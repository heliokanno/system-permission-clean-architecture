insert into users ("user_id", "name", "email", "password", "status", "created_at", "updated_at")
values (nextval('seq_users'), 'Basic User','basic@system.com', null, 'ACTIVE', current_timestamp(6), null);

insert into users ("user_id", "name", "email", "password", "status", "created_at", "updated_at")
values (nextval('seq_users'), 'Advanced User','advanced@system.com', null, 'ACTIVE', current_timestamp(6), null);

insert into roles ("role_id", "name", "description")
values (nextval('seq_roles'), 'Basic Account','Limited transfer access.');

insert into roles ("role_id", "name", "description")
values (nextval('seq_roles'), 'Advanced Account','Unlimited transfer access.');

insert into permissions ("permission_id", "name", "description")
values (nextval('seq_permissions'), 'transfer.internal','Permission to internal transfer.');

insert into permissions ("permission_id", "name", "description")
values (nextval('seq_permissions'), 'transfer.pix','Permission to pix transfer.');

insert into permissions ("permission_id", "name", "description")
values (nextval('seq_permissions'), 'transfer.ted','Permission to ted transfer.');

insert into users_roles ("user_id", "role_id")
values ((select user_id from users where email = 'basic@system.com'), (select role_id from roles where name = 'Basic Account'));

insert into users_roles ("user_id", "role_id")
values ((select user_id from users where email = 'advanced@system.com'), (select role_id from roles where name = 'Advanced Account'));

insert into roles_permissions ("role_id", "permission_id")
values ((select role_id from roles where name = 'Basic Account'), (select permission_id from permissions where name = 'transfer.internal'));

insert into roles_permissions ("role_id", "permission_id")
values ((select role_id from roles where name = 'Advanced Account'), (select permission_id from permissions where name = 'transfer.internal'));

insert into roles_permissions ("role_id", "permission_id")
values ((select role_id from roles where name = 'Advanced Account'), (select permission_id from permissions where name = 'transfer.pix'));

insert into roles_permissions ("role_id", "permission_id")
values ((select role_id from roles where name = 'Advanced Account'), (select permission_id from permissions where name = 'transfer.ted'));