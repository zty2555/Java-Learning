/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 5.5.52 : Database - bookstore210107
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore210107` /*!40100 DEFAULT CHARACTER SET utf8 */;


/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `img_path` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`book_id`,`book_name`,`author`,`price`,`sales`,`stock`,`img_path`) values 
(1,'解忧杂货店','东野圭吾',27.2,100,100,'static/uploads/jieyouzahuodian.jpg'),
(2,'边城','沈从文',23,100,100,'static/uploads/biancheng.jpg'),
(3,'中国哲学史','冯友兰',44.5,100,100,'static/uploads/zhongguozhexueshi.jpg'),
(4,'忽然七日',' 劳伦',19.33,100,100,'static/uploads/huranqiri.jpg'),
(5,'苏东坡传','林语堂',19.3,100,100,'static/uploads/sudongpozhuan.jpg'),
(6,'百年孤独','马尔克斯',29.5,100,100,'static/uploads/bainiangudu.jpg'),
(7,'扶桑','严歌苓',19.8,100,100,'static/uploads/fusang.jpg'),
(8,'给孩子的诗','北岛',22.2,100,100,'static/uploads/geihaizideshi.jpg'),
(9,'为奴十二年','所罗门',16.5,100,100,'static/uploads/weinushiernian.jpg'),
(10,'平凡的世界','路遥',55,100,100,'static/uploads/pingfandeshijie.jpg'),
(11,'悟空传','今何在',14,100,100,'static/uploads/wukongzhuan.jpg'),
(12,'硬派健身','斌卡',31.2,100,100,'static/uploads/yingpaijianshen.jpg'),
(13,'从晚清到民国','唐德刚',39.9,100,100,'static/uploads/congwanqingdaominguo.jpg'),
(14,'三体','刘慈欣',56.5,100,100,'static/uploads/santi.jpg'),
(15,'看见','柴静',19.5,100,100,'static/uploads/kanjian.jpg'),
(16,'活着','余华',11,100,100,'static/uploads/huozhe.jpg'),
(17,'小王子','安托万',19.2,100,100,'static/uploads/xiaowangzi.jpg'),
(18,'我们仨','杨绛',11.3,100,100,'static/uploads/womensa.jpg'),
(19,'生命不息,折腾不止','罗永浩',25.2,100,100,'static/uploads/shengmingbuxi.jpg'),
(20,'皮囊','蔡崇达',23.9,100,100,'static/uploads/pinang.jpg'),
(21,'恰到好处的幸福','毕淑敏',16.4,100,100,'static/uploads/qiadaohaochudexingfu.jpg'),
(22,'大数据预测','埃里克',37.2,100,100,'static/uploads/dashujuyuce.jpg'),
(23,'人月神话','布鲁克斯',55.9,100,100,'static/uploads/renyueshenhua.jpg'),
(24,'C语言入门经典','霍尔顿',45,100,100,'static/uploads/cyuyanrumenjingdian.jpg'),
(25,'数学之美','吴军',29.9,100,100,'static/uploads/shuxuezhimei.jpg'),
(26,'Java编程思想','埃史尔',70.5,100,100,'static/uploads/Javabianchengsixiang.jpg'),
(27,'设计模式之禅','秦小波',20.2,100,100,'static/uploads/shejimoshizhichan.jpg'),
(28,'图解机器学习','杉山将',33.8,100,100,'static/uploads/tujiejiqixuexi.jpg'),
(29,'艾伦图灵传','安德鲁',47.2,100,100,'static/uploads/ailuntulingzhuan.jpg'),
(30,'教父','马里奥普佐',29,100,100,'static/uploads/jiaofu.jpg');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` char(100) DEFAULT NULL,
  `user_pwd` char(100) DEFAULT NULL,
  `email` char(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`user_name`,`user_pwd`,`email`) values 
(2,'happy','E10ADC3949BA59ABBE56E057F20F883E','abc@qq.com'),
(3,'tom2021','E10ADC3949BA59ABBE56E057F20F883E','tom@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
