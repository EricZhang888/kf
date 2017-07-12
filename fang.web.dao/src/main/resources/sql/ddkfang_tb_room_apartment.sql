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
e7d65d66-5674-11e7-8bf6-6c92bf292868:1-176675';

--
-- Dumping data for table `tb_room_apartment`
--

LOCK TABLES `tb_room_apartment` WRITE;
/*!40000 ALTER TABLE `tb_room_apartment` DISABLE KEYS */;
INSERT INTO `tb_room_apartment` VALUES (1,'惠州海悦长滩','一呆公寓•惠州华润小径湾地处惠州市惠阳区霞涌镇，毗邻大亚湾著名景点十里银滩，信步可至十里银滩，园区内清静宜人，环境幽雅静谧，远离都市尘嚣，公寓拥有各类房型，适合眷侣及家庭游客入住，小区出行方便，园区外有公交直达霞涌镇海鲜市场，清泉古寺，园区入口毗邻惠深沿海高速的小径湾出口，方便自驾游客户\\n\\n周边景点简介:\\n小径生态园  距离公寓约2.7公里  项目收费制\\n位于惠州市霞涌镇小径湾,以休闲度假及亲子活动为主题的观光农场.生态园共占地近250多亩,其中美食娱乐区占地10亩,果园40多亩,另有良田200多亩.园内配置有动物养殖区,养蜂区,百果园区,儿童娱乐拓展区,野炊园,彩虹吊床区,凉亭区,骑马场,射箭靶场,露天大型投影卡拉OK及躺椅午休区.另还设有泥鳅池,钓鱼塘,自制棉花糖,烧烤,花式台球,乒乓球,飞镖,棋牌室,风情铁架摇椅,田园果林摄影摄像,小型户外篮球投篮,滚铁环,卡通飞镖粘耙吸盘等活动项目\\n\\n清泉古寺  距离公寓约6.9公里  暂无需门票\\n清泉古寺始创于清朝顺治年间(公元1644年),距今已有370年历史,是远近闻名的观音菩萨道场.清泉古寺作为大亚湾地区集礼佛,观光旅游为一体的佛教胜地,致力将清泉古寺打造成为不仅是出家人,在家佛弟子们修行的佛教圣地,更是普罗大众净化身心,远离尘嚣,修身养性之旅游文化净土 \\n\\n熊猫黄金海岸  距离公寓约8公里  暂无需门票\\n位于大亚湾区霞涌东部,这里沙滩平缓,沙质洁白,水质清澈,中间夹一弯银色月牙状沙滩,两边各是一条蜿蜒数里的绿色防护带,宛如莲花仙子广舒云袖.南临茫茫人海,碧水共长天一色;西望百岛丽影,群鸟与落霞齐飞;东观巽寮日出,云蒸霞蔚;北依铁炉山峰,层峦叠嶂,山光水色尽收眼底\\n\\n小径湾美食推荐:\\n惠州沿海,海鲜必尝, 海鲜一条街,位于大亚湾霞涌镇上,既可以现场买新鲜海鲜回公寓或在旁边餐馆进行加工,也可以直接到公寓附近的海鲜餐馆吃海鲜大餐\\n\\n公寓位置交通指引:\\n深圳自驾路线:东部沿海高速小径湾出口直行2.7公里右转即是\\n\\n东莞自驾路线:深莞高速>沈海高速>盐排高速>沿海高速>小径湾出口直行2.7公里右转即是\\n\\n广州自驾路线:环城高速>沈海高速广州支线>沈海高速公路>环城南路>珠三角环线高速公路>机荷高速公路>长深高速公路>沈海高速公路>石化大道西>惠深沿海高速公路>小径湾出口直行2.7公里右转即是\\n\\n公交到达惠州（惠阳淡水客运站）换乘巴士201或188至南坑站下>换成202乘至晓阳村站下车\\n\\n深圳往返巴士：\\n站点一:深圳湾北门停车场，发车时间\\n出发时间:9:00、10:00、13:30 (周六、周日)\\n出发时间:9:00、13:30 (周一至周五)\\n\\n站点二:深圳罗湖万象城-华润大厦连廊下，发车时间\\n出发时间:9:00、9:40、10:00、10:40、11:00、14:10 (周六、周日)\\n出发时间:9:40、14:10 (周一至周五)','1、凭身份证入住公寓，一人一证<br>2、公寓暂时未提供早餐，团队需要早餐可以安排。一般15--30元一人。<br>3、公寓提供停车位，30分钟内免费。<br>      小车停放3小时内收费5元/次<br>      小车停放3-12小时内收费10元/次<br>      小车停放12-24小时内收费15元/次<br>      小车停放包月180元/月<br>4.公寓暂不提供餐具借用服务<br>5.小区配有游泳池、健身房等配套需收费，健身房50元/次，会所游泳池25元/次，小区露天泳池20元/次<br>6.小区已有华润万家便利店、太平洋咖啡和驹鲍私房菜等商户进驻<br>7.公寓提供发票，具体开票事宜请咨询公寓前台工作人员');
/*!40000 ALTER TABLE `tb_room_apartment` ENABLE KEYS */;
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

-- Dump completed on 2017-07-12 22:12:53
