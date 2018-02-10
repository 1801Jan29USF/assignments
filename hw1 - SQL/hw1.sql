--?	Setting up Oracle Chinook
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE LastName = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee WHERE FirstName = 'Andrew' AND ReportSTO IS NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album ORDER BY Title DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FirstName FROM Customer ORDER BY FirstName ASC;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre VALUES (26, 'Electronic');
--Task – Insert two new records into Employee table
--UPDATE Employee SET Country = 'United States' WHERE EmployeeID = 9;
INSERT INTO Employee VALUES 
    (9, 'M', 'Bobby', 'Sowftware Developer', NULL, '13-NOV-92', '29-JAN-18', 'address', 'city', 'state',
    'United States', '111111', '+1 (555) 555-55555', NULL, 'bmail@mail.com');
INSERT INTO Employee VALUES
    (10, 'F', 'Billy', 'HR Staff', NULL, '13-AUG-92', '06-FEB-19', 'address', 'city', 'state', 'United States',
    '11111', '+1 (666) 123-4567', 'Who faxes anymore?', 'usemenotfax@mail.com');
--Task – Insert two new records into Customer table
INSERT INTO Customer VALUES
    (60, 'Mario', 'Jumpman', 'Nintendo', '84 Green Pipe Ln', 'World 1-1', 'Mushrooom Kingdom', 'Japan', '87117775',
    '+2 (776) 582-7379', NULL, 'mario@mushroommail.com', 1);
INSERT INTO Customer VALUES
    (61, 'Sonic', 'Hedgehog', 'Sega', '100 Gold Ring Rd', 'Green Hill Zone', 'Mobius', 'Japan', '71729077', '+7 (837) 978-7367',
    'Seriously stop faxing', 'soinc@prower.net', 2);
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer SET FirstName = 'Robert', LastName = 'Walter' WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist SET Name = 'CCR' WHERE Name = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM Employee WHERE HireDate BETWEEN '01-JUN-03' AND '01-MAR-04';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE Invoice
    DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE Invoice
    ADD CONSTRAINT FK_INVOICECUSTOMERID_Cascade
    FOREIGN KEY (CustomerID) REFERENCES Customer (CustomerID) ON DELETE CASCADE;
DELETE FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walter';
--
--?	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH24:MI:SS') FROM DUAL;
--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name), name FROM mediatype;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(total) FROM invoice;
--Task – Create a function that returns the most expensive track
SELECT MAX(unitprice) FROM track;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_invoice_line_price
RETURN NUMBER
IS avg_price NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO avg_price FROM INVOICELINE;
    RETURN avg_price;
END;
/
SELECT avg_invoice_line_price FROM DUAL;
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION emp_after_1968
RETURN SYS_REFCURSOR
IS result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT employeeid FROM employee WHERE birthdate > TO_DATE('1968-01-31', 'YYYY-MM-DD');
    RETURN result;
END;
/
SELECT emp_after_1968 FROM DUAL;
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE emp_name (emp_names OUT SYS_REFCURSOR)
IS BEGIN
    OPEN emp_names FOR SELECT firstname, lastname FROM employee;
END emp_name;
/
SET SERVEROUTPUT ON
DECLARE
    result SYS_REFCURSOR;
    firstname VARCHAR2(20 BYTE);
    lastname VARCHAR2(20 BYTE);
BEGIN 
    emp_name(result);
    LOOP
        FETCH result INTO firstname, lastname;
        EXIT WHEN result%notfound;
        dbms_output.put_line(firstname || ' | ' || lastname);
    END LOOP;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE emp_update
(emp_id IN NUMBER,
lname IN VARCHAR2,
fname IN VARCHAR2,
title_param IN VARCHAR2,
rpt_to IN NUMBER,
bdate IN DATE,
hdate IN DATE,
address_param IN VARCHAR2,
city_param IN VARCHAR2,
state_param IN VARCHAR,
country_param IN VARCHAR2,
pcode IN VARCHAR2,
phone_param IN VARCHAR2,
fax_param IN VARCHAR2,
email_param IN VARCHAR2)
IS BEGIN
    UPDATE employee SET 
        lastname = lname,
        firstname = fname,
        title = title_param,
        reportsto = rpt_to,
        birthdate = bdate,
        hiredate = hdate,
        address = address_param,
        city = city_param,
        state = state_param,
        country = country_param,
        postalcode = pcode,
        fax = fax_param,
        email = email_param
        WHERE
        employeeid = emp_id;
END;
/
SET SERVEROUTPUT ON
DECLARE
BEGIN 
    emp_update(9, 'McGetrick', 'Bobby', 'Sowftware Developer', NULL, '13-NOV-92', '29-JAN-18', 'new address', 'new city', 'new state',
    'United States', '77777', '+1 (888) 888-8888', NULL, 'newmail@newmail.com');
END;
/
SELECT * FROM employee WHERE employeeid = 9;
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE mngr_of_emp (emp_id IN NUMBER, result OUT SYS_REFCURSOR)
IS BEGIN
    OPEN result FOR SELECT e0.firstname, e0.lastname FROM employee e0, employee e1
    WHERE e1.reportsto = e0.employeeid AND e1.employeeid = emp_id;
END;
/
SET SERVEROUTPUT ON
DECLARE
result SYS_REFCURSOR;
firstname VARCHAR2(40 BYTE);
lastname VARCHAR2(20 BYTE);
BEGIN 
    mngr_of_emp(6, result);
    LOOP
        FETCH result INTO firstname, lastname;
        EXIT WHEN result%notfound;
        dbms_output.put_line(firstname || ' | ' || lastname);
    END LOOP;
END;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE name_co_of_cust (cust_id IN NUMBER, fname_param OUT VARCHAR2, lname_param OUT VARCHAR2,
co OUT VARCHAR2)
IS BEGIN
    SELECT firstname, lastname, company INTO fname_param, lname_param, co FROM customer WHERE customerid = cust_id;
END;
/
SET SERVEROUTPUT ON
DECLARE
fname VARCHAR2(40 BYTE);
lname VARCHAR2(20 BYTE);
co VARCHAR2(80 BYTE);
BEGIN
    name_co_of_cust(5, fname, lname, co);
    dbms_output.put_line(fname || ' | ' || lname || ' | ' || co);
END;
/
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoiceline
    DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE Invoiceline
    ADD CONSTRAINT FK_INVOICELINEINVOICEID_Casc
    FOREIGN KEY (invoicelineid) REFERENCES invoiceline (invoicelineID) ON DELETE CASCADE;
ACCEPT invnum PROMPT 'Enter invoice id: '
DELETE FROM invoice WHERE invoiceid = &invnum;
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER emp_after_insert_trig
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('after inert to employee trgigger fired');
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER alb_after_update_trig
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    dbms_output.put_line('after update album trigger fired');
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER cust_after_delete_trig
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    dbms_output.put_line('after delete customer trigger fired');
END;
/
--
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE VIEW invoice_view AS SELECT * FROM invoice;
CREATE OR REPLACE TRIGGER invoice_instead_of_delete_trig
INSTEAD OF DELETE ON invoice_view
BEGIN
    IF :old.total > 50 THEN
        dbms_output.put_line('invoice total exceeds $50, delete did not occur.');
    ELSE
        dbms_output.put_line('invoice total <= 50, delte occured.');
        DELETE FROM invoice WHERE invoiceid = :old.invoiceid;
    END IF;
END;
/
SELECT * FROM invoice ORDER BY total DESC;
UPDATE invoice SET total = 100 WHERE invoiceid = 299;
DELETE FROM invoice_view WHERE invoiceid = 299;
DELETE FROM invoice_view WHERE invoiceid = 96;
SELECT * FROM invoice_view ORDER BY total DESC;
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT lastname, firstname, invoiceid FROM customer cust
    INNER JOIN invoice inv
    ON cust.customerid = inv.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT cust.customerid, cust.firstname, cust.lastname, inv.invoiceid, inv.total FROM customer cust
    LEFT JOIN invoice inv
    ON cust.customerid = inv.customerid;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title FROM album
    RIGHT JOIN artist
    USING (artistid);
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM album
    CROSS JOIN artist
    ORDER BY artist.name ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee e0, employee e1
    WHERE e0.reportsto = e1.reportsto;
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE INDEX cust_clust ON customer(firstname, lastname);
--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
--Task – Create a .bak file for the Chinook database.
