create table permissions
(
    permission_id bigint not null constraint permissions_pk primary key,
    name varchar(100) not null,
    description varchar(500) not null
);

create index idx_permissions_name on permissions(name);

create sequence "seq_permissions"
    start with 1
    increment by 1
    no minvalue
    no maxvalue
    cache 1;
