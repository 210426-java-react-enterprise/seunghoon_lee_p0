--select aws-postgresql
--prepare
select current_user, session_user; --postgres, postgres
create schema lee_bank;
alter schema lee_bank owner to slee;

grant usage on all tables in schema lee_bank to slee;
grant all privileges on schema lee_bank to slee;

--start from here
--select aws-postgresql-slee

select current_user, session_user; --slee, slee
set search_path to lee_bank;
show search_path;

drop table if exists "transactions";
drop table if exists "accounts";
drop table if exists "customers";

create table "customers" (
	"customer_id" serial primary key, 
	"username" varchar(25) unique not null,
	"password" varchar(255) not null,
	"first_name" varchar(25) not null,
	"last_name" varchar(25) not null,
	"email" varchar(25) unique not null
);

create table "accounts" (
	"account_id" serial primary key,
	"customer_id" int not null,
	"balance" numeric(10, 2) check (balance >= 0.0)
);

alter table "accounts" add constraint "fk_accouts_customer_id"
	foreign key ("customer_id") references "customers" ("customer_id");
	
create table "transactions" (
	"transaction_id" serial primary key,
	"date" date not null default current_date,
	"account_id" int not null,
	"customer_id" int not null,
	"type" varchar(10) not null,
	"amount" numeric(10, 2) not null,
	"balance" numeric(10, 2) not null
);
	
alter table "transactions" add constraint "fk_transactions_account_id"
	foreign key ("account_id") references "accounts" ("account_id");

alter table "transactions" add constraint "fk_transactions_customer_id"
	foreign key ("customer_id") references "customers" ("customer_id");

