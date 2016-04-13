Ext.define('Hronee.hronee.web.com.view.humanresourceboundedcontext.employee.EmployeeRegistration', {
     "xtype": "employeeRegistration",
     "items": [{
          "xtype": "panel",
          "items": [{
               "xtype": "form",
               "items": [{
                    "xtype": "panel",
                    "items": [{
                         "xtype": "combo",
                         "name": "titleId",
                         "margin": 5,
                         "bindable": "titleId",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 1,
                         "fieldLabel": "Title",
                         "displayField": "titles",
                         "valueField": "titleId",
                         "columnWidth": 0.5,
                         "itemId": "combo_ext_8220",
                         "store": {
                              "model": "Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.TitleModel",
                              "autoLoad": true,
                              "autoSync": true,
                              "sorters": [{
                                   "property": "titles",
                                   "direction": "ASC"
                              }],
                              "proxy": {
                                   "type": "ajax",
                                   "url": "secure/Title/findAll",
                                   "serviceId": "85C88CCB-60AC-42A1-9785-E6EA644ADF06",
                                   "serviceOperationId": "D963928F-D827-4F55-8287-A8AF687B74EE",
                                   "actionMethods": {
                                        "read": "GET"
                                   },
                                   "headers": {
                                        "Content-Type": "application/json"
                                   },
                                   "extraParams": {},
                                   "reader": {
                                        "type": "json",
                                        "rootProperty": "response.data"
                                   }
                              }
                         }
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "First Name",
                         "margin": 5,
                         "bindable": "firstName",
                         "name": "firstName",
                         "columnWidth": 0.5,
                         "itemId": "textfield_ext_8393"
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "Middle Name",
                         "margin": 5,
                         "bindable": "middleName",
                         "name": "middleName",
                         "columnWidth": 0.5,
                         "itemId": "textfield_ext_8530"
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "Last Name",
                         "margin": 5,
                         "bindable": "lastName",
                         "name": "lastName",
                         "columnWidth": 0.5,
                         "itemId": "textfield_ext_8671"
                    }, {
                         "xtype": "combo",
                         "name": "genderId",
                         "margin": 5,
                         "bindable": "genderId",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 1,
                         "fieldLabel": "Gender",
                         "displayField": "gender",
                         "valueField": "genderId",
                         "columnWidth": 0.5,
                         "itemId": "combo_ext_8823",
                         "store": {
                              "model": "Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.GenderModel",
                              "autoLoad": true,
                              "autoSync": true,
                              "sorters": [{
                                   "property": "gender",
                                   "direction": "ASC"
                              }],
                              "proxy": {
                                   "type": "ajax",
                                   "url": "secure/Gender/findAll",
                                   "serviceId": "5E0ED1BC-27C7-494E-BA22-CB5F678D9D51",
                                   "serviceOperationId": "AA379994-ACC9-40E5-8A2B-63E319E8E7FE",
                                   "actionMethods": {
                                        "read": "GET"
                                   },
                                   "headers": {
                                        "Content-Type": "application/json"
                                   },
                                   "extraParams": {},
                                   "reader": {
                                        "type": "json",
                                        "rootProperty": "response.data"
                                   }
                              }
                         }
                    }, {
                         "xtype": "customdatetimefield",
                         "fieldLabel": "DOB",
                         "name": "dateofbirth",
                         "bindable": "dateofbirth",
                         "margin": 5,
                         "columnWidth": 0.5,
                         "itemId": "customdatetimefield_ext_8976",
                         "submitFormat": "d-m-Y H:m:s"
                    }, {
                         "xtype": "customdatetimefield",
                         "fieldLabel": "Approx DOB",
                         "name": "approximateDOB",
                         "bindable": "approximateDOB",
                         "margin": 5,
                         "columnWidth": 0.5,
                         "itemId": "customdatetimefield_ext_9139",
                         "submitFormat": "d-m-Y H:m:s"
                    }, {
                         "xtype": "numberfield",
                         "fieldLabel": "Age",
                         "name": "age",
                         "margin": 5,
                         "bindable": "age",
                         "columnWidth": 0.5,
                         "itemId": "numberfield_ext_11190"
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "Email ID",
                         "margin": 5,
                         "bindable": "emailId",
                         "name": "emailId",
                         "columnWidth": 0.5,
                         "itemId": "textfield_ext_11362"
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "Phone Number",
                         "margin": 5,
                         "bindable": "phoneNumber",
                         "name": "phoneNumber",
                         "columnWidth": 0.5,
                         "itemId": "textfield_ext_11599"
                    }, {
                         "xtype": "combo",
                         "name": "timeZoneId",
                         "margin": 5,
                         "bindable": "timeZoneId",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 1,
                         "fieldLabel": "Time Zone",
                         "displayField": "timeZoneLabel",
                         "valueField": "timeZoneId",
                         "columnWidth": 0.5,
                         "itemId": "combo_ext_11786",
                         "store": {
                              "model": "Hronee.hronee.shared.com.model.organizationboundedcontext.location.TimezoneModel",
                              "autoLoad": true,
                              "autoSync": true,
                              "sorters": [{
                                   "property": "timeZoneLabel",
                                   "direction": "ASC"
                              }],
                              "proxy": {
                                   "type": "ajax",
                                   "url": "secure/Timezone/findAll",
                                   "serviceId": "052BF97F-10CD-43BD-9522-FE110346E5C9",
                                   "serviceOperationId": "B772FF5B-9A1A-4925-9107-1657245DBD95",
                                   "actionMethods": {
                                        "read": "GET"
                                   },
                                   "headers": {
                                        "Content-Type": "application/json"
                                   },
                                   "extraParams": {},
                                   "reader": {
                                        "type": "json",
                                        "rootProperty": "response.data"
                                   }
                              }
                         }
                    }],
                    "layout": "column",
                    "autoScroll": true,
                    "border": true,
                    "title": "Column Layout",
                    "margin": 5,
                    "dockedItems": [],
                    "itemId": "panel_ext_8179"
               }],
               "border": true,
               "autoScroll": true,
               "title": "Form",
               "margin": 5,
               "dockedItems": [],
               "itemId": "form_ext_8144"
          }],
          "layout": "fit",
          "bodyBorder": true,
          "bodyPadding": 0,
          "border": true,
          "title": "Tab-1",
          "tabId": 1,
          "dockedItems": [],
          "itemId": "panel_ext_8049"
     }, {
          "xtype": "panel",
          "items": [{
               "xtype": "panel",
               "isFormGridPanel": true,
               "items": [{
                    "xtype": "panel",
                    "items": [{
                         "xtype": "form",
                         "name": "AddressForm",
                         "items": [{
                              "xtype": "panel",
                              "items": [{
                                   "xtype": "combo",
                                   "name": "addressTypeId",
                                   "margin": 5,
                                   "bindable": "addressTypeId",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "Address Type",
                                   "displayField": "addressType",
                                   "valueField": "addressTypeId",
                                   "columnWidth": 0.5,
                                   "itemId": "combo_ext_48855",
                                   "store": {
                                        "model": "Hronee.hronee.shared.com.model.organizationboundedcontext.location.AddressTypeModel",
                                        "autoLoad": true,
                                        "autoSync": true,
                                        "sorters": [{
                                             "property": "addressType",
                                             "direction": "ASC"
                                        }],
                                        "proxy": {
                                             "type": "ajax",
                                             "url": "secure/AddressType/findAll",
                                             "serviceId": "E1FA086F-B359-4747-902D-09D92C6872FA",
                                             "serviceOperationId": "FF3F80B4-BF0A-4E9E-8123-E3CE710F30E6",
                                             "actionMethods": {
                                                  "read": "GET"
                                             },
                                             "headers": {
                                                  "Content-Type": "application/json"
                                             },
                                             "extraParams": {},
                                             "reader": {
                                                  "type": "json",
                                                  "rootProperty": "response.data"
                                             }
                                        }
                                   }
                              }, {
                                   "xtype": "textfield",
                                   "fieldLabel": "Address Label",
                                   "margin": 5,
                                   "bindable": "addressLabel",
                                   "name": "addressLabel",
                                   "columnWidth": 0.5,
                                   "itemId": "textfield_ext_49156"
                              }, {
                                   "xtype": "textareafield",
                                   "fieldLabel": "Address1",
                                   "name": "address1",
                                   "margin": 5,
                                   "bindable": "address1",
                                   "columnWidth": 0.5,
                                   "itemId": "textareafield_ext_49474"
                              }, {
                                   "xtype": "textareafield",
                                   "fieldLabel": "Address2",
                                   "name": "address2",
                                   "margin": 5,
                                   "bindable": "address2",
                                   "columnWidth": 0.5,
                                   "itemId": "textareafield_ext_49806"
                              }, {
                                   "xtype": "combo",
                                   "name": "countryId",
                                   "margin": 5,
                                   "bindable": "countryId",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "Country",
                                   "displayField": "countryName",
                                   "valueField": "countryId",
                                   "columnWidth": 0.5,
                                   "itemId": "combo_ext_50150",
                                   "store": {
                                        "model": "Hronee.hronee.shared.com.model.organizationboundedcontext.location.CountryModel",
                                        "autoLoad": true,
                                        "autoSync": true,
                                        "sorters": [{
                                             "property": "countryName",
                                             "direction": "ASC"
                                        }],
                                        "proxy": {
                                             "type": "ajax",
                                             "url": "secure/Country/findAll",
                                             "serviceId": "8A3046A8-891B-48DE-999C-429C9D17C61D",
                                             "serviceOperationId": "DE9328D2-ECFE-4260-B1A6-46E1CEF260CB",
                                             "actionMethods": {
                                                  "read": "GET"
                                             },
                                             "headers": {
                                                  "Content-Type": "application/json"
                                             },
                                             "extraParams": {},
                                             "reader": {
                                                  "type": "json",
                                                  "rootProperty": "response.data"
                                             }
                                        }
                                   },
                                   "listeners": {
                                        "change": "onCountryIdChange"
                                   }
                              }, {
                                   "xtype": "combo",
                                   "name": "stateId",
                                   "margin": 5,
                                   "bindable": "stateId",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "State",
                                   "displayField": "stateName",
                                   "valueField": "stateId",
                                   "columnWidth": 0.5,
                                   "isRelatedWith": "eogkmdhli",
                                   "itemId": "combo_ext_50511",
                                   "listeners": {
                                        "change": "onStateIdChange"
                                   }
                              }, {
                                   "xtype": "combo",
                                   "name": "cityId",
                                   "margin": 5,
                                   "bindable": "cityId",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "City",
                                   "displayField": "cityName",
                                   "valueField": "cityId",
                                   "columnWidth": 0.5,
                                   "isRelatedWith": "emngebogi",
                                   "itemId": "combo_ext_50888"
                              }, {
                                   "xtype": "textfield",
                                   "fieldLabel": "Postal Code",
                                   "margin": 5,
                                   "bindable": "zipcode",
                                   "name": "zipcode",
                                   "columnWidth": 0.5,
                                   "itemId": "textfield_ext_51280"
                              }],
                              "layout": "column",
                              "autoScroll": true,
                              "border": true,
                              "title": "Column Layout",
                              "margin": 5,
                              "dockedItems": [],
                              "itemId": "panel_ext_48746"
                         }],
                         "border": true,
                         "autoScroll": true,
                         "title": "Detail",
                         "margin": 5,
                         "fwgDetailForm": true,
                         "region": "center",
                         "dockedItems": [{
                              "xtype": "toolbar",
                              "dock": "bottom",
                              "ui": "footer",
                              "isToolBar": true,
                              "margin": 0,
                              "isDockedItem": true,
                              "items": [{
                                   "xtype": "button",
                                   "text": "Add",
                                   "margin": 5,
                                   "name": "AddressFormAddButton",
                                   "itemId": "addButton",
                                   "listeners": {
                                        "click": "onAddressFormAddButtonClick"
                                   }
                              }, {
                                   "xtype": "button",
                                   "text": "Reset",
                                   "margin": 5,
                                   "name": "AddressFormResetButton",
                                   "itemId": "resetButton",
                                   "isResetFormGridButton": true,
                                   "listeners": {
                                        "click": "onAddressFormResetButtonClick"
                                   }
                              }]
                         }],
                         "itemId": "form_ext_48655"
                    }, {
                         "xtype": "grids",
                         "name": "address",
                         "title": "Address List",
                         "hiddenName": "Grid",
                         "margin": 5,
                         "collapseMode": "header",
                         "bindable": "address",
                         "border": true,
                         "editTools": false,
                         "features": [],
                         "plugins": [{
                              "ptype": "cellediting",
                              "clicksToEdit": 1
                         }],
                         "columns": [{
                              "xtype": "gridcolumn",
                              "dataIndex": "addressTypeId",
                              "header": "Address Type",
                              "text": "Address Type",
                              "flex": 1,
                              "refCmp": "ejiiccdli"
                         }, {
                              "xtype": "gridcolumn",
                              "dataIndex": "addressLabel",
                              "header": "Address Label",
                              "text": "Address Label",
                              "flex": 1,
                              "refCmp": "cdbffhjni"
                         }, {
                              "xtype": "gridcolumn",
                              "dataIndex": "address1",
                              "header": "Address1",
                              "text": "Address1",
                              "flex": 1,
                              "refCmp": "ngcfbigpi"
                         }, {
                              "xtype": "gridcolumn",
                              "dataIndex": "address2",
                              "header": "Address2",
                              "text": "Address2",
                              "flex": 1,
                              "refCmp": "ofakdfici"
                         }, {
                              "xtype": "gridcolumn",
                              "dataIndex": "countryId",
                              "header": "Country",
                              "text": "Country",
                              "flex": 1,
                              "refCmp": "eogkmdhli"
                         }, {
                              "xtype": "gridcolumn",
                              "dataIndex": "stateId",
                              "header": "State",
                              "text": "State",
                              "flex": 1,
                              "refCmp": "emngebogi"
                         }, {
                              "xtype": "gridcolumn",
                              "dataIndex": "cityId",
                              "header": "City",
                              "text": "City",
                              "flex": 1,
                              "refCmp": "glhigofgi"
                         }, {
                              "xtype": "gridcolumn",
                              "dataIndex": "zipcode",
                              "header": "Postal Code",
                              "text": "Postal Code",
                              "flex": 1,
                              "refCmp": "khggojgoi"
                         }],
                         "fwgListGrid": true,
                         "region": "south",
                         "height": "20%",
                         "collapsible": true,
                         "isRelatedWith": "emngebogi",
                         "itemId": "gridpanel_ext_48656",
                         "tools": [{
                              "type": "refresh",
                              "tooltip": "Refresh Grid Data",
                              "handler": "onGridRefreshClick"
                         }],
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "listeners": {
                              "rowclick": "onAddressRowclick"
                         }
                    }],
                    "margin": 5,
                    "border": true,
                    "autoScroll": false,
                    "title": "Panel",
                    "layout": "border",
                    "height": 400,
                    "width": 400,
                    "bodyStyle": {
                         "background": "#ffffff"
                    },
                    "header": {
                         "hidden": true
                    },
                    "dockedItems": [],
                    "itemId": "panel_ext_48654"
               }],
               "margin": "5 5 5 5",
               "layout": "fit",
               "title": "Form With Grid",
               "height": 400,
               "width": 400,
               "dockedItems": [],
               "itemId": "panel_ext_48653"
          }],
          "layout": "fit",
          "bodyBorder": true,
          "bodyPadding": 0,
          "border": true,
          "title": "Tab-2",
          "tabId": 2,
          "dockedItems": [],
          "itemId": "panel_ext_48595"
     }, {
          "xtype": "panel",
          "items": [{
               "xtype": "panel",
               "isFormGridPanel": true,
               "items": [{
                    "xtype": "panel",
                    "items": [{
                         "xtype": "form",
                         "name": "CommunicationInfo",
                         "items": [{
                              "xtype": "panel",
                              "items": [{
                                   "xtype": "combo",
                                   "name": "commGroupId",
                                   "margin": 5,
                                   "bindable": "commGroupId",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "Communication Group",
                                   "displayField": "commGroupName",
                                   "valueField": "commGroupId",
                                   "columnWidth": 0.5,
                                   "itemId": "combo_ext_56962",
                                   "store": {
                                        "model": "Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel",
                                        "autoLoad": true,
                                        "autoSync": true,
                                        "sorters": [{
                                             "property": "commGroupName",
                                             "direction": "ASC"
                                        }],
                                        "proxy": {
                                             "type": "ajax",
                                             "url": "secure/CommunicationGroup/findAll",
                                             "serviceId": "9F09F79A-8CDB-4296-80A4-1B0C6E41B0A9",
                                             "serviceOperationId": "56B65273-1F81-4756-A03F-667EDF7C5532",
                                             "actionMethods": {
                                                  "read": "GET"
                                             },
                                             "headers": {
                                                  "Content-Type": "application/json"
                                             },
                                             "extraParams": {},
                                             "reader": {
                                                  "type": "json",
                                                  "rootProperty": "response.data"
                                             }
                                        }
                                   }
                              }, {
                                   "xtype": "combo",
                                   "name": "commType",
                                   "margin": 5,
                                   "bindable": "commType",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "Communication Type",
                                   "displayField": "commTypeName",
                                   "valueField": "commType",
                                   "columnWidth": 0.5,
                                   "itemId": "combo_ext_57448",
                                   "store": {
                                        "model": "Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.CommunicationTypeModel",
                                        "autoLoad": true,
                                        "autoSync": true,
                                        "sorters": [{
                                             "property": "commTypeName",
                                             "direction": "ASC"
                                        }],
                                        "proxy": {
                                             "type": "ajax",
                                             "url": "secure/CommunicationType/findAll",
                                             "serviceId": "236F284D-6C56-4E28-B1C6-A34E42BD31D0",
                                             "serviceOperationId": "EEE38651-477E-4E55-A483-B2896641D449",
                                             "actionMethods": {
                                                  "read": "GET"
                                             },
                                             "headers": {
                                                  "Content-Type": "application/json"
                                             },
                                             "extraParams": {},
                                             "reader": {
                                                  "type": "json",
                                                  "rootProperty": "response.data"
                                             }
                                        }
                                   }
                              }, {
                                   "xtype": "textfield",
                                   "fieldLabel": "Communication Data",
                                   "margin": 5,
                                   "bindable": "commData",
                                   "name": "commData",
                                   "columnWidth": 0.5,
                                   "itemId": "textfield_ext_58289"
                              }],
                              "layout": "column",
                              "autoScroll": true,
                              "border": true,
                              "title": "Column Layout",
                              "margin": 5,
                              "dockedItems": [],
                              "itemId": "panel_ext_56805"
                         }],
                         "border": true,
                         "autoScroll": true,
                         "title": "Communication Data",
                         "margin": 5,
                         "fwgDetailForm": true,
                         "region": "center",
                         "dockedItems": [{
                              "xtype": "toolbar",
                              "dock": "bottom",
                              "ui": "footer",
                              "isToolBar": true,
                              "margin": 0,
                              "isDockedItem": true,
                              "items": [{
                                   "xtype": "button",
                                   "text": "Add",
                                   "margin": 5,
                                   "name": "CommunicationInfoAddButton",
                                   "itemId": "addButton",
                                   "listeners": {
                                        "click": "onCommunicationInfoAddButtonClick"
                                   }
                              }, {
                                   "xtype": "button",
                                   "text": "Reset",
                                   "margin": 5,
                                   "name": "CommunicationInfoResetButton",
                                   "itemId": "resetButton",
                                   "isResetFormGridButton": true,
                                   "listeners": {
                                        "click": "onCommunicationInfoResetButtonClick"
                                   }
                              }]
                         }],
                         "itemId": "form_ext_55632"
                    }, {
                         "xtype": "grids",
                         "name": "communicationData",
                         "title": "Communication Data",
                         "hiddenName": "Grid",
                         "margin": 5,
                         "collapseMode": "header",
                         "bindable": "communicationData",
                         "border": true,
                         "editTools": false,
                         "features": [],
                         "plugins": [{
                              "ptype": "cellediting",
                              "clicksToEdit": 1
                         }],
                         "columns": [{
                              "xtype": "gridcolumn",
                              "dataIndex": "commGroupId",
                              "header": "Communication Group",
                              "text": "Communication Group",
                              "flex": 1,
                              "refCmp": "fkhlgfkdi"
                         }, {
                              "xtype": "gridcolumn",
                              "dataIndex": "commType",
                              "header": "Communication Type",
                              "text": "Communication Type",
                              "flex": 1,
                              "refCmp": "edjmgcpei"
                         }, {
                              "xtype": "gridcolumn",
                              "dataIndex": "commData",
                              "header": "Communication Data",
                              "text": "Communication Data",
                              "flex": 1,
                              "refCmp": "aafodbiai"
                         }],
                         "fwgListGrid": true,
                         "region": "south",
                         "height": "20%",
                         "collapsible": true,
                         "itemId": "gridpanel_ext_55633",
                         "tools": [{
                              "type": "refresh",
                              "tooltip": "Refresh Grid Data",
                              "handler": "onGridRefreshClick"
                         }],
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "listeners": {
                              "rowclick": "onCommunicationDataRowclick"
                         }
                    }],
                    "margin": 5,
                    "border": true,
                    "autoScroll": false,
                    "title": "Panel",
                    "layout": "border",
                    "height": 400,
                    "width": 400,
                    "bodyStyle": {
                         "background": "#ffffff"
                    },
                    "header": {
                         "hidden": true
                    },
                    "dockedItems": [],
                    "itemId": "panel_ext_55631"
               }],
               "margin": "5 5 5 5",
               "layout": "fit",
               "title": "Form With Grid",
               "height": 400,
               "width": 400,
               "dockedItems": [],
               "itemId": "panel_ext_55630"
          }],
          "layout": "fit",
          "bodyBorder": true,
          "bodyPadding": 0,
          "border": true,
          "title": "Tab-3",
          "tabId": 3,
          "dockedItems": [],
          "itemId": "panel_ext_55507"
     }, {
          "xtype": "panel",
          "items": [{
               "xtype": "form",
               "items": [{
                    "xtype": "panel",
                    "items": [{
                         "xtype": "combo",
                         "name": "deptTypeCode",
                         "margin": 5,
                         "bindable": "deptTypeCode",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 1,
                         "fieldLabel": "Department",
                         "displayField": "deptTypeDesc",
                         "valueField": "deptTypeCode",
                         "columnWidth": 0.5,
                         "itemId": "combo_ext_3605",
                         "store": {
                              "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DepartmentTypeModel",
                              "autoLoad": true,
                              "autoSync": true,
                              "sorters": [{
                                   "property": "deptTypeDesc",
                                   "direction": "ASC"
                              }],
                              "proxy": {
                                   "type": "ajax",
                                   "url": "secure/DepartmentType/findAll",
                                   "serviceId": "D311AE31-AA3A-4B50-8AC5-6A00403D31BC",
                                   "serviceOperationId": "5B689767-2EEC-439E-A635-50195CECFECE",
                                   "actionMethods": {
                                        "read": "GET"
                                   },
                                   "headers": {
                                        "Content-Type": "application/json"
                                   },
                                   "extraParams": {},
                                   "reader": {
                                        "type": "json",
                                        "rootProperty": "response.data"
                                   }
                              }
                         }
                    }, {
                         "xtype": "combo",
                         "name": "designationTypeCode",
                         "margin": 5,
                         "bindable": "designationTypeCode",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 1,
                         "fieldLabel": "Designation",
                         "displayField": "designatnTypeDesc",
                         "valueField": "designatnTypeCode",
                         "columnWidth": 0.5,
                         "itemId": "combo_ext_4113",
                         "store": {
                              "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DesignationTypeModel",
                              "autoLoad": true,
                              "autoSync": true,
                              "sorters": [{
                                   "property": "designatnTypeDesc",
                                   "direction": "ASC"
                              }],
                              "proxy": {
                                   "type": "ajax",
                                   "url": "secure/DesignationType/findAll",
                                   "serviceId": "E749C833-2DB8-4C4A-8FC8-387BF7118227",
                                   "serviceOperationId": "DDE48872-E77B-4854-8C0B-53B98E974783",
                                   "actionMethods": {
                                        "read": "GET"
                                   },
                                   "headers": {
                                        "Content-Type": "application/json"
                                   },
                                   "extraParams": {},
                                   "reader": {
                                        "type": "json",
                                        "rootProperty": "response.data"
                                   }
                              }
                         }
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "Reporting Officer",
                         "margin": 5,
                         "bindable": "reportingOfficer",
                         "name": "reportingOfficer",
                         "columnWidth": 0.5,
                         "itemId": "textfield_ext_4623"
                    }, {
                         "xtype": "textfield",
                         "fieldLabel": "PAN",
                         "margin": 5,
                         "bindable": "pan",
                         "name": "pan",
                         "columnWidth": 0.5,
                         "itemId": "textfield_ext_5141"
                    }, {
                         "xtype": "combo",
                         "name": "jobTypeCode",
                         "margin": 5,
                         "bindable": "jobTypeCode",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 1,
                         "fieldLabel": "Job Type",
                         "displayField": "jobDesc",
                         "valueField": "jobTypeCode",
                         "columnWidth": 0.5,
                         "itemId": "combo_ext_5665",
                         "store": {
                              "model": "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.JobTypeModel",
                              "autoLoad": true,
                              "autoSync": true,
                              "sorters": [{
                                   "property": "jobDesc",
                                   "direction": "ASC"
                              }],
                              "proxy": {
                                   "type": "ajax",
                                   "url": "secure/JobType/findAll",
                                   "serviceId": "623FEC14-6BB6-4090-B0FE-ED752FCC9A7B",
                                   "serviceOperationId": "63D6528D-E368-4917-B6DC-686BB83C99D6",
                                   "actionMethods": {
                                        "read": "GET"
                                   },
                                   "headers": {
                                        "Content-Type": "application/json"
                                   },
                                   "extraParams": {},
                                   "reader": {
                                        "type": "json",
                                        "rootProperty": "response.data"
                                   }
                              }
                         }
                    }, {
                         "xtype": "hiddenfield",
                         "fieldLabel": "contactId",
                         "bindable": "contactId",
                         "margin": 5,
                         "name": "contactId",
                         "columnWidth": 0.5,
                         "itemId": "hiddenfield_ext_6206"
                    }],
                    "layout": "column",
                    "autoScroll": true,
                    "border": true,
                    "title": "Column Layout",
                    "margin": 5,
                    "dockedItems": [],
                    "itemId": "panel_ext_3425"
               }],
               "border": true,
               "autoScroll": true,
               "title": "Form",
               "margin": 5,
               "dockedItems": [],
               "itemId": "form_ext_3265"
          }],
          "layout": "fit",
          "bodyBorder": true,
          "bodyPadding": 0,
          "border": true,
          "title": "Tab-4",
          "tabId": 4,
          "dockedItems": [],
          "itemId": "panel_ext_3107"
     }],
     "autoScroll": true,
     "activeItem": 0,
     "activeTab": 0,
     "title": "Tab Layout",
     "margin": 5,
     "dockedItems": [{
          "xtype": "toolbar",
          "dock": "bottom",
          "ui": "footer",
          "isToolBar": true,
          "isDockedItem": true,
          "items": [{
               "xtype": "tbfill",
               "itemId": "tbfill_ext_1798"
          }, {
               "xtype": "button",
               "name": "save",
               "text": "save",
               "margin": 5,
               "itemId": "button_ext_1975",
               "listeners": {
                    "click": "onSaveClick"
               }
          }, {
               "xtype": "tbfill",
               "itemId": "tbfill_ext_2154"
          }],
          "itemId": "toolbar_ext_1567",
          "dockedItems": []
     }],
     "itemId": "tabpanel_ext_8036",
     "requires": ["Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.TitleModel", "Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.GenderModel", "Hronee.hronee.shared.com.model.organizationboundedcontext.location.TimezoneModel", "Hronee.hronee.shared.com.model.organizationboundedcontext.location.CountryModel", "Hronee.hronee.shared.com.model.organizationboundedcontext.location.AddressTypeModel", "Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel", "Hronee.hronee.shared.com.model.organizationboundedcontext.contacts.CommunicationTypeModel", "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DepartmentTypeModel", "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.DesignationTypeModel", "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.JobTypeModel", "Hronee.hronee.web.com.controller.humanresourceboundedcontext.employee.EmployeeRegistrationController", "Hronee.hronee.shared.com.viewmodel.humanresourceboundedcontext.employee.EmployeeRegistrationViewModel", "Hronee.hronee.shared.com.model.humanresourceboundedcontext.employee.EmployeeRegistrationModel", "Hronee.view.fw.component.DateTimeField", "Hronee.view.fw.component.DateTimePicker", "Hronee.view.fw.component.Grids", "Hronee.view.fw.component.Grids"],
     "extend": "Ext.tab.Panel",
     "viewModel": "EmployeeRegistrationViewModel",
     "controller": "EmployeeRegistrationController"
});