create table web_id_tbl(
	webid varchar2(100) not null,
	pwd varchar2(40) not null,
	platform varchar2(20),
	joindate varchar2(50),
	primary key(webid)
);

create table game_id_tbl(
	gameid varchar2(100) not null,
	pwd varchar2(40) not null,
	platform varchar2(20),
	joindate varchar2(100),
	primary key(gameid)
);

create table sns_id_tbl(
	snsid varchar2(100) not null,
	pwd varchar2(40) not null,
	platform varchar2(20),
	joindate varchar2(100),
	primary key(snsid)
);

DROP TABLE sns_id_tbl;

select * from WEB_ID_TBL;

select webid 
from web_id_tbl w,game_id_tbl g,sns_id_tbl s


