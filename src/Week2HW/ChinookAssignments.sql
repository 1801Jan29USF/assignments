---------2.0 SQL Queries !!DONE
------2.1 SELECT
---Select all records from Employee table
SELECT * FROM Employee;
---Select all records from Employee table where last name is King
SELECT * FROM Employee
    WHERE LastName = 'King';
---Select all records from Employee table where first name is Andrew and ReportsTo is NULL
SELECT * FROM Employee
    WHERE FirstName = 'Andrew'
    AND ReportsTo IS NULL;
------2.2 ORDER BY
---Select all albums in Album table and sort result in descending order by title
SELECT * FROM Album
    ORDER BY Title DESC;
---Select first name from Customer and sort result set in ascending order by city
SELECT FirstName FROM Customer
    ORDER BY City;
------2.3 INSERT INTO
---Insert two new records into Genre table
INSERT INTO Genre
    VALUES(26, 'Simpsonwave');
INSERT INTO Genre
    VALUES(27, 'Softstep Mumblecore');
---Insert two new records into Employee table
INSERT INTO Employee
    VALUES (9, 'Jass', 'Hugh', 'Executive Chairman', NULL, TO_DATE('1969-2-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2014-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '619 Crude Ln', 'Boston', 'NY', 'US', '55555', '+1 (505) 867-5309', '+1 (863) 427-1242', 'hugh@chinookcorp.com');
INSERT INTO Employee
    VALUES (10, 'Jass', 'Tim', 'Shoemaker', 9, TO_DATE('2000-9-21 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2017-11-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '619 Crude Ln', 'Boston', 'NY', 'US', '55555', NULL, NULL, 'shoemaker@chinookcorp.com');
---Insert two new records into Customer table
INSERT INTO Customer
    VALUES (60, 'Lizardman', 'Lizardman', 'Lizardman Inc.', 'Lizard Cave', 'Lizard City', 'FL', 'US', '33317', NULL, NULL, 'lizardman@lizardman.lz', 1);
INSERT INTO Customer
    VALUES (61, 'Employee', 'Bored', 'Nowhere I Want to Be, LLC', 'As An Equal', 'Grayscale', 'Sad', 'Brazil', '12227-000', '+55 (12) 4217-5969', NULL, 'joke@email.com.br', 2);
------2.4 UPDATE
---Update Aaron Mitchell in Customer table to Robert Walker
UPDATE Customer
    SET FirstName = 'Robert', LastName = 'Walker'
    WHERE FirstName = 'Aaron'
    AND LastName = 'Mitchell';
---Update Creedence Clearwater Revival in Artist table to CCR
UPDATE Artist
    SET Name = 'CCR'
    WHERE Name = 'Creedence Clearwater Revival';
------2.5 LIKE
---Select all invoices with a billing address like "T%"
SELECT * FROM Invoice
    WHERE BillingAddress
    LIKE 'T%';
------2.6 BETWEEN
---Select all invoices that have a total between 15 and 50
SELECT * FROM Invoice
    WHERE Total
    BETWEEN 15 AND 50;
---Select all employees hired between 1st of june 2003 and 2st of march 2004
SELECT * FROM Employee
    WHERE HireDate
    BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-2 00:00:00','yyyy-mm-dd hh24:mi:ss');
------2.7 DELETE
---Delete a record in Customer table where the name is Robert Walker (resolve constraints)
DELETE FROM InvoiceLine
    WHERE InvoiceId IN (SELECT InvoiceId FROM Invoice
        WHERE CustomerId IN (SELECT CustomerId from Customer
            WHERE FirstName = 'Robert' AND LastName = 'Walker'));
DELETE FROM Invoice
    WHERE CustomerId IN (SELECT CustomerId FROM Customer
        WHERE FirstName = 'Robert' and LastName = 'Walker');
DELETE FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walker';
---------3.0 SQL Functions !!!DONE
------3.1 System Defined Functions
---Create a function that returns the current time
CREATE OR REPLACE FUNCTION tim
    RETURN DATE
    IS now DATE;
    BEGIN
        SELECT SYSDATE
        INTO now
        FROM DUAL;
        RETURN(now);
    END;
/
SELECT tim FROM DUAL;
---Create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION len_media(id_param IN NUMBER)
    RETURN NUMBER
    IS media_length NUMBER;
    BEGIN
        SELECT LENGTH(MediaType.Name)
        INTO media_length
        FROM MediaType
        WHERE MediaTypeId = id_param;
        RETURN media_length;
    END;
/
SELECT len_media(2) FROM DUAL;
------3.2 System Defined Aggregate Functions
---Create a function that returns the average total of all invoices !!DONE
CREATE OR REPLACE FUNCTION avg_tot
    RETURN NUMBER
    IS
    average NUMBER;
    BEGIN
        SELECT AVG(Invoice.total) INTO average FROM Invoice;
        RETURN average;
    END;
/
SELECT avg_tot FROM DUAL;
---Create a function that returns the most expensive track !!DONE
CREATE OR REPLACE FUNCTION most_expensive
    RETURN VARCHAR2
    IS track_name VARCHAR2(200);
    BEGIN
        SELECT name INTO track_name FROM Track
        ORDER BY UnitPrice DESC
        FETCH FIRST 1 ROWS ONLY;
        RETURN track_name;
    END;
/
SELECT most_expensive FROM DUAL;
------3.3 User Defined Scalar Functions
---Create a function that returns the average price of invoiceline items in the invoiceline table !!DONE
CREATE OR REPLACE FUNCTION avg_invoiceline
    RETURN NUMBER
    IS average NUMBER;
    BEGIN
        SELECT AVG(InvoiceLine.UnitPrice) INTO average FROM InvoiceLine;
        RETURN average;
    END;
/
SELECT avg_invoiceline FROM DUAL;
------3.4 User Defined Table Valued Functions !!!mostly done
---Create a function that returns all employees who are born after 1968
CREATE OR REPLACE FUNCTION not_old
    RETURN SYS_REFCURSOR
    IS
    resultset SYS_REFCURSOR;
    BEGIN
        OPEN resultset FOR SELECT FirstName FROM Employee WHERE BirthDate > TO_DATE('1968-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
        RETURN resultset;
    END;
/
SELECT not_old FROM DUAL;
---------4.0 Stored Procedures !!!DONE
------4.1 Basic Stored Procedure
---Create a stored procedure that selects the first and last names of all the employees !!DONE
CREATE OR REPLACE PROCEDURE first_and_last(results OUT SYS_REFCURSOR)AS
    BEGIN
        OPEN results FOR SELECT FirstName, LastName FROM Employee;
    END first_and_last;
/
SET SERVEROUTPUT ON;
DECLARE 
    results SYS_REFCURSOR;
    fname VARCHAR2(20);
    lname VARCHAR2(20);
BEGIN
    first_and_last(results);
    LOOP
        FETCH RESULTS INTO fname, lname;
        EXIT WHEN results%notfound;
        dbms_output.put_line(fname||', '||lname);
    END LOOP;    
END;
/
------4.2 Stored Procedure Input Parameters
---Create a stored procedure that updates the personal information of an employee !!DONE
CREATE OR REPLACE PROCEDURE update_emp_phone (new_phone IN VARCHAR2, emp_id IN NUMBER) AS
    BEGIN
        UPDATE Employee
        SET Phone = new_phone
        WHERE EmployeeId = emp_id;
    END update_emp_phone;
/
SELECT * FROM Employee WHERE EmployeeId = 8;
EXECUTE update_emp_phone('1', 8);
SELECT * FROM Employee WHERE EmployeeId = 8;
---Create a stored procedure that returns the managers of an employee !!DONE
CREATE OR REPLACE PROCEDURE get_managers (emp_id IN NUMBER, managers OUT SYS_REFCURSOR) AS
    BEGIN
        OPEN managers FOR SELECT reportsTo FROM Employee WHERE EmployeeId = emp_id;
    END;
/
SET SERVEROUTPUT ON;
DECLARE 
    results SYS_REFCURSOR;
    manager_id NUMBER;
    emp_id NUMBER;
BEGIN
    emp_id := 4;
    get_managers(emp_id, results);
    LOOP
        FETCH results INTO manager_id;
        EXIT WHEN results%notfound;
        dbms_output.put_line('ID of manager of Employee ID '||emp_id||' is '||manager_id);
    END LOOP;    
END;
/
------4.3 Stored Procedure Output Parameters
---Create a stored procedure that returns the names and company of a customer !!DONE
CREATE OR REPLACE PROCEDURE get_name_company (cust_id IN NUMBER, results OUT SYS_REFCURSOR) AS
    BEGIN
        OPEN results FOR SELECT Firstname, Company FROM Customer WHERE CustomerId = cust_id;
    END;
/
SET SERVEROUTPUT ON;
DECLARE 
    results SYS_REFCURSOR;
    cust_id NUMBER;
    cust_fname VARCHAR(20);
    cust_comp VARCHAR(80);
BEGIN
    cust_id := 19;
    get_name_company(cust_id, results);
    LOOP
        FETCH results INTO cust_fname, cust_comp;
        EXIT WHEN results%notfound;
        dbms_output.put_line('Customer ID '||cust_id||' is '||cust_fname||' with the company '||cust_comp);
    END LOOP;    
END;
/
---------5.0 Transactions !!!DONE
---Create a transaction that given an invoiceid, will delete that invoice (resolve constraints)
DECLARE
    invoiceid_to_delete NUMBER;
BEGIN
    invoiceid_to_delete := 45;
    DELETE FROM InvoiceLine WHERE InvoiceId = invoiceid_to_delete;
    DELETE FROM Invoice WHERE InvoiceId = invoiceid_to_delete;
END;
/
---Create a transaction nested within a stored procedure that inserts a new record in the customer table !!DONE
CREATE OR REPLACE PROCEDURE insert_into_customer AS
    BEGIN
        INSERT INTO Customer VALUES(100, 'Literal', 'Mr.', 'something', null, null, null, null, null, null, null, 'idontexist@mail.gg)', null);
    END;
/
EXECUTE insert_into_customer;
---------6.0 Triggers !!!DONE
------6.1 AFTER/FOR
---Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER insert_trig
AFTER INSERT ON Employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('INSERTION ON EMPLOYEE DETECTED');
END;
/
---Create an after update trigger on the album table that fires after a row is updated in the table
DROP TRIGGER update_trig;
CREATE OR REPLACE TRIGGER update_trig
AFTER UPDATE ON Employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('UPDATE IN ALBUM DETECTED');
END;
/
---Create an after delete trigger on the customer table that fires after a row is deleted from the table
DROP TRIGGER delete_trig;
CREATE OR REPLACE TRIGGER delete_trig
AFTER DELETE ON Employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('DELETION FROM CUSTOMER DETECTED');
END;
/
------6.2 INSTEAD OF
---Create an isntead of trigger that restrictss the deletion of any invoice that is priced over 50 dollars
DROP TRIGGER delete_inst_trig;
CREATE OR REPLACE TRIGGER delete_inst_trig
BEFORE DELETE ON Invoice
FOR EACH ROW
BEGIN
    IF :old.Total > 50 THEN
    INSERT INTO Invoice VALUES(:old.InvoiceId, :old.CustomerId, :old.InvoiceDate, :old.BillingAddress, :old.BillingCity, :old.BillingState, :old.BillingCountry, :old.BillingPostalCode, :old.Total);
    END IF;
END;
/
---------7.0 Joins !!!DONE
------7.1 INNER
---Create an inner join that joins cucstomers and orders and specifies the name of the customer and the invoiceid
SELECT Customer.FirstName, Invoice.InvoiceId
    FROM Customer INNER JOIN Invoice
    ON Invoice.CustomerId = Customer.CustomerId;
------7.2 OUTER
---Create an outer join that joins the customer and invoice table, specifying customerid, firstname, lastname, invoiceid, total
SELECT CustomerId, FirstName, LastName, InvoiceId, Total
    FROM Customer OUTER NATURAL JOIN Invoice;
------7.3 RIGHT
---Create a right join that joins album and artist specifying artist name and title
SELECT Name, Title
    FROM Album RIGHT NATURAL JOIN Artist;
------7.4 CROSS
---Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT *
    FROM Album CROSS JOIN Artist
    ORDER BY Artist.Name ASC;
------7.5 SELF
---Perform a self-join on the employee table, joining on the reportsto column
SELECT *
    FROM Employee a, Employee b
    WHERE a.reportsTo = b.EmployeeId;
---------8.0 Indexes !!!DONE
------8.1 Clustered Indexes
---Create a clustered index on of table of your choice
CREATE CLUSTER cl_track_artist(ArtistId NUMBER, TrackName VARCHAR2(80));
CREATE INDEX ind_track_artist
    ON CLUSTER cl_track_artist;
exit;