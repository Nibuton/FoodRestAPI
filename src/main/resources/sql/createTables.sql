create database if not exists `food`;

use `food`;

drop table if exists `recipe_x_ingredient`;
drop table if exists `ingredient`;
drop table if exists `recipe`;

create table if not exists `ingredient`(
	`id` SERIAL PRIMARY KEY,
    `name` 	varchar(45) DEFAULT NULL,
    `remaining` double DEFAULT 0,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1;

create table if not exists `recipe`(
	`id` SERIAL PRIMARY KEY,
    `name` 	varchar(45) DEFAULT NULL,
    `description` varchar(45) DEFAULT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1;

create table if not exists `recipe_x_ingredient`(
    `recipe_id` BIGINT UNSIGNED NOT NULL,
    `ingredient_id` BIGINT UNSIGNED NOT NULL,
    `amount` DOUBLE DEFAULT 0,
    primary key(`recipe_id`,`ingredient_id`),
    CONSTRAINT recipe_id_key FOREIGN KEY (recipe_id) REFERENCES recipe(id) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT ingredient_id_key FOREIGN KEY (ingredient_id) REFERENCES ingredient(id) ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1;



