use wileyDI001;

create table Department(
DEPARTMENT_ID int primary key,
DEPARTMENT_NAME varchar(30) not null,
MANAGER_ID int,
LOCATION_ID int);

create table Jobs(
JOB_ID varchar(10) primary key,
JOB_TITLE varchar(35) not null,
MIN_SALARY int,
MAX_SALARY int);
 
create table Employees(
EMPLOYEE_ID int primary key, 
FIRST_NAME varchar(20),
LAST_NAME varchar(25) not null,
EMAIL varchar(20) not null,
PHONE_NUMBER varchar(20),
HIRE_DATE date not null,
JOB_ID varchar(10) not null,
SALARY double,
COMMISSION_PCT double,
MANAGER_ID int, 
DEPARTMENT_ID int,
constraint DEPARTMENT_ID_FK
foreign key (DEPARTMENT_ID)
references Department(DEPARTMENT_ID),
constraint JOB_ID_FK
foreign key (JOB_ID)
references Jobs(JOB_ID));

describe Department;
describe Jobs;
describe Employees;

insert into Department
values(101, 'Sales', 9876, 234567),
(102, 'IT', 3573, 948245),
(103, 'Finance', 3563, 964323),
(104, 'Banking', 7632, 555322),
(105, 'Customer Service', 7842, 912301);

select * from Department;

insert into Jobs
values(201, 'Executive', 80000, 120000),
(302, 'Sr. Executive', 120000, 160000),
(403, 'Director', 160000, 300000),
(504, 'Manager', 40000, 65000),
(605, 'CSA', 19000, 22000);

select * from Jobs;

-- Date structure is 'YYYY-MM-DD'

insert into Employees
values(9092, 'Neah', 'Demi', 'Neahdemi@wiley.com', '07483627483', '2022-10-10', 201, 25000, 10000, 2345, 101),
(9093, 'Ava', 'Croft', 'Ava@wiley.com', '07483463283', '2019-10-10', 302, 50000, 40000, 7432, 102),
(9094, 'Lewis', 'Smith', 'Lewis@wiley.com', '07483633321', '2002-10-10', 403, 80000, 20000, 4323, 103),
(9095, 'George', 'Vasi', 'George@wiley.com', '07483699976', '2008-10-10', 504, 120000, 50000, 8753, 104),
(9096, 'Angelos', 'Barnet', 'Angelos@wiley.com', '07483627000', '2022-11-10', 605, 19000, 100, 6323, 105);

insert into employees
values(9097, 'Lina', 'Matos', 'Lina@wiley.com', '07483888976', '2011-10-10', 201, 100000, 9000, 8753, 104),
(9098, 'Megan', 'Taylor', 'Megan@wiley.com', '07773699976', '2001-10-10', 605, 20000, 200, 8753, 103),
(9099, 'Rick', 'Matos', 'Rick@wiley.com', '07483499976', '2009-10-10', 403, 250000, 50000, 8753, 102);

select * from Employees;



