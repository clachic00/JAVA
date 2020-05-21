--2020.05.18



SELECT * FROM emp order by sal desc;

SELECT * FROM dept where deptno > 20;

select * from emp where sal > = 3000;

--전체 사원중 10번 부서의 소속 사원과 이름과 직급을 출력

select ename, job from emp where deptno = 10;

select * from emp where deptno is null;

select * from emp
where hiredate = '80-12-17';

--논리 연산자 : and
--10번 부서 소속인 사원들 중에서
--직급이 manager인 사람을 검색하여
--사원명, 부서번호, 직급을 출력하려고 한다면
--조건1 : 10번 부서 소속 -> deptno = 10
--조건2 : job = 'manager'

select * from emp
where not deptno = 10 and job = 'MANAGER';

select * from emp
where comm in(300, 500, 1400);


--논리 연산자 : or
--직급이 manager이고 부서번호는 10
--사원명, 부서번호, 직급을 출력합시다.
--조건1 : 10번 부서 소속 - > deptno = 10
--조건2 : job'MANAGER

select * from emp
where deptno = 10 or job = ' MANAGER';

--논리연산자 : not
--부서번호가 10번이 아닌 사원의
--사원이름, 부서본호, 직급을 출력

select *
from emp
--where deptno!=10;
--where deptno<>10;
where not deptno =10;

--범위 연산자 : between A and B -> A 이상 B이하
--2000에서 3000 사이의 급여를 받는 사원의 정보를 출력

select *
from emp
where sal between 2000 and 3000;


-- 2000을 초과하고 3000 미만의 급여를 받는 사원
--sal >2000 and sal <3000
--sal between 2001 and 2999

select * from emp
where sal between 2001 and 2999;

SELECT
    *
FROM emp
where hiredate >= '1987-01-01'and hiredate<='1987-12-31'; -- 1987년 이후


-- or 연산을 간소화 시키는 in 연사자
--컬럼 이름 IN(데이터1, 데이터2, 데이터3,...)
--컬럼=데이터1 or 컬럽=데이터2 or 컬럼 =  데이터3 or...

SELECT
    *
FROM emp 
where comm in(300, 500, 1400);

-- 패턴검색 : like 연산자
-- 컬럼이름 like 패턴
-- 패턴 : %,_
-- _->1개의 자리수에 어떠한 문자가 와도 가능하다

SELECT *
FROM EMP
WHERE ENAME LIKE '_A%';


SELECT *
FROM EMP
WHERE ENAME LIKE '_A%' order by nvl(comm,0) asc
;

--null 값 확인을 위한 연산자 : is null, is not null
--컬럼명 is null : 해당 컬럼의 값이 null 인경우 true
--컬럼명 is not null : 해당 컬럼의 값이 null이 아닌경우 true

select ename, nvl(comm,0)
from emp
where comm is null;

--row의 정렬
--오름차순 : 큰쪽에서 작은쪽, asc (생략 가능, 기본 값)
--내림차순 : 작은쪽에서 큰쪽, desc (명시적 사용)

SELECT ename, sal, hiredate, comm
FROM EMP
ORDER BY SAL DESC, ENAME ASC;




