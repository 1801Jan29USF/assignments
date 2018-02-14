DROP USER bankingApp CASCADE;

CREATE USER bankingApp
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;
GRANT connect to bankingApp;
GRANT resource to bankingApp;
GRANT create session TO bankingApp;
GRANT create table TO bankingApp;
GRANT create view TO bankingApp;
conn bankingApp/p4ssw0rd

CREATE TABLE user_table (
    user_id number PRIMARY KEY,
    username varchar2(40),
    user_pass varchar2(40),
    balance number(31, 2) CHECK(balance > 0)
);
CREATE TABLE audit_log (
    audit_id number PRIMARY KEY,
    old_user_id number,
    new_user_id number,
    old_username varchar2(40),
    new_username varchar2(40),
    old_password varchar2(40),
    new_password varchar2(40),
    old_balance number(12, 2),
    new_balance number(12, 2),
    audit_time timestamp
);

CREATE SEQUENCE user_id_seq;
CREATE OR REPLACE TRIGGER user_id_trig BEFORE INSERT OR UPDATE on user_table
    FOR EACH ROW
    BEGIN
        IF INSERTING THEN
            SELECT user_id_seq.nextVal INTO :new.user_id FROM dual;
        ELSIF UPDATING THEN
            SELECT :old.user_id INTO :new.user_id FROM dual;
        END IF;
    END;
/

CREATE SEQUENCE audit_user_seq;
CREATE OR REPLACE TRIGGER audit_user_trig AFTER INSERT OR UPDATE OR DELETE ON user_table
    FOR EACH ROW
    BEGIN
        INSERT INTO audit_log (audit_id, old_user_id, new_user_id, old_username, new_username, old_password,
                    new_password, old_balance, new_balance, audit_time)
                VALUES (audit_user_seq.nextVal, :old.user_id, :new.user_id, :old.username, :new.username, :old.user_pass, 
                    :new.user_pass, :old.balance, :new.balance, systimestamp);
    END;
/
    
CREATE OR REPLACE PROCEDURE get_user_history (username_p IN varchar2, results OUT sys_refcursor)
    IS
    BEGIN
        OPEN results FOR SELECT * FROM audit_log WHERE (old_username = username_p) OR (new_username = username_p) ORDER BY audit_id ASC;
    END get_user_history;
/

commit;