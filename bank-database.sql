DROP USER bank CASCADE;


CREATE USER bank
IDENTIFIED BY pass
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to bank;
GRANT resource to bank;
GRANT create session TO bank;
GRANT create table TO bank;
GRANT create view TO bank;

conn bank/pass

create table bank_user
(
    user_id number(10) primary key,
    username varchar2(15) not null,
    pass varchar2(15) not null,
    balance number(20,2) not null check ( balance >=0)
);

create table bank_transaction
(
    transaction_id number(10) primary key,
    amount number(20,2) not null,
    transaction_date timestamp not null,
    user_id number(10) not null
);

create sequence user_id_seq;
create sequence transaction_id_seq;

--create trigger to generate user id;
CREATE OR REPLACE TRIGGER user_id_trigger
BEFORE INSERT OR UPDATE ON bank_user
FOR EACH ROW 
BEGIN
    IF inserting THEN
        SELECT user_id_seq.NEXTVAL INTO :NEW.user_id FROM dual;
    ELSIF updating THEN 
        SELECT :OLD.user_id INTO :NEW.user_id FROM dual;
    END IF;
END;
/
--create trigger to generate transaction id;
CREATE OR REPLACE TRIGGER transaction_id_trigger
BEFORE INSERT OR UPDATE ON bank_transaction
FOR EACH ROW 
BEGIN
    IF inserting THEN
        SELECT transaction_id_seq.NEXTVAL INTO :NEW.transaction_id FROM dual;
    ELSIF updating THEN 
        SELECT :OLD.transaction_id INTO :NEW.transaction_id FROM dual;
    END IF;
END;
/
--create trigger to add transactions
CREATE OR REPLACE TRIGGER transaction_trigger
AFTER UPDATE ON bank_user
FOR EACH ROW 
BEGIN
        INSERT INTO bank_transaction (amount, transaction_date, user_id) 
            VALUES (:NEW.balance - :OLD.balance, CURRENT_TIMESTAMP, :OLD.user_id);
END;
/
-- get an ordered table of transactions
CREATE OR REPLACE FUNCTION get_transactions
(username_param IN varchar2)
RETURN sys_refcursor
IS
--define additional variables if needed
results sys_refcursor;
--actual function
BEGIN
    OPEN results FOR SELECT amount, transaction_date
        FROM bank_transaction
        WHERE user_id IN 
        (SELECT user_id FROM bank_user WHERE username = username_param)
        ORDER BY transaction_date desc;
    RETURN results;
END;
/

--testing

insert into bank_user (username, pass, balance) Values ('matt','pass', 600);
update bank_user set balance = 400 where username = 'matt';
select * from BANK_USER;
select * from BANK_TRANSACTION;
SELECT get_transactions('matt') from dual;