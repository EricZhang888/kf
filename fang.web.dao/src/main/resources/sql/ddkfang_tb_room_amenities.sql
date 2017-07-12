-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: rm-uf6ew3bn3t9syf6kfo.mysql.rds.aliyuncs.com    Database: ddkfang
-- ------------------------------------------------------
-- Server version	5.6.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED='a123b3ff-d88f-11e6-9704-7cd30abeae02:1-9119,
bb7c651d-d88f-11e6-9705-48d5394a2531:1-1302670,
e7d65d66-5674-11e7-8bf6-6c92bf292868:1-176676';

--
-- Dumping data for table `tb_room_amenities`
--

LOCK TABLES `tb_room_amenities` WRITE;
/*!40000 ALTER TABLE `tb_room_amenities` DISABLE KEYS */;
INSERT INTO `tb_room_amenities` VALUES (1,'停车位','Parking'),(2,'游泳池','SwimmingPool'),(3,'儿童乐园','ChildrenPark'),(4,'空调','Air-Condition'),(5,'电视','Television'),(7,'电冰箱','Refrigerator'),(8,'洗衣机','WashingMachine'),(9,'洗漱用品','Toiletries'),(10,'24h热水','HotWater'),(11,'拖鞋','Slipper'),(12,'淋浴','Bathroom'),(13,'毛巾','Washcloth'),(14,'WIFI','WIFI'),(15,'管家服务','ButlerService'),(16,'可做饭','Cooking');
/*!40000 ALTER TABLE `tb_room_amenities` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-12 22:13:07
