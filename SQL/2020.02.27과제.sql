--2020.05.27

drop table phoneInfo_basic;
drop table phoneInfo_univ;
drop table phoneInfo_com;


--외래키 설정시 부모의 행이 삭제 될 때 설정
--references phoneinfo_basic(idx) on delete 설정 옵션
--no action : 모두 삭제
-- cascade : 참조를 하고 있는 자식 테이블의 모든 행도 삭제
-- set null : 참조를 하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 null로 변경
--set default : 참조를 하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 기본값으로 변경





create table phoneinfo_basic(
    idx number(6) constraint phoneinfo_basic_idx_pk primary key,
    fr_name varchar2(20) not null,
    fr_phonenumber varchar2(20) not null,
    fr_email varchar2(20),
    fr_address varchar2(20),
    fr_regdate date default sysdate
);
    
create table phoneinfo_univ(
    idx number(6) constraint phoneinfo_univ_idx_pk primary key,
    fr_u_major varchar2(20) default 'n' constraint phoneinfo_univ_fr_u_major_nn not null ,
    fr_u_year number(1) default '1' not null,
    fr_ref number(7) not null,
    constraint phoneinfo_univ_fr_ref_fk foreign key(fr_ref) references phoneinfo_basic(idx),
    constraint phoneinfo_univ_fr_u_year_ck check (fr_u_year between 1 and 4)
);

create table phoneinfo_com(
    idx number(6) constraint phoneinfo_com_idx_pk primary key,
    fr_c_company varchar2(20) default 'N' not null,
    fr_ref number(6) not null,
    constraint phoneinfo_com_fr_ref_fk foreign key(fr_ref) references phoneinfo_basic(idx)
);
    
    select* 
    from phoneinfo_basic;

---------------------------------------------------------------------------------
-- 입력 DML
---------------------------------------------------------------------------------

-- 학교 친구 정보 입력 순서
-- 1. 기본 친구 정보 테이블 데이터 입력
-- 2. 학교 친구 정보 테이블 데이터 입력


insert into phoneinfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address ) values(1,'박지성','010-0000-0000','aaa@gmail.com','서울 종로구');

insert into phoneinfo_univ(idx, fr_u_major, fr_u_year, fr_ref) values(1, '맨유', 4 ,1);

insert into phoneinfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address ) values(PB_BASIC_IDX_SEQ.nextval,'이동국','010-0000-0003','ccc@gmail.com','서울 강남구');

insert into phoneinfo_univ(idx, fr_u_major, fr_u_year, fr_ref) values(PB_BASIC_IDX_SEQ.nextval, '전북', 3 ,pb_basic_idx_seq.currval);

insert into phoneinfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address ) values(5,'홍병보','010-0000-0005','eee@gmail.com','서울');

insert into phoneinfo_univ(idx, fr_u_major, fr_u_year, fr_ref) values(PB_BASIC_IDX_SEQ.nextval, '서울', 2 ,pb_basic_idx_seq.currval);



-- 회사 친구 정보 입력 순서
-- 1. 기본 친구 정보 테이블 데이터 입력
-- 2. 회사 친구 정보 테이블 데이터 입력



insert into phoneinfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address ) values(2,'손흥민','010-0000-0001','bbb@gmail.com','부산');


insert into phoneinfo_com(idx, fr_c_company, fr_ref) values(1, '토트넘', 2);


insert into phoneinfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address ) values(PB_BASIC_IDX_SEQ.nextval,'이천수','010-0000-0004','ddd@gmail.com','대구');


insert into phoneinfo_com(idx, fr_c_company, fr_ref) values(PB_BASIC_IDX_SEQ.nextval, '울산', PB_BASIC_IDX_SEQ.currval);


---------------------------------------------------------------------------------
-- 친구 정보 출력 질의
---------------------------------------------------------------------------------

-- 1. 전체 친구 목록 출력
--    테이블 3개 JOIN

select* 
from phoneinfo_basic pb, phoneinfo_univ pu,phoneinfo_com pc
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)  
order by pb.idx asc
;

-- 2. 학교 친구 목록 출력
select* 
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref 
;
-- 3. 회사 친구 목록 출력
 select* 
from phoneinfo_basic pb,phoneinfo_com pc
where pb.idx=pc.fr_ref
;   


---------------------------------------------------------------------------
-- 수정을 위한 sql
---------------------------------------------------------------------------
rollback;
--1. 회사 친구 정보를 수정

update phoneinfo_com 
set fr_c_company=(select fr_c_company from phoneinfo_com where fr_ref=2)
where fr_c_company='울산'
;

update phoneinfo_basic
set fr_name =(select fr_name from phoneinfo_basic where idx=4)
where idx =(select fr_ref from phoneinfo_com where fr_c_company = '토트넘' )
;
--2. 학교 친구 정보를 수정

update phoneinfo_univ 
set (fr_u_major,fr_u_year)=(select fr_u_major,fr_u_year from phoneinfo_univ where fr_ref=1)
where fr_ref=5
;
update phoneinfo_basic
set fr_name =(select fr_name from phoneinfo_basic where idx=3)
where idx =(select fr_ref from phoneinfo_univ where fr_u_major = '맨유' )
;


---------------------------------------------------------------------------
-- 삭제를 위한 sql
---------------------------------------------------------------------------
--1. 회사 친구 정보를 삭제



delete from phoneinfo_com 
where fr_ref=2
;

delete from phoneinfo_basic
where idx=2;




--2. 학교 친구 정보를 삭제



delete from phoneinfo_univ
where fr_ref=5
;

delete from phoneinfo_basic
where idx=5;

----------------------------------------------------------------------


-- 1. 전체 친구 목록 출력
--    테이블 3개 JOIN

select* 
from phoneinfo_basic pb, phoneinfo_univ pu,phoneinfo_com pc
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)  
order by pb.idx asc
;

-- 2. 학교 친구 목록 출력
select* 
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref 
;
-- 3. 회사 친구 목록 출력
 select* 
from phoneinfo_basic pb,phoneinfo_com pc
where pb.idx=pc.fr_ref
;   

--view

-- 1. 전체 친구 목록 출력
create or replace view pb_all_view
as 
select pb.idx, pb.fr_name, pb.fr_email, pb.fr_address, pb.fr_regdate, pu.fr_u_major, pu.fr_u_year, pc.fr_c_company
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)  
;
-- 2. 학교 친구 목록 출력

create or replace view pb_univ_view
as
select pb.idx, pb.fr_name,pb.fr_phonenumber,pb.fr_email,pb.fr_address,pb.fr_regdate,pu.fr_u_major,pu.fr_u_year
from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref 
;
-- 3. 회사 친구 목록 출력

create or replace view pb_com_view
as
select pb.idx, pb.fr_name,pb.fr_phonenumber,pb.fr_email,pb.fr_address,pb.fr_regdate,pc.fr_c_company
from phoneinfo_basic pb,phoneinfo_com pc
where pb.idx=pc.fr_ref
;   


---------------------------------------------------------
-- sequence 생성
---------------------------------------------------------
-- 1. basic 테이블 seq
create sequence pb_basic_idx_seq start with 0 MINVALUE 0;

-- 2. com 테이블 seq
create sequence pb_com_idx_seq start with 0 MINVALUE 0;

-- 3. univ 테이블 seq
create sequence pb_univ_idx_seq start with 0 MINVALUE 0;








