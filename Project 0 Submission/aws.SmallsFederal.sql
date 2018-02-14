/*******************************************************************************
   Smalls Federal Database - Version 1.4
   Script: Smalls_Federal_Oracle.sql
   Description: Creates and populates the Smalls Federal database.
   DB Server: Oracle
   Author: Brandon Smalls
********************************************************************************/
/*******************************************************************************
  Create database
********************************************************************************/
CREATE USER Smalls
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;
GRANT connect to Smalls;
GRANT resource to Smalls;
GRANT create session TO Smalls;
GRANT create table TO Smalls;
GRANT create view TO Smalls;
conn Smalls/p4ssw0rd
/*******************************************************************************
   Create Tables
********************************************************************************/
DROP TABLE user_transaction;
DROP TABLE acct_user;
DROP SEQUENCE user_id_seq;
CREATE TABLE acct_user
(
    user_id NUMBER PRIMARY KEY,
    user_name VARCHAR2(30) NOT NULL UNIQUE,
    password VARCHAR(20),
    balance number DEFAULT(0.0)
);


CREATE TABLE user_transaction
(
    trans_id number PRIMARY KEY,
    amount number,
    time TIMESTAMP,
    user_id REFERENCES acct_user(user_id)
);

CREATE SEQUENCE user_id_seq START WITH 1;
CREATE SEQUENCE trans_id_seq START WITH 1;

CREATE OR REPLACE TRIGGER trans_id_trig
BEFORE INSERT OR UPDATE ON user_transaction
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        SELECT trans_id_seq.nextVal INTO :new.trans_id FROM dual;
    ELSIF UPDATING THEN
        SELECT :old.trans_id INTO :new.trans_id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER user_id_trig
BEFORE INSERT OR UPDATE ON acct_user
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        SELECT user_id_seq.nextVal INTO :new.user_id FROM dual;
    ELSIF UPDATING THEN
        SELECT :old.user_id INTO :new.user_id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER pop_trans
AFTER UPDATE ON acct_user
FOR EACH ROW
BEGIN
   INSERT INTO user_transaction
   (trans_id, amount, time, user_id) 
   VALUES(trans_id_seq.nextVal,:new.balance, systimestamp, :new.user_id);
END;
/

INSERT INTO acct_user(user_name, password, balance) VALUES('Brandon', 'b123', 500);
INSERT INTO acct_user(user_name, password, balance) VALUES('Miguel', 'm123', 400);
INSERT INTO acct_user(user_name, password, balance) VALUES('Jack', 'j123', 300);

COMMIT;

SELECT * FROM acct_user;
SELECT * FROM user_transaction;

SELECT * FROM acct_user WHERE user_name= 'Brandon' AND password= 'b123';
DELETE FROM acct_user WHERE balance = 0;

CREATE OR REPLACE PROCEDURE pop_the_trans
(u_id IN number,
action IN varcahr2,
amount IN number,
generated_id OUt number)
AS
BEGIN
    INSERT INTO user_transaction(action, amount, u_id)
        VALUES(action, amount, user_id)
    RETURNING trans_id INTO generated_id;
END pop_tran;

DROP PROCEDURE pop_the_trans;
DROP TRIGGER pop_trans;
        

