DROP TABLE IF EXISTS `ast_Login_T`;

CREATE TABLE `ast_Login_T` ( `loginPk` VARCHAR(64) NOT NULL, `loginId` VARCHAR(200) NOT NULL, `serverAuthImage` VARCHAR(64) NULL DEFAULT NULL, `serverAuthText` VARCHAR(32) NULL DEFAULT NULL, `userId` VARCHAR(64) NOT NULL, `contactId` VARCHAR(64) NOT NULL, `failedLoginAttempts` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2016-04-11 15:22:47', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2016-04-11 15:22:47', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`loginPk`));

