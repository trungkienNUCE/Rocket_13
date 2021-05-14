DROP DATABASE IF EXISTS MANGER_SALARY;
CREATE DATABASE MANGER_SALARY;
USE MANGER_SALARY;

/*===============CREATE TABLE & CONSTRAINS===============*/
/*=======================================================*/
-- DROP TABLE Department
DROP TABLE IF EXISTS Department;
-- CREATE TABLE Department
CREATE TABLE Department
(
	id 				INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name` 			ENUM('Admin' , 'HR', 'IT', 'Delivery') NOT NULL,
    `description` 	TEXT,
    create_at		DATETIME,
    update_at 		DATETIME
);

-- DROP TABLE Users
DROP TABLE IF EXISTS Users;
-- CREATE TABLE Users
CREATE TABLE Users
(
	id 				INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    first_name 		VARCHAR(30) NOT NULL,
    last_name 		VARCHAR(30) NOT NULL,
    email 			VARCHAR(100) UNIQUE NOT NULL,
    phone 			VARCHAR(20) UNIQUE NOT NULL,
    employee_id 	VARCHAR(100) NOT NULL,
    avatar 			TEXT NULL,
    department_id 	INT(10) UNSIGNED,
    gender 			ENUM('M','F', 'U') NOT NULL,
    age 			INT(3),
    create_at		DATETIME,
    update_at 		DATETIME
);

-- DROP TABLE User_department
DROP TABLE IF EXISTS User_department;
-- CREATE TABLE User_department
CREATE TABLE User_department
(
	id 				INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_rid 		INT(10) UNSIGNED,
    department_id 	INT(10) UNSIGNED,
    start_date 		DATE,
    end_date 		DATE,
    create_at		DATETIME,
    update_at 		DATETIME
);

-- DROP TABLE User_role
DROP TABLE IF EXISTS User_role;
-- CREATE TABLE User_role
CREATE TABLE User_role
(
	id 					INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_department_id INT(10) UNSIGNED,
    role_id 			INT(10) UNSIGNED,
    start_date 			DATE,
    end_date 			DATE,
    create_at			DATETIME,
    update_at 			DATETIME
);

-- DROP TABLE roles
DROP TABLE IF EXISTS roles;
-- CREATE TABLE roles
CREATE TABLE roles
(
	id 			INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name` 		ENUM('Giam doc', 'Truong phong','Pho phong','Nhan vien', 'CTV') NOT NULL DEFAULT 'Nhan Vien',
    create_at	DATETIME,
    update_at 	DATETIME
);

-- DROP TABLE salary
DROP TABLE IF EXISTS salary;
-- CREATE TABLE salary
CREATE TABLE salary
(
	id 				INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_role_id 	INT(10) UNSIGNED,
    total_salary 	DECIMAL(12,2),
    `MONTH` 		VARCHAR(2),
    `YEAR` 			YEAR,
    create_at		DATETIME,
    update_at 		DATETIME
);

-- DROP TABLE salary_detail
DROP TABLE IF EXISTS salary_detail;
-- CREATE TABLE salary_detail
CREATE TABLE salary_detail
(
	id 						INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    amount 					DECIMAL(12,2),
    salary_id 				INT(10) UNSIGNED,
	salary_detail_type_id 	INT(10) UNSIGNED,
	operation 				ENUM('1','2','3','4') NOT NULL DEFAULT '1'
);


-- DROP TABLE salary_detail_type
DROP TABLE IF EXISTS salary_detail_type;
-- CREATE TABLE salary_detail_type
CREATE TABLE salary_detail_type
(
	id 				INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name` 			ENUM('Luong cung', 'Phu cap', 'Thuong', 'Thue TNCN', 'BHXH') NOT NULL,
    create_at		DATETIME,
    update_at 		DATETIME
);

ALTER TABLE user_department
ADD FOREIGN KEY (user_rid) REFERENCES `users`(id),
ADD FOREIGN KEY (department_id) REFERENCES department(id);

ALTER TABLE user_role
ADD FOREIGN KEY (user_department_id) REFERENCES user_department(id),
ADD FOREIGN KEY (role_id) REFERENCES roles(id);


ALTER TABLE salary
ADD FOREIGN KEY (user_role_id) REFERENCES user_role(id);


ALTER TABLE salary_detail
ADD FOREIGN KEY (salary_id) REFERENCES salary(id),
ADD FOREIGN KEY (salary_detail_type_id) REFERENCES salary_detail_type(id);





