-- MySQL dump 10.13  Distrib 8.0.18, for Linux (x86_64)
--
-- Host: localhost    Database: db_week_end
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
-- Table structure for table `authentification`
--

DROP TABLE IF EXISTS `authentification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authentification` (
  `login` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authentification`
--

LOCK TABLES `authentification` WRITE;
/*!40000 ALTER TABLE `authentification` DISABLE KEYS */;
INSERT INTO `authentification` VALUES ('login','password');
/*!40000 ALTER TABLE `authentification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (2),(2),(2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` bigint(20) NOT NULL,
  `id_parent` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `sport_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfjgxuj29tnm4e7f6w7mxnf9y9` (`sport_name`),
  CONSTRAINT `FKfjgxuj29tnm4e7f6w7mxnf9y9` FOREIGN KEY (`sport_name`) REFERENCES `sport` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_personnes`
--

DROP TABLE IF EXISTS `location_personnes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location_personnes` (
  `location_id` bigint(20) NOT NULL,
  `personnes_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_itbjcquif2hg2cyi48ll6lljy` (`personnes_id`),
  KEY `FKxg0frrr1wkg53yo3ndh6o9r5` (`location_id`),
  CONSTRAINT `FK359uicpi5nng0aupnojxk1sfq` FOREIGN KEY (`personnes_id`) REFERENCES `personne` (`id`),
  CONSTRAINT `FKxg0frrr1wkg53yo3ndh6o9r5` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_personnes`
--

LOCK TABLES `location_personnes` WRITE;
/*!40000 ALTER TABLE `location_personnes` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_personnes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meteo`
--

DROP TABLE IF EXISTS `meteo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meteo` (
  `id` bigint(20) NOT NULL,
  `pluie` bit(1) NOT NULL,
  `soleil` bit(1) NOT NULL,
  `temperature` bigint(20) DEFAULT NULL,
  `vent` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meteo`
--

LOCK TABLES `meteo` WRITE;
/*!40000 ALTER TABLE `meteo` DISABLE KEYS */;
/*!40000 ALTER TABLE `meteo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personne` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `authentification_login` varchar(255) DEFAULT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhliwmyr52ba2hwydkkxh5819` (`authentification_login`),
  KEY `FK627hc6cqcrqo7u7s91estqfyv` (`location_id`),
  CONSTRAINT `FK627hc6cqcrqo7u7s91estqfyv` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FKhliwmyr52ba2hwydkkxh5819` FOREIGN KEY (`authentification_login`) REFERENCES `authentification` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personne`
--

LOCK TABLES `personne` WRITE;
/*!40000 ALTER TABLE `personne` DISABLE KEYS */;
INSERT INTO `personne` VALUES (1,'email','name','login',NULL);
/*!40000 ALTER TABLE `personne` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personne_sport`
--

DROP TABLE IF EXISTS `personne_sport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personne_sport` (
  `personnes_id` bigint(20) NOT NULL,
  `sports_name` varchar(255) NOT NULL,
  KEY `FKsavq9e7tj7ng8per9exarasun` (`sports_name`),
  KEY `FKfjcjn1jkv6eb5iejkayx79nc4` (`personnes_id`),
  CONSTRAINT `FKfjcjn1jkv6eb5iejkayx79nc4` FOREIGN KEY (`personnes_id`) REFERENCES `personne` (`id`),
  CONSTRAINT `FKsavq9e7tj7ng8per9exarasun` FOREIGN KEY (`sports_name`) REFERENCES `sport` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personne_sport`
--

LOCK TABLES `personne_sport` WRITE;
/*!40000 ALTER TABLE `personne_sport` DISABLE KEYS */;
/*!40000 ALTER TABLE `personne_sport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport`
--

DROP TABLE IF EXISTS `sport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sport` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport`
--

LOCK TABLES `sport` WRITE;
/*!40000 ALTER TABLE `sport` DISABLE KEYS */;
INSERT INTO `sport` VALUES ('Football');
/*!40000 ALTER TABLE `sport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport_meteos`
--

DROP TABLE IF EXISTS `sport_meteos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sport_meteos` (
  `sports_name` varchar(255) NOT NULL,
  `meteos_id` bigint(20) NOT NULL,
  KEY `FKajqouukonhvpe0ng864h6y1a0` (`meteos_id`),
  KEY `FKjyks7a0skvfe7t3sbflbsjt6j` (`sports_name`),
  CONSTRAINT `FKajqouukonhvpe0ng864h6y1a0` FOREIGN KEY (`meteos_id`) REFERENCES `meteo` (`id`),
  CONSTRAINT `FKjyks7a0skvfe7t3sbflbsjt6j` FOREIGN KEY (`sports_name`) REFERENCES `sport` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport_meteos`
--

LOCK TABLES `sport_meteos` WRITE;
/*!40000 ALTER TABLE `sport_meteos` DISABLE KEYS */;
/*!40000 ALTER TABLE `sport_meteos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-03  7:29:18
