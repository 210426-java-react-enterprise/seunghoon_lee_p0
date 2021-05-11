--select aws-postgresql

select current_user, session_user; --postgres, postgres
create schema lee_bank;
alter schema lee_bank owner to slee;

grant usage on all tables in schema lee_bank to slee;
grant all privileges on schema lee_bank to slee;

--select aws-postgresql-slee

select current_user, session_user; --slee, slee
set search_path to lee_bank;
show search_path;

drop table if exists "customers";

create table "customers" (
	"customer_id" serial, 
	"username" varchar(25) unique, not null,
	"password" varchar(255) not null,
	"first_name" varchar(25) not null,
	"last_name" varchar(25) not null,
	"email" varchar(25) unique, not null
	constraint "pk_customer" primary key ("customer_id");
);

select * from lee_bank."customers";

drop table if exists "accounts";

create table "accounts" (
	"account_id" serial,
	"customer_id" int,
	"balance" numeric(10, 2) ,
	constraint "pk_account" primary key("account_id")
);

alter table "accounts" add constraint "fk_accouts_customer_id"
	foreign key ("customer_id") references "customers" ("customer_id");
	
insert into lee_bank.accounts (customer_id, balance) values(1,0.0);