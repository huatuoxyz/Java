
create database king_db;

grant all on king_db.* to king@localhost identified by 'password';

drop table users;
drop table book_info;
create table users(
	email varchar(50) not null primary key,
	password varchar(50) not null,
	name varchar(50) not null,
	birthday date,
	gender tinyint,
	website varchar(200)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

create table book_info(
	isbn VARCHAR(30) PRIMARY KEY,
	title VARCHAR(50),
	author VARCHAR(50),
	price INTEGER,
	publish VARCHAR(50),
	published DATE
)ENGINE=INNODB DEFAULT CHARSET=utf8;

