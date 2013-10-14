/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "FiscalPeriod_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.FiscalPeriod_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("period", Ext.create(Dnet.ns.md + "FiscalPeriod_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("period", {name:"periodFilter", xtype:"md_FiscalPeriod_Dc$Filter"})
		.addDcEditGridView("period", {name:"periodEditList", xtype:"md_FiscalPeriod_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["periodFilter", "periodEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbPeriodList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbPeriodList", {dc: "period"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
