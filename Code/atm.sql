-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2019 at 09:26 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm`
--

-- --------------------------------------------------------

--
-- Table structure for table `clientdata`
--

CREATE TABLE `clientdata` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `nationalid` varchar(50) NOT NULL,
  `type` enum('normal','VIP') DEFAULT NULL,
  `balance` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clientdata`
--

INSERT INTO `clientdata` (`username`, `password`, `phone`, `firstname`, `lastname`, `nationalid`, `type`, `balance`) VALUES
('ahmed', '1234321', '012123123', 'ahmed', 'farag', '123374788', NULL, 1700),
('momen', '12435577', '1293959', 'momen', 'zakarya', '142484858', NULL, NULL),
('nour', '33544666', '45678900', 'atalla', 'nour', '666554333', NULL, 1500),
('saad', '12345', '232312', 'saad', 'ahmed', '52515', NULL, 1000),
('khaled', '54321', '434234', 'khaled', 'nabil', '45563463', 'VIP', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
