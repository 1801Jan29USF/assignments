/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER bankapp CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER bankapp
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bankapp;
GRANT resource to bankapp;
GRANT create session TO bankapp;
GRANT create table TO bankapp;
GRANT create view TO bankapp;



conn bankapp/p4ssw0rd


/*******************************************************************************
   Create Tables
********************************************************************************/

CREATE TABLE users
(
    UserId NUMBER NOT NULL,
    Username VARCHAR2(160) NOT NULL,
    Pasword VARCHAR2(160) NOT NULL,
    balance NUMBER ,
    CONSTRAINT PK_Users PRIMARY KEY  (UserId)
);

CREATE TABLE Transactions
(
    TransactionId NUMBER NOT NULL,
    UserId NUMBER NOT NULL,
    amntDeposit NUMBER,
    amntWithdraw NUMBER,    
    Transaction_date timestamp,
    CONSTRAINT PK_Transactions PRIMARY KEY  (TransactionId),
        CONSTRAINT FK_UserTransaction FOREIGN KEY (UserId)
    REFERENCES Users(UserId)
    
);
     
    

--********************************************************************************/
drop table transactions;
drop table users;
delete  from users;

INSERT INTO Users (UserId, Username, Pasword, Balance) 
    VALUES (1, 'Mike', 'Mike',600);
INSERT INTO Users (UserId, Username, Pasword,balance)  
    VALUES (2, 'Larry', 'Larry',200);
INSERT INTO Users (UserId, Username, Pasword,balance)  
    VALUES (3, 'Tim', 'Tim',1000);
    
    commit;
    
  SELECT * FROM users;
  SELECT * FROM users;
  
  INSERT INTO TRANSACTIONS (TransactionId, UserId , amntDeposit, accntBalance, Transaction_date)
    VALUES(1, 3, 500, 500, CURRENT_TIMESTAMP);
     INSERT INTO TRANSACTIONS (TransactionId, UserId , amntDeposit, accntBalance, Transaction_date)
    VALUES(2, 1, 500, 500, CURRENT_TIMESTAMP);
     INSERT INTO TRANSACTIONS (TransactionId, UserId , amntDeposit, accntBalance, Transaction_date)
    VALUES(3, 2, 500, 500, CURRENT_TIMESTAMP);
         INSERT INTO TRANSACTIONS (TransactionId, UserId , amntWithdraw, accntBalance, Transaction_date)
    VALUES(4, 2, 500, 0, CURRENT_TIMESTAMP);
    
    
      SELECT * FROM transactions;

    
---------------------Functions
    
CREATE OR REPLACE FUNCTION rich_users
RETURN SYS_REFCURSOR
IS 
users SYS_REFCURSOR;
BEGIN
     OPEN users 
     FOR SELECT userid
         FROM users
         WHERE balance >= (10000);
         RETURN users;
END;
/ 
-----------------------------------------------------------
--sequence and triggers

CREATE SEQUENCE  user_id_sequence START with 10;

CREATE OR REPLACE TRIGGER user_id_trig
BEFORE INSERT OR UPDATE ON users
FOR EACH ROW
BEGIN
    IF INSERTING THEN 
        SELECT user_id_sequence.nextVal INTO  :new.userid FROM dual;
        
    ELSIF UPDATING THEN
        SELECT :old.userid INTO :new.userid from dual;
    END IF;
END;
/

UPDATE users SET userid = 1;
-----------------------------------------------------
CREATE SEQUENCE  Transactions_id_sequence START with 10;

CREATE OR REPLACE TRIGGER Transaction_id_trig
BEFORE INSERT OR UPDATE ON transactions
FOR EACH ROW
BEGIN
    IF INSERTING THEN 
        SELECT Transactions_id_sequence.nextVal INTO  :new.TransactionId FROM dual;
        
    ELSIF UPDATING THEN
        SELECT :old.TransactionId INTO :new.TransactionId from dual;
    END IF;
END;
/

UPDATE transactions SET TransactionId = 2;
--------------------------------------------------

-- transaction 
CREATE OR REPLACE PROCEDURE insert_user_transaction
(user_id IN number, user_name IN VARCHAR2, amnt_Deposit IN NUMBER, amnt_Withdraw IN NUMBER, accnt_Balance in NUMBER, Transactiondate IN SYSTIMESTAMP )
IS
BEGIN
    INSERT INTO Users(UserId, Username, amntDeposit, amntWithdraw ,accntBalance ,Transaction_date)
        VALUES(user_id, user_name, amnt_Deposit, amnt_Withdraw, accnt_Balance, Transactiondate);
END insert_user_transaction;
/


-- a stored procedure that returns the username and password of a user.
CREATE OR REPLACE PROCEDURE find_user_password
(user_id IN number, pass_word OUT sys_refcursor)
IS 
BEGIN
OPEN pass_word 
FOR SELECT username, Pasword 
FROM users
WHERE users.userid = user_id;
END find_user_password;
/

--------------------------------------------------------------------





  
  
  
  
  