-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `patId` int NOT NULL,
  `p_name` varchar(50) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `roomNo` int DEFAULT NULL,
  PRIMARY KEY (`patId`),
  KEY `fk_romNo` (`roomNo`),
  CONSTRAINT `fk_romNo` FOREIGN KEY (`roomNo`) REFERENCES `room` (`roomNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Patient1','1991-06-02','Female',65,'Building 546 Street 51 Okara  ','12844826',11),(2,'Patient2','1992-04-26','Male',63,'Building 546 Street 51 Okara  ','7764425',11),(3,'Patient3','1980-04-26','Female',64,'Building 546 Street 51 Okara  ','10990721',11),(4,'Patient4','1950-12-16','Male',68,'Building 546 Street 51 Okara  ','13444600',11),(5,'Patient5','2012-05-23','Female',69,'Building 546 Street 51 Okara  ','12937440',12),(6,'Patient6','2002-10-02','Male',67,'Building 546 Street 51 Okara  ','11138299',12),(7,'rana ali','2018-01-24','male',56,'not addrs','3303163',12),(8,'Mr Abd ddH','2010-01-07','male',56,'fsd','301113',13),(9,'sir abd tlal','2020-12-30','male',56,'address g2','3000',13),(10,'Mr asd asad','2018-01-18','male',67,'ad g2 fsd','300',13),(11,'mr  aliu','2021-01-06','male',56,'asd g2','300',13),(12,'mr ali gg','2018-01-11','male',56,'g2 fsd','300',13),(13,'mr al aki','2017-01-18','male',56,'g2 fsd','3000',13),(14,'ali ew','2021-01-18','male',56,'ge fsd','23',13),(15,'mr jj','2021-01-19','male',56,'g2 fsd','333',13),(16,'mr  g','2021-01-19','male',56,'addr','20',13),(17,'mr gg2','2021-01-24','male',57,'ad','1001',14),(18,'mr ali amjad','2021-01-11','male',56,'gefsd part 2','2',21),(19,'mr raza','2020-12-29','male',45,'g2 ','042104',13);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-24  1:29:40
