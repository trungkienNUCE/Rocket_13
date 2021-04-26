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
CREATE TABLE `Account`
(
	AccountID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email 			VARCHAR(50) NOT NULL UNIQUE KEY,
    Username 		VARCHAR(50) NOT NULL UNIQUE KEY,
    Fullname 		NVARCHAR(50) NOT NULL,
    DepartmentID 	TINYINT UNSIGNED NOT NULL,
    PositionID 		TINYINT UNSIGNED NOT NULL,
    CreateDate 		DATETIME DEFAULT NOW(),
    CONSTRAINT fk_account_departments FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    CONSTRAINT fk_account_Position  FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);



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

ALTER TABLE `Group`
ADD FOREIGN KEY(CreatorID) REFERENCES  `Account`(AccountID) ;

ALTER TABLE `Group`
DROP FOREIGN KEY group_ibfk_1;

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


/*===============INSERT VALUES===============*/
/*===========================================*/

-- add data Department
INSERT INTO Department(DepartmentName)
VALUES
		(N'Marketing'),
        (N'Sale'),
        (N'Meeting'),
        (N'Bảo vệ'),
        (N'Nhân sự'),
        (N'Thư ký'),
        (N'Kỹ thuật');

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
					(N'trantrungkien12345@gmail.com'	,'trungkien12345'	,'Trần Trung Kiên12345'	,'2'		,'3'		,'2021-01-02'),
					(N'trantrungkien01@gmail.com'		,'trungkien01'		,'Trần Trung Kiên'		,'2'		,'2'		,'2021-01-02'),
					(N'trantrungkien02@gmail.com'		,'trungkien02'		,'Trần Trung Kiên'		,'3'		,'1'		,'2021-01-02'),
					(N'trantrungkien03@gmail.com'		,'trungkien03'		,'Trần Trung Kiên'		,'1'		,'3'		,'2021-01-02'),
					(N'trantrungkien04@gmail.com'		,'trungkien04'		,'Trần Trung Kiên'		,'4'		,'2'		,'2021-01-02'),
					(N'nguyenvanA@gmail.com'			,'nguyenA'			,'Nguyễn Văn A'			,'2'		,'3'		,'2020-11-02'),
					(N'nguyenvanB@gmail.com'			,'nguyenB'			,'Nguyễn Văn B'			,'1'		,'3'		,'2019-11-10'),
					(N'account01@gmail.com'				,'account01'		,'Account is 01'		,'4'		,'4'		,DEFAULT);
        
-- add data `Group`
INSERT INTO `Group`(GroupName,CreatorID,CreateDate)
VALUES 
					(N'Tester',1,'2019-09-12'),
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
		(N'Java học có khó không?','1','2','3','2020-05-04'),
        (N'Java web trong bao lâu?','2','1','2','2020-05-04'),
		(N'PHP có thật sự dễ học?','3','1','1','2020-05-04'),
		(N'Python lương bao nhiêu?','4','2','4','2020-05-04');

-- add data Answer
INSERT INTO Answer(Content,QuestionID,isCorrect)
VALUES 
		(N'Dễ ợt','2',0),
        (N'Java web học trong 4.5 tháng','2',1),
        (N'PHP tương đối đơn giản','3',1),
        (N'LTV Python lương 20tr','4',0);
        
-- add data Exam
INSERT INTO Exam(`Code`,Title,CategoryID,Duration,CreatorID,CreateDate)
VALUES 
				('Rocket13','Đề thi Java core','1','90','2','2019-08-09'),
				('Rocket14','Đề thi Java web','2','60','3','2021-01-09'),
				('Rocket15','Đề thi PHP','3','75','1','2021-01-28');

-- add data ExamQuestion
INSERT INTO ExamQuestion(ExamID,QuestionID)
VALUES
						('1','2'),
						('3','1'),
						('3','2');


/*===============Testing_System_Assignment_3===============*/
/*=========================================================*/

-- Q2 lấy ra tất cả các phòng ban
SELECT * FROM department;
    
-- Q3 lấy ra id của phòng ban "Sale"
SELECT DepartmentID AS 'ID of Sale' FROM department
WHERE DepartmentName = 'Sale';
    
-- Q4 lấy ra thông tin account có full name dài nhất
SELECT * FROM `Account`
WHERE LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM `Account`);

-- Q5 Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3 ???
SELECT * FROM `Account`
WHERE LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM `Account`) AND DepartmentID = 2;
        
-- Q6 Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT GroupName, CreateDate FROM `Group`
WHERE CreateDate < '2019-12-20'
ORDER BY CreateDate ASC;

-- Q7 Lấy ra ID của question có >= 4 câu trả lời
SELECT 
    QuestionID
FROM
    Answer
GROUP BY QuestionID
HAVING COUNT(QuestionID) >= 4;

-- Q8 Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT `code` AS 'Mã đề' FROM Exam 
WHERE duration >= 60 AND CreateDate < '2019-12-20';
        
-- Q9 Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

-- Q10 Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(AccountID) AS 'Number of account have depID is 2' FROM `account` 
WHERE departmentID = 2;
    
-- Q11 Lấy ra nhân viên có tên bắt đầu bằng chữ "N" và kết thúc bằng chữ "A" => NGUYEN VAN AN
SELECT  * FROM `account` 
WHERE Fullname LIKE 'N%' AND Fullname LIKE '%A';
    
-- Q12 Xoá tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM exam 
WHERE
    CreateDate < '2019-12-20';
    
-- Q13 Xóa tất cả các question có nội dung bắt đầu bằng từ "JAVA"
DELETE FROM question
WHERE content LIKE ('Java%');
-- SELECT * FROM 
-- question
-- WHERE content LIKE ('Java%');

-- Q14 Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `account` 
SET 
    Fullname = 'Đào Bá Lộc',
    Email = 'loc.nguyen@vti.com.vn'
WHERE AccountID = 5;
    
-- Q15 update account có id = 5 sẽ thuộc group có id = 4
UPDATE Groupaccount 
SET AccountID = 5
WHERE GroupID = 4;

