CREATE DATABASE  IF NOT EXISTS `progetto` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `progetto`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: progetto
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `attori`
--

DROP TABLE IF EXISTS `attori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attori` (
  `idatt` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  `cognome` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idatt`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attori`
--

LOCK TABLES `attori` WRITE;
/*!40000 ALTER TABLE `attori` DISABLE KEYS */;
INSERT INTO `attori` VALUES (150,'Massimo','Troisi'),(151,'Fabrizio','Moro'),(152,'Anita','Akberg'),(153,'Valeria','Ciangottini'),(154,'Leonardo','Di Caprio'),(155,'Robert','De Niro'),(156,'Giulio','Servillo'),(157,'Matthew','McConaughey'),(158,'Tom','Hanks'),(159,'Morgan ','Freeman'),(160,'Penelope Ann ','Miller'),(161,'Kevin','Costner'),(162,'Al ','Pacino');
/*!40000 ALTER TABLE `attori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biglietti`
--

DROP TABLE IF EXISTS `biglietti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `biglietti` (
  `idb` int NOT NULL AUTO_INCREMENT,
  `dataemiss` date NOT NULL,
  `username` varchar(20) NOT NULL,
  `codprog` int DEFAULT NULL,
  `codpos` int NOT NULL,
  PRIMARY KEY (`idb`)
) ENGINE=InnoDB AUTO_INCREMENT=186 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biglietti`
--

LOCK TABLES `biglietti` WRITE;
/*!40000 ALTER TABLE `biglietti` DISABLE KEYS */;
/*!40000 ALTER TABLE `biglietti` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `biglietti_AFTER_INSERT` AFTER INSERT ON `biglietti` FOR EACH ROW BEGIN
UPDATE `progetto`.`utenti` SET `bigliettiacquistati`= `bigliettiacquistati`+1  WHERE  username=new.username;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `biglietti_storico`
--

DROP TABLE IF EXISTS `biglietti_storico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `biglietti_storico` (
  `codst` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `film` varchar(50) NOT NULL,
  `giorno` timestamp NOT NULL,
  `cinema` varchar(20) NOT NULL,
  `numsala` int NOT NULL,
  `numfila` int DEFAULT NULL,
  `numcol` int DEFAULT NULL,
  `dataemiss` date NOT NULL,
  PRIMARY KEY (`codst`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biglietti_storico`
--

LOCK TABLES `biglietti_storico` WRITE;
/*!40000 ALTER TABLE `biglietti_storico` DISABLE KEYS */;
/*!40000 ALTER TABLE `biglietti_storico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `bigliettiacquistati`
--

DROP TABLE IF EXISTS `bigliettiacquistati`;
/*!50001 DROP VIEW IF EXISTS `bigliettiacquistati`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `bigliettiacquistati` AS SELECT 
 1 AS `username`,
 1 AS `codpos`,
 1 AS `idb`,
 1 AS `dataemiss`,
 1 AS `giorno`,
 1 AS `FILM`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinema` (
  `idcin` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `indirizzo` varchar(50) NOT NULL,
  `città` varchar(20) NOT NULL,
  `nazione` varchar(30) DEFAULT NULL,
  `numsale` int DEFAULT NULL,
  PRIMARY KEY (`idcin`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema`
--

LOCK TABLES `cinema` WRITE;
/*!40000 ALTER TABLE `cinema` DISABLE KEYS */;
INSERT INTO `cinema` VALUES (1,'The Space','Via Cavour 33','Roma','Italia',5),(2,'Medusa','Via Giuseppe Verdi 11','Verona','Italia',5),(3,'F.Fellini','Via Italia 12','Venezia','Italia',5);
/*!40000 ALTER TABLE `cinema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultazioni`
--

DROP TABLE IF EXISTS `consultazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consultazioni` (
  `username` varchar(20) NOT NULL,
  `codprog` int NOT NULL,
  PRIMARY KEY (`username`,`codprog`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultazioni`
--

LOCK TABLES `consultazioni` WRITE;
/*!40000 ALTER TABLE `consultazioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `consultazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film` (
  `idf` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `anno` int DEFAULT NULL,
  `durata` varchar(10) DEFAULT NULL,
  `recensione` varchar(100) DEFAULT NULL,
  `distributore` varchar(100) DEFAULT NULL,
  `genere` varchar(20) DEFAULT NULL,
  `paese` varchar(30) DEFAULT NULL,
  `idreg` int DEFAULT NULL,
  PRIMARY KEY (`idf`)
) ENGINE=InnoDB AUTO_INCREMENT=4012 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (4000,'La Dolce Vita',1960,'180 min','4,4 stelle','Cineriz','Drammarìtico','Italia,Francia',1501),(4001,'I vitelloni',1953,'115 min','4,4 stelle','Enic','Commedia','Italia,Francia',1501),(4002,'Ricomincio da tre',2015,'109 min','4,3 stelle','Medusa','Commedia','Italia',1502),(4003,'Il Divo',2008,'110 min','4 stelle','Lucky Red','Biografico','Italia',1506),(4004,'Scarface',1983,'161 min','4,2 stelle','UIP','Drammatico','USA',1505),(4005,'Le Ali della libertà',1994,'135 min','4,3 stelle','CRE','Drammatico','USA',1503),(4007,'La città incantata',2001,'125 min','4,5 stelle','Mikado','Fantasy','Giappone',1507),(4008,'Iron Man',2008,'126 min','4,8 stelle','Universal Pictures','Azione','USA',1508),(4009,'L\'attimo fuggente',1989,'128 min','4,8 stelle','Universal Pictures','Drammatico','USA',1509),(4010,'The Truman Show',1998,'103 min','4,3 stelle','Paramount','Scifi','USA',1509),(4011,'Chiamami col tuo nome',2017,'130 min','4,8 stelle','Sony','Romantico','Francia',1510);
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `film_prog`
--

DROP TABLE IF EXISTS `film_prog`;
/*!50001 DROP VIEW IF EXISTS `film_prog`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `film_prog` AS SELECT 
 1 AS `CPROG`,
 1 AS `FILM`,
 1 AS `GIORNO`,
 1 AS `CINEMA`,
 1 AS `SALA`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `film_programmazione`
--

DROP TABLE IF EXISTS `film_programmazione`;
/*!50001 DROP VIEW IF EXISTS `film_programmazione`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `film_programmazione` AS SELECT 
 1 AS `prezzo`,
 1 AS `CPROG`,
 1 AS `FILM`,
 1 AS `GIORNO`,
 1 AS `CINEMA`,
 1 AS `idcin`,
 1 AS `SALA`,
 1 AS `idreg`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `posti`
--

DROP TABLE IF EXISTS `posti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posti` (
  `codpos` int NOT NULL AUTO_INCREMENT,
  `numfila` int DEFAULT NULL,
  `numcol` int DEFAULT NULL,
  `codsale` int DEFAULT NULL,
  PRIMARY KEY (`codpos`),
  KEY `FK_POST_S` (`codsale`),
  CONSTRAINT `FK_POST_S` FOREIGN KEY (`codsale`) REFERENCES `sale` (`codsale`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14344 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posti`
--

LOCK TABLES `posti` WRITE;
/*!40000 ALTER TABLE `posti` DISABLE KEYS */;
INSERT INTO `posti` VALUES (13844,1,1,52),(13845,1,2,52),(13846,1,3,52),(13847,1,4,52),(13848,1,5,52),(13849,1,6,52),(13850,1,7,52),(13851,1,8,52),(13852,1,9,52),(13853,1,10,52),(13854,2,1,52),(13855,2,2,52),(13856,2,3,52),(13857,2,4,52),(13858,2,5,52),(13859,2,6,52),(13860,2,7,52),(13861,2,8,52),(13862,2,9,52),(13863,2,10,52),(13864,3,1,52),(13865,3,2,52),(13866,3,3,52),(13867,3,4,52),(13868,3,5,52),(13869,3,6,52),(13870,3,7,52),(13871,3,8,52),(13872,3,9,52),(13873,3,10,52),(13874,4,1,52),(13875,4,2,52),(13876,4,3,52),(13877,4,4,52),(13878,4,5,52),(13879,4,6,52),(13880,4,7,52),(13881,4,8,52),(13882,4,9,52),(13883,4,10,52),(13884,5,1,52),(13885,5,2,52),(13886,5,3,52),(13887,5,4,52),(13888,5,5,52),(13889,5,6,52),(13890,5,7,52),(13891,5,8,52),(13892,5,9,52),(13893,5,10,52),(13894,1,1,53),(13895,1,2,53),(13896,1,3,53),(13897,1,4,53),(13898,1,5,53),(13899,1,6,53),(13900,1,7,53),(13901,1,8,53),(13902,1,9,53),(13903,1,10,53),(13904,2,1,53),(13905,2,2,53),(13906,2,3,53),(13907,2,4,53),(13908,2,5,53),(13909,2,6,53),(13910,2,7,53),(13911,2,8,53),(13912,2,9,53),(13913,2,10,53),(13914,3,1,53),(13915,3,2,53),(13916,3,3,53),(13917,3,4,53),(13918,3,5,53),(13919,3,6,53),(13920,3,7,53),(13921,3,8,53),(13922,3,9,53),(13923,3,10,53),(13924,4,1,53),(13925,4,2,53),(13926,4,3,53),(13927,4,4,53),(13928,4,5,53),(13929,4,6,53),(13930,4,7,53),(13931,4,8,53),(13932,4,9,53),(13933,4,10,53),(13934,5,1,53),(13935,5,2,53),(13936,5,3,53),(13937,5,4,53),(13938,5,5,53),(13939,5,6,53),(13940,5,7,53),(13941,5,8,53),(13942,5,9,53),(13943,5,10,53),(13944,1,1,54),(13945,1,2,54),(13946,1,3,54),(13947,1,4,54),(13948,1,5,54),(13949,1,6,54),(13950,1,7,54),(13951,1,8,54),(13952,1,9,54),(13953,1,10,54),(13954,2,1,54),(13955,2,2,54),(13956,2,3,54),(13957,2,4,54),(13958,2,5,54),(13959,2,6,54),(13960,2,7,54),(13961,2,8,54),(13962,2,9,54),(13963,2,10,54),(13964,3,1,54),(13965,3,2,54),(13966,3,3,54),(13967,3,4,54),(13968,3,5,54),(13969,3,6,54),(13970,3,7,54),(13971,3,8,54),(13972,3,9,54),(13973,3,10,54),(13974,4,1,54),(13975,4,2,54),(13976,4,3,54),(13977,4,4,54),(13978,4,5,54),(13979,4,6,54),(13980,4,7,54),(13981,4,8,54),(13982,4,9,54),(13983,4,10,54),(13984,5,1,54),(13985,5,2,54),(13986,5,3,54),(13987,5,4,54),(13988,5,5,54),(13989,5,6,54),(13990,5,7,54),(13991,5,8,54),(13992,5,9,54),(13993,5,10,54),(13994,1,1,55),(13995,1,2,55),(13996,1,3,55),(13997,1,4,55),(13998,1,5,55),(13999,1,6,55),(14000,1,7,55),(14001,1,8,55),(14002,1,9,55),(14003,1,10,55),(14004,2,1,55),(14005,2,2,55),(14006,2,3,55),(14007,2,4,55),(14008,2,5,55),(14009,2,6,55),(14010,2,7,55),(14011,2,8,55),(14012,2,9,55),(14013,2,10,55),(14014,3,1,55),(14015,3,2,55),(14016,3,3,55),(14017,3,4,55),(14018,3,5,55),(14019,3,6,55),(14020,3,7,55),(14021,3,8,55),(14022,3,9,55),(14023,3,10,55),(14024,4,1,55),(14025,4,2,55),(14026,4,3,55),(14027,4,4,55),(14028,4,5,55),(14029,4,6,55),(14030,4,7,55),(14031,4,8,55),(14032,4,9,55),(14033,4,10,55),(14034,5,1,55),(14035,5,2,55),(14036,5,3,55),(14037,5,4,55),(14038,5,5,55),(14039,5,6,55),(14040,5,7,55),(14041,5,8,55),(14042,5,9,55),(14043,5,10,55),(14044,1,1,56),(14045,1,2,56),(14046,1,3,56),(14047,1,4,56),(14048,1,5,56),(14049,1,6,56),(14050,1,7,56),(14051,1,8,56),(14052,1,9,56),(14053,1,10,56),(14054,2,1,56),(14055,2,2,56),(14056,2,3,56),(14057,2,4,56),(14058,2,5,56),(14059,2,6,56),(14060,2,7,56),(14061,2,8,56),(14062,2,9,56),(14063,2,10,56),(14064,3,1,56),(14065,3,2,56),(14066,3,3,56),(14067,3,4,56),(14068,3,5,56),(14069,3,6,56),(14070,3,7,56),(14071,3,8,56),(14072,3,9,56),(14073,3,10,56),(14074,4,1,56),(14075,4,2,56),(14076,4,3,56),(14077,4,4,56),(14078,4,5,56),(14079,4,6,56),(14080,4,7,56),(14081,4,8,56),(14082,4,9,56),(14083,4,10,56),(14084,5,1,56),(14085,5,2,56),(14086,5,3,56),(14087,5,4,56),(14088,5,5,56),(14089,5,6,56),(14090,5,7,56),(14091,5,8,56),(14092,5,9,56),(14093,5,10,56),(14094,1,1,57),(14095,1,2,57),(14096,1,3,57),(14097,1,4,57),(14098,1,5,57),(14099,1,6,57),(14100,1,7,57),(14101,1,8,57),(14102,1,9,57),(14103,1,10,57),(14104,2,1,57),(14105,2,2,57),(14106,2,3,57),(14107,2,4,57),(14108,2,5,57),(14109,2,6,57),(14110,2,7,57),(14111,2,8,57),(14112,2,9,57),(14113,2,10,57),(14114,1,1,58),(14115,1,2,58),(14116,1,3,58),(14117,1,4,58),(14118,1,5,58),(14119,1,6,58),(14120,1,7,58),(14121,1,8,58),(14122,1,9,58),(14123,1,10,58),(14124,2,1,58),(14125,2,2,58),(14126,2,3,58),(14127,2,4,58),(14128,2,5,58),(14129,2,6,58),(14130,2,7,58),(14131,2,8,58),(14132,2,9,58),(14133,2,10,58),(14134,1,1,59),(14135,1,2,59),(14136,1,3,59),(14137,1,4,59),(14138,1,5,59),(14139,1,6,59),(14140,1,7,59),(14141,1,8,59),(14142,1,9,59),(14143,1,10,59),(14144,2,1,59),(14145,2,2,59),(14146,2,3,59),(14147,2,4,59),(14148,2,5,59),(14149,2,6,59),(14150,2,7,59),(14151,2,8,59),(14152,2,9,59),(14153,2,10,59),(14154,1,1,60),(14155,1,2,60),(14156,1,3,60),(14157,1,4,60),(14158,1,5,60),(14159,1,6,60),(14160,1,7,60),(14161,1,8,60),(14162,1,9,60),(14163,1,10,60),(14164,2,1,60),(14165,2,2,60),(14166,2,3,60),(14167,2,4,60),(14168,2,5,60),(14169,2,6,60),(14170,2,7,60),(14171,2,8,60),(14172,2,9,60),(14173,2,10,60),(14174,1,1,61),(14175,1,2,61),(14176,1,3,61),(14177,1,4,61),(14178,1,5,61),(14179,1,6,61),(14180,1,7,61),(14181,1,8,61),(14182,1,9,61),(14183,1,10,61),(14184,2,1,61),(14185,2,2,61),(14186,2,3,61),(14187,2,4,61),(14188,2,5,61),(14189,2,6,61),(14190,2,7,61),(14191,2,8,61),(14192,2,9,61),(14193,2,10,61),(14194,1,1,62),(14195,1,2,62),(14196,1,3,62),(14197,1,4,62),(14198,1,5,62),(14199,1,6,62),(14200,1,7,62),(14201,1,8,62),(14202,1,9,62),(14203,1,10,62),(14204,2,1,62),(14205,2,2,62),(14206,2,3,62),(14207,2,4,62),(14208,2,5,62),(14209,2,6,62),(14210,2,7,62),(14211,2,8,62),(14212,2,9,62),(14213,2,10,62),(14214,1,1,63),(14215,1,2,63),(14216,1,3,63),(14217,1,4,63),(14218,1,5,63),(14219,1,6,63),(14220,1,7,63),(14221,1,8,63),(14222,1,9,63),(14223,1,10,63),(14224,2,1,63),(14225,2,2,63),(14226,2,3,63),(14227,2,4,63),(14228,2,5,63),(14229,2,6,63),(14230,2,7,63),(14231,2,8,63),(14232,2,9,63),(14233,2,10,63),(14234,1,1,64),(14235,1,2,64),(14236,1,3,64),(14237,1,4,64),(14238,1,5,64),(14239,1,6,64),(14240,1,7,64),(14241,1,8,64),(14242,1,9,64),(14243,1,10,64),(14244,2,1,64),(14245,2,2,64),(14246,2,3,64),(14247,2,4,64),(14248,2,5,64),(14249,2,6,64),(14250,2,7,64),(14251,2,8,64),(14252,2,9,64),(14253,2,10,64),(14254,1,1,65),(14255,1,2,65),(14256,1,3,65),(14257,1,4,65),(14258,1,5,65),(14259,1,6,65),(14260,1,7,65),(14261,1,8,65),(14262,1,9,65),(14263,1,10,65),(14264,2,1,65),(14265,2,2,65),(14266,2,3,65),(14267,2,4,65),(14268,2,5,65),(14269,2,6,65),(14270,2,7,65),(14271,2,8,65),(14272,2,9,65),(14273,2,10,65),(14274,1,1,66),(14275,1,2,66),(14276,1,3,66),(14277,1,4,66),(14278,1,5,66),(14279,1,6,66),(14280,1,7,66),(14281,1,8,66),(14282,1,9,66),(14283,1,10,66),(14284,2,1,66),(14285,2,2,66),(14286,2,3,66),(14287,2,4,66),(14288,2,5,66),(14289,2,6,66),(14290,2,7,66),(14291,2,8,66),(14292,2,9,66),(14293,2,10,66);
/*!40000 ALTER TABLE `posti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `prenotazioni`
--

DROP TABLE IF EXISTS `prenotazioni`;
/*!50001 DROP VIEW IF EXISTS `prenotazioni`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `prenotazioni` AS SELECT 
 1 AS `FILM`,
 1 AS `GIORNO`,
 1 AS `CINEMA`,
 1 AS `SALA`,
 1 AS `NUMFILA`,
 1 AS `NUMCOL`,
 1 AS `DATAEMISS`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `prog_posl`
--

DROP TABLE IF EXISTS `prog_posl`;
/*!50001 DROP VIEW IF EXISTS `prog_posl`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `prog_posl` AS SELECT 
 1 AS `CODPROG`,
 1 AS `NUMFILA`,
 1 AS `NUMCOL`,
 1 AS `CODPOS`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `programmazioni`
--

DROP TABLE IF EXISTS `programmazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programmazioni` (
  `codprog` int NOT NULL AUTO_INCREMENT,
  `giorno` timestamp NULL DEFAULT NULL,
  `prezzo` varchar(7) DEFAULT NULL,
  `idf` int DEFAULT NULL,
  `codsale` int DEFAULT NULL,
  `dinizio` date DEFAULT NULL,
  `dfine` date DEFAULT NULL,
  PRIMARY KEY (`codprog`),
  UNIQUE KEY `UNICITà` (`giorno`,`codsale`)
) ENGINE=InnoDB AUTO_INCREMENT=343 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programmazioni`
--

LOCK TABLES `programmazioni` WRITE;
/*!40000 ALTER TABLE `programmazioni` DISABLE KEYS */;
INSERT INTO `programmazioni` VALUES (327,'2021-09-24 19:00:00','8',4000,52,'2021-09-24','2021-09-24'),(328,'2021-09-24 21:00:00','8',4002,52,'2021-09-24','2021-09-24'),(329,'2021-09-24 16:00:00','8',4008,53,'2021-09-24','2021-09-24'),(330,'2021-09-24 16:00:00','8',4004,66,'2021-09-24','2021-09-24'),(331,'2021-09-24 19:00:00','8',4003,61,'2021-09-24','2021-09-24'),(332,'2021-09-24 17:00:00','8',4005,56,'2021-09-24','2021-09-24'),(333,'2021-09-24 16:00:00','11',4010,57,'2021-09-24','2021-09-24'),(334,'2021-09-25 17:00:00','11',4002,66,'2021-09-25','2021-09-25'),(335,'2021-09-26 16:00:00','8',4004,64,'2021-09-26','2021-09-26'),(336,'2021-09-27 18:00:00','12',4007,59,'2021-09-27','2021-09-27'),(337,'2021-09-28 16:00:00','6',4010,60,'2021-09-28','2021-09-28'),(338,'2021-09-29 17:00:00','12',4011,65,'2021-09-29','2021-09-29'),(339,'2021-09-30 19:00:00','12',4000,52,'2021-09-30','2021-09-30'),(340,'2021-09-30 16:00:00','12',4010,52,'2021-09-30','2021-09-30'),(341,'2021-09-28 15:00:00','8',4008,64,'2021-09-28','2021-09-28'),(342,'2021-09-29 15:00:00','9',4005,65,'2021-09-29','2021-09-29');
/*!40000 ALTER TABLE `programmazioni` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `programmazioni_BEFORE_INSERT` BEFORE INSERT ON `programmazioni` FOR EACH ROW BEGIN
 IF(NEW.dinizio<SYSDATE()) THEN
 signal sqlstate '45000' set message_text= 'data non valida: la data d inizio non dev essere minore di quella odierna';
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Conserva_Biglietti` AFTER DELETE ON `programmazioni` FOR EACH ROW BEGIN
DECLARE done INT DEFAULT FALSE;
DECLARE USERNAME varchar(20);
declare FIL varchar(50);
declare COD int(7);
declare FILA int(2);
declare COLONNA int(2);
declare DATAEMISS date;
declare CINEM varchar(20);
declare NUMSALA int(2);

declare CUR cursor for SELECT BI.DATAEMISS, BI.USERNAME, BI.IDB FROM BIGLIETTI BI WHERE BI.CODPROG=OLD.CODPROG;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
OPEN CUR; bloop: LOOP FETCH CUR INTO DATAEMISS, USERNAME, COD;
IF done THEN
LEAVE bloop;
END IF;
SELECT FI.NOME INTO FIL FROM FILM FI WHERE FI.IDF=OLD.IDF;
SELECT SA.NUMS INTO NUMSALA FROM SALE SA WHERE SA.CODSALE=OLD.CODSALE;
SELECT CIN.NOME INTO CINEM FROM CINEMA CIN JOIN SALE SA ON CIN.IDCIN=SA.IDCIN WHERE SA.CODSALE=OLD.CODSALE;
SELECT PO.NUMFILA INTO FILA FROM BIGLIETTI BI JOIN POSTI PO ON BI.CODPOS=PO.CODPOS WHERE BI.CODPROG=OLD.CODPROG AND BI.IDB=COD;
SELECT PO.NUMCOL INTO COLONNA FROM BIGLIETTI BI JOIN POSTI PO ON BI.CODPOS=PO.CODPOS WHERE BI.CODPROG=OLD.CODPROG AND BI.IDB=COD;
INSERT INTO BIGLIETTI_STORICO VALUES (COD, USERNAME, FIL,OLD.GIORNO,CINEM,NUMSALA, FILA,COLONNA,DATAEMISS);
END LOOP;
CLOSE CUR;
DELETE from BIGLIETTI BI WHERE BI.CODPROG=OLD.CODPROG;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `recitazioni`
--

DROP TABLE IF EXISTS `recitazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recitazioni` (
  `idatt` int NOT NULL,
  `idf` int NOT NULL,
  PRIMARY KEY (`idatt`,`idf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recitazioni`
--

LOCK TABLES `recitazioni` WRITE;
/*!40000 ALTER TABLE `recitazioni` DISABLE KEYS */;
INSERT INTO `recitazioni` VALUES (150,4002),(151,4001),(152,4000),(153,4000),(154,4006),(154,4007),(155,4005),(156,4011),(157,4006),(162,4004),(162,4009);
/*!40000 ALTER TABLE `recitazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registi`
--

DROP TABLE IF EXISTS `registi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registi` (
  `idreg` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  `cognome` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idreg`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  UNIQUE KEY `cognome_UNIQUE` (`cognome`)
) ENGINE=InnoDB AUTO_INCREMENT=1515 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registi`
--

LOCK TABLES `registi` WRITE;
/*!40000 ALTER TABLE `registi` DISABLE KEYS */;
INSERT INTO `registi` VALUES (1501,'Federico','Fellini'),(1502,'Massimo ','Troisi'),(1503,'Frank ','Darabont'),(1504,'Brian','De Palma'),(1505,'Martin','Scorsese'),(1506,'Paolo','Sorrentino'),(1507,'Hayao ','Miyazaki'),(1508,'Jon','Frevaur'),(1509,'Peter ','Weir'),(1510,'Luca','Guadagnino');
/*!40000 ALTER TABLE `registi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale` (
  `codsale` int NOT NULL AUTO_INCREMENT,
  `nums` int NOT NULL,
  `superficie` varchar(20) DEFAULT 'Non disponibile',
  `capienza` int DEFAULT NULL,
  `idcin` int NOT NULL,
  PRIMARY KEY (`codsale`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (52,1,'350.0cm2',50,1),(53,2,'350.0cm2',50,1),(54,3,'350.0cm2',50,1),(55,4,'350.0cm2',50,1),(56,5,'350.0cm2',50,1),(57,1,'300.0cm2',20,2),(58,2,'300.0cm2',20,2),(59,3,'300.0cm2',20,2),(60,4,'300.0cm2',20,2),(61,5,'300.0cm2',20,2),(62,1,'300.0cm2',20,3),(63,2,'300.0cm2',20,3),(64,3,'300.0cm2',20,3),(65,4,'300.0cm2',20,3),(66,5,'300.0cm2',20,3);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefoni`
--

DROP TABLE IF EXISTS `telefoni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefoni` (
  `numero` varchar(10) NOT NULL,
  `idcin` int NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefoni`
--

LOCK TABLES `telefoni` WRITE;
/*!40000 ALTER TABLE `telefoni` DISABLE KEYS */;
INSERT INTO `telefoni` VALUES ('555-3434',3),('555-4324',2),('555-4353',1);
/*!40000 ALTER TABLE `telefoni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti`
--

DROP TABLE IF EXISTS `utenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utenti` (
  `username` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(8) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
INSERT INTO `utenti` VALUES ('user','user','User','user@user.it','user');
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'progetto'
--

--
-- Dumping routines for database 'progetto'
--

--
-- Final view structure for view `bigliettiacquistati`
--

/*!50001 DROP VIEW IF EXISTS `bigliettiacquistati`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `bigliettiacquistati` AS select `biglietti`.`username` AS `username`,`biglietti`.`codpos` AS `codpos`,`biglietti`.`idb` AS `idb`,`biglietti`.`dataemiss` AS `dataemiss`,`film_prog`.`GIORNO` AS `giorno`,`film_prog`.`FILM` AS `FILM` from (`film_prog` join `biglietti` on((`film_prog`.`CPROG` = `biglietti`.`codprog`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `film_prog`
--

/*!50001 DROP VIEW IF EXISTS `film_prog`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `film_prog` AS select `pr`.`codprog` AS `CPROG`,`fi`.`nome` AS `FILM`,`pr`.`giorno` AS `GIORNO`,`ci`.`nome` AS `CINEMA`,`sa`.`nums` AS `SALA` from (((`film` `fi` join `programmazioni` `pr` on((`fi`.`idf` = `pr`.`idf`))) join `sale` `sa` on((`pr`.`codsale` = `sa`.`codsale`))) join `cinema` `ci` on((`sa`.`idcin` = `ci`.`idcin`))) order by `pr`.`giorno` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `film_programmazione`
--

/*!50001 DROP VIEW IF EXISTS `film_programmazione`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `film_programmazione` AS select `pr`.`prezzo` AS `prezzo`,`pr`.`codprog` AS `CPROG`,`fi`.`nome` AS `FILM`,`pr`.`giorno` AS `GIORNO`,`ci`.`nome` AS `CINEMA`,`ci`.`idcin` AS `idcin`,`sa`.`nums` AS `SALA`,`fi`.`idreg` AS `idreg` from (((`film` `fi` join `programmazioni` `pr` on((`fi`.`idf` = `pr`.`idf`))) join `sale` `sa` on((`pr`.`codsale` = `sa`.`codsale`))) join `cinema` `ci` on((`sa`.`idcin` = `ci`.`idcin`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `prenotazioni`
--

/*!50001 DROP VIEW IF EXISTS `prenotazioni`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `prenotazioni` AS select `fp`.`FILM` AS `FILM`,`fp`.`GIORNO` AS `GIORNO`,`fp`.`CINEMA` AS `CINEMA`,`fp`.`SALA` AS `SALA`,`po`.`numfila` AS `NUMFILA`,`po`.`numcol` AS `NUMCOL`,`bi`.`dataemiss` AS `DATAEMISS` from ((`film_prog` `fp` join `biglietti` `bi` on((`fp`.`CPROG` = `bi`.`codprog`))) join `posti` `po` on((`bi`.`codpos` = `po`.`codpos`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `prog_posl`
--

/*!50001 DROP VIEW IF EXISTS `prog_posl`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `prog_posl` AS select `pr`.`codprog` AS `CODPROG`,`po`.`numfila` AS `NUMFILA`,`po`.`numcol` AS `NUMCOL`,`po`.`codpos` AS `CODPOS` from ((((`film` `fi` join `programmazioni` `pr` on((`fi`.`idf` = `pr`.`idf`))) join `sale` `sa` on((`pr`.`codsale` = `sa`.`codsale`))) join `cinema` `ci` on((`sa`.`idcin` = `ci`.`idcin`))) join `posti` `po` on((`sa`.`codsale` = `po`.`codsale`))) where (`po`.`codpos`,`pr`.`codprog`) in (select `bi`.`codpos`,`bi`.`codprog` from `biglietti` `bi`) is false order by `pr`.`codprog` */;
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

-- Dump completed on 2021-09-23 13:39:54
