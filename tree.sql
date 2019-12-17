/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : tree

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 16/12/2019 20:29:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for nodetree
-- ----------------------------
DROP TABLE IF EXISTS `nodetree`;
CREATE TABLE `nodetree`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `data` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `father` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nodetree
-- ----------------------------
INSERT INTO `nodetree` VALUES (1, '5', '0');
INSERT INTO `nodetree` VALUES (2, '10', '5');
INSERT INTO `nodetree` VALUES (3, '15', '5');
INSERT INTO `nodetree` VALUES (4, '20', '10');
INSERT INTO `nodetree` VALUES (5, '11', '15');
INSERT INTO `nodetree` VALUES (6, '153', '11');
INSERT INTO `nodetree` VALUES (7, '80', '5');

SET FOREIGN_KEY_CHECKS = 1;
