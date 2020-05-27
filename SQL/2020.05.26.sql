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


--서브쿼리를 이용해서 여로 테이블에 한번에 데이터 삽입
--테스트 테이블 emp_hir : empno, ename, hiredate
--테스트 테이블 emp_mgr : empno, ename, mgr

create table emp_hir
as
select empno, ename, hiredate from emp where 1<0;


create table emp_mgr
as
select empno, ename, mgr from emp where 1<0;

desc emp_hir;
desc emp_mgr;

--두개 테이블에 emp 테이블의 데이터를 기반으로 삽입

insert all
into emp_hir values (empno, ename, hiredate)
into emp_mgr values (empno, ename, mgr)
select empno, ename, hiredate, mgr 
from emp
;

select * from emp_hir;
select * from emp_mgr;

--INSERT ALL 명령문에 WHEN 절을 추가해서 조건을 제시하여 
--조건에 맞는 행만 추출하여 테이블에 추가합니다.
--1982년 01월 01일 이후에 입사한 사원들의 번호, 사원명, 입사일을 추가합니다.
--emp_sal 테이블에는 
--급여가 2000이상인 사원들의 번호, 사원명, 급여를 추가합니다.

create table emp_hir02
as
select empno, ename, hiredate from emp where 1<0;

create table emp_sal
as
select empno, ename, sal from emp where 1<0;

desc emp_hir02;
desc emp_sal;

insert all
when hiredate> '82/01/01' then
    into emp_hir02 values(empno, ename, hiredate)
when sal >= 2000 then
    into emp_sal values(empno, ename, sal)
select empno, ename, hiredate, sal 
from emp
;

select * from emp_hir02;
select * from emp_sal;



drop table emp01;

create table emp01
as
select * from emp;



select * from emp01;

--1. 모든 사원의 부서번호를 30번으로 수정합시다.
UPDATE EMP01 SET DEPTNO=30;

--2. 이번엔 모든 사원의 급여를 10% 인상시키는 UPDATE 문을 보겠습니다.
update emp01
set sal = sal + sal*0.01;

--3. 모든 사원의 입사일을 오늘로 수정하려면 다음과 같이 합니다. 

update emp01
set hiredate = sysdate;


select* from emp01;

--1.부서번호가 10번인 사원의 부서번호를 30번으로 수정합시다.

update emp01
set deptno =30
where deptno =10;

--2. 급여가 3000 이상인 사원만 급여를 10% 인상합시다.

update emp01
set sal = sal *1.1
where sal>=3000;

rollback;


--3. 1987년에 입사한 사원의 입사일이 오늘로 수정합시다. 
--사원의 입사일을 오늘로 수정한 후에 테이블 내용을 살펴봅시다.


update emp01
set hiredate = sysdate
where substr(hiredate, 1, 2)='87'
;

--1.SCOTT 사원의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정하도록 합시다.
UPDATE EMP01 SET DEPTNO=20, JOB='MANAGER' WHERE ENAME='SCOTT';

select* from emp01;

--2.SCOTT 사원의 입사일자는 오늘로, 급여를 50 으로 커미션을 4000 으로 수정합시다.
UPDATE EMP01 SET HIREDATE = SYSDATE, SAL=50, COMM=4000 WHERE ENAME='SCOTT';


--1. 20번 부서의 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다.

select * from dept01;

UPDATE DEPT01 SET LOC=(SELECT LOC FROM DEPT01 WHERE DEPTNO=40) WHERE DEPTNO=20;

--1. 부서 번호가 20번인 부서의 이름과 지역은 RESEARCH와 DALLAS입니다.
--다음은 부서번호가 20인 부서의 부서명과 지역명을 부서 번호가 40번인 부서와 동일하게 변경하기 위한 UPDATE 명령문입니다.

UPDATE DEPT01 SET (DNAME, LOC)=(SELECT DNAME, LOC FROM DEPT WHERE DEPTNO=40) WHERE DEPTNO=20;




--DELETE 문으로 부서 테이블의 모든 행을 삭제합시다.
-- delete from 테이블 이름 where 행을 찾을 조건식
-- where 절이 없으면 모든행에 영향을 준다.

DELETE FROM DEPT01;

--부서 테이블에서 30번 부서만 삭제합시다.
delete from dept01 where deptno =30;

rollback;

--사원 테이블에서 부서명이 SALES인 사원을 모두 삭제해봅시다.
DELETE FROM EMP01 WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');









