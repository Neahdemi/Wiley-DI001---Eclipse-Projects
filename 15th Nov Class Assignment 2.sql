-- The HR department wants a query to display the last name, job code,
-- hire date, and employee number for each employee, with employee number appearing first.
--  Provide an alias STARTDATE for the HIRE_DATE column.
select employee_id as 'EMPLOYEE NUMBER',last_name as 'LAST NAME',job_id as 'JOB ID' ,hire_date as 'START DATE'
from employees;

-- The HR department has requested a report of all employees and their job IDs. 
select employee_id, job_id
from employees;

-- Display the last name concatenated with the job ID (separated by a comma and space) and 
-- name the column Employee and Title.
select 
concat("Mr./Ms.",last_name,"'s job id is ",job_id) as "Employee and Title"
from employees;

-- To familiarize yourself with the data in the EMPLOYEES table, create a query to display
-- all the data from that table. Separate each column output by a comma. Name the column 
-- title THE_OUTPUT.
select
concat(employee_id,", ", first_name,", ", last_name,", ", email,", ", phone_number,", ", 
hire_date,", ", job_id,", ", salary,", ", commission_pct,", ", manager_id,", ", department_id) as "THE_OUTPUT"
from employees;

-- HR department needs a report that displays the last name and salary of employees who
-- earn more than $12,000.
select last_name, salary
from employees
where salary>12000;

-- Create a report to display the last name, job ID, and start date for the employees with
-- the last names of Matos and Taylor.
select last_name, job_id, hire_date
from employees
where last_name = "Matos" ;