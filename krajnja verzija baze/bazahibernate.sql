-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 10, 2014 at 06:46 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Table structure for table `tipstalnogsredstva`
--

DROP TABLE IF EXISTS `tipstalnogsredstva`;
CREATE TABLE IF NOT EXISTS `tipstalnogsredstva` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAZIV` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

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
