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

 Date: 01/12/2018 00:24:49 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `AppUser`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `AppUser` (
  `id` int(11) NOT NULL,
  `userName` varchar(30) NOT NULL DEFAULT '' COMMENT '用户名',
  `nickName` varchar(30) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `userPass` varchar(40) NOT NULL,
  `shipInfoId` int(11) NOT NULL DEFAULT '0' COMMENT '临调船信息id',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='app用户基础信息';

-- ----------------------------
--  Table structure for `AppUserThirdParty`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `AppUserThirdParty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT 'app userId',
  `thirdType` tinyint(4) NOT NULL DEFAULT '0' COMMENT '三方类型   1:微信',
  `thirdId` varchar(50) NOT NULL DEFAULT '' COMMENT '三方唯一标识id 如微信的UnionId或openId',
  `thirdId2` varchar(50) NOT NULL DEFAULT '' COMMENT '冗余字段  微信中后续可能会有openId和unionId使用场景',
  `thirdName` varchar(50) NOT NULL DEFAULT '' COMMENT '三方昵称',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='App用户三方信息表';

-- ----------------------------
--  Table structure for `BigShipState`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `BigShipState` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerTaskFlowId` int(11) NOT NULL DEFAULT '0' COMMENT '客户任务流向id',
  `pch` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '批次号',
  `load` int(11) NOT NULL DEFAULT '0' COMMENT '总载量',
  `arriveLocation` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '到达位置',
  `arriveTime` int(11) NOT NULL DEFAULT '0' COMMENT '到达时间',
  `departTime` int(11) NOT NULL DEFAULT '0' COMMENT '离港时间',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态  1：启用  2：禁用',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  `description` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='大轮动态';

-- ----------------------------
--  Table structure for `Contract`
-- ----------------------------
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
  `cheyun` int(11) NOT NULL DEFAULT '0' COMMENT '车辆运费',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态 1：启用  2：禁用',
  `description` varchar(100) NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同信息';

-- ----------------------------
--  Table structure for `ContractFlow`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `ContractFlow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contractId` int(11) NOT NULL DEFAULT '0' COMMENT '合同id',
  `flowId` int(11) NOT NULL DEFAULT '0' COMMENT '流向id',
  `unitPrice` int(11) NOT NULL DEFAULT '0' COMMENT '运价',
  `ticketStatus` tinyint(4) NOT NULL DEFAULT '0' COMMENT '开票与否  1：开  2：不开',
  `lastUnitPrice` int(11) NOT NULL DEFAULT '0' COMMENT '上期合同运价',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同流向';

-- ----------------------------
--  Table structure for `Customer`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `Customer` (
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
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户信息';

-- ----------------------------
--  Table structure for `CustomerTask`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `CustomerTask` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL DEFAULT '0',
  `contractId` int(11) NOT NULL DEFAULT '0' COMMENT '合同id',
  `totalLoad` int(11) NOT NULL DEFAULT '0' COMMENT '总载重',
  `description` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='客户任务';

-- ----------------------------
--  Table structure for `CustomerTaskFlow`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `CustomerTaskFlow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taskId` int(11) NOT NULL DEFAULT '0' COMMENT '客户任务id',
  `flowId` int(11) NOT NULL DEFAULT '0' COMMENT '流向id',
  `goodsName` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '货物名称',
  `goodsType` tinyint(2) NOT NULL DEFAULT '0' COMMENT '货物类型  1：熟料  2：散装  3：集装箱',
  `totalWeight` int(11) NOT NULL DEFAULT '0' COMMENT '总吨位',
  `direction` varchar(20) COLLATE utf8_bin NOT NULL,
  `sender` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '发送方',
  `receiver` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '收货单位',
  `loadingDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '装货日期',
  `dischargeDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '卸货日期',
  `startPortId` int(11) NOT NULL DEFAULT '0' COMMENT '装货港口',
  `endPortId` int(11) NOT NULL DEFAULT '0' COMMENT '卸货港口id',
  `loadType` tinyint(2) NOT NULL DEFAULT '0' COMMENT '装货途径  1：大轮  2：场地',
  `bigShipPC` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '大轮批次',
  `totalLoad` int(11) NOT NULL DEFAULT '0' COMMENT '总载重',
  `arriveLocation` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '到达位置',
  `bigShipArriveTime` int(11) NOT NULL DEFAULT '0' COMMENT '大轮预计达到时间',
  `bigShipDepartTime` int(11) NOT NULL DEFAULT '0' COMMENT '大轮预计离开时间',
  `selfPick` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否自提  1：是 2：否',
  `sailingArea` smallint(6) NOT NULL DEFAULT '0' COMMENT '航行区域',
  `shipSuggestUnitPrice` int(10) NOT NULL DEFAULT '0' COMMENT '船户参考运价',
  `sailingFlag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '航次标识  1：正常  2：散装回程货  3：安吉货',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态 1：启用  2：禁用',
  `description` varchar(100) COLLATE utf8_bin NOT NULL,
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '1',
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='客户任务流向';

-- ----------------------------
--  Table structure for `DangerZone`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `DangerZone` (
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
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='危险区域';

-- ----------------------------
--  Table structure for `DangerZoneSpeed`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `DangerZoneSpeed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `coordinate` varchar(512) NOT NULL DEFAULT '0' COMMENT '经纬度集合',
  `minSpeed` int(11) NOT NULL DEFAULT '0' COMMENT '最小速度',
  `maxSpeed` int(11) NOT NULL DEFAULT '0' COMMENT '最大速度',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态  1：启用 2：禁用',
  `description` varchar(100) NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='危险区域速度';

-- ----------------------------
--  Table structure for `DispatchInfo`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `DispatchInfo` (
  `int` int(11) NOT NULL AUTO_INCREMENT,
  `customerTaksFlowId` int(11) NOT NULL DEFAULT '0' COMMENT '客户任务流向ID',
  `orderNo` varchar(30) NOT NULL DEFAULT '' COMMENT '订单自定义编号',
  `dispatchType` tinyint(4) NOT NULL DEFAULT '0' COMMENT '调度方式',
  `shipId` int(11) NOT NULL DEFAULT '0' COMMENT '船舶id',
  `shipType` tinyint(3) NOT NULL DEFAULT '0' COMMENT '船舶类型  1：自由 2：挂靠  3：临调',
  `preWeight` int(11) NOT NULL DEFAULT '0' COMMENT '预报吨位',
  `preLoad` int(11) NOT NULL DEFAULT '0' COMMENT '预发吨位',
  `preArriveTime` int(11) NOT NULL DEFAULT '0' COMMENT '预计到港时间',
  `preSettleAmount` double NOT NULL DEFAULT '0' COMMENT '预结算金额',
  `settleType` tinyint(3) NOT NULL DEFAULT '0' COMMENT '结算方式  1：按实发吨位  2：按实收吨位   11：现金结算  12：定期结算',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`int`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调度单';

-- ----------------------------
--  Table structure for `Flow`
-- ----------------------------
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
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流向信息';

-- ----------------------------
--  Table structure for `LeftDispatchInfo`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `LeftDispatchInfo` (
  `int` int(11) NOT NULL AUTO_INCREMENT,
  `customerTaksFlowId` int(11) NOT NULL DEFAULT '0' COMMENT '客户任务流向ID',
  `dispatchWeight` int(11) NOT NULL DEFAULT '0' COMMENT '调度吨位',
  `bookSDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '预约抢单有效开始日期',
  `bookEDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '预约抢单有效截止日期',
  `specialTip` varchar(100) NOT NULL DEFAULT '' COMMENT '特殊要求',
  `minShipWeight` int(11) NOT NULL DEFAULT '0' COMMENT '最小船舶吨位',
  `maxShipWeight` int(11) NOT NULL DEFAULT '0' COMMENT '最大船舶吨位',
  `waterLevel` float NOT NULL DEFAULT '0' COMMENT '水位',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '发布状态  1：待发布  2：已发布  3：已取消',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(4) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`int`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='余量临调信息';

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
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标记  0：未删除  1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='港口';

-- ----------------------------
--  Table structure for `Reservation`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `Reservation` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `shipLongitude` int(11) NOT NULL DEFAULT '0' COMMENT '船舶经度',
  `shipLatitude` int(11) NOT NULL DEFAULT '0' COMMENT '船舶维度',
  `preLoad` int(11) NOT NULL DEFAULT '0' COMMENT '预报吨位',
  `preArrivePortTime` int(11) NOT NULL DEFAULT '0' COMMENT '预计到达港口时间',
  `shipEmptyPhoto` varchar(50) NOT NULL DEFAULT '' COMMENT '空船照片',
  `shipReference` varchar(50) NOT NULL DEFAULT '' COMMENT '参照物照片',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约信息';

-- ----------------------------
--  Table structure for `SailingInfo`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `SailingInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shipId` int(11) NOT NULL DEFAULT '0' COMMENT '船id',
  `orderId` int(11) NOT NULL DEFAULT '0' COMMENT '订单id',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '航次信息类型  1：空船到港  2：空船装后  3:重船到港  4：重船卸后  5：重船离港',
  `arriveSPortTime` int(11) NOT NULL DEFAULT '0' COMMENT '实际到装货港时间',
  `loadTime` int(11) NOT NULL DEFAULT '0' COMMENT '实际装货时间',
  `loadWeight` int(11) NOT NULL DEFAULT '0' COMMENT '装货吨位',
  `preArriveEPortTime` int(11) NOT NULL DEFAULT '0' COMMENT '预计到卸货港时间',
  `actualArriveEPortTime` int(11) NOT NULL DEFAULT '0' COMMENT '实际到达卸货港时间',
  `dischargeTime` int(11) NOT NULL DEFAULT '0' COMMENT '实际卸货时间',
  `dischargeWeight` int(11) NOT NULL DEFAULT '0' COMMENT '实际卸货重量',
  `dischargeDelayFee` float NOT NULL DEFAULT '0' COMMENT '卸货延迟费用',
  `allowance` float NOT NULL DEFAULT '0' COMMENT '异常补助',
  `description` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='航次信息';

-- ----------------------------
--  Table structure for `Ship`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `Ship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shipNo` varchar(30) NOT NULL DEFAULT '' COMMENT '船号',
  `shipFlag` tinyint(3) NOT NULL DEFAULT '0' COMMENT '船舶类型  1：自由船舶  2：挂靠船舶',
  `shipType` tinyint(3) NOT NULL DEFAULT '0' COMMENT '船舶类型 1：干货船   2：多用途船',
  `length` float NOT NULL DEFAULT '0' COMMENT '船长',
  `width` float NOT NULL DEFAULT '0' COMMENT '船宽',
  `depth` float NOT NULL DEFAULT '0' COMMENT '船深',
  `totalWeight` int(11) NOT NULL DEFAULT '0' COMMENT '总吨位',
  `netWeight` int(11) NOT NULL DEFAULT '0' COMMENT '净重',
  `loadWeight` int(11) NOT NULL DEFAULT '0' COMMENT '载重吨位',
  `feeWeight` int(11) NOT NULL DEFAULT '0' COMMENT '计费吨位',
  `levelAWeight` int(11) NOT NULL DEFAULT '0' COMMENT 'A级吨位',
  `levelBWeight` int(11) NOT NULL DEFAULT '0' COMMENT 'B级吨位',
  `levelCWeight` int(11) NOT NULL DEFAULT '0' COMMENT 'C级吨位',
  `buildDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '建成日期',
  `customerId` int(11) NOT NULL DEFAULT '0' COMMENT '船舶所属单位',
  `checkRegisterNo` varchar(30) NOT NULL DEFAULT '' COMMENT '船检登记号',
  `checkNo` varchar(30) NOT NULL DEFAULT '' COMMENT '船检编号',
  `shipID` varchar(30) NOT NULL DEFAULT '' COMMENT '船舶识别码',
  `sailingAreaA` varchar(30) NOT NULL DEFAULT '' COMMENT 'A级航区',
  `sailingAreaB` varchar(30) NOT NULL DEFAULT '' COMMENT 'B级航区',
  `sailingAreaC` varchar(30) NOT NULL DEFAULT '' COMMENT 'C级航区',
  `firstRegisterNo` varchar(30) NOT NULL DEFAULT '' COMMENT '初次登记号',
  `sailingDepth` int(11) NOT NULL DEFAULT '0' COMMENT '航深',
  `buildFactory` varchar(30) NOT NULL DEFAULT '' COMMENT '制造厂家',
  `aisID` varchar(30) NOT NULL DEFAULT '' COMMENT 'AIS识别码',
  `gpsDeviceId` varchar(20) NOT NULL DEFAULT '' COMMENT 'GPS设备编号',
  `oldShipName` varchar(30) NOT NULL DEFAULT '' COMMENT '原船名',
  `runType` tinyint(3) NOT NULL DEFAULT '0' COMMENT '营运类型  1：集散两用  2：集装箱  3：砂石  99：其他',
  `rebuildDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '改建日期',
  `insuranceDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '保险日期',
  `checkDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '检验日期',
  `repairDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '维修日期',
  `description` varchar(100) NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='船舶';

-- ----------------------------
--  Table structure for `ShipCurrentGps`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `ShipCurrentGps` (
  `id` int(11) NOT NULL,
  `shipNo` varchar(255) NOT NULL DEFAULT '' COMMENT '船号',
  `devId` varchar(255) NOT NULL DEFAULT '' COMMENT '设备id',
  `longitude` int(11) NOT NULL DEFAULT '0' COMMENT '经度',
  `latitude` int(11) NOT NULL DEFAULT '0' COMMENT '维度',
  `gpsTime` varchar(20) NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'gps时间',
  `speed` int(11) NOT NULL DEFAULT '0' COMMENT '速度',
  `angle` int(11) NOT NULL DEFAULT '0' COMMENT '角度',
  `alarmType` tinyint(4) NOT NULL DEFAULT '0' COMMENT '报警类型',
  `areaId` int(11) NOT NULL DEFAULT '0' COMMENT '区域/航道id',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `ShipEvent`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `ShipEvent` (
  `int` int(11) NOT NULL AUTO_INCREMENT,
  `shipId` int(11) NOT NULL DEFAULT '0',
  `eventId` tinyint(4) NOT NULL DEFAULT '0' COMMENT '事件类型 1：正常   2：停驶   3：不适航  ',
  `description` varchar(100) NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL,
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL,
  PRIMARY KEY (`int`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `ShipStaff`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `ShipStaff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `mobile` varchar(15) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '手机号',
  `gender` tinyint(2) NOT NULL DEFAULT '0' COMMENT '性别 1：男  2：女',
  `identity` varchar(18) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '身份证号',
  `birthday` date NOT NULL DEFAULT '1900-01-01' COMMENT '生日',
  `residence` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '户籍',
  `shipId` int(11) NOT NULL DEFAULT '0' COMMENT '所属',
  `title` tinyint(2) NOT NULL DEFAULT '0' COMMENT '岗位  1：船长  2：驾驶员  3：轮机员  4：水手',
  `isOwner` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否承包人  1：是  2：否',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态  1：启用  2：禁用',
  `description` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='船舶人员';

-- ----------------------------
--  Table structure for `TempDispatchShip`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `TempDispatchShip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shipNo` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '船号',
  `name` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `mobile` varchar(15) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '手机号',
  `preLoad` int(11) NOT NULL DEFAULT '0' COMMENT '预报吨位',
  `identity` varchar(18) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '身份证号',
  `bankCardNo` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '银行卡号',
  `bankName` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '银行名称',
  `idPhoto` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '身份证照片',
  `bankCardPhoto` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '银行照片',
  `shipPhoto` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '船舶照片',
  `from` tinyint(2) NOT NULL DEFAULT '0' COMMENT '信息来源  1：后台新增  2:APP新增',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态  1：启用  2：禁用',
  `description` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='临调船舶信息';

-- ----------------------------
--  Table structure for `TransferFlowPrice`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `TransferFlowPrice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transferPriceId` int(11) NOT NULL DEFAULT '0' COMMENT '运价信息id',
  `flowId` int(11) NOT NULL DEFAULT '0' COMMENT '流向编号',
  `unitPrice` int(11) NOT NULL DEFAULT '0' COMMENT '运价',
  `suggestUnitPrice` int(11) NOT NULL DEFAULT '0' COMMENT '参考运价',
  `startDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '执行开始日期',
  `endDate` date NOT NULL DEFAULT '1900-01-01' COMMENT '执行结束日期',
  `creatorId` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL,
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运价流向信息';

-- ----------------------------
--  Table structure for `TransferPrice`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `TransferPrice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL DEFAULT '0' COMMENT '客户id',
  `contractId` int(11) NOT NULL DEFAULT '0' COMMENT '合同id',
  `priceType` tinyint(2) NOT NULL DEFAULT '0' COMMENT '运价类型',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运价信息';

-- ----------------------------
--  Table structure for `WaterLevel`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `WaterLevel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '水位名称',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '水位',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态  1：启用  2：禁用',
  `description` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `creator` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updater` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水位';

SET FOREIGN_KEY_CHECKS = 1;
