USE wileyDI001;

SELECT * FROM EMPLOYEES;

-- Display the last name and salary of employees who earn between 
-- $5,000 and $12,000 and are in department 20 or 50. Label the columns
-- Employee and Monthly Salary, respectively.
SELECT LAST_NAME AS 'Employee', SALARY AS 'Monthly Salary'
FROM EMPLOYEES
WHERE (SALARY BETWEEN 18000 AND 30000) 
AND (DEPARTMENT_ID = 102 OR DEPARTMENT_ID = 105); -- USE IN DEPARTMENT

-- The HR department needs a report that displays the last name
-- and hire date for all employees who were hired in 1994.
SELECT LAST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE "2022%";

-- Create a report to display the last name and job Id 
-- of all employees who do not have a manager.
SELECT LAST_NAME, JOB_ID 
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL;

-- Create a report to display the last name, salary, and 
-- commission of all employees who earn commissions.
SELECT LAST_NAME, SALARY, COMMISSION_PCT AS "Comission"
FROM EMPLOYEES
WHERE COMMISSION_PCT > 0;

-- Change the last name of employee 3 to Drexler.
SET SQL_SAFE_UPDATES = 0;

update employees
set last_Name = "Drexler"
where employee_Id BETWEEN 9092 and 9094;

-- Change the salary to $1,000 for all employees who have a salary less than $900.
update employees
set salary = 25100
where salary < 25000;

-- Delete Betty Dancs from the EMPLOYEE table
delete from employees
where last_name = "Taylor" and first_name = "Rick";

-- Empty the table EMPLOYEE (DOT NOT RUN THIS UNLESS I WANT TO LOSE ALL MY DATA)
delete from employees;

