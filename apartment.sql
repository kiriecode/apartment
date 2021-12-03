/*!40101 SET NAMES utf8 */;
/*!40101 SET SQL_MODE=''*/;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`apartment` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `apartment`;

-- 1.学生
/*Table structure for table `students` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
                           `name` char(10) NOT NULL COMMENT '姓名',
                           `gender` char(2) NOT NULL COMMENT '性别',
                           `birthday` char(15) NOT NULL COMMENT '出生日期',
                           `contact` char(11) NOT NULL COMMENT '联系方式',
                           `student_id` char(11) NOT NULL COMMENT '学号',
                           `college` char(20) NOT NULL COMMENT '学院',
                           `major` char(20) NOT NULL COMMENT '专业',
                           `classes` char(10) NOT NULL COMMENT '班级',
                           `building_id` char(10) NOT NULL COMMENT '楼号',
                           `dorm_id` char(10) NOT NULL COMMENT '宿舍号',
                           `bed_id` int(1) NOT NULL COMMENT '床号',
                           `status` smallint(1) NOT NULL DEFAULT '0' COMMENT '状态（0表示不在，1表示在）',
                           PRIMARY KEY (`student_id`),
                           UNIQUE KEY `UNIQUE` (`contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `student` VALUES ('樱木花道','男','76441876','15152245359','19110103024','计算机科学与技术学院','计算机科学与技术','计科1903','11', '518',1,0), ('赤木晴子','女','767761871','15512556259','20120101040','计算机科学与技术学院','计算机科学与技术','计科1902','2', '330',3,0), ('流川枫','男','767164856','18866956314','20110407122','车辆交通学院','车辆工程','车辆1902','Y1', '220',4,0), ('三井寿','男','767112271','15613516684','20110504011','数学学院','信息科学技术','信科2003','11', '208',2,0);

UPDATE `student` SET `gender` = '未知' WHERE student_id = '19110103024';
UPDATE `student` SET `status` = 1 WHERE student_id = '19110103024';

-- 2.宿管
/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
                           `name` char(20) NOT NULL COMMENT '姓名',
                           `manager_id` char(11) NOT NULL COMMENT '员工号',
                           `contact` char(11) NOT NULL COMMENT '联系方式',
                           PRIMARY KEY (`manager_id`),
                           UNIQUE KEY `UNIQUE` (`contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `manager` (`name`,`manager_id`,`contact`) VALUES ('王阿姨', '30120026375', '15059963163'), ('李叔叔', '30110521341', '19899251656');

-- 3.登录
/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
                            `identity` int(1) NOT NULL COMMENT '身份(1：学生，2：宿管，3：超级管理员)',
                            `account` char(11) NOT NULL COMMENT '账号',
                            `password` char(12) NOT NULL DEFAULT '000' COMMENT '密码',
                            PRIMARY KEY (`account`),
                            UNIQUE KEY `UNIQUE` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `register` VALUES (1, '19110103024', 123), (1, '20120101040', 123), (1, '20110407122', 123), (1, '20110504011', 123), (2, '30120026375', 123), (2, '30110521341', 123), (3, '123', 123);

-- 4.宿舍
/*Table structure for table `dorm` */

DROP TABLE IF EXISTS `dorm`;

CREATE TABLE `dorm` (
                        `name` char(20) NOT NULL COMMENT '宿舍名',
                        `building_id` char(10) DEFAULT NULL COMMENT '楼号（4/Y1...）',
                        `dorm_id` char(10) DEFAULT NULL COMMENT '宿舍号（311/209...）',
                        `bed_num` int(2) DEFAULT NULL COMMENT '床位数',
                        `people_num` int(2) DEFAULT NULL COMMENT '人数',
                        `deposit` double DEFAULT 0 NOT NULL COMMENT '宿舍费用'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dorm` VALUES ('百草园', '11', '518', 4, 4, 1000), ('三味书屋', '2', '330', 4, 3, 2000), ('幸福屋', 'Y1', '220', 6, 6, 2350), ('自习室', '11', '208', 4, 4, 2000);

SELECT * FROM `dorm` WHERE `building_id` = '11' AND `dorm_id` = '518';

-- 5.楼宇
/*Table structure for table `building` */

DROP TABLE IF EXISTS `building`;

CREATE TABLE `building` (
                            `name` char(20) NOT NULL COMMENT '楼宇名',
                            `building_id` char(10) NOT NULL COMMENT '楼宇号（4/Y1...）',
                            `address` char(30) DEFAULT NULL COMMENT '位置',
                            `manager_id` char(11) NOT NULL COMMENT '楼宇管理员号',
                            PRIMARY KEY (`building_id`),
                            UNIQUE KEY `UNIQUE` (`building_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `building` VALUES ('11号男生公寓', '11', '大学生艺术中心北50米', '30120026375'), ('2号女生公寓', '2', '第一餐厅东100米', '30120026375'), ('研究生1号男生公寓', 'Y1', '第二操场北35米', '30110521341');


-- 6.操作
/*Table structure for table `operation` */

DROP TABLE IF EXISTS `operation`;

CREATE TABLE `operation` (
                             `operation_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '操作号',
                             `account_id` char(11) NOT NULL COMMENT '用户id',
                             `type` int(1) NOT NULL COMMENT '（1：缴费，2：签入，3：签出）',
                             `payment_account` int(10) DEFAULT NULL COMMENT '缴费金额（如有）',
                             `date` datetime DEFAULT NULL COMMENT '操作日期',
                             PRIMARY KEY (`operation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `operation`(	`operation_id`, `account_id`, `type`, 	`payment_account`) VALUES (20001, '19110103024', 1, 200);
INSERT INTO `operation`(	`operation_id`, `account_id`, `type`) VALUES (20002, '19110103024', 2);
