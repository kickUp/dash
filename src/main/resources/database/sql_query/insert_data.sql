--Roles--
INSERT INTO roles (role) values ('student');
INSERT INTO roles (role) values ('lector');
INSERT INTO roles (role) values ('admin');
--Users--
INSERT INTO users (login, password, role_id) values ('student', 'student', 1);
INSERT INTO users (login, password, role_id) values ('lector', 'lector', 2);
INSERT INTO users (login, password, role_id) values ('admin', 'admin', 3);
--Courses--
INSERT INTO courses (name, description, user_id) values('Sql', 'Is here', '2');
INSERT INTO courses (name, description, user_id) values('Spring', 'Be ready!', '2');
INSERT INTO courses (name, description, user_id) values('Javascript', 'Nice lang', '2');
INSERT INTO courses (name, description, user_id) values('Java', 'Solid!', '2');
INSERT INTO courses (name, description, user_id) values('Houdini', 'Solid!', '2');