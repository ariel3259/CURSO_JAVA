
CREATE DATABASE `universidad_db`; 

USE `universidad_db`;

CREATE TABLE `person`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `dni` INT NOT NULL,
	PRIMARY KEY(`id`),
    UNIQUE(`dni`)
);



CREATE TABLE `student`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `course` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`id`),
    UNIQUE(`course`)
);


 ALTER TABLE `person` ADD `id_student` INT, ADD FOREIGN KEY(`id_student`) REFERENCES `student`(`id`); 


CREATE TABLE `teacher`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `department` VARCHAR(45) NOT NULL,
    PRIMARY KEY(`id`),
    UNIQUE(`department`)
);


 ALTER TABLE `person` ADD `id_teacher` INT , ADD FOREIGN KEY(`id_teacher`) REFERENCES `teacher`(`id`); 


CREATE TABLE `personal_service`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `district` VARCHAR(45) NOT NULL,
    PRIMARY KEY(`id`),
    UNIQUE(`district`)
);
 
 
 ALTER TABLE `person` ADD `id_personal_service` INT, ADD FOREIGN KEY(`id_personal_service`) REFERENCES `personal_service`(`id`);
 
 