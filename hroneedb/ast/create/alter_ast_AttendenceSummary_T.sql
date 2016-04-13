

ALTER TABLE `ast_AttendenceSummary_T` ADD CONSTRAINT FOREIGN KEY (`empId`) REFERENCES `ast_EmpInformation_T`(`empId`);

