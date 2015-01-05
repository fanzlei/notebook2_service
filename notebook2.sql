CREATE DATABASE  IF NOT EXISTS `notebook` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `notebook`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: notebook
-- ------------------------------------------------------
-- Server version	5.7.3-m13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用户注册信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'fanz','1112','14718090417','fanz_lei@126.com'),(3,'abc','abc',NULL,NULL),(4,'qq','qq','qq','qq'),(5,'fanzz','1111',NULL,'fasd2@126.com'),(6,'ss','ss',NULL,'fanfs@121.com'),(7,'abctt','abctt',NULL,'fanz@123.com'),(8,'qqqq','1111','14718090417','dtf5@126.com'),(9,'qqqqq','1111','14718090417','fgft@126.com'),(12,'qqqqqq','1111','14718090417','dgdty@126.com'),(13,'pioi','1111','14718090417','fht@126.com'),(15,'pioii','1111','14718090417','fht@126.com'),(17,'qqq','qqqq','14718090417','fgg@126.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_notebook`
--

DROP TABLE IF EXISTS `user_notebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_notebook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_notebook`
--

LOCK TABLES `user_notebook` WRITE;
/*!40000 ALTER TABLE `user_notebook` DISABLE KEYS */;
INSERT INTO `user_notebook` VALUES (19,'qqq','12','fjdslfajlfj','2014-12-8 上午10:26:23','2'),(20,'qqq','ppp','    ','2014-12-8 上午10:24:59','1'),(21,'qqq','zx','    ','2014-12-8 ??9:43:44','1'),(23,'qqq','mmmm','    ','2014-12-8 上午11:30:33','1'),(24,'qqq','校长信箱','    ','2014-12-8 下午1:16:12','1'),(25,'fanz','p','    ','2014-12-8 ??1:54:45','1'),(26,'fanz','title','content','date','2'),(27,'fanz','p','    ','2014-12-8 ??2:12:35','2'),(28,'fanz','u','    ','2014-12-8 ??2:12:53','1');
/*!40000 ALTER TABLE `user_notebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'notebook'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-20 10:45:48
