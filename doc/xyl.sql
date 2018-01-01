/*
 Navicat Premium Data Transfer

 Source Server         : myc
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : xyl

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 01/01/2018 18:10:40 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Port`
-- ----------------------------
DROP TABLE IF EXISTS `Port`;
CREATE TABLE `Port` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `portNo` varchar(20) NOT NULL DEFAULT '' COMMENT '港口编号',
  `name` varchar(30) NOT NULL DEFAULT '' COMMENT '名称',
  `portType` tinyint(2) NOT NULL DEFAULT '0' COMMENT '港口类型 1：集装箱 2：其他',
  `company` varchar(50) NOT NULL DEFAULT '' COMMENT '所属公司',
  `longitude` int(11) NOT NULL DEFAULT '0' COMMENT '经度',
  `latitude` int(11) NOT NULL DEFAULT '0' COMMENT '纬度',
  `radius` int(11) NOT NULL DEFAULT '0' COMMENT '港口半径',
  `description` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL,
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标记  0：未删除  1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='港口';

SET FOREIGN_KEY_CHECKS = 1;
