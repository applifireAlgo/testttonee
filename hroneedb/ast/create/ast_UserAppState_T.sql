DROP TABLE IF EXISTS `ast_UserAppState_T`;

CREATE TABLE `ast_UserAppState_T` ( `appStateId` VARCHAR(64) NOT NULL, `AppSessionId` VARCHAR(256) NOT NULL, `TabId` VARCHAR(11) NOT NULL, `isActive` INT(11) NOT NULL DEFAULT '0', `sessionDataType` VARCHAR(11) NULL DEFAULT NULL, `sessionData` VARCHAR(4000) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2016-04-11 15:22:47', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2016-04-11 15:22:47', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`appStateId`));

