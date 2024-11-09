-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: qsys01
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

CREATE SCHEMA `qsys01` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

USE `qsys01`;

DROP TABLE IF EXISTS users_role;
CREATE TABLE users_role (
  id          int(11) NOT NULL AUTO_INCREMENT,
  description varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id          int(11) NOT NULL AUTO_INCREMENT,
  email       varchar(255) NOT NULL,
  password    varchar(255) NOT NULL,
  user_name   varchar(30) DEFAULT NULL,
  first_name  varchar(255) NOT NULL,
  last_name   varchar(255) NOT NULL,
  role_id     int(11) DEFAULT 0,
  locked      int(1) DEFAULT 0,
  enabled     int(1) DEFAULT 1,
  created_at  datetime(6) DEFAULT NULL,
  updated_at  datetime(6) DEFAULT NULL,
  upd_usr_id  int(11) DEFAULT 0,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into users_role (description) values ('ADMIN');
insert into users_role (description) values ('REPORT');
insert into users_role (description) values ('USER');


insert into users (email, password, first_name, last_name, role_id, created_at) values ('admin@test.com','12345678','TEST1','TEST2', 1, NOW());


/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-01 20:59:57
