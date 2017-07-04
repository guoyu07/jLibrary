-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 106.14.221.208    Database: jlibrary
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aName` varchar(20) DEFAULT NULL,
  `aUsername` varchar(20) DEFAULT NULL,
  `aPassword` varchar(20) DEFAULT NULL,
  `aGender` char(1) DEFAULT NULL,
  `aTel` varchar(20) DEFAULT NULL,
  `aJob` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'某管理','admin@live.com','123321','F','18600000000','图书管理员');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bType` int(11) DEFAULT NULL,
  `bLocale` int(11) DEFAULT NULL,
  `bSupplier` int(11) DEFAULT NULL,
  `bDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,1,1,1,'2017-06-30'),(2,1,1,1,'2017-05-05'),(3,1,1,1,'2017-06-15'),(4,1,2,1,'2017-06-02'),(5,1,2,1,'2016-12-12'),(6,1,2,2,'2015-02-22'),(7,1,2,2,'2016-07-24'),(8,2,1,3,'2017-07-22'),(9,2,1,3,'2017-06-15'),(10,2,1,3,'2017-06-15'),(11,2,1,3,'2017-06-15'),(12,3,3,1,'2017-06-15'),(13,3,3,1,'2017-06-15'),(14,3,3,1,'2017-06-15'),(15,3,3,1,'2017-06-15'),(16,4,4,1,'2017-06-15'),(17,4,4,1,'2017-06-15'),(18,4,4,1,'2017-06-15');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `circulation`
--

DROP TABLE IF EXISTS `circulation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circulation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cUser` int(11) DEFAULT NULL,
  `cBook` int(11) DEFAULT NULL,
  `cDate` date DEFAULT NULL,
  `cDdl` date DEFAULT NULL,
  `cState` varchar(10) DEFAULT 'in',
  `cReDate` date DEFAULT '2000-01-01',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circulation`
--

LOCK TABLES `circulation` WRITE;
/*!40000 ALTER TABLE `circulation` DISABLE KEYS */;
INSERT INTO `circulation` VALUES (1,1,1,'2017-06-20','2018-01-01','in','2000-01-01'),(4,1,5,'2017-06-30','2017-10-03','in','2000-01-01'),(7,1,15,'2017-06-30','2017-10-03','done','2017-06-30'),(8,1,22,'2017-07-01','2017-10-04','done','2017-07-01'),(9,1,10,'2017-07-01','2017-10-04','done','2017-07-01'),(10,1,18,'2017-07-04','2017-10-07','done','2017-07-04');
/*!40000 ALTER TABLE `circulation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locale`
--

DROP TABLE IF EXISTS `locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locale`
--

LOCK TABLES `locale` WRITE;
/*!40000 ALTER TABLE `locale` DISABLE KEYS */;
INSERT INTO `locale` VALUES (-1,'待上架'),(0,'已借出'),(1,'1A书架'),(2,'1B书架'),(3,'2A书架'),(4,'2B书架'),(5,'2C书架');
/*!40000 ALTER TABLE `locale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sName` varchar(20) DEFAULT NULL,
  `sTel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'当当','80000001'),(2,'天猫','80000002'),(3,'新华','80000003');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typee`
--

DROP TABLE IF EXISTS `typee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tName` varchar(20) DEFAULT NULL,
  `tAuthor` varchar(20) DEFAULT NULL,
  `tISBN` varchar(20) DEFAULT NULL,
  `tPress` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typee`
--

LOCK TABLES `typee` WRITE;
/*!40000 ALTER TABLE `typee` DISABLE KEYS */;
INSERT INTO `typee` VALUES (1,'百年孤独','作者A','9798123123123','出版社A'),(2,'千年孤独','作者A','9788053151351135','出版社B'),(3,'万年孤独','作者B','978846464864068046','出版社B'),(4,'百万孤独','作者B','97856465048468468','出版社C'),(5,'百万富翁','作者C','97856486464','出版社D'),(6,'大富翁','作者B','97851651654546','出版社B');
/*!40000 ALTER TABLE `typee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uName` varchar(20) DEFAULT NULL,
  `uUsername` varchar(20) DEFAULT NULL,
  `uPassword` varchar(20) DEFAULT NULL,
  `uGender` char(1) DEFAULT NULL,
  `uTel` varchar(20) DEFAULT NULL,
  `uCredit` int(11) DEFAULT NULL,
  `uGroup` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'王国志','wung@live.com','123456','M','13684810000',95,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-05  1:50:53
