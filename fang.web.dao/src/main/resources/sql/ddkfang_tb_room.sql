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
e7d65d66-5674-11e7-8bf6-6c92bf292868:1-176681';

--
-- Dumping data for table `tb_room`
--

LOCK TABLES `tb_room` WRITE;
/*!40000 ALTER TABLE `tb_room` DISABLE KEYS */;
INSERT INTO `tb_room` VALUES ('1546845454857489764','霞涌金色海岸','3211','1栋','32','10002','深圳',1,NULL,NULL,'太棒了大床',NULL,'114.718014','22.797819',0,0,99,0,2,0,2,1,0,'1','4.9',850,'惠州大道12号',240,380,'sddf679asdf8.jpg,sdffscv67767.jpg,sfaxxf3455.jpg,xj78sfff.jpg',NULL,'2016-12-16 06:17:10','2016-09-25 21:02:09'),('1546845454857489765','轰趴大豪宅','2801','5栋2单元','28','10002','深圳',1,NULL,NULL,'棒极了',NULL,'114.718014','22.797819',0,0,480,0,6,1,6,0,1,'6','4.3',869,'惠州码头1栋',8888,12880,'l31huisuo-1.jpg,l31huisuo-2.jpg,l31huisuo-3.jpg,l31huisuo-4.jpg,l31huisuo-5.jpg,l31huisuo-6.jpg,l31huisuo-7.jpg,l31huisuo-8.jpg,l31huisuo-9.jpg,l31huisuo-10.jpg,l31huisuo-11.jpg,l31huisuo-12.jpg,l31huisuo-13.jpg',NULL,'2017-02-26 09:07:18','2016-09-25 21:02:09'),('1546845454857489770','海景双床房','3112','1栋','31','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','402',1000,'惠州码头1栋',238,268,'1546845454857489770-1.jpg,1546845454857489770-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489771','海景双床房','3105','1栋','31','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',1003,'惠州码头1栋',238,268,'1546845454857489771-1.jpg,1546845454857489771-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489772','海景双床房','2208','1栋','22','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489772-1.jpg,1546845454857489772-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489773','海景双床房','2202','1栋','22','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489773-1.jpg,1546845454857489772-2.jpg',NULL,'2017-03-08 12:52:39','2016-09-25 21:02:09'),('1546845454857489774','海景双床房','1503','1栋','15','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489774-1.jpg,1546845454857489774-3.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489775','海景双床房','1107','1栋','11','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489775-1.jpg,1546845454857489775-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489776','海景双床房','1108','1栋','11','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489776-1.jpg,1546845454857489776-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489777','海景双床房','1004','1栋','10','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489777-1.jpg,1546845454857489777-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489778','海景双床房','812','1栋','8','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489778-1.jpg,1546845454857489778-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489779','海景双床房','703','1栋','7','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489779-1.jpg,1546845454857489779-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489780','海景双床房','604','1栋','6','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489780-1.jpg,1546845454857489780-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489781','海景双床房','404','1栋','4','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489781-1.jpg,1546845454857489781-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489782','海景双床房','403','1栋','4','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489782-1.jpg,1546845454857489782-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489783','海景双床房','402','1栋','4','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489783-1.jpg,1546845454857489783-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489784','海景双床房','303','1栋','3','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'2','4.5',101,'惠州码头1栋',238,268,'1546845454857489784-1.jpg,1546845454857489784-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489785','海景大床房','2903','1栋','29','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'1','4.5',101,'惠州码头1栋',238,268,'1546845454857489785-1.jpg,1546845454857489785-2.jpg',NULL,'2017-03-08 12:52:19','2016-09-25 21:02:09'),('1546845454857489786','海景大床房','2905','1栋','29','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'1','4.5',101,'惠州码头1栋',238,268,'1546845454857489786-1.jpg,1546845454857489786-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489787','海景大床房','2913','1栋','29','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,70,0,1,0,1,1,0,'1','4.5',101,'惠州码头1栋',418,458,'1546845454857489787-1.jpg,1546845454857489787-2.jpg',NULL,'2017-03-08 13:01:38','2016-09-25 21:02:09'),('1546845454857489788','海景大床房','2613','1栋','26','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,70,0,1,0,1,1,0,'1','4.5',101,'惠州码头1栋',418,458,'1546845454857489788-1.jpg,1546845454857489788-2.jpg',NULL,'2017-03-08 13:01:39','2016-09-25 21:02:09'),('1546845454857489789','海景大床房','1906','1栋','19','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'1','4.5',101,'惠州码头1栋',238,268,'1546845454857489789-1.jpg,1546845454857489789-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489790','海景大床房','1203','1栋','12','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'1','4.5',101,'惠州码头1栋',238,268,'1546845454857489790-1.jpg,1546845454857489790-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489791','海景大床房','1005','1栋','10','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'1','4.5',101,'惠州码头1栋',238,268,'1546845454857489791-1.jpg,1546845454857489791-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489792','海景大床房','704','1栋','7','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'1','4.5',101,'惠州码头1栋',238,268,'1546845454857489792-1.jpg,1546845454857489792-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489793','海景大床房','306','1栋','3','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,50,0,1,0,1,0,0,'1','4.5',101,'惠州码头1栋',238,268,'1546845454857489793-1.jpg,1546845454857489793-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489794','海景三房一厅','1807','3栋','18','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,90,0,3,1,1,0,1,'3','4.5',101,'惠州码头1栋',500,558,'1546845454857489794-1.jpg,1546845454857489794-2.jpg',NULL,'2017-03-08 13:00:48','2016-09-25 21:02:09'),('1546845454857489795','海景三房一厅','604','4栋','6','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,90,0,3,1,1,0,1,'3','4.5',101,'惠州码头1栋',500,558,'1546845454857489795-1.jpg,1546845454857489795-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489796','海景三房一厅','507','2栋','5','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,90,0,3,1,1,0,1,'3','4.5',101,'惠州码头1栋',500,558,'1546845454857489796-1.jpg,1546845454857489796-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489797','海景两房一厅','1601','5栋','16','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,90,0,2,1,1,0,1,'3','4.5',101,'惠州码头1栋',488,528,'1546845454857489797-1.jpg,1546845454857489797-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489798','海景两房一厅','1203','4栋','12','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,90,0,2,1,1,0,1,'3','4.5',101,'惠州码头1栋',488,528,'1546845454857489798-1.jpg,1546845454857489798-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489799','海景两房一厅','2403','6栋','24','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,90,0,2,1,1,0,1,'3','4.5',101,'惠州码头1栋',488,528,'1546845454857489799-1.jpg,1546845454857489799-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489800','特价房','330','7栋','3','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,38,0,1,0,1,0,1,'2','4.5',101,'惠州码头1栋',138,188,'1546845454857489800-1.jpg,1546845454857489800-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489801','特价房','329','7栋','3','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,38,0,1,0,1,0,1,'2','4.5',101,'惠州码头1栋',138,188,'1546845454857489801-1.jpg,1546845454857489801-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09'),('1546845454857489802','特价房','302','7栋','3','10002','深圳',1,NULL,NULL,NULL,NULL,'114.718014','22.797819',0,0,38,0,1,0,1,0,1,'2','4.5',101,'惠州码头1栋',138,188,'1546845454857489802-1.jpg,1546845454857489802-2.jpg',NULL,'2017-03-08 12:37:02','2016-09-25 21:02:09');
/*!40000 ALTER TABLE `tb_room` ENABLE KEYS */;
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

-- Dump completed on 2017-07-12 22:13:55
