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
e7d65d66-5674-11e7-8bf6-6c92bf292868:1-176679';

--
-- Dumping data for table `tb_booker`
--

LOCK TABLES `tb_booker` WRITE;
/*!40000 ALTER TABLE `tb_booker` DISABLE KEYS */;
INSERT INTO `tb_booker` VALUES ('1','1',NULL,'1001','zaq@sohu.com','zaqwe','$2a$10$BpRZCX67URypjXcggwQWTuMd89Mulci2YVPPeoLtuz.xkL3lzYoRu',NULL,'2016-09-12 14:13:02','2016-09-12 14:13:02'),('111','111',NULL,'13761170304','zaqweb@live.com','zaqweb','$2a$10$BpRZCX67URypjXcggwQWTuMd89Mulci2YVPPeoLtuz.xkL3lzYoRu',NULL,'2016-09-12 14:13:02','2016-09-12 14:13:02'),('1112','123',NULL,'13761170305','zaqweb234@live.com','45688',NULL,NULL,NULL,NULL),('ff808081577582620157758468da0002',NULL,NULL,'13681900016',NULL,NULL,'$2a$10$jKY7FD1nYG8DHCHhrMKSneBdVKklb4irIt9l4KJtsofXuQP4kstSe',NULL,NULL,'2016-09-29 10:36:34'),('ff80808157758262015775dbdba50004',NULL,NULL,'18098900860',NULL,NULL,'$2a$10$WsSf/WMtCOvHjq1SRl5t1O2gz.lztYgdT79TmgjQlFUUdi07Yq/66',NULL,NULL,'2016-09-29 12:12:05'),('ff80808157758262015775dd36b60007',NULL,NULL,'13828827979',NULL,NULL,'$2a$10$ZSfVaQ22FHs6KAuS06SCg.jsVlLJxNzTFrKx9N4K5n4s.Gya4sfcC',NULL,NULL,'2016-09-29 12:13:34'),('ff80808157f043f30157f07b627e0006',NULL,NULL,'13502871950',NULL,NULL,NULL,NULL,NULL,'2016-10-23 07:40:01'),('ff80808157f043f30157f10b53fe0008',NULL,NULL,'13600160416',NULL,NULL,NULL,NULL,NULL,'2016-10-23 10:17:14'),('ff80808157f3eef40157f464a1790005',NULL,NULL,'13682608580',NULL,NULL,NULL,NULL,NULL,'2016-10-24 01:53:38'),('ff808081580168680158051fb0040002',NULL,NULL,'13058158333',NULL,NULL,NULL,NULL,NULL,'2016-10-27 07:51:53'),('ff808081580168680158052150e10005',NULL,NULL,'13794577706',NULL,NULL,NULL,NULL,NULL,'2016-10-27 07:53:39'),('ff808081589e98330159549e02b60001',NULL,NULL,'13590117460',NULL,NULL,NULL,NULL,NULL,'2016-12-31 11:22:39');
/*!40000 ALTER TABLE `tb_booker` ENABLE KEYS */;
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

-- Dump completed on 2017-07-12 22:13:28