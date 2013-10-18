/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "FiscalPeriod_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "FiscalPeriod_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "FiscalPeriod_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_FiscalPeriod_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"name", dataIndex:"name", xtype:"md_FiscalPeriods_Lov",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addCombo({ xtype:"combo", name:"type", dataIndex:"type", store:[ "month", "quarter", "half-year", "other"]})
		.addLov({name:"fiscalYear", dataIndex:"fiscalYear", xtype:"md_FiscalYears_Lov",
			retFieldMapping: [{lovField:"id", dsField: "fiscalYearId"} ]})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addBooleanField({ name:"posting", dataIndex:"posting"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:210, layout:"form"})
		.addPanel({ name:"col3", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["name", "fiscalYear"])
		.addChildrenTo("col2", ["type"])
		.addChildrenTo("col3", ["posting", "active"]);
	}
});

/* ================= FILTER: FilterCtx ================= */


Ext.define(Dnet.ns.md + "FiscalPeriod_Dc$FilterCtx" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterPropGrid",
	alias: "widget.md_FiscalPeriod_Dc$FilterCtx",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", dataIndex:"name"})
			.addCombo({ xtype:"combo", name:"type", dataIndex:"type", store:[ "month", "quarter", "half-year", "other"]})
			.addBooleanField({ name:"posting", dataIndex:"posting"})
			.addBooleanField({ name:"active", dataIndex:"active"})
		;
	}

});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.md + "FiscalPeriod_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.md_FiscalPeriod_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"fiscalYear", dataIndex:"fiscalYear", width:200})
		.addDateColumn({ name:"startDate", dataIndex:"startDate", _mask_: Masks.DATE})
		.addDateColumn({ name:"endDate", dataIndex:"endDate", _mask_: Masks.DATE})
		.addTextColumn({ name:"type", dataIndex:"type", width:80})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addBooleanColumn({ name:"posting", dataIndex:"posting"})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "FiscalPeriod_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_FiscalPeriod_Dc$EditList",
	_bulkEditFields_: ["type","active","posting"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"fiscalYear", dataIndex:"fiscalYear", xtype:"gridcolumn", width:200, 
			editor:{xtype:"md_FiscalYears_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "fiscalYearId"} ]}})
		.addDateColumn({name:"startDate", dataIndex:"startDate", _mask_: Masks.DATE })
		.addDateColumn({name:"endDate", dataIndex:"endDate", _mask_: Masks.DATE })
		.addComboColumn({name:"type", dataIndex:"type", width:80, 
			editor:{xtype:"combo", mode: 'local', selectOnFocus:true, allowBlank:false, triggerAction:'all', forceSelection:true, store:[ "month", "quarter", "half-year", "other"]}})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addBooleanColumn({name:"posting", dataIndex:"posting"})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"notes", dataIndex:"notes", width:200})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Dnet.ns.md + "FiscalPeriod_Dc$CtxEditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_FiscalPeriod_Dc$CtxEditList",
	_bulkEditFields_: ["type","active","posting"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addDateColumn({name:"startDate", dataIndex:"startDate", _mask_: Masks.DATE })
		.addDateColumn({name:"endDate", dataIndex:"endDate", _mask_: Masks.DATE })
		.addComboColumn({name:"type", dataIndex:"type", width:80, 
			editor:{xtype:"combo", mode: 'local', selectOnFocus:true, allowBlank:false, triggerAction:'all', forceSelection:true, store:[ "month", "quarter", "half-year", "other"]}})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"fiscalYear", dataIndex:"fiscalYear", hidden:true, width:200, noEdit: true})
		.addBooleanColumn({name:"posting", dataIndex:"posting"})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.md + "FiscalPeriod_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_FiscalPeriod_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name", noEdit:true })
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addBooleanField({ name:"posting", dataIndex:"posting"})
		.addTextField({ name:"notes", dataIndex:"notes"})
		.addDateField({name:"startDate", dataIndex:"startDate", allowBlank:false})
		.addDateField({name:"endDate", dataIndex:"endDate", allowBlank:false})
		.addCombo({ xtype:"combo", name:"type", dataIndex:"type", store:[ "month", "quarter", "half-year", "other"]})
		.addLov({name:"fiscalYear", dataIndex:"fiscalYear", xtype:"md_FiscalYears_Lov",
			retFieldMapping: [{lovField:"id", dsField: "fiscalYearId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:300, layout:"form"})
		.addPanel({ name:"col3", width:160, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["fiscalYear", "startDate", "endDate", "type"])
		.addChildrenTo("col2", ["name", "notes"])
		.addChildrenTo("col3", ["posting", "active"]);
	}
});
