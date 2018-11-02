
insert into privilege (id,name) values (1,"MODIFY");
insert into privilege (id,name) values (2,"CREATE");
insert into privilege (id,name) values (3,"DELETE");
insert into privilege (id,name) values (4,"VIEW");


insert into role (id,name) values (1,"USER_ROLE");

insert into roles_privileges (role_id,privilege_id) values (1,1);
insert into roles_privileges (role_id,privilege_id) values (1,2);
insert into roles_privileges (role_id,privilege_id) values (1,3);
insert into roles_privileges (role_id,privilege_id) values (1,4);

insert into users_roles (user_id,role_id) values (1,1);