--Part I – Working with an existing database
--
--?	Setting up Oracle Chinook
--In this section you will begin the process of working with the Oracle Chinook database
--Task – Open the Chinook_Oracle.sql file and execute the scripts within.
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
--Task – Create a function that returns the most expensive trac
SELECT MAX(UnitPrice) FROM Track;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT AVG(UnitPrice) FROM InvoiceLine;
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT *FROM Employee
    WHERE BirthDate >= TO_DATE('1969-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
--TODO
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--TODO
--Task – Create a stored procedure that returns the managers of an employee.
--TODO
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
--TODO
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--TODO
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--TODO
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--TODO
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--TODO
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--TODO
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--TODO
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
--TODO
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
SELECT Employee.FirstName AS Employee1_First, Employee.LastName AS Employee1_Last, 
    Employee.FirstName AS Employee2_First, Employee.LastName AS Employee2_Last, Employee.ReportsTo
    FROM Employee
    WHERE Employee.EmployeeID <> Employee.EmployeeID
    AND Employee.EmployeeID = Employee.ReportsTo
    ORDER BY Employee.ReportsTo;


--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
--Task – Create a .bak file for the Chinook database.
--3.1 SELECT
--Task – Select all the rows from the employees table
--Task – Select all the rows from the employees table where the Department is HR
--Task – Select all the rows from the employees table where username is jsmith and department is HR
--Task – Select all the rows from the employees table where manager is true or department is HR
--3.2 ORDER BY
--Task – Select name from product table and order by name in ascending order.
--Task – Select name from product table and order by name in descending order.
--Task- Select all records from category table order by name.
--3.3 INSERT INTO
--Task – Insert a new row into the employees table.
--Task – Insert into a new row into the category table
--Task – Insert three records into the supplier table.
--3.4 UPDATE
--Task – Update unit cost in products table where name is ruler
--Task – Update the description of computer and cleaning supplies in the Category table.
--3.5 LIKE
--Task – Select username from employees table where username is like “j”
--Task – Select name from product table where name is like “O”
--3.6 BETWEEN
--Task – Select name from products table where unitprice is between 3 and 10
--Task – Select name from products table where unit price is between 500 and 800
--3.7 DELETE
--Task – Delete a record from the category where the value is audio visual
--Task – Delete the three records you previously inserted into the supplier table  
--
--
--?	SQL Functions
--In this section your will be using the system defined functions built into Oracle 10g as well as creating your own user defined functions
--4.1 System Defined Scalar Functions
--Task – create a function that returns the length of the string of the description of the laser pointer
--Task – Create a function the converts a username in the employees table to upper case.
--4.2 System Defined Aggregate Function
--Task – Create a function that gets the sum of the unitprice column from the products table
--Task – Create a function that gets the count of all the products in the products table
--4.3 User Defined Scalar Functions
--Task – Create a function that takes two inputs (unit price of products) and calculates the cost of the two products
--4.4 User Defined Table Valued Functions
--Task – Create a function that returns whether or not a username belongs to a manager
--?	Stored Procedures
--In this section you will be creating stored procedures, including stored procedures that have input and output parameters, and return values.
--5.1 Basic Stored Procedure
--Task – Create a store procedure that returns all employees with the username, dept, and manager columns from the employees table. Call the procedure to get the result set.
--Task – Create a stored procedure that returns all the products with the name, and unitprice column from the products table.
--5.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that takes in a productID and gets the name and description of that productID
--Task – Create a stored procedure that insert a new manager into the employees table
--
--5.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that calculates the value of the unit cost column in the products table and returns the total amount 
--Task – Create a procedure that would return username and password based on employeeID
--?	Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure and contain exaction handling functionality.  You will also work with error handling in a transaction.
--Task- Create a transaction that is nested inside a stored procedure that inserts a new record into the employees table.
--Task – Create a transaction that is nested inside a stored procedure that updates the untitprice of a product in the products table.
--Task – create a multi-statement transaction nested in a stored procedure that updates at least two records’ name and description in the category table 
--?	Triggers
--In this section you will be creating triggers on various tables. You will work with AFTER/FOR triggers and INSTEAD OF triggers. 
--7.1 AFTER/FOR Triggers
--Task - Create an after insert trigger on the categories table fired after a new record is inserted into the table.
--Task – Create an after update trigger on the categories table that fires after a row is inserted in the table
--Task – Create an after delete trigger on the categories table that fires after a row is deleted from the table.
--7.2 INSTEAD OF Triggers
--Task – create an instead of delete trigger on the Products table that restricts the deletion of any records that are priced below 500 dollars.
--?	JOINS
--In this section you will be performing joins on various tables. You will to populate each table with data. Pay attention to keys and referential integrity when inserting data into your tables. 
--8.1 INNER JOIN
--Task – Perform an inner join on tables product and category
--Task – Perform an inner join on tables employee and orders
--8.2 OUTER JOIN
--Task – Perform an outer join on tables products and orderitems
--Task – Perform an outer join on tables employee and orders
--
--8.3 RIGHT JOIN
--Task – Perform a right join on tables orders and orderitems
--Task – Perform a left join on tables product and orderitems
--
--8.4 LEFT JOIN
--Task – Perform a left join on tables product and category
--Task – Perform a left join on tables employees and orders
--
--8.5 CROSS JOIN
--Task – Perform a cross join on tables product and category
--8.6 SELF-JOIN
--Task – using the employees table perform a self-join. You can break up the table as needed.
--?	Views
--View can be thought of as virtual tables. In this section you will create views to enhance the security of your database. 
--Task – create two new columns named SSN and salary on the employees table. Create a view that displays all columns except SSN and salary
--Task – Create a view on the products table that only displays only the name of the product and the description.
--?	Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--10.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
--?	Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
--Task – Create a .bak file for the OfficeSupply database
--
--
--
--
--






