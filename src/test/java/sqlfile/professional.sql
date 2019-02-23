

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `professional`
-- ----------------------------
DROP TABLE IF EXISTS `professional`;
CREATE TABLE `professional` (`p_id` int(50) NOT NULL AUTO_INCREMENT,`proName` varchar(255) NOT NULL,`d_id` int(50) NOT NULL, PRIMARY KEY (`p_id`)) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of professional
-- ----------------------------
INSERT INTO `professional` VALUES ('1', '英语', '1');
INSERT INTO `professional` VALUES ('2', '商务英语', '1');
INSERT INTO `professional` VALUES ('3', '动画', '2');
INSERT INTO `professional` VALUES ('4', '美术学', '2');
INSERT INTO `professional` VALUES ('5', '视觉传达设计', '2');
INSERT INTO `professional` VALUES ('6', '环境设计', '2');
INSERT INTO `professional` VALUES ('7', '设计学类(中外合作办学)', '2');
INSERT INTO `professional` VALUES ('8', '教育技术学', '3');
INSERT INTO `professional` VALUES ('9', '学前教育', '3');
INSERT INTO `professional` VALUES ('10', '小学教育', '3');
INSERT INTO `professional` VALUES ('11', '应用心理学', '3');
INSERT INTO `professional` VALUES ('12', '机械设计制造及其自动化', '4');
INSERT INTO `professional` VALUES ('13', '电气工程及其自动化', '4');
INSERT INTO `professional` VALUES ('14', '电子信息工程', '4');
INSERT INTO `professional` VALUES ('15', '电子科学与技术', '4');
INSERT INTO `professional` VALUES ('16', '微电子科学与工程', '4');
INSERT INTO `professional` VALUES ('17', '化学工程与工艺', '5');
INSERT INTO `professional` VALUES ('18', '无机非金属材料工程', '5');
INSERT INTO `professional` VALUES ('19', '生物工程', '5');
INSERT INTO `professional` VALUES ('20', '应用化学', '5');
INSERT INTO `professional` VALUES ('21', '历史学', '6');
INSERT INTO `professional` VALUES ('22', '旅游管理', '6');
INSERT INTO `professional` VALUES ('23', '酒店管理', '6');
INSERT INTO `professional` VALUES ('24', '数学与应用数学', '7');
INSERT INTO `professional` VALUES ('25', '信息与计算科学', '7');
INSERT INTO `professional` VALUES ('26', '物理学', '7');
INSERT INTO `professional` VALUES ('27', '计算机科学与技术', '8');
INSERT INTO `professional` VALUES ('28', '软件工程', '8');
INSERT INTO `professional` VALUES ('29', '网络工程', '8');
INSERT INTO `professional` VALUES ('30', '物联网工程', '8');
INSERT INTO `professional` VALUES ('31', '金融工程', '9');
INSERT INTO `professional` VALUES ('32', '国际经济与贸易', '9');
INSERT INTO `professional` VALUES ('33', '法学', '9');
INSERT INTO `professional` VALUES ('34', '市场营销', '9');
INSERT INTO `professional` VALUES ('35', '财务管理', '9');
INSERT INTO `professional` VALUES ('36', '文化产业管理', '9');
INSERT INTO `professional` VALUES ('37', '公共事业管理', '9');
INSERT INTO `professional` VALUES ('38', '电子商务', '9');
INSERT INTO `professional` VALUES ('39', '会展经济与管理', '9');
INSERT INTO `professional` VALUES ('40', '旅游管理类(中外合作办学)', '9');
INSERT INTO `professional` VALUES ('41', '统计学', '9');
INSERT INTO `professional` VALUES ('42', '体育教育', '10');
INSERT INTO `professional` VALUES ('43', '社会体育指导与管理', '10');
INSERT INTO `professional` VALUES ('44', '汉语言文学', '12');
INSERT INTO `professional` VALUES ('45', '广播电视学', '12');
INSERT INTO `professional` VALUES ('46', '广告学', '12');
