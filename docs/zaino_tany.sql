-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.3.8-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database zaino
CREATE DATABASE IF NOT EXISTS `zaino` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `zaino`;

-- Dump della struttura di tabella zaino.pezzo
CREATE TABLE IF NOT EXISTS `pezzo` (
  `id` int(11) NOT NULL,
  `id_problema` varchar(5) NOT NULL,
  `peso` int(11) NOT NULL,
  `costo` int(11) NOT NULL,
  `ottimo` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pezzo_problema` (`id_problema`),
  CONSTRAINT `FK_pezzo_problema` FOREIGN KEY (`id_problema`) REFERENCES `problema` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella zaino.pezzo: ~82 rows (circa)
DELETE FROM `pezzo`;
/*!40000 ALTER TABLE `pezzo` DISABLE KEYS */;
INSERT INTO `pezzo` (`id`, `id_problema`, `peso`, `costo`, `ottimo`) VALUES
	(1, 'P01', 23, 92, 1),
	(2, 'P01', 31, 57, 1),
	(3, 'P01', 29, 49, 1),
	(4, 'P01', 44, 68, 1),
	(5, 'P01', 53, 60, 0),
	(6, 'P01', 38, 43, 1),
	(7, 'P01', 63, 67, 0),
	(8, 'P01', 85, 84, 0),
	(9, 'P01', 89, 87, 0),
	(10, 'P01', 82, 72, 0),
	(11, 'P02', 12, 24, 0),
	(12, 'P02', 7, 13, 1),
	(13, 'P02', 11, 23, 1),
	(14, 'P02', 8, 15, 1),
	(15, 'P02', 9, 16, 0),
	(16, 'P03', 56, 50, 1),
	(17, 'P03', 59, 50, 1),
	(18, 'P03', 80, 64, 0),
	(19, 'P03', 64, 46, 0),
	(20, 'P03', 75, 50, 1),
	(21, 'P03', 17, 5, 0),
	(22, 'P04', 31, 70, 1),
	(23, 'P04', 10, 20, 0),
	(24, 'P04', 20, 39, 0),
	(25, 'P04', 19, 37, 1),
	(26, 'P04', 4, 7, 0),
	(27, 'P04', 3, 5, 0),
	(28, 'P04', 6, 10, 0),
	(29, 'P05', 25, 350, 1),
	(30, 'P05', 35, 400, 0),
	(31, 'P05', 45, 450, 1),
	(32, 'P05', 5, 20, 1),
	(33, 'P05', 25, 70, 1),
	(34, 'P05', 3, 8, 0),
	(35, 'P05', 2, 5, 1),
	(36, 'P05', 2, 5, 1),
	(37, 'P06', 41, 442, 0),
	(38, 'P06', 50, 525, 1),
	(39, 'P06', 49, 511, 0),
	(40, 'P06', 59, 593, 1),
	(41, 'P06', 55, 546, 0),
	(42, 'P06', 57, 564, 0),
	(43, 'P06', 60, 617, 1),
	(44, 'P07', 70, 135, 1),
	(45, 'P07', 73, 139, 0),
	(46, 'P07', 77, 149, 1),
	(47, 'P07', 80, 150, 0),
	(48, 'P07', 82, 156, 1),
	(49, 'P07', 87, 163, 0),
	(50, 'P07', 90, 173, 1),
	(51, 'P07', 94, 184, 1),
	(52, 'P07', 98, 192, 1),
	(53, 'P07', 106, 201, 0),
	(54, 'P07', 110, 210, 0),
	(55, 'P07', 113, 214, 0),
	(56, 'P07', 115, 221, 0),
	(57, 'P07', 118, 229, 1),
	(58, 'P07', 120, 240, 1),
	(59, 'P08', 382745, 825594, 1),
	(60, 'P08', 799601, 1677009, 1),
	(61, 'P08', 909247, 1676628, 0),
	(62, 'P08', 729069, 1523970, 1),
	(63, 'P08', 467902, 943972, 1),
	(64, 'P08', 44328, 97426, 1),
	(65, 'P08', 34610, 69666, 0),
	(66, 'P08', 698150, 1296457, 0),
	(67, 'P08', 823460, 1679693, 0),
	(68, 'P08', 903959, 1902996, 1),
	(69, 'P08', 853665, 1844992, 1),
	(70, 'P08', 551830, 1049289, 0),
	(71, 'P08', 610856, 1252836, 1),
	(72, 'P08', 670702, 1319836, 0),
	(73, 'P08', 488960, 953277, 0),
	(74, 'P08', 951111, 2067538, 1),
	(75, 'P08', 323046, 675367, 0),
	(76, 'P08', 446298, 853655, 0),
	(77, 'P08', 931161, 1826027, 0),
	(78, 'P08', 31385, 65731, 0),
	(79, 'P08', 496951, 901489, 0),
	(80, 'P08', 264724, 577243, 1),
	(81, 'P08', 224916, 466257, 1),
	(82, 'P08', 169684, 369261, 1);
/*!40000 ALTER TABLE `pezzo` ENABLE KEYS */;

-- Dump della struttura di tabella zaino.problema
CREATE TABLE IF NOT EXISTS `problema` (
  `id` varchar(5) NOT NULL,
  `capacity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella zaino.problema: ~8 rows (circa)
DELETE FROM `problema`;
/*!40000 ALTER TABLE `problema` DISABLE KEYS */;
INSERT INTO `problema` (`id`, `capacity`) VALUES
	('P01', 165),
	('P02', 26),
	('P03', 190),
	('P04', 50),
	('P05', 104),
	('P06', 170),
	('P07', 750),
	('P08', 6404180);
/*!40000 ALTER TABLE `problema` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
