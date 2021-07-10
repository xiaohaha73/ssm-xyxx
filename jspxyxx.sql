/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : jspxyxx

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2021-04-17 09:25:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for banji
-- ----------------------------
DROP TABLE IF EXISTS `banji`;
CREATE TABLE `banji` (
  `bjid` int(11) NOT NULL auto_increment,
  `bj` varchar(40) default NULL COMMENT '班级',
  PRIMARY KEY  (`bjid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of banji
-- ----------------------------
INSERT INTO `banji` VALUES ('1', '计算机01班');
INSERT INTO `banji` VALUES ('2', '机械02班');

-- ----------------------------
-- Table structure for chengji
-- ----------------------------
DROP TABLE IF EXISTS `chengji`;
CREATE TABLE `chengji` (
  `cjid` int(11) NOT NULL auto_increment,
  `kc` varchar(40) default NULL COMMENT '课程',
  `xs` varchar(40) default NULL COMMENT '学生',
  `djsj` varchar(40) default NULL COMMENT '登记时间',
  `lx` varchar(40) default NULL COMMENT '类型',
  `cj` int(40) default NULL COMMENT '成绩',
  `lb` varchar(40) default NULL COMMENT '类别',
  PRIMARY KEY  (`cjid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of chengji
-- ----------------------------
INSERT INTO `chengji` VALUES ('1', '计算机原理', '123', '2021-03-06 12:28:10', '期末', '90', '及格');
INSERT INTO `chengji` VALUES ('2', '计算机原理', '123', '2021-03-06 14:00:30', '平时', '75', '及格');
INSERT INTO `chengji` VALUES ('3', '计算机原理', '333', '2021-03-06 14:18:39', '平时', '56', '及格');
INSERT INTO `chengji` VALUES ('4', '计算机原理', '333', '2021-03-06 14:18:44', '期末', '56', '及格');
INSERT INTO `chengji` VALUES ('8', '计算机原理', '123', '2021-04-15 21:06:57', '平时', '88', '及格');
INSERT INTO `chengji` VALUES ('9', '计算机原理', '123', '2021-04-15 21:06:58', '平时', '89', '及格');
INSERT INTO `chengji` VALUES ('10', '计算机原理', '123', '2021-04-15 21:06:58', '平时', '40', '不及格');

-- ----------------------------
-- Table structure for gly
-- ----------------------------
DROP TABLE IF EXISTS `gly`;
CREATE TABLE `gly` (
  `glyid` int(11) NOT NULL auto_increment,
  `yhm` varchar(40) default NULL COMMENT '用户名',
  `mm` varchar(40) default NULL COMMENT '密码',
  `xm` varchar(40) default NULL COMMENT '姓名',
  PRIMARY KEY  (`glyid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of gly
-- ----------------------------
INSERT INTO `gly` VALUES ('1', 'admin', 'admin', 'admin');

-- ----------------------------
-- Table structure for jiaoshi
-- ----------------------------
DROP TABLE IF EXISTS `jiaoshi`;
CREATE TABLE `jiaoshi` (
  `jsid` int(11) NOT NULL auto_increment,
  `yhm` varchar(40) default NULL COMMENT '用户名',
  `mm` varchar(40) default NULL COMMENT '密码',
  `xm` varchar(40) default NULL COMMENT '姓名',
  `lxdh` varchar(40) default NULL COMMENT '联系电话',
  `lxdz` varchar(40) default NULL COMMENT '联系地址',
  `xy` varchar(40) default NULL COMMENT '学院',
  PRIMARY KEY  (`jsid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jiaoshi
-- ----------------------------
INSERT INTO `jiaoshi` VALUES ('1', 'js', 'js', 'js', '120312300', '120310230', '计算机学院');
INSERT INTO `jiaoshi` VALUES ('2', 'js2', 'js2', 'js2', '123129391293', '129319239', '机械学院');

-- ----------------------------
-- Table structure for kcb
-- ----------------------------
DROP TABLE IF EXISTS `kcb`;
CREATE TABLE `kcb` (
  `kcbid` int(11) NOT NULL auto_increment,
  `kc` varchar(40) default NULL COMMENT '课程',
  `skdd` varchar(40) default NULL COMMENT '上课地点',
  `sksj` varchar(40) default NULL COMMENT '上课时间',
  `sm` varchar(4000) default NULL COMMENT '说明',
  `ks` varchar(40) default NULL,
  PRIMARY KEY  (`kcbid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of kcb
-- ----------------------------
INSERT INTO `kcb` VALUES ('1', '计算机原理', '阶梯教师', '周一 周三', '计算机专业', '15:00~16:30');
INSERT INTO `kcb` VALUES ('2', '数据库盖伦', '教室2020', '周三', '0120', '13:00~14:30');

-- ----------------------------
-- Table structure for kecheng
-- ----------------------------
DROP TABLE IF EXISTS `kecheng`;
CREATE TABLE `kecheng` (
  `kcid` int(11) NOT NULL auto_increment,
  `kcmc` varchar(40) default NULL COMMENT '课程名称',
  `js` varchar(4000) default NULL COMMENT '介绍',
  `fbjs` varchar(40) default NULL COMMENT '发布教师',
  `bl` varchar(40) default NULL,
  PRIMARY KEY  (`kcid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of kecheng
-- ----------------------------
INSERT INTO `kecheng` VALUES ('1', '计算机原理', '数据库盖伦数据库盖伦', 'js', '比例1');
INSERT INTO `kecheng` VALUES ('2', '软件工程', '数据库盖伦数据库盖伦', 'js', '比例2');
INSERT INTO `kecheng` VALUES ('3', '数据库盖伦', '数据库盖伦数据库盖伦', 'js', '比例1');

-- ----------------------------
-- Table structure for keshi
-- ----------------------------
DROP TABLE IF EXISTS `keshi`;
CREATE TABLE `keshi` (
  `ksid` int(11) NOT NULL auto_increment,
  `ks` varchar(40) default NULL COMMENT '课时',
  PRIMARY KEY  (`ksid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of keshi
-- ----------------------------
INSERT INTO `keshi` VALUES ('1', '8:00~9:30');
INSERT INTO `keshi` VALUES ('2', '10:00~11:30');
INSERT INTO `keshi` VALUES ('3', '13:00~14:30');
INSERT INTO `keshi` VALUES ('4', '15:00~16:30');

-- ----------------------------
-- Table structure for pfbl
-- ----------------------------
DROP TABLE IF EXISTS `pfbl`;
CREATE TABLE `pfbl` (
  `pfblid` int(11) NOT NULL auto_increment,
  `ps` varchar(40) default NULL COMMENT '平时',
  `qm` varchar(40) default NULL COMMENT '期末',
  `mc` varchar(40) default NULL,
  PRIMARY KEY  (`pfblid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of pfbl
-- ----------------------------
INSERT INTO `pfbl` VALUES ('1', '20', '80', '比例1');
INSERT INTO `pfbl` VALUES ('2', '30', '70', '比例2');

-- ----------------------------
-- Table structure for sksj
-- ----------------------------
DROP TABLE IF EXISTS `sksj`;
CREATE TABLE `sksj` (
  `sksjid` int(11) NOT NULL auto_increment,
  `kc` varchar(40) default NULL COMMENT '课程',
  `xq` varchar(40) default NULL COMMENT '星期',
  `j` varchar(40) default NULL COMMENT '节',
  PRIMARY KEY  (`sksjid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of sksj
-- ----------------------------
INSERT INTO `sksj` VALUES ('1', '计算机原理', '星期一', '8:00~9:30');
INSERT INTO `sksj` VALUES ('2', '软件工程', '星期一', '10:00~11:30');
INSERT INTO `sksj` VALUES ('3', '数据库盖伦', '星期一', '8:00~9:30');

-- ----------------------------
-- Table structure for xq
-- ----------------------------
DROP TABLE IF EXISTS `xq`;
CREATE TABLE `xq` (
  `xq` varchar(255) character set gb2312 default NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 COLLATE=gb2312_bin;

-- ----------------------------
-- Records of xq
-- ----------------------------
INSERT INTO `xq` VALUES ('星期一');
INSERT INTO `xq` VALUES ('星期二');
INSERT INTO `xq` VALUES ('星期三');
INSERT INTO `xq` VALUES ('星期四');
INSERT INTO `xq` VALUES ('星期五');
INSERT INTO `xq` VALUES ('星期六');
INSERT INTO `xq` VALUES ('星期日');

-- ----------------------------
-- Table structure for xuanke
-- ----------------------------
DROP TABLE IF EXISTS `xuanke`;
CREATE TABLE `xuanke` (
  `xkid` int(11) NOT NULL auto_increment,
  `kc` varchar(40) default NULL COMMENT '课程',
  `xs` varchar(40) default NULL COMMENT '学生',
  `xksj` varchar(40) default NULL COMMENT '选课时间',
  `zt` varchar(40) default NULL COMMENT '状态',
  PRIMARY KEY  (`xkid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xuanke
-- ----------------------------
INSERT INTO `xuanke` VALUES ('1', '计算机原理', '123', '2021-03-06 10:32:26', '选课');
INSERT INTO `xuanke` VALUES ('2', '计算机原理', '333', '2021-03-06 14:18:19', '选课');
INSERT INTO `xuanke` VALUES ('3', '软件工程', '123', '2021-04-15 18:34:20', '选课');

-- ----------------------------
-- Table structure for xuesheng
-- ----------------------------
DROP TABLE IF EXISTS `xuesheng`;
CREATE TABLE `xuesheng` (
  `xsid` int(11) NOT NULL auto_increment,
  `yhm` varchar(40) default NULL COMMENT '用户名',
  `mm` varchar(40) default NULL COMMENT '密码',
  `xm` varchar(40) default NULL COMMENT '姓名',
  `zy` varchar(40) default NULL COMMENT '专业',
  `xy` varchar(40) default NULL COMMENT '学院',
  `nl` varchar(40) default NULL COMMENT '年龄',
  `dh` varchar(40) default NULL COMMENT '电话',
  `bj` varchar(40) default NULL COMMENT '班级',
  PRIMARY KEY  (`xsid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xuesheng
-- ----------------------------
INSERT INTO `xuesheng` VALUES ('1', '123', '123', '123', '计算机', '计算机学院', '23', '1231232', '计算机01班');
INSERT INTO `xuesheng` VALUES ('2', '333', '333', '333', '123123', '123', '23', '123123123', '计算机01班');

-- ----------------------------
-- Table structure for zpcj
-- ----------------------------
DROP TABLE IF EXISTS `zpcj`;
CREATE TABLE `zpcj` (
  `zpcjid` int(11) NOT NULL auto_increment,
  `kc` varchar(40) default NULL COMMENT '课程',
  `xs` varchar(40) default NULL COMMENT '学生',
  `pscj` varchar(40) default NULL COMMENT '平时成绩',
  `qmcj` varchar(40) default NULL COMMENT '期末成绩',
  `zcj` varchar(40) default NULL COMMENT '总成绩',
  `djsj` varchar(40) default NULL COMMENT '登记时间',
  PRIMARY KEY  (`zpcjid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of zpcj
-- ----------------------------
INSERT INTO `zpcj` VALUES ('1', '计算机原理', '123', '73', '90', '86', '2021-04-17 09:24:45');
