/**
������
**/

create database gala_cms;


/**
user���û���
**/
create table users (
	uname varchar(20),
	uuser varchar(20),
	upassword varchar(20),
	supers int(10)
	emil varchar(30)
	comment varchar(50),
	utime varchar(30)
)

/**
newstype���ñ�Ϊ�������
**/

create table newstype (
	newstype_id int(20),
	newstype_type varchar(40),
	newstype_date timestamp
)


/**
news�������б�
**/
create news table(
	news_id int(5),
	new_title varchar(10),
	new_type varchar(10),
	news_keyword varchar(5),
	news_check int(5),
	news_referaddress varchar(50),
	news_content varchar(100),
	news_image varchar(100),
	news_date timestamp
)