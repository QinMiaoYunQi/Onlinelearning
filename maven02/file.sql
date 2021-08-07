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

 Date: 06/08/2021 18:04:13
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
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `className` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (1, 'cookie.js', '10.24', '一班');
INSERT INTO `file` VALUES (2, 'java基础简答题答案.txt', '09.23', '二班');
INSERT INTO `file` VALUES (3, '接口文档.pdf', '08.25', '三班');
INSERT INTO `file` VALUES (4, '4. 热带往事.ico', '10.12', '二班');
INSERT INTO `file` VALUES (6, 'java web图书商城.pdf', '08.06', '三班');

SET FOREIGN_KEY_CHECKS = 1;
