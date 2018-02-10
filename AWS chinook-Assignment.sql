--Part I – Working with an existing database
--
--1.0	Setting up Oracle Chinook
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee WHERE lastname = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE firstname = 'Andrew' And REPORTSTO is null;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
    ORDER BY title DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer
    ORDER BY city ASC;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT into genre(GENREID, name) VALUES (26, 'Country');
INSERT into genre(GENREID,name) VALUES (27, 'Classic');
SELECT * FROM genre;
--Task – Insert two new records into Employee table

INSERT into employee(employeeid,lastname, firstname, title, REPORTSTO, 
            birthdate, hiredate, address, city, state, country,
            postalcode, phone, fax, email) 
                VALUES (9,'Mike', 'Mike', 'Accountant', 6, '05-DEC-88', '15-09-05', '999 James rd', 'tampa', 'FL', 'United States', 66598, '+1 (888) 999-8888', '+1 (888) 999-8882', 'mike@gmail.com'  );
                
INSERT into employee(employeeid,lastname, firstname, title, REPORTSTO, 
            birthdate, hiredate, address, city, state, country,
            postalcode, phone, fax, email) 
                VALUES (10,'tim', 'Timy', 'Accountant', 6, '05-jan-78', '01-SEP-09', '466 Wall St', 'New York', 'NY', 'United States', 45631, '+1 (456) 123-7896', '+1 (888) 852-1589', 'timy@gmail.com'  );                

--Task – Insert two new records into Customer table

INSERT into customer(customerid, firstname, lastname, company, address, city, state, country,
            postalcode, phone, fax, email) 
                VALUES (60,'tom', 'tom', 'Revature','tampa st' , 'tampa', 'FL', 'United States', 65852, '+1 (753) 999-1478', '+1 (753) 999-3564', 'tome@gmail.com' );

INSERT into customer(customerid, firstname, lastname, company, address, city, state, country,
            postalcode, phone, fax, email) 
                VALUES (61,'Sarah', 'Long', 'Cap one','orlando st','Orlando' , 'FL', 'United States', 12365, '+1 (896) 222-1236', '+1 (896) 1111-4569', 'Sarah@gmail.com' );

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter

UPDATE Customer
SET firstname = 'Robert', lastname= 'Walter'
WHERE firstname = 'Aaron';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice
    WHERE BILLINGADDRESS like 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
    WHERE TOTAL BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
    WHERE HIREDATE BETWEEN '01-JUN-03' AND '1-MAR-04';
    

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE Invoice
    DROP CONSTRAINT FK_InvoiceCustomerId;
    
ALTER TABLE Invoice
    ADD CONSTRAINT I_C_ID_Casc
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)
    ON DELETE CASCADE;

ALTER TABLE InvoiceLine
    DROP CONSTRAINT FK_InvoiceLineInvoiceId;
    
ALTER TABLE InvoiceLine
    ADD CONSTRAINT InvoiceLine_Casc
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId)
    ON DELETE CASCADE;
DELETE FROM customer WHERE firstname = 'Robert' and lastname = 'Walter';

select * from customer
    WHERE firstname = 'Robert';




--
--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database


--3.1 System Defined Functions
--Task – Create a function that returns the current time.
create or replace function current_time
return TIMESTAMP is
  c_date TIMESTAMP;
BEGIN
  select SYSTIMESTAMP
    into c_date
    from dual;
  return c_date;
END;
SELECT current_time FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
--select* from mediatype;
create or replace function mediatype_length(media_id in number)
return number is
  m_length number;
BEGIN
  select LENGTH(MEDIATYPE.Name) 
  INTO m_length     
    from MEDIATYPE
    WHERE MEDIATYPEID = media_id;
  return m_length;
END;
/

SELECT mediatype_length(5) FROM DUAL;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
select * from invoice;
CREATE OR REPLACE FUNCTION average_total_invoice 
RETURN number IS 
   total_average number; 
BEGIN 
   SELECT AVG(total) 
   INTO total_average
     FROM invoice; 
   RETURN total_average; 
END; 
/ 
SELECT average_total_invoice FROM DUAL;

--Task – Create a function that returns the most expensive track
SELECT MAX(UnitPrice) FROM Track;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

CREATE OR REPLACE FUNCTION average_price_invoiceline
RETURN NUMBER
IS price NUMBER;
BEGIN
    SELECT AVG(unitprice)
    INTO price 
    FROM INVOICELINE;
    RETURN price;
END;
/
SELECT average_price_invoiceline FROM DUAL;    
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

CREATE OR REPLACE FUNCTION old_employess
RETURN SYS_REFCURSOR
IS 
employees SYS_REFCURSOR;
BEGIN
     OPEN employees 
     FOR SELECT firstname, lastname
         FROM Employee
         WHERE birthdate >= TO_DATE('1969-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
         RETURN employees;
END;
/ 

SELECT old_employess FROM DUAL;
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE find_employee
(found_employee OUT sys_refcursor)
IS 
BEGIN
    OPEN found_employee 
    FOR SELECT firstname, lastname 
    FROM employee;    
    
END find_employee;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE update_employee_info
(employeeid IN NUMBER, lastname IN VARCHAR2, firstname IN VARCHAR2, address IN VARCHAR2, city IN VARCHAR2, state IN VARCHAR2, phone IN NUMBER)
IS 
BEGIN
  INSERT INTO employee (employeeid,lastname,firstname, address, city, state, phone)
  VALUES (employeeid,lastname,firstname,address, city, state, phone);
  
END update_employee_info;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE returns_employee_manager
(manager OUT sys_refcursor)
IS 
BEGIN
    OPEN manager 
    FOR SELECT * 
    FROM employee emp1, employee emp2
    WHERE emp1.reportsto = emp2.reportsto;
END returns_employee_manager;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE find_customer_name_company
(customer_id IN number, name_company OUT sys_refcursor)
IS 
BEGIN
OPEN name_company 
FOR SELECT firstname, company 
FROM customer
WHERE customer.customerid = customer_id;
END find_customer_name_company;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

CREATE OR REPLACE PROCEDURE delete_invoice
(invoice_id IN number)
IS
BEGIN
    DELETE FROM InvoiceLine
        WHERE InvoiceId = invoice_id;
    DELETE FROM Invoice
        WHERE InvoiceId = invoice_id;
END delete_invoice;
/ 
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer_transaction
(customer_id IN number, first_name IN varchar2, last_name IN varchar2, email_ IN varchar2,address_ in VARCHAR2, city_ IN VARCHAR2, state_ IN VARCHAR2)
IS
BEGIN
    INSERT INTO customer(customerid, firstname, lastname, email ,address ,city ,state)
        VALUES(customer_id, first_name, last_name, email_,address_,city_,state_);
END insert_customer_transaction;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

--6.1 AFTER/FOR


--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER after_insert 
AFTER INSERT ON Employee
FOR EACH ROW
DECLARE
BEGIN
dbms_output.put_line('There was an insert attempt');
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER after_update
AFTER UPDATE ON Employee
FOR EACH ROW
DECLARE
BEGIN
dbms_output.put_line(' There was an update attempt');
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete 
AFTER  ON Employee
FOR EACH ROW
DECLARE
BEGIN
dbms_output.put_line('There was an delete attempt');
END;
/
--
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER instead_delete_trig
BEFORE DELETE ON invoice
FOR EACH ROW
BEGIN 
    IF :old.Total > 50.0 THEN 
        dbms_output.put_line('Not approved for deleting of invoices over $50');
    END IF;
END;
/
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, lastname, invoiceid FROM customer 
    INNER JOIN invoice 
    ON customer.customerid = invoice.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, firstname, lastname,invoiceId,total FROM customer 
    FULL OUTER JOIN invoice 
    ON customer.customerid = invoice.customerid;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title FROM artist 
    RIGHT JOIN album 
    ON artist.artistid = album.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM artist 
    cross JOIN album 
    ORDER BY artist.name ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee emp1, employee emp2 
    WHERE emp1.reportsto = emp2.employeeid;

--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
CREATE INDEX index_name ON track(name, composer);

