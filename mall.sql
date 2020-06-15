-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: mall
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `goodsid` int(11) NOT NULL,
  `goodsname` varchar(45) NOT NULL,
  `number` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk5_idx` (`goodsid`),
  KEY `fk6_idx` (`userid`),
  CONSTRAINT `fk5` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`),
  CONSTRAINT `fk6` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (20,43,37,'测试耳机',20),(21,1,37,'测试耳机',1);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `content` varchar(500) DEFAULT NULL,
  `value` int(11) DEFAULT '3',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk1_idx` (`userid`),
  KEY `fk2_idx` (`goodsid`),
  CONSTRAINT `fk3` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `fk4` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (5,1,4,'哈哈哈哈哈。',3,'2020-05-12 12:49:20'),(6,1,1,'不错的耳机，下次还来买',3,'2020-06-01 08:25:34'),(7,5,1,'不错的耳机，下次还来',5,'2020-06-13 23:13:41'),(8,11,1,'很烂的鼠标垫，用2此就烂了，不要买',1,'2020-06-13 23:14:09'),(9,12,1,'不错的椅子',5,'2020-06-13 23:14:29'),(10,5,1,'很好的耳机',5,'2020-06-13 23:21:07'),(11,11,1,'很好的鼠标垫，很漂亮',4,'2020-06-13 23:32:19');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `typename` varchar(30) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `info` varchar(1000) DEFAULT NULL,
  `picture` varchar(100) DEFAULT 'nophoto',
  `sales` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `typename` (`typename`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`typename`) REFERENCES `goodstype` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'beats耳机','耳机',344,234234.00,'类型：蓝牙耳机\n续航：7天\n重量：20g\n颜色：白色','d513daff-2432-4ba1-b291-cb6a45281be6耳机4.jpg',0),(4,'小米耳机','耳机',344,1200.00,'小米的蓝牙耳机','1f6c54cd-57bf-4ea7-b087-e5faf18bcf5d下载.jpg',0),(5,'华为耳机','耳机',344,1200.00,'华为的蓝牙耳机','42cf5ad6-15d5-4f09-845b-e3bc0d838458下载 (1).jpg',0),(8,'罗技鼠标','鼠标',234,222.00,'罗技502鼠标，最新的鼠标','d10f588e-1daa-4366-b6a7-bf6bfb0c1722u=3770017804,2048760092&fm=26&gp=0.jpg',0),(11,'1号鼠标垫','鼠标垫',231,11.00,'对方是否','0b3512cf-9d3e-461d-95b8-a81d473b0201鼠标垫1.jpg',2),(12,'电竞椅3号','电竞椅',2333,333.00,'一款电竞椅','da3fbf45-da82-49af-8385-5b898bfb182e电竞椅2.jpg',0),(14,'电竞椅6号','电竞椅',2333,335.00,'一款电竞椅','fd4809a5-da61-426c-9d21-feb0b553985e前后端分离.jpg',0),(29,'otto电竞椅','电竞椅',234,234.00,'234','93d324fa-6a6c-4af0-9a5f-11258e07a372电竞椅1.jpg',0),(31,'士大夫键盘','键盘',234,234.00,'234','953ca365-2506-44a7-a178-86d12e74d3dc键盘2.jpg',0),(32,'大米键盘','键盘',234,234.00,'大米键盘','a8d980c4-0ef8-4183-8a78-c20792c1bcdd键盘5.jpg',0),(33,'你在干什么手柄','手柄',1,23.22,'手柄','bed6fdec-8aa8-42c4-ba5d-8cb8334a5f2b手柄1.jpg',0),(34,'大罗发鼠标','鼠标',1,4.22,'士大夫','1365b5aa-7be8-4032-b333-1a0807c7aae9鼠标2.jpg',0),(35,'df ','手柄',1,0.00,'asdf ','e06db1a4-9335-4b40-a2f9-b5a4b254d14b手柄2.jpg',0),(36,'测试用鼠标初始10个','鼠标',5,10.00,'类型：鼠标；\n颜色：黑色；\n重量：100g；','bdb15a38-aa54-46b9-b680-f3bdca2659a6鼠标2.jpg',0),(37,'测试耳机','耳机',0,69.30,'颜色：黑色\n重量：100g\n电池：锂电池\n类型：蓝牙\n','9c948217-ce8c-4016-aeb0-65a4b6f38626耳机6.jpg',50);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodstype`
--

DROP TABLE IF EXISTS `goodstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodstype`
--

LOCK TABLES `goodstype` WRITE;
/*!40000 ALTER TABLE `goodstype` DISABLE KEYS */;
INSERT INTO `goodstype` VALUES (5,'手柄'),(6,'电竞椅'),(1,'耳机'),(3,'键盘'),(2,'鼠标'),(4,'鼠标垫');
/*!40000 ALTER TABLE `goodstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) NOT NULL,
  `goodsid` int(11) NOT NULL,
  `goodsname` varchar(50) NOT NULL,
  `number` int(11) NOT NULL DEFAULT '1',
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk2_idx` (`orderid`),
  CONSTRAINT `fk2` FOREIGN KEY (`orderid`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` VALUES (6,10,5,'华为耳机',2,1200.00),(7,10,11,'1号鼠标垫',3,11.00),(8,10,12,'电竞椅3号',2,333.00),(9,11,29,'otto电竞椅',1,234.00),(10,12,12,'电竞椅3号',1,333.00),(11,13,32,'大米键盘',3,234.00),(12,14,36,'测试用鼠标初始10个',5,10.00),(13,15,37,'测试耳机',10,69.30),(14,16,11,'1号鼠标垫',2,11.00),(15,17,37,'测试耳机',20,69.30),(16,18,37,'测试耳机',20,69.30);
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `receiver` varchar(45) NOT NULL,
  `address` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(20) NOT NULL,
  `postcode` varchar(10) NOT NULL,
  `status` varchar(5) NOT NULL DEFAULT '待发货',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk7_idx` (`userid`),
  CONSTRAINT `fk7` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (10,1,'user','user','15869196095','000000','已收货','2020-06-12 22:50:56'),(11,1,'李小龙','浙江工业大学屏峰校区','15869196095','000000','待发货','2020-06-13 00:34:03'),(12,1,'user','北京市','15869196095','000000','待发货','2020-06-13 00:40:37'),(13,1,'user','user','15869196095','000000','待发货','2020-06-13 00:54:51'),(14,1,'小红','浙江工业大学','15869196095','000000','待发货','2020-06-13 06:59:28'),(15,1,'user','浙江工业大学','15869196095','000000','已收货','2020-06-13 21:20:40'),(16,1,'user','浙江工业大学','15869196095','000000','已评价','2020-06-13 23:31:09'),(17,43,'user1','浙江工业大学','15869196095','000000','待发货','2020-06-13 23:53:03'),(18,1,'user','上海','15869196095','000000','待发货','2020-06-13 23:59:44');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','12345','男','234324@qq.com','15869196055'),(4,'小李子','123456','男','1319176438@qq.com','15869196095'),(5,'小明','222222','女','1319176438@qq.com','15869196095'),(6,'小赵字','123456','男','1319176438@qq.com','15869196095'),(9,'admin1234444','222','女','234423@qq.com','15869196095'),(22,'小丽','111111','女','21312@qq.com','1111111'),(35,'张无忌','12345','女','123213@qq.com','15923492952'),(36,'张三丰','12345','女','zhangsanf@qq.com','15829430923'),(37,'狮王','11111','女','12@qq.com','15869196053'),(38,'asdf','11111','女','123@qq.com','15812325232'),(39,'werw','11111','女','111@qq.com','15961434234'),(40,'234234','22222','女','222@qq.com','15869191233'),(41,'123','11111','女','111@qq.com','15869196043'),(42,'34242','22222','女','234234@qq.com','15869243424'),(43,'user1','12345','男','123123@qq.com','15869696044');
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

-- Dump completed on 2020-06-14 16:24:14
