create table roles
(
    role_id bigint not null constraint roles_pk primary key,
    name varchar(100) not null,
    description varchar(500) not null
);

create index idx_roles_name on roles(name);

create sequence "seq_roles"
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;