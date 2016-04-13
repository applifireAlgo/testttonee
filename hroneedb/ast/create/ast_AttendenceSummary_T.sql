DROP TABLE IF EXISTS `ast_AttendenceSummary_T`;

CREATE TABLE `ast_AttendenceSummary_T` ( `attendenceSummaryId` VARCHAR(256) NOT NULL, `empId` VARCHAR(256) NOT NULL, `monthValue` INT(10) NOT NULL, `yearValue` INT(10) NOT NULL, `present` INT(10) NOT NULL, `absent` INT(10) NOT NULL, `privilegeLeave` INT(10) NOT NULL, `casualLeave` INT(10) NOT NULL, `sickLeave` INT(10) NOT NULL, `maternityLeave` INT(10) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2016-04-11 15:22:47', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2016-04-11 15:22:47', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`attendenceSummaryId`));

