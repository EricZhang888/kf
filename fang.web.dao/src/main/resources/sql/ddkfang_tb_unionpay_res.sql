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
e7d65d66-5674-11e7-8bf6-6c92bf292868:1-176673';

--
-- Dumping data for table `tb_unionpay_res`
--

LOCK TABLES `tb_unionpay_res` WRITE;
/*!40000 ALTER TABLE `tb_unionpay_res` DISABLE KEYS */;
INSERT INTO `tb_unionpay_res` VALUES ('402881e757d506d30157d510294d0002','402881e757d506d30157d50dc3560000','01','01','108881','6221********0000','156','1018','68759585097','201610180750341088818','success','20161018075034','00'),('402881e757d506d30157d510950b0003','402881e757d506d30157d50dc3560000','01','01','108881','6221********0000','156','1018','68759585097','201610180750341088818','success','20161018075034','00'),('402881e757d506d30157d51158f50004','402881e757d506d30157d50dc3560000','01','01','108881','6221********0000','156','1018','68759585097','201610180750341088818','success','20161018075034','00'),('402881e757d5129d0157d51428910001','402881e757d5129d0157d51343970000','01','01','108913','6221********0000','156','1018','68759585097','201610180756461089138','success','20161018075646','00'),('402881e757d516860157d51859c80001','402881e757d516860157d5179e5b0000','01','01','109089','6221********0000','156','1018','68759585097','201610180801201090898','success','20161018080120','00'),('402881e757d519510157d51a7f6c0001','402881e757d519510157d519de750000','01','01','109153','6221********0000','156','1018','68759585097','201610180803471091538','success','20161018080347','00');
/*!40000 ALTER TABLE `tb_unionpay_res` ENABLE KEYS */;
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

-- Dump completed on 2017-07-12 22:12:29