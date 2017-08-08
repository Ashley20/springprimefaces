CREATE TABLE `messages` (
  `MESSAGE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUBJECT` varchar(45) NOT NULL,
  `CONTENT` varchar(145) NOT NULL,
  `MESSAGE_READ` varchar(3) NOT NULL,
  `DATE` DATETIME,
  
  PRIMARY KEY (`MESSAGE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('1', '1', '1', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('2', '2', '2', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('3', '3', '3', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('4', '4', '4', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('5', '5', '5', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('6', '6', '6', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('7', '7', '7', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('8', '8', '8', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('9', '9', '9', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('10', '10', '10', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('11', '11', '11', 'NO', now());
INSERT INTO `sys`.`messages` (`MESSAGE_ID`, `SUBJECT`, `CONTENT`, `MESSAGE_READ`, `DATE`) VALUES ('12', '12', '12', 'NO', now());
