SET tx_isolation = 'READ-COMMITTED';
SET GLOBAL tx_isolation = 'READ-COMMITTED';

DROP DATABASE IF EXISTS KafkaData;
CREATE DATABASE KafkaData;

GRANT ALL PRIVILEGES ON KafkaData.* TO 'root'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON KafkaData.* TO 'root'@'localhost' IDENTIFIED BY 'password';

use KafkaData;
