

ALTER TABLE `ast_EmpInformation_T` ADD CONSTRAINT FOREIGN KEY (`contactId`) REFERENCES `ast_CoreContacts_T`(`contactId`);



ALTER TABLE `ast_EmpInformation_T` ADD CONSTRAINT FOREIGN KEY (`deptTypeCode`) REFERENCES `ast_DepartmentType_M`(`deptTypeCode`);



ALTER TABLE `ast_EmpInformation_T` ADD CONSTRAINT FOREIGN KEY (`designationTypeCode`) REFERENCES `ast_DesignationType_M`(`designatnTypeCode`);



ALTER TABLE `ast_EmpInformation_T` ADD CONSTRAINT FOREIGN KEY (`jobTypeCode`) REFERENCES `ast_JobType_M`(`jobTypeCode`);

