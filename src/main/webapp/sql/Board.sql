create table board (
	articleNO int auto_increment primary key,
	groupNO int(10),
	depth int(10) default 0,
	title varchar(50) not null,
	content varchar(1000) not null,
	id varchar(10) not null,
	writeDate timestamp default now()
)default character set utf8 collate utf8_general_ci;


insert into board(title, content, id) values('첫번째 게시글','첫번째 내용','guest1');
insert into board(title, content, id) values('두번째 게시글','두번째 내용','guest2');
insert into board(title, content, id) values('세번째 게시글','세번째 내용','guest3');
insert into board(articleNO, title, content, id) values(1,'세번째 게시글','세번째 내용','guest3');

insert into board(groupNO,title, content, id) values((select last_insert_id()+1),'세번째 게시글','세번째 내용','guest3');

select * from board;
select articleNO,title,content,id,writeDate from board order by articleNO desc;
select title,content,id,writeDate from board where articleNO=2;
update board set title="수정",content="수정테스트",id="테스트" where articleNO=20;

SELECT @ROWNUM:=@ROWNUM+1, A.*
FROM board A, (SELECT @ROWNUM:=0) R
;

ALTER TABLE board AUTO_INCREMENT=1;

drop table board;