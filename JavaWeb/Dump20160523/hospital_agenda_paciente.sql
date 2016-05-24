-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
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
-- Table structure for table `agenda_paciente`
--

DROP TABLE IF EXISTS `agenda_paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda_paciente` (
  `AGENDA_ID` int(11) NOT NULL,
  `PACIENTE_CPF` varchar(11) NOT NULL,
  UNIQUE KEY `UK_9vn192k1s3c5tlqcpbohyhfmf` (`AGENDA_ID`,`PACIENTE_CPF`),
  UNIQUE KEY `CONSTRAINT_AGENDA_PACIENTE` (`AGENDA_ID`,`PACIENTE_CPF`),
  KEY `FK_4guux37xi3bcti2bpp50ai91v` (`PACIENTE_CPF`),
  CONSTRAINT `FK_4guux37xi3bcti2bpp50ai91v` FOREIGN KEY (`PACIENTE_CPF`) REFERENCES `paciente` (`CPF`),
  CONSTRAINT `FK_hnql4bgn1mxa74hxk7kshn2wj` FOREIGN KEY (`AGENDA_ID`) REFERENCES `agenda` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda_paciente`
--

LOCK TABLES `agenda_paciente` WRITE;
/*!40000 ALTER TABLE `agenda_paciente` DISABLE KEYS */;
INSERT INTO `agenda_paciente` VALUES (1,'11122233300'),(1,'3350145784');
/*!40000 ALTER TABLE `agenda_paciente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-23 22:36:47
