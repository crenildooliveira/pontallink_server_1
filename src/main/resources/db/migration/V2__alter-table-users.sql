alter table users
	add column name varchar(100) not null,
	add column bio varchar(255),
	add column condominium varchar(100) not null,
	add column userProfileImageMid LONGTEXT,
	add column active boolean not null;