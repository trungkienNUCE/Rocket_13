USE TestingSystem;
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
INSERT INTO `Account`(Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
VALUES		
		(N'trantrungkien12345@gmail.com','trungkien12345','Trần Trung Kiên12345','2','3','2021-01-02'),
        (N'trantrungkien01@gmail.com','trungkien01','Trần Trung Kiên','2','2','2021-01-02'),
        (N'trantrungkien02@gmail.com','trungkien02','Trần Trung Kiên','3','1','2021-01-02'),
        (N'trantrungkien03@gmail.com','trungkien03','Trần Trung Kiên','1','3','2021-01-02'),
        (N'trantrungkien04@gmail.com','trungkien04','Trần Trung Kiên','4','2','2021-01-02'),
        (N'nguyenvanA@gmail.com','nguyenA','Nguyễn Văn A','2','3','2020-11-02'),
        (N'nguyenvanB@gmail.com','nguyenB','Nguyễn Văn B','1','3','2019-11-10'),
        (N'account01@gmail.com','account01','Account is 01','4','4',DEFAULT);
        
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
