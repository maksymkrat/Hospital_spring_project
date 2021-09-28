DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
CREATE TABLE roles(
                      role_id int(11) NOT NULL AUTO_INCREMENT,
                      role_name varchar(255) DEFAULT NULL,

                      PRIMARY KEY (role_id)
);
INSERT INTO roles VALUES (1,'DOCTOR');
INSERT INTO roles VALUES (2,'ADMIN');
INSERT INTO roles VALUES (3,'USER');

CREATE TABLE users (
                       user_id int(11) NOT NULL AUTO_INCREMENT,
                       first_name varchar(255) NOT NULL,
                       last_name varchar(255) NOT NULL,
                       email varchar(255) NOT NULL,
                       password varchar(255) NOT NULL,
                       status varchar(255),
                       PRIMARY KEY (user_id)
);

CREATE TABLE users_roles (
                             user_id int(11) NOT NULL,
                             role_id int(11) NOT NULL,
                             PRIMARY KEY (user_id,role_id),
                             KEY FK_users_roles (role_id),
                             CONSTRAINT FK_users FOREIGN KEY (user_id) REFERENCES users (user_id),
                             CONSTRAINT FK_users_roles FOREIGN KEY (role_id) REFERENCES roles (role_id)
) ;

insert into users (user_id,first_name,last_name,email,password,status) values (1,'max','krat','max@gmail.com','$2a$12$Z8YgwqCXQYZ1XQXL7/Emoe4vxIQLWDRWyEHll6.XwJYHz1t29paMW','VERIFIED');
insert into users (user_id,first_name,last_name,email,password,status) values (2,'user','userov','user@gmail.com','$2a$12$.QzJYpVpTM6SHLYzq/IROeMDdbeoIw9U7kw3oOvy1ynXDPS9c/dIG','VERIFIED');
insert into users_roles (user_id, role_id) values ('1','2');
insert into users_roles (user_id, role_id) values ('2','3');

ALTER TABLE users ADD phone_number int;

DELETE from users_roles where user_id = 1;