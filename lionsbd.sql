-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `lions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lions` ;

CREATE TABLE IF NOT EXISTS `lions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `imageUrl` VARCHAR(45) NOT NULL,
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
USE `mydb`;
INSERT INTO `lions` (`id`, `name`, `gender`, `imageUrl`) VALUES (1, 'Denver', 'male', DEFAULT);
INSERT INTO `lions` (`id`, `name`, `gender`, `imageUrl`) VALUES (2, 'Charis', 'female', DEFAULT);
INSERT INTO `lions` (`id`, `name`, `gender`, `imageUrl`) VALUES (3, 'Daddy', 'male', DEFAULT);

COMMIT;
