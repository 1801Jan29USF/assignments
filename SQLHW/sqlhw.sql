--Select all records from the Employee table.
SELECT * FROM employee;

--Select all records from the Employee table where last name is King.
SELECT * FROM employee WHERE lastname='King';

--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE firstname='Andrew' AND reportsto IS NULL;

--Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title DESC;

--Select first name from Customer and sort result set in ascending order by city.
SELECT firstname FROM customer ORDER BY city ASC;

--Insert two new records into Genre table
INSERT INTO genre (genreid, NAME) VALUES (26,'Gangster Rap');
INSERT INTO genre (genreid, NAME) VALUES (27,'Trap');

--Insert two new records into Employee table
INSERT INTO employee (employeeid ,lastname,firstname ,title ,reportsto,birthdate,hiredate,address,city ,STATE,country,postalcode,phone,fax,email)
VALUES(9,'Worker','Hard','Help Desk Tech',2,
            TO_DATE('1991-08-29 09:09:10','yyyy-mm-dd hh24:mi:ss'),
            TO_DATE('2018-05-15 08:15:32','yyyy-mm-dd hh24:mi:ss'),'1234 Hialeah Drive','Hialeah','Florida','USA','33018','+1 (786)-245-9921','+1 (786)-245-9921','rick@yahoo.com');
            
INSERT INTO employee (employeeid ,lastname,firstname ,title ,reportsto,birthdate,hiredate,address,city ,STATE,country,postalcode,phone,fax,email)
VALUES(10,'Working','Hardly','Software Engineer',4,
            TO_DATE('1991-09-07 10:10:25','yyyy-mm-dd hh24:mi:ss'),
            TO_DATE('2018-04-13 09:00:00','yyyy-mm-dd hh24:mi:ss'),'1243 Miami Drive','Miami','Florida','USA','33135','+1 (786)-335-9831','+1 (786)-335-9831','dick@yahoo.com');


--Insert two new records into Customer table
INSERT INTO customer(customerid, firstname, lastname, company, address, city, STATE, country, postalcode, phone, fax, email, supportrepid)
 VALUES(666,'Devil','MayCry','Capcom','666 Evil Drive East','Badland','Hell','USA','666666','+1 (786)-111-3941','+1 (786)-111-3941','Iambad@capcom.com',4);
       
INSERT INTO customer(customerid, firstname, lastname, company, address, city, STATE, country, postalcode, phone, fax, email, supportrepid)
 VALUES(357,'Mike','Jones','Unemployed Rappers','444 NonYa Business','Nowhere','Alaska','USA','111222','+1 (786)-777-9997','+1 (786)-777-9997','whois@mikejones.com',3);

-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname='Robert', lastname='Walter'
WHERE firstname='Aaron' AND lastname='Mitchell';

-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';


-- Select all invoices with a billing address like “T%”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

-- Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 20;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN '01/June/2003' AND '01/March/2004';

-- Delete a record in Customer table where the name is Robert Walter 
-- (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM customer
WHERE firstname='Robert' AND lastname='Walter';

-- Create a function that returns the current time.
CREATE OR REPLACE FUNCTION current__time
RETURN VARCHAR2
IS
currenttime VARCHAR2(50);
BEGIN
    SELECT to_char(sysdate, 'HH:MI:SS') INTO currenttime 
    FROM dual;
    RETURN currenttime;
END;
/
SELECT current__time() AS "Current Time" FROM dual;

-- create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION length_of_mediatype(le_of NUMBER)
RETURN NUMBER
IS
lengthofmediatype NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO lengthofmediatype FROM mediatype
        WHERE mediatypeid = le_of;
    RETURN lengthofmediatype;
END;
/

SELECT length_of_mediatype(1) AS "Length of Mediatype" FROM dual;

-- Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION average_of_total
RETURN NUMBER
IS
average NUMBER;
BEGIN
    SELECT AVG(total) INTO average FROM invoice;
    RETURN average;
END;
/
SELECT CAST(average_of_total() AS NUMERIC(10,2)) AS "Total average" FROM dual;

-- Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive
RETURN NUMBER
IS
max_price NUMBER;
BEGIN
    SELECT MAX(unitprice) INTO max_price FROM track;
    RETURN max_price;
END;
/

SELECT most_expensive() AS "Price of most expensive track " FROM dual;

-- Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION average_price_invoiceline
RETURN NUMBER
IS
average NUMBER;
BEGIN
    SELECT AVG(unitprice)  INTO average  FROM invoiceline;
    RETURN average;
END;
/
SELECT CAST(average_price_invoiceline() AS NUMERIC(10,2)) AS "Average unit price" FROM dual;

-- Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION born_after
RETURN SYS_REFCURSOR
IS
results SYS_REFCURSOR;
BEGIN
    OPEN results FOR SELECT birthdate FROM employee    
    WHERE birthdate > '31/Dec/1968';
    RETURN results;
END;
/
SELECT born_after() FROM dual;


-- Create a stored procedure that selects the first and last names of all the employees.

-- Create a stored procedure that updates the personal information of an employee.

-- Create a stored procedure that returns the managers of an employee.
 
-- Create a stored procedure that returns the name and company of a customer.


-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;
DELETE FROM invoice WHERE invoiceid = 282;

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer
(customerid NUMBER,
    firstname VARCHAR2,
    lastname VARCHAR2,
    company VARCHAR2,
    address VARCHAR2,
    city VARCHAR2,
    STATE VARCHAR2,
    country VARCHAR2,
    postalcode VARCHAR2,
    phone VARCHAR2,
    fax VARCHAR2,
    email VARCHAR2,
    supportrepid NUMBER)
IS
BEGIN 
    INSERT INTO customer VALUES(customerid, firstname, lastname, company, address,
    city, STATE, country , postalcode, phone, fax, email,supportrepid);
END insert_customer;
/


-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER insert_trig
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('New employee has been hired.');
END;
-- Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER update_trig
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    dbms_output.put_line('New album has been added.');
END;
/

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER delete_trig
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    dbms_output.put_line('You are no longer a customer.');
END;
/
-- Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.

-- INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, invoiceid FROM customer
INNER JOIN invoice USING(customerid);

-- OUTER
-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customerid , firstname, lastname, invoiceid, total FROM customer
OUTER JOIN invoice USING(customerid);

-- RIGHT
-- Create a right join that joins album and artist specifying artist name and title.
SELECT artist.NAME, album.title FROM album
RIGHT JOIN artist ON artist.artistid = album.artistid;

-- CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT NAME FROM album
CROSS JOIN artist 
ORDER BY NAME ASC; 

-- SELF
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT e1.lastname||' reports to '||e2.lastname AS "Employees and their Managers"
FROM employee e1, employee e2
WHERE e1.reportsto = e2.employeeid;

-- Create a clustered index on of table of your choice
CREATE INDEX trk_albm
ON track (trackid,albumid);

