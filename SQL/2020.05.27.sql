--2020.05.27

--자주 사용되는 30번 부서에 소속된사원들의 사번과 이름과 부서번호를 출력하기 위한 SELECT문을 하나의 뷰로 정의해 봅시다.


create view emp_view_deptno30
as
select empno, ename,deptno from emp where deptno =30;

--뷰는 테이블에 접근(SELECT)한 것과 동일한 방법으로 결과를 얻을 수 있습니다.

SELECT * FROM emp_view_deptno30;

SELECT VIEW_NAME, TEXT
FROM USER_VIEWS;



--1.다음은 ROWNUM 칼럼 값을 출력하기 위한 쿼리문입니다.
SELECT ROWNUM, EMPNO, ENAME, HIREDATE FROM EMP;

--2. 입사일이 빠른 사람 5명만(TOP-N)을 얻어오기 위해서는 일련의 출력 데이터를
--일단 임의의 순서로 정렬한 후에 그 중 일부의 데이터만 출력할 수 있도록 해야 하므로 
--ORDER BY 절을 사용하여 입사일을 기준으로 오름차순 정렬해 봅시다.

SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE;

--3. 이번에는 입사일을 기준으로 오름차순 정렬을 하는 쿼리문에 ROWNUM 칼럼을 출력해 봅시다.

SELECT ROWNUM, EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE;

--1. 입사일을 기준으로 오름차순 정렬한 쿼리문으로 새로운 뷰를 생성해 봅시다.

CREATE OR REPLACE VIEW VIEW_HIRE AS SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE;

--2. 입사일을 기준으로 오름차순 정렬을 하는 뷰에 ROWNUM 칼럼을 함께 출력해 봅시다.

SELECT ROWNUM, EMPNO, ENAME, HIREDATE FROM VIEW_HIRE;

--3. 이제 입사일이 빠른 사람 5명만을 얻어와 봅시다.

SELECT ROWNUM, EMPNO, ENAME, HIREDATE FROM VIEW_HIRE WHERE ROWNUM<=5;



--------------------------------------------------------------------------------------

-- sequence : 번호 자동 생성기

--------------------------------------------------------------------------------------


--create sequence 시퀀스이름
--start with 시작값 0 시작
--increment by 증가값 1
--maxvalue 최대값
--minvalue 최소값
--cycle | nocycle 반복 여부
--cache | nocache

--부서번호 deptno 의 sequence 생성

create sequence dept_deptno_seq01;

select dept_deptno_seq01.nextval
from dual;

select dept_deptno_seq01.currval
from dual;
