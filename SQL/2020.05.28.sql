--2020.05.28





---------------------------------------------------------------------

-- INDEX

---------------------------------------------------------------------

--검색을 빠르게 하기위해 사용한다.
--DML 작업에는 성능 저하가 올 수 있다.

DESC USER_IND_COLUMNS;

SELECT INDEX_NAME, TABLE_NAME , COLUMN_NAME FROM USER_IND_COLUMNS WHERE TABLE_NAME IN('EMP', 'DEPT');

--테스트 테이블 생성

DROP TABLE EMP01;

CREATE TABLE EMP01
AS
SELECT * FROM EMP
;

INSERT INTO EMP01 SELECT * FROM EMP01;

INSERT INTO EMP01 (EMPNO, ENAME) VALUES (1111,'SON');
INSERT INTO EMP01 (EMPNO, ENAME) VALUES (2222,'PARK');


SELECT * FROM EMP01 WHERE ENAME = 'SON';
SELECT * FROM EMP01 WHERE ENAME = 'PARK';


--INDEX 생성
--CREATE INDEX 인덱스이름 ON 테이블이름 (컬럼이름)

CREATE INDEX EMP01_ENAME_INDEX ON EMP01(ENAME);





