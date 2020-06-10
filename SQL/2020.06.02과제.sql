--2020.06.02

select * from dept;


drop table dept01;

create table dept01
as SELECT  * FROM dept;


drop table emp01;

create table emp01
as SELECT  * FROM emp;



--1. 아래 조건에 맞는 DDL을 작성하시오.

--===== 전화번호 부( 테이블 이름 : Contact )
------ 기본정보(not null)
-- 대리키 : 일련번호 -> pIdx 기본키로 설정
-- 이름, 전화번호, 주소, 이메일 
-- 주소값과 이메일은 입력이 없을 때 기본값 입력
-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능

------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임



drop table contact;
drop table phoneinfo_univ;
drop table phoneinfo_com;
drop table phoneinfo_cafe;

create table Contact(
    idx number(6) constraint Contact_idx_pk primary key,
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_enamil varchar2(20) default '미입력',
    fr_address varchar2(20) default '미입력',
    fr_friendtype varchar2(20) constraint Contact_fr_friendtype_ck check (fr_friendtype in('univ' , 'com' , 'cafe')));
    
    
create table phoneinfo_univ(
    idx number(6) constraint phoneinfo_univ_idx_pk primary key,
    fr_u_major varchar2(20) default 'n' constraint phoneinfo_univ_fr_u_major_nn not null ,
    fr_u_year number(1) default '1' not null,
    fr_ref number(7) not null,
    constraint phoneinfo_univ_fr_ref_fk foreign key(fr_ref) references contact(idx),
    constraint phoneinfo_univ_fr_u_year_ck check (fr_u_year between 1 and 4)
);
 
create table phoneinfo_com(
    idx number(6) constraint phoneinfo_com_idx_pk primary key,
    fr_c_company varchar2(20) default 'N' not null,
    fr_c_dname varchar2(20) not null,
    fr_c_job varchar2(20) not null,
    fr_ref number(6) not null,
    constraint phoneinfo_com_fr_ref_fk foreign key(fr_ref) references contact(idx)
);

create table phoneinfo_cafe(
    idx number(6) constraint phoneinfo_cafe_idx_pk primary key,
    fr_ca_cafename varchar2(20) not null ,
    fr_ca_nickname varchar2(20) not null,
    fr_ref number(7) not null,
    constraint phoneinfo_cafe_fr_ref_fk foreign key(fr_ref) references contact(idx)
  
);

--2. DEPT 테이블에 데이터를 삽입하는 SQL을 작성하시오. 입력 데이터는 임의로 작성하시오.

insert into dept
(deptno, dname, loc)values(80,'SALESMAN','SEOUL');

--3. DEPT 테이블에 위에서 삽입한 데이터의 dname, loc 데이터를 변경하는 SQL을 작성하시오.
--입력 데이터는 임의로 작성하시오.

UPDATE DEPT
SET LOC='JAPAN',DNAME='PRESIDENT' 
WHERE DEPTNO=80;

--4. DEPT 테이블에 위에서 삽입한 데이터를 deptno 컬럼의 값을 기반으로 삭제하는 SQL을 작성하시오.

DELETE FROM DEPT
WHERE DEPTNO = 80;

--5. 사용자가 보유한 테이블 목록을 확인하는 SQL문을 작성하시오.

SELECT * FROM TAB;

--6. EMP 테이블의 구조를 확인하는 SQL을 작성하시오.

DESC EMP;

--7. 사용자가 정의한 제약조건들을 확인하는 SQL문을 작성하시오.

SELECT * FROM ALL_CONSTRAINTS;



--#2 아래 요구사항에 맞도록 고급 SQL 문을 작성하시오.
--1. EMP 테이블의 ename 컬럼에 인덱스를 생성하는 SQL을 작성하시오. 인덱스의 이름은 emp_index

CREATE INDEX EMP_INDEX
ON EMP(ENAME);

--2. EMP 테이블과 DEPT 테이블을 조인하는 SQL을 기반으로 view 객체를 생성하는 SQL을 작성하시오.
--view 의 이름은 emp_view 로 하시오. 

CREATE VIEW EMP_VIEW
AS 
SELECT emp.empno, 
       emp.ename, 
       emp.sal, 
       emp.comm, 
       emp.mgr, 
       emp.job, 
       emp.hiredate, 
       emp.deptno as deptno, 
       dept.dname, 
       dept.loc 
FROM EMP, DEPT 
WHERE EMP.DEPTNO=DEPT.DEPTNO;


--3. EMP 테이블에서 모든 사원의 부서번호를 이름이 'SCOTT'인 사원의 부서번호로 변경하는 SQL을 작성하시오.


update emp01
set deptno=(select deptno from emp01 where ename='SCOTT');



