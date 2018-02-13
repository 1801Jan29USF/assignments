CREATE TABLE bank_user
(
    user_id NUMBER PRIMARY KEY,
    username VARCHAR2(300) NOT NULL UNIQUE,
    password VARCHAR2(100) NOT NULL,
    balance NUMBER NOT NULL CHECK (balance >= 0)
);

CREATE TABLE bank_transaction
(
    transaction_id NUMBER PRIMARY KEY,
    user_id NUMBER REFERENCES bank_user(user_id),
    amount_deposited NUMBER NOT NULL CHECK (amount_deposited >= 0),
    amount_withdrawn NUMBER NOT NULL CHECK (amount_withdrawn >= 0),
    transaction_date TIMESTAMP
);

CREATE SEQUENCE user_id_seq;

CREATE OR REPLACE TRIGGER user_id_trig
BEFORE INSERT OR UPDATE ON bank_user
FOR EACH ROW
BEGIN 
    IF INSERTING THEN 
        SELECT user_id_seq.nextVal INTO :new.user_id FROM dual;
    ELSIF UPDATING THEN
        SELECT :old.user_id INTO :new.user_id FROM dual;
    END IF;
END;
/

CREATE SEQUENCE transaction_id_seq;

CREATE OR REPLACE TRIGGER transaction_id_trig
BEFORE INSERT OR UPDATE ON bank_transaction
FOR EACH ROW
BEGIN 
    IF INSERTING THEN 
        SELECT transaction_id_seq.nextVal INTO :new.transaction_id FROM dual;
    ELSIF UPDATING THEN
        SELECT :old.transaction_id INTO :new.transaction_id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE FUNCTION get_total_amount_of_trans
(user_id_param IN number)
RETURN number
IS
total number;
BEGIN
    SELECT SUM(amount_deposited + amount_withdrawn) INTO total FROM bank_transaction
        INNER JOIN bank_user USING(user_id) WHERE user_id = user_id_param;
    RETURN total;
END;
/

CREATE OR REPLACE PROCEDURE deposit
(user_id_param IN number, amount IN number)
IS
BEGIN
    UPDATE bank_user 
    SET balance = balance + amount
    WHERE user_id = user_id_param;
    commit;
END deposit;
/

CREATE OR REPLACE PROCEDURE withdraw
(user_id_param IN number, amount IN number)
IS
BEGIN
    UPDATE bank_user 
    SET balance = balance - amount
    WHERE user_id = user_id_param;
    commit;
END withdraw;
/













SELECT * FROM bank_user;

SELECT * FROM bank_transaction;