-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bayensolutions
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Dumping data for table `artikal`
--

LOCK TABLES `artikal` WRITE;
/*!40000 ALTER TABLE `artikal` DISABLE KEYS */;
INSERT INTO `artikal` VALUES (1,'Bazen 700x125 (UV folija)',2800.00,'Bazen sa 150-mikronskom UV folijom. U cijenu je uračunata montaža.'),(2,'Bazen 600x125 (UV folija)',2600.00,'Bazen sa 150-mikronskom UV folijom. U cijenu je uračunata montaža.'),(3,'Bazen 540x125 (UV folija)',2200.00,'Bazen sa 150-mikronskom UV folijom. U cijenu je uračunata montaža.'),(4,'Bazen 500x125 (UV folija) ',2100.00,'Bazen sa 150-mikronskom UV folijom. U cijenu je uračunata montaža.'),(5,'Bazen 360x125 (UV folija)',1800.00,'Bazen sa 150-mikronskom UV folijom. U cijenu je uračunata montaža.'),(6,'Pumpa sa pješčanim filterom 10500 l/h',550.00,'Pumpa proizvođača INTEX protoka 10500 l/h. Uz pumpu se dobija izlazna mlaznica.'),(7,'Pumpa sa pješčanim filterom 7900 l/h',450.00,'Pumpa proizvođača INTEX protoka 7900 l/h. Uz pumpu se dobija izlazna mlaznica.'),(8,'Pumpa sa pješčanim filterom 4500 l/h',350.00,'Pumpa proizvođača INTEX protoka 4500 l/h. Uz pumpu se dobija izlazna mlaznica.'),(9,'Zidna mlaznica',50.00,'Ulazno-izlazna mlaznica proizvođača ASTRAL.'),(10,'Kvarcni pijesak granulacije 0.4-0.8 (25 kg)',50.00,'Kvarcni pijesak granulacije 0.4 - 0.8 mm proizvođača ASTRALPOOL.'),(11,'Merdevine sa duplim ojačanjem i završnim stepenikom visine 125 cm',140.00,'Merdevine sa 4 stepenika i završnim stepenikom za skakanje.'),(12,'Merdevine sa 3 stepenika visine 125 cm',100.00,'Merdevine sa 3 stepenika bez završnog stepenika za skakanje.'),(13,'Merdevine sa 4 stepenika visine 135 cm',130.00,'Merdevine sa 4 stepenika bez završnog stepenika za skakanje.'),(14,'Hlor BelChlor Tabs 20',20.00,'Tablete hlora za doziranje bazena zapremine do 25 m^3.'),(15,'Hlor BelMulti Tabs 20',25.00,'Tablete hlora sa flokulantima i algicidima za doziranje bazena zapremine do 25 m^3.'),(16,'Hlor BelChlor Tabs 200',20.00,'Tablete hlora za doziranje bazena zapremine preko 25 m^3.'),(17,'Hlor BelMulti Tabs 200',25.00,'Tablete hlora sa flokulantima i algicidima za doziranje bazena zapremine preko 25 m^3.'),(18,'Algicid BelAlgin 1 l',10.00,'Sredstvo za sprečavanje razmnožavanja algi u vodi'),(19,'Set za čišćenje - osnovni paket',60.00,'Uključuje teleskopski štap sa nastavkom za dvorišno crijevo i mrežicu za sakupljanje insekata i lišća'),(20,'Platforma površine 12 m^2 za bazen prečnika 600 cm',6000.00,'Platforma sa podestom od sibirskog ariša uključuje elemente: stepenice, ogradu po izboru, bočne rešetke sa ulaznim vratima i rosfrajne merdevine za ulazak u bazen'),(21,'Obloga od smrekovih poluoblica za bazen prečnika 600 cm',160.00,'Cijena se računa po metru obima bazena'),(22,'Završna lajsna od sibirskog ariša za bazen prečnika 600 cm',50.00,'Cijena se računa po metru obima bazena'),(31,'naziv',10000.00,'opis'),(32,'obloga',5000.00,'opis'),(33,'test',0.00,'ym'),(34,'jsefn',485.00,'dlkfmdkf'),(35,'Vanja',12.00,'Intex Vanja');
/*!40000 ALTER TABLE `artikal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `artikal_sadrži_materijal`
--

LOCK TABLES `artikal_sadrži_materijal` WRITE;
/*!40000 ALTER TABLE `artikal_sadrži_materijal` DISABLE KEYS */;
/*!40000 ALTER TABLE `artikal_sadrži_materijal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bazen`
--

LOCK TABLES `bazen` WRITE;
/*!40000 ALTER TABLE `bazen` DISABLE KEYS */;
INSERT INTO `bazen` VALUES (1),(2),(3),(4),(5);
/*!40000 ALTER TABLE `bazen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kompanija`
--

LOCK TABLES `kompanija` WRITE;
/*!40000 ALTER TABLE `kompanija` DISABLE KEYS */;
/*!40000 ALTER TABLE `kompanija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `materijal`
--

LOCK TABLES `materijal` WRITE;
/*!40000 ALTER TABLE `materijal` DISABLE KEYS */;
INSERT INTO `materijal` VALUES (1,'Armaturna mreža Q131 5 mm',20.50,5,1),(2,'Željezna cijev fi 33,4 mm',40.00,5,1),(3,'Pijesak granulacije nula',800.00,4,2),(4,'Lim 22,5 x 1,25',1.00,5,3),(5,'Lim 16,0 x 1,25',1.00,5,3),(6,'Lim 12,0 x 1,25',2.00,5,3),(8,'Žabica 40x40',200.00,5,1),(9,'BelChlor Tabs 20',7.00,4,4),(10,'BelMulti Tabs 20',10.00,4,4);
/*!40000 ALTER TABLE `materijal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mjerna_jedinica`
--

LOCK TABLES `mjerna_jedinica` WRITE;
/*!40000 ALTER TABLE `mjerna_jedinica` DISABLE KEYS */;
INSERT INTO `mjerna_jedinica` VALUES (1,'m'),(2,'m^2'),(3,'m^3'),(4,'kg'),(5,'kom.');
/*!40000 ALTER TABLE `mjerna_jedinica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mjesto`
--

LOCK TABLES `mjesto` WRITE;
/*!40000 ALTER TABLE `mjesto` DISABLE KEYS */;
INSERT INTO `mjesto` VALUES ('71240','Hadžići'),('71250','Kiseljak'),('72283','Turbe'),('75300','Lukavac'),('78000','Banja Luka');
/*!40000 ALTER TABLE `mjesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `montažni_artikal`
--

LOCK TABLES `montažni_artikal` WRITE;
/*!40000 ALTER TABLE `montažni_artikal` DISABLE KEYS */;
INSERT INTO `montažni_artikal` VALUES (1,7.00,1.25),(2,6.00,1.25),(3,5.40,1.25),(4,5.00,1.25),(5,3.60,1.25),(20,6.00,1.25),(21,6.00,1.25),(22,6.00,1.25),(31,8.00,1.00),(32,8.00,1.00),(34,5.00,5.00);
/*!40000 ALTER TABLE `montažni_artikal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `narudžba`
--

LOCK TABLES `narudžba` WRITE;
/*!40000 ALTER TABLE `narudžba` DISABLE KEYS */;
INSERT INTO `narudžba` VALUES (311,'2023-02-17 17:00:15',1,0.00,'saarajevoooooo',3),(323,'2023-02-17 17:00:37',1,-1900.00,'husosrbine',2),(341,'2023-02-17 16:21:29',1,6650.00,'patre 6969',7),(345,'2023-02-17 15:51:00',1,17600.00,'TEST 123',37),(346,'2023-02-17 17:01:18',1,9800.00,'testic123',37),(350,'2023-02-19 11:52:01',0,8990.00,'Turbe 24',2),(351,'2023-02-19 16:29:18',0,0.00,'erfe',2),(352,'2023-02-19 21:03:12',0,7750.00,'',3),(353,'2023-02-19 21:14:11',0,0.00,'',3),(354,'2023-02-19 21:14:39',0,0.00,'',7),(355,'2023-02-19 21:15:54',0,0.00,'',2),(356,'2023-02-19 21:16:36',0,0.00,'',7),(357,'2023-02-19 21:20:04',0,0.00,'',7),(358,'2023-02-19 21:22:11',0,0.00,'',7),(359,'2023-02-19 21:23:36',0,0.00,'',12),(360,'2023-02-19 21:24:10',0,0.00,'',12),(361,'2023-02-19 21:25:03',0,0.00,'',12);
/*!40000 ALTER TABLE `narudžba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `narudžbenica`
--

LOCK TABLES `narudžbenica` WRITE;
/*!40000 ALTER TABLE `narudžbenica` DISABLE KEYS */;
INSERT INTO `narudžbenica` VALUES (1,0,'2022-12-16 21:49:00',1,NULL),(2,0,'2022-12-16 21:49:49',2,1),(4,0,'2022-12-16 22:23:54',1,1),(5,0,'2022-12-16 22:28:06',2,1),(6,0,'2022-12-19 21:08:34',3,1);
/*!40000 ALTER TABLE `narudžbenica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `narudžbenica_ima_materijal`
--

LOCK TABLES `narudžbenica_ima_materijal` WRITE;
/*!40000 ALTER TABLE `narudžbenica_ima_materijal` DISABLE KEYS */;
INSERT INTO `narudžbenica_ima_materijal` VALUES (1,1,2.00,49.00),(1,4,1.00,382.50),(1,5,1.00,272.00),(1,6,2.00,204.00),(6,9,5.00,13.60),(6,10,5.00,16.90);
/*!40000 ALTER TABLE `narudžbenica_ima_materijal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `obloga`
--

LOCK TABLES `obloga` WRITE;
/*!40000 ALTER TABLE `obloga` DISABLE KEYS */;
INSERT INTO `obloga` VALUES ('Smreka',21),('Sibirski ariš',22),('trska',32),('drvo',34);
/*!40000 ALTER TABLE `obloga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `oprema`
--

LOCK TABLES `oprema` WRITE;
/*!40000 ALTER TABLE `oprema` DISABLE KEYS */;
INSERT INTO `oprema` VALUES (24,6,1,1),(24,7,1,1),(24,8,1,1),(36,9,2,2),(0,10,3,2),(24,11,4,1),(24,12,4,1),(24,13,4,1),(0,14,5,3),(0,15,5,3),(0,16,5,3),(0,17,5,3),(0,18,5,3),(24,19,6,1),(1,33,2,1),(12,35,1,1);
/*!40000 ALTER TABLE `oprema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `osoba`
--

LOCK TABLES `osoba` WRITE;
/*!40000 ALTER TABLE `osoba` DISABLE KEYS */;
INSERT INTO `osoba` VALUES (1,'Slobodan','Jelić','065 535-208','78000'),(2,'Husein','Šakić','061 751-377','72283'),(3,'Anando','Halilović','063 891-086','71250'),(4,'Aleksandar','Jelić','065 371-432','78000'),(7,'Almir','Bektić','061 232-439','75300'),(12,'Muamer','Kavazović','061 213-016','71240'),(15,'Nikola','Gak','000 000-000','78000'),(31,'a','a','06666666','78000'),(37,'Vanja','Đenadija','065 625-488','78000'),(48,'Vanja','Vanjić','065 455 633','78000'),(49,'Vanja','Vanjić','065625488','78000');
/*!40000 ALTER TABLE `osoba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `partnerska_kompanija`
--

LOCK TABLES `partnerska_kompanija` WRITE;
/*!40000 ALTER TABLE `partnerska_kompanija` DISABLE KEYS */;
INSERT INTO `partnerska_kompanija` VALUES (1,'Limocentar d.o.o.','Put srpskih branilaca 115, Banja Luka','limocentardoo@gmail.com','051 370-694'),(2,'Abi d.o.o.','Ulica generala Izeta Nanića b.b. Novi Grad','abi@gmail.com','065 480-923'),(3,'Belif d.o.o.','Poslovna zona Ciglana br. 14 Jelah','info@belif.ba','032 664-555');
/*!40000 ALTER TABLE `partnerska_kompanija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `platforma`
--

LOCK TABLES `platforma` WRITE;
/*!40000 ALTER TABLE `platforma` DISABLE KEYS */;
INSERT INTO `platforma` VALUES (12.00,'Sibirski ariš',20),(12.34,'arisss',31);
/*!40000 ALTER TABLE `platforma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `proizvođač_opreme`
--

LOCK TABLES `proizvođač_opreme` WRITE;
/*!40000 ALTER TABLE `proizvođač_opreme` DISABLE KEYS */;
INSERT INTO `proizvođač_opreme` VALUES (1,'Intex'),(2,'Astral'),(3,'Belif');
/*!40000 ALTER TABLE `proizvođač_opreme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stavka`
--

LOCK TABLES `stavka` WRITE;
/*!40000 ALTER TABLE `stavka` DISABLE KEYS */;
INSERT INTO `stavka` VALUES (323,1,1),(323,2,1),(341,3,1),(341,4,1),(341,5,1),(341,6,1),(345,1,2),(345,2,3),(345,3,1),(345,9,6),(345,14,5),(345,18,6),(345,19,7),(345,21,7),(346,1,1),(346,3,1),(350,1,3),(350,6,1),(350,16,2),(352,6,2),(352,20,1),(352,22,13);
/*!40000 ALTER TABLE `stavka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tip_opreme`
--

LOCK TABLES `tip_opreme` WRITE;
/*!40000 ALTER TABLE `tip_opreme` DISABLE KEYS */;
INSERT INTO `tip_opreme` VALUES (1,'Pumpa sa pješčanim filterom'),(2,'Zidna mlaznica'),(3,'Kvarcni pijesak'),(4,'Merdevine'),(5,'Hemikalije'),(6,'Čistač');
/*!40000 ALTER TABLE `tip_opreme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `uloga_zaposlenog`
--

LOCK TABLES `uloga_zaposlenog` WRITE;
/*!40000 ALTER TABLE `uloga_zaposlenog` DISABLE KEYS */;
INSERT INTO `uloga_zaposlenog` VALUES (1,'Montažer'),(2,'Skladišni radnik'),(3,'Direktor');
/*!40000 ALTER TABLE `uloga_zaposlenog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vrsta_materijala`
--

LOCK TABLES `vrsta_materijala` WRITE;
/*!40000 ALTER TABLE `vrsta_materijala` DISABLE KEYS */;
INSERT INTO `vrsta_materijala` VALUES (1,'željezo'),(2,'pijesak'),(3,'lim'),(4,'hemikalije');
/*!40000 ALTER TABLE `vrsta_materijala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `zaposleni`
--

LOCK TABLES `zaposleni` WRITE;
/*!40000 ALTER TABLE `zaposleni` DISABLE KEYS */;
INSERT INTO `zaposleni` VALUES ('BOBI','bobilica',2000.00,'0105972113243',1,1),('bayen','bayen',0.00,'1404998100019',4,3),('komso','gak',50.00,'0000000000000',15,2),('a','a',0.00,'0',31,1),('vanja123','vanja123',1000.00,'1234567891234',49,3);
/*!40000 ALTER TABLE `zaposleni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `zaposleni_montira_montažni_artikal`
--

LOCK TABLES `zaposleni_montira_montažni_artikal` WRITE;
/*!40000 ALTER TABLE `zaposleni_montira_montažni_artikal` DISABLE KEYS */;
/*!40000 ALTER TABLE `zaposleni_montira_montažni_artikal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bayensolutions'
--
/*!50003 DROP PROCEDURE IF EXISTS `brisanjeMaterijala` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `brisanjeMaterijala`(in pIdMaterijal INTEGER)
BEGIN
    DELETE FROM materijal m WHERE m.IdMaterijal=pIdMaterijal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `brisanjeNarudžbe` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `brisanjeNarudžbe`(in pIdNarudžba INTEGER)
BEGIN
	DELETE FROM stavka s WHERE s.NARUDŽBA_IdNarudžba=pIdNarudžba;
    DELETE FROM narudžba n WHERE n.IdNarudžba=pIdNarudžba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `brisanjeOsobe` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `brisanjeOsobe`(in pIdOsoba INTEGER)
BEGIN
    DELETE FROM osoba o WHERE o.IdOsoba=pIdOsoba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `brisanjeStavke` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `brisanjeStavke`(in pIdNarudžba INTEGER, in pIdArtikal INTEGER)
BEGIN
	DELETE FROM stavka s WHERE s.NARUDŽBA_IdNarudžba=pIdNarudžba AND s.ARTIKAL_IdArtikal=pIdArtikal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `brisanjeZaposlenog` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `brisanjeZaposlenog`(in pIdOsoba INTEGER)
BEGIN
    DELETE FROM zaposleni z WHERE z.OSOBA_IdOsoba=pIdOsoba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dodavanjeArtiklaUNarudžbu` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodavanjeArtiklaUNarudžbu`(in pIdNarudžba INTEGER, in pIdArtikal INTEGER, in pKoličina INTEGER)
BEGIN
    INSERT INTO stavka(NARUDŽBA_IdNarudžba, ARTIKAL_IdArtikal, Količina) VALUES (pIdNarudžba,pIdArtikal,pKoličina);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dodavanjeMaterijala` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodavanjeMaterijala`(in pNaziv VARCHAR(100), in pKoličina DECIMAL(5,2), in pIdMjernaJedinica TINYINT, in pIdVrsteMaterijala TINYINT)
BEGIN
    INSERT INTO materijal(Naziv, Količina, MJERNA_JEDINICA_IdMjernaJedinica, VRSTA_MATERIJALA_IdVrsteMaterijala) VALUES (pNaziv,pKoličina,pIdMjernaJedinica,pIdVrsteMaterijala);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dodavanjeMaterijalaNaNarudžbenicu` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodavanjeMaterijalaNaNarudžbenicu`(in pIdNarudžbenica INTEGER, in pIdMaterijal INTEGER, in pKoličina DECIMAL(5,2), in pNabavnaCijena DECIMAL(6,2))
BEGIN
    INSERT INTO narudžbenica_ima_materijal(NARUDŽBENICA_IdNarudžbenica, MATERIJAL_IdMaterijal, Količina, NabavnaCijena) VALUES (pIdNarudžbenica,pIdMaterijal,pKoličina,pNabavnaCijena);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dodavanjeOsobe` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodavanjeOsobe`(in pIme VARCHAR(50), in pPrezime VARCHAR(50), in pTelefon VARCHAR(15), in pPoštanskiBroj VARCHAR(5), out pIndeks INTEGER)
BEGIN
    INSERT INTO osoba(Ime, Prezime, Telefon, MJESTO_PoštanskiBroj) VALUES (pIme, pPrezime, pTelefon, pPoštanskiBroj);
    SET pIndeks=last_insert_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dodavanjeZaposlenog` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dodavanjeZaposlenog`(in pIdOsoba INTEGER, in pKorisničkoIme VARCHAR(50), in pOtisakLozinke VARCHAR(512), in pPlata DECIMAL(6,2), in pJMBG VARCHAR(13), in pIdUloga TINYINT)
BEGIN
    INSERT INTO zaposleni(OSOBA_IdOsoba, KorisničkoIme, OtisakLozinke, Plata, JMBG, ULOGA_ZAPOSLENOG_IdUloga) VALUES (pIdOsoba, pKorisničkoIme, pOtisakLozinke, pPlata, pJMBG, pIdUloga);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeArtikalaUNarudžbi` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeArtikalaUNarudžbi`(in pIdNarudžba INTEGER)
BEGIN
	SELECT s.Narudžba_IdNarudžba as "Broj narudžbe", o.IdOsoba as "ID osobe", o.Ime as "Ime kupca", o.Prezime as "Prezime kupca", o.Telefon as "Broj telefona", m.PoštanskiBroj as "Poštanski broj", m.Naziv as "Naziv mjesta", n.Datum as "Vrijeme narudžbe", n.UkupnaCijena as "Ukupna cijena", n.AdresaMontaže as "Adresa montaže", a.IdArtikal as "Šifra artikla", a.Naziv as "Naziv artikla", a.Cijena as "Cijena", a.Opis as "Opis", s.Količina as "Količina", n.Status as "Status"
	FROM stavka s INNER JOIN narudžba n on n.IdNarudžba=s.NARUDŽBA_IdNarudžba AND s.NARUDŽBA_IdNarudžba=pIdNarudžba INNER JOIN osoba o on o.IdOsoba=n.OSOBA_IdOsoba INNER JOIN mjesto m ON m.PoštanskiBroj=o.MJESTO_PoštanskiBroj INNER JOIN artikal a ON a.IdArtikal=s.ARTIKAL_IdArtikal
    ORDER BY a.IdArtikal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeArtikla` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeArtikla`(in pIdArtikal INTEGER)
BEGIN
	SELECT * FROM artikal a WHERE a.IdArtikal=pIdArtikal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeKoličineICijeneArtikala` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeKoličineICijeneArtikala`(in pIdNarudžba INT)
BEGIN
	SELECT a.Cijena, s.Količina
    FROM narudžba n
    INNER JOIN stavka s ON n.IdNarudžba=s.NARUDŽBA_IdNarudžba
    INNER JOIN artikal a ON s.ARTIKAL_IdArtikal=a.IdArtikal
    WHERE n.IdNarudžba=pIdNarudžba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeMaterijalaNaNarudžbenici` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeMaterijalaNaNarudžbenici`(in pIdNarudžbenica INTEGER)
BEGIN
	SELECT nia.NARUDŽBENICA_IdNarudžbenica, n.Status, n.VrijemeKupovine, n.PARTNERSKA_KOMPANIJA_IdPartnerskaKompanija, pk.Naziv as "Naziv partnerske kompanije", n.ZAPOSLENI_OSOBA_IdOsoba, nia.MATERIJAL_IdMaterijal, m.Naziv,m.MJERNA_JEDINICA_IdMjernaJedinica, mj.Oznaka, nia.Količina, nia.NabavnaCijena  
	FROM narudžbenica_ima_materijal nia INNER JOIN narudžbenica n on nia.NARUDŽBENICA_IdNarudžbenica=pIdNarudžbenica AND nia.NARUDŽBENICA_IdNarudžbenica=n.IdNarudžbenica INNER JOIN materijal m on nia.MATERIJAL_IdMaterijal=m.IdMaterijal INNER JOIN mjerna_jedinica mj ON m.MJERNA_JEDINICA_IdMjernaJedinica=mj.IdMjernaJedinica INNER JOIN partnerska_kompanija pk ON n.PARTNERSKA_KOMPANIJA_IdPartnerskaKompanija=pk.IdPartnerskaKompanija
    ORDER BY m.Naziv;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeMjesta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeMjesta`()
BEGIN
	SELECT * FROM mjesto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSveOpreme` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSveOpreme`()
BEGIN
	SELECT * FROM oprema o INNER JOIN ARTIKAL a on o.ARTIKAL_IdArtikal=a.IdArtikal INNER JOIN tip_opreme top on o.TIP_OPREME_IdTipOpreme=top.IdTipOpreme INNER JOIN proizvođač_opreme pop on o.PROIZVOĐAČ_OPREME_IdProizvođača=pop.IdProizvođača;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihArtikala` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihArtikala`()
BEGIN
	SELECT * FROM artikal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihBazena` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihBazena`()
BEGIN
	SELECT IdArtikal,Naziv,PrečnikBazena,DubinaBazena,Cijena, Opis FROM bazen b INNER JOIN montažni_artikal ma ON b.MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal=ma.ARTIKAL_IdArtikal INNER JOIN ARTIKAL a on b.MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal=a.IdArtikal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihKlijenata` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihKlijenata`()
BEGIN
	SELECT o.IdOsoba,o.Ime,o.Prezime,o.Telefon,m.PoštanskiBroj,m.Naziv
	FROM osoba o INNER JOIN mjesto m on o.MJESTO_PoštanskiBroj=m.PoštanskiBroj WHERE o.IdOsoba NOT IN (SELECT OSOBA_IdOsoba FROM zaposleni)
    ORDER BY o.IdOsoba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihMjesta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihMjesta`()
BEGIN
	SELECT * FROM mjesto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihNarudžbi` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihNarudžbi`()
BEGIN
	SELECT n.IdNarudžba, n.Datum, n.Status, n.UkupnaCijena, n.AdresaMontaže, n.OSOBA_IdOsoba as "Id Osoba", o.Ime, o.Prezime, o.Telefon, m.PoštanskiBroj, m.Naziv
    FROM narudžba n INNER JOIN osoba o ON n.OSOBA_IdOsoba=o.IdOsoba INNER JOIN mjesto m ON o.MJESTO_PoštanskiBroj=m.PoštanskiBroj
	ORDER BY n.Datum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihObloga` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihObloga`()
BEGIN
	SELECT IdArtikal,Naziv,PrečnikBazena,DubinaBazena,Cijena,Opis,VrstaMaterijala FROM obloga o INNER JOIN montažni_artikal ma ON o.MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal=ma.ARTIKAL_IdArtikal INNER JOIN ARTIKAL a on o.MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal=a.IdArtikal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihOsoba` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihOsoba`()
BEGIN
	SELECT o.IdOsoba,o.Ime,o.Prezime,o.Telefon,m.PoštanskiBroj,m.Naziv
	FROM osoba o INNER JOIN mjesto m on o.MJESTO_PoštanskiBroj=m.PoštanskiBroj
    ORDER BY o.IdOsoba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihPlatformi` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihPlatformi`()
BEGIN
	SELECT IdArtikal,Naziv,PrečnikBazena,DubinaBazena,Cijena,Opis,KvadraturaPodesta,VrstaMaterijala FROM platforma p INNER JOIN montažni_artikal ma ON p.MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal=ma.ARTIKAL_IdArtikal INNER JOIN ARTIKAL a on p.MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal=a.IdArtikal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihProizvođačaOpreme` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihProizvođačaOpreme`()
BEGIN
	SELECT * FROM proizvođač_opreme;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihStavkiNarudžbe` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihStavkiNarudžbe`(in pIdNarudžba INTEGER)
BEGIN
	SELECT ARTIKAL_IdArtikal, Količina FROM stavka s WHERE s.NARUDŽBA_IdNarudžba=pIdNarudžba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihTipovaOpreme` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihTipovaOpreme`()
BEGIN
	SELECT * FROM tip_opreme;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihUlogaZaposlenih` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihUlogaZaposlenih`()
BEGIN
	SELECT * FROM uloga_zaposlenog;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `dohvatanjeSvihZaposlenih` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `dohvatanjeSvihZaposlenih`()
BEGIN
	SELECT z.OSOBA_IdOsoba, o.Ime, o.Prezime, o.Telefon, o.MJESTO_PoštanskiBroj, m.Naziv, z.KorisničkoIme, z.OtisakLozinke, z.Plata, u.IdUloga, u.Naziv, z.JMBG
	FROM osoba o INNER JOIN zaposleni z ON o.IdOsoba=z.OSOBA_IdOsoba 
    INNER JOIN mjesto m ON o.MJESTO_PoštanskiBroj=m.PoštanskiBroj
    INNER JOIN uloga_zaposlenog u ON z.ULOGA_ZAPOSLENOG_IdUloga=u.IdUloga
    ORDER BY o.IdOsoba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `izmjenaMaterijala` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `izmjenaMaterijala`(in pIdMaterijal INTEGER, in pNaziv VARCHAR(100), in pKoličina DECIMAL(5,2), in pMjernaJedinica TINYINT, in pVrstaMaterijala TINYINT)
BEGIN
    UPDATE materijal m
    SET m.Naziv=pNaziv, m.Količina=pKoličina, m.MJERNA_JEDINICA_IdMjernaJedinica=pMjernaJedinica, m.VRSTA_MATERIJALA_IdVrsteMaterijala=pVrstaMaterijala WHERE m.IdMaterijal=pIdMaterijal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `izmjenaNarudžbe` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `izmjenaNarudžbe`(in pIdNarudžba INTEGER, in pAdresaMontaže VARCHAR(200), in pIdOsoba INTEGER)
BEGIN
    UPDATE narudžba n
    SET n.AdresaMontaže=pAdresaMontaže, n.OSOBA_IdOsoba=pIdOsoba,n.Datum=now() WHERE n.IdNarudžba=pIdNarudžba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `izmjenaOsobe` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `izmjenaOsobe`(in pIdOsoba INTEGER, in pIme VARCHAR(50), in pPrezime VARCHAR(50), in pTelefon VARCHAR(15), in pPoštanskiBroj VARCHAR(5))
BEGIN
    UPDATE osoba o
    SET o.Ime=pIme, o.Prezime=pPrezime, o.Telefon=pTelefon, o.MJESTO_PoštanskiBroj=pPoštanskiBroj WHERE o.IdOsoba=pIdOsoba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `izmjenaZaposlenog` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `izmjenaZaposlenog`(in pIdZaposlenog INTEGER, in pKorisničkoIme VARCHAR(50), in pOtisakLozinke VARCHAR(512), in pPlata DECIMAL(6,2), in pJMBG VARCHAR(13), in pIdUloga TINYINT)
BEGIN
    UPDATE zaposleni z
    SET z.KorisničkoIme=pKorisničkoIme, z.OtisakLozinke=pOtisakLozinke, z.Plata=pPlata, z.JMBG=pJMBG, z.ULOGA_ZAPOSLENOG_IdUloga=pIdUloga WHERE z.OSOBA_IdOsoba=pIdZaposlenog;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `izračunavanjeUkupneCijene` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `izračunavanjeUkupneCijene`(in pIdNarudžba INTEGER, in pUkupnaCijena DECIMAL(7,2))
BEGIN
	UPDATE narudžba n
    SET n.UkupnaCijena=pUkupnaCijena
    WHERE n.IdNarudžba=pIdNarudžba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `kreiranjeArtikla` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kreiranjeArtikla`(out pIdArtikal INTEGER, in pNaziv VARCHAR(200), in pCijena DECIMAL(7,2), in pOpis VARCHAR(500))
BEGIN
    INSERT INTO artikal(Naziv, Cijena, Opis) VALUES (pNaziv, pCijena, pOpis);
    SET pIdArtikal=last_insert_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `kreiranjeBazena` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kreiranjeBazena`(in pId INTEGER)
BEGIN
    INSERT INTO bazen(MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal) VALUES (pId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `kreiranjeMontažnogArtikla` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kreiranjeMontažnogArtikla`(in pId INTEGER, in pPrečnik DECIMAL(3,2), in pDubina DECIMAL(3,2))
BEGIN
    INSERT INTO montažni_artikal(ARTIKAL_IdArtikal, PrečnikBazena, DubinaBazena) VALUES (pId, pPrečnik, pDubina);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `kreiranjeNarudžbe` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kreiranjeNarudžbe`(out pIdNarudžba INTEGER, in pUkupnaCijena DECIMAL(7,2), in pAdresaMontaže VARCHAR(200), in pIdOsoba INTEGER)
BEGIN
    INSERT INTO narudžba(Datum, Status, UkupnaCijena, AdresaMontaže, OSOBA_IdOsoba) VALUES (now(), 0, pUkupnaCijena, pAdresaMontaže, pIdOsoba);
    SET pIdNarudžba=last_insert_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `kreiranjeNarudžbenice` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kreiranjeNarudžbenice`(in pIdPartnerskaKompanija INTEGER, in pIdZaposleni INTEGER, out pIdNarudžbenica INTEGER)
BEGIN
    INSERT INTO narudžbenica(IdNarudžbenica,Status,VrijemeKupovine,PARTNERSKA_KOMPANIJA_IdPartnerskaKompanija,ZAPOSLENI_OSOBA_IdOsoba) VALUES (pIdNarudžbenica,0,now(),pIdPartnerskaKompanija,pIdZaposleni);
    SET pIdNarudžbenica=last_insert_id();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `kreiranjeObloge` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kreiranjeObloge`(in pId INTEGER, in pVrstaMaterijala VARCHAR(50))
BEGIN
    INSERT INTO obloga(VrstaMaterijala, MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal) VALUES (pVrstaMaterijala, pId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `kreiranjeOpreme` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kreiranjeOpreme`(in pId INTEGER, in pIdTipOpreme INTEGER, in pIdProizvođačOpreme INTEGER, in pTrajanjeGarancije INTEGER)
BEGIN
    INSERT INTO oprema(TrajanjeGarancije, ARTIKAL_IdArtikal, TIP_OPREME_IdTipOpreme, PROIZVOĐAČ_OPREME_IdProizvođača) VALUES (pTrajanjeGarancije, pId, pIdTipOpreme, pIdProizvođačOpreme);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `kreiranjePlatforme` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `kreiranjePlatforme`(in pId INTEGER, in pKvadraturaPodesta DECIMAL(4,2), in pVrstaMaterijala VARCHAR(50))
BEGIN
    INSERT INTO platforma(KvadraturaPodesta, VrstaMaterijala, MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal) VALUES (pKvadraturaPodesta, pVrstaMaterijala, pId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pretragaMaterijala` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pretragaMaterijala`(in naziv VARCHAR(100))
BEGIN
	SET @konkatenacija=concat("%",naziv,"%");
    SELECT * FROM materijal m WHERE m.naziv LIKE @konkatenacija;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `prijavaZaposlenog` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prijavaZaposlenog`(in pKorisničkoIme VARCHAR(50), in pOtisakLozinke VARCHAR(512), out pPrijava boolean, out pIdZaposleni INTEGER)
BEGIN
	SELECT count(*)>0, OSOBA_IdOsoba INTO pPrijava, pIdZaposleni FROM zaposleni z
	WHERE z.KorisničkoIme=korisničkoIme AND z.OtisakLozinke=pOtisakLozinke;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `promjenaArtikla` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `promjenaArtikla`(in pIdArtikal INTEGER, in pNaziv VARCHAR(200), in pCijena DECIMAL(7,2), in pOpis VARCHAR(500))
BEGIN
    UPDATE artikal a
    SET a.Naziv=pNaziv, a.Cijena=pCijena, a.Opis=pOpis WHERE a.IdArtikal=pIdArtikal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `promjenaKoličineMaterijala` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `promjenaKoličineMaterijala`(in pIdNarudžbenica INTEGER)
BEGIN
	UPDATE materijal, narudžbenica n
    INNER JOIN narudžbenica_ima_materijal nim  ON n.IdNarudžbenica=nim.NARUDŽBENICA_IdNarudžbenica
    INNER JOIN materijal m
    SET m.Količina=m.Količina+nim.Količina
    WHERE n.IdNarudžbenica=pIdNarudžbenica AND nim.MATERIJAL_IdMaterijal=m.IdMaterijal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `promjenaKoličineStavke` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `promjenaKoličineStavke`(in pIdNarudžba INTEGER, in pIdArtikal INTEGER, in pKoličina INTEGER)
BEGIN
	UPDATE stavka s
    SET s.Količina=pKoličina
    WHERE s.NARUDŽBA_IdNarudžba=pIdNarudžba AND s.ARTIKAL_IdArtikal=pIdArtikal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `promjenaStatusaNarudžbe` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `promjenaStatusaNarudžbe`(in pIdNarudžba INTEGER, in pStatus TINYINT)
BEGIN
    UPDATE narudžba n
    SET n.Status=pStatus WHERE n.IdNarudžba=pIdNarudžba;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `promjenaStatusaNarudžbenice` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `promjenaStatusaNarudžbenice`(in pIdNarudžbenica INTEGER, in pStatus TINYINT)
BEGIN
    UPDATE narudžbenica n
    SET n.Status=pStatus WHERE n.IdNarudžbenica=pIdNarudžbenica;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!50003 DROP PROCEDURE IF EXISTS `provjeraStanjaMaterijala` */;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `provjeraStanjaMaterijala`(in pIdMaterijal INTEGER, in pKoličina DECIMAL(6,2), out pRazlikaUKoličini DECIMAL(6,2))
BEGIN
	DECLARE KoličinaBaza DECIMAL(6,2);
    SELECT Količina INTO KoličinaBaza FROM materijal m WHERE m.IdMaterijal=pIdMaterijal;
    SET pRazlikaUKoličini=KoličinaBaza-pKoličina;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bayensolutions` CHARACTER SET utf8mb3 COLLATE utf8mb3_bin ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-19 22:56:02
