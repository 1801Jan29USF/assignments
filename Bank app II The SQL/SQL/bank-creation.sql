/*******************************************************************************
   Bank Database - Version 1.0
   Script: bank-creation.sql
   Description: Creates and populates the Bank database.
   DB Server: Oracle
   Author: Bobby McGetrick
********************************************************************************/

/*******************************************************************************
   Drop database if it exists
***x*****************************************************************************/
DROP USER bank CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER bank
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bank;
GRANT resource to bank;
GRANT create session TO bank;
GRANT create table TO bank;
GRANT create view TO bank;
GRANT create job TO bank;



conn bank/p4ssw0rd


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE users
(
    user_id NUMBER PRIMARY KEY,
    user_name VARCHAR2(50) UNIQUE NOT NULL,
    password_id NUMBER
);

CREATE TABLE passwords
(
    password_id NUMBER PRIMARY KEY,
    pass_word VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE transactions
(
    transaction_id NUMBER PRIMARY KEY,
    user_id NUMBER,
    account_id NUMBER,
    amount_deposited NUMBER NOT NULL,
    transaction_date TIMESTAMP NOT NULL
);

CREATE TABLE accounts
(
    account_id NUMBER PRIMARY KEY,
    account_name_id NUMBER,
    balance NUMBER CHECK (balance >= 0)
);

CREATE TABLE account_names
(
    account_name_id NUMBER PRIMARY KEY,
    account_name VARCHAR2(80) UNIQUE NOT NULL
);

/*******************************************************************************
   Create Junction Tables
********************************************************************************/
CREATE TABLE user_to_account
(
    user_id NUMBER,
    account_id NUMBER,
    CONSTRAINT pk_composite_u2a_key PRIMARY KEY (user_id, account_id)
);

/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE users ADD CONSTRAINT fk_password_id_cascade
    FOREIGN KEY (password_id) REFERENCES passwords (password_id) ON DELETE CASCADE;

ALTER TABLE transactions ADD CONSTRAINT fk_user_id_cascade
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE;
    
ALTER TABLE transactions ADD CONSTRAINT fk_account_id_cascade
    FOREIGN KEY (account_id) REFERENCES accounts (account_id) ON DELETE CASCADE;
    
ALTER TABLE accounts ADD CONSTRAINT fk_account_name_id_cascade
    FOREIGN KEY (account_name_id) REFERENCES account_names (account_name_id) ON DELETE CASCADE;
    
ALTER TABLE user_to_account ADD CONSTRAINT fk_u2a_user_id_cascade
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE;
    
ALTER TABLE user_to_account ADD CONSTRAINT fk_u2a_account_id_cascade
    FOREIGN KEY (account_id) REFERENCES accounts (account_id) ON DELETE CASCADE;
    
/*******************************************************************************
   Create Sequences
********************************************************************************/
CREATE SEQUENCE user_id_seq;

CREATE SEQUENCE transaction_id_seq;

CREATE SEQUENCE account_id_seq;

CREATE SEQUENCE account_name_id_seq;

CREATE SEQUENCE password_id_seq;

/*******************************************************************************
   Create Triggers
********************************************************************************/
CREATE OR REPLACE TRIGGER user_id_trig
    BEFORE INSERT OR UPDATE ON users
    FOR EACH ROW
    BEGIN
        IF INSERTING THEN
            SELECT user_id_seq.nextVal INTO :new.user_id FROM DUAL;
        ELSIF UPDATING THEN
            SELECT :old.user_id INTO :new.user_id FROM DUAL;
        END IF;
    END;
    /

CREATE OR REPLACE TRIGGER transaction_id_trig
    BEFORE INSERT OR UPDATE ON transactions
    FOR EACH ROW
    BEGIN
        IF INSERTING THEN
            SELECT transaction_id_seq.nextVal INTO :new.transaction_id FROM DUAL;
        ELSIF UPDATING THEN
            SELECT :old.transaction_id INTO :new.transaction_id FROM DUAL;
        END IF;
    END;
    /

CREATE OR REPLACE TRIGGER account_id_trig
    BEFORE INSERT OR UPDATE ON accounts
    FOR EACH ROW
    BEGIN
        IF INSERTING THEN
            SELECT account_id_seq.nextVal INTO :new.account_id FROM DUAL;
        ELSIF UPDATING THEN
            SELECT :old.account_id INTO :new.account_id FROM DUAL;
        END IF;
    END;
    /
    
CREATE OR REPLACE TRIGGER account_name_id_trig
    BEFORE INSERT OR UPDATE ON account_names
    FOR EACH ROW
    BEGIN
        IF INSERTING THEN
            SELECT account_name_id_seq.nextVal INTO :new.account_name_id FROM DUAL;
        ELSIF UPDATING THEN
            SELECT :old.account_name_id INTO :new.account_name_id FROM DUAL;
        END IF;
    END;
    /

CREATE OR REPLACE TRIGGER password_id_trig
    BEFORE INSERT OR UPDATE ON passwords
    FOR EACH ROW
    BEGIN
        IF INSERTING THEN
            SELECT password_id_seq.nextVal INTO :new.password_id FROM DUAL;
        ELSIF UPDATING THEN
            SELECT :old.password_id INTO :new.password_id FROM DUAL;
        END IF;
    END;
    /

/*******************************************************************************
   Create Stored Procedures
********************************************************************************/
CREATE OR REPLACE PROCEDURE interest_procedure
IS BEGIN
    UPDATE accounts SET balance =  balance + balance*0.01;
END;
/

/*******************************************************************************
   Create Functions
********************************************************************************/

/*******************************************************************************
   Create Jobs
********************************************************************************/
BEGIN
DBMS_SCHEDULER.CREATE_JOB (
  job_type     => 'STORED_PROCEDURE',  
  job_name     => 'interest_update_job',
  job_action    => 'interest_procedure',
  start_date    => SYSTIMESTAMP,
  repeat_interval  => 'FREQ=MINUTELY; INTERVAL=1',
  end_date     => SYSTIMESTAMP + INTERVAL '200' YEAR,
  --enabled     => TRUE,
  comments     => 'Call stored procedure to update account balances with their interest every minute');
END;
/

EXEC dbms_scheduler.ENABLE('interest_update_job');

/*******************************************************************************
   Commit changes and exit
********************************************************************************/
COMMIT;
EXIT;



















