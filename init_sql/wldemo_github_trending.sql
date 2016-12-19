-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: localhost    Database: db_tech
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `github_trending`
--

DROP TABLE IF EXISTS `github_trending`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `github_trending` (
  `_updated` text,
  `_href` text,
  `_desc` text,
  `_author` text,
  `_title` text,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `github_trending`
--

LOCK TABLES `github_trending` WRITE;
/*!40000 ALTER TABLE `github_trending` DISABLE KEYS */;
INSERT INTO `github_trending` VALUES ('2016-10-27 03:49:17','/romandanylyk/PageIndicatorView','\n      An page indicator for Android ViewPager\n    ','romandanylyk','/romandanylyk/PageIndicatorView',1),('2016-10-27 03:49:17','/czy1121/badgebutton','\n      带有徽标(数字，小红点)的按钮\n    ','czy1121','/czy1121/badgebutton',2),('2016-10-27 03:49:17','/linglongxin24/DylanStepCount','\n      Android精准计步器\n    ','linglongxin24','/linglongxin24/DylanStepCount',3),('2016-10-27 03:49:17','/Cleveroad/FanLayoutManager',NULL,'yarovoiag','/Cleveroad/FanLayoutManager',4),('2016-10-27 03:49:17','/Muyangmin/Android-PLog','\n      Android 专用日志封装库，轻巧易用，高扩展性。An log library focused on high extensibility, powerful enough but easy to use.\n    ','Muyangmin','/Muyangmin/Android-PLog',5),('2016-10-27 03:49:17','/julian-klode/dns66','\n      DNS-based Ad/Host Blocker for Android\n    ','julian-klode','/julian-klode/dns66',6),('2016-10-27 03:49:17','/lygttpod/SuperTextView','\n      a super textview for android\n    ','lygttpod','/lygttpod/SuperTextView',7),('2016-10-27 03:49:17','/gavinliu/SimpleOneStep','\n      The SimpleOneStep is like OneStep about Smartisan OS 3.\n    ','gavinliu','/gavinliu/SimpleOneStep',8),('2016-10-27 03:49:17','/florent37/DiagonalLayout','\n      With Diagonal Layout explore new styles and approaches on material design\n    ','florent37','/florent37/DiagonalLayout',9),('2016-10-27 03:49:17','/facebook/react-native','\n      A framework for building native apps with React.\n    ','vjeux','/facebook/react-native',10),('2016-10-27 03:49:17','/diamondlin2016/LauncherView','\n      app 启动时的 Loading 动画\n    ','diamondlin2016','/diamondlin2016/LauncherView',11),('2016-10-27 03:49:17','/baoyongzhang/BigBang','\n      模仿 Smartisan OS 的 BigBang 功能\n    ','baoyongzhang','/baoyongzhang/BigBang',12),('2016-10-27 03:49:17','/scouter-project/scouter','\n      Scouter is an open source APM and an open source profiler for java application like web applications on a tomcat .\n    ','bill23-kim','/scouter-project/scouter',13),('2016-10-27 03:49:17','/alibaba/weex','\n      A framework for building Mobile cross-platform UI\n    ','sospartan','/alibaba/weex',14),('2016-10-27 03:49:17','/spring-projects/spring-boot','\n      Spring Boot\n    ','philwebb','/spring-projects/spring-boot',15),('2016-10-27 03:49:17','/Tencent/tinker','\n      Tinker is a hot-fix solution library for Android, it supports dex, library and resources update without reinstall apk.\n    ','shwenzhang','/Tencent/tinker',16),('2016-10-27 03:49:17','/fabric8io/funktion','\n      funktion is an open source lambda style event driven programming model for Kubernetes\n    ','fusesource-ci','/fabric8io/funktion',17),('2016-10-27 03:49:17','/square/retrofit','\n      Type-safe HTTP client for Android and Java by Square, Inc.\n    ','JakeWharton','/square/retrofit',18),('2016-10-27 03:49:17','/DreaminginCodeZH/MaterialRatingBar','\n      Material Design RatingBar with better appearance.\n    ','DreaminginCodeZH','/DreaminginCodeZH/MaterialRatingBar',19),('2016-10-27 03:49:17','/Freelander/Elephant','\n      Elephant is PHPHub Community Android unofficial client, base on Material Design + MVP+RxJava+Retrofit .\n    ','Freelander','/Freelander/Elephant',20),('2016-10-27 03:49:17','/naver/pinpoint','\n      Pinpoint is an open source APM (Application Performance Management) tool for large-scale distributed systems written in Java. \n    ','emeroad','/naver/pinpoint',21),('2016-10-27 03:49:17','/iluwatar/java-design-patterns','\n      Design patterns implemented in Java\n    ','iluwatar','/iluwatar/java-design-patterns',22),('2016-10-27 03:49:17','/roughike/BottomBar','\n      A custom view component that mimics the new Material Design Bottom Navigation pattern.\n    ','roughike','/roughike/BottomBar',23),('2016-10-27 03:49:17','/TellH/GitClub','\n      An elegent Android Client for Github. 不仅仅是Github客户端，而且是一个发现优秀Github开源项目的app\n    ','TellH','/TellH/GitClub',24),('2016-10-27 03:49:17','/square/okhttp','\n      An HTTP+HTTP/2 client for Android and Java applications.\n    ','swankjesse','/square/okhttp',25);
/*!40000 ALTER TABLE `github_trending` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-04 13:56:29
