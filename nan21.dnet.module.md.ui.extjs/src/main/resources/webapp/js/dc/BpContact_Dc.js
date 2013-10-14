/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "BpContact_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "BpContact_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "BpContact_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_BpContact_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextField({ name:"firstName", dataIndex:"firstName"})
		.addTextField({ name:"lastName", dataIndex:"lastName"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({xtype:"md_BpContactPositions_Lov", name:"position", dataIndex:"position",
			retFieldMapping: [{lovField:"id", dsField: "positionId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:220, layout:"form"})
		.addPanel({ name:"col3", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["lastName", "firstName"])
		.addChildrenTo("col2", ["position"])
		.addChildrenTo("col3", ["active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "BpContact_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_BpContact_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"lastName", dataIndex:"lastName", width:200})
		.addTextColumn({name:"firstName", dataIndex:"firstName", width:200})
		.addLov({name:"position", dataIndex:"position", xtype:"gridcolumn", width:200, 
			editor:{xtype:"md_BpContactPositions_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "positionId"} ]}})
		.addTextColumn({name:"notes", dataIndex:"notes", width:200})
		.addDateColumn({name:"birthDate", dataIndex:"birthDate", _mask_: Masks.DATE })
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"businessPartnerId", dataIndex:"businessPartnerId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"positionId", dataIndex:"positionId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
