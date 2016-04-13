Ext.define('Hronee.hronee.web.com.view.humanresourceboundedcontext.employee.EmpInformationMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "EmpInformationMainController",
     "restURL": "/EmpInformation",
     "defaults": {
          "split": true
     },
     "requires": ["Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.EmpInformationModel", "Hronee.hronee.web.com.controller.humanresourceboundedcontext.employee.EmpInformationMainController", "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DepartmentTypeModel", "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DesignationTypeModel", "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.JobTypeModel", "Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Hronee.hronee.shared.com.viewmodel.humanresourceboundedcontext.employee.EmpInformationViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "displayName": "EmpInformation",
               "name": "EmpInformationTreeContainer",
               "itemId": "EmpInformationTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "EmpInformationTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": [{
                         "name": "deptTypeCode",
                         "itemId": "deptTypeCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Department",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DepartmentTypeModel"
                         },
                         "fieldLabel": "Department",
                         "fieldId": "CC23E1D6-89FF-4215-A0E6-45958D3F6BAD",
                         "restURL": "DepartmentType",
                         "bindable": "deptTypeCode"
                    }, {
                         "name": "designationTypeCode",
                         "itemId": "designationTypeCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Designation",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DesignationTypeModel"
                         },
                         "fieldLabel": "Designation",
                         "fieldId": "BB9A86E4-094B-45EF-A78B-942A57C46F88",
                         "restURL": "DesignationType",
                         "bindable": "designationTypeCode"
                    }, {
                         "name": "reportingOfficer",
                         "itemId": "reportingOfficer",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Reporting Officer",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Reporting Officer",
                         "fieldId": "2E015EE6-BD8A-48A8-9A83-BDDC187F2B00",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "reportingOfficer"
                    }, {
                         "name": "jobTypeCode",
                         "itemId": "jobTypeCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Job Type",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.JobTypeModel"
                         },
                         "fieldLabel": "Job Type",
                         "fieldId": "62CA6898-3A5D-44AC-BCF5-7D3686654912",
                         "restURL": "JobType",
                         "bindable": "jobTypeCode"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "xtype": "form",
                    "displayName": "EmpInformation",
                    "name": "EmpInformation",
                    "itemId": "EmpInformationForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "empId",
                                   "itemId": "empId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Employee Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Employee Id<font color='red'> *<\/font>",
                                   "fieldId": "5D5141EF-FD2B-49C6-B3F9-869BEECE9D53",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "empId"
                              }, {
                                   "name": "deptTypeCode",
                                   "itemId": "deptTypeCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Department",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DepartmentTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Department<font color='red'> *<\/font>",
                                   "fieldId": "CC23E1D6-89FF-4215-A0E6-45958D3F6BAD",
                                   "restURL": "DepartmentType",
                                   "bindable": "deptTypeCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "designationTypeCode",
                                   "itemId": "designationTypeCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Designation",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DesignationTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Designation<font color='red'> *<\/font>",
                                   "fieldId": "BB9A86E4-094B-45EF-A78B-942A57C46F88",
                                   "restURL": "DesignationType",
                                   "bindable": "designationTypeCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "reportingOfficer",
                                   "itemId": "reportingOfficer",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Reporting Officer",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Reporting Officer<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "2E015EE6-BD8A-48A8-9A83-BDDC187F2B00",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "reportingOfficer",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "pan",
                                   "itemId": "pan",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "PAN",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "PAN<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "2B5AE94E-833C-4F51-B765-B20BBC6555AB",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "pan",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "jobTypeCode",
                                   "itemId": "jobTypeCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Job Type",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.JobTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Job Type<font color='red'> *<\/font>",
                                   "fieldId": "62CA6898-3A5D-44AC-BCF5-7D3686654912",
                                   "restURL": "JobType",
                                   "bindable": "jobTypeCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "B495EA51-C4DA-4DCF-99C4-65B928A147FA",
                                   "bindable": "versionId",
                                   "hidden": true
                              }, {
                                   "xtype": "combo",
                                   "name": "CoreContacts",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "margin": 5,
                                   "bindable": "coreContacts.contactId",
                                   "typeAhead": true,
                                   "columnWidth": 0.5,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "Core Contacts<font color='red'> *<\/font>",
                                   "title": "Core Contacts",
                                   "itemId": "coreContacts",
                                   "store": {
                                        "data": [],
                                        "model": "Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                                   }
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "EmpInformation",
                    "title": "Details Grid",
                    "name": "EmpInformationGrid",
                    "itemId": "EmpInformationGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Employee Id",
                         "dataIndex": "empId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Department",
                         "dataIndex": "deptTypeCode",
                         "flex": 1
                    }, {
                         "header": "Designation",
                         "dataIndex": "designationTypeCode",
                         "flex": 1
                    }, {
                         "header": "Reporting Officer",
                         "dataIndex": "reportingOfficer",
                         "flex": 1
                    }, {
                         "header": "PAN",
                         "dataIndex": "pan",
                         "flex": 1
                    }, {
                         "header": "Job Type",
                         "dataIndex": "jobTypeCode",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "xtype": "form",
               "displayName": "EmpInformation",
               "name": "EmpInformation",
               "itemId": "EmpInformationForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "empId",
                              "itemId": "empId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Employee Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Employee Id<font color='red'> *<\/font>",
                              "fieldId": "5D5141EF-FD2B-49C6-B3F9-869BEECE9D53",
                              "hidden": true,
                              "value": "",
                              "bindable": "empId"
                         }, {
                              "name": "deptTypeCode",
                              "itemId": "deptTypeCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Department",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DepartmentTypeModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Department<font color='red'> *<\/font>",
                              "fieldId": "CC23E1D6-89FF-4215-A0E6-45958D3F6BAD",
                              "restURL": "DepartmentType",
                              "bindable": "deptTypeCode",
                              "columnWidth": 0.5
                         }, {
                              "name": "designationTypeCode",
                              "itemId": "designationTypeCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Designation",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DesignationTypeModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Designation<font color='red'> *<\/font>",
                              "fieldId": "BB9A86E4-094B-45EF-A78B-942A57C46F88",
                              "restURL": "DesignationType",
                              "bindable": "designationTypeCode",
                              "columnWidth": 0.5
                         }, {
                              "name": "reportingOfficer",
                              "itemId": "reportingOfficer",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Reporting Officer",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Reporting Officer<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "2E015EE6-BD8A-48A8-9A83-BDDC187F2B00",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "reportingOfficer",
                              "columnWidth": 0.5
                         }, {
                              "name": "pan",
                              "itemId": "pan",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "PAN",
                              "margin": "5 5 5 5",
                              "fieldLabel": "PAN<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "2B5AE94E-833C-4F51-B765-B20BBC6555AB",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "pan",
                              "columnWidth": 0.5
                         }, {
                              "name": "jobTypeCode",
                              "itemId": "jobTypeCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Job Type",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.JobTypeModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Job Type<font color='red'> *<\/font>",
                              "fieldId": "62CA6898-3A5D-44AC-BCF5-7D3686654912",
                              "restURL": "JobType",
                              "bindable": "jobTypeCode",
                              "columnWidth": 0.5
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "B495EA51-C4DA-4DCF-99C4-65B928A147FA",
                              "bindable": "versionId",
                              "hidden": true
                         }, {
                              "xtype": "combo",
                              "name": "CoreContacts",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "margin": 5,
                              "bindable": "coreContacts.contactId",
                              "typeAhead": true,
                              "columnWidth": 0.5,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "Core Contacts<font color='red'> *<\/font>",
                              "title": "Core Contacts",
                              "itemId": "coreContacts",
                              "store": {
                                   "data": [],
                                   "model": "Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                              }
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});