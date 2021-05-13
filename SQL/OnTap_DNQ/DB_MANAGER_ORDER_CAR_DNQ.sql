DROP DATABASE IF EXISTS Manager_Order_Car;
CREATE DATABASE Manager_Order_Car;
USE Manager_Order_Car;

/*===============CREATE TABLE & CONSTRAINS===============*/
/*=======================================================*/

-- 1. Tạo table với các ràng buộc và kiểu dữ liệu

-- DROP TABLE CUSTOMER:
DROP TABLE IF EXISTS CUSTOMER;
-- CREATE TABLE Department
CREATE TABLE CUSTOMER
(
	CustomerID 	INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` 		VARCHAR(50) NOT NULL,
    Phone 		VARCHAR(15) NOT NULL UNIQUE KEY,
    Email		VARCHAR(50) NOT NULL UNIQUE KEY,
    Address 	VARCHAR(100) NOT NULL,
    Note 		VARCHAR(255) NULL
);
-- DROP TABLE CAR:
DROP TABLE IF EXISTS CAR;
-- CREATE TABLE CAR
CREATE TABLE CAR
(
	CARID 		INT UNSIGNED AUTO_INCREMENT,
    Maker 		ENUM('HONDA','TOYOYA','NISSAN') NOT NULL,
    Model 		VARCHAR(15) NOT NULL UNIQUE KEY,
    `Year`		YEAR NOT NULL,
    Color 		VARCHAR(15) NOT NULL,
    Note 		VARCHAR(255) NULL,
    PRIMARY KEY(CARID,Model,Year)
);

-- DROP TABLE CAR_ORDER
DROP TABLE IF EXISTS CAR_ORDER;
-- CREATE TABLE CAR_ORDER
CREATE TABLE CAR_ORDER
(
	OrderID 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CustomerID			INT UNSIGNED,
    CARID 				INT UNSIGNED,
    Amount				TINYINT NOT NULL DEFAULT 1,
    SalePrice 			INT UNSIGNED NOT NULL,
    OrderDate			DATE NOT NULL,
    DeliveryDate 		DATE NOT NULL,
    DeliveryAddress		VARCHAR(100) NOT NULL,
    `Status`				ENUM('0','1','2') DEFAULT '0',
    Note 				VARCHAR(255) NULL,
    FOREIGN KEY (CustomerID) REFERENCES CUSTOMER(CustomerID),
    FOREIGN KEY (CARID) REFERENCES CAR(CARID)
);


-- Thêm ít nhất 5 bản ghi vào table.
	INSERT INTO CUSTOMER(`Name`		, Phone			, Email					, Address		, Note)
	VALUES 				('Name01' 	, '0961781080'	, 'Email01@gmail.com'	, 'Ha Noi'		, 'Khach VIP' ),
						('Name02' 	, '0961234561'	, 'Email02@gmail.com'	, 'Bac Giang'	,  ''),
						('Name03' 	, '0961781232'	, 'Email03@gmail.com'	, 'Bac Ninh'	, 'Khach VIP' ),
						('Name04' 	, '0961781231'	, 'Email04@gmail.com'	, 'Tp HCM'		,  ''),
						('Name05' 	, '0961121231'	, 'Email05@gmail.com'	, 'Da Nang'		, 'Khach VIP' );
                        
                        
	INSERT INTO CAR(Maker		, Model		, `Year`	, Color		, Note)
	VALUES 			('HONDA' 	, 'Civic'	, '2020'	, 'Black'	, 'HOT' ),
					('HONDA' 	, 'City'	, '2018'	, 'White'	, ''	),
					('TOYOYA' 	, 'Vios'	, '2020'	, 'Red'		, '' 	),
					('NISSAN' 	, 'Nissan'	, '2019'	, 'Black'	, ''	),
					('HONDA' 	, 'Civic2.0', '2021'	, 'White'	, '' 	);
                    
	INSERT INTO CAR_ORDER(CustomerID		, CarID	, Amount		, SalePrice, OrderDate, DeliveryDate, DeliveryAddress, `Status`, Note)
	VALUES 					('1' 	, '1'	, '1'	, '700000000'	, '2021-04-12', '2021-04-15', 'Ha Noi', '1', 'Done' ),
							('2' 	, '2'	, '2'	, '800000000'	, '2021-05-9', '2021-06-15', 'Bac Giang', '0', '' ),
							('3' 	, '3'	, '1'	, '900000000'	, '2020-12-12', '2020-12-15', 'Ha Noi', '2', 'Cancel' ),
							('1' 	, '4'	, '1'	, '1000000000'	, '2021-03-25', '2021-06-25', 'Da Nang', '0', '' ),
                            ('2' 	, '3'	, '1'	, '1000000000'	, '2021-02-25', '2021-04-25', 'Ha Noi', '1', 'Done' ),
                            ('1' 	, '4'	, '3'	, '1000000000'	, '2021-01-25', '2021-04-25', 'Da Nang', '1', 'Done' );

-- 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
-- mua và sắp sếp tăng dần theo số lượng oto đã mua.
	SELECT `Name`, SUM(Amount) FROM CUSTOMER C
    JOIN CAR_ORDER CO ON C.CustomerID = CO.CustomerID AND CO.status = '1'
    GROUP BY CO.CustomerID
    ORDER BY SUM(Amount);

-- 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều
-- oto nhất trong năm nay.
	DROP PROCEDURE IF EXISTS sp_maker_sale_max;
	DELIMITER $$
	CREATE PROCEDURE sp_maker_sale_max()
	BEGIN
		WITH Cte_GetMaxAmountCarSale AS 
			(SELECT sum(Amount) AS SL FROM car_order
			WHERE Status = '1'
			GROUP BY CARID)
        SELECT c.maker, sum(Amount) AS SL FROM CAR C
        JOIN CAR_ORDER CO ON CO.CARID = C.CARID 
        WHERE Status = '1'
        GROUP BY CO.CARID
        HAVING sum(CO.Amount) = (SELECT MAX(SL) FROM Cte_GetMaxAmountCarSale);
	END$$
	DELIMITER ;
    
	CALL sp_maker_sale_max();
-- 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của
-- những năm trước. In ra số lượng bản ghi đã bị xóa.
	DROP PROCEDURE IF EXISTS sp_del_order_before_1Y;
	DELIMITER $$
	CREATE PROCEDURE sp_del_order_before_1Y()
	BEGIN
		DECLARE v_account MEDIUMINT;
		DECLARE v_noti VARCHAR(50);
		DROP TABLE IF EXISTS ORDERIDBefore1Year;
		CREATE TABLE ORDERIDBefore1Year
				(
				ID INT PRIMARY KEY AUTO_INCREMENT,
				ORDERID INT
				);
		-- Insert dữ liệu bảng tạm
		INSERT INTO ORDERIDBefore1Year(ORDERID)
		SELECT CO.ORDERID FROM CAR_ORDER CO  WHERE OrderDate < Date_sub(Now(), INTERVAL 1 YEAR) AND CO.status = '2';
		SELECT count(1) INTO v_account FROM ORDERIDBefore1Year;
		-- xoa du lieu
		DELETE FROM CAR_ORDER WHERE OrderDate < Date_sub(Now(), INTERVAL 1 YEAR) AND `status` = '2';
		-- in ra thong bao
		SELECT CONCAT("Da xoa ",v_account," order trong bang CAR_ORDER ") INTO v_noti;
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = v_noti;
		-- xoa bang tam
		DROP TABLE IF EXISTS ORDERIDBefore1Year;
		END$$
    DELIMITER ;
    
    CALL sp_del_order_before_1Y();

-- 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
-- hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto
-- và tên hãng sản xuất.
	DROP PROCEDURE IF EXISTS sp_info_customer;
	DELIMITER $$
	CREATE PROCEDURE sp_info_customer(IN in_customer_id INT UNSIGNED)
	BEGIN
        SELECT C.Name, CO.OrderID, Amount AS SL, CA.Maker  FROM Customer C
        JOIN CAR_ORDER CO ON CO.CustomerID = C.CustomerID
        JOIN CAR CA ON CA.CARID = CO.CARID
        WHERE CO.status = '1'
        AND CO.CustomerID = in_customer_id;
	END$$
	DELIMITER ;
    
	CALL sp_info_customer('1');

-- 6. Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ
-- vào database (DeliveryDate < OrderDate + 15).
	DROP TRIGGER IF EXISTS trig_bf_insert_car_order;
	DELIMITER $$
	CREATE TRIGGER trig_bf_insert_car_order
    BEFORE INSERT ON  CAR_ORDER 
    FOR EACH ROW
	BEGIN
        IF  NEW.DeliveryDate < date_add(NEW.OrderDate, INTERVAL 15 DAY) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = "CAN'T INSERT";
		END IF;
	END$$
	DELIMITER ;

	INSERT INTO CAR_ORDER(CustomerID, CarID	, Amount, SalePrice	, OrderDate		, DeliveryDate, DeliveryAddress, `Status` , Note)
	VALUES 				('2' 		, '2'	, '1'	, '700000000', '2021-04-12', '2021-04-13'	, 'Ha Noi'		, '0'		, '' );









