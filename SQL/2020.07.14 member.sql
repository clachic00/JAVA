SELECT * FROM project.member;

SELECT `member`.`idx`,
    `member`.`uid`,
    `member`.`upw`,
    `member`.`uname`,
    `member`.`uphoto`,
    `member`.`regdate`
FROM `project`.`member`;

INSERT INTO project.member

(uid,upw,uname,uphoto)
VALUES

('cool',
1111,
'COOL',
null)
;
