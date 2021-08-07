/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : onlinelearning

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 06/08/2021 18:04:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `foundTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `teacherName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '一班', '02.12', '张三');
INSERT INTO `class` VALUES (2, '二班', '03.24', '李四');
INSERT INTO `class` VALUES (3, '三班', '07.06', '王五');

SET FOREIGN_KEY_CHECKS = 1;
