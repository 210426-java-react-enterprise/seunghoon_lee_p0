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
	"username" varchar(25) not null,
	"password" varchar(255) not null,
	"first_name" varchar(25) not null,
	"last_name" varchar(25) not null,
	"email" varchar(25),
	constraint pk_customer primary key ("customer_id")
);