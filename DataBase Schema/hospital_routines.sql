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
