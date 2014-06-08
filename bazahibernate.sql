-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2014 at 06:15 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bazahibernate`
--
CREATE DATABASE IF NOT EXISTS `bazahibernate` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bazahibernate`;

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE IF NOT EXISTS `administrator` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`ID`, `USERNAME`, `PASSWORD`) VALUES
(1, 'Administrator', '21232f297a57a5a743894a0e4a801fc3');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
CREATE TABLE IF NOT EXISTS `korisnik` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `IME` varchar(255) DEFAULT NULL,
  `PREZIME` varchar(255) DEFAULT NULL,
  `JMBG` varchar(255) DEFAULT NULL,
  `BRTEL` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `DATUMKREIRANJA` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`ID`, `IME`, `PREZIME`, `JMBG`, `BRTEL`, `USERNAME`, `PASSWORD`, `DATUMKREIRANJA`) VALUES
(6, 'Kenan', 'Ekinovic', '1111111111111', '123123123', 'hjuhefner', 'c81e728d9d4c2f636f067f89cc14862c', '2014-05-26 15:14:44'),
(7, 'Dajan', 'Bracko', '123123123232', '123123123', 'dajo', 'eaa3e4926b712e1c31c2c9aad1d8e8e0', '2014-05-26 15:59:57'),
(8, 'k', 'k', 'k', 'k', 'k', '8ce4b16b22b58894aa86c421e8759df3', '2014-06-02 23:02:58'),
(9, '', '', '', '123e12123', 'beab', '12eccbdd9b32918131341f38907cbbb5', '2014-06-03 16:42:26'),
(10, 'e', 'e', '1234567890123', '123123123', 'e', 'e1671797c52e15f763380b45e841ec32', '2014-06-03 16:49:55'),
(14, 'admin', 'admin', '1234567890123', '123123123', 'dajos', 'e1671797c52e15f763380b45e841ec32', '2014-06-05 01:52:24'),
(15, 'A z', 'Z-u', '1234567890123', '123123123', 'uu', 'e1671797c52e15f763380b45e841ec32', '2014-06-05 04:41:34');

-- --------------------------------------------------------

--
-- Table structure for table `stalnosredstvo`
--

DROP TABLE IF EXISTS `stalnosredstvo`;
CREATE TABLE IF NOT EXISTS `stalnosredstvo` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAZIV` varchar(255) DEFAULT NULL,
  `LOKACIJA` varchar(255) DEFAULT NULL,
  `NABAVNAVRIJEDNOST` double DEFAULT NULL,
  `DATUMNABAVKE` datetime DEFAULT NULL,
  `TIP` bigint(20) DEFAULT NULL,
  `UUPOTREBI` bit(1) DEFAULT NULL,
  `TRENUTNAVRIJEDNOST` double DEFAULT NULL,
  `STOPAAMORTIZACIJE` double DEFAULT NULL,
  `DATUMSTAVLJANJAUUPOTREBU` datetime DEFAULT NULL,
  `GODISNJAAMORT` bit(1) DEFAULT NULL,
  `OTPISANO` bit(1) DEFAULT NULL,
  `DATUMOTPISIVANJA` datetime DEFAULT NULL,
  `PRODANO` bit(1) DEFAULT NULL,
  `DATUMPRODAJE` datetime DEFAULT NULL,
  `PRODAJNACIJENA` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_o43q5beo69701pdhx7fot16tl` (`TIP`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `stalnosredstvo`
--

INSERT INTO `stalnosredstvo` (`ID`, `NAZIV`, `LOKACIJA`, `NABAVNAVRIJEDNOST`, `DATUMNABAVKE`, `TIP`, `UUPOTREBI`, `TRENUTNAVRIJEDNOST`, `STOPAAMORTIZACIJE`, `DATUMSTAVLJANJAUUPOTREBU`, `GODISNJAAMORT`, `OTPISANO`, `DATUMOTPISIVANJA`, `PRODANO`, `DATUMPRODAJE`, `PRODAJNACIJENA`) VALUES
(1, 'racunar', 'kuca', 2000, '2014-06-02 23:04:00', 2, b'0', 2000, 0, NULL, b'0', b'0', NULL, b'0', NULL, 0),
(2, 'lampa', 'kuca', 100, '2014-06-05 02:09:31', 1, b'1', 100, 0.2, '2014-06-05 02:10:28', b'0', b'0', NULL, b'0', NULL, 0),
(3, 'stolica', 'kuca', 50, '2014-06-05 03:58:13', 1, b'1', 50, 120, '2014-06-05 03:58:40', b'1', b'0', NULL, b'0', NULL, 0),
(4, 'zli klobuk', 'kucica', 50, '2014-06-05 04:01:47', 2, b'1', 50, 1.2000000000000002, '2014-06-05 04:02:02', b'1', b'0', NULL, b'0', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tipstalnogsredstva`
--

DROP TABLE IF EXISTS `tipstalnogsredstva`;
CREATE TABLE IF NOT EXISTS `tipstalnogsredstva` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAZIV` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tipstalnogsredstva`
--

INSERT INTO `tipstalnogsredstva` (`ID`, `NAZIV`) VALUES
(1, 'namjestaj'),
(2, 'Hardver');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `stalnosredstvo`
--
ALTER TABLE `stalnosredstvo`
  ADD CONSTRAINT `FK_o43q5beo69701pdhx7fot16tl` FOREIGN KEY (`TIP`) REFERENCES `tipstalnogsredstva` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
