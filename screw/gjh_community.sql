/*
Navicat MySQL Data Transfer

Source Server         : mysqlpro
Source Server Version : 80025
Source Host           : localhost:3306
Source Database       : gjh_community

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2023-04-09 19:01:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_activity
-- ----------------------------
DROP TABLE IF EXISTS `tb_activity`;
CREATE TABLE `tb_activity` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '活动ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `title` varchar(100) DEFAULT NULL COMMENT '活动标题',
  `address` varchar(200) DEFAULT NULL COMMENT '活动地点',
  `organizer` varchar(100) DEFAULT NULL COMMENT '举办单位',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动截止时间',
  `status` char(1) DEFAULT '0' COMMENT '状态:0-活动未开始（默认），1-活动进行中，2-活动已结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='活动表';

-- ----------------------------
-- Records of tb_activity
-- ----------------------------
INSERT INTO `tb_activity` VALUES ('1', '翻斗花园A区', '1', '春游活动', '小区公园', '物业公司A', '2023-03-24 21:25:27', '2023-03-24 21:25:59', '2023-04-01 09:00:00', '2023-04-01 12:00:00', '0');
INSERT INTO `tb_activity` VALUES ('2', '翻斗花园A区', '1', '篮球比赛', '篮球场地', '物业公司A', '2023-03-24 21:25:27', '2023-03-24 21:25:59', '2023-04-03 14:00:00', '2023-04-03 17:00:00', '0');
INSERT INTO `tb_activity` VALUES ('3', '翻斗花园B区', '2', '健步走活动', '小区健身步道', '物业公司B', '2023-03-24 21:25:27', '2023-03-24 21:25:59', '2023-04-06 08:00:00', '2023-04-06 10:00:00', '0');
INSERT INTO `tb_activity` VALUES ('4', '翻斗花园B区', '2', '儿童绘画比赛', '小区活动室', '物业公司B', '2023-03-24 21:25:27', '2023-03-24 21:25:59', '2023-04-08 10:00:00', '2023-04-08 12:00:00', '1');
INSERT INTO `tb_activity` VALUES ('5', '翻斗花园C区', '3', '夜跑活动', '小区健身步道', '物业公司C', '2023-03-24 21:25:27', '2023-03-24 21:25:59', '2023-04-10 20:00:00', '2023-04-10 22:00:00', '1');
INSERT INTO `tb_activity` VALUES ('6', '翻斗花园C区', '3', '早操活动', '小区健身广场', '物业公司C', '2023-03-24 21:25:27', '2023-03-24 21:25:59', '2023-04-12 07:30:00', '2023-04-12 08:30:00', '1');
INSERT INTO `tb_activity` VALUES ('7', '翻斗花园D区', '4', '足球比赛', '足球场地', '物业公司D', '2023-03-24 21:25:27', '2023-03-24 21:25:59', '2023-04-15 14:00:00', '2023-04-15 17:00:00', '0');
INSERT INTO `tb_activity` VALUES ('8', '翻斗花园D区', '4', '书法大赛', '小区活动室', '物业公司D', '2023-03-24 21:25:27', '2023-03-24 21:25:59', '2023-04-17 09:00:00', '2023-04-17 12:00:00', '1');
INSERT INTO `tb_activity` VALUES ('9', '翻斗花园E区', '5', '羽毛球比赛', '羽毛球场地', '物业公司E', '2023-03-24 21:25:27', '2023-03-24 21:25:59', '2023-04-20 14:00:00', '2023-04-20 17:00:00', '0');
INSERT INTO `tb_activity` VALUES ('10', '翻斗花园E区', '5', '小区美食节', '小区广场', '物业公司E', '2023-03-24 21:25:27', '2023-03-24 21:25:59', '2023-04-22 10:00:00', '2023-04-22 13:00:00', '0');

-- ----------------------------
-- Table structure for tb_building
-- ----------------------------
DROP TABLE IF EXISTS `tb_building`;
CREATE TABLE `tb_building` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '楼栋ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `name` varchar(50) DEFAULT NULL COMMENT '栋数名称',
  `total_households` int DEFAULT NULL COMMENT '总户数',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='楼栋表';

-- ----------------------------
-- Records of tb_building
-- ----------------------------
INSERT INTO `tb_building` VALUES ('1', '翻斗花园A区', '1', '1栋', '100', '一栋新的楼房', '2023-02-09 19:14:08', '2023-02-10 15:25:39');
INSERT INTO `tb_building` VALUES ('2', '翻斗花园A区', '1', '2栋', '120', '二栋老的楼房', '2023-02-09 19:14:08', '2023-02-10 15:25:42');
INSERT INTO `tb_building` VALUES ('3', '翻斗花园A区', '1', '3栋', '80', '三栋豪华的楼房', '2023-02-09 19:14:08', '2023-02-10 15:25:58');
INSERT INTO `tb_building` VALUES ('4', '翻斗花园B区', '2', '1栋', '90', '一栋时尚的楼房', '2023-02-09 19:14:08', '2023-02-10 15:26:00');
INSERT INTO `tb_building` VALUES ('5', '翻斗花园B区', '2', '2栋', '110', '二栋实用的楼房', '2023-02-09 19:14:08', '2023-02-10 15:26:02');
INSERT INTO `tb_building` VALUES ('6', '翻斗花园B区', '2', '3栋', '70', '三栋普通的楼房', '2023-02-09 19:14:08', '2023-02-10 15:26:06');
INSERT INTO `tb_building` VALUES ('7', '翻斗花园C区', '3', '1栋', '95', '一栋干净的楼房', '2023-02-09 19:14:08', '2023-02-10 15:26:09');
INSERT INTO `tb_building` VALUES ('8', '翻斗花园C区', '3', '2栋', '115', '二栋整洁的楼房', '2023-02-09 19:14:08', '2023-02-10 15:25:52');
INSERT INTO `tb_building` VALUES ('9', '翻斗花园C区', '3', '3栋', '75', '三栋环保的楼房', '2023-02-09 19:14:08', '2023-02-10 15:25:55');
INSERT INTO `tb_building` VALUES ('10', '翻斗花园D区', '4', '1栋', '92', '一栋温馨的楼房', '2023-02-09 19:14:08', '2023-02-10 15:25:49');
INSERT INTO `tb_building` VALUES ('11', '翻斗花园D区', '4', '2栋', '92', '二栋温馨的楼房', '2023-02-09 19:14:08', '2023-02-10 15:25:45');
INSERT INTO `tb_building` VALUES ('12', '翻斗花园D区', '4', '3栋', '92', '三栋温馨的楼房', '2023-02-09 19:14:08', '2023-03-25 21:56:24');
INSERT INTO `tb_building` VALUES ('13', '翻斗花园E区', '5', '1栋', '92', '二栋温馨的楼房', '2023-02-09 19:14:08', '2023-02-10 15:25:45');
INSERT INTO `tb_building` VALUES ('14', '翻斗花园E区', '5', '2栋', '92', '二栋温馨的楼房', '2023-02-09 19:14:08', '2023-02-10 15:25:45');
INSERT INTO `tb_building` VALUES ('15', '翻斗花园E区', '5', '3栋', '92', '二栋温馨的楼房', '2023-02-09 19:14:08', '2023-02-10 15:25:45');

-- ----------------------------
-- Table structure for tb_car
-- ----------------------------
DROP TABLE IF EXISTS `tb_car`;
CREATE TABLE `tb_car` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '车辆ID',
  `picture` varchar(100) DEFAULT NULL COMMENT '车辆照片',
  `owner_id` int DEFAULT NULL COMMENT '所属成员（业主）',
  `color` varchar(10) DEFAULT NULL COMMENT '车辆颜色',
  `car_number` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='车辆表';

-- ----------------------------
-- Records of tb_car
-- ----------------------------
INSERT INTO `tb_car` VALUES ('1', '/fileupload/d057c823-ec0d-4731-a5a3-39483c341b96.jpg', '1', 'red', '京A12345', '备注1', '2023-03-22 20:46:00', '2023-03-22 20:46:11');
INSERT INTO `tb_car` VALUES ('2', '/fileupload/d057c823-ec0d-4731-a5a3-39483c341b96.jpg', '1', 'blue', '京A67890', '备注2', '2023-03-22 20:46:00', '2023-03-22 20:46:11');
INSERT INTO `tb_car` VALUES ('3', '/fileupload/d057c823-ec0d-4731-a5a3-39483c341b96.jpg', '2', 'yellow', '京B12345', '备注3', '2023-03-22 20:46:00', '2023-03-22 20:46:11');
INSERT INTO `tb_car` VALUES ('4', '/fileupload/d057c823-ec0d-4731-a5a3-39483c341b96.jpg', '2', 'black', '京B67890', '备注4', '2023-03-22 20:46:00', '2023-03-22 20:46:11');
INSERT INTO `tb_car` VALUES ('5', '/fileupload/d057c823-ec0d-4731-a5a3-39483c341b96.jpg', '3', 'white', '京C12345', '备注5', '2023-03-22 20:46:00', '2023-03-22 20:46:11');
INSERT INTO `tb_car` VALUES ('6', '/fileupload/d057c823-ec0d-4731-a5a3-39483c341b96.jpg', '3', 'red', '京C67890', '备注6', '2023-03-22 20:46:00', '2023-03-22 20:46:11');
INSERT INTO `tb_car` VALUES ('7', '/fileupload/d057c823-ec0d-4731-a5a3-39483c341b96.jpg', '4', 'blue', '京D12345', '备注7', '2023-03-22 20:46:00', '2023-03-22 20:46:11');
INSERT INTO `tb_car` VALUES ('8', '/fileupload/d057c823-ec0d-4731-a5a3-39483c341b96.jpg', '4', 'red', '京D67890', '备注8', '2023-03-22 20:46:00', '2023-03-22 20:46:11');
INSERT INTO `tb_car` VALUES ('9', '/fileupload/d057c823-ec0d-4731-a5a3-39483c341b96.jpg', '5', 'yellow', '京E12345', '备注9', '2023-03-22 20:46:00', '2023-03-22 20:46:11');
INSERT INTO `tb_car` VALUES ('10', '/fileupload/d057c823-ec0d-4731-a5a3-39483c341b96.jpg', '6', 'black', '京F12345', '备注10', '2023-03-22 20:46:00', '2023-03-22 20:46:11');

-- ----------------------------
-- Table structure for tb_charge_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_charge_detail`;
CREATE TABLE `tb_charge_detail` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '收费明细ID',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `charge_item_id` int DEFAULT NULL COMMENT '收费项目ID',
  `charge_item_name` varchar(50) DEFAULT NULL COMMENT '收费项目名称',
  `contractor` varchar(50) DEFAULT NULL COMMENT '承办人名称',
  `telephone` bigint DEFAULT NULL COMMENT '承办人联系电话',
  `pay_money` int DEFAULT NULL COMMENT '应收金额(￥)，单位分',
  `actual_money` int DEFAULT NULL COMMENT '实收金额(￥)，单位分',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `pay_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '缴费时间',
  `status` char(1) DEFAULT '0' COMMENT '状态：0-生效中（默认），1-已过期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='收费名细表';

-- ----------------------------
-- Records of tb_charge_detail
-- ----------------------------
INSERT INTO `tb_charge_detail` VALUES ('1', '1', '翻斗花园A区', '1', '物业管理费', '张三', '13800000000', '20000', '20000', '2023-03-25 21:58:40', '2023-03-24 21:31:16', '2022-12-01 00:00:00', '0');
INSERT INTO `tb_charge_detail` VALUES ('2', '1', '翻斗花园A区', '2', '车位管理费', '李四', '13811111111', '5000', '5000', '2023-03-25 21:58:40', '2023-03-24 21:31:16', '2022-12-01 00:00:00', '1');
INSERT INTO `tb_charge_detail` VALUES ('3', '2', '翻斗花园B区', '3', '物业管理费', '王五', '13822222222', '18000', '18000', '2023-03-25 21:58:40', '2023-03-24 21:31:16', '2022-12-01 00:00:00', '1');
INSERT INTO `tb_charge_detail` VALUES ('4', '2', '翻斗花园B区', '4', '车位管理费', '赵六', '13833333333', '4000', '4000', '2023-03-25 21:58:40', '2023-03-24 21:31:16', '2022-12-01 00:00:00', '1');
INSERT INTO `tb_charge_detail` VALUES ('5', '3', '翻斗花园C区', '5', '物业管理费', '张三', '13800000000', '22000', '22000', '2023-03-25 21:58:40', '2023-03-24 21:31:16', '2022-12-01 00:00:00', '0');
INSERT INTO `tb_charge_detail` VALUES ('6', '3', '翻斗花园C区', '6', '车位管理费', '李四', '13811111111', '4500', '4500', '2023-03-25 21:58:40', '2023-03-24 21:31:16', '2022-12-01 00:00:00', '0');
INSERT INTO `tb_charge_detail` VALUES ('7', '4', '翻斗花园D区', '7', '物业管理费', '王五', '13822222222', '19000', '19000', '2023-03-25 21:58:40', '2023-03-24 21:31:16', '2022-12-01 00:00:00', '1');
INSERT INTO `tb_charge_detail` VALUES ('8', '4', '翻斗花园D区', '8', '车位管理费', '赵六', '13833333333', '4200', '4200', '2023-03-25 21:58:40', '2023-03-24 21:31:16', '2022-12-01 00:00:00', '1');
INSERT INTO `tb_charge_detail` VALUES ('9', '5', '翻斗花园E区', '9', '物业管理费', '张三', '13800000000', '21000', '20000', '2023-03-25 21:58:40', '2023-03-24 21:31:16', '2022-12-01 00:00:00', '0');
INSERT INTO `tb_charge_detail` VALUES ('10', '5', '翻斗花园E区', '10', '车位管理费', '李四', '13811111111', '4800', '4800', '2023-03-25 21:58:40', '2023-03-24 21:31:16', '2022-12-01 00:00:00', '0');

-- ----------------------------
-- Table structure for tb_charge_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_charge_item`;
CREATE TABLE `tb_charge_item` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '收费项目ID',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `code` varchar(20) DEFAULT NULL COMMENT '收费编号',
  `name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `money` int DEFAULT NULL COMMENT '项目收费金额（年），单位分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='收费项目表';

-- ----------------------------
-- Records of tb_charge_item
-- ----------------------------
INSERT INTO `tb_charge_item` VALUES ('1', '1', '翻斗花园A区', '10001', '物业管理费', '2023-03-24 21:27:36', '2023-03-24 21:30:51', '20000');
INSERT INTO `tb_charge_item` VALUES ('2', '1', '翻斗花园A区', '10002', '车位管理费', '2023-03-24 21:27:36', '2023-03-24 21:30:51', '5000');
INSERT INTO `tb_charge_item` VALUES ('3', '2', '翻斗花园B区', '20001', '物业管理费', '2023-03-24 21:27:36', '2023-03-24 21:30:51', '18000');
INSERT INTO `tb_charge_item` VALUES ('4', '2', '翻斗花园B区', '20002', '车位管理费', '2023-03-24 21:27:36', '2023-03-24 21:30:51', '4000');
INSERT INTO `tb_charge_item` VALUES ('5', '3', '翻斗花园C区', '30001', '物业管理费', '2023-03-24 21:27:36', '2023-03-24 21:30:51', '22000');
INSERT INTO `tb_charge_item` VALUES ('6', '3', '翻斗花园C区', '30002', '车位管理费', '2023-03-24 21:27:36', '2023-03-24 21:30:51', '4500');
INSERT INTO `tb_charge_item` VALUES ('7', '4', '翻斗花园D区', '40001', '物业管理费', '2023-03-24 21:27:36', '2023-03-24 21:30:51', '19000');
INSERT INTO `tb_charge_item` VALUES ('8', '4', '翻斗花园D区', '40002', '车位管理费', '2023-03-24 21:27:36', '2023-03-24 21:30:51', '4200');
INSERT INTO `tb_charge_item` VALUES ('9', '5', '翻斗花园E区', '50001', '物业管理费', '2023-03-24 21:27:36', '2023-03-24 21:30:51', '21000');
INSERT INTO `tb_charge_item` VALUES ('10', '5', '翻斗花园E区', '50002', '车位管理费', '2023-03-24 21:27:36', '2023-03-24 21:30:51', '4800');

-- ----------------------------
-- Table structure for tb_community
-- ----------------------------
DROP TABLE IF EXISTS `tb_community`;
CREATE TABLE `tb_community` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '小区id',
  `code` varchar(20) NOT NULL COMMENT '小区编号',
  `name` varchar(50) NOT NULL COMMENT '小区名称',
  `address` varchar(200) DEFAULT NULL COMMENT '坐落地址',
  `area` double DEFAULT NULL COMMENT '占地面积（m2）',
  `total_buildings` int DEFAULT NULL COMMENT '总栋数',
  `total_households` int DEFAULT NULL COMMENT '总户数',
  `greening_rate` int DEFAULT NULL COMMENT '绿化率（%）',
  `thumbnail` varchar(200) DEFAULT NULL COMMENT '缩略图',
  `developer` varchar(100) DEFAULT NULL COMMENT '开发商名称',
  `estate_company` varchar(100) DEFAULT NULL COMMENT '物业公司名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态:0-启用（默认），1-不启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb3 COMMENT='小区表';

-- ----------------------------
-- Records of tb_community
-- ----------------------------
INSERT INTO `tb_community` VALUES ('1', 'FDHY2023001', '翻斗花园A区', '历城区花园路1号', '3333', '66', '2432', '30', '/fileupload/77030e72-4494-4b40-8469-1d9295e81cac.jpg', '翻斗集团', '翻斗物业', '2023-03-26 13:29:32', '2023-03-26 13:29:32', '0');
INSERT INTO `tb_community` VALUES ('2', 'FDHY2023002', '翻斗花园B区', '历城区花园路2号', '33000', '50', '2222', '40', '/fileupload/77030e72-4494-4b40-8469-1d9295e81cac.jpg', '翻斗集团', '翻斗物业', '2023-03-25 21:40:59', '2023-03-25 21:40:59', '0');
INSERT INTO `tb_community` VALUES ('3', 'FDHY2023003', '翻斗花园C区', '历城区花园路3号', '44444', '88', '3000', '50', '/fileupload/77030e72-4494-4b40-8469-1d9295e81cac.jpg', '翻斗集团', '翻斗物业', '2023-03-25 21:29:20', '2023-03-25 21:29:20', '0');
INSERT INTO `tb_community` VALUES ('4', 'FDHY2023004', '翻斗花园D区', '历城区花园路4号', '66666', '66', '2195', '35', '/fileupload/77030e72-4494-4b40-8469-1d9295e81cac.jpg', '翻斗集团', '翻斗物业', '2023-02-08 22:35:29', '2023-02-08 22:35:29', '1');
INSERT INTO `tb_community` VALUES ('5', 'FDHY2023005', '翻斗花园E区', '历城区花园路5号', '12000', '20', '5000', '50', '/fileupload/77030e72-4494-4b40-8469-1d9295e81cac.jpg', '翻斗集团', '翻斗物业', '2023-02-11 10:52:46', '2023-02-11 10:52:46', '0');

-- ----------------------------
-- Table structure for tb_complaint
-- ----------------------------
DROP TABLE IF EXISTS `tb_complaint`;
CREATE TABLE `tb_complaint` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '投诉ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `owner_id` int DEFAULT NULL COMMENT '投诉人员（业主）ID',
  `owner_name` varchar(40) DEFAULT NULL COMMENT '投诉人员（业主）名称',
  `description` varchar(500) DEFAULT NULL COMMENT '投诉具体描述',
  `reason` varchar(100) DEFAULT NULL COMMENT '投诉事由',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态：0-未受理，1-已受理（默认），2-已处理完毕',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='投诉表';

-- ----------------------------
-- Records of tb_complaint
-- ----------------------------
INSERT INTO `tb_complaint` VALUES ('1', '翻斗花园A区', '1', '1001', '张三', '小区门口的垃圾桶一直没有清理，臭味很严重，希望物业能够及时处理', '物业服务不到位', '2023-03-25 21:59:46', '2023-03-24 21:33:04', '0');
INSERT INTO `tb_complaint` VALUES ('2', '翻斗花园A区', '1', '1002', '李四', '小区内停车位不足，且有一些车位被占用了，希望物业能够加强管理', '停车位管理问题', '2023-03-25 21:59:46', '2023-03-24 21:33:04', '1');
INSERT INTO `tb_complaint` VALUES ('3', '翻斗花园B区', '2', '1003', '王五', '小区绿化带内的草坪长得太高了，影响了小区的美观度，希望物业能够及时修剪', '绿化带管理问题', '2023-03-25 21:59:46', '2023-03-24 21:33:04', '1');
INSERT INTO `tb_complaint` VALUES ('4', '翻斗花园B区', '2', '1004', '赵六', '小区门口的路灯坏了，晚上很暗，希望物业能够及时修理', '设施维护问题', '2023-03-25 21:59:46', '2023-03-24 21:33:04', '2');
INSERT INTO `tb_complaint` VALUES ('5', '翻斗花园C区', '3', '1005', '张三', '小区内的垃圾分类桶被混淆了，需要物业工作人员进行整理', '垃圾分类问题', '2023-03-25 21:59:46', '2023-03-24 21:33:04', '0');
INSERT INTO `tb_complaint` VALUES ('6', '翻斗花园C区', '3', '1006', '李四', '小区内的电梯有异响，感觉不太安全，希望物业能够检查维修', '设施维护问题', '2023-03-25 21:59:46', '2023-03-24 21:33:04', '2');
INSERT INTO `tb_complaint` VALUES ('7', '翻斗花园D区', '4', '1007', '王五', '小区内的儿童游乐设施有些损坏了，希望物业能够及时维修', '设施维护问题', '2023-03-25 21:59:46', '2023-03-24 21:33:04', '2');
INSERT INTO `tb_complaint` VALUES ('8', '翻斗花园D区', '4', '1008', '赵六', '小区内的垃圾桶太少了，导致垃圾经常堆放在路边，非常不卫生', '垃圾管理问题', '2023-03-25 21:59:46', '2023-03-24 21:33:04', '2');
INSERT INTO `tb_complaint` VALUES ('9', '翻斗花园E区', '5', '1009', '张三', '小区内的公共厕所需要进行清洁卫生，很脏很臭', '卫生问题', '2023-03-25 21:59:46', '2023-03-24 21:33:04', '0');
INSERT INTO `tb_complaint` VALUES ('10', '翻斗花园E区', '5', '1010', '李四', '小区内的门禁系统有些问题，有时候不能正常使用', '设施维护问题', '2023-03-25 21:59:46', '2023-03-24 21:33:04', '0');

-- ----------------------------
-- Table structure for tb_device
-- ----------------------------
DROP TABLE IF EXISTS `tb_device`;
CREATE TABLE `tb_device` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `code` varchar(20) DEFAULT NULL COMMENT '设备编号',
  `name` varchar(50) DEFAULT NULL COMMENT '设备名称',
  `brand` varchar(40) DEFAULT NULL COMMENT '设备品牌',
  `unit_price` int DEFAULT NULL COMMENT '购买单价(￥)，单位分',
  `num` int DEFAULT NULL COMMENT '购买数量',
  `expected_useful_life` int DEFAULT NULL COMMENT '预计使用年限(年)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `purchase_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '购买日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='设备表';

-- ----------------------------
-- Records of tb_device
-- ----------------------------
INSERT INTO `tb_device` VALUES ('1', '翻斗花园A区', '1', 'D001', '电视', '海信', '100000', '10', '5', '2023-03-25 22:00:16', '2023-03-24 21:34:49', '2021-01-01 00:00:00');
INSERT INTO `tb_device` VALUES ('2', '翻斗花园A区', '1', 'D002', '空调', '格力', '200000', '5', '8', '2023-03-25 22:00:16', '2023-03-24 21:34:49', '2021-02-01 00:00:00');
INSERT INTO `tb_device` VALUES ('3', '翻斗花园B区', '2', 'D003', '洗衣机', '小天鹅', '50000', '20', '6', '2023-03-25 22:00:16', '2023-03-24 21:34:49', '2021-03-01 00:00:00');
INSERT INTO `tb_device` VALUES ('4', '翻斗花园B区', '2', 'D004', '电热水器', '海尔', '80000', '10', '7', '2023-03-25 22:00:16', '2023-03-24 21:34:49', '2021-04-01 00:00:00');
INSERT INTO `tb_device` VALUES ('5', '翻斗花园C区', '3', 'D005', '电梯', '三菱', '5000000', '1', '20', '2023-03-25 22:00:16', '2023-03-24 21:34:49', '2021-05-01 00:00:00');
INSERT INTO `tb_device` VALUES ('6', '翻斗花园C区', '3', 'D006', '水泵', '西门子', '300000', '2', '10', '2023-03-25 22:00:16', '2023-03-24 21:34:49', '2021-06-01 00:00:00');
INSERT INTO `tb_device` VALUES ('7', '翻斗花园D区', '4', 'D007', '燃气灶', '万和', '60000', '15', '5', '2023-03-25 22:00:16', '2023-03-24 21:34:49', '2021-07-01 00:00:00');
INSERT INTO `tb_device` VALUES ('8', '翻斗花园D区', '4', 'D008', '垃圾桶', '欧瑞卡', '5000', '30', '3', '2023-03-25 22:00:16', '2023-03-24 21:34:49', '2021-08-01 00:00:00');
INSERT INTO `tb_device` VALUES ('9', '翻斗花园E区', '5', 'D009', '门禁系统', '华为', '1000000', '1', '15', '2023-03-25 22:00:16', '2023-03-24 21:34:49', '2021-09-01 00:00:00');
INSERT INTO `tb_device` VALUES ('10', '翻斗花园E区', '5', 'D010', '电动车充电桩', '特来电', '200000', '5', '8', '2023-03-25 22:00:16', '2023-03-24 21:34:49', '2021-10-01 00:00:00');

-- ----------------------------
-- Table structure for tb_estate_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_estate_manager`;
CREATE TABLE `tb_estate_manager` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '物业管理人员ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `login_name` varchar(20) DEFAULT NULL COMMENT '登录名:登录时使用的名称',
  `name` varchar(50) DEFAULT NULL COMMENT '真实名称',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `telephone` int DEFAULT NULL COMMENT '手机',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `role_id` int DEFAULT '0' COMMENT '角色ID：0-普通用户（默认0），1-管理员用户',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='物业管理人员表';

-- ----------------------------
-- Records of tb_estate_manager
-- ----------------------------
INSERT INTO `tb_estate_manager` VALUES ('1', '化纤小区', '1', '15900000000', '张三', '123456', '2147483647', '123@163.com', '0', '2020-12-14 10:17:49', '2020-12-14 10:17:49');
INSERT INTO `tb_estate_manager` VALUES ('2', '百花小区', '3', '15911111111', '李四', '123456', '2147483647', '456@163.com', '0', '2020-12-14 10:17:55', '2020-12-14 10:17:55');
INSERT INTO `tb_estate_manager` VALUES ('3', '东风小区', '2', '15922222222', '王五', '123456', '2147483647', '789@163.com', '0', '2020-12-14 10:18:03', '2020-12-14 10:18:03');

-- ----------------------------
-- Table structure for tb_house
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房屋ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `building_name` varchar(50) DEFAULT NULL COMMENT '所属栋数名称',
  `building_id` int DEFAULT NULL COMMENT '所属栋数ID',
  `code` varchar(50) DEFAULT NULL COMMENT '房产编码',
  `name` varchar(100) DEFAULT NULL COMMENT '房产名称',
  `owner_id` int DEFAULT NULL COMMENT '户主（业主）ID',
  `owner_name` varchar(50) DEFAULT NULL COMMENT '户主（业主）名称',
  `telephone` bigint DEFAULT NULL COMMENT '联系方式',
  `room_num` int DEFAULT NULL COMMENT '房间数',
  `unit` int DEFAULT NULL COMMENT '单元',
  `floor` int DEFAULT NULL COMMENT '楼层',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `live_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入住时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='房屋表';

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES ('1', '翻斗花园A区', '1', '1栋', '1', 'WKMY10001', 'A001', '1', '张三', '13000000012', '2', '1', '5', '高楼层，朝南，简约装修', '2023-02-01 14:48:30');
INSERT INTO `tb_house` VALUES ('2', '翻斗花园B区', '2', '2栋', '2', 'ZYCT10002', 'B002', '2', '李四', '13000000001', '3', '2', '8', '超高楼层，朝北，简约装修', '2023-02-02 06:55:00');
INSERT INTO `tb_house` VALUES ('3', '翻斗花园C区', '3', '3栋', '3', 'BGYYGH10003', 'C003', '3', '王五', '13000000002', '2', '3', '10', '中楼层，朝东，简约装修', '2023-02-03 06:55:12');
INSERT INTO `tb_house` VALUES ('4', '翻斗花园D区', '4', '4栋', '4', 'LHYY10004', 'D004', '4', '赵六', '13000000003', '3', '4', '15', '低楼层，朝南，简约装修', '2023-02-03 06:55:24');
INSERT INTO `tb_house` VALUES ('5', '翻斗花园E区', '5', '4栋', '5', 'LHYY10004', 'D004', '5', '赵六', '13000000003', '3', '4', '15', '低楼层，朝南，简约装修', '2023-02-03 06:55:24');

-- ----------------------------
-- Table structure for tb_letter
-- ----------------------------
DROP TABLE IF EXISTS `tb_letter`;
CREATE TABLE `tb_letter` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '信件ID',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `owner_id` int DEFAULT NULL COMMENT '信件发送者（业主）ID',
  `owner_name` varchar(50) DEFAULT NULL COMMENT '信件发送者（业主）名称',
  `origin` char(1) DEFAULT '0' COMMENT '信件来源：0-信箱（默认），1-邮件，2-微信，3-公众号，4-app,5-pc',
  `title` varchar(100) DEFAULT NULL COMMENT '信件标题',
  `content` varchar(2000) DEFAULT NULL COMMENT '信箱内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态:0-未读（默认），1-已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='信件表';

-- ----------------------------
-- Records of tb_letter
-- ----------------------------
INSERT INTO `tb_letter` VALUES ('1', '1', '翻斗花园A区', '1001', '张三', '0', '物业管理不到位', '最近小区门口的垃圾一直没有清理，希望物业能够加强管理', '2023-03-24 21:38:30', '2023-03-24 21:39:08', '0');
INSERT INTO `tb_letter` VALUES ('2', '1', '翻斗花园A区', '1002', '李四', '1', '停车位管理问题', '小区内停车位不足，且有一些车位被占用了，希望物业能够加强管理', '2023-03-24 21:38:30', '2023-03-24 21:39:08', '0');
INSERT INTO `tb_letter` VALUES ('3', '2', '翻斗花园B区', '1003', '王五', '1', '绿化带管理问题', '小区绿化带内的草坪长得太高了，影响了小区的美观度，希望物业能够及时修剪', '2023-03-24 21:38:30', '2023-03-24 21:39:08', '0');
INSERT INTO `tb_letter` VALUES ('4', '2', '翻斗花园B区', '1004', '赵六', '2', '设施维护问题', '小区门口的路灯坏了，晚上很暗，希望物业能够及时修理', '2023-03-24 21:38:30', '2023-03-24 21:39:08', '1');
INSERT INTO `tb_letter` VALUES ('5', '3', '翻斗花园C区', '1005', '张三', '0', '垃圾分类问题', '小区内的垃圾分类桶被混淆了，需要物业工作人员进行整理', '2023-03-24 21:38:30', '2023-03-24 21:39:08', '1');
INSERT INTO `tb_letter` VALUES ('6', '3', '翻斗花园C区', '1006', '李四', '0', '设施维护问题', '小区内的电梯有异响，感觉不太安全，希望物业能够检查维修', '2023-03-24 21:38:30', '2023-03-24 21:39:08', '1');
INSERT INTO `tb_letter` VALUES ('7', '4', '翻斗花园D区', '1007', '王五', '2', '设施维护问题', '小区内的儿童游乐设施有些损坏了，希望物业能够及时维修', '2023-03-24 21:38:30', '2023-03-24 21:39:08', '1');
INSERT INTO `tb_letter` VALUES ('8', '4', '翻斗花园D区', '1008', '赵六', '2', '垃圾管理问题', '小区内的垃圾桶太少了，导致垃圾经常堆放在路边，非常不卫生', '2023-03-24 21:38:30', '2023-03-24 21:39:08', '1');
INSERT INTO `tb_letter` VALUES ('9', '5', '翻斗花园E区', '1009', '张三', '0', '卫生问题', '小区内的公共厕所需要进行清洁卫生，很脏很臭', '2023-03-24 21:38:30', '2023-03-24 21:39:08', '0');
INSERT INTO `tb_letter` VALUES ('10', '5', '翻斗花园E区', '1010', '李四', '0', '设施维护问题', '小区内的电动车充电桩已经坏了好几天了，希望物业能够及时维修', '2023-03-24 21:38:30', '2023-03-24 21:39:08', '0');

-- ----------------------------
-- Table structure for tb_owner
-- ----------------------------
DROP TABLE IF EXISTS `tb_owner`;
CREATE TABLE `tb_owner` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '业主ID',
  `community_id` int DEFAULT NULL COMMENT '所属小区',
  `house_id` int DEFAULT NULL COMMENT '所属房产',
  `name` varchar(50) DEFAULT NULL COMMENT '成员名称',
  `picture` varchar(100) DEFAULT NULL COMMENT '成员照片',
  `idcard` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `telephone` bigint DEFAULT NULL COMMENT '联系方式',
  `profession` varchar(20) DEFAULT NULL COMMENT '职业',
  `sex` char(1) DEFAULT '0' COMMENT '性别:0-男（默认），1-女',
  `type` char(1) DEFAULT '0' COMMENT '类型:0-房主（默认），1-租客',
  `remark` varchar(200) DEFAULT '无' COMMENT '备注（默认无）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `birthday` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '出生日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3 COMMENT='业主表';

-- ----------------------------
-- Records of tb_owner
-- ----------------------------
INSERT INTO `tb_owner` VALUES ('1', '5', '2', '张三', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1990xxxx001', '13812345678', '教师', '0', '1', '无', '2023-03-19 15:30:00', '2023-03-19 18:02:21', '1990-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('2', '3', '4', '李四', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1995xxxx002', '13912345678', '工人', '1', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:39', '1995-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('3', '2', '3', '王五', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1992xxxx003', '13922345678', '会计师', '1', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:43', '1992-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('4', '1', '2', '赵六', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1993xxxx004', '13932345678', '医生', '1', '1', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:45', '1993-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('5', '4', '5', '钱七', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1988xxxx005', '13942345678', '自由职业者', '0', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:48', '1988-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('6', '1', '5', '孙八', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1989xxxx006', '13952345678', '设计师', '0', '1', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:53', '1989-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('7', '2', '2', '周九', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1985xxxx007', '13962345678', '教练', '0', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:51', '1985-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('8', '5', '2', '张三', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1990xxxx001', '13812345678', '教师', '0', '1', '无', '2023-03-19 15:30:00', '2023-03-19 18:02:21', '1990-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('9', '3', '4', '李四', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1995xxxx002', '13912345678', '工人', '1', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:39', '1995-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('10', '2', '3', '王五', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1992xxxx003', '13922345678', '会计师', '1', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:43', '1992-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('11', '1', '2', '赵六', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1993xxxx004', '13932345678', '医生', '1', '1', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:45', '1993-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('12', '4', '5', '钱七', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1988xxxx005', '13942345678', '自由职业者', '0', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:48', '1988-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('13', '1', '5', '孙八', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1989xxxx006', '13952345678', '设计师', '0', '1', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:53', '1989-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('14', '2', '2', '周九', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1985xxxx007', '13962345678', '教练', '0', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:51', '1985-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('15', '5', '2', '张三', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1990xxxx001', '13812345678', '教师', '0', '1', '无', '2023-03-19 15:30:00', '2023-03-19 18:02:21', '1990-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('16', '3', '4', '李四', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1995xxxx002', '13912345678', '工人', '1', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:39', '1995-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('17', '2', '3', '王五', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1992xxxx003', '13922345678', '会计师', '1', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:43', '1992-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('18', '1', '2', '赵六', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1993xxxx004', '13932345678', '医生', '1', '1', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:45', '1993-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('19', '4', '5', '钱七', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1988xxxx005', '13942345678', '自由职业者', '0', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:48', '1988-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('20', '1', '5', '孙八', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1989xxxx006', '13952345678', '设计师', '0', '1', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:53', '1989-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('21', '2', '2', '周九', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1985xxxx007', '13962345678', '教练', '0', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:51', '1985-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('22', '5', '2', '张三', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1990xxxx001', '13812345678', '教师', '0', '1', '无', '2023-03-19 15:30:00', '2023-03-19 18:02:21', '1990-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('23', '3', '4', '李四', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1995xxxx002', '13912345678', '工人', '1', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:39', '1995-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('24', '2', '3', '王五', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1992xxxx003', '13922345678', '会计师', '1', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:43', '1992-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('25', '1', '2', '赵六', '/fileupload/6ff511bd-e81a-418e-b4d0-664f9152f10f.jpg', '510xxx1993xxxx004', '13932345678', '医生', '1', '1', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:45', '1993-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('26', '4', '5', '钱七', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1988xxxx005', '13942345678', '自由职业者', '0', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:48', '1988-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('27', '1', '5', '孙八', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1989xxxx006', '13952345678', '设计师', '0', '1', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:53', '1989-01-01 00:00:00');
INSERT INTO `tb_owner` VALUES ('28', '2', '2', '周九', '/fileupload/d1019888-8c98-46c9-9fcd-980885a23ef5.jpg', '510xxx1985xxxx007', '13962345678', '教练', '0', '0', '无', '2023-03-19 15:30:00', '2023-03-21 21:15:51', '1985-01-01 00:00:00');

-- ----------------------------
-- Table structure for tb_parking
-- ----------------------------
DROP TABLE IF EXISTS `tb_parking`;
CREATE TABLE `tb_parking` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '车位ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `picture` varchar(100) DEFAULT NULL COMMENT '车位图片',
  `code` varchar(20) DEFAULT NULL COMMENT '车位编号',
  `name` varchar(50) DEFAULT NULL COMMENT '车位名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COMMENT='车位表';

-- ----------------------------
-- Records of tb_parking
-- ----------------------------
INSERT INTO `tb_parking` VALUES ('1', '翻斗花园A区', '1', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P001', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '0');
INSERT INTO `tb_parking` VALUES ('2', '翻斗花园A区', '1', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P002', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '0');
INSERT INTO `tb_parking` VALUES ('3', '翻斗花园A区', '1', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P003', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '1');
INSERT INTO `tb_parking` VALUES ('4', '翻斗花园B区', '2', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P001', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '0');
INSERT INTO `tb_parking` VALUES ('5', '翻斗花园B区', '2', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P002', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '1');
INSERT INTO `tb_parking` VALUES ('6', '翻斗花园B区', '2', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P002', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '1');
INSERT INTO `tb_parking` VALUES ('7', '翻斗花园C区', '3', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P001', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '1');
INSERT INTO `tb_parking` VALUES ('8', '翻斗花园C区', '3', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P002', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '0');
INSERT INTO `tb_parking` VALUES ('9', '翻斗花园C区', '4', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P001', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '1');
INSERT INTO `tb_parking` VALUES ('10', '翻斗花园D区', '4', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P002', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '0');
INSERT INTO `tb_parking` VALUES ('11', '翻斗花园D区', '4', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P003', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '1');
INSERT INTO `tb_parking` VALUES ('12', '翻斗花园D区', '5', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P001', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '1');
INSERT INTO `tb_parking` VALUES ('13', '翻斗花园E区', '5', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P002', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '0');
INSERT INTO `tb_parking` VALUES ('14', '翻斗花园E区', '5', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', 'P003', '翻斗花园A区车位', '2023-03-22 21:13:44', '2023-03-22 21:13:52', '1');

-- ----------------------------
-- Table structure for tb_parking_use
-- ----------------------------
DROP TABLE IF EXISTS `tb_parking_use`;
CREATE TABLE `tb_parking_use` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '车位使用ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `code` varchar(20) DEFAULT NULL COMMENT '车位编号',
  `car_number` varchar(20) DEFAULT NULL COMMENT '车牌号码',
  `picture` varchar(100) DEFAULT NULL COMMENT '车辆牌照（照片）',
  `owner_name` varchar(50) DEFAULT NULL COMMENT '车辆所有人（业主）名称',
  `owner_id` int DEFAULT NULL COMMENT '车辆所有人（业主）ID',
  `telephone` bigint DEFAULT NULL COMMENT '联系方式',
  `use_type` char(1) DEFAULT '0' COMMENT '使用性质：0-购买(默认)，1-月租，2-年租',
  `total_fee` int DEFAULT NULL COMMENT '总费用(￥)，以分为单位',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '（使用）开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '（使用）结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='车位使用表';

-- ----------------------------
-- Records of tb_parking_use
-- ----------------------------
INSERT INTO `tb_parking_use` VALUES ('1', '翻斗花园A区', '1', 'A01', '粤A12345', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', '张三', '1', '13800138000', '0', '2000', '2022-01-01 00:00:00', '2022-01-02 00:00:00', '2022-01-03 00:00:00', '2022-01-05 00:00:00');
INSERT INTO `tb_parking_use` VALUES ('2', '翻斗花园A区', '1', 'A02', '粤A23456', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', '李四', '2', '13800138001', '1', '5000', '2022-01-02 00:00:00', '2022-01-03 00:00:00', '2022-02-01 00:00:00', '2022-03-01 00:00:00');
INSERT INTO `tb_parking_use` VALUES ('3', '翻斗花园B区', '2', 'B01', '京A12345', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', '王五', '3', '13800138002', '0', '1500', '2022-01-03 00:00:00', '2022-01-04 00:00:00', '2022-01-05 00:00:00', '2022-01-08 00:00:00');
INSERT INTO `tb_parking_use` VALUES ('4', '翻斗花园B区', '2', 'B02', '京A23456', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', '赵六', '4', '13800138003', '2', '20000', '2022-01-04 00:00:00', '2022-01-05 00:00:00', '2022-02-01 00:00:00', '2023-02-01 00:00:00');
INSERT INTO `tb_parking_use` VALUES ('5', '翻斗花园C区', '3', '001', '粤B12345', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', '张三', '1', '13612345678', '0', '5000', '2023-02-14 00:00:00', '2023-02-14 00:00:00', '2023-02-15 08:00:00', '2023-02-15 18:00:00');
INSERT INTO `tb_parking_use` VALUES ('6', '翻斗花园C区', '3', '002', '粤B23456', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', '李四', '2', '13698765432', '0', '6000', '2023-02-13 00:00:00', '2023-02-13 00:00:00', '2023-02-14 07:00:00', '2023-02-14 17:00:00');
INSERT INTO `tb_parking_use` VALUES ('7', '翻斗花园D区', '4', '003', '粤B34567', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', '王五', '3', '13876543210', '1', '80000', '2023-02-12 00:00:00', '2023-02-12 00:00:00', '2023-03-01 00:00:00', '2023-03-31 23:59:59');
INSERT INTO `tb_parking_use` VALUES ('8', '翻斗花园D区', '4', '004', '粤B45678', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', '赵六', '4', '13987654321', '1', '50000', '2023-02-11 00:00:00', '2023-02-11 00:00:00', '2023-03-01 00:00:00', '2023-03-31 23:59:59');
INSERT INTO `tb_parking_use` VALUES ('9', '翻斗花园E区', '5', '005', '粤B56789', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', '钱七', '5', '13765432109', '2', '100000', '2023-02-10 00:00:00', '2023-02-10 00:00:00', '2023-02-01 00:00:00', '2024-01-31 23:59:59');
INSERT INTO `tb_parking_use` VALUES ('10', '翻斗花园E区', '5', '006', '粤B67890', '/fileupload/1dda8857-178a-4ecb-97b2-ddda30885507.jpg', '孙八', '6', '13543210987', '2', '200000', '2023-02-09 00:00:00', '2023-02-09 00:00:00', '2023-02-01 00:00:00', '2024-01-31 23:59:59');

-- ----------------------------
-- Table structure for tb_pet
-- ----------------------------
DROP TABLE IF EXISTS `tb_pet`;
CREATE TABLE `tb_pet` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '宠物ID',
  `picture` varchar(100) DEFAULT NULL COMMENT '宠物照片',
  `owner_name` varchar(50) DEFAULT NULL COMMENT '所属成员（业主）名称',
  `owner_id` int DEFAULT NULL COMMENT '所属成员（业主）ID',
  `name` varchar(50) DEFAULT NULL COMMENT '宠物名称',
  `color` varchar(10) DEFAULT NULL COMMENT '宠物颜色',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `adopt_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '收养时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='宠物表';

-- ----------------------------
-- Records of tb_pet
-- ----------------------------
INSERT INTO `tb_pet` VALUES ('1', '/fileupload/3cb522a3-6383-43be-9f30-228d730c6646.jpeg', '张三', '1', '小狗狗', '棕色', '可爱的小狗狗', '2023-03-22 21:03:02', '2023-03-22 21:03:09', '2022-02-01 12:00:00');
INSERT INTO `tb_pet` VALUES ('2', '/fileupload/3cb522a3-6383-43be-9f30-228d730c6646.jpeg', '李四', '2', '小猫咪', '黑色', '喵喵喵', '2023-03-22 21:03:02', '2023-03-22 21:03:09', '2022-02-02 12:00:00');
INSERT INTO `tb_pet` VALUES ('3', '/fileupload/3cb522a3-6383-43be-9f30-228d730c6646.jpeg', '王五', '3', '小鸟儿', '红色', '欢快的小鸟儿', '2023-03-22 21:03:02', '2023-03-22 21:03:09', '2022-02-03 12:00:00');
INSERT INTO `tb_pet` VALUES ('4', '/fileupload/3cb522a3-6383-43be-9f30-228d730c6646.jpeg', '张三', '1', '小乌龟', '绿色', '慢慢爬的小乌龟', '2023-03-22 21:03:02', '2023-03-22 21:03:09', '2022-02-04 12:00:00');
INSERT INTO `tb_pet` VALUES ('5', '/fileupload/3cb522a3-6383-43be-9f30-228d730c6646.jpeg', '赵六', '4', '小鹿', '棕色', '美丽的小鹿', '2023-03-22 21:03:02', '2023-03-22 21:03:09', '2022-02-05 12:00:00');
INSERT INTO `tb_pet` VALUES ('6', '/fileupload/3cb522a3-6383-43be-9f30-228d730c6646.jpeg', '孙七', '5', '小鱼儿', '黄色', '水中的小鱼儿', '2023-03-22 21:03:02', '2023-03-22 21:03:09', '2022-02-06 12:00:00');
INSERT INTO `tb_pet` VALUES ('7', '/fileupload/3cb522a3-6383-43be-9f30-228d730c6646.jpeg', '王五', '3', '小乌鸦', '黑色', '神秘的小乌鸦', '2023-03-22 21:03:02', '2023-03-22 21:03:09', '2022-02-06 12:00:00');

-- ----------------------------
-- Table structure for tb_repair
-- ----------------------------
DROP TABLE IF EXISTS `tb_repair`;
CREATE TABLE `tb_repair` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '维修ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '所属小区名称',
  `community_id` int DEFAULT NULL COMMENT '所属小区ID',
  `building_name` varchar(50) DEFAULT NULL COMMENT '所属楼栋名称',
  `building_id` int DEFAULT NULL COMMENT '所属楼栋ID',
  `owner_name` varchar(50) DEFAULT NULL COMMENT '报修人员（业主）名称',
  `owner_id` int DEFAULT NULL COMMENT '报修人员（业主）ID',
  `device_name` varchar(50) DEFAULT NULL COMMENT '设备名称',
  `device_id` int DEFAULT NULL COMMENT '设备编号ID',
  `description` varchar(500) DEFAULT NULL COMMENT '报修描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态：0-待受理，1-已受理，2-修理完毕',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COMMENT='维修表';

-- ----------------------------
-- Records of tb_repair
-- ----------------------------
INSERT INTO `tb_repair` VALUES ('1', '翻斗花园A区', '1', '1号楼', '101', '张三', '1001', '电视', '201', '电视机无法开机', '2023-03-24 21:41:41', '2023-03-25 19:49:48', '0');
INSERT INTO `tb_repair` VALUES ('2', '翻斗花园A区', '1', '2号楼', '102', '李四', '1002', '空调', '202', '空调制冷效果不好', '2023-03-24 21:41:41', '2023-03-25 19:49:48', '0');
INSERT INTO `tb_repair` VALUES ('3', '翻斗花园B区', '2', '3号楼', '103', '王五', '1003', '洗衣机', '203', '洗衣机漏水', '2023-03-24 21:41:41', '2023-03-25 19:49:48', '1');
INSERT INTO `tb_repair` VALUES ('4', '翻斗花园B区', '2', '4号楼', '104', '赵六', '1004', '热水器', '204', '热水器没有热水', '2023-03-24 21:41:41', '2023-03-25 19:49:48', '1');
INSERT INTO `tb_repair` VALUES ('5', '翻斗花园C区', '3', '5号楼', '105', '张三', '1005', '灯具', '205', '灯泡需要更换', '2023-03-24 21:41:41', '2023-03-25 19:49:48', '2');
INSERT INTO `tb_repair` VALUES ('6', '翻斗花园C区', '3', '6号楼', '106', '李四', '1006', '排气扇', '206', '排气扇声音太大', '2023-03-24 21:41:41', '2023-03-25 19:49:48', '2');
INSERT INTO `tb_repair` VALUES ('7', '翻斗花园D区', '4', '7号楼', '107', '王五', '1007', '门锁', '207', '门锁损坏需要更换', '2023-03-24 21:41:41', '2023-03-25 19:49:48', '2');
INSERT INTO `tb_repair` VALUES ('8', '翻斗花园D区', '4', '8号楼', '108', '赵六', '1008', '水龙头', '208', '水龙头漏水需要修理', '2023-03-24 21:41:41', '2023-03-25 19:49:48', '2');
INSERT INTO `tb_repair` VALUES ('9', '翻斗花园E区', '5', '9号楼', '109', '张三', '1009', '电梯', '209', '电梯出现故障需要维修', '2023-03-24 21:41:41', '2023-03-25 19:49:48', '1');
INSERT INTO `tb_repair` VALUES ('10', '翻斗花园E区', '5', '10号楼', '110', '李四', '1010', '窗户', '210', '窗户密封不好需要更换', '2023-03-24 21:41:41', '2023-03-25 19:49:48', '0');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `head_img` varchar(255) DEFAULT NULL COMMENT '头像',
  `telephone` varchar(255) DEFAULT NULL COMMENT '手机',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `salt` varchar(255) NOT NULL COMMENT '加盐加密',
  `power` int unsigned NOT NULL DEFAULT '0' COMMENT '用户权限，0-管理员，1-超级管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', '6d5267077b3b0041bfeafd7a2a8337bd', '/fileupload/122b8007-bea0-4507-ad23-f86721c57315.jpeg', '12344445555', '2023-02-12 17:24:11', '0515fe8fb0744b16ae69655643ab95e1', '1');
INSERT INTO `tb_user` VALUES ('2', 'keke', '6d5267077b3b0041bfeafd7a2a8337bd', '/fileupload/122b8007-bea0-4507-ad23-f86721c57315.jpeg', '12355556666', '2023-02-12 11:48:53', '0515fe8fb0744b16ae69655643ab95e1', '0');
