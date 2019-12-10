-- --------------------------------------------------------
-- 主机:                           192.168.95.128
-- Server version:               5.7.24 - MySQL Community Server (GPL)
-- Server OS:                    Linux
-- HeidiSQL 版本:                  10.0.0.5460
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for fvblog
CREATE DATABASE IF NOT EXISTS `fvblog` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `fvblog`;

-- Dumping structure for table fvblog.blog
CREATE TABLE IF NOT EXISTS `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `create_Time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_Time` timestamp NULL DEFAULT NULL,
  `author_Id` int(11) DEFAULT NULL,
  `content` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200004 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table fvblog.blog: ~199,193 rows (approximately)
DELETE FROM `blog`;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` (`id`, `title`, `create_Time`, `update_Time`, `author_Id`, `content`) VALUES
	(1, 'first blog', NULL, NULL, 1, 'first content of blog'),
	(2, 'first blog', '2019-01-25 16:57:13', NULL, 1, 'first content of blog'),
	(3, '0first blog', '2019-01-25 17:00:57', NULL, 0, '0first content of blog'),
	(4, '1first blog', '2019-01-25 17:00:57', NULL, 1, '1first content of blog'),
	(5, '2first blog', '2019-01-25 17:00:57', NULL, 2, '2first content of blog'),
	(6, '3first blog', '2019-01-25 17:00:57', NULL, 3, '3first content of blog'),
	(7, '4first blog', '2019-01-25 17:00:57', NULL, 4, '4first content of blog'),
	(8, '5first blog', '2019-01-25 17:00:57', NULL, 5, '5first content of blog'),
	(9, '6first blog', '2019-01-25 17:00:57', NULL, 6, '6first content of blog'),
	(10, '7first blog', '2019-01-25 17:00:57', NULL, 7, '7first content of blog'),
	(11, '8first blog', '2019-01-25 17:00:57', NULL, 8, '8first content of blog'),
	(12, '9first blog', '2019-01-25 17:00:57', NULL, 9, '9first content of blog'),
	(13, '10first blog', '2019-01-25 17:00:57', NULL, 10, '10first content of blog'),
	(14, '11first blog', '2019-01-25 17:00:57', NULL, 11, '11first content of blog'),
	(15, '12first blog', '2019-01-25 17:00:57', NULL, 12, '12first content of blog'),
	(16, '13first blog', '2019-01-25 17:00:57', NULL, 13, '13first content of blog'),
	(17, '14first blog', '2019-01-25 17:00:57', NULL, 14, '14first content of blog'),
	(18, '15first blog', '2019-01-25 17:00:57', NULL, 15, '15first content of blog'),
	(19, '16first blog', '2019-01-25 17:00:57', NULL, 16, '16first content of blog'),
	(20, '17first blog', '2019-01-25 17:00:57', NULL, 17, '17first content of blog');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;

-- Dumping structure for table fvblog.city
CREATE TABLE IF NOT EXISTS `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='市级信息';

-- Dumping data for table fvblog.city: ~2 rows (approximately)
DELETE FROM `city`;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`id`, `name`, `state`) VALUES
	(1, '石家庄', '河北'),
	(2, '邯郸', '河北');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;

-- Dumping structure for table fvblog.country
CREATE TABLE IF NOT EXISTS `country` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `country_name` varchar(255) DEFAULT NULL COMMENT '名称',
  `country_code` varchar(255) DEFAULT NULL COMMENT '代码',
  `age` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8 COMMENT='国家信息';

-- Dumping data for table fvblog.country: ~183 rows (approximately)
DELETE FROM `country`;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`Id`, `country_name`, `country_code`, `age`) VALUES
	(1, 'Angola', 'AO', NULL),
	(2, 'Afghanistan', 'AF', NULL),
	(3, 'Albania', 'AL', NULL),
	(4, 'Algeria', 'DZ', NULL),
	(5, 'Andorra', 'AD', NULL),
	(6, 'Anguilla', 'AI', NULL),
	(7, 'Antigua and Barbuda', 'AG', NULL),
	(8, 'Argentina', 'AR', NULL),
	(9, 'Armenia', 'AM', NULL),
	(10, 'Australia', 'AU', NULL),
	(11, 'Austria', 'AT', NULL),
	(12, 'Azerbaijan', 'AZ', NULL),
	(13, 'Bahamas', 'BS', NULL),
	(14, 'Bahrain', 'BH', NULL),
	(15, 'Bangladesh', 'BD', NULL),
	(16, 'Barbados', 'BB', NULL),
	(17, 'Belarus', 'BY', NULL),
	(18, 'Belgium', 'BE', NULL),
	(19, 'Belize', 'BZ', NULL),
	(20, 'Benin', 'BJ', NULL),
	(21, 'Bermuda Is.', 'BM', NULL),
	(22, 'Bolivia', 'BO', NULL),
	(23, 'Botswana', 'BW', NULL),
	(24, 'Brazil', 'BR', NULL),
	(25, 'Brunei', 'BN', NULL),
	(26, 'Bulgaria', 'BG', NULL),
	(27, 'Burkina-faso', 'BF', NULL),
	(28, 'Burma', 'MM', NULL),
	(29, 'Burundi', 'BI', NULL),
	(30, 'Cameroon', 'CM', NULL),
	(31, 'Canada', 'CA', NULL),
	(32, 'Central African Republic', 'CF', NULL),
	(33, 'Chad', 'TD', NULL),
	(34, 'Chile', 'CL', NULL),
	(35, 'China', 'CN', NULL),
	(36, 'Colombia', 'CO', NULL),
	(37, 'Congo', 'CG', NULL),
	(38, 'Cook Is.', 'CK', NULL),
	(39, 'Costa Rica', 'CR', NULL),
	(40, 'Cuba', 'CU', NULL),
	(41, 'Cyprus', 'CY', NULL),
	(42, 'Czech Republic', 'CZ', NULL),
	(43, 'Denmark', 'DK', NULL),
	(44, 'Djibouti', 'DJ', NULL),
	(45, 'Dominica Rep.', 'DO', NULL),
	(46, 'Ecuador', 'EC', NULL),
	(47, 'Egypt', 'EG', NULL),
	(48, 'EI Salvador', 'SV', NULL),
	(49, 'Estonia', 'EE', NULL),
	(50, 'Ethiopia', 'ET', NULL),
	(51, 'Fiji', 'FJ', NULL),
	(52, 'Finland', 'FI', NULL),
	(53, 'France', 'FR', NULL),
	(54, 'French Guiana', 'GF', NULL),
	(55, 'Gabon', 'GA', NULL),
	(56, 'Gambia', 'GM', NULL),
	(57, 'Georgia', 'GE', NULL),
	(58, 'Germany', 'DE', NULL),
	(59, 'Ghana', 'GH', NULL),
	(60, 'Gibraltar', 'GI', NULL),
	(61, 'Greece', 'GR', NULL),
	(62, 'Grenada', 'GD', NULL),
	(63, 'Guam', 'GU', NULL),
	(64, 'Guatemala', 'GT', NULL),
	(65, 'Guinea', 'GN', NULL),
	(66, 'Guyana', 'GY', NULL),
	(67, 'Haiti', 'HT', NULL),
	(68, 'Honduras', 'HN', NULL),
	(69, 'Hongkong', 'HK', NULL),
	(70, 'Hungary', 'HU', NULL),
	(71, 'Iceland', 'IS', NULL),
	(72, 'India', 'IN', NULL),
	(73, 'Indonesia', 'ID', NULL),
	(74, 'Iran', 'IR', NULL),
	(75, 'Iraq', 'IQ', NULL),
	(76, 'Ireland', 'IE', NULL),
	(77, 'Israel', 'IL', NULL),
	(78, 'Italy', 'IT', NULL),
	(79, 'Jamaica', 'JM', NULL),
	(80, 'Japan', 'JP', NULL),
	(81, 'Jordan', 'JO', NULL),
	(82, 'Kampuchea (Cambodia )', 'KH', NULL),
	(83, 'Kazakstan', 'KZ', NULL),
	(84, 'Kenya', 'KE', NULL),
	(85, 'Korea', 'KR', NULL),
	(86, 'Kuwait', 'KW', NULL),
	(87, 'Kyrgyzstan', 'KG', NULL),
	(88, 'Laos', 'LA', NULL),
	(89, 'Latvia', 'LV', NULL),
	(90, 'Lebanon', 'LB', NULL),
	(91, 'Lesotho', 'LS', NULL),
	(92, 'Liberia', 'LR', NULL),
	(93, 'Libya', 'LY', NULL),
	(94, 'Liechtenstein', 'LI', NULL),
	(95, 'Lithuania', 'LT', NULL),
	(96, 'Luxembourg', 'LU', NULL),
	(97, 'Macao', 'MO', NULL),
	(98, 'Madagascar', 'MG', NULL),
	(99, 'Malawi', 'MW', NULL),
	(100, 'Malaysia', 'MY', NULL),
	(101, 'Maldives', 'MV', NULL),
	(102, 'Mali', 'ML', NULL),
	(103, 'Malta', 'MT', NULL),
	(104, 'Mauritius', 'MU', NULL),
	(105, 'Mexico', 'MX', NULL),
	(106, 'Moldova, Republic of', 'MD', NULL),
	(107, 'Monaco', 'MC', NULL),
	(108, 'Mongolia', 'MN', NULL),
	(109, 'Montserrat Is', 'MS', NULL),
	(110, 'Morocco', 'MA', NULL),
	(111, 'Mozambique', 'MZ', NULL),
	(112, 'Namibia', 'NA', NULL),
	(113, 'Nauru', 'NR', NULL),
	(114, 'Nepal', 'NP', NULL),
	(115, 'Netherlands', 'NL', NULL),
	(116, 'New Zealand', 'NZ', NULL),
	(117, 'Nicaragua', 'NI', NULL),
	(118, 'Niger', 'NE', NULL),
	(119, 'Nigeria', 'NG', NULL),
	(120, 'North Korea', 'KP', NULL),
	(121, 'Norway', 'NO', NULL),
	(122, 'Oman', 'OM', NULL),
	(123, 'Pakistan', 'PK', NULL),
	(124, 'Panama', 'PA', NULL),
	(125, 'Papua New Cuinea', 'PG', NULL),
	(126, 'Paraguay', 'PY', NULL),
	(127, 'Peru', 'PE', NULL),
	(128, 'Philippines', 'PH', NULL),
	(129, 'Poland', 'PL', NULL),
	(130, 'French Polynesia', 'PF', NULL),
	(131, 'Portugal', 'PT', NULL),
	(132, 'Puerto Rico', 'PR', NULL),
	(133, 'Qatar', 'QA', NULL),
	(134, 'Romania', 'RO', NULL),
	(135, 'Russia', 'RU', NULL),
	(136, 'Saint Lueia', 'LC', NULL),
	(137, 'Saint Vincent', 'VC', NULL),
	(138, 'San Marino', 'SM', NULL),
	(139, 'Sao Tome and Principe', 'ST', NULL),
	(140, 'Saudi Arabia', 'SA', NULL),
	(141, 'Senegal', 'SN', NULL),
	(142, 'Seychelles', 'SC', NULL),
	(143, 'Sierra Leone', 'SL', NULL),
	(144, 'Singapore', 'SG', NULL),
	(145, 'Slovakia', 'SK', NULL),
	(146, 'Slovenia', 'SI', NULL),
	(147, 'Solomon Is', 'SB', NULL),
	(148, 'Somali', 'SO', NULL),
	(149, 'South Africa', 'ZA', NULL),
	(150, 'Spain', 'ES', NULL),
	(151, 'Sri Lanka', 'LK', NULL),
	(152, 'St.Lucia', 'LC', NULL),
	(153, 'St.Vincent', 'VC', NULL),
	(154, 'Sudan', 'SD', NULL),
	(155, 'Suriname', 'SR', NULL),
	(156, 'Swaziland', 'SZ', NULL),
	(157, 'Sweden', 'SE', NULL),
	(158, 'Switzerland', 'CH', NULL),
	(159, 'Syria', 'SY', NULL),
	(160, 'Taiwan', 'TW', NULL),
	(161, 'Tajikstan', 'TJ', NULL),
	(162, 'Tanzania', 'TZ', NULL),
	(163, 'Thailand', 'TH', NULL),
	(164, 'Togo', 'TG', NULL),
	(165, 'Tonga', 'TO', NULL),
	(166, 'Trinidad and Tobago', 'TT', NULL),
	(167, 'Tunisia', 'TN', NULL),
	(168, 'Turkey', 'TR', NULL),
	(169, 'Turkmenistan', 'TM', NULL),
	(170, 'Uganda', 'UG', NULL),
	(171, 'Ukraine', 'UA', NULL),
	(172, 'United Arab Emirates', 'AE', NULL),
	(173, 'United Kiongdom', 'GB', NULL),
	(174, 'United States of America', 'US', NULL),
	(175, 'Uruguay', 'UY', NULL),
	(176, 'Uzbekistan', 'UZ', NULL),
	(177, 'Venezuela', 'VE', NULL),
	(178, 'Vietnam', 'VN', NULL),
	(179, 'Yemen', 'YE', NULL),
	(180, 'Yugoslavia', 'YU', NULL),
	(181, 'Zimbabwe', 'ZW', NULL),
	(182, 'Zaire', 'ZR', NULL),
	(183, 'Zambia', 'ZM', NULL);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;

-- Dumping structure for table fvblog.order_detail
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_Id` int(11) NOT NULL,
  `total_Price` double NOT NULL,
  `item_id` int(11) NOT NULL,
  `item` json NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COMMENT='订单详情';

-- Dumping data for table fvblog.order_detail: ~4 rows (approximately)
DELETE FROM `order_detail`;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` (`id`, `order_Id`, `total_Price`, `item_id`, `item`, `status`) VALUES
	(1, 2, 15000, 1, '{"id": 4, "itemName": "Macbook", "itemPrice": 15000, "itemDetail": "Apple"}', 1),
	(25, 1, 1, 1, 'null', 1),
	(26, 2, 2, 2, 'null', 2),
	(27, 1, 3, 1, 'null', 3);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;

-- Dumping structure for table fvblog.sys_dict
CREATE TABLE IF NOT EXISTS `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` char(50) NOT NULL,
  `name` char(50) NOT NULL,
  `value` char(50) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典';

-- Dumping data for table fvblog.sys_dict: ~0 rows (approximately)
DELETE FROM `sys_dict`;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;

-- Dumping structure for table fvblog.tb_item
CREATE TABLE IF NOT EXISTS `tb_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) DEFAULT NULL,
  `item_price` decimal(10,2) DEFAULT NULL,
  `item_detail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table fvblog.tb_item: ~3 rows (approximately)
DELETE FROM `tb_item`;
/*!40000 ALTER TABLE `tb_item` DISABLE KEYS */;
INSERT INTO `tb_item` (`id`, `item_name`, `item_price`, `item_detail`) VALUES
	(1, '袜子', 29.90, '李宁'),
	(2, '帽子', 99.99, '耐克'),
	(4, 'Macbook', 15000.00, 'Apple');
/*!40000 ALTER TABLE `tb_item` ENABLE KEYS */;

-- Dumping structure for table fvblog.tb_order
CREATE TABLE IF NOT EXISTS `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `order_number` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_id` (`user_id`),
  CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table fvblog.tb_order: ~2 rows (approximately)
DELETE FROM `tb_order`;
/*!40000 ALTER TABLE `tb_order` DISABLE KEYS */;
INSERT INTO `tb_order` (`id`, `user_id`, `order_number`, `create_date`, `update_date`) VALUES
	(1, 1, '1', '2019-11-28 11:11:39', '2019-11-28 11:11:41'),
	(2, 1, '2', '2019-11-29 18:05:40', '2019-11-29 18:05:44');
/*!40000 ALTER TABLE `tb_order` ENABLE KEYS */;

-- Dumping structure for table fvblog.user_info
CREATE TABLE IF NOT EXISTS `user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `age` int(10) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_type` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `enabled` int(2) DEFAULT NULL COMMENT '是否可用',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `qq` varchar(14) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `created` int(11) DEFAULT NULL,
  `updated` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- Dumping data for table fvblog.user_info: ~15 rows (approximately)
DELETE FROM `user_info`;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`Id`, `user_name`, `age`, `sex`, `birthday`, `password`, `user_type`, `enabled`, `real_name`, `qq`, `email`, `tel`, `created`, `updated`) VALUES
	(1, '斯通纳7', 47, 1, '1979-03-14', '12345678', '1', NULL, NULL, NULL, 'sitongna@gmail.com', NULL, NULL, NULL),
	(2, 'test2', NULL, NULL, NULL, 'aaaa', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 'test3', NULL, NULL, NULL, 'bbbb', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 'test4', NULL, NULL, NULL, 'cccc', '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(5, 'test5', NULL, NULL, NULL, 'dddd', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(6, '??', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(7, 'pitaya', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(8, 'pitaya', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(9, 'apple', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(10, 'apple', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(11, 'pear', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(18, 'today is rest day', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(23, 'today is rest day2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
