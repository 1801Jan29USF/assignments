-- Ben Zahler
-- Revature Associate
-- Homework Assignment 2
-- The SQL Workbook

-- Task – Open the Chinook_Oracle.sql file and execute the scripts within.
SET SERVEROUTPUT ON
DECLARE
  task VARCHAR2 (10) := 'Done!';
BEGIN
  DBMS_OUTPUT.put_line (task);
END;
/

-- Task – Select all records from the Employee table.
SELECT * FROM employee;

-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee WHERE lastname = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer ORDER BY city ASC;

-- Task – Insert two new records into Genre table
INSERT INTO genre(genreid, name) VALUES (26, 'newgenre1');
INSERT INTO genre(genreid, name) VALUES (27, 'newgenre2');

-- Task – Insert two new records into Employee table
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, 
    city, state, country, postalcode, phone, fax, email)
    VALUES(25, 'a', 'b', 'c', 1, TO_DATE('1980/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l');
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, 
    city, state, country, postalcode, phone, fax, email)
    VALUES(26, 'z', 'y', 'w', 1, TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'), 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l');
-- This was obnoxious

-- Task – Insert two new records into Customer table
-- whhhyyyyyyyyyy
INSERT INTO customer(customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
    VALUES(1000, 'l', 'o', 's', 'e', 'r', 'c', 'u', 's', 't', 'o', 'm', 1);
INSERT INTO customer(customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
    VALUES(1001, 'e', 'r', 's', 'e', 'n', 'd', 'h', 'e', 'l', 'p', 'x', 1);
    
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
-- Complete name change eh?

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 20;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE('2003/06/01 00:00:00', 'yyyy/mm/dd hh24:mi:ss') AND TO_DATE('2004/03/01 00:00:00', 'yyyy/mm/dd hh24:mi:ss');

-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';


-- It said to make a function for each....... idk why. But I did
-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_current_time  
RETURN date
IS 
datevar date;
BEGIN
    SELECT SYSDATE INTO datevar FROM DUAL;
    RETURN datevar;
END;
/
SELECT get_current_time FROM DUAL;

-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_media_length  
RETURN number
IS 
medialength number;
BEGIN
    SELECT MAX(LENGTH(name)) INTO medialength FROM mediatype;
    RETURN medialength;
END;
/
SELECT get_media_length FROM DUAL;

-- Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_avg_invoice_total  
RETURN number
IS 
avgtotal number;
BEGIN
    SELECT AVG(total) INTO avgtotal FROM invoice;
    RETURN avgtotal;
END;
/
SELECT get_avg_invoice_total FROM DUAL;

-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_highest_cost_track
RETURN number
IS 
highest_cost number;
BEGIN
    SELECT MAX(unitprice) INTO highest_cost FROM track;
    RETURN highest_cost;
END;
/
SELECT get_highest_cost_track FROM DUAL;

-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_avg_price_invoiceline
RETURN number
IS 
avg_price number;
BEGIN
    SELECT AVG(unitprice) INTO avg_price FROM invoiceline;
    RETURN avg_price;
END;
/
SELECT get_avg_price_invoiceline FROM DUAL;

-- Task – Create a function that returns all employees who are born after 1968.
-- Gr. You're getting a regular statement for this one.
-- I wrote out the function using this but didn't understand how to call it properly
SELECT * FROM employee WHERE birthdate > TO_DATE('1968-01-01', 'YYYY-DD-MM');

-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE find_first_and_last
(results OUT sys_refcursor)
IS
BEGIN
    OPEN results FOR SELECT firstname, lastname FROM employee;
END find_first_and_last;
/
SET SERVEROUTPUT ON;
DECLARE
    results sys_refcursor;
    firstname varchar2(20 BYTE);
    lastname varchar2(20 BYTE);
BEGIN
    find_first_and_last(results);
    LOOP
        FETCH results INTO firstname, lastname;
        EXIT WHEN results%notfound;
        dbms_output.put_line(firstname || ' | ' || lastname);
    END LOOP;
END;
/

-- Task – Create a stored procedure that updates the personal information of an employee.
-- I don't understand this question
CREATE OR REPLACE PROCEDURE update_personal_info
IS
BEGIN
    UPDATE employee SET lastname = 'd' WHERE employeeid = 1;
END update_personal_info;
/
BEGIN
    update_personal_info;
END;
/

-- Task – Create a stored procedure that returns the managers of an employee.
-- Select the first name of the employee where the reportsto of the given employee matches the id of the name you want.

-- Thats the best I got I think. It tells me it needs an INTO statement?
-- (later) I got my procedure to compile at least...

-- Even later. Don't worry, I made it work. And actually learned what I'm doing
CREATE OR REPLACE PROCEDURE find_managers (employee_name IN varchar2, manager_name OUT varchar2)
IS
BEGIN
    SELECT firstname INTO manager_name FROM employee WHERE (SELECT reportsto FROM employee WHERE firstname = employee_name) = employeeid;
END find_managers;
/
SET SERVEROUTPUT ON
DECLARE
    manager_name varchar2(200);
BEGIN
    find_managers('Robert', manager_name);
    dbms_output.put_line(manager_name);
END;
/
    


-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE find_name_and_company (customer_firstname IN varchar2, customer_lastname IN varchar2, c_name OUT varchar2, c_company OUT varchar2)
    IS
    BEGIN
        SELECT firstname, company INTO c_name, c_company FROM customer WHERE firstname = customer_firstname AND lastname = customer_lastname;
    END find_name_and_company;
/
SET SERVEROUTPUT ON;
DECLARE
    c_name varchar2(200);
    c_company varchar2(200);
BEGIN
    find_name_and_company('Eduardo', 'Martins', c_name, c_company);
    dbms_output.put_line(c_name || ' | ' || c_company);
END;
/

-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
-- soo we just delete the invoice related to that id
    DELETE FROM invoice WHERE invoiceid = 1;    
    
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
-- Never said the procedure I put it in had to be useful...
CREATE OR REPLACE PROCEDURE insert_record_customer
IS
BEGIN
    INSERT INTO customer VALUES(69, 'A', 'B', 'C', 'D', 'E', 'G', 'H', 'J', 'I', 'O', 'P', 3);
END insert_record_customer;
/
BEGIN
    insert_record_customer;
END;
/

-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_table_trigger AFTER INSERT ON employee
    FOR EACH ROW
    BEGIN
        -- Do whatever you want done
    END;
/

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_table_trigger AFTER UPDATE ON album
    FOR EACH ROW
    BEGIN
        -- Do whatever you want
    END;
/

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
-- Is there more that I'm supposed to be doing? The trigger goes off after the delete
CREATE OR REPLACE TRIGGER customer_after_delete_trig AFTER DELETE ON album
    FOR EACH ROW
    BEGIN
        -- Do whatever you want
    END;
/

-- Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER invoice BEFORE DELETE ON invoice
    FOR EACH ROW
    BEGIN
    -- I'm not really sure what to put here. If this was java then no problem but... I can't do normal ifs can I?
    -- This is question 3 from the first one all over! How the heck do I do this?
    END;
/

-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname, invoice.invoiceid FROM customer INNER JOIN invoice 
    ON customer.customerid = invoice.customerid;
    
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
-- You mean full join? Said outer doesn't do anything
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceId, invoice.total 
    FROM customer FULL JOIN invoice ON customer.customerid = invoice.customerid;
    
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title FROM album RIGHT JOIN artist ON artist.artistid = album.artistid;

-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT artist.name FROM artist CROSS JOIN album ORDER BY artist.name ASC;
-- Thats uh, quite a few results

-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT e1.firstname, e2.reportsto FROM employee e1 JOIN employee e2 ON (e1.employeeid = e2.reportsto);

-- Task – Create a clustered index on of table of your choice
CREATE CLUSTER genre (genreid number, name varchar2(120 BYTE));

