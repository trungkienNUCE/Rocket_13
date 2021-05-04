/*===============Testing_System_Assignment_5===============*/
/*=========================================================*/
	USE TestingSystem;
-- Exercise 1: Tiếp tục với Database Testing System
-- (Sử dụng subquery hoặc CTE)
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
/* Tao View */
	CREATE OR REPLACE VIEW v_nhanvien_sale AS
    SELECT A.FULLNAME, D.DEPARTMENTNAME FROM `ACCOUNT` A
    JOIN DEPARTMENT D ON D.DEPARTMENTID = A.DEPARTMENTID
    WHERE D.DEPARTMENTNAME = 'SALE';
    
    SELECT *FROM v_nhanvien_sale;

/* Tao CTE */
	WITH nhanvien_sale AS (
		SELECT A.FULLNAME, D.DEPARTMENTNAME FROM `ACCOUNT` A
		JOIN DEPARTMENT D ON D.DEPARTMENTID = A.DEPARTMENTID
		WHERE D.DEPARTMENTNAME = 'SALE')
	SELECT *FROM nhanvien_sale;
    
-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
/* Tao View*/
	CREATE OR REPLACE VIEW v_acc_maxGroup AS
    SELECT A.*,COUNT(GA.ACCOUNTID) AS 'SL'
    FROM `ACCOUNT` A
    JOIN GROUPACCOUNT GA ON GA.ACCOUNTID = A.ACCOUNTID
    GROUP BY A.ACCOUNTID
    HAVING SL = (SELECT MAX(COUNT_ACC) FROM
				(SELECT COUNT(GA.ACCOUNTID) AS COUNT_ACC
				FROM `ACCOUNT` A
				JOIN GROUPACCOUNT GA ON GA.ACCOUNTID = A.ACCOUNTID
				GROUP BY A.ACCOUNTID) AS MAX_ACCOUNID);
    
    SELECT * FROM v_acc_maxGroup;
    
    /* Tao CTE */
    WITH CTE_GETMAX AS (SELECT MAX(COUNT_ACC) FROM
			(SELECT COUNT(GA.ACCOUNTID) AS COUNT_ACC
			FROM `ACCOUNT` A
			JOIN GROUPACCOUNT GA ON GA.ACCOUNTID = A.ACCOUNTID
			GROUP BY A.ACCOUNTID) AS MAX_ACCOUNID)
    SELECT A.*,COUNT(GA.ACCOUNTID) AS 'SL'
    FROM `ACCOUNT` A
    JOIN GROUPACCOUNT GA ON GA.ACCOUNTID = A.ACCOUNTID
    GROUP BY A.ACCOUNTID
    HAVING SL = (SELECT * FROM CTE_GETMAX);

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi



-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất


-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo





