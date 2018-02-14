CREATE TABLE bank_user
(
User_id NUMBER,
Username varchar(30) NOT NULL UNIQUE,
Password varchar(40) NOT NULL,
Balance NUMBER

);


CREATE TABLE user_transaction 
(
Tran_id NUMBER,
Username REFERENCES bank_user,
Balance NUMBER,
Time systime
);


create or replace PROCEDURE create_bank_user
(USER_ID IN NUMBER, USERNAME IN VARCHAR2, PASSWORD IN VARCHAR2, BALANCE IN NUMBER)
IS
BEGIN 
INSERT INTO BANK_USER (USER_ID, USERNAME, PASSWORD, BALANCE) 
VALUES (USER_ID, USERNAME, PASSWORD, BALANCE);
END create_bank_user;

create or replace TRIGGER tran_id_trig
BEFORE INSERT OR UPDATE ON user_transaction
FOR EACH ROW
BEGIN 
   IF INSERTING THEN
    SELECT tran_id_seq.nextVal INTO :new.tran_id FROM dual;
    ELSIF UPDATING THEN
    SELECT :old.tran_id INTO :new.tran_id FROM dual;
    END IF;
    END;
    
create or replace TRIGGER tran_trig
AFTER UPDATE ON bank_user
FOR EACH ROW
BEGIN 
   INSERT INTO user_transaction (tran_id, username, balance, time)
   VALUES(tran_id_seq.nextVal, :new.username, :new.balance, systimestamp); 
   END;
   
CREATE SEQUENCE bank_user_id_seq START WITH 1;
CREATE SEQUENCE tran_id_seq START WITH 1;