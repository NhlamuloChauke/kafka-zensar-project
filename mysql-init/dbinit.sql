SET tx_isolation = 'READ-COMMITTED';
SET GLOBAL tx_isolation = 'READ-COMMITTED';

DROP DATABASE IF EXISTS KafkaData;
CREATE DATABASE KafkaData;

GRANT ALL PRIVILEGES ON KafkaData.* TO 'root'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON KafkaData.* TO 'root'@'localhost' IDENTIFIED BY 'password';

use KafkaData;

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
