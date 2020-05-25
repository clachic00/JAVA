--2020.05.22

select * from customer;
select * from orders;
select * from book;



--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.

--(5) 박지성이구매한도서의출판사수

select count(distinct bk.publisher)

from book bk

where bk.bookid in (select od.bookid from orders od where od.custid in (select cs.custid from customer cs where name = '박지성'));





--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이

select bk.bookname, od.saleprice, bk.price-od.saleprice

from book bk, orders od

where bk.bookid in (select od.bookid from orders od where od.custid in (select cs.custid from customer cs where name = '박지성'))
and od.bookid = bk.bookid
;

--(7) 박지성이구매하지않은도서의이름

select bk.bookname

from book bk

where bk.bookid != all (select od.bookid from orders od where od.custid in (select cs.custid from customer cs where name = '박지성'));




--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.

--(8) 주문하지않은고객의이름(부속질의사용)

select cs.name
from customer cs 
where cs.custid != all (select od.custid from orders od)
;

--(9) 주문금액의총액과주문의평균금액
SELECT sum(saleprice), avg(saleprice)
FROM orders
;

--(10) 고객의이름과고객별구매액

select cs.name, sum(nvl(od.saleprice,0))
from customer cs left join orders od
on cs.custid in(select od.custid from orders od)
and cs.custid= od.custid
group by cs.name
;

--(11) 고객의이름과고객이구매한도서목록

select cs.name, (select bookname from book bk where bk.bookid = od.bookid)
from customer cs left join orders od
on cs.custid in(select od.custid from orders)
and cs.custid= od.custid

;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문 ?


select od.orderid, max(bk.price - od.saleprice)
from book bk left join orders od
on bk.bookid=od.bookid
group by od.orderid
having max(bk.price - od.saleprice)
=(select max(max(bk.price - od.saleprice))
from book bk left join orders od
on bk.bookid=od.bookid
group by od.orderid)
;



--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름 ?

SELECT NAME, avg
FROM (SELECT NAME, AVG(saleprice) AVG FROM CUSTOMER C, ORDERS O WHERE C.CUSTID =  O.CUSTID GROUP BY NAME)
where avg>(select avg(saleprice)
                from orders)
;

--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select cs2.name

from orders od2, book bk2, customer cs2
where bk2.publisher in (select distinct bk.publisher
from book bk
where bk.bookid in (select od.bookid from orders od where od.custid in (select cs.custid from customer cs where name = '박지성')))

and od2.bookid=bk2.bookid
and od2.custid=cs2.custid
and name!='박지성'
;

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름


select cs2.name
from orders od2, book bk2, customer cs2
where od2.bookid=bk2.bookid and od2.custid=cs2.custid
group by cs2.name
HAVING count(distinct publisher)>1
;