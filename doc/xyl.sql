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
CREATE TABLE IF NOT EXISTS `Port` (
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
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标记  0：未删除  1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='港口';

CREATE TABLE IF NOT EXISTS `WaterLevel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '水位名称',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '水位',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态  1：启用  2：禁用',
  `description` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水位'

CREATE TABLE IF NOT EXISTS`DangerZone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `longitude` int(11) NOT NULL DEFAULT '0' COMMENT '经度',
  `latitude` int(11) NOT NULL DEFAULT '0' COMMENT '维度',
  `radius` int(11) NOT NULL DEFAULT '0' COMMENT '半径',
  `alarmDistance` int(11) NOT NULL DEFAULT '0' COMMENT '报警距离',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态  1：启用 2：禁用',
  `description` varchar(100) NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='危险区域'

CREATE TABLE IF NOT EXISTS`DangerZoneSpeed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `coordinate` varchar(512) NOT NULL DEFAULT '0' COMMENT '经纬度集合',
  `minSpeed` int(11) NOT NULL DEFAULT '0' COMMENT '最小速度',
  `maxSpeed` int(11) NOT NULL DEFAULT '0' COMMENT '最大速度',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态  1：启用 2：禁用',
  `description` varchar(100) NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='危险区域速度'

CREATE TABLE IF NOT EXISTS`Customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerNo` varchar(20) NOT NULL DEFAULT '' COMMENT '客户单位编号',
  `fullName` varchar(50) NOT NULL DEFAULT '' COMMENT '客户单位名称',
  `simpleName` varchar(50) NOT NULL DEFAULT '' COMMENT '单位简称',
  `contact` varchar(20) NOT NULL DEFAULT '' COMMENT '单位联系人',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '单位电话',
  `email` varchar(30) NOT NULL DEFAULT '' COMMENT '单位邮箱',
  `type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '客户类型  1：长期  2：临时',
  `goodsType` smallint(6) NOT NULL DEFAULT '0' COMMENT '货物分类  按位标识是否支持该类型，2字节存储  从第0位到8位使用，高位缺省，0位:熟料  1位:电煤  2位：集装箱  3~7位保留填0，8位：其他  0：未选中  1：选中',
  `contact1` varchar(20) NOT NULL DEFAULT '' COMMENT '联系人1',
  `title1` varchar(20) NOT NULL DEFAULT '' COMMENT '职务',
  `phone1` varchar(20) NOT NULL DEFAULT '' COMMENT '电话1',
  `weChat1` varchar(30) NOT NULL DEFAULT '' COMMENT '微信号1',
  `qq1` varchar(15) NOT NULL DEFAULT '' COMMENT 'qq号1',
  `email1` varchar(30) NOT NULL DEFAULT '' COMMENT '邮箱1',
  `contact2` varchar(20) NOT NULL DEFAULT '' COMMENT '联系人2',
  `title2` varchar(20) NOT NULL DEFAULT '' COMMENT '职务2',
  `phone2` varchar(20) NOT NULL DEFAULT '' COMMENT '电话2',
  `weChat2` varchar(30) NOT NULL DEFAULT '' COMMENT '微信号2',
  `qq2` varchar(15) NOT NULL DEFAULT '' COMMENT 'qq号2',
  `email2` varchar(30) NOT NULL DEFAULT '' COMMENT '邮箱2',
  `contact3` varchar(20) NOT NULL DEFAULT '' COMMENT '联系人3',
  `title3` varchar(20) NOT NULL DEFAULT '' COMMENT '职务3',
  `phone3` varchar(20) NOT NULL DEFAULT '' COMMENT '电话3',
  `weChat3` varchar(30) NOT NULL DEFAULT '' COMMENT '微信号3',
  `qq3` varchar(15) NOT NULL DEFAULT '' COMMENT 'qq号3',
  `email3` varchar(30) NOT NULL DEFAULT '' COMMENT '邮箱3',
  `description` varchar(100) NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户信息'

CREATE TABLE IF NOT EXISTS `Flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL DEFAULT '',
  `startFlow` int(11) NOT NULL DEFAULT '0' COMMENT '起始流向',
  `endFlow` int(11) NOT NULL DEFAULT '0' COMMENT '结束流向',
  `startPortId` int(11) NOT NULL DEFAULT '0' COMMENT '起始港口',
  `endPortId` int(11) NOT NULL DEFAULT '0' COMMENT '终点港口',
  `sailingArea` smallint(6) NOT NULL DEFAULT '0' COMMENT '航行区域 按位存储信息',
  `waterLevelPoint` smallint(6) NOT NULL DEFAULT '0' COMMENT '水位点',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态  1：启用  2：禁用',
  `description` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流向信息'

CREATE TABLE IF NOT EXISTS `Contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contractNo` varchar(50) NOT NULL DEFAULT '' COMMENT '合同编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '合同名称',
  `partyA` int(11) NOT NULL DEFAULT '0' COMMENT '合同甲方 从客户信息中选',
  `partyB` varchar(50) NOT NULL DEFAULT '' COMMENT '合同乙方',
  `validSDate` date NOT NULL DEFAULT '1970-01-01' COMMENT '合同有效期起始日期',
  `validEDate` date NOT NULL DEFAULT '1970-01-01' COMMENT '合同有效期截止日期',
  `deposit` int(11) NOT NULL DEFAULT '0' COMMENT '保证金',
  `depositDate` date NOT NULL DEFAULT '1970-01-01' COMMENT '保证金缴纳日期',
  `depositFinanceDate` date NOT NULL DEFAULT '1970-01-01' COMMENT '保证金交财务日期',
  `type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '合同类型  1：短期  2：长期',
  `signDepartment` int(11) NOT NULL DEFAULT '0' COMMENT '合同签订部门',
  `signPerson` int(11) NOT NULL DEFAULT '0' COMMENT '合同签订人员',
  `cheyun` int(11) NOT NULL DEFAULT '0' COMMENT '车运什么鬼？',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态 1：启用  2：禁用',
  `description` varchar(100) NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同信息'

CREATE TABLE IF NOT EXISTS `ContractFlow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contractId` int(11) NOT NULL DEFAULT '0' COMMENT '合同id',
  `flowId` int(11) NOT NULL DEFAULT '0' COMMENT '流向id',
  `unitPrice` int(11) NOT NULL DEFAULT '0' COMMENT '运价',
  `ticketStatus` tinyint(4) NOT NULL DEFAULT '0' COMMENT '开票与否  1：开  2：不开',
  `lastUnitPrice` int(11) NOT NULL DEFAULT '0' COMMENT '上期合同运价',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同流向'

CREATE TABLE IF NOT EXISTS `TransferPrice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL DEFAULT '0' COMMENT '客户id',
  `contractId` int(11) NOT NULL DEFAULT '0' COMMENT '合同id',
  `priceType` tinyint(2) NOT NULL DEFAULT '0' COMMENT '运价类型',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运价信息'

CREATE TABLE IF NOT EXISTS `TransferFlowPrice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transferPriceId` int(11) NOT NULL DEFAULT '0' COMMENT '运价信息id',
  `flowId` int(11) NOT NULL DEFAULT '0' COMMENT '流向编号',
  `unitPrice` int(11) NOT NULL DEFAULT '0' COMMENT '运价',
  `suggestUnitPrice` int(11) NOT NULL DEFAULT '0' COMMENT '参考运价',
  `startDate` date NOT NULL DEFAULT '1970-01-01' COMMENT '执行开始日期',
  `endDate` date NOT NULL DEFAULT '1970-01-01' COMMENT '执行结束日期',
  `creatorId` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运价流向信息'

SET FOREIGN_KEY_CHECKS = 1;
