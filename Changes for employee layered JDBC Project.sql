
use wileydi001;

select * from employee;

alter table employee
add doj date;

set SQL_SAFE_UPDATES=0;
update employee
set doj="2018-12-11"
where department="Sales";

update employee
set doj="2021-05-28"
where department="Marketing";

update employee
set doj="2019-05-28"
where department="IT";

update employee
set doj="2008-05-28"
where department="Finance";

update employee
set doj="2002-05-28"
where department="HR";