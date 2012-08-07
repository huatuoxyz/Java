
# create database
create database king;

# create user and grant 
grant all on king.* to king@localhost identified by 'password';

# drop tables
drop table person_books;
drop table person;
drop table book;

# create tables
create table book (
	ISBN char(17) primary key not null, 
	NAME varchar(64) not null,
	PRICE integer not null
)ENGINE=INNODB DEFAULT CHARSET=utf8;

create table person(
	id int not null primary key ,
	name text not null
)ENGINE=INNODB DEFAULT CHARSET=utf8;

create table person_books (
	personid int not null,
	isbn char(17) not null ,
	FOREIGN KEY (isbn) REFERENCES book(ISBN) ON DELETE CASCADE
)ENGINE=INNODB DEFAULT CHARSET=utf8;

