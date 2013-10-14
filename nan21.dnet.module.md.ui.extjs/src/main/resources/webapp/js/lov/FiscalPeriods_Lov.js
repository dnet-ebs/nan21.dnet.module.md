/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "FiscalPeriods_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_FiscalPeriods_Lov",
	displayField: "name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}, {[ Ext.util.Format.date(values.startDate,Dnet.DATE_FORMAT)  ]}, {[ Ext.util.Format.date(values.endDate,Dnet.DATE_FORMAT)  ]}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "FiscalPeriod_Ui",
		bundle: Dnet.bundle.md
	},
	recordModel: Dnet.ns.md + "FiscalPeriodLov_Ds"
});
