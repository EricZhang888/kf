/*
Navicat MySQL Data Transfer

Source Server         : kf
Source Server Version : 50632
Source Host           : 115.44.98.43:3306
Source Database       : ddkfang

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2016-10-01 21:50:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_booker
-- ----------------------------
DROP TABLE IF EXISTS `tb_booker`;
CREATE TABLE `tb_booker` (
  `id` varchar(32) NOT NULL,
  `booker_name` varchar(45) DEFAULT NULL,
  `booker_icon` varchar(300) DEFAULT NULL,
  `booker_mobile` varchar(45) NOT NULL,
  `booker_email` varchar(45) DEFAULT NULL,
  `booker_wechat` varchar(45) DEFAULT NULL,
  `booker_pwd` varchar(60) DEFAULT NULL,
  `booker_sex` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `booker_mobile_UNIQUE` (`booker_mobile`),
  UNIQUE KEY `booker_email_UNIQUE` (`booker_email`),
  UNIQUE KEY `booker_wechat_UNIQUE` (`booker_wechat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_booker
-- ----------------------------
INSERT INTO `tb_booker` VALUES ('111', '111', null, '13761170304', 'zaqweb@live.com', 'zaqweb', '$2a$10$pVIUJTVWg1VhA5ME45/jJepHdvNoF24T7mbzoc1aE5qnTsKja/NjO', null, '2016-09-12 22:13:02', '2016-09-12 22:13:02');
INSERT INTO `tb_booker` VALUES ('1112', '123', null, '13761170305', 'zaqweb234@live.com', '45688', null, null, null, null);
INSERT INTO `tb_booker` VALUES ('ff808081577582620157758468da0002', null, null, '13681900016', null, null, '$2a$10$jKY7FD1nYG8DHCHhrMKSneBdVKklb4irIt9l4KJtsofXuQP4kstSe', null, null, '2016-09-29 18:36:34');
INSERT INTO `tb_booker` VALUES ('ff80808157758262015775dbdba50004', null, null, '18098900860', null, null, '$2a$10$WsSf/WMtCOvHjq1SRl5t1O2gz.lztYgdT79TmgjQlFUUdi07Yq/66', null, null, '2016-09-29 20:12:05');
INSERT INTO `tb_booker` VALUES ('ff80808157758262015775dd36b60007', null, null, '13828827979', null, null, '$2a$10$fdGupnWQqp8PaV6i5Z/z8eQtzVnUlGY2VKCpRX/7tdhOv036zlroi', null, null, '2016-09-29 20:13:34');

-- ----------------------------
-- Table structure for tb_dingdan_active
-- ----------------------------
DROP TABLE IF EXISTS `tb_dingdan_active`;
CREATE TABLE `tb_dingdan_active` (
  `id` varchar(32) NOT NULL,
  `room_id` varchar(45) DEFAULT NULL,
  `date_start` date DEFAULT NULL,
  `date_end` date DEFAULT NULL,
  `booker_id` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `total_price` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `discount_id` varchar(32) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '支付状态0未支付1已支付',
  `payment` varchar(45) DEFAULT NULL COMMENT '付款方式',
  `payment_callback` varchar(45) DEFAULT NULL COMMENT '付款回执',
  `pay_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `F_KEY_DINGDAN_ID_idx` (`room_id`),
  KEY `F_KEY_DINGDAN_BOOKER_ID_idx` (`booker_id`),
  CONSTRAINT `F_KEY_DINGDAN_BOOKER_ID` FOREIGN KEY (`booker_id`) REFERENCES `tb_booker` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `F_KEY_DINGDAN_ID` FOREIGN KEY (`room_id`) REFERENCES `tb_room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_dingdan_active
-- ----------------------------

-- ----------------------------
-- Table structure for tb_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_room`;
CREATE TABLE `tb_room` (
  `room_id` varchar(32) NOT NULL,
  `room_name` varchar(45) NOT NULL COMMENT '房间名称',
  `room_city_id` varchar(45) NOT NULL COMMENT '城市ID用于选择城市搜索',
  `room_city_name` varchar(45) NOT NULL COMMENT '房间城市名称',
  `room_apartment_id` int(10) NOT NULL,
  `room_type_id` varchar(45) DEFAULT NULL COMMENT '房源类型',
  `room_type_desc` varchar(45) DEFAULT NULL,
  `room_type_mini_desc` varchar(45) DEFAULT NULL COMMENT '一句话卖点',
  `room_type_tips` varchar(45) DEFAULT NULL,
  `room_longitude` varchar(45) DEFAULT NULL COMMENT '经度',
  `room_latitude` varchar(45) DEFAULT NULL COMMENT '纬度',
  `room_map_type` int(11) DEFAULT NULL COMMENT '地图类型1百度2谷歌3高德',
  `room_min_area` int(11) NOT NULL COMMENT '使用面积',
  `room_max_area` int(11) NOT NULL COMMENT '建筑面积',
  `room_enters_number` int(11) NOT NULL COMMENT '房数',
  `room_bedroom_count` int(11) NOT NULL COMMENT '卧室数量',
  `room_kitchen_count` int(11) NOT NULL COMMENT '厨房数量',
  `room_bathroom_count` int(11) NOT NULL COMMENT '卫生间',
  `room_sitting_count` int(11) NOT NULL COMMENT '客厅',
  `room_balcony_count` int(11) NOT NULL COMMENT '阳台数',
  `room_bed_count` varchar(100) NOT NULL COMMENT '几个床',
  `room_score` varchar(200) DEFAULT NULL COMMENT '房间评分',
  `room_likes` int(11) DEFAULT NULL COMMENT '点赞数',
  `room_address` varchar(500) DEFAULT NULL,
  `room_price` int(11) DEFAULT NULL COMMENT '常规销售价',
  `room_basic_price` int(11) DEFAULT NULL COMMENT '门店价格',
  `room_images` longtext,
  `room_type_tags` varchar(45) DEFAULT NULL COMMENT '房源标签',
  `room_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `room_update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`room_id`),
  KEY `Index_room` (`room_name`,`room_city_name`,`room_min_area`,`room_map_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room
-- ----------------------------
INSERT INTO `tb_room` VALUES ('1546845454857489764', '霞涌金色海岸', '10002', '深圳', '1', null, null, '太棒了大床', null, '114.718014', '22.797819', '0', '0', '99', '0', '2', '0', '2', '1', '0', '1', '4.5', '850', '惠州大道12号', '689', '756', '1467741016_750_450.jpg,170005710_750_450.jpg', null, '2016-10-01 16:33:10', '2016-09-26 05:02:09');
INSERT INTO `tb_room` VALUES ('1546845454857489765', '轰趴大豪宅', '10002', '深圳', '1', null, null, '棒极了', null, null, null, '0', '0', '120', '0', '2', '1', '1', '0', '1', '1', '4.6', '869', '惠州码头1栋', '600', '720', '1754005256_750_450.jpg,-840547281_750_450.jpg', null, '2016-10-01 02:03:12', '2016-09-26 05:02:09');

-- ----------------------------
-- Table structure for tb_room_amenities
-- ----------------------------
DROP TABLE IF EXISTS `tb_room_amenities`;
CREATE TABLE `tb_room_amenities` (
  `amenities_id` int(10) NOT NULL,
  `amenity_name` varchar(45) DEFAULT NULL COMMENT '配置名空调,电视,洗衣机等',
  `icon` varchar(45) DEFAULT NULL COMMENT '对应的Icon class属性',
  PRIMARY KEY (`amenities_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room_amenities
-- ----------------------------
INSERT INTO `tb_room_amenities` VALUES ('1', '停车位', 'Parking');
INSERT INTO `tb_room_amenities` VALUES ('2', '游泳池', 'SwimmingPool');
INSERT INTO `tb_room_amenities` VALUES ('3', '儿童乐园', 'ChildrenPark');

-- ----------------------------
-- Table structure for tb_room_amenities_mapping
-- ----------------------------
DROP TABLE IF EXISTS `tb_room_amenities_mapping`;
CREATE TABLE `tb_room_amenities_mapping` (
  `room_id` varchar(32) NOT NULL,
  `amenities_id` int(10) NOT NULL,
  PRIMARY KEY (`room_id`,`amenities_id`),
  KEY `F_KEY_ROOM_AMENITY_MAP_AMENITY_ID_idx` (`amenities_id`),
  CONSTRAINT `F_KEY_ROOM_AMENITY_MAP_AMENITY_ID` FOREIGN KEY (`amenities_id`) REFERENCES `tb_room_amenities` (`amenities_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `F_KEY_ROOM_AMENITY_MAP_ROOM_ID` FOREIGN KEY (`room_id`) REFERENCES `tb_room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room_amenities_mapping
-- ----------------------------
INSERT INTO `tb_room_amenities_mapping` VALUES ('1546845454857489764', '1');
INSERT INTO `tb_room_amenities_mapping` VALUES ('1546845454857489765', '1');
INSERT INTO `tb_room_amenities_mapping` VALUES ('1546845454857489764', '2');
INSERT INTO `tb_room_amenities_mapping` VALUES ('1546845454857489765', '2');
INSERT INTO `tb_room_amenities_mapping` VALUES ('1546845454857489765', '3');

-- ----------------------------
-- Table structure for tb_room_apartment
-- ----------------------------
DROP TABLE IF EXISTS `tb_room_apartment`;
CREATE TABLE `tb_room_apartment` (
  `apartment_id` int(10) NOT NULL,
  `apartment_name` varchar(100) NOT NULL,
  `apartment_desc` longtext,
  `apartment_tips` longtext,
  PRIMARY KEY (`apartment_id`),
  UNIQUE KEY `apartment_id_UNIQUE` (`apartment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room_apartment
-- ----------------------------
INSERT INTO `tb_room_apartment` VALUES ('1', '惠州华润小径湾', '一呆公寓•惠州华润小径湾地处惠州市惠阳区霞涌镇，毗邻大亚湾著名景点十里银滩，信步可至十里银滩，园区内清静宜人，环境幽雅静谧，远离都市尘嚣，公寓拥有各类房型，适合眷侣及家庭游客入住，小区出行方便，园区外有公交直达霞涌镇海鲜市场，清泉古寺，园区入口毗邻惠深沿海高速的小径湾出口，方便自驾游客户\\n\\n周边景点简介:\\n小径生态园  距离公寓约2.7公里  项目收费制\\n位于惠州市霞涌镇小径湾,以休闲度假及亲子活动为主题的观光农场.生态园共占地近250多亩,其中美食娱乐区占地10亩,果园40多亩,另有良田200多亩.园内配置有动物养殖区,养蜂区,百果园区,儿童娱乐拓展区,野炊园,彩虹吊床区,凉亭区,骑马场,射箭靶场,露天大型投影卡拉OK及躺椅午休区.另还设有泥鳅池,钓鱼塘,自制棉花糖,烧烤,花式台球,乒乓球,飞镖,棋牌室,风情铁架摇椅,田园果林摄影摄像,小型户外篮球投篮,滚铁环,卡通飞镖粘耙吸盘等活动项目\\n\\n清泉古寺  距离公寓约6.9公里  暂无需门票\\n清泉古寺始创于清朝顺治年间(公元1644年),距今已有370年历史,是远近闻名的观音菩萨道场.清泉古寺作为大亚湾地区集礼佛,观光旅游为一体的佛教胜地,致力将清泉古寺打造成为不仅是出家人,在家佛弟子们修行的佛教圣地,更是普罗大众净化身心,远离尘嚣,修身养性之旅游文化净土 \\n\\n熊猫黄金海岸  距离公寓约8公里  暂无需门票\\n位于大亚湾区霞涌东部,这里沙滩平缓,沙质洁白,水质清澈,中间夹一弯银色月牙状沙滩,两边各是一条蜿蜒数里的绿色防护带,宛如莲花仙子广舒云袖.南临茫茫人海,碧水共长天一色;西望百岛丽影,群鸟与落霞齐飞;东观巽寮日出,云蒸霞蔚;北依铁炉山峰,层峦叠嶂,山光水色尽收眼底\\n\\n小径湾美食推荐:\\n惠州沿海,海鲜必尝, 海鲜一条街,位于大亚湾霞涌镇上,既可以现场买新鲜海鲜回公寓或在旁边餐馆进行加工,也可以直接到公寓附近的海鲜餐馆吃海鲜大餐\\n\\n公寓位置交通指引:\\n深圳自驾路线:东部沿海高速小径湾出口直行2.7公里右转即是\\n\\n东莞自驾路线:深莞高速>沈海高速>盐排高速>沿海高速>小径湾出口直行2.7公里右转即是\\n\\n广州自驾路线:环城高速>沈海高速广州支线>沈海高速公路>环城南路>珠三角环线高速公路>机荷高速公路>长深高速公路>沈海高速公路>石化大道西>惠深沿海高速公路>小径湾出口直行2.7公里右转即是\\n\\n公交到达惠州（惠阳淡水客运站）换乘巴士201或188至南坑站下>换成202乘至晓阳村站下车\\n\\n深圳往返巴士：\\n站点一:深圳湾北门停车场，发车时间\\n出发时间:9:00、10:00、13:30 (周六、周日)\\n出发时间:9:00、13:30 (周一至周五)\\n\\n站点二:深圳罗湖万象城-华润大厦连廊下，发车时间\\n出发时间:9:00、9:40、10:00、10:40、11:00、14:10 (周六、周日)\\n出发时间:9:40、14:10 (周一至周五)', '1、凭身份证入住公寓，一人一证<br>2、公寓暂时未提供早餐，团队需要早餐可以安排。一般15--30元一人。<br>3、公寓提供停车位，30分钟内免费。<br>      小车停放3小时内收费5元/次<br>      小车停放3-12小时内收费10元/次<br>      小车停放12-24小时内收费15元/次<br>      小车停放包月180元/月<br>4.公寓暂不提供餐具借用服务<br>5.小区配有游泳池、健身房等配套需收费，健身房50元/次，会所游泳池25元/次，小区露天泳池20元/次<br>6.小区已有华润万家便利店、太平洋咖啡和驹鲍私房菜等商户进驻<br>7.公寓提供发票，具体开票事宜请咨询公寓前台工作人员');

-- ----------------------------
-- Table structure for tb_room_apartment_mapping
-- ----------------------------
DROP TABLE IF EXISTS `tb_room_apartment_mapping`;
CREATE TABLE `tb_room_apartment_mapping` (
  `room_id` varchar(32) NOT NULL,
  `apartment_id` int(10) NOT NULL,
  PRIMARY KEY (`room_id`),
  KEY `F_KEY_ROOM_APART_MAP_APART_ID_idx` (`apartment_id`),
  CONSTRAINT `F_KEY_ROOM_APART_MAP_APART_ID` FOREIGN KEY (`apartment_id`) REFERENCES `tb_room_apartment` (`apartment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `F_KEY_ROOM_APART_MAP_ROOM_ID` FOREIGN KEY (`room_id`) REFERENCES `tb_room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room_apartment_mapping
-- ----------------------------
INSERT INTO `tb_room_apartment_mapping` VALUES ('1546845454857489764', '1');

-- ----------------------------
-- Table structure for tb_room_comments
-- ----------------------------
DROP TABLE IF EXISTS `tb_room_comments`;
CREATE TABLE `tb_room_comments` (
  `id` varchar(32) NOT NULL,
  `room_id` varchar(32) NOT NULL,
  `create_by` varchar(32) NOT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Index_room_comm` (`room_id`,`create_by`),
  KEY `F_KEY_ROOM_COMM_BOOKER_idx` (`create_by`),
  CONSTRAINT `F_KEY_ROOM_COMM` FOREIGN KEY (`room_id`) REFERENCES `tb_room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `F_KEY_ROOM_COMM_BOOKER` FOREIGN KEY (`create_by`) REFERENCES `tb_booker` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room_comments
-- ----------------------------

-- ----------------------------
-- Table structure for tb_room_holder
-- ----------------------------
DROP TABLE IF EXISTS `tb_room_holder`;
CREATE TABLE `tb_room_holder` (
  `id` varchar(32) NOT NULL,
  `room_id` varchar(32) DEFAULT NULL COMMENT '房间系统唯一ID',
  `name` varchar(45) NOT NULL COMMENT '房东名',
  `id_num` varchar(18) DEFAULT NULL COMMENT '身份证',
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(13) NOT NULL,
  `email_checked` int(11) DEFAULT NULL COMMENT '邮箱是否验证0未验证',
  `mobile_checked` int(11) DEFAULT NULL COMMENT '手机是否验证0未验证',
  `bank_name` varchar(100) NOT NULL COMMENT '银行名称',
  `bank_num` varchar(45) NOT NULL COMMENT '银行账号',
  `bank_site` varchar(100) NOT NULL COMMENT '网店名',
  PRIMARY KEY (`id`),
  KEY `F_KEY_room_holder_idx` (`room_id`),
  CONSTRAINT `F_KEY_room_holder` FOREIGN KEY (`room_id`) REFERENCES `tb_room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room_holder
-- ----------------------------

-- ----------------------------
-- Table structure for tb_room_price_calendar
-- ----------------------------
DROP TABLE IF EXISTS `tb_room_price_calendar`;
CREATE TABLE `tb_room_price_calendar` (
  `room_id` varchar(32) NOT NULL COMMENT '房间id外键',
  `room_date` date NOT NULL COMMENT '房间指定的日期',
  `room_date_price` decimal(10,0) NOT NULL COMMENT '房间指定日期的价格',
  `create_time` timestamp NULL DEFAULT NULL,
  `create_by` varchar(45) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `status` smallint(2) DEFAULT NULL COMMENT '0正常可租状态1已被租2设置为不可租',
  PRIMARY KEY (`room_date`,`room_id`),
  KEY `F_KEY_ROOM_ID_idx` (`room_id`),
  KEY `Index_room_price` (`room_date`),
  CONSTRAINT `F_KEY_ROOM_ID` FOREIGN KEY (`room_id`) REFERENCES `tb_room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_room_price_calendar
-- ----------------------------
INSERT INTO `tb_room_price_calendar` VALUES ('1546845454857489764', '2016-09-21', '438', '2016-09-21 10:35:30', '1', '2016-09-21 10:35:36', '1', '0');
INSERT INTO `tb_room_price_calendar` VALUES ('1546845454857489764', '2016-09-22', '433', '2016-09-21 10:37:54', '1', '2016-09-21 10:38:03', '1', '0');
INSERT INTO `tb_room_price_calendar` VALUES ('1546845454857489764', '2016-09-23', '444', '2016-09-21 10:41:39', '1', '2016-09-21 10:41:43', '1', '0');

-- ----------------------------
-- Table structure for tb_verify_code
-- ----------------------------
DROP TABLE IF EXISTS `tb_verify_code`;
CREATE TABLE `tb_verify_code` (
  `id` varchar(32) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `Index_sms_code_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_verify_code
-- ----------------------------
INSERT INTO `tb_verify_code` VALUES ('8ab442bf576a509701576a511b8b0000', '13761170304', '816288', '2016-09-27 15:06:43');
INSERT INTO `tb_verify_code` VALUES ('8ab442bf576af2ba01576af7805a0000', '13761170304', '057061', '2016-09-27 17:26:28');
INSERT INTO `tb_verify_code` VALUES ('8ab442bf576af2ba01576afa139d0001', '13761170304', '521596', '2016-09-27 17:29:16');
INSERT INTO `tb_verify_code` VALUES ('ff808081576ba6f101576ba745310000', '13681900016', '993144', '2016-09-27 20:38:27');
INSERT INTO `tb_verify_code` VALUES ('ff808081576ba6f101576baa4c2e0002', '13681900016', '301912', '2016-09-27 20:41:45');
INSERT INTO `tb_verify_code` VALUES ('ff808081576baed001576baf5a7a0000', '13681600019', '380086', '2016-09-27 20:47:17');
INSERT INTO `tb_verify_code` VALUES ('ff808081576baed001576bb066770001', '13681900016', '128318', '2016-09-27 20:48:25');
INSERT INTO `tb_verify_code` VALUES ('ff808081576bb50701576beccb930000', '13828827979', '971360', '2016-09-27 21:54:23');
INSERT INTO `tb_verify_code` VALUES ('ff80808157753fb401577543ecbc0000', '18098900860', '328132', '2016-09-29 17:26:08');
INSERT INTO `tb_verify_code` VALUES ('ff80808157753fb401577545b1df0001', '13828827979', '720187', '2016-09-29 17:28:04');
INSERT INTO `tb_verify_code` VALUES ('ff8080815775762b01577579bdac0000', '13681900016', '870612', '2016-09-29 18:34:55');
INSERT INTO `tb_verify_code` VALUES ('ff808081577582620157758388bb0000', '13681900016', '015906', '2016-09-29 18:35:37');
INSERT INTO `tb_verify_code` VALUES ('ff80808157758262015775db933a0003', '18098900860', '041778', '2016-09-29 20:11:47');
INSERT INTO `tb_verify_code` VALUES ('ff80808157758262015775dcae300005', '18098900860', '067382', '2016-09-29 20:12:59');
INSERT INTO `tb_verify_code` VALUES ('ff80808157758262015775dd0a530006', '13828827979', '999840', '2016-09-29 20:13:23');
INSERT INTO `tb_verify_code` VALUES ('ff80808157758262015775de035a0008', '13828827979', '711805', '2016-09-29 20:14:27');
