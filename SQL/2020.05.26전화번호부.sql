--2020.05.26

--전화번호 관리 프로그램

--이름, 전화번호, 생일, 이메일
--전공, 학년
--부서이름, 직급
--모임이름, 닉네임
--대리키 : 일련번호 -> pidx
--전화번호 부 (contact)

--create table phoneinfo(
--    pidx number(6) constraint phoneinfo_pidx_pk primary key,
--    name varchar2(20) constraint phoneinfo_name_nn not null,
--    phonenumber varchar2(20) constraint phoneinfo_phonenumber_nn not null,
--    birthday varchar2(20) constraint phoneinfo_birthday_nn not null,
--    enamil varchar2(10) constraint phoneinfo_email_nn not null
--
--);
--
--create table phoneunivinfo(
--    pidx number(6) constraint phoneunivinfo_pidx_pk primary key,
--    major varchar(20) ,
--    year number(1),
--    constraint phoneunivinfo_pidx_fk foreign key(pidx) references phoneinfo(pidx),
--    constraint phoneunivinfo_year_ck check (year in('1','2','3','4'))
--       
--);
--
--create table phonecompanyinfo(
--    pidx number(6) constraint phonecompanyinfo_pidx_pk primary key,
--    company varchar(20) ,
--    job varchar(20),
--    constraint phonecompanyinfo_pidx_fk foreign key(pidx) references phoneinfo(pidx)
--    
--);
--
--create table phonecafeinfo(
--    pidx number(6) constraint phonecafeinfo_pidx_pk primary key,
--    cafename varchar(20),
--    nickname varchar(20),
--    constraint phonecafeinfo_pidx_fk foreign key(pidx) references phoneinfo(pidx)
--    
--);
    
--contact

create table Contact(
    pidx number(4) constraint contact_pidx_pk primary key,
    pbname varchar2(20) not null,
    pbnumber varchar2(13) not null,
    pbaddr varchar2(30) default '입력없음' not null,
    pbenamil varchar2(30) default '입력없음' not null,
 
    pbmajor varchar2(20) ,
    pbyear number(1),

    pbcompany varchar2(20) ,
    pbjob varchar2(20),

    pbcafename varchar2(20),
    pbnickname varchar2(20),
   
    pbtype varchar2(4),
    constraint contact_pbtype_ck check (pbtype in('univ','com','cafe')),
    constraint contact_pbyear_ck check (pbyear in('1','2','3','4'))
);
  
  





-- 명세서  
    
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
    
    -- phonebook 테이블명세서 DDL : 2020.05.26

drop table phoneInfo_basic;
drop table phoneInfo_univ;
drop table phoneInfo_com;

--create table phoneInfo_basic (
--    idx number(6),
--    fr_name varchar2(20) not null,
--    fr_phonenumber varchar2(20) not null,
--    fr_email varchar2(20),
--    fr_address VARCHAR2(20),
--    fr_regdate date default sysdate,    
--    constraint pb_idx_pk primary key(idx)    
--);
-- 
--create table phoneInfo_univ (
--    idx number(6),
--    fr_u_major varchar2(20) default 'N' not null,
--    fr_u_year number(1) default 1 not null,
--    fr_ref number(6),
--    constraint pu_idx_pk primary key(idx),
--    constraint pu_fr_u_year_ck check (fr_u_year between 1 and 4),
--    constraint pu_fr_ref_fk foreign key(fr_ref) REFERENCES phoneInfo_basic(idx)    
--);
-- 
--create table phoneInfo_com(
--    idx number(6),
--    fr_c_company varchar2(20) default 'N' not null,
--    fr_ref number(6),
--    constraint pc_idx_pk primary key(idx),
--    constraint pc_fr_ref_fk foreign key(fr_ref) REFERENCES phoneInfo_basic(idx)  
--);

---------------------------------------------------------------------------------
-- 입력 DML
---------------------------------------------------------------------------------

-- 학교 친구 정보 입력 순서
-- 1. 기본 친구 정보 테이블 데이터 입력
-- 2. 학교 친구 정보 테이블 데이터 입력


insert into phoneinfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address ) values(1,'박지성','010-0000-0000','aaa@gmail.com','서울 종로구');

insert into phoneinfo_univ(idx, fr_u_major, fr_u_year, fr_ref) values(1, '맨유', 4 ,1);

insert into phoneinfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address ) values(3,'이동국','010-0000-0003','ccc@gmail.com','서울 강남구');

insert into phoneinfo_univ(idx, fr_u_major, fr_u_year, fr_ref) values(2, '전북', 3 ,3);

insert into phoneinfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address ) values(5,'홍병보','010-0000-0005','eee@gmail.com','서울');

insert into phoneinfo_univ(idx, fr_u_major, fr_u_year, fr_ref) values(3, '서울', 2 ,5);



-- 회사 친구 정보 입력 순서
-- 1. 기본 친구 정보 테이블 데이터 입력
-- 2. 학교 친구 정보 테이블 데이터 입력



insert into phoneinfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address ) values(2,'손흥민','010-0000-0001','bbb@gmail.com','부산');


insert into phoneinfo_com(idx, fr_c_company, fr_ref) values(1, '토트넘', 2);


insert into phoneinfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address ) values(4,'이천수','010-0000-0004','ddd@gmail.com','대구');


insert into phoneinfo_com(idx, fr_c_company, fr_ref) values(2, '울산', 4);


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
    