--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM Employee; 

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee 
    WHERE (LASTNAME) = 'King' ; 

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.  
SELECT * FROM Employee 
    WHERE (firstname) = 'Andrew'
   AND REPORTSTO is NULL;    

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album 
    ORDER BY title desc;
    
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM Customer
    ORDER by city asc;
    
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
select * from genre;
INSERT INTO GENRE (genreid, name)
    VALUES (26, 'Hiphop');
    
INSERT INTO GENRE (genreid, name)
    VALUES (27, 'rap');
--Task – Insert two new records into Employee table
select * from employee;
INSERT INTO EMPLOYEE (employeeId, lastname, firstname, title, reportsto, birthdate, 
    hiredate, address, city, state, country, postalcode, phone, fax, email)
    VALUES (9, 'Romil', 'Desai', 'IT manager', 
    TO_DATE('1975-4-23','yyyy-mm-dd'), 
    TO_DATE('2006-2-28','yyyy-mm-dd'), 
    '25 main street', 'calagary', 'AB', 'Canada', 'T2P 5G3', 
    '+1 (564) 678-6543', '+1 (856) 037-7685', 'managerdesai@chinookcorp.com');
    
    INSERT INTO EMPLOYEE (employeeId, lastname, firstname, title, reportsto, birthdate, 
    hiredate, address, city, state, country, postalcode, phone, fax, email)
    VALUES (10, 'Bena', 'Patel', 'IT manager', 
    TO_DATE('1979-2-5','yyyy-mm-dd'), 
    TO_DATE('2010-6-21','yyyy-mm-dd'), 
    '12 main street', 'Edmonton', 'AB', 'Canada', 'T5k 2n1', 
    '+1 (756) 434-8934', '+1 (937) 245-0724', 'managerbeena@chinookcorp.com');
    
--Task – Insert two new records into Customer table
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
    SET firstname = 'Robert', lastname = 'Walter'
    WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
    
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
    SET name = 'CCR' 
    WHERE name = 'Creedence Clearwater Revival';
    
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE totaL
    BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate
    BETWEEN To_DATE('2003-06-01', 'YYYY-MM-DD') 
    AND To_DATE('2004-03-01', 'YYYY-MM-DD');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE Customer 
where firstname = 'Robert' 
AND lastname = 'Walter';

--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT CURRENT_TIMESTAMP FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
--SELECT * FROM MEDIATYPE
--SELECT COUNT(*) FROM MEDIATYPE;
SELECT LENGTH(NAME) FROM MEDIATYPE;


--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(TOTAL) FROM INVOICE;
--Task – Create a function that returns the most expensive track
--SELECT * FROM TRACK ;
SELECT MAX(UNITPRICE ) FROM TRACK ;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
--SELECT * FROM invoiceline;
SELECT AVG(UNITPRICE) FROM INVOICELINE;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM EMPLOYEE WHERE birthdate > To_DATE('1969-01-01', 'YYYY-MM-DD');

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
create or replace PROCEDURE first_last (results OUT sys_refcursor)
IS
BEGIN
      OPEN RESULTS FOR SELECT firstname, lastname FROM Employee;
END first_last;
/
SELECT * FROM EMPLOYEE;
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
create or replace PROCEDURE updates
--(setid IN number)
(NEW_ID IN NUMBER, NEW_FIRSTNAME IN VARCHAR2, NEW_LASTNAME IN VARCHAR2, NEW_POTALCODE IN NUMBER,
NEW_STATE IN VARCHAR2)
IS
BEGIN
UPDATE EMPLOYEE SET EMPLOYEEID = NEW_ID, FIRSTNAME = NEW_FIRSTNAME, LASTNAME= NEW_LASTNAME, POSTALCODE= NEW_POTALCODE,
STATE = NEW_STATE;
      
END UPDATES;
/

--Task – Create a stored procedure that returns the managers of an employee.
create or replace PROCEDURE manager_of_employee
(employeeId_param IN NUMBER, RESULTS OUT SYS_REFCURSOR)
AS
BEGIN
OPEN RESULTS FOR SELECT M.FIRSTNAME, M.LASTNAME
FROM EMPLOYEE E
INNER JOIN EMPLOYEE M
ON M.EMPLOYEEID = E.REPORTSTO 
WHERE E.EMPLOYEEID = EMPLOYEEID_PARAM;
END manager_of_employee;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE name_and_company 
(customer_id_param IN NUMBER, results out sys_refcursor)
AS 
BEGIN
  OPEN results FOR SELECT Customer.firstname, Customer.comapny
  FROM Customer
  WHERE Customer.Customerid = Customerid_param ;
END name_and_company;
/
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. 
--You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice
(invoice_id_param IN number)
IS
BEGIN
    DELETE FROM invoiceline
        WHERE invoiceline.invoiceid = invoice_id_param;
    DELETE FROM Invoice
        WHERE invoice.invoiceid = invoice_id_param;
COMMIT;
END delete_invoice;
/ 
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_new_record AS
    BEGIN
        INSERT INTO Customer VALUES(60, 'Srushti', 'Patel', null, '34 mains street', 'Sydney', 'NSW', 'Australia', '3456', '+61 (02) 3456 6555',null, 'iexist@mail.com)', 3);
    END;
/
select * from customer ;
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER insert_trigger
AFTER INSERT ON Employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('trigger inserted ');
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER update_trigger
AFTER UPDATE ON Employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('trigger updated');
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER delete_trigger
AFTER DELETE ON Employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('after delete trogger');
END;
/


--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER instead_trigger
BEFORE DELETE ON Invoice
FOR EACH ROW
BEGIN
    IF (old.Total > 50.0)
       THEN DBMS_OUTPUT.PUT_LINE('total is greater than 50');
    ELSE DELETE FROM Invoice WHERE invoiceid = old.invoiceid;
    END IF;
END instead_trigger;
/


--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT Customer.firstname,Customer.lastname,Invoice.invoiceid
    FROM Customer
    INNER JOIN Invoice ON Customer.customerid = Invoice.customerid;
    
    
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT Customer.customerid,Customer.firstname, Customer.lastname, Invoice.invoiceid, Invoice.total
    FROM Customer
    FULL OUTER JOIN Invoice ON Customer.customerid = Invoice.customerid;
    
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title FROM album
    RIGHT JOIN artist
    USING (artistid);

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT* FROM Artist
CROSS JOIN Album
ORDER BY Artist.name asc;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM Employee emp1, employee emp2
    WHERE emp1.reportsto = emp2.EMPLOYEEID;
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice



