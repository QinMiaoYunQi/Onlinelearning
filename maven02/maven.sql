/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : maven

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 03/08/2021 14:38:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fileName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (1, 'cookie.js');
INSERT INTO `file` VALUES (2, 'java基础简答题答案.txt');
INSERT INTO `file` VALUES (3, '接口文档.pdf');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'userName',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES (1, '三三三', '123456');
INSERT INTO `login` VALUES (2, '李四', '123456');
INSERT INTO `login` VALUES (3, '王五', '123456');
INSERT INTO `login` VALUES (4, '李留', '123456');
INSERT INTO `login` VALUES (5, '小白', '123456');
INSERT INTO `login` VALUES (6, '小黑', '123456');
INSERT INTO `login` VALUES (7, '小红', '123456');
INSERT INTO `login` VALUES (8, 'admin', '123456');
INSERT INTO `login` VALUES (9, '小兰', '123456');
INSERT INTO `login` VALUES (10, '小绿', '123456');
INSERT INTO `login` VALUES (11, '赵三', '123456');
INSERT INTO `login` VALUES (12, '钱三', '123456');
INSERT INTO `login` VALUES (13, '孙三', '123456');
INSERT INTO `login` VALUES (14, '李三', '123456');
INSERT INTO `login` VALUES (15, '周三', '123456');
INSERT INTO `login` VALUES (16, '吴三', '123456');
INSERT INTO `login` VALUES (17, '郑三', '123456');
INSERT INTO `login` VALUES (18, '王三', '123456');
INSERT INTO `login` VALUES (19, '汉三', '123456');
INSERT INTO `login` VALUES (20, '陈三', '123456');
INSERT INTO `login` VALUES (21, '舒散', '123456');
INSERT INTO `login` VALUES (22, '魏三', '123456');
INSERT INTO `login` VALUES (23, 'ssssss', 'sssss');
INSERT INTO `login` VALUES (25, 'sdsd', 'das');
INSERT INTO `login` VALUES (26, 'sada', 'sss');

-- ----------------------------
-- Table structure for phone
-- ----------------------------
DROP TABLE IF EXISTS `phone`;
CREATE TABLE `phone`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of phone
-- ----------------------------
INSERT INTO `phone` VALUES (1, '18331011889', 1);
INSERT INTO `phone` VALUES (2, '18331011889', 2);
INSERT INTO `phone` VALUES (3, '18331011889', 3);
INSERT INTO `phone` VALUES (4, '18331011889', 4);
INSERT INTO `phone` VALUES (5, '18331011889', 5);
INSERT INTO `phone` VALUES (6, '18331011889', 6);
INSERT INTO `phone` VALUES (7, '18331011889', 7);
INSERT INTO `phone` VALUES (8, '18331011889', 8);
INSERT INTO `phone` VALUES (9, '18331011889', 9);
INSERT INTO `phone` VALUES (10, '18331011889', 10);
INSERT INTO `phone` VALUES (11, '18331011889', 11);
INSERT INTO `phone` VALUES (12, '18331011889', 12);
INSERT INTO `phone` VALUES (13, '18331011889', 13);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin1', '123456');
INSERT INTO `user` VALUES (2, 'admin2', '123456');
INSERT INTO `user` VALUES (3, 'admin3', '123456');
INSERT INTO `user` VALUES (4, 'admin4', '123456');
INSERT INTO `user` VALUES (5, 'admin5', '123456');
INSERT INTO `user` VALUES (6, 'admin6', '123456');
INSERT INTO `user` VALUES (7, 'admin7', '123456');
INSERT INTO `user` VALUES (8, 'admin8', '123456');
INSERT INTO `user` VALUES (9, 'admin9', '123456');
INSERT INTO `user` VALUES (10, 'admin10', '123456');
INSERT INTO `user` VALUES (11, 'admin11', '123456');
INSERT INTO `user` VALUES (12, 'admin12', '123456');
INSERT INTO `user` VALUES (13, 'admin13', '123456');

SET FOREIGN_KEY_CHECKS = 1;
