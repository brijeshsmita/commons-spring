drop table department;
drop table role;
drop table project;
drop table employee;

drop SEQUENCE SEQ_DEPT;
drop SEQUENCE SQ_PROJECT;
select deptId from department;

======================================================
DEPARTMENT
create table department
(
deptId number(10) constraint dept_pk21 primary key,
deptName varchar2(30) not null,
deptDesc varchar2(100)
);
//sucessfull



create SEQUENCE SEQ_DEPT
START WITH 10
INCREMENT BY 10;

drop SEQUENCE SEQ_DEPT;

insert into department values(SEQ_DEPT.NEXTVAL,'Oracle','Oracle Programming');

insert into department values(SEQ_DEPT.NEXTVAL,'.NET','.NET Programming');

select * from department;

=================================================================================================
PROJECT.....


create table project
(
projectId number(10) constraint project_pk5 primary key,
projectName varchar2(30) not null,
projectDescription varchar2(100),
deptId number(10) constraint deptid_fk references department(deptid)
on delete cascade
);


create SEQUENCE SQ_PROJECT
START WITH 100
INCREMENT BY 1;

drop SEQUENCE SQ_PROJECT;

insert into project values(SQ_PROJECT.NEXTVAL,'BankDb','Oracle Database',10);
insert into project values(SQ_PROJECT.NEXTVAL,'HotelDb','Oracle Database',20);
insert into project values(SQ_PROJECT.NEXTVAL,'BankDb','SQL Database',10);


select * from project;
=======================================================================================================================

ROLE...

create table role
(
roleId number(10) constraint role_pk6 primary key,
roleName varchar2(30) not null,
roleDesc varchar2(100)
);

drop table role;

create SEQUENCE SEQ_ROLE
START WITH 1001
INCREMENT BY 1
NOCACHE
NOCYCLE;

drop SEQUENCE SEQ_ROLE;

insert into role values(SEQ_ROLE.NEXTVAL,'Programmer','SystemUser');
insert into role values(SEQ_ROLE.NEXTVAL,'Administrator','AdminUser');

select * from role;




======================================================================================================================
EMPLOYEE........

create table employee
(
empId number(10) constraint sq_emp1 primary key,
empName varchar2(20) not null ,
kinId varchar2(20) unique not null,
emailId varchar2(50) unique not null,
 phoneNo varchar2(20) unique not null,
 dob date, 
 doj date,
 address varchar2(100),
 deptId number(10) constraint deptid_fk1 references department(deptId),
 projectId number(10) constraint proj_fk1 references project(projectId) 
 on delete cascade,
 roleId number(10) constraint role_fk1 references role(roleId)
 );

create SEQUENCE SEQ_EMP
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE; 

drop SEQUENCE SEQ_EMP;


insert into employee values(SEQ_EMP.NEXTVAL,'Nilesh','KIN11','nilesh.ge@cg.com','+9165486556','11-dec-1993','29-dec-2015','Pune',10,100,1001);
insert into employee values(SEQ_EMP.NEXTVAL,'Sailee','KIN12','saile.ge@cg.com','+91787846','05-march-1993','29-dec-2015','Mumbai',10,101,1002);
insert into employee values(SEQ_EMP.NEXTVAL,'Smith','KIN13','smith.ge@cg.com','+9178784667','07-march-1993','29-dec-2010','UP',20,102,1001);


select * from employee;

======================================================================================================================
 select * from role;
 select * from project;
 select * from department;
select * from employee;

delete from project where projectId=100;
select * from project where projectId=100;


create table EMS(
name varchar(50),
username varchar(10),
password varchar(10));

insert into EMS values('riya','riya','123');
insert into EMS values('siya','siya','123');
insert into EMS values('tiya','tiya','123');

select * from EMS;
