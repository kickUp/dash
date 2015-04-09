-- 1. Почему, если убрать drop table не загружается? БД должна удаляться после зав. работы. --
-- 2. role `varchar primary key` не работает?! --

drop table if exists roles;
drop table if exists users;
drop table if exists courses;

CREATE TABLE roles (id int generated by default as identity (start with 1) primary key,
					role varchar not null
					);


CREATE TABLE users (
					 id int generated by default as identity (start with 1) primary key,
					 login varchar not null, 
					 password varchar not null, 
					 role_id int not null,
					 CONSTRAINT login_unique UNIQUE (login),
					 FOREIGN KEY(role_id) REFERENCES roles(id)					 
					);	
					
					
CREATE TABLE courses (
						id int generated by default as identity (start with 1) primary key, 
						name varchar not null, 
						description varchar not null, 
						user_id int not null, 
						FOREIGN KEY(user_id) REFERENCES Users(id)
					  );
					   			  
					  
				  
					  
					  
					  
					  
					  
					  
					  