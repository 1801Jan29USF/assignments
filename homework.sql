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
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer ORDER BY city;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO genre (genreid, NAME) VALUES (26, 'electro-swing');
INSERT INTO genre (genreid, NAME) VALUES (27, 'heavy dubstep');
--Task – Insert two new records into Employee table
INSERT INTO employee (employeeid, firstname, lastname) VALUES (5000, 'matt','mark');
INSERT INTO employee (employeeid, firstname, lastname) VALUES (5001, 'bella','french');
--Task – Insert two new records into Customer table
INSERT INTO customer (customerid, firstname, lastname, email) VALUES (5000, 'matt','mark','myemail');
INSERT INTO customer (customerid, firstname, lastname, email) VALUES (5001, 'summer','briel','heremail');
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
select * from invoice where billingaddress like 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between TO_DATE('2003/06/01', 'yyyy/mm/dd') and TO_DATE('2004/03/01', 'yyyy/mm/dd');
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--
alter table invoice
drop constraint FK_InvoiceCustomerId;
delete from customer where firstname = 'Robert' and lastname = 'Walter';
--3.0	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
create or replace function get_time
return timestamp 
is
begin
    return SYSTIMESTAMP;
end;
/
select get_time from dual;
--Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function mediatype_length
(media_id_param number)
return number
is
tempname varchar2(500);
begin
    select name into tempname from mediatype where mediatypeid = media_id_param;
    return length(tempname);
end;
/
select * from mediatype where MEDIATYPEID = 2;
select mediatype_length(2) from dual;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
create or replace function average_invoice
return number
is
average number;
begin
    select avg(total) into average from invoice;
    return average;
end;
/
select average_invoice from dual;
--Task – Create a function that returns the most expensive track
create or replace function most_expensive_track
return sys_refcursor
is
tempcur sys_refcursor;
begin
    open tempcur for select name from track where (select max(unitprice) from track) = unitprice;
    return tempcur;
end;
/
select most_expensive_track from dual;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function average_invoice_line
return number
is
average number;
begin
    select avg(unitprice) into average from invoiceline;
    return average;
end;
/
select average_invoice_line from dual;
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
create or replace function young_employees
return sys_refcursor
is
results sys_refcursor;
begin
    open results for select * from employee where birthdate >= DATE '1968-01-01';
    return results;
end;
/
select young_employees from dual;
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
create or replace procedure get_names
(results OUT sys_refcursor)
is
begin 
    open results for select firstname, lastname from employee;
end get_names;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure update_info
(param_id in number, param_fname in varchar2, param_lname in varchar2)
is
begin 
    update employee set firstname = param_fname, lastname = param_lname where employeeid = param_id;
end update_info;
/
--Task – Create a stored procedure that returns the managers of an employee.
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure get_customer
(param_id in number, param_fname out varchar2, param_lname out varchar2, param_company out varchar2)
is
begin 
    select firstname, lastname, company into param_fname, param_lname, param_company from customer where customerid = param_id;
end get_customer;
/
--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
alter table invoiceline drop constraint FK_InvoiceLineInvoiceId;
delete from invoice where invoiceid = 1;
commit;
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure get_customer
(param_id in number, param_fname in varchar2, param_lname in varchar2, param_company in varchar2)
is
begin 
    insert into customer (firstname, lastname, company, customerid) values (param_fname, param_lname, param_company, param_id);
end get_customer;
/
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger new_hire
after insert on employee
begin
    dbms_output.put_line('new hire');
end;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger new_album
after insert on employee
begin
     dbms_output.put_line('new album');
end;
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger customer_cancel
after delete on customer
begin
    dbms_output.put_line('customer canceled');
end;
/
--
--6.2 INSTEAD OF
--Task – Create an instead of trigger that restricts the deletion of any invoice that is priced over 50 dollars.
create or replace trigger customer_protection
before delete on invoice
referencing old as old
for each row
begin
    if :old.total > 50 then
        rollback;
    end if;
end;
/
--7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select firstname, lastname, invoiceid from customer inner join invoice using (customerid);
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select CustomerId, firstname, lastname, invoiceId, total from customer outer join invoice using (customerid);
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
select name, title from album right join artist using (artistid);
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from artist cross join album order by artist.name;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
select * from employee a, employee b where a.reportsto = b.employeeid;
--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Clustered Indexes
--Task – Create a clustered index on of table of your choice
create index mycluster2 on track (trackid, name);
--9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.


--Task – Create a .bak file for the Chinook database.
