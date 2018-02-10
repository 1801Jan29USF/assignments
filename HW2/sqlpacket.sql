--Part I – Working with an existing database
--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT *FROM Employee;
--Task – Select all records from the Employee table where last name is King.
SELECT *FROM Employee
    WHERE LastName = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *FROM Employee
    WHERE FirstName = 'Andrew'
    AND ReportsTo is NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT *FROM Album
    ORDER BY title desc;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FirstName FROM Customer
    ORDER BY city asc;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO Genre 
    VALUES (26 ,'lo-fi');
    
INSERT INTO Genre 
    VALUES (27 ,'indie');

--Task – Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
    VALUES (9, 'Adamsss', 'Andrew', 'General Manager', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
    VALUES (10, 'Adamsss', 'Paulie', 'General Manager', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');
--Task – Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
    VALUES (60, 'lENNY kRAVITZ', 'KÃ¶hler', 'Theodor-Heuss-StraÃŸe 34', 'Stuttgart', 'Germany', '70174', '+49 0711 2842222', 'leonekohler@surfeu.de', 5);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
    VALUES (61, 'Jsher', 'KÃ¶hler', 'Theodor-Heuss-StraÃŸe 34', 'Stuttgart', 'Germany', '70174', '+49 0711 2842222', 'leonekohler@surfeu.de', 5);
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
    SET FirstName = 'Robert', LastName = 'Walter'
    WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
    SET Name = 'CCR'
    WHERE Name = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT *FROM Invoice
    WHERE BillingAddress LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM Invoice
    WHERE Total BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *FROM Employee
    WHERE HireDate BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-03-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
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

DELETE Customer
    WHERE FirstName = 'Robert' AND LastName = 'Walter';

--?	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT SYSTIMESTAMP AT TIME ZONE 'EST' FROM DUAL;
--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(NAME) FROM MediaType;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(Total) FROM Invoice;
--Task – Create a function that returns the most expensive track
SELECT MAX(UnitPrice) FROM Track;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_price_invoiceline
RETURN number
IS
average number;
BEGIN
   SELECT AVG(UnitPrice) INTO average FROM InvoiceLine;
        RETURN average;
END;
/

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION return_employees
RETURN SYS_REFCURSOR
IS 
results SYS_REFCURSOR;
BEGIN
     OPEN results FOR SELECT *
         FROM Employee
         WHERE BirthDate >= TO_DATE('1969-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
         RETURN results;
END;
/ 

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE PROCEDURE first_and_last
(results OUT SYS_REFCURSOR)
IS 
BEGIN
    OPEN results FOR SELECT FirstName, LastName 
    FROM Employee;
    
END first_and_last;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
-- stored procedure
CREATE OR REPLACE PROCEDURE update_personal_info
(EmployeeId_param IN NUMBER,
    Address_param IN VARCHAR2,
    City_param IN VARCHAR2,
    State_param IN VARCHAR2,
    Country_param IN VARCHAR2,
    PostalCode_param IN VARCHAR2)
IS 
BEGIN
    UPDATE Employee SET Address = Address_param, City = City_param,
    State = State_param, Country = Country_param, PostalCode = PostalCode_param
    WHERE EmployeeId = EmployeeId_param;
END;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE man_of_emp 
(EmployeeId_param IN NUMBER, results OUT sys_refcursor)
AS 
BEGIN
  OPEN results FOR SELECT m.FirstName, m.LastName
  FROM Employee e
  INNER JOIN Employee m 
  ON m.EmployeeId = e.ReportsTo
  WHERE e.EmployeeID = EmployeeId_param ;
END man_of_emp;
/
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE comp_and_name 
(CustomerId_param IN NUMBER, results OUT sys_refcursor)
AS 
BEGIN
  OPEN results FOR SELECT FirstName, Company
  FROM Customer
  WHERE Customer.CustomerId = CustomerId_param ;
END comp_and_name;
/
--TODO
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice
(invoice_Id_param IN number)
IS
BEGIN
    DELETE FROM InvoiceLine
        WHERE InvoiceLine.InvoiceId = invoice_Id_param;
    DELETE FROM Invoice
        WHERE Invoice.InvoiceId = invoice_Id_param;
COMMIT;
END delete_invoice;
/ 

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE SEQUENCE Customer_id_seq START WITH 60;

CREATE OR REPLACE PROCEDURE new_customer_record
(
    FirstName_param IN VARCHAR2,LastName_param IN VARCHAR2,Company_param IN VARCHAR2,Address_param IN VARCHAR2,City_param IN VARCHAR2,
    State_param IN VARCHAR2,Country_param IN VARCHAR2,PostalCode_param IN VARCHAR2,Phone_param IN VARCHAR2,Fax_param IN VARCHAR2,
    Email_param IN VARCHAR2,SupportRepId_param IN NUMBER)
IS
BEGIN
    INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
    VALUES (Customer_id_seq.nextVal, FirstName_param,
    LastName_param,Company_param,Address_param,City_param,State_param,Country_param,PostalCode_param,Phone_param,Fax_param,Email_param,SupportRepId_param);
COMMIT;
END new_customer_record;
/ 
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER after_new_rec_insert 
AFTER INSERT ON Employee
FOR EACH ROW
DECLARE
BEGIN
DBMS_OUTPUT.PUT_LINE('Record successfully inserted into Employee table');
END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER after_row_in_albume_insert 
AFTER UPDATE ON Album
FOR EACH ROW
BEGIN
INSERT INTO Album (AlbumId, Title, ArtistId)
      VALUES (:new.AlbumId, :new.Title, :new.ArtistID);
DBMS_OUTPUT.PUT_LINE('Record successfully inserted into Employee table');      
END;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_row_delete
AFTER DELETE ON Album
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('Record successfully deleted into Employee table');      
END;
/
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE VIEW i_view AS SELECT * FROM invoice;
DROP TRIGGER Invoice_Trigger;
CREATE OR REPLACE TRIGGER Invoice_Trigger
INSTEAD OF DELETE ON i_view
FOR EACH ROW
BEGIN
    IF (:old.Total > 50.0)
       THEN DBMS_OUTPUT.PUT_LINE('Deletions not allowed for any invoice priced over 50 dollars');
    ELSE DELETE FROM Invoice WHERE InvoiceId = :old.InvoiceId;
    END IF;
END Invoice_Trigger;
/
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT Customer.FirstName,Customer.LastName,Invoice.InvoiceId
    FROM Customer
    INNER JOIN Invoice ON Customer.CustomerId = Invoice.CustomerId;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT Customer.CustomerId,Customer.FirstName, Customer.LastName, Invoice.InvoiceId, Invoice.total
    FROM Customer
    FULL OUTER JOIN Invoice ON Customer.CustomerId = Invoice.CustomerId;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT Artist.Name, Album.Title
    FROM Artist
    RIGHT JOIN Album ON Album.ArtistId = Artist.ArtistId;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM Artist
CROSS JOIN Album
ORDER BY Artist.name asc;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsTo column.
SELECT a.FirstName, a.LastName, a.ReportsTo
FROM Employee a, Employee b 
WHERE a.ReportsTo = b.EmployeeId
ORDER BY a.ReportsTo;
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on table of your choice
CREATE INDEX Employee_cluster ON Employee (EmployeeId, ReportsTo);
