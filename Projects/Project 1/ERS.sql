

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER ers CASCADE;

/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER ers
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to ers;
GRANT resource to ers;
GRANT create session TO ers;
GRANT create table TO ers;
GRANT create view TO ers;



conn ers/p4ssw0rd


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE ers_reimbursement
(
    reimb_id number,
    reimb_amount number,
    reimb_submitted timestamp,
    reimb_resolved timestamp,
    reimb_description varchar2(250),
    reimb_receipt blob,
    reimb_author number,
    reimb_resolver number,
    reimb_status_id number,
    reimb_type_id number,
    constraint reinbursement_pk primary key (reimb_id),
    constraint ers_users_fk_auth foreign key (reimb_author),
    constraint ers_users_fk_reslvr foreign key (reimb_resolver),
    constraint ers_reimbursement_status_fk foreign key (reimb_status_id),
    constraint ers_reimbursement_type_fk foreign key (reimb_type_id)
    
    
    

);

CREATE TABLE ers_users
(
    ers_users_id number,
    ers_username varchar2(50),
    ers_password varchar2(50),
    user_first_name varchar2(100),
    user_last_name varchar2 (100),
    user_email varchar2 (150),
    user_role_id number,
    constraint ers_users_pk primary key (ers_users_id),
    constraint ers_users_unv1 (ers_username, user_email),
    constraint user_roles_fk foreign key (user_role_id)
    
    
);
CREATE TABLE transactions
(   
    transaction_id NUMBER NOT NULL,
    user_id NUMBER NOT NULL,
    trans varchar2(500) NOT NULL,
    CONSTRAINT transaction_id_pk PRIMARY KEY (transaction_id)
);

/*******************************************************************************
   Sequences
********************************************************************************/
--CREATE SEQUENCE user_id_seq START WITH 1;
--
--CREATE SEQUENCE transaction_id_seq START WITH 1;
--
--CREATE SEQUENCE account_id_seq START WITH 1;
/*******************************************************************************
   Triggers
********************************************************************************/

--CREATE OR REPLACE TRIGGER transaction_id_trigger
--BEFORE INSERT OR UPDATE on transactions
--FOR EACH ROW
--BEGIN
--    IF INSERTING THEN
--        SELECT transaction_id_seq.nextVal INTO :new.transaction_id FROM dual;
--    ELSIF UPDATING THEN
--        SELECT :old.transaction_id INTO :new.transaction_id FROM dual;
--    END IF;
--END;
--/

--CREATE OR REPLACE TRIGGER user_id_trigger
--BEFORE INSERT OR UPDATE on bank_users
--FOR EACH ROW
--BEGIN
--    IF INSERTING THEN
--        SELECT user_id_seq.nextVal INTO :new.user_id FROM dual;
--    ELSIF UPDATING THEN
--        SELECT :old.user_id INTO :new.user_id FROM dual;
--    END IF;
--END;
--/
--
--CREATE OR REPLACE TRIGGER account_id_trigger
--BEFORE INSERT OR UPDATE on accounts
--FOR EACH ROW
--BEGIN
--    IF INSERTING THEN
--        SELECT account_id_seq.nextVal INTO :new.account_id FROM dual;
--    ELSIF UPDATING THEN
--        SELECT :old.account_id INTO :new.account_id FROM dual;
--    END IF;
--END;
--/

/*******************************************************************************
   Procedures
********************************************************************************/

--CREATE OR REPLACE PROCEDURE create_account_for_user
--(u_id IN number,
--a_name IN varchar2,
--a_type IN varchar2,
--bal IN number)
--IS 
--BEGIN
--    INSERT INTO accounts (user_id, account_name, account_type, balance) 
--        VALUES (u_id, a_name, a_type, bal);
--    
--END create_account_for_user;
--/

/*******************************************************************************
   Functions 
********************************************************************************/
----never used in project
--CREATE OR REPLACE FUNCTION count_number_of_transactions_by_user
--(user_id_param IN number) 
--RETURN  number 
--IS 
--transaction_count number;
--begin
--    SELECT COUNT(transaction_id) INTO transaction_count FROM transactions
--    WHERE user_id  = user_id_param
--    RETURN transaction_count;
--end;
---- delimiter for plsql blocks
--/

commit;
exit;