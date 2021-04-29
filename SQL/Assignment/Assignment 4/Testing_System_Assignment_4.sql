/*===============Testing_System_Assignment_4===============*/
/*=========================================================*/
	USE TestingSystem;
-- Exercise 1: Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
	SELECT 		a.*,d.DepartmentName AS 'Phòng ban' FROM `account` a
	INNER JOIN 	department d ON a.DepartmentID = d.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
	SELECT * FROM `account`
    WHERE CreateDate > '2020-12-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
	SELECT 		a.AccountID,a.Email,a.Fullname,p.PositionName FROM `account` a
	INNER JOIN 	position p ON a.PositionID = p.PositionID
    HAVING 		p.PositionName = 'Dev';
    
-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
	SELECT 		d.DepartmentID AS 'ID Phòng', d.DepartmentName AS 'Tên Phòng', COUNT(a.DepartmentID) AS 'SL Nhân Viên'
	FROM 		`Account` a 
	INNER JOIN 	Department  d ON d.DepartmentID = a.DepartmentID
	GROUP BY 	a.DepartmentID
	HAVING 		COUNT(a.DepartmentID) > 2;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
	SELECT 		Q.QuestionID, Q.Content, Count(Q.Content) AS 'SO LUONG'
	FROM		Question Q 
	INNER JOIN 	ExamQuestion EQ ON Q.QuestionID = EQ.QuestionID
	GROUP BY	Q.Content
	HAVING		COUNT(Q.Content) = (SELECT MAX(CountQ) FROM		
											(SELECT 		COUNT(Q.QuestionID) AS CountQ FROM	ExamQuestion EQ 
											INNER JOIN 		Question Q ON EQ.QuestionID = Q.QuestionID
											GROUP BY		Q.QuestionID) AS MaxContent);
                                            
     -- CACH 2 CTE
     WITH CTE_GETMAX AS  (SELECT MAX(CountQ) FROM		
											(SELECT 		COUNT(Q.QuestionID) AS CountQ FROM	ExamQuestion EQ 
											INNER JOIN 		Question Q ON EQ.QuestionID = Q.QuestionID
											GROUP BY		Q.QuestionID) AS MaxContent)
	SELECT 		EQ.QuestionID, Q.Content, Count(Q.Content) AS 'SO LUONG' FROM examquestion EQ
	INNER JOIN 	question Q ON Q.QuestionID = EQ.QuestionID
	GROUP BY 	EQ.QuestionID
	HAVING 		count(EQ.QuestionID) = (SELECT * FROM CTE_GETMAX);                                             
    
-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
	SELECT		CQ.CategoryID, CQ.CategoryName, COUNT(Q.CategoryID) AS 'SO LUONG'
	FROM		CategoryQuestion CQ 
	LEFT JOIN 	Question Q ON CQ.CategoryID = Q.CategoryID
	GROUP BY	CQ.CategoryID
	ORDER BY	CQ.CategoryID ASC;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
	SELECT 		Q.content, COUNT(Ex.QuestionID)
    FROM 		Question Q
    LEFT JOIN 	Examquestion Ex ON Q.QuestionID = Ex.QuestionID
    GROUP BY 	Q.QuestionID;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
	SELECT 		Q.QuestionID, Q.Content, COUNT(A.QuestionID) AS 'SO_LUONG'
	FROM		QUESTION Q 
	INNER JOIN 	answer A ON A.QuestionID = Q.QuestionID
	GROUP BY 	A.QuestionID
    HAVING  	SO_LUONG =  (SELECT 	MAX(CountA) FROM		
								(SELECT 	COUNT(A.QUESTIONID) AS CountA
								FROM		QUESTION Q 
								INNER JOIN 	answer A ON A.QuestionID = Q.QuestionID
								GROUP BY	A.QuestionID) AS MAXCOUNTA);
	-- CACH 2 DUNG CTE
    WITH CTE_GETMAX AS (SELECT 	MAX(CountA) FROM		
								(SELECT 	COUNT(A.QUESTIONID) AS CountA
								FROM		QUESTION Q 
								INNER JOIN 	answer A ON A.QuestionID = Q.QuestionID
								GROUP BY	A.QuestionID) AS MAXCOUNTA)
	SELECT 		Q.QuestionID, Q.Content, COUNT(A.QuestionID) AS 'SO_LUONG' FROM QUESTION Q
    INNER JOIN 	ANSWER A ON A.QUESTIONID = Q.QUESTIONID
    GROUP BY 	A.QUESTIONID
    HAVING 		SO_LUONG = (SELECT * FROM CTE_GETMAX);

-- Question 9: Thống kê số lượng account trong mỗi group
	SELECT 		G.GroupID, G.GroupName,COUNT(GA.AccountID) AS 'SL account'
    FROM 		`Group` G
    LEFT JOIN  	Groupaccount GA ON G.GroupID = GA.GroupID
    GROUP BY 	G.GroupID;

-- Question 10: Tìm chức vụ có ít người nhất
	SELECT 		P.PositionID, P.PositionName , COUNT(A.PositionID) AS 'SO_LUONG'
	FROM		Position P 
	INNER JOIN 	`Account` A ON P.PositionID = A.PositionID
	GROUP BY 	P.PositionID
	HAVING  	SO_LUONG =  (SELECT 	MIN(CountP) FROM		
								(SELECT 	COUNT(P.PositionID) AS CountP
								FROM		Position P 
								INNER JOIN 	`Account` A ON P.PositionID = A.PositionID		
								GROUP BY	P.PositionID) AS MINCOUNTP);
    
    -- CACH 2 DUNG CTE 
    WITH CTE_GETMIN AS (SELECT 	MIN(CountP) FROM		
								(SELECT 	COUNT(P.PositionID) AS CountP
								FROM		Position P 
								INNER JOIN 	`Account` A ON P.PositionID = A.PositionID		
								GROUP BY	P.PositionID) AS MINCOUNTP)
	SELECT 		P.PositionID, P.PositionName , COUNT(A.PositionID) AS 'SO_LUONG'
	FROM		Position P 
	INNER JOIN 	`Account` A ON P.PositionID = A.PositionID
	GROUP BY 	P.PositionID
    HAVING 		SO_LUONG = (SELECT * FROM CTE_GETMIN);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
	SELECT		a.DepartmentID, d.DepartmentName, p.PositionName, COUNT(p.PositionName) AS 'SO_LUONG'
	FROM 		`Account` a
	INNER JOIN 	department d 	ON d.DepartmentID = a.DepartmentID
	INNER JOIN 	position p 		ON a.PositionID = p.PositionID
	GROUP BY	a.DepartmentID, a.PositionID
    ORDER BY 	a.DepartmentID;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, 
-- loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
	SELECT 		Q.QUESTIONID AS 'ID QUESTION',Q.CONTENT AS 'CAU HOI',T.TYPENAME AS 'LOAI CAU HOI',AC.FULLNAME AS 'NGUOI TAO CAU HOI',A.CONTENT AS 'CAU TRA LOI' FROM QUESTION Q
    INNER JOIN 	ANSWER A ON A.QUESTIONID = Q.QUESTIONID
    INNER JOIN 	TYPEQUESTION T ON Q.TYPEID = T.TYPEID
    INNER JOIN 	ACCOUNT AC ON AC.ACCOUNTID = Q.CREATORID
    ORDER BY 	Q.QUESTIONID;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
	SELECT 		T.TypeName,COUNT(Q.TypeID) AS 'SL' FROM question Q
	INNER JOIN 	typequestion T ON T.TypeID = Q.TypeID
	GROUP BY 	Q.TypeID;

-- Question 14: Lấy ra group không có account nào
	SELECT 		G.GroupID, G.GroupName,COUNT(GA.AccountID) AS 'SL account'
    FROM 		`Group` G
    LEFT JOIN  	Groupaccount GA ON G.GroupID = GA.GroupID
    WHERE 		GA.AccountID IS NULL;
    
-- Question 15: Lấy ra group không có account nào
	SELECT 		G.GroupID, G.GroupName,COUNT(GA.AccountID) AS 'SL account'
    FROM 		`Group` G
    LEFT JOIN  	Groupaccount GA ON G.GroupID = GA.GroupID
    WHERE 		GA.AccountID IS NULL;
    
-- Question 16: Lấy ra question không có answer nào
	SELECT 		Q.QuestionID, Q.content, COUNT(A.QuestionID) AS 'SL câu tl'
    FROM 		Question Q
    LEFT JOIN 	Answer A ON Q.QuestionID = A.QuestionID
    WHERE 		A.QuestionID IS NULL;

-- Exercise 2: Union
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
	SELECT 	a.accountID,a.fullname
    FROM 	`account` a 
    JOIN 	GroupAccount Ga ON a.accountID = ga.accountID
    WHERE 	ga.accountID = 4;

-- b) Lấy các account thuộc nhóm thứ 2
	SELECT 	a.accountID,a.fullname
    FROM 	`account` a 
    JOIN 	GroupAccount Ga ON a.accountID = ga.accountID
    WHERE 	ga.accountID = 5;

-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
	SELECT 		a.accountID,a.fullname
	FROM 		`Account` a
	JOIN 		GroupAccount ga ON a.AccountID = ga.AccountID
	WHERE 		GA.GroupID = 4
	UNION
	SELECT 		a.accountID,a.fullname
	FROM 		`Account` a
	JOIN 		GroupAccount ga ON a.AccountID = ga.AccountID
	WHERE 		GA.GroupID = 5;

-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
	SELECT 		g.groupID, g.GroupName, COUNT(1) AS 'SL_Nhan_Vien'
	FROM 		`Group` g
	JOIN 		GroupAccount ga ON g.GroupID = ga.GroupID
	GROUP BY	ga.groupID
	HAVING 		SL_Nhan_Vien >= 5;

-- b) Lấy các group có nhỏ hơn 7 thành viên
	SELECT 		g.groupID, g.GroupName, COUNT(1) AS 'SL_Nhan_Vien'
	FROM 		`Group` g
	JOIN 		GroupAccount ga ON g.GroupID = ga.GroupID
	GROUP BY	ga.groupID
	HAVING 		SL_Nhan_Vien < 7;

-- c) Ghép 2 kết quả từ câu a) và câu b)
	SELECT 		g.groupID, g.GroupName, COUNT(1) AS 'SL_Nhan_Vien'
	FROM 		`Group` g
	JOIN 		GroupAccount ga ON g.GroupID = ga.GroupID
	GROUP BY	ga.groupID
	HAVING 		SL_Nhan_Vien >= 2
    UNION
	SELECT 		g.groupID, g.GroupName, COUNT(1) AS 'SL_Nhan_Vien'
	FROM 		`Group` g
	JOIN 		GroupAccount ga ON g.GroupID = ga.GroupID
	GROUP BY	ga.groupID
	HAVING 		SL_Nhan_Vien < 7
    ORDER BY 	GroupID;