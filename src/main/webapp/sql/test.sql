CREATE TABLE `t_member` (
  `id` varchar(30) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

CREATE TABLE `t_board` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `p_bno` int DEFAULT '0',
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `imgName` varchar(45) DEFAULT NULL,
  `regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id` varchar(45) NOT NULL,
  PRIMARY KEY (`bno`),
  KEY `id_idx` (`id`)
);

INSERT INTO `t_board` 
VALUES (1,0,'안녕하세요','인서트 테스트입니다.',NULL,'2020-08-14 13:05:35','coco');
,(2,0,'안녕하세요2','인서트 테스트입니다.',NULL,'2020-08-14 13:05:41','coco')
,(3,0,'안녕하세요3','인서트 테스트입니다.',NULL,'2020-08-14 13:05:42','coco')
,(4,0,'hong입니다.','인서트 테스트입니다.',NULL,'2020-08-14 13:06:18','hong')
,(5,0,'hong입니다2','인서트 테스트입니다.',NULL,'2020-08-14 13:06:20','hong')
,(6,0,'toto입니다.','스포츠 토토 아니에요.',NULL,'2020-08-14 13:06:51','toto')
,(7,0,'toto입니다.','시네마천국 토토요',NULL,'2020-08-14 13:07:02','toto')
,(8,7,'저도 그 영화 좋아하는데','엔니오 모리꼬네!',NULL,'2020-08-14 13:07:37','coco')
,(9,7,'조선 최고의 흥행작이죠 ','이따리오루',NULL,'2020-08-14 13:08:00','hong')
,(10,1,'코코님 하이!','친하게 지내요',NULL,'2020-08-14 13:08:25','hong')
,(11,4,'길동님 하이!','오늘 밤은 출동 안 하시낭?',NULL,'2020-08-14 13:10:24','coco')
;
