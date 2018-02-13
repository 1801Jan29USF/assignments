CREATE USER jackman
IDENTIFIED BY rascaloreo10
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;
GRANT connect to jackman;
GRANT resource to jackman;
GRANT create session TO jackman;
GRANT create table TO jackman;
GRANT create view TO jackman;
conn jackman/rascaloreo10

/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE bank_user
( 
    username VARCHAR2(30) UNIQUE NOT NULL PRIMARY KEY,
    password VARCHAR2(20) NOT NULL,
    balance number NOT NULL
);

CREATE TABLE transactions
(
    username VARCHAR2(30),
    FOREIGN KEY (username) REFERENCES bank_user(username),
    amount NUMBER NOT NULL,
    transaction_timestamp timestamp,
    PRIMARY KEY (username, transaction_timestamp)
);

CREATE OR REPLACE FUNCTION find_transactions_by_user
(username IN varchar2)
RETURN sys_refcursor
IS
results sys_refcursor;
BEGIN
    OPEN results FOR SELECT amount, transaction_timestamp FROM transactions 
        WHERE username = username;
    RETURN results;
END;
/

CREATE OR REPLACE FUNCTION get_user
(username IN VARCHAR2, password IN VARCHAR2)
RETURN sys_refcursor
AS
results sys_refcursor;
BEGIN
    OPEN results FOR
    SELECT * FROM bank_user
    WHERE username = username
    AND password = password;
    RETURN results;
END;
/

CREATE OR REPLACE FUNCTION withdraw
(user_name IN VARCHAR2, amount IN NUMBER)
RETURN varchar2
AS
holder NUMBER;
BEGIN
    SELECT balance INTO holder FROM bank_user
    WHERE username = user_name;
    IF amount < holder THEN
        UPDATE bank_user
        SET balance = (balance - amount);
        RETURN 'f';
    ELSE
        RETURN 't';
    END IF;
END;
/

CREATE OR REPLACE FUNCTION login
(user_name IN VARCHAR2, password IN varchar2)
RETURN varchar2
AS
holder varchar2(20);
BEGIN
    SELECT password INTO holder FROM bank_user
    WHERE username = user_name;
    IF holder = password THEN
        RETURN 't';
    ELSE
        RETURN 'f';
    END IF;
END;
/

CREATE OR REPLACE PROCEDURE add_user
(user_name IN varchar2, pass_word IN varchar2)
AS
BEGIN
    INSERT INTO bank_user (username, password, balance)
    VALUES (user_name, pass_word, 0.00);
END add_user;
/

CREATE OR REPLACE PROCEDURE deposit
(user_name IN VARCHAR2, amount IN NUMBER)
AS
BEGIN
    UPDATE bank_user
    SET balance = (balance + amount)
    WHERE username = user_name;
END deposit;
/

CREATE OR REPLACE TRIGGER bank_trans_trig
    AFTER UPDATE ON bank_user
    FOR EACH ROW
    BEGIN
        INSERT INTO transactions (username, amount, transaction_timestamp)
        VALUES (:new.username, (:new.balance - :old.balance), systimestamp); 
    END;
/
