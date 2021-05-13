-- Xây dựng DataBase Quản lý đồ án ĐHBKHN
-- Để quản lý đồ án tốt nghiệp của các sinh viên, trường ĐHBKHN đang cần xây dựng 1 cơ sở
-- dữ liệu MySQL để quản lý tập trung, bạn hãy giúp trường làm việc này. Hãy xây dựng 1 DB
-- có tên QL_DoAn có các bảng dữ liệu như bên dưới (trường có dấu gạch chân là
-- PrimaryKey):
-- GiangVien(Id_GV, Ten_GV, Tuoi, HocVi)
-- SinhVien(Id_SV, Tên_SV, NamSinh, QueQuan)
-- DeTai(Id_DeTai, Ten_DeTai)
-- HuongDan(Id, Id_SV, Id_DeTai, Id_GV, Diem)
-- Trường học vị: nhận các giá trị là Ths, Ts, PGS, GS, ...

	/*Bai 	lam*/

DROP DATABASE IF EXISTS QL_DoAn;
CREATE DATABASE QL_DoAn;
USE QL_DoAn;

/*===============CREATE TABLE & CONSTRAINS===============*/
/*=======================================================*/
-- DROP TABLE Department
DROP TABLE IF EXISTS GiangVien;
-- CREATE TABLE Department
CREATE TABLE GiangVien
(
		ID_GV TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        Ten_GV NVARCHAR(50) NOT NULL,
        Tuoi TINYINT UNSIGNED NOT NULL,
        HocVi CHAR(10) NOT NULL
);

DROP TABLE IF EXISTS SinhVien;
-- CREATE TABLE Department
CREATE TABLE SinhVien
(
		ID_SV SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        Ten_SV NVARCHAR(50) NOT NULL,
        NamSinh DATETIME NOT NULL,
        QueQuan NVARCHAR(50)
);


DROP TABLE IF EXISTS DeTai;
-- CREATE TABLE Department
CREATE TABLE DeTai
(
		ID_DeTai SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        Ten_DeTai NVARCHAR(50) NOT NULL
);


DROP TABLE IF EXISTS HuongDan;
-- CREATE TABLE Department
CREATE TABLE HuongDan
(
		ID SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        ID_SV SMALLINT UNSIGNED,
        ID_DeTai SMALLINT UNSIGNED,
        ID_GV TINYINT UNSIGNED,
        Diem TINYINT UNSIGNED,
        FOREIGN KEY (ID_SV) REFERENCES SinhVien(ID_SV) ,
        FOREIGN KEY (ID_DeTai) REFERENCES DeTai(ID_DeTai),
        FOREIGN KEY (ID_GV) REFERENCES GiangVien(ID_GV)
);


/*===============INSERT VALUES===============*/
/*===========================================*/

INSERT INTO GiangVien(Ten_GV, Tuoi, HocVi)
VALUES
		(N'Giang Vien 01', '30', 'Ths'),
        (N'Giang Vien 02', '31', 'Ths'),
        (N'Giang Vien 03', '32', 'GS'),
        (N'Giang Vien 04', '33', 'Ths'),
        (N'Giang Vien 05', '34', 'TS'),
        (N'Giang Vien 06', '32', 'Ths'),
        (N'Giang Vien 07', '37', 'GS'),
        (N'Giang Vien 08', '31', 'PGS'),
        (N'Giang Vien 09', '31', 'GS');

INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan)
VALUES
		(N'Sinh Vien 01', '1999-01-02', 'Ha Noi'),
        (N'Sinh Vien 02', '1999-01-02', 'Bac Giang'),
        (N'Sinh Vien 03', '1999-01-02', 'Ha Noi'),
        (N'Sinh Vien 04', '1999-01-02', 'Bac Ninh'),
        (N'Sinh Vien 05', '1999-01-02', 'Ha Noi'),
        (N'Sinh Vien 06', '1994-01-02', 'Ha Noi'),
        (N'Sinh Vien 07', '1993-01-02', 'Ha Noi'),
        (N'Sinh Vien 08', '1992-01-02', 'Ha Noi'),
        (N'Sinh Vien 09', '1994-01-02', 'Hai Phong'),
        (N'Sinh Vien 10', '1998-01-02', 'Ha Noi');
        

INSERT INTO DeTai(Ten_DeTai)
VALUES
		('De tai 01'),
        ('De tai 02'),
        ('De tai 03'),
        ('De tai 04'),
        ('De tai 05'),
        ('De tai 06');

INSERT INTO HuongDan(Id_SV, Id_DeTai, Id_GV, Diem)
VALUES
		('1','2','3','9' ),
        ('2','5','1','8' ),
        ('4','1','2','6' ),
        ('3','2','3','2' ),
        ('1','3','5','1' );

-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn

	SELECT S.* FROM sinhvien S
    LEFT JOIN Huongdan H ON H.id_sv = s.id_sv
    WHERE H.Id_SV IS NULL;

-- b) Lấy ra số sinh viên làm đề tài ‘DeTai 6’

	SELECT d.ten_detai AS 'Ten de tai', count(1) AS 'SL' FROM ql_doan.huongdan h
	JOIN detai d ON d.ID_DeTai = h.ID_DeTai
	where h.id_detai = 2;
    
-- 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
-- mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")

	CREATE OR REPLACE VIEW vw_SinhVienInfo AS
		SELECT  s.ten_sv,d.ten_detai FROM `huongdan` h
		JOIN sinhvien s ON s.id_sv = h.id_sv
		JOIN DeTai d ON D.id_detai = H.id_detai
        -- tao bang sv da co de tai
		UNION 
		SELECT  s.ten_sv,'Chua co' FROM `sinhvien` S
		LEFT JOIN Huongdan H ON H.id_sv = s.id_sv
        WHERE h.ID_SV IS NULL;
        -- left join voi bang HD voi dk h.id_sv null
    
    SELECT *FROM vw_SinhVienInfo;

-- 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1950
-- thì hiện ra thông báo "Moi ban kiem tra lai nam sinh"

	DROP TRIGGER IF EXISTS trig_bf_insert_SV;
	DELIMITER $$
	CREATE TRIGGER trig_bf_insert_SV
    BEFORE INSERT ON  `sinhvien` 
    FOR EACH ROW
	BEGIN
		-- DECLARE v_namsinh DATETIME;
--         SELECT NEW.NamSinh INTO v_namsinh FROM sinhvien;
        IF  NEW.NamSinh < '1950-01-01'  THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Moi ban kiem tra lai nam sinh';
		END IF;
	END$$
	DELIMITER ;

	INSERT INTO SinhVien(Ten_SV, NamSinh, QueQuan)
	VALUES
		(N'Sinh Vien 11', '1949-01-01', 'Ha Noi');
	

-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
-- tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
	ALTER TABLE huongdan
    DROP FOREIGN KEY huongdan_ibfk_1;
    ALTER TABLE huongdan
    ADD FOREIGN KEY (`ID_SV`) REFERENCES `sinhvien` (`ID_SV`) ON DELETE CASCADE;
	
-- 6. Viết 1 Procedure để khi nhập vào tên của sinh viên thì sẽ thực hiện xóa toàn bộ thông tin
-- liên quan của sinh viên trên hệ thống:
	
	DROP PROCEDURE IF EXISTS sp_del_sv;
    DELIMITER $$
	CREATE PROCEDURE sp_del_sv(IN in_tenSV NVARCHAR(50))
	BEGIN
		WITH cte_idsv as
			(SELECT ID_SV FROM ql_doan.sinhvien
			WHERE Ten_SV = in_tenSV)
		DELETE FROM huongdan WHERE id_sv = (SELECT *FROM cte_idsv);
        DELETE FROM sinhvien WHERE ten_sv = in_tenSV;
	END$$
	DELIMITER ;
	
	Call sp_del_sv('sinh vien 03')


