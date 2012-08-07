
create database king_db;

grant all on king_db.* to king@localhost identified by 'password';

create table book_info(
	isbn VARCHAR(30) PRIMARY KEY,
	title VARCHAR(50),
	author VARCHAR(50),
	price INTEGER,
	publish VARCHAR(50),
	published DATE
)ENGINE=INNODB DEFAULT CHARSET=utf8;

