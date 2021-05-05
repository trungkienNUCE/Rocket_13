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
    
	Call sp_account_of_groupID(5);


-- Nhập tên group in ra số lượng account của group đó
	-- DELIMITER $$
-- 	DROP PROCEDURE IF EXISTS sp_account_of_groupName;
-- 	CREATE PROCEDURE sp_account_of_groupName(IN in_group_name NVARCHAR(50))
-- 	BEGIN
-- 		SELECT g.GroupName, COUNT(1) AS SL FROM groupaccount ga 
-- 		INNER JOIN `group` g 
-- 		WHERE g.GroupName = in_group_name;
-- 	END$$
-- 	DELIMITER ;

-- 	Call sp_account_of_groupName('Development');
    
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
		SELECT 		Q.TypeID, t.typename,COUNT(q.TypeID) AS SL
		FROM		Question q
        INNER JOIN Typequestion T ON T.TypeID = Q.TypeID
		GROUP BY 	q.TypeID
		HAVING		COUNT(q.TypeID) = (SELECT * FROM CTE_MAX_QUES);
	END$$
	DELIMITER ;
    
	Call sp_max_typequesName();

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào



-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công


-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất


-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID


-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa) Sau đó in số lượng record đã remove từ các table liên quan trong khi removing


-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc


-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay


-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")


