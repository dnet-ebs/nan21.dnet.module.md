/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "OrgType_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "OrgType_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "OrgType_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_OrgType_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"code", dataIndex:"code", xtype:"md_OrgTypes_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addTextField({ name:"name", dataIndex:"name"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addBooleanField({ name:"external", dataIndex:"external"})
		.addBooleanField({ name:"carrier", dataIndex:"carrier"})
		.addBooleanField({ name:"inventory", dataIndex:"inventory"})
		.addBooleanField({ name:"warehouse", dataIndex:"warehouse"})
		.addBooleanField({ name:"legalEntity", dataIndex:"legalEntity"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"})
		.addPanel({ name:"col3", width:170, layout:"form"})
		.addPanel({ name:"col4", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
		.addChildrenTo("col1", ["code", "name"])
		.addChildrenTo("col2", ["active", "external"])
		.addChildrenTo("col3", ["legalEntity", "inventory"])
		.addChildrenTo("col4", ["carrier"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "OrgType_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_OrgType_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addBooleanColumn({name:"legalEntity", dataIndex:"legalEntity", width:80})
		.addBooleanColumn({name:"external", dataIndex:"external", width:80})
		.addBooleanColumn({name:"inventory", dataIndex:"inventory", width:80})
		.addBooleanColumn({name:"warehouse", dataIndex:"warehouse", width:80})
		.addBooleanColumn({name:"carrier", dataIndex:"carrier", width:80})
		.addBooleanColumn({name:"accountingEnabled", dataIndex:"accountingEnabled", hidden:true, width:80})
		.addBooleanColumn({name:"active", dataIndex:"active", width:80})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addDefaults();
	}
});
