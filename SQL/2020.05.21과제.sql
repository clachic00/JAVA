--2020.05.21

--32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.

select e.deptno, d.dname from dept d, emp e 
where d.deptno = e.deptno
;

--33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.

select e.ename,d.dname,d.loc
from dept d
inner join emp e
on d.deptno = e.deptno
;

--36. 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.

select e.ename,d.dname
from dept d
natural join emp e
where e.ename like '%A%'
;

--37. JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.

select ename, job, deptno, dname
from dept
natural join emp 
where loc = 'NEW YORK'
;

--38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.

select e.ename, e.empno, m.ename as manager
from emp e, emp m
where e.mgr = m.empno
;

--39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 출력하시오.

SELECT *
FROM emp emp1 LEFT OUTER JOIN emp emp2
ON emp1.mgr = emp2.empno
order by emp1.empno desc
;

--40. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )

select emp1.ename, emp1.deptno, emp2. ename
from emp emp1, emp emp2
where emp1.deptno=emp2.deptno and emp1.ename = 'SCOTT' and emp2.ename!='SCOTT'
;


--41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.

select emp2.ename, emp2.hiredate
from emp emp1, emp emp2
where emp2.hiredate>emp1.hiredate and emp1.ename ='WARD'
;

--42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.

select emp1.ename, emp2.ename, emp1.hiredate, emp2.hiredate
from emp emp1, emp emp2
where emp1.mgr=emp2.empno and emp1.hiredate<emp2.hiredate;




