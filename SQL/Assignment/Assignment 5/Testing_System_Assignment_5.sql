/*===============Testing_System_Assignment_5===============*/
/*=========================================================*/
	USE TestingSystem;
-- Exercise 1: Tiếp tục với Database Testing System
-- (Sử dụng subquery hoặc CTE)
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
/* Tao View */
	CREATE OR REPLACE VIEW vw_nhanvien_sale AS
    SELECT A.FullName, D.departmentName FROM `ACCOUNT` A
    JOIN department D ON D.departmentID = A.departmentID
    WHERE D.DepartmentName = 'SALE';
    
    SELECT *FROM vw_nhanvien_sale;

/* Tao CTE */
	WITH nhanvien_sale AS (
		SELECT A.FullName, D.departmentName FROM `ACCOUNT` A
		JOIN department D ON D.departmentID = A.departmentID
		WHERE D.departmentName = 'SALE')
	SELECT *FROM nhanvien_sale;
    
-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
/* Tao View*/
	CREATE OR REPLACE VIEW vw_acc_maxGroup AS
    SELECT A.*,COUNT(GA.groupID) AS 'SL'
    FROM `ACCOUNT` A
    JOIN groupaccount GA ON GA.AccountID = A.AccountID
    GROUP BY A.AccountID
    HAVING SL = (SELECT MAX(COUNT_GROUP) FROM
				(SELECT COUNT(GA.groupID) AS COUNT_GROUP
				FROM `ACCOUNT` A
				JOIN groupaccount GA ON GA.AccountID = A.AccountID
				GROUP BY A.AccountID) AS MAX_GROUP);
    
    SELECT * FROM vw_acc_maxGroup;
    
/* Tao CTE */
    WITH CTE_GETMAX AS (SELECT MAX(COUNT_GROUP) FROM
				(SELECT COUNT(GA.groupID) AS COUNT_GROUP
					FROM `ACCOUNT` A
					JOIN groupaccount GA ON GA.AccountID = A.AccountID
					GROUP BY A.AccountID) AS MAX_GROUP)
    SELECT A.*,COUNT(GA.AccountID) AS 'SL'
    FROM `ACCOUNT` A
    JOIN groupaccount GA ON GA.AccountID = A.AccountID
    GROUP BY A.AccountID
    HAVING SL = (SELECT * FROM CTE_GETMAX);

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
/* Tao View*/
	CREATE OR REPLACE VIEW vw_content_too_long AS
	SELECT Content,length(Content) AS 'DO DAI'  
    FROM question
	WHERE (length(Content) > 30);
	
    SELECT * FROM vw_content_too_long;

	DELETE FROM vw_content_too_long;
/* Tao CTE */
	WITH CTE_CONTENT AS (SELECT Content,length(Content) AS 'DO DAI'  
    FROM question
	WHERE (length(Content) > 35))
    SELECT * FROM CTE_CONTENT;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
/* Tao View*/	
    CREATE OR REPLACE VIEW vw_dept_max_Acc AS
    SELECT D.*, COUNT(D.DepartmentID) AS 'SL' FROM department D
    JOIN `ACCOUNT` A ON D.DepartmentID = A.DepartmentID
    GROUP BY D.DepartmentID
    HAVING SL = (SELECT MAX(MAX_ACC) FROM
    (SELECT  COUNT(A.accountID) AS 'MAX_ACC' FROM `ACCOUNT` A
	GROUP BY A.DepartmentID) AS SL_MAX_ACC);

	SELECT * FROM vw_dept_max_Acc;

/* Tao CTE */
	WITH CTE_GETMAX AS 	(SELECT MAX(MAX_ACC) FROM
						(SELECT  COUNT(A.accountID) AS 'MAX_ACC' FROM `ACCOUNT` A
						GROUP BY A.DepartmentID) AS SL_MAX_ACC)
	SELECT 
		D.*, COUNT(D.DepartmentID) AS 'SL'
	FROM department D
	JOIN `ACCOUNT` A ON D.DepartmentID = A.DepartmentID
	GROUP BY D.DepartmentID
	HAVING SL = (SELECT * FROM CTE_GETMAX);

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
/* Tao View*/	
	CREATE OR REPLACE VIEW vw_ques_by_Nguyen AS
	SELECT Q.questionID, Q.content, A.FullName FROM Question Q
	JOIN `ACCOUNT` A ON A.accountID = Q.creatorID
	HAVING substring_index(FullName,' ',1) = 'Nguyen';

	SELECT * FROM vw_ques_by_Nguyen;

/* Tao CTE */
	WITH CTE_QUES_BY_NGUYEN AS 
		(SELECT Q.questionID, Q.content, A.FullName FROM Question Q
		JOIN `ACCOUNT` A ON A.accountID = Q.CreatorID
		HAVING substring_index(FullName,' ',1) = 'Nguyen')
    SELECT * FROM CTE_QUES_BY_NGUYEN;


