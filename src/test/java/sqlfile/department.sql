
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (`departName` varchar(255) DEFAULT NULL,`departId` int(50) NOT NULL AUTO_INCREMENT,PRIMARY KEY (`departId`)) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('外语系', '1');
INSERT INTO `department` VALUES ('艺术学院', '2');
INSERT INTO `department` VALUES ('教育系', '3');
INSERT INTO `department` VALUES ('电子工程与电气自动化学院', '4');
INSERT INTO `department` VALUES ('化学化工与生命科学学院', '5');
INSERT INTO `department` VALUES ('历史旅游文化系', '6');
INSERT INTO `department` VALUES ('数学系', '7');
INSERT INTO `department` VALUES ('计算机与信息工程学院', '8');
INSERT INTO `department` VALUES ('经济管理与法学学院', '9');
INSERT INTO `department` VALUES ('体育系', '10');
INSERT INTO `department` VALUES ('思想政治理论课教学部', '11');
INSERT INTO `department` VALUES ('文学与传媒系', '12');
