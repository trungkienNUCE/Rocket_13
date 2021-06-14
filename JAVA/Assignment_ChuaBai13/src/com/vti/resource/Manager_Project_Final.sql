DROP DATABASE IF EXISTS Manager_Project_Final;
CREATE DATABASE Manager_Project_Final;
USE Manager_Project_Final;

DROP TABLE IF EXISTS Project;
CREATE TABLE Project(
	id 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Project_Name 		NVARCHAR(30) NOT NULL UNIQUE KEY,
    `teamSize` 			TINYINT UNSIGNED
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`email`		VARCHAR(50) NOT NULL UNIQUE KEY,
    `password` 		VARCHAR(30) NOT NULL DEFAULT'12345A',
     `fullName`		NVARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`(
	id 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `ExpInYear` 		TINYINT UNSIGNED NULL,
	FOREIGN KEY(id) REFERENCES `user`(id) ON DELETE CASCADE
);
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`(
	id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    proSkill 		ENUM('DEV', 'TEST', 'PM', 'SQL') NOT NULL,
    FOREIGN KEY(id) REFERENCES `user`(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS ProjectAndUser;
CREATE TABLE ProjectAndUser(
	projectId 	TINYINT UNSIGNED NOT NULL,
    userId		TINYINT UNSIGNED NOT NULL, 
    `role` 		ENUM('MANAGER', 'EMPLOYEE'),
    PRIMARY KEY(projectId, userId),
     FOREIGN KEY(userId) REFERENCES `user`(id) ON DELETE CASCADE,
     FOREIGN KEY(projectId) REFERENCES Project(id) ON DELETE CASCADE
);

INSERT INTO Project (Project_Name, TeamSize)
VALUE				('Quan ly khach san',5),
					('Quan ly sinh vien',5),
                    ('Facebook',100);
                    
INSERT INTO `user` (Email, `password`, fullname)
VALUE				('Manger1@gmail.com', '12345A','Manger1'),
					('Employee1@gmail.com','A12345', 'Employee1'),
					('Manger2@gmail.com', '12345A','Manger2'),
					('Employee2@gmail.com','A12345', 'Employee2'),
					('Manger3@gmail.com', '12345A','Manger3'),
					('Employee4@gmail.com','A12345', 'Employee3');

INSERT INTO `manager` (id, ExpInYear)
VALUE				(1,5),(3,2),(5,1);
                    
INSERT INTO `employee` (id, proSkill)
VALUE				(2, 'TEST'),
					(4, 'DEV'),
					(6, 'PM');
                    
INSERT INTO ProjectAndUser
VALUE				(1,	1, 'MANAGER'),
					(1,	2, 'EMPLOYEE'),
					(2,	3, 'MANAGER'),
                    (2,	4, 'EMPLOYEE'),
                    (3,	5, 'MANAGER'),
					(3,	6, 'EMPLOYEE');
	