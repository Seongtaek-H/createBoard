create table board (
	articleNO integer auto_increment primary key,
	group_no int(10),
	depth int(10) default 0,
	title varchar(50) not null,
	content varchar(1000) not null,
	id varchar(10) not null,
	writeDate timestamp default now()
)default character set utf8 collate utf8_general_ci;

insert into board(title, content, id) values('첫번째 게시글','첫번째 내용','guest1');
insert into board(title, content, id) values('두번째 게시글','두번째 내용','guest2');
insert into board(title, content, id) values('세번째 게시글','세번째 내용','guest3');

select * from board;
select articleNO,title,content,id,writeDate from board order by articleNO desc;

drop table board;