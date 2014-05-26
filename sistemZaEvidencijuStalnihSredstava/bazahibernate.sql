-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2014 at 02:52 PM
-- Server version: 5.5.36
-- PHP Version: 5.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bazahibernate`
--

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
(1, 'Administrator', 'admin');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`ID`, `IME`, `PREZIME`, `JMBG`, `BRTEL`, `USERNAME`, `PASSWORD`, `DATUMKREIRANJA`) VALUES
(1, 'jasmin', 'ackaposkc', '1801992', '1516161', '1516161', 'hehea', '2014-05-26 00:00:00'),
(2, 'Jasmin', 'Cebo', '1801992170022', '062170128', '062170128', 'Jasminos', '2014-05-26 00:00:00'),
(3, 'Jasmin', 'Cebo', '1801992170022', '062170128', 'Jasminos', '1801992', '2014-05-26 00:00:00'),
(4, 'Amina', 'Djonko', '1123587690068', '123456456', 'amina', 'amina', '2014-05-26 14:35:09');

-- --------------------------------------------------------

--
-- Table structure for table `tipstalnogsredstva`
--

DROP TABLE IF EXISTS `tipstalnogsredstva`;
CREATE TABLE IF NOT EXISTS `tipstalnogsredstva` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAZIV` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
