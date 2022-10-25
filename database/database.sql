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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `patId` int NOT NULL,
  `bill_id` int NOT NULL,
  `otherCharges` float DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `patId` (`patId`),
  CONSTRAINT `bill_fk_patID` FOREIGN KEY (`patId`) REFERENCES `patient` (`patId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,1,1000),(2,2,1000),(3,3,800),(4,4,900),(5,5,1000),(6,6,700),(5,7,766);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
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
-- Table structure for table `daterecord`
--

DROP TABLE IF EXISTS `daterecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `daterecord` (
  `entryId` int NOT NULL,
  `patId` int NOT NULL,
  `admit` datetime DEFAULT NULL,
  `discharge` datetime DEFAULT NULL,
  `dateOfDisease` date DEFAULT NULL,
  PRIMARY KEY (`entryId`),
  KEY `patId2_idx` (`patId`),
  CONSTRAINT `patId2` FOREIGN KEY (`patId`) REFERENCES `patient` (`patId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daterecord`
--

LOCK TABLES `daterecord` WRITE;
/*!40000 ALTER TABLE `daterecord` DISABLE KEYS */;
INSERT INTO `daterecord` VALUES (1,1,'2021-06-23 00:00:00','2021-06-25 00:00:00','2021-06-05'),(2,2,'2021-06-21 00:00:00','2021-06-24 00:00:00','2021-06-04'),(3,3,'2021-06-21 00:00:00','2021-06-23 00:00:00','2021-06-04'),(4,4,'2021-06-20 00:00:00','2021-06-21 00:00:00','2021-06-01'),(5,5,'2021-06-20 00:00:00','2021-06-22 00:00:00','2021-06-03'),(6,6,'2021-06-25 00:00:00','2021-06-27 00:00:00','2021-06-09'),(7,19,'2021-01-23 11:00:23','2021-01-24 12:40:01','2021-01-04');
/*!40000 ALTER TABLE `daterecord` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-24  1:29:39

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
-- Table structure for table `diagnosis`
--

DROP TABLE IF EXISTS `diagnosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnosis` (
  `Dia_id` int unsigned NOT NULL AUTO_INCREMENT,
  `patId` int NOT NULL,
  `disease` varchar(50) DEFAULT NULL,
  `temp` float DEFAULT NULL,
  `blood` varchar(10) DEFAULT NULL,
  `bp` varchar(10) DEFAULT NULL,
  `perscription` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Dia_id`),
  KEY `patId` (`patId`),
  CONSTRAINT `fk_patId` FOREIGN KEY (`patId`) REFERENCES `patient` (`patId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnosis`
--

LOCK TABLES `diagnosis` WRITE;
/*!40000 ALTER TABLE `diagnosis` DISABLE KEYS */;
INSERT INTO `diagnosis` VALUES (1,5,'injury',99,'A+','128','operate'),(2,3,'kidney failure',97,'B-','120','medicine'),(3,2,'injury',100,'A+','123','operate'),(4,4,'digestive disorder',98,'B-','130','medicine'),(5,1,'heart attack',101,'A+','125','medicine'),(6,6,'kidney failure',103,'AB+','126','medicine'),(7,2,'heart attack',101,'AB+','125','medicine'),(8,3,'injury',98,'A+','125','operate'),(9,2,'Injury 2',98,'A+','180 / 90','This is a injury');
/*!40000 ALTER TABLE `diagnosis` ENABLE KEYS */;
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
-- Table structure for table `doc_assign`
--

DROP TABLE IF EXISTS `doc_assign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doc_assign` (
  `patId` int NOT NULL,
  `docId` int NOT NULL,
  KEY `fk_patId` (`patId`),
  KEY `fk_docId` (`docId`),
  CONSTRAINT `doc_assign_ibfk_1` FOREIGN KEY (`docId`) REFERENCES `doctor` (`doc_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `doc_assign_ibfk_2` FOREIGN KEY (`patId`) REFERENCES `patient` (`patId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doc_assign`
--

LOCK TABLES `doc_assign` WRITE;
/*!40000 ALTER TABLE `doc_assign` DISABLE KEYS */;
INSERT INTO `doc_assign` VALUES (5,1),(1,2),(3,3),(4,4),(2,5),(6,5),(5,2);
/*!40000 ALTER TABLE `doc_assign` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-24  1:29:39

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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `doc_id` int NOT NULL,
  `doc_name` varchar(40) DEFAULT NULL,
  `charge` float DEFAULT NULL,
  `specialization` varchar(40) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'Ahmad',500,'Surgeon',40,'Building 546 Street 51 Okara  ','10890569'),(2,'Rana',500,'Cardiologist',33,'Building 546 Street 51 Okara  ','44629501'),(3,'Alex',500,'Surgeon',65,'Building 546 Street 51 Okara  ','60981003'),(4,'Sama',500,'Gastroenterologist',42,'Building 546 Street 51 Okara  ','77967657'),(5,'tes',500,'Nephrologist',35,'Building 546 Street 51 Okara  ','51655555');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
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
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `roomNo` int NOT NULL,
  `beds` int DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `charge` float DEFAULT NULL,
  PRIMARY KEY (`roomNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (11,3,1,900),(12,3,0,70),(13,3,1,100),(14,2,0,100),(21,3,0,100),(22,2,0,800),(23,3,0,NULL),(24,3,0,200),(25,3,0,12);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
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
-- Temporary view structure for view `currentpatient`
--

DROP TABLE IF EXISTS `currentpatient`;
/*!50001 DROP VIEW IF EXISTS `currentpatient`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `currentpatient` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `roomNo`,
 1 AS `contact`,
 1 AS `address`,
 1 AS `admit`,
 1 AS `disease`,
 1 AS `prescription`,
 1 AS `doctor`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `oldpatient`
--

DROP TABLE IF EXISTS `oldpatient`;
/*!50001 DROP VIEW IF EXISTS `oldpatient`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `oldpatient` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `roomNo`,
 1 AS `contact`,
 1 AS `address`,
 1 AS `admit`,
 1 AS `discharge`,
 1 AS `disease`,
 1 AS `prescription`,
 1 AS `doctor`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `patientbill`
--

DROP TABLE IF EXISTS `patientbill`;
/*!50001 DROP VIEW IF EXISTS `patientbill`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `patientbill` AS SELECT 
 1 AS `patId`,
 1 AS `p_name`,
 1 AS `roomCharge`,
 1 AS `docCharge`,
 1 AS `days`,
 1 AS `otherCharges`,
 1 AS `totbill`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `currentpatient`
--

/*!50001 DROP VIEW IF EXISTS `currentpatient`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `currentpatient` AS select distinct `pat`.`patId` AS `id`,`pat`.`p_name` AS `name`,`pat`.`roomNo` AS `roomNo`,`pat`.`contact` AS `contact`,`pat`.`address` AS `address`,`daterecord`.`admit` AS `admit`,`diagnosis`.`disease` AS `disease`,`diagnosis`.`perscription` AS `prescription`,`doctor`.`doc_name` AS `doctor` from ((((`patient` `pat` join `daterecord` on((`pat`.`patId` = `daterecord`.`patId`))) left join `diagnosis` on((`pat`.`patId` = `diagnosis`.`patId`))) left join `doc_assign` on((`pat`.`patId` = `doc_assign`.`patId`))) left join `doctor` on((`doc_assign`.`docId` = `doctor`.`doc_id`))) where (`daterecord`.`discharge` is null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `oldpatient`
--

/*!50001 DROP VIEW IF EXISTS `oldpatient`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `oldpatient` AS select distinct `pat`.`patId` AS `id`,`pat`.`p_name` AS `name`,`pat`.`roomNo` AS `roomNo`,`pat`.`contact` AS `contact`,`pat`.`address` AS `address`,`daterecord`.`admit` AS `admit`,`daterecord`.`discharge` AS `discharge`,`diagnosis`.`disease` AS `disease`,`diagnosis`.`perscription` AS `prescription`,`doctor`.`doc_name` AS `doctor` from ((((`patient` `pat` join `daterecord` on((`pat`.`patId` = `daterecord`.`patId`))) left join `diagnosis` on((`pat`.`patId` = `diagnosis`.`patId`))) left join `doc_assign` on((`pat`.`patId` = `doc_assign`.`patId`))) left join `doctor` on((`doc_assign`.`docId` = `doctor`.`doc_id`))) where (`daterecord`.`discharge` is not null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `patientbill`
--

/*!50001 DROP VIEW IF EXISTS `patientbill`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `patientbill` AS select `patient`.`patId` AS `patId`,`patient`.`p_name` AS `p_name`,(select `room`.`charge` from `room` where (`patient`.`roomNo` = `room`.`roomNo`)) AS `roomCharge`,(select `doctor`.`charge` from (`doctor` join `doc_assign`) where ((`patient`.`patId` = `doc_assign`.`patId`) and (`doc_assign`.`docId` = `doctor`.`doc_id`)) limit 1) AS `docCharge`,(select (to_days((select distinct `daterecord`.`discharge` from `daterecord` where (`daterecord`.`patId` = `patient`.`patId`) limit 1)) - to_days((select distinct `daterecord`.`admit` from `daterecord` where (`daterecord`.`patId` = `patient`.`patId`) limit 1)))) AS `days`,(select `bill`.`otherCharges` from `bill` where (`bill`.`patId` = `patient`.`patId`) limit 1) AS `otherCharges`,(select (((`roomCharge` * `days`) + `otherCharges`) + `docCharge`)) AS `totbill` from `patient` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-24  1:29:41

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
-- Table structure for table `athentication`
--

DROP TABLE IF EXISTS `athentication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `athentication` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `athentication`
--

LOCK TABLES `athentication` WRITE;
/*!40000 ALTER TABLE `athentication` DISABLE KEYS */;
INSERT INTO `athentication` VALUES ('adil123','123456'),('arshad123','123456'),('imran123','123456'),('saeed','1234fg.'),('shafiq123','123456'),('shafiq1234','234234'),('shafiq786','123456'),('talha123','123456');
/*!40000 ALTER TABLE `athentication` ENABLE KEYS */;
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
