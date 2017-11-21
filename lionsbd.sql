-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lionsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lionsdb` ;

-- -----------------------------------------------------
-- Schema lionsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lionsdb` DEFAULT CHARACTER SET utf8 ;
USE `lionsdb` ;

-- -----------------------------------------------------
-- Table `lions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lions` ;

CREATE TABLE IF NOT EXISTS `lions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `gender_id` VARCHAR(45) NOT NULL,
  `image_id` VARCHAR(50000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gender`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gender` ;

CREATE TABLE IF NOT EXISTS `gender` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `image_url`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `image_url` ;

CREATE TABLE IF NOT EXISTS `image_url` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO lions;
 DROP USER lions;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'lions' IDENTIFIED BY 'lions';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'lions';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `lions`
-- -----------------------------------------------------
START TRANSACTION;
USE `lionsdb`;
INSERT INTO `lions` (`id`, `name`, `gender_id`, `image_id`) VALUES (1, 'Denver', 'male', '');
INSERT INTO `lions` (`id`, `name`, `gender_id`, `image_id`) VALUES (2, 'Charis', 'female', '');
INSERT INTO `lions` (`id`, `name`, `gender_id`, `image_id`) VALUES (3, 'Daddy', 'male', '');

COMMIT;


-- -----------------------------------------------------
-- Data for table `gender`
-- -----------------------------------------------------
START TRANSACTION;
USE `lionsdb`;
INSERT INTO `gender` (`id`, `name`) VALUES (1, 'Male');
INSERT INTO `gender` (`id`, `name`) VALUES (2, 'Female');

COMMIT;


-- -----------------------------------------------------
-- Data for table `image_url`
-- -----------------------------------------------------
START TRANSACTION;
USE `lionsdb`;
INSERT INTO `image_url` (`id`, `name`) VALUES (1, 'https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjZhunnts7XAhVhh1QKHTe7AsIQjRwIBw&url=https%3A%2F%2Fwww.pinterest.com%2Froont83%2Fnope%2F&psig=AOvVaw13asx5_i6Zxt9Kw1fYPIjb&ust=1511311097892818');
INSERT INTO `image_url` (`id`, `name`) VALUES (2, 'http://vignette1.wikia.nocookie.net/animal-jam-clans-1/images/4/43/Lioness-hunting.jpg/revision/latest?cb=20160623151938');

COMMIT;
