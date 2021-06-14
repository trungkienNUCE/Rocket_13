DROP DATABASE IF EXISTS Manager_Project;
CREATE DATABASE Manager_Project;
USE Manager_Project;

DROP TABLE IF EXISTS Project;
CREATE TABLE Project(
	ProjectID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProjectName 		NVARCHAR(30) NOT NULL UNIQUE KEY,
    TeamSize 			TINYINT UNSIGNED
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    FullName		NVARCHAR(50) NOT NULL,
    Email			VARCHAR(50) NOT NULL UNIQUE KEY,
    `PassWord` 		VARCHAR(30) NOT NULL DEFAULT'12345A',
    ExpInYear 		TINYINT UNSIGNED NULL,
    ProSkill 		NVARCHAR(50) NULL
);

DROP TABLE IF EXISTS ManagerProject;
CREATE TABLE ManagerProject(
	ProjectID 		TINYINT UNSIGNED NOT NULL,
    AccountID		TINYINT UNSIGNED NOT NULL, 
    PRIMARY KEY(ProjectID, AccountID)
);

DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin`(
	UserName 		NVARCHAR(50) NOT NULL PRIMARY KEY,
    `Password`		VARCHAR(30) NOT NULL
);

-- insert data
INSERT INTO `Admin`
VALUE		('admin','Admin1');

INSERT INTO Project (ProjectName, TeamSize)
VALUE				('Quan ly khach san',5),
					('Quan ly sinh vien',5),
                    ('Facebook',100);
                    
INSERT INTO `Account` (FullName, Email, ExpInYear, ProSkill)
VALUE				('Manger1','Manger1@gmail.com',5, 'CNTT'),
					('Manger2','Manger2@gmail.com',3, 'CNTT'),
                    ('Employee1','Employee1@gmail.com',null, null),
					('Employee2','Employee2@gmail.com',null, null);
                    
INSERT INTO ManagerProject
VALUE				(1,	1),
					(2,	2),
					(3,	1),
					(3,	2);
					
					