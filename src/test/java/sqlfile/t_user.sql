
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (`passWord` varchar(255) DEFAULT NULL,`userName` varchar(255) DEFAULT NULL, `id` int(11) NOT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
--INSERT INTO `t_user` VALUES ('admin', 'admin', '0');
INSERT INTO `t_user` VALUES ('123456', 'shan', '1');
