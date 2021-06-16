-- create database
DROP DATABASE IF EXISTS manager_user_15;
CREATE DATABASE manager_user_15;
USE manager_user_15;

-- create table: User
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`email` 		CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
	`fullName` 		NVARCHAR(50) NOT NULL,
    `Role`			ENUM('USER', 'ADMIN')
);

-- create table: Manager
DROP TABLE IF EXISTS 	`admin`;
CREATE TABLE IF NOT EXISTS `admin` ( 	
	id 				SMALLINT UNSIGNED NOT NULL,
	`expInYear` 	SMALLINT UNSIGNED NOT NULL,
    FOREIGN KEY (id) REFERENCES `User`(id) ON DELETE CASCADE
);

-- create table: Employee
DROP TABLE IF EXISTS 	`Employee`;
CREATE TABLE IF NOT EXISTS `Employee` ( 	
	id 				SMALLINT UNSIGNED NOT NULL,
    proSkill 		ENUM('DEV', 'TEST', 'JAVA', 'SQL') NOT NULL,
    FOREIGN KEY (id) REFERENCES `User`(id) ON DELETE CASCADE
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data User
INSERT INTO `User` 	(`email`,						`password`,		`fullName`,					`Role`)
VALUE				('admin@gmail.com',				'Admin1',		'admin',					'ADMIN'), 
					('kien@gmail.com',				'Admin1',		'kien',						'ADMIN'), 
					('user1@gmail.com',				'123456A',		'User 1',					'USER'), 
					('user2@gmail.com',				'123456A',		'User 2',					'USER'), 
					('user3@gmail.com',				'123456A',		'User 3',					'USER'), 
					('user4@gmail.com',				'123456A',		'User 4',					'USER'),
					('user5@gmail.com', 			'123456A',		'User 5',					'USER'),
					('user6@gmail.com', 			'123456A',		'User 6',					'USER'),
					('user7@gmail.com', 			'123456A',		'User 7',					'USER'),
					('user8@gmail.com', 			'123456A',		'User 8',					'USER'),
					('user9@gmail.com', 			'123456A',  	'User 9',					'USER'),
					('user10@gmail.com', 			'123456A',		'User 10',					'USER'),
					('user11@gmail.com', 			'123456A',		'User 11',					'USER'),
					('user12@gmail.com', 			'123456A',		'User 12',					'USER'),
					('user13@gmail.com', 			'123456A',		'User 13',					'USER'),
					('user14@gmail.com', 			'123456A',		'User 14',					'USER'),
					('user15@gmail.com', 			'123456A',		'User 15',					'USER');

-- Add data admin
INSERT INTO `admin` (id,	`expInYear`	)
VALUE				(3,			1		), 
					(5,			2		), 
					(7,			3		), 
					(9,			5		), 
					(11,		7		), 
					(13,		8		), 
					(15,		9		), 
					(17,		10		);

-- Add data Employee
INSERT INTO Employee 	(id,	`proSkill`	)
VALUE					(2,			'DEV'	), 
						(4,			'DEV'	), 
						(6,			'TEST'	), 
						(8,			'TEST'	), 
						(10,		'JAVA'	), 
						(12,		'DEV'	), 
						(14,		'JAVA'	), 
						(16,		'SQL'	);
                        