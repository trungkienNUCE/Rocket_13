/*===============Testing_System_Assignment_6===============*/
/*=========================================================*/
	USE TestingSystem;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
	DELIMITER $$
	DROP PROCEDURE IF EXISTS sp_account_of_dept;
	CREATE PROCEDURE sp_account_of_dept(IN p_department_name NVARCHAR(50))
	BEGIN
		SELECT 		A.AccountID, A.Email, A.Username, A.Fullname, A.CreateDate,D.Departmentname
		FROM		Department D 
		INNER JOIN 	`Account` A ON D.DepartmentID = A.DepartmentID
		WHERE		DepartmentName = p_department_name;
	END$$
	DELIMITER ;
	
	Call sp_account_of_dept('meeting');
		
-- nhập departmentid thì in ra account 
	-- DELIMITER $$
-- 	DROP PROCEDURE IF EXISTS sp_account_of_deptID;
-- 	CREATE PROCEDURE sp_account_of_deptID(IN p_department_id TINYINT)
-- 	BEGIN
-- 		SELECT 		A.AccountID, A.Email, A.Username, A.Fullname, A.CreateDate,A.DepartmentID,D.DepartmentName
-- 		FROM		Department D 
-- 		INNER JOIN 	`Account` A ON D.DepartmentID = A.DepartmentID
-- 		WHERE		A.DepartmentID = p_department_id;
-- 	END$$
-- 	DELIMITER ;
-- 	Call sp_account_of_deptID('3');


-- Question 2: Tạo store để in ra số lượng account trong mỗi group
	DELIMITER $$
	DROP PROCEDURE IF EXISTS sp_account_of_groupID;
	CREATE PROCEDURE sp_account_of_groupID(IN p_groupid tinyint)
	BEGIN
		SELECT 		GroupId, count(g.accountID)
		FROM		`Groupaccount` G
		WHERE		g.groupid = p_groupid
        GROUP BY 	groupid;
	END$$
	DELIMITER ;
    
	Call sp_account_of_groupID(2);


-- Nhập tên group in ra số lượng account của group đó
-- 	DELIMITER $$
-- 	DROP PROCEDURE IF EXISTS sp_account_of_groupName;
-- 	CREATE PROCEDURE sp_account_of_groupName(IN in_group_name NVARCHAR(50))
-- 	BEGIN
-- 		SELECT g.GroupName, COUNT(ga.accountid) AS SL FROM groupaccount ga
--         INNER JOIN `group` g ON g.groupid = ga.groupid
-- 		WHERE g.GroupName = in_group_name
--         GROUP BY g.groupid;
-- 	END$$
-- 	DELIMITER ;

-- 	Call sp_account_of_groupName('sale01');
    
-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
	
    DROP PROCEDURE IF EXISTS sp_GetCountTypeInMonth;
	DELIMITER $$
	CREATE PROCEDURE sp_GetCountTypeInMonth()
		BEGIN
			SELECT Q.TypeID,Q.CreateDate, count(Q.TypeID) AS 'SL' FROM question Q 
			INNER JOIN typequestion t ON t.TypeID = q.TypeID
			WHERE month(Q.CreateDate) = month(now()) AND year(Q.CreateDate) = year(now())
			GROUP BY Q.TypeID;
		END$$	
	DELIMITER ;
    
    CALL sp_GetCountTypeInMonth();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
	DELIMITER $$
	DROP PROCEDURE IF EXISTS sp_max_typeques;
	CREATE PROCEDURE sp_max_typeques(OUT v_ID TINYINT)
	BEGIN
		WITH CTE_MAX_QUES AS 
			(SELECT max(SL) FROM
				(SELECT COUNT(TypeID) AS 'SL' 
				FROM question
				GROUP BY TypeID) AS MAXX)
                
		SELECT 		TypeID INTO v_ID
		FROM		Question
		GROUP BY 	TypeID
		HAVING		COUNT(TypeID) = (SELECT * FROM CTE_MAX_QUES);
	END$$
	DELIMITER ;
    
    SET @ID = 0;
	Call sp_max_typeques(@ID);
    SELECT @ID;


-- Cách 2: không dùng out trong procedure
	-- DELIMITER $$
-- 	DROP PROCEDURE IF EXISTS sp_max_typeques_02;
-- 	CREATE PROCEDURE sp_max_typeques_02()
-- 	BEGIN
-- 		WITH CTE_MAX_QUES AS 
-- 			(SELECT max(SL) FROM
-- 				(SELECT COUNT(TypeID) AS 'SL' 
-- 				FROM question
-- 				GROUP BY TypeID) AS MAXX)
--                 
-- 		SELECT 		TypeID INTO v_ID
-- 		FROM		Question
-- 		GROUP BY 	TypeID
-- 		HAVING		COUNT(TypeID) = (SELECT * FROM CTE_MAX_QUES);
-- 	END$$
-- 	DELIMITER ;
-- 	
--     CALL sp_max_typeques_02();

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
	DELIMITER $$
	DROP PROCEDURE IF EXISTS sp_max_typequesName;
	CREATE PROCEDURE sp_max_typequesName()
	BEGIN
		WITH CTE_MAX_QUES AS 
			(SELECT max(SL) FROM
				(SELECT COUNT(TypeID) AS 'SL' 
				FROM question 
				GROUP BY TypeID) AS MAXX)
		SELECT 		Q.TypeID, t.typename AS 'Loai cau hoi',COUNT(q.TypeID) AS SL
		FROM		Question q
        INNER JOIN Typequestion T ON T.TypeID = Q.TypeID
		GROUP BY 	q.TypeID
		HAVING		COUNT(q.TypeID) = (SELECT * FROM CTE_MAX_QUES);
	END$$
	DELIMITER ;
    
	Call sp_max_typequesName();

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào
	DROP PROCEDURE IF EXISTS sp_name_of_group_or_username;
	DELIMITER $$
	CREATE PROCEDURE sp_name_of_group_or_username(IN in_string_input VARCHAR(50), IN in_select BIT)
	BEGIN
		IF (in_select = 1) THEN
			SELECT	GroupName
			FROM	`group`
			WHERE	GroupName LIKE concat_ws('%',in_string_input,'%');
		ELSEIF (in_select = 0) THEN
			SELECT	Username
			FROM	`account`
			WHERE	Username LIKE concat_ws('%',in_string_input,'%');
		END IF;
	END$$
	DELIMITER ;

	CALL sp_name_of_group_or_username('te',1);


-- CACH 2
	DROP PROCEDURE IF EXISTS sp_name_of_group_or_username02;
	DELIMITER $$
	CREATE PROCEDURE sp_name_of_group_or_username02(IN in_string_input VARCHAR(50))
	BEGIN
			SELECT	g.GroupName AS `Name`
			FROM	`group` g
			WHERE	GroupName LIKE concat_ws('%',in_string_input,'%')
            UNION
			SELECT	a.Username
			FROM	`account` a
			WHERE	Username LIKE concat_ws('%',in_string_input,'%');
	END$$
	DELIMITER ;

	CALL sp_name_of_group_or_username02('trung');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
	DELIMITER $$
	DROP PROCEDURE IF EXISTS sp_insert_fullname_email;
	CREATE PROCEDURE sp_insert_fullname_email(IN in_fullname VARCHAR(50), IN in_email VARCHAR(50))
	BEGIN
		DECLARE v_username VARCHAR(50)  DEFAULT SUBSTRING_INDEX(in_email,'@',1);
        DECLARE v_dept_id TINYINT DEFAULT  8;
        DECLARE v_postion_id TINYINT DEFAULT  1;
        DECLARE v_CreateDate DATETIME DEFAULT   now();
        
        INSERT INTO `account`(Email,Username,Fullname,departmentid, positionid,createdate)
        VALUE 				(in_email,v_username,in_fullname,v_dept_id,v_postion_id,v_CreateDate);
	END$$
	DELIMITER ;
    
	CALL sp_insert_fullname_email('Nguyen Duc Huong','nguyenduchuong3@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
	DROP PROCEDURE IF EXISTS sp_maxContentWithTypeName;
	DELIMITER $$
	CREATE PROCEDURE sp_maxContentWithTypeID
	(IN in_TypeName VARCHAR(15))
	BEGIN
		IF (in_TypeName = 'Essay') THEN
			SELECT	Content, MAX(LENGTH(Content))
			FROM	Question
			WHERE	TypeID = 1;
		ELSEIF (in_TypeName = 'Multiple-Choice') THEN
			SELECT	Content, MAX(LENGTH(Content))
			FROM	Question
			WHERE	TypeID = 2;
		END IF;
	END$$
	DELIMITER ;

	CALL sp_maxContentWithTypeID('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
-- 	DROP PROCEDURE IF EXISTS sp_del_examID;
-- 	DELIMITER $$
-- 	CREATE PROCEDURE sp_del_examID (IN in_ExamID TINYINT)
-- 		BEGIN
-- 			DELETE FROM Exam
-- 			WHERE in_ExamID = ExamID;
-- 		END$$
-- 	DELIMITER ;

-- 	CALL sp_del_examID(2);

-- dap an
	DROP PROCEDURE IF EXISTS sp_DeleteExamWithID;
	DELIMITER $$
	CREATE PROCEDURE sp_DeleteExamWithID (IN in_ExamID TINYINT UNSIGNED)
	BEGIN
	DELETE FROM examquestion WHERE ExamID = in_ExamID;
	DELETE FROM Exam WHERE ExamID = in_ExamID;
	END$$
	DELIMITER ;
	CALL sp_DeleteExamWithID(7);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa) Sau đó in số lượng record đã remove từ các table liên quan trong khi removing???
-- 	DROP PROCEDURE IF EXISTS sp_del_exam_3Years;
-- 	DELIMITER $$
-- 	CREATE PROCEDURE sp_del_exam_3Years()
-- 		BEGIN
-- 			WITH CTE_EXAMID_3YEARS AS
--             (
-- 				SELECT ExamID FROM Exam
--                 WHERE (Year(now()) - Year(CreateDate)) > 3
--             )
--             DELETE FROM Exam
--             WHERE ExamID = (SELECT *FROM CTE_EXAMID_3YEARS);
-- 		END$$
-- 	DELIMITER ;

-- 	CALL sp_del_exam_3Years();


-- dap an 
	DROP PROCEDURE IF EXISTS SP_DeleteExamBefore3Year;
	DELIMITER $$
	CREATE PROCEDURE SP_DeleteExamBefore3Year()
	BEGIN-- Khai báo biến sử dụng trong chương trình
	DECLARE v_ExamID TINYINT UNSIGNED;
	DECLARE v_CountExam TINYINT UNSIGNED DEFAULT 0;
	DECLARE v_CountExamquestion TINYINT UNSIGNED DEFAULT 0;
	DECLARE i TINYINT UNSIGNED DEFAULT 1;
	DECLARE v_print_Del_info_Exam VARCHAR(50) ;
	-- Tạo bảng tạm
	DROP TABLE IF EXISTS ExamIDBefore3Year_Temp;
	CREATE TABLE ExamIDBefore3Year_Temp
			(
			ID INT PRIMARY KEY AUTO_INCREMENT,
			ExamID INT
            );
	-- Insert dữ liệu bảng tạm
	INSERT INTO ExamIDBefore3Year_Temp(ExamID)
	SELECT e.ExamID FROM exam e WHERE (year(now()) - year(e.CreateDate)) >2;
	-- Lấy số lượng số Exam và ExamQuestion cần xóa.
	SELECT count(1) INTO v_CountExam FROM ExamIDBefore3Year_Temp;
	SELECT count(1) INTO v_CountExamquestion FROM examquestion ex
	INNER JOIN ExamIDBefore3Year_Temp et ON ex.ExamID = et.ExamID;
	-- Thực hiện xóa trên bảng Exam và ExamQuestion sử dụng Procedure đã tạo ở Question9 bên trên
	WHILE (i <= v_CountExam) DO
		SELECT ExamID INTO v_ExamID FROM ExamIDBefore3Year_Temp WHERE ID=i;
		CALL sp_DeleteExamWithID(v_ExamID);
		SET i = i +1;
	END WHILE;
	-- In câu thông báo
	SELECT CONCAT("DELETE ",v_CountExam," rows IN Exam AND ", v_CountExamquestion ," rows IN ExamQuestion") INTO v_print_Del_info_Exam;
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = v_print_Del_info_Exam ;
	-- Xóa bảng tạm sau khi hoàn thành
	DROP TABLE IF EXISTS ExamIDBefore3Year_Temp;
	END$$
	DELIMITER ;
	-- Run Procedure
	Call SP_DeleteExamBefore3Year();

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc ???
	DROP PROCEDURE IF EXISTS sp_del_departmentname;
	DELIMITER $$
	CREATE PROCEDURE sp_del_departmentname(IN in_deptName NVARCHAR(50))
		BEGIN
			UPDATE 	`Account`
				SET		DepartmentID = 8
				WHERE	DepartmentID = (SELECT 	DepartmentID	
										FROM	Department
										WHERE 	DepartmentName = in_deptName);
			DELETE 
			FROM	Department
			WHERE	DepartmentName = in_deptName;
		END$$
	DELIMITER ;

	CALL sp_del_departmentname('ky thuat');



-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
	DROP PROCEDURE IF EXISTS sp_CountQuesInMonth;
	DELIMITER $$
	CREATE PROCEDURE sp_CountQuesInMonth()
	BEGIN
			SELECT EachMonthInYear.MONTH, COUNT(QuestionID) AS COUNT
			FROM
			(
				 SELECT 1 AS MONTH
				 UNION SELECT 2 AS MONTH
				 UNION SELECT 3 AS MONTH
				 UNION SELECT 4 AS MONTH
				 UNION SELECT 5 AS MONTH
				 UNION SELECT 6 AS MONTH
				 UNION SELECT 7 AS MONTH
				 UNION SELECT 8 AS MONTH
				 UNION SELECT 9 AS MONTH
				 UNION SELECT 10 AS MONTH
				 UNION SELECT 11 AS MONTH
				 UNION SELECT 12 AS MONTH
			) AS EachMonthInYear
			LEFT JOIN Question ON EachMonthInYear.MONTH = MONTH(CreateDate) 
            AND YEAR(NOW()) = YEAR(CreateDate)
			GROUP BY EachMonthInYear.MONTH
			ORDER BY EachMonthInYear.MONTH ASC;
	END$$
	DELIMITER ;

	CALL sp_CountQuesInMonth();
    
    
	DROP PROCEDURE IF EXISTS sp_CountQuesInMonth02;
	DELIMITER $$
	CREATE PROCEDURE sp_CountQuesInMonth02()
	BEGIN
		WITH CTE_12Months AS (
				 SELECT 1 AS MONTH
				 UNION SELECT 2 AS MONTH
				 UNION SELECT 3 AS MONTH
				 UNION SELECT 4 AS MONTH
				 UNION SELECT 5 AS MONTH
				 UNION SELECT 6 AS MONTH
				 UNION SELECT 7 AS MONTH
				 UNION SELECT 8 AS MONTH
				 UNION SELECT 9 AS MONTH
				 UNION SELECT 10 AS MONTH
				 UNION SELECT 11 AS MONTH
				 UNION SELECT 12 AS MONTH
	)	
	SELECT M.MONTH, count(month(Q.CreateDate)) AS SL  FROM CTE_12Months M
	LEFT JOIN (SELECT * FROM question Q1 WHERE year(Q1.CreateDate) = year(now()) )  Q ON M.MONTH = month(Q.CreateDate) 
	GROUP BY M.MONTH;
	END$$
	DELIMITER ;

	Call sp_CountQuesInMonth02();
    
-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
	DROP PROCEDURE IF EXISTS sp_CountQuesBefore6Month;
	DELIMITER $$
	CREATE PROCEDURE sp_CountQuesBefore6Month()
	BEGIN
	WITH CTE_Talbe_6MonthBefore AS (
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS MONTH,
			YEAR(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS `YEAR`
			UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS MONTH,
			YEAR(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS `YEAR`
			UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS MONTH,
			YEAR(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS `YEAR`
			UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS MONTH,
			YEAR(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS `YEAR`
			UNION
			SELECT MONTH(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS MONTH,
			YEAR(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS `YEAR`
			UNION
			SELECT MONTH(NOW()) AS MONTH, YEAR(NOW()) AS `YEAR`
			)
	SELECT M.MONTH,M.YEAR, 
		CASE
		WHEN COUNT(QuestionID) = 0 THEN 'không có câu hỏi nào trong tháng'
		ELSE COUNT(QuestionID)
		END AS SL
	FROM CTE_Talbe_6MonthBefore M
	LEFT JOIN (SELECT * FROM question where CreateDate >= DATE_SUB(NOW(),INTERVAL 6 MONTH) AND CreateDate <= now())  AS Sub_Question 
    ON M.MONTH = MONTH(CreateDate)
	GROUP BY M.MONTH
	ORDER BY M.MONTH ASC;
	END$$
	DELIMITER ;

	-- Run:
	CALL sp_CountQuesBefore6Month;




