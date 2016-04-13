Ext.define('Hronee.view.databrowsercalendar.DBCalendar', {
	extend : 'Hronee.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Hronee.view.databrowsercalendar.DBCalendarController',
	             'Hronee.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
