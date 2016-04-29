-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2015 at 04:12 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `craigslist`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(8, 'Automobiles'),
(9, 'Electronics'),
(10, 'Furniture'),
(11, 'Home Appliances'),
(12, 'Miscellaneous');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `prod_id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) NOT NULL,
  `user_id` varchar(80) NOT NULL,
  `email` varchar(50) NOT NULL,
  `category` int(11) NOT NULL,
  `price` float NOT NULL,
  `img_desc` varchar(40) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `prod_desc` varchar(70) DEFAULT NULL,
  `Name` varchar(60) NOT NULL,
  `sold_Flag` varchar(10) NOT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4022 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`prod_id`, `title`, `user_id`, `email`, `category`, `price`, `img_desc`, `phone`, `prod_desc`, `Name`, `sold_Flag`) VALUES
(4000, 'Camry2014', 'test1234', 'm@g.com', 8, 22000, 'AutoMobiles/auto_1', '7133801032', '2014 Camry with full working condition and with no accident history', 'swetha', 'N'),
(4001, 'samsung laptop', 'test1234', 'm@g.com', 9, 300, 'Electronics/elec_1', '7133801032', '1 year old samsung laptop with 6gb RAM and 500GB harddisk', 'Swetha', 'N'),
(4002, 'iphone', 'test1234', 'm@g.com', 9, 300, 'Electronics/elec_3', '7133801032', 'Iphone 5s refurbished one with good working condition', 'Swetha', 'N'),
(4003, 'couch', 'test6789', 't@c.com', 10, 400, 'Furniture/furn_2', '7776678799', 'couch 2013 model', 'test', 'N'),
(4004, 'Chair', 'test6789', 't@c.com', 10, 30, 'Furniture/furn_3', '7776678799', 'Study Chair 3 year old', 'test', 'N'),
(4005, 'Vacuum cleaner', 'test6789', 't@c.com', 11, 40, 'HomeApp/home_1', '7776678799', '6 month old vacuum cleaner', 'test', 'N'),
(4006, 'Gray Mountain', 'test6789', 't@c.com', 12, 20, 'Misc/lat_2', '7776678799', 'John Grisham Gray mountain novel', 'test', 'N'),
(4007, 'Mustang', 'test6789', 't@c.com', 8, 28000, 'AutoMobiles/auto_2', '7776678799', '2012 model mustang with good working condition', 'Mike', 'N'),
(4008, 'Breakfast table', 'test6789', 'm@g.com', 10, 380, 'Furniture/furn_1', '7133801032', '6months old breakfast table in good condition', 'swetha', 'N'),
(4009, 'TV', 'bhavya', 'dfgfd@dfg.com', 9, 1000, 'Electronics/samsungtv', '23432', '32'' HD LED TV ', 'sdfdsf', 'N'),
(4010, 'iphone', 'ravalin', 'ravali@hello.com', 9, 500, 'Electronics/iphone6s', '873462308', 'IPHONE used', 'ravali', 'Y'),
(4011, 'iphone', 'ravalin', 'sfsdf@df.com', 9, 300, 'Electronics/iphone6s', '43597348', 'Iphone 5', 'sam', 'Y'),
(4012, 'iphone', 'ravalin', 'sdfdsf@gmail.com', 9, 200, 'Electronics/iphone6s', '2345', 'scknds', 'sdfbdsk', 'Y'),
(4013, 'washing machine', 'ravalin', 'sdfjk@djd.com', 11, 400, 'HomeApp/home_3', '4359384', 'new washing machine', 'bhavya', 'N'),
(4014, 'Book about Sachin', 'ravalin', 'xcvxcv@sdfd.com', 12, 30, 'Misc/lat_5', '5464654', 'Biography of Sachin Tendular', 'bhavya', 'N'),
(4018, 'paper art', 'bhavya', 'bha.gm.com', 12, 100, 'Misc/paperart', '2345', 'hand made wall art', 'bhavya', 'N'),
(4019, 'Samsung 50 inch tv', 'testpr', 'test@gmail.com', 9, 400, 'Electronics/samsung50', '7888888888', 'Samsung 5 series 2014 model', 'test', 'N'),
(4020, 'Home theatre system', 'test123', 'test2@gmail.com', 9, 400, 'Electronics/speaker', '7899999999', '1 year old speakers with good working condition', 'test', 'Y'),
(4021, 'bike', 'testacc', 'hello@gmail.com', 12, 100, 'Misc/bicycle', '7893273943', 'New Bike with gears and auto locking.', 'bhavya', 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `producthistory`
--

CREATE TABLE IF NOT EXISTS `producthistory` (
  `user_id` varchar(40) NOT NULL,
  `isbn` int(5) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4022 ;

--
-- Dumping data for table `producthistory`
--

INSERT INTO `producthistory` (`user_id`, `isbn`) VALUES
('test1234', 4000),
('test1234', 4001),
('test1234', 4002),
('test6789', 4003),
('test6789', 4004),
('test6789', 4005),
('test6789', 4006),
('test6789', 4007),
('test6789', 4008),
('bhavya', 4009),
('ravalin', 4010),
('ravalin', 4011),
('ravalin', 4012),
('ravalin', 4013),
('ravalin', 4014),
('bhavya', 4015),
('bhavya', 4016),
('bhavya', 4017),
('bhavya', 4018),
('testpr', 4019),
('test123', 4020),
('testacc', 4021);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_fname` varchar(80) DEFAULT NULL,
  `phone` varchar(80) DEFAULT NULL,
  `user_id` varchar(80) NOT NULL DEFAULT '',
  `email` varchar(80) DEFAULT NULL,
  `user_password` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_fname`, `phone`, `user_id`, `email`, `user_password`) VALUES
('Nagabhavya', '4698261402', 'bhavya', 'nagabhavyam@gmail.com', '$2y$10$S1jdnTiwZ7vcJHR4fZ99r.eUBxAraz2FuxegGDEXhNjo2GXo9o.Pq'),
('lakshmi', '1223455', 'lakshmi', 'lakshmi@gmail.com', '$2y$10$uH0xtRJcLSaNUYyCvRD1te7kFHjUoM12NxFrK7u9kkXPOJS4nObSq'),
('puppy', '3247845984', 'puppy', 'dsfsd@eg.com', '$2y$10$nWqoZGA0JvJyEtqcmGYVue4iZbHNMM8UFKzAYsy.fdkXePu72QKGu'),
('ravali', '346208534`', 'ravalin', 'dbfvhdkgvd@dfg.com', '$2y$10$Pq4mSnIKrQ2P5avyi4pxle8stZxw6qS1/fegqcUqgG9WrPrehycLu'),
('test project', '7688888888', 'test123', 'test1@gmail.com', '$2y$10$4.kSxvxX1Hkn06xLFSfbuOruRXoXXZjyALfJDE6t25pmAdn./KOJu'),
('test', '8778866778', 'test1234', 't@t.com', '$2y$10$hF3F6dPlcei6Hys1iKBLHuZuftW3k.o.TxHVXo0aVKDePyBuZHzlO'),
('test4', '7666666666', 'test4', 'test4@gmail.com', '$2y$10$gUs.waoVQQUF9IuBRkelTeM7E/2zUDN3K0o0J34aSTa4Jk2rkonpO'),
('S m', '7776666678', 'test6789', 'abc@gmail.com', '$2y$10$CaVR7BXNK2jRjcx6Iq9ftOm3Jzyg.zJXMc1zEpDE1zSQDSN3Ucbgy'),
('testacc', '123456789', 'testacc', 'testacc@outlook.com', '$2y$10$.A2vJJ3LNG.y.0H1pv2PCuTz.Ne0MSAwVNWIWyk8jbUxj1YuapYy.'),
('test project', '7888888855', 'testpr', 'test@gmail.com', '$2y$10$wkv7qwLC2F7i7ZmrwcBy/.NWp7rbaU.ckK/WAS9Yez75kIIdZBV96');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
