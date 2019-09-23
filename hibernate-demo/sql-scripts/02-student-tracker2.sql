CREATE DATABASE IF NOT EXISTS hb_student_tracker;
USE hb_student_tracker;


DROP TABLE IF EXISTS student;


CREATE TABLE IF NOT EXISTS student (
	id INT(11) NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(45) DEFAULT NULL,
    last_name VARCHAR(45) DEFAULT NULL,
    email VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB auto_increment=6 DEFAULT CHARSET=latin1;