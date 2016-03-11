drop table Employee;
CREATE TABLE Employee (
  id number(11) constraint emp_pk111 primary key,
  name varchar(20) NOT NULL,
  role varchar(20) NOT NULL
) ;