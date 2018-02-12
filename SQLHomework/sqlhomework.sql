--
--1.0	Setting up Oracle Chinook
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.
--DONEZO
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT *
FROM Employee;
--Task – Select all records from the Employee table where last name is King.
SELECT *
FROM Employee
WHERE LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM Employee
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album
ORDER BY title DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM Customer
ORDER BY city;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre(name, genreid)
    VALUES('Electro-swing', 27);
INSERT INTO Genre (name, genreid)
    VALUES ('Jazz-dubstep', 132);
--Task – Insert two new records into Employee table
INSERT INTO Employee(employeeid, lastname, firstname, title, reportsto, 
    birthdate, hiredate, address, city, state, country, postalcode, 
    phone, fax, email)
VALUES(167, 'Poblocki', 'Jack', null, null, null, null, null, null, 
    null, null, null, null, null, null);
INSERT INTO Employee(employeeid, lastname, firstname, title, reportsto, 
    birthdate, hiredate, address, city, state, country, postalcode, 
    phone, fax, email)
VALUES(168, 'Stewart', 'Patrick', null, null, null, null, null, null, 
    null, null, null, null, null, null);
--Task – Insert two new records into Customer table
INSERT INTO Customer(customerid, firstname, lastname, email)
    VALUES(201, 'George', 'Washington', 'gDaddy@gmail.com');
INSERT INTO Customer(customerid, firstname, lastname, email)
    VALUES(202, 'John', 'Adams', 'fuckGeorge@gmail.com');
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE customer
WHERE firstname = 'Robert' AND lastname = 'Walter';
--
--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT systimestamp FROM DUAL; 
--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_media_name
    (media_id IN number)
    RETURN varchar2
    IS
    m_type varchar2(120);
    BEGIN
        SELECT name INTO m_type  FROM mediatype
            WHERE mediatypeid = media_id;
        RETURN m_type;
    END;
/    
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avg_invoice
    RETURN number
    IS
    end_val number;
    BEGIN
        SELECT AVG(total) INTO end_val  FROM invoice;
        RETURN end_val;
    END;
/
SET SERVEROUTPUT ON
DECLARE
BEGIN    
    dbms_output.put_line(avg_invoice);
END;
/
--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION bling_track
    RETURN sys_refcursor
    IS
    b_track sys_refcursor;
    BEGIN
        OPEN b_track
        FOR SELECT * FROM track
        WHERE unitprice IN (SELECT MAX(unitprice) FROM track);
        RETURN b_track;
    END;
/
SET SERVEROUTPUT ON
SELECT bling_track FROM track;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_invoiceline_price
    RETURN number
    IS
    end_val number;
    BEGIN
        SELECT AVG(unitprice) INTO end_val  FROM invoiceline;
        RETURN end_val;
    END;
/
SET SERVEROUTPUT ON
DECLARE
BEGIN    
    dbms_output.put_line(avg_invoiceline_price);
END;
/
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION young_folk
RETURN sys_refcursor
IS
end_list sys_refcursor;
BEGIN
    OPEN end_list FOR
    SELECT * FROM employee
    WHERE birthdate < TO_DATE('1968-01-01', 'YYYY-MM-DD');
    RETURN end_list;
END;
/
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE first_last
(results OUT sys_refcursor)
IS
BEGIN
    OPEN results FOR SELECT firstname, lastname FROM employee;
END first_last;
/
SET SERVEROUTPUT ON;
DECLARE
    results sys_refcursor;
    firstname varchar2(30);
    lastname varchar2(30);
BEGIN
    first_last(results);
    LOOP
        FETCH results INTO firstname, lastname;
        EXIT WHEN results%notfound;
        dbms_output.put_line(firstname || ' | ' || lastname);
    END LOOP;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE change_employee_info
(employee_id IN number, n_lastname IN varchar2, n_firstname IN varchar2, n_title IN varchar2, n_address IN varchar2, 
n_city IN varchar2, n_state IN varchar2, n_country IN varchar2, n_postalcode IN varchar2, 
n_phone IN varchar2, n_fax IN varchar2, n_email IN varchar2)
IS
BEGIN
    UPDATE employee
    SET lastname = n_lastname, firstname = n_firstname, title = n_title, address = n_address, city = n_city,
    state = n_state, country = n_country, postalcode = n_postalcode, phone = n_phone, fax = n_fax,
    email = n_email
    WHERE employeeid = employee_id;
END change_employee_info;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE find_managers
(employee_id IN number, results OUT sys_refcursor)
IS
BEGIN
    OPEN results FOR SELECT * FROM employee a, employee b 
    WHERE a.employeeid = employee_id 
    AND a.reportsto = b.employeeid;
END find_managers;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE customer_employment
(c_id IN NUMBER, c_f_name OUT varchar2, c_l_name OUT varchar2, c_company OUT varchar2) 
IS
BEGIN
    SELECT firstname, lastname, company INTO c_f_name, c_l_name, c_company FROM customer
    WHERE customerid = c_id;
END customer_employment;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
-- ALTER TABLE with ON DELETE CASCADE clause
ALTER TABLE invoiceline
ADD CONSTRAINT casc_inv
  FOREIGN KEY (invoiceid)
  REFERENCES invoice(invoiceid)
  ON DELETE CASCADE;

CREATE OR REPLACE FUNCTION invoice_deleter
(inv_id IN NUMBER)
RETURN NUMBER
AS
BEGIN
    DELETE FROM invoice WHERE invoiceid = inv_id;
    RETURN 0;
END;
/
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE SEQUENCE cus_sequence START WITH 1000; 
CREATE OR REPLACE PROCEDURE into_customer
(f_name IN varchar2, l_name IN varchar2, e_mail IN varchar2)
IS
BEGIN
    INSERT INTO customer (customerid, firstname, lastname, email)
    VALUES (cus_sequence.nextVal, f_name, l_name, e_mail);
END;
/
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE SEQUENCE emp_seq  START WITH 500;

CREATE OR REPLACE TRIGGER after_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
UPDATE employee
SET employeeid = emp_seq.nextVal;
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE SEQUENCE alb_seq  START WITH 500;

CREATE OR REPLACE TRIGGER after_insert_album
AFTER INSERT ON album
FOR EACH ROW
BEGIN
UPDATE album
SET albumid = alb_seq.nextVal;
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete_customer
AFTER DELETE ON album
BEGIN
rollback;
END;
/

--
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER dont_phase_me_bro
BEFORE DELETE ON invoice
FOR EACH ROW
BEGIN
    IF :old.total > 50 THEN
        raise_application_error(-20001, 'Cannot delete invoice priced over 50 dollars.');
    END IF;
END;
/
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, invoiceid FROM invoice INNER JOIN CUSTOMER ON invoice.customerid = customer.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, firstname, lastname, invoiceid, total FROM invoice FULL OUTER JOIN customer ON invoice.customerid = customer.customerid;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title FROM album RIGHT JOIN artist ON album.artistid = artist.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM album CROSS JOIN artist WHERE album.artistid = artist.artistid
ORDER BY name asc;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * from employee e1, employee e2 WHERE e1.reportsto = e2.employeeid; 
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE INDEX employee_id_reportsto ON employee (employeeid, reportsto);



