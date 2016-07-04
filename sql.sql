-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.24-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;


-- 导出  表 test.attention 结构
CREATE TABLE IF NOT EXISTS `attention` (
  `username` varchar(50) NOT NULL,
  `othername` varchar(50) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  test.attention 的数据：~2 rows (大约)
DELETE FROM `attention`;
/*!40000 ALTER TABLE `attention` DISABLE KEYS */;
INSERT INTO `attention` (`username`, `othername`, `state`, `id`) VALUES
	('123', '321', 1, 1),
	('321', '123', 1, 3);
/*!40000 ALTER TABLE `attention` ENABLE KEYS */;


-- 导出  表 test.comment 结构
CREATE TABLE IF NOT EXISTS `comment` (
  `talktalk_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `textarea` varchar(250) NOT NULL,
  `time` varchar(100) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.comment 的数据：~1 rows (大约)
DELETE FROM `comment`;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`talktalk_id`, `username`, `textarea`, `time`, `id`) VALUES
	(1, '123', 'grffsfsfdsfsd', '2016-7-2 14:38', 1);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


-- 导出  表 test.talktalk 结构
CREATE TABLE IF NOT EXISTS `talktalk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL,
  `textarea` varchar(250) NOT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `time` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 正在导出表  test.talktalk 的数据：~5 rows (大约)
DELETE FROM `talktalk`;
/*!40000 ALTER TABLE `talktalk` DISABLE KEYS */;
INSERT INTO `talktalk` (`id`, `account`, `textarea`, `picture`, `time`) VALUES
	(1, '123', 'fgdfgd', 'F://1.png', '2016-07-22 11:38'),
	(2, '123', 'dsdsa', NULL, '2016-7-22 11:38'),
	(3, '321', 'fwefwefwefwe', NULL, '2016-7-2 21:35'),
	(4, '444', 'fsdfsdf', NULL, '2016-7-2 21:33'),
	(5, '321', '2432424', NULL, '2016-07-03 02:58'),
	(6, '321', '2432424', NULL, '2016-07-03 03:01'),
	(7, '321', '2432424', NULL, '2016-07-03 03:05'),
	(8, '321', '2432424', NULL, '2016-07-03 03:09'),
	(9, '321', 'gdfgd4', NULL, '2016-07-03 03:12'),
	(10, '321', 'gdfgd4', NULL, '2016-07-03 03:56'),
	(11, '444', 'sdadsad', 'F:\\hello7\\14675342190941.png', '2016-07-03 04:23'),
	(12, '444', 'sdadsad', 'F:\\hello7\\14675342627291.png', '2016-07-03 04:24'),
	(13, '444', 'sdadsad', 'F:\\hello7\\14675343257201.png', '2016-07-03 04:25'),
	(14, '444', 'sdadsad', 'F:\\hello7\\14675373096671.png', '2016-07-03 05:15'),
	(15, '444', 'sdadsad', 'F:\\hello7\\14675416493481.png', '2016-07-03 06:27'),
	(16, '444', 'sdadsad', 'F:\\hello7\\14675416655071.png', '2016-07-03 06:27');
/*!40000 ALTER TABLE `talktalk` ENABLE KEYS */;


-- 导出  表 test.username 结构
CREATE TABLE IF NOT EXISTS `username` (
  `id` varchar(50) NOT NULL,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  test.username 的数据：~4 rows (大约)
DELETE FROM `username`;
/*!40000 ALTER TABLE `username` DISABLE KEYS */;
INSERT INTO `username` (`id`, `account`, `password`) VALUES
	('111', 'zhengruitian', '112116'),
	('222', '123', '123'),
	('333', '321', '321'),
	('444', '444', '444');
/*!40000 ALTER TABLE `username` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
