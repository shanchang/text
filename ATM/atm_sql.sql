/*
Navicat MySQL Data Transfer

Source Server         : UML
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : atm_sql

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2015-05-27 16:49:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `accountId` varchar(12) NOT NULL,
  `customerKey` varchar(6) NOT NULL,
  `balance` decimal(10,2) NOT NULL,
  `state` int(1) NOT NULL,
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('111111111111', '111111', '96700.00', '1');
INSERT INTO `account` VALUES ('222222222222', '222222', '5000.00', '1');

-- ----------------------------
-- Table structure for consume
-- ----------------------------
DROP TABLE IF EXISTS `consume`;
CREATE TABLE `consume` (
  `consumerDate` datetime NOT NULL,
  `accountId` varchar(18) NOT NULL,
  `saveMoney` decimal(10,0) DEFAULT NULL,
  `getMoney` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`consumerDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consume
-- ----------------------------
INSERT INTO `consume` VALUES ('2015-05-27 07:38:27', '111111111111', '0', '300');
INSERT INTO `consume` VALUES ('2015-05-27 07:38:31', '111111111111', '0', '100');
INSERT INTO `consume` VALUES ('2015-05-27 07:39:05', '111111111111', '100', '0');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` varchar(18) NOT NULL,
  `customerName` varchar(12) NOT NULL,
  `accountId` varchar(12) NOT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('372928199511070011', '山昌', '111111111111');
INSERT INTO `customer` VALUES ('372928199511070012', '赵旭', '222222222222');
