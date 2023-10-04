create table users_roles
(
    user_id bigint not null references users(user_id),
    role_id bigint not null references roles(role_id),
    constraint users_roles_pk primary key (user_id, role_id)
);
