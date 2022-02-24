create table se_money_Account (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	balance DOUBLE,
	total BOOLEAN
);

create table se_money_Category (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	type INTEGER
);

create table se_money_Operation (
	id_ LONG not null primary key,
	date_ DATE null,
	category_id LONG,
	sum DOUBLE,
	comment VARCHAR(75) null
);

create table se_money_SubCategory (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	parent_category_id LONG
);