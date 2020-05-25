--2020.05.22

select *
from emp
where sal > (select avg(sal) from emp;

(select deptno from emp where ename = 'SCOTT');



select *
from emp
where deptno = (select deptno from emp where ename = 'KING')
;



SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO in (SELECT DISTINCT DEPTNO
FROM EMP
WHERE SAL>=3000);

select *
from emp
where sal > (select max(sal)from emp where deptno=30)
;

select ename, sal
from emp
where sal> all(select sal from emp where deptno=30)
;

--마당서점의 고객별 판매액을 보이시오
--(결과는 고객이름과 고객별 판매액을 출력)

select name, sum(saleprice)
from orders o, customer c
where o.custid = c.custid
group by name
;

select custid, 
( select name from customer c where o.custid=c.custid
)
as custom_name, sum(saleprice)
from orders o
group by custid
;

--질의 고객번호가 2 이하인 고객의 판매액을 보이시오 (결과는 고객이름과 고객별 판매액 출력)
SELECT cs.name, SUM(od.saleprice) "total"
FROM (SELECT custid, name
FROM Customer
WHERE custid <= 2) cs,
Orders od
WHERE cs.custid=od.custid
GROUP BY cs.name;



select cs.name,  sum(od.saleprice)"total"
from (select custid, name
from customer
where custid <=2) cs,
orders od
where cs.custid = od.custid
group by cs.name
;

--평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오.

select orderid, saleprice
from orders
where saleprice <= (select avg(saleprice)from orders)
;

--질의. 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오.

select orderid, custid, saleprice
from orders
where saleprice >= (select avg(saleprice)from orders)
;

select * from orders;
select * from customer;
select * from book;

--질의. 대한민국에 거주하는 고객에게 판매한 도서의 총판매액을 구하시오.

select sum(saleprice)"total"
from orders
where custid in(select custid from customer where address Like'%대한민국%');

--질의. 3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오.

select orderid, saleprice, custid
from orders e
where saleprice > all(SELECT saleprice FROM Orders WHERE custid='3')
;

--질의. EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.

select sum(saleprice) "total"
from orders od
where exists (select * from customer cs where address Like'%대한민국%' and cs.custid =  od.custid);








