/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : JSG_ZYGL

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-08-10 10:18:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ALLOWANCE`
-- ----------------------------
DROP TABLE IF EXISTS `ALLOWANCE`;
CREATE TABLE `ALLOWANCE` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `FOOD` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '饭补助',
  `COMPUTER` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电脑补助',
  `TRAFFIC` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '交通补助',
  `HOUSING` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '住房补助',
  `OTHER_DAY` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '其它补助每天',
  `OTHER_MOUTH` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '其它补助每月',
  `CUSTOMER` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '客户信息',
  `PARAM1` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PARAM2` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PARAM3` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ALLOWANCE
-- ----------------------------


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
INSERT INTO `BASE_DIC` VALUES ('40288f5c556cf84601556cfddefc0000', '启用', 'ENABLE', '1', '40288f5c556c9fce01556cf40dc40000', '1', '2016-06-20 16:47:04', '2016-06-20 16:47:04');
INSERT INTO `BASE_DIC` VALUES ('40288f5c556cf84601556cff0a570001', '禁用', 'DISABLE', '2', '40288f5c556c9fce01556cf40dc40000', '1', '2016-06-20 16:48:21', '2016-06-20 16:48:21');
INSERT INTO `BASE_DIC` VALUES ('40288f5c5576097b0155762d31550001', '身份证', 'ID_CARD', '1', '40288f5c5576097b0155762cb1780000', '1', '2016-06-22 11:35:21', '2016-06-22 11:35:21');
INSERT INTO `BASE_DIC` VALUES ('40288f5c5576097b0155762d6b3f0002', '军官证', 'SOLDIERS_CARD', '2', '40288f5c5576097b0155762cb1780000', '1', '2016-06-22 11:35:35', '2016-06-22 11:35:35');
INSERT INTO `BASE_DIC` VALUES ('40288f5c55b4a8190155b4ab09d20001', '是', 'YES', '1', '40288f5c55b4a8190155b4aad1c10000', '1', '2016-07-04 14:49:15', '2016-07-04 14:49:15');
INSERT INTO `BASE_DIC` VALUES ('40288f5c55b4a8190155b4ab360c0002', '否', 'NO', '2', '40288f5c55b4a8190155b4aad1c10000', '1', '2016-07-04 14:49:27', '2016-07-04 14:49:27');
INSERT INTO `BASE_DIC` VALUES ('40288f5c55c329a30155c32e11690002', '农业', 'FARMING', '1', '40288f5c55c329a30155c32cdd680001', '1', '2016-07-07 10:27:04', '2016-07-07 10:27:04');
INSERT INTO `BASE_DIC` VALUES ('40288f5c55c329a30155c32e5cc60003', '城镇', 'CITY', '2', '40288f5c55c329a30155c32cdd680001', '1', '2016-07-07 10:27:23', '2016-07-07 10:27:23');
INSERT INTO `BASE_DIC` VALUES ('40288f5c55c329a30155c32f3c2b0004', '开发一部', 'DEVL_ONE', '1', '40288f5c55c329a30155c32ca2af0000', '1', '2016-07-07 10:28:20', '2016-07-07 10:28:20');
INSERT INTO `BASE_DIC` VALUES ('40288f5c55c329a30155c32f80ff0005', '开发二部', 'DEVL_TWO', '2', '40288f5c55c329a30155c32ca2af0000', '1', '2016-07-07 10:28:38', '2016-07-07 10:28:38');
INSERT INTO `BASE_DIC` VALUES ('40288f73552e84a101552e85ce9a0000', '女', 'WOMEN', '2', '4028932d550043d10155004530330000', '1', '2016-06-08 13:39:29', '2016-06-20 15:16:44');
INSERT INTO `BASE_DIC` VALUES ('40288f775528bea0015528c016ab0000', '男', 'WEN', '1', '4028932d550043d10155004530330000', '1', '2016-06-07 10:45:25', '2016-06-20 15:16:52');

-- ----------------------------
-- Table structure for `CUSTOMER`
-- ----------------------------
DROP TABLE IF EXISTS `CUSTOMER`;
CREATE TABLE `CUSTOMER` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `CODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '客户编码',
  `OVERTIME_MONEY` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '加班费',
  `IS_MEAL_SUPPLEMENT` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否有餐补',
  `WORK_DAYS` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '月平均工作日天数',
  `NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '客户名称',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `COMMENTS` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of CUSTOMER
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
INSERT INTO `DIC_CATEGORY` VALUES ('40288f5c556c9fce01556cf40dc40000', '状态', 'STATUS', null, null, '2016-06-20 16:36:21', '2016-06-20 16:36:21', ' ');
INSERT INTO `DIC_CATEGORY` VALUES ('40288f5c5576097b0155762cb1780000', '证件类型', 'CARDTYPE', null, null, '2016-06-22 11:34:48', '2016-06-22 11:34:48', ' ');
INSERT INTO `DIC_CATEGORY` VALUES ('40288f5c55b4a8190155b4aad1c10000', '是否', 'Y_N', null, null, '2016-07-04 14:49:01', '2016-07-04 14:49:01', ' ');
INSERT INTO `DIC_CATEGORY` VALUES ('40288f5c55c329a30155c32ca2af0000', '部门', 'DEPARTMENT', null, null, '2016-07-07 10:25:30', '2016-07-07 10:25:30', ' ');
INSERT INTO `DIC_CATEGORY` VALUES ('40288f5c55c329a30155c32cdd680001', '户口性质', 'REGISTER', null, null, '2016-07-07 10:25:45', '2016-07-07 10:25:45', ' ');
INSERT INTO `DIC_CATEGORY` VALUES ('4028932d550043d10155004530330000', '性别', 'GENDER', null, null, '2016-05-30 14:06:22', '2016-05-30 14:06:22', null);

-- ----------------------------
-- Table structure for `EMPLOYEE`
-- ----------------------------
DROP TABLE IF EXISTS `EMPLOYEE`;
CREATE TABLE `EMPLOYEE` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `EMPLOYEE_NAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工姓名',
  `EMPLOYEE_CODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `DEPT` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所属部门',
  `CUSTOMER` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所在客户',
  `EMAIL` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `PROBATION` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '试用期工资',
  `SALARY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '基本工资',
  `PROBATION_STATE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '试用期是否全薪',
  `IS_JOB` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否在职',
  `ENTRY_TIME` datetime DEFAULT NULL COMMENT '入职日期',
  `QUIT_TIME` datetime DEFAULT NULL COMMENT '离职日期',
  `REGISTER` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '户口性质',
  `CREATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_FULL_MEMBER` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否转正',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of EMPLOYEE
-- ----------------------------


-- ----------------------------
-- Table structure for `EMPLOYEE_SALARY`
-- ----------------------------
DROP TABLE IF EXISTS `EMPLOYEE_SALARY`;
CREATE TABLE `EMPLOYEE_SALARY` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `EMPLOYEE_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工ID',
  `SALARY_DATE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '薪资年月',
  `ADJUSTMENT` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上月调整',
  `ALLOWANCE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '岗位津贴',
  `OTHER` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '其他代扣款',
  `REWARD_ITEMS` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '奖金内容',
  `REWARD_AMOUNT` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '奖金金额',
  `REWARD_TIME` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '奖金时间',
  `RESIGN_MONEY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '离职补偿金',
  `PUNISH` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '罚款',
  `IS_FULL_TIME` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否全勤',
  `FULL_TIME` int(11) DEFAULT NULL COMMENT '应出勤天数',
  `OVERTIME` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '加班小时数',
  `IS_FIXED` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否固定加班费',
  `IS_SELF` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否公积金自缴',
  `FUND_MONEY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公积金缴纳金额',
  `IS_COMPUTER` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否有电脑补助',
  `PERSONAL_LEAVE` int(32) DEFAULT '0' COMMENT '事假小时数',
  `TRYPERSONAL_LEAVE` int(32) DEFAULT NULL COMMENT '试用期事假',
  `PERSONAL_REMARK` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '事假说明',
  `ANNUAL_LEAVE` int(11) DEFAULT '0' COMMENT '年假天数',
  `ANNUAL_REMARK` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '年假说明',
  `TRYSICK_LEAVE` int(11) DEFAULT NULL COMMENT '试用期病假',
  `SICK_LEAVE` int(11) DEFAULT '0' COMMENT '病假天数',
  `SICK_REMARK` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '病假说明',
  `MARRIAGE_LEAVE` int(11) DEFAULT '0' COMMENT '婚假天数',
  `MARRIAGE_REMARK` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '婚假说明',
  `MATERNITY_LEAVE` int(11) DEFAULT '0' COMMENT '产假天数',
  `MATERNITY_REMARK` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产假说明',
  `FUNERAL_LEAVE` int(11) DEFAULT '0' COMMENT '丧假天数',
  `FUNERAL_REMARK` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '丧假说明',
  `CREATOR` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of EMPLOYEE_SALARY
-- ----------------------------


-- ----------------------------
-- Table structure for `SALARY_RESULT`
-- ----------------------------
DROP TABLE IF EXISTS `SALARY_RESULT`;
CREATE TABLE `SALARY_RESULT` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `EMPLOYEE_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工ID',
  `SALARY_DATE` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '薪资年月',
  `ABSENCE_DAY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '缺勤天数',
  `ABSENCE_MONEY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '缺勤扣款',
  `OVERTIME_MONEY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '加班费及补助',
  `ATTENDANCE_MONEY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '出勤工资',
  `PROMOTION` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '转正工资调整',
  `REWARD` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '奖金',
  `ALLOWANCE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '岗位津贴',
  `MEAL_SUPPLEMENT` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '餐补',
  `COMPUTER_SUPPLEMENT` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电脑补助',
  `ADJUSTMENT` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上月调整',
  `COMPENSATE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '离职补偿金',
  `SUM` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工资及补贴总额',
  `SOCIAL_SECURITY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '社保',
  `FUND_MONEY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公积金',
  `PUNISH` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '罚款',
  `OTHER` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '代扣款',
  `TAX` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '个税',
  `FINNAL_MONEY` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '实发工资',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of SALARY_RESULT
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

INSERT INTO `USER` VALUES ('402893555498a315015498c0b13c0004', '11', '130922199102138767', '', '', '', '', '40288f775528bea0015528c016ab0000', '40288f5c5576097b0155762d31550001', '40288f5c556cf84601556cfddefc0000', null, '40288f5c557c40f001557c44b08b0001', null, '2016-06-30 15:13:24');

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

INSERT INTO `USER_LOGIN` VALUES ('40288f5c557c40f001557c44b08b0001', '11', '25d55ad283aa400af464c76d713c07ad', null, null, null, null, null, null);

