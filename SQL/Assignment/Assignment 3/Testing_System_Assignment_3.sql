DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

/*===============CREATE TABLE & CONSTRAINS===============*/
/*=======================================================*/
-- DROP TABLE Department
DROP TABLE IF EXISTS Department;
-- CREATE TABLE Department
CREATE TABLE Department
(
	DepartmentID 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 	NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- ALTER TABLE Department
-- CHANGE COLUMN DepartmentName DepartmentName NVARCHAR(30) NOT NULL UNIQUE KEY;

-- DROP TABLE Position
DROP TABLE IF EXISTS Position;
-- CREATE TABLE Position
CREATE TABLE Position
(
	PositionID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName 	ENUM('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE KEY
);

-- DROP TABLE Account
DROP TABLE IF EXISTS `Account`;
-- CREATE TABLE Account
CREATE TABLE `Account`
(
	AccountID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email 			VARCHAR(50) NOT NULL UNIQUE KEY,
    Username 		VARCHAR(50) NOT NULL UNIQUE KEY,
    Fullname 		NVARCHAR(50) NOT NULL,
    DepartmentID 	TINYINT UNSIGNED NOT NULL,
    PositionID 		TINYINT UNSIGNED NOT NULL,
    CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);
-- ALTER TABLE `Account`
-- CHANGE COLUMN DepartmentID DepartmentID TINYINT UNSIGNED NOT NULL DEFAULT '8';

-- ALTER TABLE `account`
-- DROP FOREIGN KEY account_ibfk_1;
-- ALTER TABLE `account`
-- ADD FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID) ON DELETE SET DEFAULT;


-- DROP TABLE Group
DROP TABLE IF EXISTS `Group`;
-- CREATE TABLE Group
CREATE TABLE `Group`
(
	GroupID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName 		NVARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID 		TINYINT UNSIGNED,
    CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY (CreatorID) REFERENCES  `Account`(AccountID)
);

-- ALTER TABLE `Group`
-- ADD FOREIGN KEY(CreatorID) REFERENCES  `Account`(AccountID) ;

-- ALTER TABLE `Group`
-- DROP FOREIGN KEY group_ibfk_1;

-- DROP TABLE GroupAccount
DROP TABLE IF EXISTS GroupAccount;
-- CREATE TABLE GroupAccount
CREATE TABLE GroupAccount
(
	GroupID 		TINYINT UNSIGNED,
    AccountID 		TINYINT UNSIGNED NOT NULL,
    JoinDate 		DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID,AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID)
);

-- DROP TABLE TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
-- CREATE TABLE TypeQuestion
CREATE TABLE TypeQuestion
(
	TypeID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName 	ENUM ('Essay','Multiple-Choice')
);

-- DROP TABLE CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
-- CREATE TABLE CategoryQuestion
CREATE TABLE CategoryQuestion
(
	CategoryID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName 	NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- DROP TABLE Question
DROP TABLE IF EXISTS Question;
-- CREATE TABLE Question
CREATE TABLE Question
(
	QuestionID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content 		NVARCHAR(255) NOT NULL,
    CategoryID		TINYINT UNSIGNED NOT NULL,
    TypeID 			TINYINT UNSIGNED NOT NULL,
    CreatorID 		TINYINT UNSIGNED NOT NULL,
    CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- DROP TABLE Answer
DROP TABLE IF EXISTS Answer;
-- CREATE TABLE Answer
CREATE TABLE Answer
(
	AnswerID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content 		NVARCHAR(255) NOT NULL,
    QuestionID		TINYINT UNSIGNED NOT NULL,
    isCorrect 		BIT DEFAULT 1,
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

-- DROP TABLE Exam
DROP TABLE IF EXISTS Exam;
-- CREATE TABLE Exam
CREATE TABLE Exam
(
	ExamID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` 			CHAR(10) NOT NULL,
    Title 			NVARCHAR(50) NOT NULL,
    CategoryID		TINYINT UNSIGNED NOT NULL,
    Duration 		TINYINT UNSIGNED NOT NULL,
    CreatorID 		TINYINT UNSIGNED NOT NULL,
    CreateDate 		DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);


-- DROP TABLE ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
-- CREATE TABLE ExamQuestion
CREATE TABLE ExamQuestion
(
	ExamID			TINYINT UNSIGNED NOT NULL,
    QuestionID		TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY (ExamID,QuestionID),
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID),
    FOREIGN KEY (ExamID) REFERENCES Exam(ExamID)
);
-- ALTER TABLE examquestion
-- ADD FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID) ON DELETE CASCADE;

-- ALTER TABLE examquestion
-- DROP FOREIGN KEY `examquestion_ibfk_1`;


/*===============INSERT VALUES===============*/
/*===========================================*/

-- add data Department
INSERT INTO Department(DepartmentName)
VALUES
		(N'Marketing'),
        (N'Sale'),
        (N'Meeting'),
        (N'B???o v???'),
        (N'Nh??n s???'),
        (N'Th?? k??'),
        (N'K??? thu???t');

-- add data Position
INSERT INTO `Position`(PositionName)
VALUES
		(N'Dev'),
        (N'PM'),
        (N'Test'),
        (N'Scrum Master');
    
-- add data `Account`
INSERT INTO `Account`(Email								, Username			, Fullname				, DepartmentID, PositionID, CreateDate)
VALUES		
					(N'trantrungkien12345@gmail.com'	,'trungkien12345'	,'Tr???n Trung Ki??n12345'	,'2'		,'3'		,'2021-01-02'),
					(N'trantrungkien01@gmail.com'		,'trungkien01'		,'Tr???n Trung Ki??n'		,'2'		,'2'		,'2021-01-02'),
					(N'trantrungkien02@gmail.com'		,'trungkien02'		,'Tr???n Trung Ki??n'		,'3'		,'1'		,'2021-01-02'),
					(N'trantrungkien03@gmail.com'		,'trungkien03'		,'Tr???n Trung Ki??n'		,'1'		,'3'		,'2021-01-02'),
					(N'trantrungkien04@gmail.com'		,'trungkien04'		,'Tr???n Trung Ki??n'		,'4'		,'2'		,'2021-01-02'),
					(N'nguyenvanA@gmail.com'			,'nguyenA'			,'Nguy???n V??n A'			,'2'		,'3'		,'2020-11-02'),
					(N'nguyenvanB@gmail.com'			,'nguyenB'			,'Nguy???n V??n B'			,'1'		,'3'		,'2019-11-10'),
					(N'account01@gmail.com'				,'account01'		,'Account is 01'		,'4'		,'4'		,DEFAULT);
        
-- add data `Group`
INSERT INTO `Group`(GroupName,CreatorID,CreateDate)
VALUES 
					(N'Meeting',1,'2019-09-12');
					(N'Development',1,'2019-09-08'),
					(N'Technology',2,'2019-09-12'),
					(N'technology02',2,'2021-01-12'),
					(N'Sale01',4,'2011-09-12'),
					(N'Sale02',5,'2017-09-12'),
					(N'Sale03',6,'2018-09-12'),
					(N'Sale04',7,'2020-09-12');

-- add data GroupAccount
INSERT INTO GroupAccount(GroupID,AccountID,JoinDate)
VALUES 
						('2','6','2020-09-12'),
						('3','4','2020-09-12'),
						('4','1','2020-09-12'),
						('5','2','2020-09-12'),
						('1','3','2020-02-20');

-- add data TypeQuestion
INSERT INTO TypeQuestion(TypeName)
VALUES 
						('Essay'),
						('Multiple-Choice');
        
-- add data CategoryQuestion
INSERT INTO CategoryQuestion(CategoryName)
VALUES 
							('Java core'),
							('Java web'),
							('PHP'),
							('Python'),
							('ASP.NET'),
							('Ruby'),
							('SQL');

-- add data Question
INSERT INTO Question(Content,CategoryID,TypeID,CreatorID,CreateDate)
VALUES
		(N'T??i mu???n h???c gi???i th?? l??m sao?','1','2','3','2020-05-04'),
        (N'Java web trong bao l??u?','2','1','2','2020-05-04'),
		(N'PHP c?? th???t s??? d??? h???c?','3','1','1','2020-05-04'),
		(N'Python l????ng bao nhi??u?','4','2','4','2020-05-04');

-- add data Answer
INSERT INTO Answer(Content,QuestionID,isCorrect)
VALUES 
		(N'D??? ???t','2',0),
        (N'Java web h???c trong 4.5 th??ng','2',1),
        (N'PHP t????ng ?????i ????n gi???n','3',1),
        (N'LTV Python l????ng 20tr','4',0);
        
-- add data Exam
INSERT INTO Exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate)
VALUES 
				('Rocket13','????? thi Java core','1','90','2','2019-08-09'),
				('Rocket14','????? thi Java web','2','60','3','2021-01-09'),
				('Rocket15','????? thi PHP','3','75','1','2021-01-28');

-- add data ExamQuestion
INSERT INTO ExamQuestion(ExamID,QuestionID)
VALUES
						('6','3'),
						('4','2'),
						('5','3');
                        
/*===============Testing_System_Assignment_3===============*/
/*=========================================================*/

-- Q2 l???y ra t???t c??? c??c ph??ng ban
SELECT * FROM department;
    
-- Q3 l???y ra id c???a ph??ng ban "Sale"
SELECT DepartmentID AS 'ID of Sale' FROM department
WHERE DepartmentName = 'Sale';
    
-- Q4 l???y ra th??ng tin account c?? full name d??i nh???t
SELECT * FROM `Account`
WHERE LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM `Account`);

-- Q5 L???y ra th??ng tin account c?? full name d??i nh???t v?? thu???c ph??ng ban c?? id = 3 ???
SELECT  * FROM `Account`
WHERE DepartmentID = 3 
AND LENGTH(FullName) = (SELECT MAX(length(FullName)) 
                        FROM Account 
                        WHERE DepartmentID = 3 );

-- CACH 2 DUNG CTE
WITH CTE_DEP3 AS  (SELECT * FROM `Account` WHERE DepartmentID = 3)
SELECT MAX(length(FullName)) FROM Account 
WHERE LENGTH(FULLNAME) = MAX(LENGTH(FULLNAME));
        

-- Q6 L???y ra t??n group ???? tham gia tr?????c ng??y 20/12/2019
SELECT GroupName, CreateDate FROM `Group`
WHERE CreateDate < '2019-12-20'
ORDER BY CreateDate ASC;

-- Q7 L???y ra ID c???a question c?? >= 4 c??u tr??? l???i
SELECT A.QuestionID FROM Answer A
GROUP BY A.QuestionID
HAVING COUNT(A.QuestionID) >= 2;

-- Q8 L???y ra c??c m?? ????? thi c?? th???i gian thi >= 60 ph??t v?? ???????c t???o tr?????c ng??y 20/12/2019
SELECT `code` AS 'M?? ?????' FROM Exam 
WHERE duration >= 60 AND CreateDate < '2019-12-20';
        
-- Q9 L???y ra 5 group ???????c t???o g???n ????y nh???t
SELECT * FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

-- Q10 ?????m s??? nh??n vi??n thu???c department c?? id = 2
SELECT COUNT(AccountID) AS 'SL NV CO DEPT_ID = 2' FROM `account` 
WHERE departmentID = 2;
    
-- Q11 L???y ra nh??n vi??n c?? t??n b???t ?????u b???ng ch??? "" v?? k???t th??c b???ng ch??? "C" => ????O B?? L???C
SELECT * FROM `account` 
WHERE substring_index(FULLNAME, ' ', -1) LIKE 'L%C';
    
-- Q12 Xo?? t???t c??? c??c exam ???????c t???o tr?????c ng??y 20/12/2019
DELETE FROM exam 
WHERE CreateDate < '2019-12-20';
    
-- Q13 X??a t???t c??? c??c question c?? n???i dung b???t ?????u b???ng t??? "JAVA"
DELETE FROM question
WHERE content LIKE ('Java%');
-- SELECT * FROM 
-- question
-- WHERE content LIKE ('Java%');

-- Q14 Update th??ng tin c???a account c?? id = 5 th??nh t??n "Nguy???n B?? L???c" v?? email th??nh loc.nguyenba@vti.com.vn
UPDATE `account` 
SET 
    Fullname = '????o B?? L???c',
    Email = 'loc.nguyen@vti.com.vn'
WHERE AccountID = 5;
    
-- Q15 update account c?? id = 5 s??? thu???c group c?? id = 4
UPDATE Groupaccount 
SET AccountID = 5
WHERE GroupID = 4;

