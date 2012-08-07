
create database king_db;

grant all on king_db.* to king@localhost identified by 'password';

drop table users;
create table users(
	email varchar(50) not null primary key,
	password varchar(50) not null,
	name varchar(50) not null,
	birthday date,
	gender tinyint,
	website varchar(200)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
