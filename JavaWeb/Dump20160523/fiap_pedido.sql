-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: fiap
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `IDPEDIDO` int(11) NOT NULL AUTO_INCREMENT,
  `IDCLIENTE` int(11) NOT NULL,
  `DATA` datetime DEFAULT NULL,
  `DESCRICAO` varchar(45) DEFAULT NULL,
  `VALOR` double DEFAULT NULL,
  PRIMARY KEY (`IDPEDIDO`),
  KEY `FK_CLIENTE_PEDIDO_idx` (`IDCLIENTE`),
  CONSTRAINT `FK_CLIENTE_PEDIDO` FOREIGN KEY (`IDCLIENTE`) REFERENCES `cliente` (`IDCLIENTE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,22,'2016-05-15 22:26:22','Compra de Teclado',1200),(2,22,'2016-05-15 22:26:22','Compra de Teclado',1200),(3,23,'2016-05-15 22:27:16','Compra de Teclado',1200),(4,23,'2016-05-15 22:27:16','Compra de Teclado',1200),(5,25,'2016-05-15 22:35:50','Compra de Teclado',1200),(6,25,'2016-05-15 22:35:50','Compra de Teclado',1200),(7,26,'2016-05-15 22:36:35','Compra de Teclado',1200),(8,26,'2016-05-15 22:36:35','Compra de Teclado',1200),(9,27,'2016-05-15 22:37:20','Compra de Teclado',1200),(10,27,'2016-05-15 22:37:20','Compra de Teclado',1200),(11,28,'2016-05-15 22:38:24','Compra de Notebook',1200),(12,28,'2016-05-15 22:38:24','Compra de Teclado',1200),(13,30,'2016-05-15 22:59:03','Compra de Notebook',1200),(14,30,'2016-05-15 22:59:03','Compra de Teclado',1200),(15,31,'2016-05-15 22:59:23','Compra de Notebook',1200),(16,31,'2016-05-15 22:59:23','Compra de Teclado',1200);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-23 22:36:46
