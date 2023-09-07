CREATE DATABASE  IF NOT EXISTS `bd_dulcevilla` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_dulcevilla`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_dulcevilla
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `tb_cab_cdp`
--

DROP TABLE IF EXISTS `tb_cab_cdp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cab_cdp` (
  `num_cdp` char(5) NOT NULL,
  `fch_cdp` date DEFAULT NULL,
  `cod_cli` char(4) DEFAULT NULL,
  `cod_usu` int DEFAULT NULL,
  `total_bol` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`num_cdp`),
  KEY `FK_CODCLI_idx` (`cod_cli`),
  KEY `FK_CODUSU_idx` (`cod_usu`),
  CONSTRAINT `FK_CODCLI` FOREIGN KEY (`cod_cli`) REFERENCES `tb_cliente` (`codigo`),
  CONSTRAINT `FK_CODUSU` FOREIGN KEY (`cod_usu`) REFERENCES `tb_usuarios` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cab_cdp`
--

LOCK TABLES `tb_cab_cdp` WRITE;
/*!40000 ALTER TABLE `tb_cab_cdp` DISABLE KEYS */;
INSERT INTO `tb_cab_cdp` VALUES ('C0001','2022-04-20','C001',10,39.90),('C0002','2022-06-18','C001',10,129.70),('C0003','2022-06-18','C001',10,99.70),('C0004','2022-06-18','C001',10,49.90);
/*!40000 ALTER TABLE `tb_cab_cdp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `codigo` char(4) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dirección` varchar(45) DEFAULT NULL,
  `celular` char(9) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES ('C001','Juan','Maldonado','Jr. Las Palmeras 123','997325647'),('C002','Luis','Arias','Jr. Los Claveles 455','998877661');
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_det_cdp`
--

DROP TABLE IF EXISTS `tb_det_cdp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_det_cdp` (
  `num_cdp` char(5) NOT NULL,
  `id_torta` char(5) NOT NULL,
  `cantidad` int DEFAULT NULL,
  `preciovta` decimal(8,2) DEFAULT NULL,
  `importe` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`num_cdp`,`id_torta`),
  KEY `FK_IDTORTA_idx` (`id_torta`),
  CONSTRAINT `FK_IDTORTA` FOREIGN KEY (`id_torta`) REFERENCES `tb_torta` (`id_torta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_det_cdp`
--

LOCK TABLES `tb_det_cdp` WRITE;
/*!40000 ALTER TABLE `tb_det_cdp` DISABLE KEYS */;
INSERT INTO `tb_det_cdp` VALUES ('C0002','T0001',2,49.90,99.80),('C0002','T0003',1,29.90,29.90),('C0003','T0002',1,39.90,39.90),('C0003','T0003',2,29.90,59.80),('C0004','T0001',1,49.90,49.90);
/*!40000 ALTER TABLE `tb_det_cdp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo`
--

DROP TABLE IF EXISTS `tb_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo` (
  `id_tipo` int NOT NULL AUTO_INCREMENT,
  `des_tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo`
--

LOCK TABLES `tb_tipo` WRITE;
/*!40000 ALTER TABLE `tb_tipo` DISABLE KEYS */;
INSERT INTO `tb_tipo` VALUES (1,'Torta de mantequilla'),(2,'Torta clásica'),(3,'Torta esponjosa');
/*!40000 ALTER TABLE `tb_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipouser`
--

DROP TABLE IF EXISTS `tb_tipouser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipouser` (
  `id_tipo` int NOT NULL AUTO_INCREMENT,
  `des_tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipouser`
--

LOCK TABLES `tb_tipouser` WRITE;
/*!40000 ALTER TABLE `tb_tipouser` DISABLE KEYS */;
INSERT INTO `tb_tipouser` VALUES (1,'Recepcionista'),(2,'Personal de mostrador'),(3,'Cajero');
/*!40000 ALTER TABLE `tb_tipouser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_torta`
--

DROP TABLE IF EXISTS `tb_torta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_torta` (
  `id_torta` char(5) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `precio` decimal(8,2) DEFAULT NULL,
  `id_tipo` int DEFAULT '2',
  PRIMARY KEY (`id_torta`),
  KEY `fk_idtipo_idx` (`id_tipo`),
  CONSTRAINT `fk_idtipo` FOREIGN KEY (`id_tipo`) REFERENCES `tb_tipo` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_torta`
--

LOCK TABLES `tb_torta` WRITE;
/*!40000 ALTER TABLE `tb_torta` DISABLE KEYS */;
INSERT INTO `tb_torta` VALUES ('T0001','Torta de chocolate',17,49.90,3),('T0002','Torta de naranja',9,39.90,2),('T0003','Torta Tres Leches',17,29.90,1),('T0004','Selva Negra',30,32.00,3);
/*!40000 ALTER TABLE `tb_torta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `usuario` char(4) DEFAULT NULL,
  `clave` char(5) DEFAULT NULL,
  `fnacim` date DEFAULT NULL,
  `tipo` int DEFAULT '2',
  `estado` int DEFAULT '1',
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `FK_tipo_idx` (`tipo`),
  CONSTRAINT `FK_tipo` FOREIGN KEY (`tipo`) REFERENCES `tb_tipouser` (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,'Tito','Siber','U001','10001','1990-04-25',2,1),(2,'Zoila','Baca','U002','10002','2001-04-25',1,1),(3,'Pedro','Navaja','U003','10003','1995-04-25',3,1),(10,'Angelo','Balbin','U004','10004','2002-06-07',3,1);
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_dulcevilla'
--

--
-- Dumping routines for database 'bd_dulcevilla'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_BuscarTorta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_BuscarTorta`(des VARCHAR(45))
select * from tb_torta where descripcion like concat(des,'%') ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_ValidarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_ValidarUsuario`(usr char(4),clav char(5))
SELECT * FROM tb_usuarios where usuario = usr AND clave = clav ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-18 19:10:51
