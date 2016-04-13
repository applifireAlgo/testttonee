Ext.define('Hronee.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Hronee.view.appreportui.ReportViewController',
	            'Hronee.view.appreportui.datagrid.DataGridPanel',
	            'Hronee.view.appreportui.datagrid.DataGridView',
	            'Hronee.view.appreportui.querycriteria.QueryCriteriaView',
	            'Hronee.view.appreportui.chart.ChartView',
	            'Hronee.view.appreportui.datapoint.DataPointView',
	            'Hronee.view.googlemaps.map.MapPanel',
	            'Hronee.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
