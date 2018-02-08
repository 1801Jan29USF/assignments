-- stored procedure to find transactions belonging to a specific user
CREATE OR REPLACE PROCEDURE find_user_transactions
(user_id IN number, results OUT sys_refcursor)
IS
BEGIN
    OPEN results FOR SELECT user_id, transaction_id, user_transaction FROM BankTransactions
        INNER JOIN UserAccount USING(user_id) WHERE user_id = user_id;
END find_user_transactions;
/

SET SERVEROUTPUT ON;
DECLARE
    results sys_refcursor;
    user_id number;
    user_transaction number(1,0);
BEGIN
    find_user_transactions(1, results);
    LOOP
        FETCH results INTO user_id, transaction_id, user_transaction;
        EXIT WHEN results%notfound;
        dbms_output.put_line(user_id || ' | ' || transaction_id || ' | ' || user_transaction);
    END LOOP;
END;


--/-- function to get number of cards in a given set
--CREATE OR REPLACE FUNCTION get_user_transactions
--(user_id_param IN number) -- parameters
--RETURN number -- return type specified
--IS -- or AS they are synonymous 
---- we can define addional variables
--card_count number;
--begin
--    SELECT COUNT(flashcard_id) INTO card_count FROM flashcard 
--        INNER JOIN flashcard_cardset USING(flashcard_id) WHERE set_id = set_id_param;
--    RETURN card_count;
--end;
---- delimiter for plsql blocks
--/
--
---- test out the function
--SELECT get_number_cards_in_set(1) FROM dual;
--
--
--
--
--
--
--
----create the sequece for our account ids
--CREATE SEQUENCE user_id_seq START WITH 6;
--
----create trigger to generate the id inserted and prevent ids from being updated
--CREATE OR REPLACE TRIGGER user_id_trig
--BEFORE INSERT OR UPDATE ON bankuser
--FOR EACH ROW
--BEGIN  
--    IF INSERTING THEN
--        SELECT user_id_seq.nextVal INTO :new.user_id FROM dual;
--    ELSIF UPDATING THEN
--        SELECT : old.user_id INTO :new.user_id FROM dual;
--    END IF;
--END;
--/
--
---- stored procedure
--CREATE OR REPLACE PROCEDURE create_bank_user
--(name_in IN varchar2,
--pass_in IN varchar2,
--checking_in IN Number,
--savings_in IN Number,
--generated_id OUT number)
--IS
--BEGIN
--    INSERT INTO UserAccount (username, pass, checking, savings)
--        VALUES (name_in, pass, checking_in, savings_in)
--    RETURNING user_id INTO generated_id; --get the generated id
--END create_bank_user;
--/
--
--SET SERVEROUTPUT ON
--DECLARE 
--    gen_id number;
--BEGIN
--    create_bank_user('ianperfitt', 'ianperfitt', 0, 0, gen_id);
--    dbms_output.put_line(gen_id);
--END;
--/
--
----SELECT *FROM flashcard;
----SELECT * FROM flashcard_cardset;
--
----create table for audit logs
--CREATE TABLE audit_user_account
--(
--    audit_id number PRIMARY KEY, 
--    old_id number,
--    new_id number,
--    old_username varchar2(200),
--    new_username varchar2(200),
--    old_password varchar2(500),
--    new_password varchar2(500),
--    audit_time timestamp
--);
--
--CREATE SEQUENCE audit_user_seq;
--CREATE OR REPLACE TRIGGER audit_user_trig
--AFTER UPDATE OR INSERT OR DELETE ON bankuser
--FOR EACH ROW
--BEGIN
--    INSERT INTO audit_user_account
--        (audit_id, old_id, new_id, old_username, new_username,
--        old_password, new_password, audit_time)
--        VALUES (audit_user_seq.nextVal, :old.user_id, :new.user_id,
--        :old.username, :new.username, :old.password, :new.password, systimestamp);
--END;
--/
--
--    
--    