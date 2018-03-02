CREATE USER jack_p
IDENTIFIED BY r00t4dmin
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to jack_p;
GRANT resource to jack_p;
GRANT create session TO jack_p;
GRANT create table TO jack_p;
GRANT create view TO jack_p;
conn jack_p/r00t4dmin

CREATE TABLE reimbursement
(
    reimb_id NUMBER PRIMARY KEY,
    reimb_amount NUMBER,
    reimb_submitted TIMESTAMP,
    reimb_resolved TIMESTAMP,
    reimb_description VARCHAR2(250),
    reimb_author NUMBER,
    reimb_resolver NUMBER,
    reimb_status_id NUMBER,
    reimb_type_id NUMBER,
    FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_id),
    FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_id),
    FOREIGN KEY (reimb_status_id) REFERENCES reimbursement_status (reimb_status_id),
    FOREIGN KEY (reimb_type_id) REFERENCES reimbursement_type (reimb_type_id)
);

ALTER TABLE reimbursement
ADD CONSTRAINT unique_time_amount UNIQUE (reimb_submitted, reimb_amount);

ALTER TABLE reimbursement
DROP CONSTRAINT SYS_C005374;

ALTER TABLE reimbursement 
  ADD CONSTRAINT fk_reimb_author 
  FOREIGN KEY (reimb_author) 
  REFERENCES ers_users(ers_id) 
  ON DELETE CASCADE;

CREATE TABLE ers_users
(
    ers_id NUMBER PRIMARY KEY,
    ers_username VARCHAR2(50),
    ers_password VARCHAR2(50),
    user_first_name VARCHAR2(100),
    user_last_name VARCHAR2(100),
    user_email VARCHAR2(150),
    user_role_id NUMBER,
    FOREIGN KEY (user_role_id) REFERENCES user_roles (ers_user_role_id)
);

ALTER TABLE ers_users
ADD CONSTRAINT unique_credentials UNIQUE (ers_username, ers_password);

--DELETE FROM ers_users 
--WHERE ers_id = 21;

INSERT INTO ers_users (ers_id)
VALUES (0);

CREATE TABLE reimbursement_status
(
    reimb_status_id NUMBER PRIMARY KEY,
    reimb_status VARCHAR2(10)
);

INSERT INTO reimbursement_status (reimb_status_id, reimb_status)
VALUES (0, 'Pending');
INSERT INTO reimbursement_status (reimb_status_id, reimb_status)
VALUES (1, 'Approved');
INSERT INTO reimbursement_status (reimb_status_id, reimb_status)
VALUES (2, 'Denied');

CREATE TABLE reimbursement_type
(
    reimb_type_id NUMBER PRIMARY KEY,
    reimb_type VARCHAR2(10)
);

INSERT INTO reimbursement_type (reimb_type_id, reimb_type)
VALUES (0, 'Lodging');
INSERT INTO reimbursement_type (reimb_type_id, reimb_type)
VALUES (1, 'Travel');
INSERT INTO reimbursement_type (reimb_type_id, reimb_type)
VALUES (2, 'Food');
INSERT INTO reimbursement_type (reimb_type_id, reimb_type)
VALUES (3, 'Other');

CREATE TABLE user_roles
(
    ers_user_role_id NUMBER PRIMARY KEY,
    user_role VARCHAR2(10)
);

INSERT INTO user_roles (ers_user_role_id, user_role)
VALUES (1, 'Employee');
INSERT INTO user_roles (ers_user_role_id, user_role)
VALUES (2, 'Manager');

--DROP TABLE reimbursement;
--DROP TABLE ers_users;
--DROP TABLE reimbursement_status;
--DROP TABLE reimbursement_type;
--DROP TABLE user_roles;

CREATE SEQUENCE user_sequence START WITH 1;
DROP SEQUENCE user_sequence;
DROP PROCEDURE new_user;



CREATE OR REPLACE PROCEDURE new_user
(user_name IN varchar2, pass_word IN varchar2, first_name IN varchar2,
    last_name IN varchar2, email IN varchar2, user_rolename IN varchar2)
AS
roleid NUMBER;
BEGIN
    SELECT ers_user_role_id INTO roleid FROM user_roles
        WHERE user_rolename = user_role; 
    INSERT INTO ers_users (ers_username, ers_password, 
        user_first_name, user_last_name, user_email, user_role_id, ers_id)
    VALUES (user_name, pass_word, first_name, last_name, 
        email, roleid, user_sequence.NEXTVAL);
END new_user;
/



CREATE SEQUENCE reimb_sequence;

CREATE OR REPLACE PROCEDURE new_reimb
(amount IN NUMBER, description IN VARCHAR2, r_type IN VARCHAR2,
    sub_username IN VARCHAR2, sub_password IN VARCHAR2)
AS
userid NUMBER;
thistime TIMESTAMP;
typeid NUMBER;
BEGIN
    SELECT ers_id INTO userid FROM ers_users
        WHERE ers_username = sub_username AND ers_password = sub_password;
    SELECT CURRENT_TIMESTAMP INTO thistime FROM DUAL;
    SELECT reimb_type_id INTO typeid FROM reimbursement_type
    WHERE reimb_type = r_type;
    INSERT INTO reimbursement (reimb_id, reimb_amount, reimb_submitted,
        reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
    VALUES (reimb_sequence.NEXTVAL, amount, thistime, description, userid,
            0, 0, typeid);
END new_reimb;
/

CREATE OR REPLACE PROCEDURE get_reimbursement_data
(username IN varchar2, pass IN VARCHAR2, results OUT sys_refcursor)
IS
roleid NUMBER;
userid NUMBER;
BEGIN
    SELECT ers_id INTO userid FROM ers_users
        WHERE ers_username = username AND ers_password = pass;
    SELECT user_role_id INTO roleid FROM ers_users
        WHERE ers_id = userid;
    IF roleid = 2 THEN
        OPEN results FOR SELECT reimb_id, reimb_amount, reimb_submitted, reimb_resolved,
            reimb_description, ers_username, reimb_type, reimb_status FROM reimbursement
            INNER JOIN ers_users ON (reimbursement.reimb_author = ers_users.ers_id)
            INNER JOIN reimbursement_status ON (reimbursement.reimb_status_id = reimbursement_status.reimb_status_id)
            INNER JOIN reimbursement_type ON (reimbursement.reimb_type_id = reimbursement_type.reimb_type_id);
    ELSIF roleid = 1 THEN
        OPEN results FOR SELECT reimb_id, reimb_amount, reimb_submitted, reimb_resolved,
            reimb_description, ers_username, reimb_type, reimb_status FROM reimbursement
            INNER JOIN ers_users ON (reimbursement.reimb_author = ers_users.ers_id)
            INNER JOIN reimbursement_status ON (reimbursement.reimb_status_id = reimbursement_status.reimb_status_id)
            INNER JOIN reimbursement_type ON (reimbursement.reimb_type_id = reimbursement_type.reimb_type_id)
            WHERE reimb_author = userid;
    END IF;
END get_reimbursement_data;
/


CREATE OR REPLACE PROCEDURE resolve_reimb
(user_name IN varchar2, pass_word IN varchar2, reimbid IN NUMBER,
    new_status IN varchar2, confirmation OUT varchar2)
AS
statusid NUMBER;
roleid NUMBER;
userid NUMBER;
authorid NUMBER;
resolved TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO resolved FROM DUAL;
    SELECT reimb_author INTO authorid FROM reimbursement
        WHERE reimb_id = reimbid;
    SELECT reimb_status_id INTO statusid FROM reimbursement_status
        WHERE reimb_status = new_status;
    SELECT ers_id INTO userid FROM ers_users
        WHERE ers_username = user_name AND ers_password = pass_word;
    SELECT user_role_id INTO roleid FROM ers_users
        WHERE ers_id = userid;
    SELECT 'f' INTO confirmation FROM DUAL;
    IF roleid = 2 THEN
        IF authorid <> userid THEN
            UPDATE reimbursement
                SET reimb_status_id = statusid, reimb_resolver = userid, reimb_resolved = resolved
                WHERE reimb_id = reimbid;
            SELECT 't' INTO confirmation FROM DUAL;
        END IF;
    END IF;
END resolve_reimb;
/

--DROP FUNCTION get_reimbursement_data;


