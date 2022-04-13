/* CREATE DATABASE `tienda_db` */

/* USE `tienda_db` */

/*
CREATE TABLE `client`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `dni` INT NOT NULL,
    `address` VARCHAR(45) NOT NULL, 
    `year_of_born` DATE NOT NULL,
    PRIMARY KEY(`id`),
    UNIQUE(`dni`)
);
*/

/*
CREATE TABLE `traider`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `dni` INT NOT NULL,
    `address` VARCHAR(45) NOT NULL,
    `year_of_born` DATE NOT NULL,
    `salary` DOUBLE NOT NULL,
    PRIMARY KEY(`id`),
    UNIQUE(`DNI`)
);
*/

/*
CREATE TABLE `products`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `product_code` INT NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `unit_price` DOUBLE NOT NULL,
    `stock` INT NOT NULL,
    `min_stock` INT NOT NULL,
    PRIMARY KEY(`id`),
    UNIQUE(`product_code`)
);
*/

/*
CREATE TABLE `invoicing`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `date_bought` DATE NOT NULL,
    `id_client` INT NOT NULL,
    `id_traider` INT NOT NULL,
    `id_product` INT NOT NULL,
    `total_price` INT NOT NULL,
    `length` INT NOT NULL,
    PRIMARY KEY(`id`),
    CONSTRAINT `fk_client_invoicing` FOREIGN KEY(`id_client`) REFERENCES `client`(`id`),
    CONSTRAINT `fK_traider_invoicing` FOREIGN KEY(`id_traider`) REFERENCES `traider`(`id`),
    CONSTRAINT `fk_products_invoicing` FOREIGN KEY(`id_product`) REFERENCES `products`(`id`) 
);
*/