--Roles--
INSERT INTO roles (role) values ('student');
INSERT INTO roles (role) values ('lector');
INSERT INTO roles (role) values ('admin');
--Users--
INSERT INTO users (login, password, role_id) values ('student', 'student', 1);
INSERT INTO users (login, password, role_id) values ('lector', 'lector', 2);
INSERT INTO users (login, password, role_id) values ('admin', 'admin', 3);
--Courses--
INSERT INTO courses (name, description, user_id, starts, ends, image) values('Ninja',
					'was a covert agent or mercenary in feudal Japan. The functions of the ninja included espionage,
					sabotage, infiltration, and assassination, and open combat in certain situations.
					Their covert methods of waging war contrasted the ninja with the samurai, who observed strict
					rules about honor and combat.',
					 '2', '2014-04-21', '2015-07-18', 'true');
INSERT INTO courses (name, description, user_id, starts, ends, image) values('Sql', 
					'is a special-purpose programming language designed for managing data held in 
					a relational database management system (RDBMS), or for stream processing in 
					a relational data stream management system (RDSMS).', 
					'2', '2015-07-11', '2015-07-18', 'true');
INSERT INTO courses (name, description, user_id, starts, ends, image) values('Spring', 
					'The frameworks core features can be used by any Java application, but there are extensions 
					for building web applications on top of the Java EE platform. Although the framework does 
					not impose any specific programming model, it has become popular in the Java community 
					as an alternative to, replacement for, or even addition to the Enterprise JavaBeans (EJB) model', 
					'2', '2014-04-21', '2015-07-18', 'false');
INSERT INTO courses (name, description, user_id, starts, ends, image) values('Javascript', 
					' also known as ECMAScript (the untrademarked name used for the standard), is a dynamic 
					programming language. It is most commonly used as part of web browsers, whose implementations 
					allow client-side scripts to interact with the user, control the browser, communicate asynchronously, 
					and alter the document content that is displayed.', 
					'2', '2016-04-12', '2015-07-18', 'false');
INSERT INTO courses (name, description, user_id, starts, ends, image) values('Java', 
					'It is intended to let application developers "write once, run anywhere" (WORA), meaning that 
					compiled Java code can run on all platforms that support Java without the need for recompilation. 
					Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) 
					regardless of computer architecture.', 
					'2', '2015-01-11', '2014-02-18', 'true');
INSERT INTO courses (name, description, user_id, starts, ends, image) values('Houdini', 
					' 3D animation application software developed by Side Effects Software of Toronto. 
					Side Effects adapted Houdini from the PRISMS suite of procedural generation software tools. 
					Its exclusive attention to procedural generation distinguishes it from other 3D computer graphics software.', 
					'2', '2015-05-18', '2015-08-18', 'false');