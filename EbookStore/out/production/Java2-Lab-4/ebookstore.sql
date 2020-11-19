-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 09, 2020 at 07:35 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ebookstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `bookID` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `author` varchar(50) DEFAULT NULL,
  `years` int(4) DEFAULT NULL,
  `status` int(11) DEFAULT NULL CHECK (`status` regexp '[1-3]{1}'),
  `qty` int(11) DEFAULT NULL,
  `price` decimal(10,1) DEFAULT NULL,
  `createddate` date DEFAULT current_timestamp(),
  `updateddate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bookID`, `title`, `author`, `years`, `status`, `qty`, `price`, `createddate`, `updateddate`) VALUES
(1001, 'Javafor dummy', 'Dang Kim Thi', 1999, 2, 2, '10.0', '2020-11-08', '2020-11-08'),
(1002, 'fgajsdfh', 'ajhsdfgj', 1999, 2, 190, '10.0', '2020-11-09', NULL),
(1003, '31dfasd', 'asdfadf', 1888, 3, 452, '2.0', '2020-11-09', '2020-11-10'),
(1004, 'dhgfxhghxg', 'dfghdfg', 1976, 2, 887, '6.0', '2020-11-09', NULL),
(1231, 'qweqw', 'sddfas', 2345, 2, 34, '4.0', '2020-11-09', NULL),
(3123, 'agdg', 'ewre', 2345, 2, 45, '7.6', '2020-11-09', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customerID` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL CHECK (`phone` regexp '[0-9]{10}'),
  `createddate` date DEFAULT current_timestamp(),
  `updateddate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerID`, `name`, `address`, `email`, `phone`, `createddate`, `updateddate`) VALUES
(1, 'vuong', 'vuong', 'vuong', '1234567890', '2020-11-10', NULL),
(7, 'minhrau', 'hanoi', 'lhm@gmail.com', '0123456789', '2020-11-09', NULL),
(1001, 'Hoang Minh Vuong', '15/241 Kham Thien, Ha Noi', 'Vuongpt93@gmail.com', '0866858676', '2020-11-09', NULL),
(1002, 'Maria', 'Obere Str. 57', 'maria@smt.com', '0300074321', '2020-11-09', NULL),
(2232, 'jkdhfkjds', 'dfad', 'asdkjfhk', '1234567889', '2020-11-09', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `orderID` int(11) DEFAULT NULL,
  `bookID` int(11) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` decimal(10,1) DEFAULT NULL,
  `createddate` date DEFAULT NULL,
  `updateddate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`orderID`, `bookID`, `title`, `amount`, `price`, `createddate`, `updateddate`) VALUES
(1234, 1001, 'Javafor dummy', 3, NULL, '2020-11-09', '2020-11-09'),
(1, 1001, 'Javafor dummy', 3, '10.0', '2020-11-10', '2020-11-10'),
(2, 1002, 'fgajsdfh', 10, '10.0', '2020-11-10', '2020-11-10'),
(3, 1003, '31dfasd', 200, '2.0', '2020-11-10', '2020-11-10');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL,
  `customerID` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `total` decimal(10,1) DEFAULT NULL,
  `orderdate` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL CHECK (`status` regexp '[0-5]{1}'),
  `createddate` date DEFAULT NULL,
  `updateddate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`orderID`, `customerID`, `discount`, `total`, `orderdate`, `status`, `createddate`, `updateddate`) VALUES
(1, 1001, 10, NULL, '2020-11-10', 1, '2020-11-10', '2020-11-10'),
(2, 1, 20, '20.0', '2020-11-10', 2, '2020-11-10', '2020-11-10'),
(3, 1, 50, '200.0', '2020-11-10', 3, '2020-11-10', '2020-11-10'),
(1234, 1001, 10, NULL, '2020-11-09', 1, '2020-11-09', '2020-11-09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`bookID`,`title`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD KEY `fk_detail` (`bookID`,`title`),
  ADD KEY `fk_detail2` (`orderID`),
  ADD KEY `fk_bookprice` (`price`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `fk_customer` (`customerID`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1237;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `fk_detail` FOREIGN KEY (`bookID`,`title`) REFERENCES `books` (`bookID`, `title`),
  ADD CONSTRAINT `fk_detail2` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_customer` FOREIGN KEY (`customerID`) REFERENCES `customers` (`customerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
