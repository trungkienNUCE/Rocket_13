/*===============CREATE TABLE & CONSTRAINS===============*/
/*=======================================================*/
-- Q1: 
DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE Fresher;
USE Fresher;
-- DROP TABLE Trainee;
DROP TABLE IF EXISTS Trainee;
-- CREATE TABLE Trainee
CREATE TABLE Trainee (
    TraineeID 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name 			NVARCHAR(50) NOT NULL,
    Birth_Date 			DATE,
    Gender 				ENUM('M', 'F', 'Unkown') NOT NULL,
    ET_IQ 				TINYINT UNSIGNED NOT NULL,
    CHECK(ET_IQ <= 20),
    ET_Gmath 			TINYINT UNSIGNED NOT NULL,
    CHECK(ET_Gmath <= 20),
    ET_English 			TINYINT UNSIGNED NOT NULL,
    CHECK(ET_English <= 50),
    Training_Class 		CHAR(10) NOT NULL,
    Evaluation_Notes 	NVARCHAR(255) NULL
);
-- Q2  thêm trường VTI_Account với điều kiện not null & unique
ALTER TABLE Trainee
ADD VTI_Account VARCHAR(50) NOT NULL UNIQUE KEY
AFTER ET_English;

-- Exercise 2: Data Types
DROP DATABASE IF EXISTS Data_Type;
CREATE DATABASE Data_Type;
USE Data_Type;

CREATE TABLE EX2
(
	ID 				MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` 			VARCHAR(30) NOT NULL,
    `Code` 			CHAR(5) UNIQUE NOT NULL,
    ModifiedDate 	TIMESTAMP
);

-- Exercise 3: Data Types (2)
CREATE TABLE EX3
(
	ID 				MEDIUMINT AUTO_INCREMENT PRIMARY KEY,
    `Name` 			VARCHAR(30) NOT NULL,
    BirthDate 		DATE NOT NULL,
    Gender 			BIT NULL,
    IsDeletedFlags 	BIT NOT NULL
);




