CREATE TABLE members (
    member_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (member_id)
);

CREATE TABLE committees (
    committee_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (committee_id)
);

INSERT INTO members(name)
VALUES('John'),('Jane'),('Mary'),('David'),('Amelia');

INSERT INTO committees(name)
VALUES('John'),('Mary'),('Amelia'),('Joe');

select * from members;

select * from committees;

-- we chose m as the alias for members and c as the alias for comittee
select member_id,m.name,committee_id,c.name
from members m inner join committees c
USING(name);

select * from emp;

select * from dept;

select empId,name,e.deptId,deptName,location,designation,salary
from emp e inner join dept d
USING(deptId);


alter table emp
change deptId dept_id varchar(10);

select * from dept;

select * from emp;

select empId,name,dept_id,deptName,location,designation,salary
from emp e inner join dept d
on e.dept_id=d.deptId;

-- shows the primary and foregin keys as well as the constraint name
SELECT TABLE_NAME, CONSTRAINT_TYPE, CONSTRAINT_NAME
FROM information_schema.table_constraints
WHERE table_name='emp';

alter table emp
drop constraint deptId_FK;

describe emp;

insert into emp
values(6,"FFFF","D010","Associate",56000);

select empId,name,dept_id,deptName,location,designation,salary
from emp e left join dept d
on e.dept_id=d.deptId;

select empId,name,dept_id,deptName,location,designation,salary
from emp e right join dept d
on e.dept_id=d.deptId;

select empId,name,dept_id,deptName,location,designation,salary
from emp e join dept d
on e.dept_id=d.deptId;

select empId,name,dept_id,deptName,location,designation,salary
from emp e cross join dept d;

select * from emp;

select * from department;