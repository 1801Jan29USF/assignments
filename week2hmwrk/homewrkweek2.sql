--Javian Butler
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.

SELECT * FROM Employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO = NULL; 
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album ORDER BY TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM Customer ORDER BY City ASC;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre(GENREID, name)
VALUES(26,'Rapa');
INSERT INTO Genre(GENREID, name)
VALUES(27,'Souls');
--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE(EmployeeId, LastName,FirstName,Title,ReportsTo,BirthDate,HireDate, Address,City,State,Country,PostalCode,Phone,Fax,Email)
VALUES(9,'Jonson','Jquill','cashier','1','09-JUN-97','17-DEC-09','5647 Lake Ave W','Calgaryu', 'AB', 'Canada','T5k 2N3', '+1 (730) 739-2376','+1 (708) 456-1237','quill@chinookcorp.com');

INSERT INTO EMPLOYEE(EmployeeId, LastName,FirstName,Title,ReportsTo,BirthDate,HireDate, Address,City,State,Country,PostalCode,Phone,Fax,Email)
VALUES(9,'Jonson','Jquill','cashier','1','09-JUN-97','17-DEC-09','5647 Lake Ave W','Calgaryu', 'AB', 'Canada','T5k 2N3', '+1 (730) 739-2376','+1 (708) 456-1237','quill@chinookcorp.com');

--Task – Insert two new records into Customer table
SELECT *FROM Customer;
INSERT INTO Customer
VALUES(62,'Danger','Rodney','Target','3456 Boston St','Boston','BossStoner','America','49-98389','+1 (773) 456-2398','+1 (867) 456-283','DangerMan@gmail.com',3);
INSERT INTO Customer
VALUES(63,'Man','The Muffan ','Wal-Mart',' 2137 Drwey lane','Disney','Illinois','America','434-89','+1 (703) 127-2398','+1 (867) 456-283','TheManTheMuffin@gmail.com',3);
--2.4 UPDATE

--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = Aaron AND lastname = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET NAME = 'CCR'
WHERE NAME='Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT
    *
FROM invoice
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
SELECT * FROM invoice;
DELETE FROM invoice
WHERE invoiceid = 34;


SELECT CustomerID FROM  customer
WHERE firstname = 'Robert' AND lastname = 'Walter';
DELETE FROM Customer 
WHERE firstname = 'Robert';
--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CURRENT_TIMESTAMP;
--Task – create a function that returns the length of a mediatype from the mediatype table
==SELECT LENGTH(name) as lengthofname;

 --delimiter for plsql blocks 

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(total) FROM invoice;

SELECT MAX(unitprice) as most_expensive FROM track;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

SELECT AVG(unitprice) FROM invoiceline ;


--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM employee WHERE hiredate > TO_DATE('1969-01-01','YYYY-MM-DD');



--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure

--Task – Create a stored procedure that selects the first and last names of all the employees.
-- stored procedure to find flashcards in a given set
CREATE OR REPLACE PROCEDURE find_name
(results OUT sys_refcursor)
IS
BEGIN
    OPEN results FOR SELECT firstname, lastname FROM employee;
       
END find_name;
/

SET SERVEROUTPUT ON;
DECLARE
    results sys_refcursor;
    firstname varchar2(20 BYTE);
    lastname varchar2(20 BYTE);
BEGIN
    find_name(results);
    LOOP
        FETCH results INTO firstname, lastname;
        EXIT WHEN results%notfound;
        dbms_output.put_line(firstname || ' | ' || lastname);
    END LOOP;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_name
IS
BEGIN
    UPDATE employee SET firstname ='love' , lastname = 'Jones';
       
END update_name;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE find_manager (employee_name IN varchar2, manager_name OUT varchar2)
IS
BEGIN
   SELECT firstname INTO manager_name FROM employee WHERE (SELECT reportsto FROM employee WHERE firstname = employee_name) = employeeid;
END find_manager;
/
DECLARE
   manager_name varchar2(200);
BEGIN
   find_manager('Steve', manager_name);
END;
/
--4.3 Stored Procedure Output Parameters

--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE find_company (customer_first_name IN varchar2, company_name OUT varchar2, customer_first OUT varchar2)
IS
BEGIN
   SELECT firstname, company INTO customer_first, company_name FROM customer WHERE firstname = customer_first_name;
END find_company;
/
DECLARE
    customer_first varchar2(200);
   company_name varchar2(200);
BEGIN
   find_company('Eduardo', company_name, customer_first);
END;



--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a query that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM invoice
WHERE invoiceid = 1;
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
INSERT INTO customer
VALUES(64,'Monster','Mob ','spike-lee',' 2137 Dry lane','Menthall','Illinois','America','434-89','+1 (703) 127-2398','+1 (867) 456-283','TheManTheMuffin@gmail.com',3)
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER employee_id_trig
AFTER INSERT OR UPDATE ON employee
FOR EACH ROW
BEGIN
    UPDATE employee
    SET hiredate = TO_DATE('1970-01-01','YYYY-MM-DD')
        WHERE employeeid = 2;
    
END;
/




--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_trig
AFTER INSERT OR UPDATE ON album
FOR EACH ROW
BEGIN
    UPDATE album
    SET title = 'whoaaaaaa'
        WHERE albumid > 10;
    
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_trig
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    INSERT INTO Customer
    VALUES(69,'chimp','Rodney','Target','3456 Boston St','Boston','BossStoner','America','49-98389','+1 (773) 456-2398','+1 (867) 456-283','DangerMan@gmail.com',3);

    
END;
/


--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT invoiceid FROM invoice;
SELECT customer.firstname, customer.lastname, invoice.invoiceid
FROM customer
INNER JOIN invoice ON customer.customerid = invoice.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
JOIN invoice ON customer.customerid = invoice.invoiceid;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM artist
RIGHT JOIN album ON artist.artistid = album.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist CROSS JOIN album
ORDER BY artist.name ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT e1.firstname, e2.REPORTSTO
FROM employee e1 JOIN employee e2
ON (e1.employeeid = e2.reportsto);
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE CLUSTER artist(artistid NUMBER, name varchar2(500));

