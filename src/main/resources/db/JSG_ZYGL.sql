/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : JSG_ZYGL

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-06-03 17:31:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `BASE_DIC`
-- ----------------------------
DROP TABLE IF EXISTS `BASE_DIC`;
CREATE TABLE `BASE_DIC` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CODE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SEQNUM` int(255) DEFAULT NULL,
  `DIC_CATEGORY` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of BASE_DIC
-- ----------------------------

-- ----------------------------
-- Table structure for `DIC_CATEGORY`
-- ----------------------------
DROP TABLE IF EXISTS `DIC_CATEGORY`;
CREATE TABLE `DIC_CATEGORY` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CODE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CATEGORY_TYPE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `COMMENTS` varchar(20000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of DIC_CATEGORY
-- ----------------------------
INSERT INTO `DIC_CATEGORY` VALUES ('1', '1', '1', '1', '1', null, null, null);
INSERT INTO `DIC_CATEGORY` VALUES ('40288f52550af3cd01550af4a4a40000', '22', '22', null, null, null, '2016-06-01 16:07:32', '  22');
INSERT INTO `DIC_CATEGORY` VALUES ('4028932d550043d10155004530330000', '性别', 'GENDER', null, null, '2016-05-30 14:06:22', '2016-05-30 14:06:22', null);

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
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_45jc6tmdcnuco3jexu8knkphn` (`USERLOGIN`),
  KEY `FK27E3CB7740DFF2` (`CERTYPE`),
  KEY `FK27E3CB1A2F485A` (`STATUS`),
  KEY `FK27E3CB3F8E15ED` (`USERTYPE`),
  KEY `FK27E3CB4E76B29` (`GENDER`),
  CONSTRAINT `FK27E3CB1A2F485A` FOREIGN KEY (`STATUS`) REFERENCES `base_dic` (`ID`),
  CONSTRAINT `FK27E3CB3F8E15ED` FOREIGN KEY (`USERTYPE`) REFERENCES `base_dic` (`ID`),
  CONSTRAINT `FK27E3CB4E76B29` FOREIGN KEY (`GENDER`) REFERENCES `base_dic` (`ID`),
  CONSTRAINT `FK27E3CB7740DFF2` FOREIGN KEY (`CERTYPE`) REFERENCES `base_dic` (`ID`),
  CONSTRAINT `FK_45jc6tmdcnuco3jexu8knkphn` FOREIGN KEY (`USERLOGIN`) REFERENCES `user_login` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of USER
-- ----------------------------
INSERT INTO `USER` VALUES ('402893555498a315015498c0b13c0004', null, null, null, null, null, null, null, null, null, null, '402893555498a315015498c0b0ce0003', null, null);

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
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKC672F9D5D4544503` (`LOGINSTATUS`),
  CONSTRAINT `FKC672F9D5D4544503` FOREIGN KEY (`LOGINSTATUS`) REFERENCES `base_dic` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of USER_LOGIN
-- ----------------------------
INSERT INTO `USER_LOGIN` VALUES ('4028935554989e7b015498a022970000', '2342', '4324', null, null, null, null, null, null);
INSERT INTO `USER_LOGIN` VALUES ('402893555498a315015498a36b480000', '234', '432423', null, null, null, null, null, null);
INSERT INTO `USER_LOGIN` VALUES ('402893555498a315015498a7502e0001', '234', '432423', null, null, null, null, null, null);
INSERT INTO `USER_LOGIN` VALUES ('402893555498a315015498c0b0ce0003', '11', '11', null, null, null, null, null, null);
