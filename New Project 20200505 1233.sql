-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.29


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema test
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ test;
USE test;

--
-- Table structure for table `test`.`items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `itemID` int(11) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(10) DEFAULT NULL,
  `itemName` varchar(30) DEFAULT NULL,
  `itemPrice` decimal(5,2) DEFAULT NULL,
  `itemDesc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`.`items`
--

/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` (`itemID`,`itemCode`,`itemName`,`itemPrice`,`itemDesc`) VALUES 
 (3,'100103','Eraser','20.00','This is a eraser');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;


--
-- Table structure for table `test`.`payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE `payments` (
  `payID` int(11) NOT NULL AUTO_INCREMENT,
  `payType` varchar(20) DEFAULT NULL,
  `payAmount` decimal(11,2) DEFAULT NULL,
  `payDate` varchar(200) DEFAULT NULL,
  `payEmail` varchar(20) DEFAULT NULL,
  `payDesc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`payID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`.`payments`
--

/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` (`payID`,`payType`,`payAmount`,`payDate`,`payEmail`,`payDesc`) VALUES 
 (1,'VISA','1200.00','2020-02-09','abc@gmail.com','Notes');
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
