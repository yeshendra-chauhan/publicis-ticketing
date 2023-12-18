-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: pst
-- ------------------------------------------------------
-- Server version	5.7.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `show_id` int(11) DEFAULT NULL,
  `booking_date` datetime DEFAULT NULL,
  `ticket_cnt` int(11) DEFAULT NULL,
  `total_amount` decimal(10,2) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `show_date` datetime NOT NULL,
  `show_time_from` int(11) DEFAULT NULL,
  `show_time_to` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `theater_id` (`show_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_cart`
--

DROP TABLE IF EXISTS `booking_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_cart` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `cart_created_at` datetime DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `payment_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_cart_FK` (`user_id`),
  CONSTRAINT `booking_cart_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_cart`
--

LOCK TABLES `booking_cart` WRITE;
/*!40000 ALTER TABLE `booking_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_cart_seats`
--

DROP TABLE IF EXISTS `booking_cart_seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_cart_seats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `show_id` int(11) NOT NULL,
  `show_date` datetime DEFAULT NULL,
  `selected_at` datetime DEFAULT NULL,
  `screen_seat_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_cart_seats_FK` (`show_id`),
  KEY `booking_cart_seats_FK_1` (`screen_seat_id`),
  CONSTRAINT `booking_cart_seats_FK` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`),
  CONSTRAINT `booking_cart_seats_FK_1` FOREIGN KEY (`screen_seat_id`) REFERENCES `screen_seat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_cart_seats`
--

LOCK TABLES `booking_cart_seats` WRITE;
/*!40000 ALTER TABLE `booking_cart_seats` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_cart_seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_seat`
--

DROP TABLE IF EXISTS `booking_seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_seat` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `booking_id` int(11) NOT NULL,
  `screen_seat_id` int(11) NOT NULL,
  `price` float NOT NULL,
  `discount` float DEFAULT NULL,
  `net_price` float DEFAULT NULL,
  `discount_code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_seat_FK` (`booking_id`),
  KEY `booking_seat_FK_1` (`screen_seat_id`),
  CONSTRAINT `booking_seat_FK` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`),
  CONSTRAINT `booking_seat_FK_1` FOREIGN KEY (`screen_seat_id`) REFERENCES `screen_seat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_seat`
--

LOCK TABLES `booking_seat` WRITE;
/*!40000 ALTER TABLE `booking_seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Bengaluru','KARNATAKA'),(2,'Delhi','DELHI');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `lang` varchar(50) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `duration_minutes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Jawan','Action','Hindi',NULL,90),(2,'Pathan','Action','Hindi',NULL,90);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `booking_cart_id` int(11) NOT NULL,
  `started_at` datetime NOT NULL,
  `completed_at` varchar(100) NOT NULL,
  `payment_status` varchar(100) NOT NULL,
  `gw_transaction_id` varchar(100) DEFAULT NULL,
  `transaction_id` varchar(100) DEFAULT NULL,
  `booking_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen`
--

DROP TABLE IF EXISTS `screen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `screen` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `theater_id` int(10) unsigned NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen`
--

LOCK TABLES `screen` WRITE;
/*!40000 ALTER TABLE `screen` DISABLE KEYS */;
/*!40000 ALTER TABLE `screen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen_seat`
--

DROP TABLE IF EXISTS `screen_seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `screen_seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `screen_id` int(11) DEFAULT NULL,
  `seat_number` varchar(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `category` varchar(100) NOT NULL,
  `row` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `theater_id` (`screen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen_seat`
--

LOCK TABLES `screen_seat` WRITE;
/*!40000 ALTER TABLE `screen_seat` DISABLE KEYS */;
INSERT INTO `screen_seat` VALUES (1,1,'1A','ACTIVE','DEFAULT',NULL),(2,1,'1B','ACTIVE','DEFAULT',NULL),(3,1,'1C','ACTIVE','DEFAULT',NULL),(4,1,'2A','ACTIVE','DEFAULT',NULL),(5,1,'2B','ACTIVE','DEFAULT',NULL),(6,1,'2C','ACTIVE','DEFAULT',NULL),(7,2,'1A','ACTIVE','DEFAULT',NULL),(8,2,'1B','ACTIVE','DEFAULT',NULL),(9,2,'1C','ACTIVE','DEFAULT',NULL),(10,2,'2A','ACTIVE','DEFAULT',NULL);
/*!40000 ALTER TABLE `screen_seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `show_price`
--

DROP TABLE IF EXISTS `show_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `show_price` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `show_id` int(11) NOT NULL,
  `seat_category` varchar(100) DEFAULT NULL,
  `start_date` varchar(100) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `price` float NOT NULL,
  `price_type` char(1) DEFAULT NULL COMMENT 'D-Daily, W-Specific Week Days',
  PRIMARY KEY (`id`),
  KEY `show_price_FK` (`show_id`),
  CONSTRAINT `show_price_FK` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `show_price`
--

LOCK TABLES `show_price` WRITE;
/*!40000 ALTER TABLE `show_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `show_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `show_price_week_days`
--

DROP TABLE IF EXISTS `show_price_week_days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `show_price_week_days` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `show_price_id` int(10) unsigned NOT NULL,
  `day_of_week` tinyint(3) unsigned NOT NULL,
  `status` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `show_price_week_days`
--

LOCK TABLES `show_price_week_days` WRITE;
/*!40000 ALTER TABLE `show_price_week_days` DISABLE KEYS */;
/*!40000 ALTER TABLE `show_price_week_days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `show_week_days`
--

DROP TABLE IF EXISTS `show_week_days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `show_week_days` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `show_id` int(11) DEFAULT NULL,
  `day_of_week` tinyint(4) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `show_id` (`show_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `show_week_days`
--

LOCK TABLES `show_week_days` WRITE;
/*!40000 ALTER TABLE `show_week_days` DISABLE KEYS */;
/*!40000 ALTER TABLE `show_week_days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shows`
--

DROP TABLE IF EXISTS `shows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shows` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `screen_id` int(11) DEFAULT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `screen_type` varchar(50) DEFAULT NULL,
  `show_time_from` smallint(5) unsigned DEFAULT NULL,
  `show_time_to` smallint(5) unsigned DEFAULT NULL,
  `show_date_from` datetime DEFAULT NULL,
  `show_date_to` datetime DEFAULT NULL,
  `show_type` char(1) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `theater_id` (`screen_id`),
  KEY `movie_id` (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shows`
--

LOCK TABLES `shows` WRITE;
/*!40000 ALTER TABLE `shows` DISABLE KEYS */;
INSERT INTO `shows` VALUES (1,1,1,'2D',660,660,'2023-12-01 00:00:00','2023-12-31 00:00:00','D','ACTIVE'),(2,1,1,'2D',675,735,'2023-12-01 00:00:00','2023-12-31 00:00:00','D','ACTIVE');
/*!40000 ALTER TABLE `shows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shows_deleted`
--

DROP TABLE IF EXISTS `shows_deleted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shows_deleted` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `show_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `day_of_week` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `show_id` (`show_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shows_deleted`
--

LOCK TABLES `shows_deleted` WRITE;
/*!40000 ALTER TABLE `shows_deleted` DISABLE KEYS */;
/*!40000 ALTER TABLE `shows_deleted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater`
--

DROP TABLE IF EXISTS `theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theater_name` varchar(100) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `is_online` tinyint(1) DEFAULT NULL,
  `city_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater`
--

LOCK TABLES `theater` WRITE;
/*!40000 ALTER TABLE `theater` DISABLE KEYS */;
INSERT INTO `theater` VALUES (1,'PVR - Metro Mall',200,1,1),(2,'INOX - Lulu',300,1,1),(3,'PVR - Saket',200,1,2);
/*!40000 ALTER TABLE `theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `user_type` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_theater`
--

DROP TABLE IF EXISTS `user_theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_theater` (
  `id` int(10) unsigned NOT NULL,
  `theater_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_theater`
--

LOCK TABLES `user_theater` WRITE;
/*!40000 ALTER TABLE `user_theater` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pst'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-18 14:19:16
