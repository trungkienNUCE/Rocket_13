-- Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
-- trước 1 năm trước
	DROP TRIGGER IF EXISTS trig_af_insert_group;
	DELIMITER $$
	CREATE TRIGGER trig_af_insert_group
    BEFORE INSERT ON  `group` 
    FOR EACH ROW
	BEGIN
		DECLARE v_createdate DATETIME;
        SELECT createdate INTO v_createdate FROM `group`;
        IF (NEW.Year(CreateDate) < (NOW())) THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Cant add group because createdate < now';
		END IF;
	END$$
	DELIMITER ;

INSERT INTO `Group`(GroupName,CreatorID,CreateDate)
VALUES (N'Tester03',1,'2011-09-12');


   DROP TRIGGER IF EXISTS trig_af_del_acc;
	DELIMITER $$
	CREATE TRIGGER trig_af_del_acc
    BEFORE DELETE ON  `account` 
    FOR EACH ROW
	BEGIN
		DECLARE email VARCHAR(50);
		SELECT a.email INTO email FROM `account` a WHERE a.AccountID = OLD.AccountID;
        IF email = 'trantrungkien@gmail.com' THEN
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Cant delete account admin';
		END IF;
	END$$
	DELIMITER ;
    
    DELETE FROM `account` WHERE (AccountID = '1');
    
    
    CREATE TABLE testingsystem.log_insert_change
    (
		AccountID 		TINYINT ,
		Username 		VARCHAR(50),
		DepartmentName 	VARCHAR(50),
		ChangeTime		DATETIME DEFAULT NOW()
    );
    
    DROP TRIGGER IF EXISTS trig_af_change_deptID;
	DELIMITER $$
	CREATE TRIGGER trig_af_change_deptID
    AFTER UPDATE ON  `account` 
    FOR EACH ROW
	BEGIN
		DECLARE v_deptName VARCHAR(50);
        SELECT d.departmentName INTO v_deptName FROM department d WHERE d.departmentID = OLD.departmentID;
        INSERT INTO log_insert_change(AccountID,Username,DepartmentName) VALUE (OLD.accountID,OLD.Username,v_deptName);
	END$$
	DELIMITER ;
    
    UPDATE `account` SET DepartmentID = '5' WHERE AccountID = '1';
    
    