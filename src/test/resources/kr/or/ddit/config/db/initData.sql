SELECT *
FROM NOT_EXISTS_IN_PRD;

/*DELETE users;*/

TRUNCATE TABLE users;

Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('pdm2','박다미','pass1234',to_date('2020-10-22','YYYY-MM-DD'),'dam','대전 대구 중앙로 76','영민빌딩 4층 404호','34904','D:\profile\63ef8354-1f33-4944-8ee5-ae0f06b74496','감자.PNG');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('cony','코니','conyPass',to_date('2020-10-21','YYYY-MM-DD'),'토끼',null,null,null,'D:\profile\cony.png','cony.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('sally','샐리','sallyPass',to_date('2020-10-21','YYYY-MM-DD'),'병아리',null,null,null,'D:\profile\sally.png','sally.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('james','제임스','jamesPass',to_date('2020-10-21','YYYY-MM-DD'),'사람',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('moon','문','moonPass',null,'달',null,null,null,'D:\profile\james.png','james.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('leonard','레너드','leonardPass',to_date('2020-10-15','YYYY-MM-DD'),'개구리',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('edward','에드워드','edwardPass',to_date('2020-10-15','YYYY-MM-DD'),'애벌레',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('jessica','제시카','jessicaPass',to_date('2020-10-15','YYYY-MM-DD'),'고양이',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('boss','보스','bossPass',to_date('2020-10-15','YYYY-MM-DD'),'사람',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('choco','초코','chocoPass',to_date('2020-10-15','YYYY-MM-DD'),'곰2',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('pangyo','팡요','pangyoPass',to_date('2020-10-15','YYYY-MM-DD'),'판다',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('muzi','무지','muziPass',to_date('2020-10-15','YYYY-MM-DD'),'토끼',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('con','콘','conPass',to_date('2020-10-15','YYYY-MM-DD'),'악어',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('apeach','어피치','apeachPass',to_date('2020-10-15','YYYY-MM-DD'),'복숭아',null,null,null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('ryan','라이언 ','ryanPass',to_date('2020-10-15','YYYY-MM-DD'),'사자',null,null,null,'D:\profile\ryan.png','ryan.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('brown','브라운','brownPass',to_date('2020-10-21','YYYY-MM-DD'),'곰',null,null,null,'D:\profile\brown.png','brown.png');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('pdmm','박다미','pass1234',to_date('2020-10-22','YYYY-MM-DD'),'dam','대전 대구 중앙로 76','영민빌딩 4층 404호','34904','D:\profile\2ffcf1be-a04b-41ce-9283-1aa6be46ab8d','6.jpg');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('aaa','aaa','aaa',to_date('2020-10-22','YYYY-MM-DD'),'aaa','aaa','aaa','aaa','aaa','aaa');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('bbb','bbb','bbb',to_date('2020-10-22','YYYY-MM-DD'),'bbb','대전 동구 중앙로 215',null,'34626',null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('eee','eee','eeee',to_date('2020-10-22','YYYY-MM-DD'),'eee','대전 대덕구 신탄진로 807',null,'34311','D:\profile\c0dbcf31-c4d7-4936-b98f-e42d14738625.PNG','닭고기.PNG');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('gugu','구구','guguPass',to_date('2020-10-26','YYYY-MM-DD'),'구구','충북 제천시 강명길 12','1','27201',null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('1','1','1',to_date('2020-11-05','YYYY-MM-DD'),'1','1','1','1','1','1');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('2','2','2',to_date('2020-11-05','YYYY-MM-DD'),'2','2','2','2','2','2');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('3','33','3',to_date('2020-11-05','YYYY-MM-DD'),'3','대전 대덕구 갑천도시고속도로 735','3','34335','d:\upload\감자.PNG','감자.PNG');
--Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('4','4','4',to_date('2020-11-05','YYYY-MM-DD'),'4',null,null,null,'d:\upload\',null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('5','5','5',to_date('2020-11-05','YYYY-MM-DD'),'5','5','5','5','5','5');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('111','2222','111',to_date('2020-11-05','YYYY-MM-DD'),'22','111','111','111','d:\upload\그래놀라3.PNG','그래놀라3.PNG');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('3333','3333','3333',to_date('2020-11-05','YYYY-MM-DD'),'3333','3333','3333','3333','3333','3333');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('12','12','12',to_date('2020-11-05','YYYY-MM-DD'),'12','12','12','12','12','12');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('xxx','xx','xx',to_date('2020-11-05','YYYY-MM-DD'),'xx',null,null,null,'d:\upload\닭고기.PNG','닭고기.PNG');
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME) values ('pdm','박다미','pass1234',to_date('2020-11-06','YYYY-MM-DD'),'dam','대전 대구 중앙로 76','영민빌딩 4층 404호','34904','d:\upload\4.jpg','4.jpg');

COMMIT;