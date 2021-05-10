DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE Fresher;
USE Fresher;


-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
-- tao bang traninee 
CREATE TABLE `trainee` (
  `TraineeID` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `Full_Name` VARCHAR(50) NOT NULL,
  `Birth_Date` DATE DEFAULT NULL,
  `Gender` ENUM('M','F','Unkown') NOT NULL,
  `ET_IQ` TINYINT UNSIGNED NOT NULL,
  `ET_Gmath` TINYINT UNSIGNED NOT NULL,
  `ET_English` TINYINT UNSIGNED NOT NULL,
  `Training_Class` CHAR(10) NOT NULL,
  `Evaluation_Notes` NVARCHAR(255) DEFAULT NULL,
  CONSTRAINT `trainee_chk_1` CHECK ((`ET_IQ` <= 20)),
  CONSTRAINT `trainee_chk_2` CHECK ((`ET_Gmath` <= 20)),
  CONSTRAINT `trainee_chk_3` CHECK ((`ET_English` <= 50))
);


-- Question 2: Thêm ít nhất 10 bản ghi vào table
-- chen du lieu
	INSERT INTO trainee(Full_Name			, Birth_Date	, Gender, ET_IQ , ET_Gmath , ET_English , Training_Class , Evaluation_Notes)
    VALUES
						('Tran Trung Kien'	, '1999-08-09'	, 'M'	, 20	, 20		, 50		, 'VTI001'		, 	'DHXD' 			),
                        ('Hoang Tien Viet'	, '1996-12-09'	, 'M'	, 16	, 12		, 32		, 'VTI002'		, 	'DHBK' 			),
                        ('Nguyen Duy Anh'	, '1979-03-02'	, 'M'	, 17	, 2			, 45		, 'VTI001'		, 	'DHCNQG' 		),
                        ('Phan Van Tuyen'	, '1998-04-01'	, 'M'	, 14	, 1			, 34		, 'VTI003'		, 	'DHQG' 			),
                        ('Luong Xuan Hieu'	, '1994-05-12'	, 'M'	, 12	, 11		, 25		, 'VTI004'		, 	'BCVT' 			),
                        ('Pham Hoai Nam'	, '1993-01-22'	, 'M'	, 12	, 15		, 34		, 'VTI005'		, 	'KDCN' 			),
                        ('Nguyen Viet Khoi'	, '1991-05-12'	, 'Unkown'	, 12	, 17		, 36		, 'VTI006'		, 	'DHXD' 			),
                        ('Vu Quoc Anh'		, '1991-03-03'	, 'M'	, 20	, 15		, 48		, 'VTI001'		, 	'DHXD' 			),
                        ('Pham Thi Van Anh'	, '1993-01-24'	, 'F'	, 18	, 12		, 17		, 'VTI002'		, 	'DHBK' 			),
                        ('Vu Cao Ky'		, '1999-07-22'	, 'M'	, 20	, 20		, 11		, 'VTI007'		, 	'DHXD' 			);

-- Question 3: Insert 1 bản ghi mà có điểm ET_IQ =30. Sau đó xem kết quả.

	INSERT INTO trainee(Full_Name			, Birth_Date	, Gender, ET_IQ , ET_Gmath , ET_English , Training_Class , Evaluation_Notes)
    VALUES
						('Tran Trung Kien'	, '1999-08-09'	, 'M'	, 30	, 20		, 50		, 'VTI001'		, 	'DHXD' 			);


-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào,
-- và sắp xếp theo ngày sinh. Điểm ET_IQ >=12, ET_Gmath>=12, ET_English>=20

	SELECT * FROM trainee
    WHERE ET_IQ >=12 AND ET_Gmath>=12 AND ET_English>=20
    ORDER BY Birth_Date ASC;

-- Question 5: Viết lệnh để lấy ra thông tin thực tập sinh có tên bắt đầu bằng chữ N và kết thúc bằng chữ C
	
    SELECT * FROM trainee
    WHERE substring_index(Full_name,' ',-1)  LIKE 'K%N';

-- Question 6: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có ký thự thứ 2 là chữ G
	
	SELECT * FROM trainee
    WHERE substring_index(Full_name,' ',-1)  LIKE '_I%';

-- Question 7: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có 10 ký tự và ký tự cuối cùng là C
	
	SELECT * FROM trainee
    WHERE length(Full_name) = 9 AND substring_index(Full_name,' ',-1)  LIKE '%Y';

-- Question 8: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, lọc bỏ các tên trùng nhau.
	
    SELECT DISTINCT Full_name FROM trainee;

-- Question 9: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, sắp xếp các tên này theo thứ tự từ A-Z.

	SELECT Full_name FROM trainee
    ORDER BY substring_index(Full_name,' ',-1);

-- Question 10: Viết lệnh để lấy ra thông tin thực tập sinh có tên dài nhất

	SELECT * FROM trainee
    WHERE length(Full_name) = (SELECT MAX(length(Full_name)) FROM trainee);
    
-- Question 11: Viết lệnh để lấy ra ID, Fullname và Ngày sinh thực tập sinh có tên dài nhất
	
    SELECT traineeID, Full_name, Birth_Date FROM trainee
    WHERE length(Full_name) = (SELECT MAX(length(Full_name)) FROM trainee);

-- Question 12: Viết lệnh để lấy ra Tên, và điểm IQ, Gmath, English thực tập sinh có tên dài nhất

	SELECT substring_index(Full_name,' ',-1) AS 'Ten', ET_IQ, ET_Gmath, ET_English FROM trainee
    WHERE length(Full_name) = (SELECT MAX(length(Full_name)) FROM trainee);

-- Question 13 Lấy ra 5 thực tập sinh có tuổi nhỏ nhất
	
	SELECT *, Year(now()) - Year(Birth_Date)  AS 'Tuoi' FROM trainee
	ORDER BY Tuoi ASC
	LIMIT 5;
    
-- Question 14: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là
-- những người thỏa mãn số điểm như sau:
-- • ET_IQ + ET_Gmath>=20
-- • ET_IQ>=8
-- • ET_Gmath>=8
-- • ET_English>=18

	SELECT * FROM trainee
	WHERE ET_IQ + ET_Gmath>=20
	AND ET_IQ>=8
	AND ET_Gmath>=8
	AND ET_English>=18;

