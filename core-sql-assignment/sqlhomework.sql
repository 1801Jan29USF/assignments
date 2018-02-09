--Setting up Oracle Chinook
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
select * from Employee;
--Task – Select all records from the Employee table where last name is King.
select * from Employee where LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from Employee where FIRSTNAME = 'Andrew' and REPORTSTO IS NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
select * from Album order by title desc;
--Task – Select first name from Customer and sort result set in ascending order by city
select * from Customer order by city;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre(GenreID, Name)
    VALUES (100, 'Kappa');
INSERT INTO Genre(GenreID, Name)
    VALUES (101, 'Hello');
--Task – Insert two new records into Employee table
INSERT INTO Employee(EmployeeID, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
    VALUES (1000, 'Charlos', 'Quebec', 'The Best', 1, null, null, 'Address', 'Tampa', 'Florida', 'US', '30041', '121231', '12314', 'hello@hello.com');
INSERT INTO Employee(EmployeeID, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
    VALUES (1001, 'Charlos', 'Quebec', 'The Best', 1, null, null, 'Address', 'Tampa', 'Florida', 'US', '30041', '121231', '12314', 'hello@hello.com');
--Task – Insert two new records into Customer table
INSERT INTO Customer(CustomerID, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
    VALUES (2000,'Charles', 'France', 'Revature', 'Nowhere', 'Miami', 'Florida', 'US', '100', '12312', '123123', 'charles@hello.com', 1);
INSERT INTO Customer(CustomerID, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
    VALUES (2001,'Charles', 'France', 'Revature', 'Nowhere', 'Miami', 'Florida', 'US', '100', '12312', '123123', 'charles@hello.com', 1);
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET 
    firstname = 'Robert', 
    lastname = 'Walter'
    WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET 
    firstname = 'Robert', 
    lastname = 'Walter'
    WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * from Invoice WHERE billingaddress LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * from Invoice WHERE Total BETWEEN 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * from Employee WHERE Hiredate BETWEEN TO_DATE ('2003/06/01', 'yyyy/mm/dd')
AND TO_DATE ('2004/03/01', 'yyyy/mm/dd');
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM Customer
    WHERE firstname = 'Robert' and lastname = 'Walter';
--
--?	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT LOCALTIMESTAMP FROM DUAL;
--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(NAME) FROM MEDIATYPE;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(total) FROM invoice;
--Task – Create a function that returns the most expensive track
SELECT MAX(unitprice) FROM track;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_average_of_invoiceline
RETURN number
IS
avg_price number;
begin
    SELECT AVG(unitprice) INTO avg_price FROM invoiceline;
    RETURN avg_price;
end;
/

SELECT get_average_of_invoiceline() FROM invoiceline;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION get_employees
RETURN SYS_REFCURSOR
IS
emp_curs SYS_REFCURSOR;
begin
    OPEN emp_curs
    FOR SELECT * FROM employee WHERE birthdate > TO_DATE ('1968/01/01', 'yyyy/mm/dd');
    RETURN emp_curs;
end;
/

SELECT get_employees() FROM employee;

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE find_names_employees
(results OUT sys_refcursor)
IS
BEGIN
    OPEN results FOR SELECT firstname, lastname FROM employee;
END find_names_employees;
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
CREATE OR REPLACE PROCEDURE find_manager_employee
(results OUT sys_refcursor)
IS
BEGIN
    OPEN results FOR SELECT * FROM employee e1, employee e2 
            WHERE e1.reportsto = e2.reportsto;
END find_manager_employee;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE find_employees_name_company
(results OUT sys_refcursor)
IS
BEGIN
    OPEN results FOR SELECT firstname, lastname, company FROM customer;
END find_employees_name_company;
/
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice
(invoiceid IN number)
IS
BEGIN
    DELETE invoice WHERE invoiceid = invoiceid;
END delete_invoice;
/

BEGIN
    delete_invoice(1);
END;
/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer
(customerid IN number, firstname IN varchar2, lastname IN varchar2, email IN varchar2)
IS
BEGIN
    INSERT INTO customer(customerid, firstname, lastname, email)
        VALUES(customerid, firstname, lastname, email);
END insert_customer;
/

BEGIN
    insert_customer(12321, 'Charles', 'Hello', 'revature.com');
END;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_trig
AFTER INSERT ON employee
FOR EACH ROW
BEGIN 
    IF INSERTING THEN 
        UPDATE employee SET firstname = firstname;
    END IF;
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_trig
AFTER UPDATE ON album
FOR EACH ROW
BEGIN 
    IF UPDATING THEN 
        UPDATE album SET albumid = albumid;
    END IF;
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_trig
AFTER DELETE ON customer
FOR EACH ROW
BEGIN 
    IF DELETING THEN 
        UPDATE customer SET firstname = firstname;
    END IF;
END;
/
--  
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER invoice_trig
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
SELECT firstname, lastname, invoiceid FROM customer cust
    INNER JOIN invoice inv
    ON cust.customerid = inv.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT inv.customerid, firstname, lastname, invoiceid, total FROM customer cust
    FULL JOIN invoice inv
    ON cust.customerid = inv.customerid;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title FROM artist art
    RIGHT OUTER JOIN album alb
    ON art.artistid = alb.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT name FROM album alb 
    CROSS JOIN artist art
    WHERE alb.artistid = art.artistid;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee e1, employee e2
    WHERE e1.reportsto = e2.reportsto;
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE INDEX clustered_index ON employee(email, firstname);