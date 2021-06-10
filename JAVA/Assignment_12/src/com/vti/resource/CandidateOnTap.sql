DROP DATABASE IF EXISTS Candidate;
CREATE DATABASE Candidate;
USE Candidate;
DROP TABLE IF EXISTS ExperienceCandidate;
CREATE TABLE ExperienceCandidate(
	UserName 		VARCHAR(30) NOT NULL PRIMARY KEY,
    FullName 		NVARCHAR(50) NOT NULL,
    Phone 			INT NOT NULL UNIQUE KEY,
    Email 			VARCHAR(50) NOT NULL UNIQUE KEY,
    `PassWord` 		VARCHAR(30) NOT NULL,
    ExpInYear 		TINYINT UNSIGNED,
    ProSkill 		NVARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS FresherCandidate;
CREATE TABLE FresherCandidate(
	UserName 		VARCHAR(30) NOT NULL PRIMARY KEY,
    FullName 		NVARCHAR(50) NOT NULL,
    Phone 			INT NOT NULL UNIQUE KEY,
    Email 			VARCHAR(50) NOT NULL UNIQUE KEY,
    `PassWord` 		VARCHAR(30) NOT NULL,
    GraduationRank 		ENUM('Excellence','Good','Fair','Poor') NOT NULL 
);
INSERT INTO ExperienceCandidate(UserName, FullName	, Phone	, Email	, `PassWord`, ExpInYear, ProSkill)
VALUES 				('trungkien', 'Tran Trung Kien'	,0961781080	, 'trantrungkien@gmail.com'	,'12345A', 5	,'CNTT');
	
INSERT INTO FresherCandidate(UserName, FullName	, Phone	, Email	, `PassWord`, GraduationRank)
VALUES 				('fresher1', 'freshername1'	,0961781080	, 'fresher1@gmail.com'	,'12345A','Excellence');