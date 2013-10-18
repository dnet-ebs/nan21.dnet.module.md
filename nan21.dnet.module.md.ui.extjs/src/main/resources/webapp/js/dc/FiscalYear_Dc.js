/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "FiscalYear_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "FiscalYear_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "FiscalYear_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_FiscalYear_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({name:"calendar", dataIndex:"calendar", xtype:"md_Calendars_Lov",
			retFieldMapping: [{lovField:"id", dsField: "calendarId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:210, layout:"form"})
		.addPanel({ name:"col3", width:210, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["name"])
		.addChildrenTo("col2", ["calendar"])
		.addChildrenTo("col3", ["active"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.md + "FiscalYear_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.md_FiscalYear_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"calendar", dataIndex:"calendar", width:200})
		.addDateColumn({ name:"startDate", dataIndex:"startDate", _mask_: Masks.DATE})
		.addDateColumn({ name:"endDate", dataIndex:"endDate", _mask_: Masks.DATE})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "FiscalYear_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_FiscalYear_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"calendar", dataIndex:"calendar", xtype:"gridcolumn", width:200, 
			editor:{xtype:"md_Calendars_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "calendarId"} ]}})
		.addDateColumn({name:"startDate", dataIndex:"startDate", _mask_: Masks.DATE })
		.addDateColumn({name:"endDate", dataIndex:"endDate", _mask_: Masks.DATE })
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"notes", dataIndex:"notes", width:200})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.md + "FiscalYear_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_FiscalYear_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name", noEdit:true })
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addTextField({ name:"notes", dataIndex:"notes"})
		.addLov({name:"calendar", dataIndex:"calendar", xtype:"md_Calendars_Lov",
			retFieldMapping: [{lovField:"id", dsField: "calendarId"} ]})
		.addDateField({name:"startDate", dataIndex:"startDate", allowBlank:false})
		.addDateField({name:"endDate", dataIndex:"endDate", allowBlank:false})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:300, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["calendar", "startDate", "endDate", "active"])
		.addChildrenTo("col2", ["name", "notes"]);
	}
});
