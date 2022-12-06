/*
1.Find the highest, lowest, sum, and average salary of all employees. 
Label the columns Maximum, Minimum, Sum, and Average, respectively.
2.Display the minimum, maximum, sum, and average salary for each job type.
3.Write a query to display the number of people with the same job.
4.Determine the number of managers without listing them. Label the column Number of Managers.
5.Find the difference between the highest and lowest salaries. Label the column DIFFERENCE.
*/
SELECT * FROM EMPLOYEES;

-- 1.
SELECT MIN(SALARY) "Minimum Salary in Entire Organisation",
MAX(SALARY) "Maximum Salary in Entire Organisation",
AVG(SALARY) "Average Salary in an Organisation"
FROM EMPLOYEES;

-- 2.
SELECT MIN(SALARY) "Minimum Salary in Department 101",
MAX(SALARY) "Maximum Salary in Department 101",
AVG(SALARY) "Average Salary in Department 101"
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 101;

SELECT MIN(SALARY) "Minimum Salary in Department 102",
MAX(SALARY) "Maximum Salary in Department 102",
AVG(SALARY) "Average Salary in Department 102"
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 102;

SELECT MIN(SALARY) "Minimum Salary in Department 103",
MAX(SALARY) "Maximum Salary in Department 103",
AVG(SALARY) "Average Salary in Department 103"
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 103;

SELECT MIN(SALARY) "Minimum Salary in Department 104",
MAX(SALARY) "Maximum Salary in Department 104",
AVG(SALARY) "Average Salary in Department 104"
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 104;

SELECT MIN(SALARY) ,
MAX(SALARY) ,
AVG(SALARY) JOB_ID
FROM EMPLOYEES 
GROUP BY JOB_ID;

-- 3.
SELECT JOB_ID, COUNT(*) AS ROWAMOUNT
FROM EMPLOYEES
GROUP BY JOB_ID;

-- 4.
select job_title, count(job_title) "Number of people with manager job"
from jobs
group by job_title;

-- 5.
SELECT MAX(salary) - MIN(salary) 
AS Difference 
FROM employees;

-- Assignment 4
-- 1
select max(salary) "Maximum", min(salary) "Minimum", sum(salary) "Sum", avg(salary) "Average" from employees;

-- 2
select job_id "Job ID", max(salary) "Maximum", min(salary) "Minimum", sum(salary) "Sum", avg(salary) "Average" from employees group by job_id;

-- 3
select job_id, count(job_id) from employees group by job_id;

-- 4
-- select count(distinct manager_id) "Number of Managers" from employees;
select count(distinct job_id) "Number of Jobs" from employees;

-- 5
select (max(salary) - min(salary)) "Difference" from employees;

