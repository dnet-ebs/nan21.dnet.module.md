/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "InventoryLocation_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "InventoryLocation_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "InventoryLocation_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_InventoryLocation_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"code", dataIndex:"code", xtype:"md_InventoryLocations_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addLov({name:"locationType", dataIndex:"locationType", xtype:"md_InventoryLocationTypes_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "locationTypeId"} ]})
		.addLov({name:"inventory", dataIndex:"inventory", xtype:"md_Inventories_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]})
		.addTextField({ name:"name", dataIndex:"name"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["code", "name"])
		.addChildrenTo("col2", ["inventory", "locationType"])
		.addChildrenTo("col3", ["active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "InventoryLocation_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_InventoryLocation_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"inventory", dataIndex:"inventory", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_Inventories_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]}})
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addLov({name:"locationType", dataIndex:"locationType", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_InventoryLocationTypes_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "locationTypeId"} ]}})
		.addBooleanColumn({name:"active", dataIndex:"active", width:80})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addDefaults();
	}
});
