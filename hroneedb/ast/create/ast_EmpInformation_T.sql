DROP TABLE IF EXISTS `ast_EmpInformation_T`;

CREATE TABLE `ast_EmpInformation_T` ( `empId` VARCHAR(256) NOT NULL, `contactId` VARCHAR(64) NOT NULL, `deptTypeCode` VARCHAR(256) NOT NULL, `designationTypeCode` VARCHAR(256) NOT NULL, `reportingOfficer` VARCHAR(256) NOT NULL, `pan` VARCHAR(256) NOT NULL, `jobTypeCode` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2016-04-11 15:22:47', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2016-04-11 15:22:47', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`empId`));

