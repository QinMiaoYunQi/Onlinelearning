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

 Date: 12/08/2021 14:43:49
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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '一班', '02.12', '张三');
INSERT INTO `class` VALUES (2, '二班', '03.24', '小红');
INSERT INTO `class` VALUES (3, '三班', '07.06', '王五');
INSERT INTO `class` VALUES (5, '四班', '10.24', '李四');

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

-- ----------------------------
-- Table structure for holiday
-- ----------------------------
DROP TABLE IF EXISTS `holiday`;
CREATE TABLE `holiday`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `data` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of holiday
-- ----------------------------
INSERT INTO `holiday` VALUES (1, '小红', '11111', '2021.07.05', '回家', '同意');
INSERT INTO `holiday` VALUES (2, '小红', '11111', '2021.08.10', '生病', '待管理员审批');
INSERT INTO `holiday` VALUES (3, '小红', '11111', '2021.07.21', '生病', '待管理员审批');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `className` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `date` datetime(0) DEFAULT NULL,
  `teacherName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (1, '语文作业', '二班', '2021-08-11 15:51:22', '小红');
INSERT INTO `homework` VALUES (2, '数学作业', '一班', '2021-08-11 16:25:23', '小黄');

-- ----------------------------
-- Table structure for jobname
-- ----------------------------
DROP TABLE IF EXISTS `jobname`;
CREATE TABLE `jobname`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `fraction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '无',
  `jobName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `ClassName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of jobname
-- ----------------------------
INSERT INTO `jobname` VALUES (1, '张三', '无', '语文作业', '二班', '哈哈哈');
INSERT INTO `jobname` VALUES (2, '李四', 'A', '语文作业', '二班', '哈哈哈哈');
INSERT INTO `jobname` VALUES (3, '王五', '无', '数学作业', '一班', '1+1=2');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'userName',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `type` int(11) DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES (1, '111', '123456', 0);
INSERT INTO `login` VALUES (2, '222', '123456', 0);
INSERT INTO `login` VALUES (3, '333', '123456', 0);
INSERT INTO `login` VALUES (4, '444', '123456', 0);
INSERT INTO `login` VALUES (5, '555', '123456', 0);
INSERT INTO `login` VALUES (6, '666', '123456', 0);
INSERT INTO `login` VALUES (7, '777', '123456', 0);
INSERT INTO `login` VALUES (8, '888', '123456', 0);
INSERT INTO `login` VALUES (9, '13313223144', '123456', 0);
INSERT INTO `login` VALUES (10, '1111', '123456', 1);
INSERT INTO `login` VALUES (11, '2222', '123456', 1);
INSERT INTO `login` VALUES (12, '3333', '123456', 1);
INSERT INTO `login` VALUES (13, '4444', '123456', 1);
INSERT INTO `login` VALUES (14, '5555', '123456', 1);
INSERT INTO `login` VALUES (15, '6666', '123456', 1);
INSERT INTO `login` VALUES (16, '7777', '123456', 1);
INSERT INTO `login` VALUES (17, '8888', '123456', 1);
INSERT INTO `login` VALUES (18, '11111', '123456', 2);
INSERT INTO `login` VALUES (19, '22222', '123456', 2);
INSERT INTO `login` VALUES (20, '13313223144', '123456', 2);
INSERT INTO `login` VALUES (21, '33333', '123456', 2);
INSERT INTO `login` VALUES (22, '13331247062', '123456', 2);
INSERT INTO `login` VALUES (23, '44444', '123456', 2);
INSERT INTO `login` VALUES (25, '17758625727', '123456', 2);
INSERT INTO `login` VALUES (26, '77777', '123456', 2);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `className` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', '111', '123456', '一班');
INSERT INTO `student` VALUES (2, '李四', '222', '123456', '一班');
INSERT INTO `student` VALUES (3, '王五', '333', '123456', '一班');
INSERT INTO `student` VALUES (4, '李留', '444', '123456', '二班');
INSERT INTO `student` VALUES (5, '小白', '555', '123456', '二班');
INSERT INTO `student` VALUES (6, '小黑', '666', '123456', '二班');
INSERT INTO `student` VALUES (7, '小红', '777', '123456', '二班');
INSERT INTO `student` VALUES (8, '小花', '888', '123456', '一班');
INSERT INTO `student` VALUES (9, '小兰', '13313223144', '123456', '三班');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `className` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张三', '13313223144', '123456', '一班');
INSERT INTO `teacher` VALUES (2, '小红', '11111', '123456', '二班');
INSERT INTO `teacher` VALUES (3, '小黄', '22222', '123456', '无');
INSERT INTO `teacher` VALUES (4, '小兰', '33333', '123456', '无');
INSERT INTO `teacher` VALUES (5, '李四', '13331247062', '123456', '四班');
INSERT INTO `teacher` VALUES (6, '小绿', '44444', '123456', '无');
INSERT INTO `teacher` VALUES (8, '王五', '17758625727', '123456', '三班');
INSERT INTO `teacher` VALUES (22, '小黑', '77777', '45453', '无');

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `studentName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title` VALUES (1, '因式分解法', '一元二次方程', '李四');
INSERT INTO `title` VALUES (9, '解决', '一元二次方程', '小红');
INSERT INTO `title` VALUES (10, '杀杀杀', '一元二次方程', '小红');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `heat` int(11) DEFAULT NULL,
  `foundTime` datetime(6) DEFAULT NULL,
  `studentName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES (1, '一元二次方程', 3, '2021-08-12 10:14:20.000000', '张三');
INSERT INTO `topic` VALUES (2, '微积分', 0, '2021-08-12 10:22:34.425000', '张三');

SET FOREIGN_KEY_CHECKS = 1;
