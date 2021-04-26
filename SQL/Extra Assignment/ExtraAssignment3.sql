USE Fresher;

-- Question 1: Thêm ít nhất 10 bản ghi vào table
INSERT INTO Trainee (Full_Name			, Birth_Date	, Gender, ET_IQ	, ET_Gmath	, ET_English	,	VTI_Account, Training_Class	, Evaluation_Notes) 
VALUES
					('Tran Trung Kien'	,'1999-08-09'	,'M'	,'20'	,'20'		,'50'			,	'kien'		,'Rocket13'		,'Oke'			),
                    ('Nguyen Van A'		,'2000-12-09'	,'M'	,'10'	,'20'		,'45'			,	'A'		,'Rocket14'		,'No notes'		),
                    ('Hoang Tien Viet'	,'1998-08-1'	,'M'	,'13'	,'1'		,'12'			,	'Viet'		,'Rocket11'		,'No notes'		),
                    ('Pham Hoai Nam'	,'1999-11-09'	,'M'	,'10'	,'2'		,'21'			,	'Nam'		,'Rocket09'		,'Perfect'		),
                    ('Nguyen Viet Khoi'	,'1999-09-09'	,'M'	,'13'	,'12'		,'43'			,	'Khoi'		,'Rocket14'		,'No notes'		),
                    ('Do Ba Duy'		,'1999-12-23'	,'M'	,'19'	,'18'		,'21'			,	'Duy1'		,'Rocket13'		,'No notes'		),
                    ('Phan Van Hieu'	,'1996-06-24'	,'M'	,'16'	,'20'		,'37'			,	'Hieu'		,'Rocket13'		,'No notes'		),
                    ('Pham Thien Duy'	,'2001-08-09'	,'M'	,'19'	,'16'		,'29'			,	'Duy2'		,'Rocket17'		,'No notes'		);


-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau
SELECT GROUP_CONCAT(Full_name) AS 'Ten', month(Birth_Date) AS 'Thang sinh'
FROM Trainee
GROUP BY month(Birth_Date);

-- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT * FROM Trainee
WHERE length(Full_name) = (SELECT (MAX(length(FUll_name))) FROM Trainee);

-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
--  ET_IQ + ET_Gmath>=20
--  ET_IQ>=8
--  ET_Gmath>=8
--  ET_English>=18
SELECT * FROM Trainee
WHERE ET_IQ + ET_Gmath>=20 AND ET_IQ>=8 AND ET_Gmath>=8 AND ET_English>=18;

-- Question 5: xóa thực tập sinh có TraineeID = 3
DELETE FROM Trainee
WHERE TraineeID = 3;

-- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
UPDATE Trainee
SET Training_Class = 'Rocket7'
WHERE TraineeID = 5;
