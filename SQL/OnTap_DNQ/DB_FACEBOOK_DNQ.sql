-- Xây dựng DB Facebook Management.
-- Facebook đang là 1 công ty đa quốc gia với nhiều trụ sở và nhân viên trên toàn thế giới, bạn
-- hãy xây dựng 1 DB có tên Facebook_DB để quản lý nhân viên trên toàn thế giới cho
-- Facebook, với số lượng nhân viên lên đến hàng triệu người. Chúng ta sẽ quản lý về nhân viên
-- (Staff), quản lý về đất nước của mỗi nhân viên, ngôn ngữ chính được sử dụng tại mỗi nước
-- đó (National), và vị trí làm việc của nhân viên tại từng quốc gia (Office)
-- National (National_id, National_Name, Language_Main)
-- Office (Office_id, Street_Address, National_id)
-- Staff (Staff_id, First_Name, Last_Name, Email, Office_id)

/* -------------BÀI LÀM-------------- */

DROP DATABASE IF EXISTS Facebook_DB;
CREATE DATABASE Facebook_DB;
USE Facebook_DB;

/*===============CREATE TABLE & CONSTRAINS===============*/
/*=======================================================*/
-- DROP TABLE National
DROP TABLE IF EXISTS `National`;
-- CREATE TABLE National
CREATE TABLE `National`
(
		National_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        National_Name VARCHAR(50) NOT NULL,
        Language_Main VARCHAR(50) NOT NULL
);

-- DROP TABLE Office
DROP TABLE IF EXISTS `Office`;
-- CREATE TABLE Office
CREATE TABLE `Office`
(
		Office_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        Street_Address VARCHAR(50) NOT NULL,
        National_id INT UNSIGNED,
        FOREIGN KEY (National_id) REFERENCES `National`(National_id) 
);

-- DROP TABLE Staff
DROP TABLE IF EXISTS `Staff`;
-- CREATE TABLE Staff
CREATE TABLE `Staff`
(
		Staff_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        First_Name VARCHAR(50) NOT NULL,
        Last_Name VARCHAR(50) NOT NULL,
        Email VARCHAR(50) NOT NULL UNIQUE,
        Office_id INT UNSIGNED,
        FOREIGN KEY (Office_id) REFERENCES `Office`(Office_id)
);


/*===============INSERT VALUES===============*/
/*===========================================*/

INSERT INTO `National`(National_Name 	, Language_Main	)
VALUES
					('Viet Nam'			, 'Vietnamese'	),
					('National 02'		, 'Language 02'	),
                    ('National 03'		, 'Language 03'	),
                    ('National 04'		, 'Language 04'	),
                    ('National 05'		, 'Language 05'	);


INSERT INTO `Office`(Street_Address , National_id	)
VALUES
					('Le Thanh Nghi'	, '1'	),
					('Street 02'		, '2'	),
                    ('Street 03'		, '2'	),
                    ('Street 04'		, '4'	),
                    ('Street 05'		, '3'	);



INSERT INTO `Staff`(First_Name 		, Last_Name 	, Email						, Office_id		)
VALUES
					('Kien'			, 'Tran Trung' 		, 'trantrungkien@gmail.com'	, '1'			),
					('FirstName 02'	, 'LastName 02' 	, 'Email02@gmail.com'		, '2'			),
                    ('FirstName 03'	, 'LastName 03' 	, 'Email03@gmail.com'		, '4'			),
                    ('FirstName 04'	, 'LastName 04' 	, 'Email04@gmail.com'		, '3'			),
                    ('FirstName 05'	, 'LastName 05' 	, 'Email05@gmail.com'		, '1'			),
                    ('FirstName 06'	, 'LastName 06' 	, 'Email06@gmail.com'		, '5'			);


-- Ques3: Bạn hãy lấy dữ liệu của tất cả nhân viên đang làm việc tại Vietnam.
	SELECT S.staff_id AS ID, concat(S.First_Name,' ',S.Last_Name) AS 'FullName', s.email AS Email, O.Street_Address FROM Staff S
    JOIN Office O ON O.Office_id = S.Office_id
    JOIN `National` N ON N.National_id = O.National_id
    WHERE N.National_Name = 'Viet Nam';

-- Ques4: Lấy ra ID, FullName, Email, National của mỗi nhân viên.
	SELECT S.staff_id AS ID, concat(S.First_Name,' ',S.Last_Name) AS 'FullName', s.email AS Email,N.national_name AS National FROM Staff S
    JOIN Office O ON O.Office_id = S.Office_id
    JOIN `National` N ON N.National_id = O.National_id
    ORDER BY ID;

-- Ques5: Lấy ra tên nước mà nhân viên có Email: "daonq@viettel.com.vn" đang làm việc
	SELECT S.staff_id AS ID, concat(S.First_Name,' ',S.Last_Name) AS 'FullName', s.email AS Email,N.national_name AS National FROM Staff S
    JOIN Office O ON O.Office_id = S.Office_id
    JOIN `National` N ON N.National_id = O.National_id
    WHERE S.email = 'trantrungkien@gmail.com';

-- Ques6: Bạn hãy tìm xem trên hệ thống có quốc gia nào có thông tin trên hệ thống nhưng
-- không có nhân viên nào đang làm việc.
	SELECT n.National_id,n.National_Name FROM facebook_db.staff s
	JOIN office O ON O.Office_id = s.Office_id
	RIGHT JOIN `national` N ON O.National_id = n.National_id
	WHERE o.National_id is null;
    
-- dung CTE tao bang
	WITH cte_office AS
    (
			SELECT DISTINCT o.national_id FROM Office o
            JOIN (SELECT DISTINCT s.office_id FROM staff s) t ON o.office_id = t.office_id
	)
    SELECT * from cte_office ct
    RIGHT JOIN `national` n ON ct.National_id = n.National_id
    WHERE ct.National_id IS NULL;

-- Ques7: Thống kê xem trên thế giới có bao nhiêu quốc gia mà FB đang hoạt động sử dụng
-- tiếng Anh làm ngôn ngữ chính.
	SELECT count(1) AS 'SL' FROM facebook_db.national
	WHERE Language_Main = 'English';

-- Ques8: Viết lệnh để lấy ra thông tin nhân viên có tên (First_Name) có 10 ký tự, bắt đầu bằng
-- chữ N và kết thúc bằng chữ C.
	SELECT *FROM Staff
    WHERE length(First_Name) = 4 AND First_Name LIKE 'K%N';
    
-- Ques9: Bạn hãy tìm trên hệ thống xem có nhân viên nào đang làm việc nhưng do nhập khi
-- nhập liệu bị lỗi mà nhân viên đó vẫn chưa cho thông tin về trụ sở làm việc(Office).
	SELECT *FROM Staff
    WHERE Office_id IS NULL;

-- Ques10: Nhân viên có mã ID =9 hiện tại đã nghỉ việc, bạn hãy xóa thông tin của nhân viên
-- này trên hệ thống.
	DELETE FROM Staff
    WHERE staff_id = 5;

-- Ques11: FB vì 1 lý do nào đó không còn muốn hoạt động tại Australia nữa, và Mark
-- Zuckerberg muốn bạn xóa tất cả các thông tin trên hệ thống liên quan đến quốc gia này. Hãy
-- tạo 1 Procedure có đầu vào là tên quốc gia cần xóa thông tin để làm việc này và gửi lại cho
-- anh ấy.
	DROP PROCEDURE IF EXISTS sp_del_national;
    DELIMITER $$
	CREATE PROCEDURE sp_del_national(IN in_nationalname VARCHAR(50))
	BEGIN
		DELETE FROM `National`
        WHERE National_Name = in_nationalname;
	END$$
	DELIMITER ;
    
	CALL sp_del_national('National 05');

-- dap an
	DROP PROCEDURE IF EXISTS SP_DelNation;
	DELIMITER $$
	CREATE PROCEDURE SP_DelNation(IN natonal_name VARCHAR(50))
	BEGIN
	DECLARE nation_id TINYINT;
	SELECT n.National_id INTO nation_id FROM `national` n WHERE n.National_Name = natonal_name;
	DELETE FROM staff s WHERE s.Office_id IN (SELECT o.Office_id FROM office o WHERE o.National_id = nation_id);
	DELETE FROM office o WHERE o.National_id = nation_id;
	DELETE FROM `national` n WHERE n.National_id = nation_id;
	END $$
	CALL SP_DelNation('Japan');

-- Ques12: Mark muốn biết xem hiện tại đang có bao nhiêu nhân viên trên toàn thế giới đang
-- làm việc cho anh ấy, hãy viết cho anh ấy 1 Function để a ấy có thể lấy dữ liệu này 1 cách
-- nhanh chóng.
	SET GLOBAL log_bin_trust_function_creators = 1;
	DROP FUNCTION IF EXISTS fc_GetNumberOfStaff;
    DELIMITER $$
	CREATE FUNCTION fc_GetNumberOfStaff() RETURNS INT
		BEGIN
			DECLARE v_number INT;
            SELECT count(1) AS 'Number Of Staff' INTO v_number FROM staff;
            RETURN v_number;
		END$$
	DELIMITER ;
    
	Select  fc_GetNumberOfStaff() AS 'Number of staff';
    
-- Ques13: Để thuận tiện cho việc quản trị Mark muốn số lượng nhân viên tại mỗi quốc gia chỉ
-- tối đa 10.000 người. Bạn hãy tạo trigger cho table Staff chỉ cho phép insert mỗi quốc gia có
-- tối đa 10.000 nhân viên giúp anh ấy (có thể cấu hình số lượng nhân viên nhỏ hơn vd 11 nhân
-- viên để Test).
	DROP TRIGGER IF EXISTS TrG_CheckToAddStaffToNational;
	DELIMITER $$
	CREATE TRIGGER TrG_CheckToAddStaffToNational
	BEFORE INSERT ON `staff`
	FOR EACH ROW
		BEGIN
			DECLARE National_id TINYINT;
			DECLARE count_Staff TINYINT;
			SELECT o.National_id INTO National_id FROM office o WHERE o.Office_id = NEW.Office_id;
			SELECT count(1) INTO count_Staff FROM staff s
			INNER JOIN office o ON o.Office_id = s.Office_id
			INNER JOIN `national` n ON n.National_id = o.National_id
			WHERE n.National_id= National_id;
			IF (count_Staff >5) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Cant add more Staff to this Country';
		END IF;
	END$$
	DELIMITER ;
    
	INSERT INTO `staff` (`First_Name`, `Last_Name`, `Email`, `Office_id`)
	VALUES ('FisrtName 12', 'LastName 12', 'Email12@gmail.com', '6');

-- Ques14: Bạn hãy viết 1 Procedure để lấy ra tên trụ sở mà có số lượng nhân viên đang làm
-- việc nhiều nhất.
	DROP PROCEDURE IF EXISTS sp_office_max_staff;
    DELIMITER $$
	CREATE PROCEDURE sp_office_max_staff()
	BEGIN
		WITH Cte_max_staff AS 
			(SELECT max(SL) FROM
				(SELECT COUNT(Office_id) AS 'SL' 
				FROM staff
				GROUP BY Office_id) AS MAXX)
		SELECT 		O.Street_Address , COUNT(S.Office_id) AS 'SL'
		FROM		Office O
        JOIN staff S ON S.Office_id = O.Office_id
        GROUP BY 	S.Office_id
		HAVING		COUNT(S.Office_id) = (SELECT * FROM Cte_max_staff);
	END$$
	DELIMITER ;
    
	Call sp_office_max_staff();


-- Ques15: Bạn hãy viết 1 Function để khi nhập vào thông tin Email của nhân viên thì sẽ trả ra
-- thông tin đầy đủ của nhân viên đó.
-- 	SET GLOBAL log_bin_trust_function_creators = 1;
-- 	DROP FUNCTION IF EXISTS fc_GetFirstNameFromEmail;
-- 	DELIMITER $$
-- 	CREATE FUNCTION fc_GetFirstNameFromEmail(email VARCHAR(50)) RETURNS VARCHAR(50)
-- 	BEGIN
-- 	DECLARE v_first_name VARCHAR(50);
-- 	SELECT s.First_Name INTO v_first_name FROM staff s WHERE s.email = email ;
-- 	RETURN v_first_name;
-- 	END $$
-- 	SELECT fc_GetFirstNameFromEmail('trantrungkien@gmail.com');

	DROP PROCEDURE IF EXISTS sp_GetStaffFromEmail;
	DELIMITER $$
	CREATE PROCEDURE sp_GetStaffFromEmail(IN in_email NVARCHAR(50))
	BEGIN
		SELECT 		s.*, n.national_name,o.street_address
		FROM		staff s
        JOIN Office O ON O.Office_id = S.Office_id
		JOIN `National` N ON N.National_id = O.National_id
		WHERE		s.email = in_email;
	END $$
	DELIMITER ;
	
	Call sp_GetStaffFromEmail('trantrungkien@gmail.com');
    
-- dap an 
	SET GLOBAL log_bin_trust_function_creators = 1;
	DROP FUNCTION IF EXISTS fc_getFullNameFromEmail;
	DELIMITER $$
	CREATE FUNCTION fc_getFullNameFromEmail(email VARCHAR(50)) RETURNS VARCHAR(100)
	BEGIN
	DECLARE fullName VARCHAR(100);
	SELECT concat(s.First_Name,' ',s.Last_Name) INTO fullName FROM staff s WHERE s.Email =email;
	RETURN fullName;
	END $$
    DELIMITER ;
    
	SELECT fc_getFullNameFromEmail('trantrungkien@gmail.com') AS FullName;
    
-- Ques16: Bạn hãy viết 1 Trigger để khi thực hiện cập nhật thông tin về trụ sở làm việc của
-- nhân viên đó thì hệ thống sẽ tự động lưu lại trụ sở cũ của nhân viên vào 1 bảng khác có tên
-- Log_Office để Mark có thể xem lại khi cần thiết.
	DROP TABLE IF EXISTS Log_Office;
	CREATE TABLE Log_Office
    (
		Id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		Email VARCHAR(50) NOT NULL,
		Office_id_Old SMALLINT UNSIGNED NOT NULL,
		ChangeDate DATETIME
    );
    
    DROP TRIGGER IF EXISTS trig_af_change_office;
	DELIMITER $$
	CREATE TRIGGER TrG_AfUpdateOfficeID
	AFTER UPDATE ON `staff`
	FOR EACH ROW
	BEGIN
		INSERT INTO `log_office` (`Email`, `Office_id_Old`, `ChangeDate`)
		VALUES ( OLD.Email, OLD.Office_id,now());
	END$$
	DELIMITER ;
    
    UPDATE `staff` SET office_id = '1' WHERE staff_id = '6';

-- Ques17: FB đang vướng vào 1 đạo luật hạn chế hoạt động, FB chỉ có thể hoạt động tối đa
-- trên 100 quốc gia trên thế giới, hãy tạo Trigger để ngăn người nhập liệu nhập vào quốc gia
-- thứ 101 (bạn có thể sử dụng số nước nhỏ hơn để Test VD 11 nước).
	DROP TRIGGER IF EXISTS trig_af_insert_national;
	DELIMITER $$
	CREATE TRIGGER trig_af_insert_national
    BEFORE INSERT ON  `national` 
    FOR EACH ROW
	BEGIN
		DECLARE v_count_national TINYINT UNSIGNED;
        SELECT count(1) INTO v_count_national FROM facebook_db.national;
        IF  v_count_national >= 6 THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Toi da 6 quoc gia';
		END IF;
	END$$
	DELIMITER ;

	INSERT INTO `national`	(National_Name	, Language_Main	)
	VALUES					('Campuchia'	,'Campuchia'	);

-- Ques18: Thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân viên đang làm việc.
	/* Dung select*/
	SELECT n.National_Name,count(s.Staff_id) AS 'SL' FROM facebook_db.staff s
	JOIN office O ON O.Office_id = s.Office_id
	RIGHT JOIN `national` N ON O.National_id = n.National_id
	GROUP BY O.National_id;
    
    /* Dung view*/
    CREATE OR REPLACE VIEW vw_staff_of_national AS
		SELECT n.National_Name,count(s.Staff_id) AS 'SL' FROM facebook_db.staff s
		JOIN office O ON O.Office_id = s.Office_id
		RIGHT JOIN `national` N ON O.National_id = n.National_id
		GROUP BY O.National_id;

	SELECT * FROM vw_staff_of_national;

-- Ques19: Viết Procedure để thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân
-- viên đang làm việc, với đầu vào là tên nước.
	DROP PROCEDURE IF EXISTS sp_count_staff_in_National;
	DELIMITER $$
	CREATE PROCEDURE sp_count_staff_in_National(IN in_national_name VARCHAR(50))
	BEGIN
		SELECT n.National_Name,count(s.Staff_id) AS 'SL' FROM facebook_db.staff s
		JOIN office O ON O.Office_id = s.Office_id
		RIGHT JOIN `national` N ON O.National_id = n.National_id
		WHERE n.National_Name = in_national_name
		GROUP BY O.National_id;
	END$$
	DELIMITER ;

	CALL sp_count_staff_in_National('Viet Nam');

-- Ques20: Thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu employee đang làm việc 
	/* Dung select*/
	SELECT o.Street_Address, count(s.Staff_id) AS 'SL' FROM staff s
	RIGHT JOIN office o ON o.Office_id = s.Office_id
	group by s.Office_id;
    
    /* Dung view*/
    CREATE OR REPLACE VIEW vw_staff_of_office AS
		SELECT o.Street_Address, count(s.Staff_id) AS 'SL' FROM staff s
		RIGHT JOIN office o ON o.Office_id = s.Office_id
		group by s.Office_id;

	SELECT * FROM vw_staff_of_office;
    
-- Ques21: Viết Procedure để thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu
-- employee đang làm việc đầu vào là ID của trụ sở.   
	DROP PROCEDURE IF EXISTS sp_count_staff_in_Office;
	DELIMITER $$
	CREATE PROCEDURE sp_count_staff_in_Office(IN in_office_id INT UNSIGNED)
	BEGIN
		SELECT o.Street_Address, count(s.Staff_id) AS 'SL' FROM staff s
		RIGHT JOIN office o ON o.Office_id = s.Office_id
		WHERE O.Office_id = in_office_id
		group by s.Office_id;
	END$$
	DELIMITER ;

	CALL sp_count_staff_in_Office('1');

-- Ques22: Viết Procedure để lấy ra tên quốc gia đang có nhiều nhân viên nhất.  
	DROP PROCEDURE IF EXISTS sp_max_staff_in_national;
    DELIMITER $$
	CREATE PROCEDURE sp_max_staff_in_national()
	BEGIN
		WITH Cte_max_staff AS 
			(SELECT max(SL) FROM
				(SELECT count(s.Staff_id) AS 'SL' FROM facebook_db.staff s
				JOIN office O ON O.Office_id = s.Office_id
				RIGHT JOIN `national` N ON O.National_id = n.National_id
				GROUP BY O.National_id) AS max_staff)
		SELECT 		n.National_Name, count(s.Staff_id)
		FROM		`national`
        JOIN 		office O ON O.National_id = n.National_id
		JOIN 		staff s ON O.office_id = s.office_id
		HAVING		SL = (SELECT * FROM Cte_max_staff);
	END$$
	DELIMITER ;
    
	Call sp_max_staff_in_national();

-- Ques23: Thống kê mỗi country có bao nhiêu employee đang làm việc.
	/* Dung select*/
	SELECT n.National_Name,count(s.Staff_id) AS 'SL' FROM facebook_db.staff s
	JOIN office O ON O.Office_id = s.Office_id
	RIGHT JOIN `national` N ON O.National_id = n.National_id
	GROUP BY O.National_id;
    
    /* Dung view*/
    CREATE OR REPLACE VIEW vw_staff_of_national AS
		SELECT n.National_Name,count(s.Staff_id) AS 'SL' FROM facebook_db.staff s
		JOIN office O ON O.Office_id = s.Office_id
		RIGHT JOIN `national` N ON O.National_id = n.National_id
		GROUP BY O.National_id;

	SELECT * FROM vw_staff_of_national;
    
-- Ques24: Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm
-- việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ chuyển về Null

	ALTER TABLE `Staff`
    DROP FOREIGN KEY staff_ibfk_1;
    ALTER TABLE `Staff`
    CHANGE COLUMN Office_id Office_id INT UNSIGNED NULL;
    ALTER TABLE `Staff`
    ADD FOREIGN KEY (Office_id) REFERENCES `Office`(Office_id) ON DELETE SET NULL;
    
    DELETE FROM OFFICE WHERE office_id = 2;
    
-- Ques25: Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm
-- việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ bị xóa hết.

	ALTER TABLE `Staff`
    DROP FOREIGN KEY staff_ibfk_1;
	ALTER TABLE `Staff`
    ADD FOREIGN KEY (Office_id) REFERENCES `Office`(Office_id) ON DELETE CASCADE;
    
    DELETE FROM OFFICE WHERE office_id = 4;
