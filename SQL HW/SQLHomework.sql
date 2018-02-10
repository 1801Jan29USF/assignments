--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM Employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title desc; 
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT * FROM customer ORDER BY city asc;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre (GENREID, NAME) VALUES (26,'Dubstep');
INSERT INTO Genre (GENREID, NAME) VALUES (27, 'Trap');
--Task – Insert two new records into Employee table
INSERT INTO Employee (EMPLOYEEID,LASTNAME, FIRSTNAME) VALUES (9,'hi','hello');
INSERT INTO Employee (EMPLOYEEID,LASTNAME, FIRSTNAME) VALUES (10,'two','three');
--Task – Insert two new records into Customer table
INSERT INTO Customer (CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL) VALUES (60,'hi','hello','hello@gmail.com');
INSERT INTO Customer (CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL) VALUES (61,'two','three','triple@gmail.com');
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell'; 
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE UPPER(BILLINGADDRESS) LIKE 'T%'; 
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE invoiceid BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';




--3.0	SQL Functions
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT sysdate FROM artist;   
--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT MAX (LENGTH(name)) FROM mediatype;
--3.2 System Defined Agregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(invoiceid) FROM invoice;
--Task – Create a function that returns the most expensive track
SELECT MAX(unitprice) FROM track;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT AVG(unitprice) FROM invoiceline; 
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM employee WHERE birthdate < TO_DATE('1968-01-01', 'YYYY-MM-DD');

--4.0 Stored Procedures

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE find_employee_first_last
(firstname IN VARCHAR2, lastname IN VARCHAR2, results OUT sys_refcursor)
IS 
BEGIN
  OPEN results FOR SELECT firstname, lastname FROM employee;
END find_employee_first_last;
  
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee_personal_info
( address IN VARCHAR2, city IN VARCHAR2, state IN VARCHAR2, phone IN NUMBER)
IS 
BEGIN
  INSERT INTO employee (address, city, state, phone)
  VALUES (address, city, state, phone);
  
END;
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE return_manager
(results OUT sys_refcursor)
IS 
BEGIN
OPEN results FOR SELECT * FROM employee e1, employee e2
WHERE e1.reportsto = e2.reportsto;
END return_manager;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE return_name_company
(results OUT sys_refcursor)
IS 
BEGIN
OPEN results FOR SELECT firstname, lastname, company FROM customer;
END return_name_company;
/
--5.0 Transactions

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE del_invoice
(invoiceid IN NUMBER)
IS 
BEGIN
 DELETE invoice WHERE invoiceid = invoiceid;
END del_invoice;
/
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE in_customer
( customerid IN NUMBER, firstname IN VARCHAR2, lastname IN VARCHAR2, email IN VARCHAR2)
IS 
BEGIN
 INSERT INTO customer(customerid, firstname, lastname, email)
VALUES customer(customerid, firstname, lastname, email);
  END in_customer;
  /

--6.0 Triggers

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE TRIGGER employee_id_trig
AFTER INSERT ON employee
FOR EACH ROW
BEGIN 
    IF INSERTING THEN
    SELECT employeeid_seq.nextval INTO :new.employeeid FROM dual;
    END IF;
    END;
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE TRIGGER album_id_trig
AFTER INSERT ON album
FOR EACH ROW
BEGIN 
    IF INSERTING THEN
    SELECT albumid_seq.nextval INTO :new.albumid FROM dual;
    END IF;
    END;
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE TRIGGER customer_id_trig
AFTER DELETE ON customer
FOR EACH ROW
BEGIN 
    IF INSERTING THEN
    SELECT customerid_seq.nextval INTO :new.customerid FROM dual;
    END IF;
    END;
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE TRIGGER invoice_id_trig
AFTER INSERT OR UPDATE ON invoice
FOR EACH ROW
BEGIN 
  IF INSERTING THEN 
    SELECT * FROM invoice WHERE TOTAL > 50;
  END;
--7.0 JOINS

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT * FROM customer INNER JOIN invoice ON customer.customerid = invoice.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, firstname, lastname, invoiceid, total FROM invoice FULL OUTER JOIN customer ON customer.customerid = invoice.customerid;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT  name, title FROM album RIGHT JOIN artist ON album.artistid = artist.artistid; 
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM album CROSS JOIN artist WHERE album.artistid = artist.artistid 
ORDER BY name asc;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee e1,employee e2 WHERE e1.reportsto = e2.employeeid; 
--8.0 Indexes

--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
SELECT * FROM track WHERE name LIKE 'He%';
CREATE INDEX name_index ON track(name);
