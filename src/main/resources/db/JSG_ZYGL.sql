/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : JSG_ZYGL

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-05-06 17:48:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `BASE_DIC`
-- ----------------------------
DROP TABLE IF EXISTS `BASE_DIC`;
CREATE TABLE `BASE_DIC` (
  `ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of BASE_DIC
-- ----------------------------

-- ----------------------------
-- Table structure for `USER`
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CERNUM` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMAIL` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PHONE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ADDRESS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BIRTHDAY` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GENDER` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CERTYPE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USERTYPE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `USERLOGIN` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_45jc6tmdcnuco3jexu8knkphn` (`USERLOGIN`),
  CONSTRAINT `FK_45jc6tmdcnuco3jexu8knkphn` FOREIGN KEY (`USERLOGIN`) REFERENCES `user_login` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of USER
-- ----------------------------
INSERT INTO `USER` VALUES ('1', null, null, null, null, null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for `USER_LOGIN`
-- ----------------------------
DROP TABLE IF EXISTS `USER_LOGIN`;
CREATE TABLE `USER_LOGIN` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `LOGIN_NAME` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PASSWORD` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOGINSTATUS` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PARAM1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PARAM2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PARAM3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of USER_LOGIN
-- ----------------------------
INSERT INTO `USER_LOGIN` VALUES ('1', '11', '11', null, null, null, null);
