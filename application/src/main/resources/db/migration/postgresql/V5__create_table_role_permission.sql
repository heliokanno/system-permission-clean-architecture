create table roles_permissions
(
    role_id bigint not null references roles(role_id),
    permission_id bigint not null references permissions(permission_id),
    constraint roles_permissions_pk primary key (role_id, permission_id)
);
