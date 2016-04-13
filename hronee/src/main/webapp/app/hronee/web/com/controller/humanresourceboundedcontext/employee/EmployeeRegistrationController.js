Ext.define('Hronee.hronee.web.com.controller.humanresourceboundedcontext.employee.EmployeeRegistrationController', {
     extend: 'Hronee.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.EmployeeRegistrationController',
     onCommunicationInfoAddButtonClick: function(me, e, eOpts) {
          var form = me.up('form');
          var grid = form.up().down('grids');
          if (form.isValid()) {
               var formData = this.getData(form);
               if (grid.selection) {
                    grid.selection.data = formData;
               } else {
                    grid.getStore().add(formData);
               }
               grid.reconfigure();
               form.reset();
               grid.setSelection();
          }
     },
     onCountryIdChange: function(me, newValue, oldValue, eOpts) {
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_50150').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/State/findByCountryId',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         var responseData = responseText.response.data;
                         var combo_ext_50511 = scope.sender.down('#combo_ext_50511');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_50511, 'stateName', 'stateId');
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     },
     onStateIdChange: function(me, newValue, oldValue, eOpts) {
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_50511').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/City/findByStateId',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         var responseData = responseText.response.data;
                         var combo_ext_50888 = scope.sender.down('#combo_ext_50888');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_50888, 'cityName', 'cityId');
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     },
     onCommunicationDataRowclick: function(me, record, tr, rowIndex, e, eOpts) {
          var formPanel = me.up().up().down('form');
          formPanel.loadRecord(record);
     },
     onAddressFormAddButtonClick: function(me, e, eOpts) {
          var form = me.up('form');
          var grid = form.up().down('grids');
          if (form.isValid()) {
               var formData = this.getData(form);
               if (grid.selection) {
                    grid.selection.data = formData;
               } else {
                    grid.getStore().add(formData);
               }
               grid.reconfigure();
               form.reset();
               grid.setSelection();
          }
     },
     onSaveClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#combo_ext_8220'), this.view.down('#textfield_ext_8393'), this.view.down('#textfield_ext_8530'), this.view.down('#textfield_ext_8671'), this.view.down('#combo_ext_8823'), this.view.down('#customdatetimefield_ext_8976'), this.view.down('#numberfield_ext_11190'), this.view.down('#customdatetimefield_ext_9139'), this.view.down('#textfield_ext_11362'), this.view.down('#textfield_ext_11599'), this.view.down('#combo_ext_11786')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.titleId = this.view.down('#combo_ext_8220').getValue();
          jsonData.firstName = this.view.down('#textfield_ext_8393').getValue();
          jsonData.middleName = this.view.down('#textfield_ext_8530').getValue();
          jsonData.lastName = this.view.down('#textfield_ext_8671').getValue();
          jsonData.genderId = this.view.down('#combo_ext_8823').getValue();
          jsonData.dateofbirth = this.view.down('#customdatetimefield_ext_8976').getValues();
          jsonData.age = this.view.down('#numberfield_ext_11190').getValue();
          jsonData.approximateDOB = this.view.down('#customdatetimefield_ext_9139').getValues();
          jsonData.emailId = this.view.down('#textfield_ext_11362').getValue();
          jsonData.phoneNumber = this.view.down('#textfield_ext_11599').getValue();
          jsonData.address = this.view.down('#gridpanel_ext_48656').getValues();
          jsonData.timezone = {};
          jsonData.timezone.timeZoneId = this.view.down('#combo_ext_11786').getValue();
          jsonData.communicationData = this.view.down('#gridpanel_ext_55633').getValues();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/CoreContacts/',
               async: false,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                         var responseData = responseText.response.data;
                         scope.sender.down('#hiddenfield_ext_6206').setValue(responseData.contactId);
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
          var componentArray = [this.view.down('#combo_ext_3605'), this.view.down('#combo_ext_4113'), this.view.down('#textfield_ext_4623'), this.view.down('#textfield_ext_5141'), this.view.down('#combo_ext_5665'), this.view.down('#hiddenfield_ext_6206')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.deptTypeCode = this.view.down('#combo_ext_3605').getValue();
          jsonData.designationTypeCode = this.view.down('#combo_ext_4113').getValue();
          jsonData.reportingOfficer = this.view.down('#textfield_ext_4623').getValue();
          jsonData.pan = this.view.down('#textfield_ext_5141').getValue();
          jsonData.jobTypeCode = this.view.down('#combo_ext_5665').getValue();
          jsonData.coreContacts = {};
          jsonData.coreContacts.contactId = this.view.down('#hiddenfield_ext_6206').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/EmpInformation/',
               async: false,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', 'Employee Registered Successfully');
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     },
     onAddressRowclick: function(me, record, tr, rowIndex, e, eOpts) {
          var formPanel = me.up().up().down('form');
          formPanel.loadRecord(record);
     },
     onAddressFormResetButtonClick: function(me, e, eOpts) {
          var form = me.up('form');
          form.reset();
          var grid = form.up().down('grids');
          grid.setSelection();
     },
     onCommunicationInfoResetButtonClick: function(me, e, eOpts) {
          var form = me.up('form');
          form.reset();
          var grid = form.up().down('grids');
          grid.setSelection();
     }
});