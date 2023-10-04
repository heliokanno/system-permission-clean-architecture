create table users
(
    user_id bigint not null constraint users_pk primary key,
    name varchar(100) not null,
    email varchar(50) not null,
    password varchar(25),
    status varchar(10) not null,
    created_at timestamp(6) not null,
    updated_at timestamp(6)
);

create index idx_users_name on users(name);
create index idx_users_email on users(name);

create sequence "seq_users"
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;
