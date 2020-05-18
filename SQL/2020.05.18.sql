//2020.05.18


select job, sal, empno from emp;

select * from emp order by MGR desc;

select * from tab;



select * from dept;

select * from tab;

--emp : 사원정보
--dept : 부서정보
--bonus : 임시테이블
--salgrade ; 급여 테이블

--테이블의 구조 확인 : desc 테이블이름

desc emp;
desc dept;
desc salgrade;

SELECT * FROM emp;
SELECT * FROM dept;

--데이터 검색 질의

select ename, sal, deptno -- 컬럼 이름
from emp -- 테이블 이름

;
select *from dept;

SELECT deptno FROM dept;

--컬럼의 산술 연산이 가능하다. +-*/ mod 함수 이용

select * from emp;

select ename, sal,comm, sal + comm from emp;

select ename, sal, sal+500 from emp;

select ename, sal, sal-100 from emp;

select ename, sal, sal*12 from emp;

select ename, sal, sal/2 from emp;

select ename, sal, comm, sal*12+comm, sal*12+nvl(comm, 0) as Annsal from emp;

-- null 값 치환 함수 : nvl(컬럼명, 기본값)
--기본값은 컬럼의 도메인의 자료형과 같아야 한다.

select ename, job, sal, nvl(comm, 0), sal*12  from emp;

select ename || ' is a ' || job from emp;

--출력 컬럼의 중복을 제거하고 하나씩만 출력 : distict

select deptno from emp;

select distinct deptno, job from emp;

