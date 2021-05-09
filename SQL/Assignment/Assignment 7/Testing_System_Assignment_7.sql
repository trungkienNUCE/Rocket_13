/*===============Testing_System_Assignment_6===============*/
/*=========================================================*/
	USE TestingSystem;
    
-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước

	DROP TRIGGER IF EXISTS trig_bf_insert_group;
	DELIMITER $$
	CREATE TRIGGER trig_bf_insert_group
    BEFORE INSERT ON  `group` 
    FOR EACH ROW
	BEGIN
        IF  NEW.CreateDate < date_sub(current_date(), INTERVAL 1 YEAR) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Cant add group because createdate < now';
		END IF;
	END$$
	DELIMITER ;

	INSERT INTO `Group`(GroupName, CreatorID, CreateDate)
	VALUES (N'Sale07','1', '2011-04-12');

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department Sale cannot add more user"

	DROP TRIGGER IF EXISTS trig_bf_not_insert_dept_Sale;
	DELIMITER $$
	CREATE TRIGGER trig_bf_not_insert_dept_Sale
    BEFORE INSERT ON  `account` 
    FOR EACH ROW
	BEGIN
        IF  NEW.DepartmentID = 11 THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Department Sale cannot add more user';
		END IF;
	END$$
	DELIMITER ;

INSERT INTO `Account`(Email								, Username			, Fullname				, DepartmentID, PositionID, CreateDate)
VALUES		
					(N'luongxuanhieu@gmail.com'			,'luonghieu01'		,'Luong Xuan Hieu'		,'11'			,'3'	,'2021-01-02');


-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user

	DROP TRIGGER IF EXISTS trig_bf_not_5user_in_group;
	DELIMITER $$
	CREATE TRIGGER trig_bf_not_5user_in_group
    BEFORE INSERT ON  `groupaccount` 
    FOR EACH ROW
	BEGIN
		DECLARE v_count_acc TINYINT UNSIGNED;
        SELECT  count(AccountID) INTO v_count_acc FROM testingsystem.groupaccount
		where GroupID = NEW.groupID 
		GROUP BY GroupID;
        IF  v_count_acc >= 5 THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'A group have max 5 users';
		END IF;
	END$$
	DELIMITER ;

	INSERT INTO GroupAccount(GroupID,AccountID,JoinDate)
	VALUES 
						('2','10','2020-09-12');

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

	DROP TRIGGER IF EXISTS trig_bf_not_5_ques_in_exam;
	DELIMITER $$
	CREATE TRIGGER trig_bf_not_5_ques_in_exam
    BEFORE INSERT ON  `examquestion` 
    FOR EACH ROW
	BEGIN
		DECLARE v_count_ques TINYINT UNSIGNED;
        SELECT count(QuestionID) INTO v_count_ques FROM testingsystem.examquestion
		WHERE ExamID = NEW.ExamID
		GROUP BY ExamID;
        IF  v_count_ques >= 3 THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'A exam have max 3 questions';
		END IF;
	END$$
	DELIMITER ;

	INSERT INTO ExamQuestion(ExamID,QuestionID)
	VALUES
						('6','4');

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- tin liên quan tới user đó

	DROP TRIGGER IF EXISTS trig_bf_del_admin_acc;
	DELIMITER $$
	CREATE TRIGGER trig_bf_del_admin_acc
    BEFORE DELETE ON  `account` 
    FOR EACH ROW
	BEGIN
		DECLARE email VARCHAR(50);
        SELECT a.email INTO email FROM `account` a
		WHERE a.AccountID = OLD.AccountID;
        IF  email = 'trantrungkien01@gmail.com' THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Cant delete admin account';
		END IF;
	END$$
	DELIMITER ;

	DELETE FROM `account` WHERE (AccountID = '2');
    
    /* ví dụ khi update thì chèn dữ liệu cũ vào bảng khác */
--  CREATE TABLE testingsystem.log_insert_change
--     (
-- 		AccountID 		TINYINT ,
-- 		Username 		VARCHAR(50),
-- 		DepartmentName 	VARCHAR(50),
-- 		ChangeTime		DATETIME DEFAULT NOW()
--     );
    
--     DROP TRIGGER IF EXISTS trig_af_change_deptID;
-- 	DELIMITER $$
-- 	CREATE TRIGGER trig_af_change_deptID
--     AFTER UPDATE ON  `account` 
--     FOR EACH ROW
-- 	BEGIN
-- 		DECLARE v_deptName VARCHAR(50);
--         SELECT d.departmentName INTO v_deptName FROM department d WHERE d.departmentID = OLD.departmentID;
--         INSERT INTO log_insert_change(AccountID,Username,DepartmentName) VALUE (OLD.accountID,OLD.Username,v_deptName);
-- 	END$$
-- 	DELIMITER ;
--     
--     UPDATE `account` SET DepartmentID = '5' WHERE AccountID = '1';



-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

	ALTER TABLE testingsystem.account
    CHANGE COLUMN departmentID departmentID TINYINT UNSIGNED;

	DROP TRIGGER IF EXISTS trig_bf_insert_acc_not_deptID;
	DELIMITER $$
	CREATE TRIGGER trig_bf_insert_acc_not_deptID
    BEFORE INSERT ON  `account` 
    FOR EACH ROW
	BEGIN
        IF  NEW.departmentID IS NULL THEN
			SET NEW.departmentID = '8';
		END IF;
	END$$
	DELIMITER ;
	
INSERT INTO `Account`(Email								, Username			, Fullname				, PositionID, CreateDate)
VALUES		
					(N'luongxuanhieu2@gmail.com'			,'luonghieu02'		,'Luong Xuan Hieu'		,'3'	,'2021-01-02');


-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- question, trong đó có tối đa 2 đáp án đúng.





-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database

	ALTER TABLE `account`
    ADD COLUMN Gender ENUM('M','F','U') DEFAULT 'U';

	ALTER TABLE `account`
    CHANGE COLUMN Gender Gender VARCHAR(20);

	DROP TRIGGER IF EXISTS trig_bf_insert_gender;
	DELIMITER $$
	CREATE TRIGGER trig_bf_insert_gender
    BEFORE INSERT ON  `account` 
    FOR EACH ROW
		BEGIN
			IF NEW.Gender = 'Nam' THEN SET NEW.Gender = 'M';
			ELSEIF NEW.Gender = 'Nu' THEN SET NEW.Gender = 'F';
			ELSEIF NEW.Gender = 'Chua xac dinh' THEN SET NEW.Gender = 'U';
			END IF ;
		END $$
	DELIMITER ;

INSERT INTO `Account`(Email								, Username			, Fullname				, PositionID, CreateDate, Gender)
VALUES		
					(N'luongxuanhieu3@gmail.com'			,'luonghieu03'		,'Luong Xuan Hieu'		,'3'	,'2021-01-02', 'Nam');

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày

	DROP TRIGGER IF EXISTS trig_bf_del_exam;
	DELIMITER $$
	CREATE TRIGGER trig_bf_del_exam
    BEFORE DELETE ON  `exam` 
    FOR EACH ROW
	BEGIN
		DECLARE createdate DATETIME;
        SELECT OLD.Createdate INTO createdate 
        FROM exam
        WHERE ExamID = OLD.ExamID;
        IF  createdate > date_sub(current_date(), INTERVAL 2 Day) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = "Can't delete this exam";
		END IF;
	END$$
	DELIMITER ;
    
	DELETE FROM exam WHERE ExamID = '8';

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào
	
    DROP TRIGGER IF EXISTS trig_bf_update_ques;
	DELIMITER $$
	CREATE TRIGGER trig_bf_update_ques
    BEFORE UPDATE ON  question 
    FOR EACH ROW
		BEGIN
			IF OLD.questionID IN (SELECT DISTINCT QuestionID FROM testingsystem.answer)
            OR
			OLD.questionID IN (SELECT DISTINCT QuestionID FROM testingsystem.examquestion) THEN
            SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = "CAN'T UPDATE question in answer or examquestion";
            END IF;
		END $$
	DELIMITER ;
    
    
	DROP TRIGGER IF EXISTS trig_bf_del_ques;
	DELIMITER $$
	CREATE TRIGGER trig_bf_del_ques
    BEFORE DELETE ON  question 
    FOR EACH ROW
		BEGIN
			IF OLD.questionID IN (SELECT DISTINCT QuestionID FROM testingsystem.answer)
            OR
			OLD.questionID IN (SELECT DISTINCT QuestionID FROM testingsystem.examquestion) THEN
            SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = "CAN'T DELETE question in answer or examquestion";
            END IF;
		END $$
	DELIMITER ;
    
-- UPDATE table_name
-- SET column1 = value1, column2 = value2, ...
-- WHERE condition;

	UPDATE question
    SET content = 'SQL la gi?' WHERE questionID = '2';
    
-- DELETE FROM table_name WHERE condition;
    DELETE FROM question WHERE QuestionID = '2';
    
    SELECT * FROM testingsystem.question;
    
-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"

	SELECT *,
		CASE
		WHEN Duration <=30 THEN 'Short time'
		WHEN Duration BETWEEN 30 AND 60 THEN 'Medium time'
		WHEN Duration >60 THEN 'Long time'
		END AS 'Time'
	FROM testingsystem.exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
	
    SELECT GroupID,Count(AccountID),
		CASE
        WHEN Count(AccountID) <= 4 THEN 'Few'
        WHEN Count(AccountID) BETWEEN 5 AND 20 THEN 'normal'
        WHEN Count(AccountID) > 20 THEN 'higher'
		END AS 'the_number_user_amount'
    FROM groupaccount
	GROUP BY GroupID;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
    
    SELECT d.DepartmentName,
		CASE
			WHEN COUNT(a.AccountID) = 0 THEN 'Khong co User'
            ELSE COUNT(a.AccountID)
		END AS Number_of_Account
	FROM Department d
	LEFT JOIN `Account` a ON d.DepartmentID = a.DepartmentID
	GROUP BY d.DepartmentName;




