--2020.05.26

drop table dept01;

create table sam02(
year01 interval year(3) to month);

create table dept01(
    deptno number(4),
    dname Varchar2(10),
    loc varchar2(20)
);

create table dept01
as
select * from dept where 1<0
;

insert into dept01(deptno, dname, loc) values(10,'ACCOUNTING','NEW YORK');


INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (10, 'ACCOUNTING');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES(10, 'ACCOUNTING', 'NEW YORK', 20);

INSERT INTO DEPT01 (NUM, DNAME, LOC) VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES(10, ACCOUNTING, 'NEW YORK');

select * from dept01;

insert into dept01(deptno, dname, loc) values(20,'DESIGN','PUSAN');

insert into dept01( loc, deptno, dname) values('LONDON',30,'SALES');

INSERT INTO DEPT01 (DEPTNO, DNAME)VALUES(40, 'DEV');

DESC DEPT01;


CREATE TABLE DEPT02(
    DEPTNO NUMBER(2) NOT NULL,
    DNAME VARCHAR2(20) NOT NULL,
    LOC VARCHAR2(20) DEFAULT 'SEOUL'
);


INSERT INTO DEPT02 (deptno, dname, loc) values(10,'MARKETING','SEOUL');
INSERT INTO DEPT02 (deptno, dname) values(40,'DEV');

INSERT INTO DEPT02 (deptno, dname, loc) values(20,'MARKETING',NULL);
INSERT INTO DEPT02 (deptno, dname, loc) values(30,'MARKETING','');

SELECT * FROM DEPT02 ORDER BY DEPTNO;

desc dept01;
select * from dept01;

desc dept02;
select * from dept02;


insert into dept02 (dname, loc)values('test','locTest');
insert into dept02 (dname, deptno)values('test',60);
















