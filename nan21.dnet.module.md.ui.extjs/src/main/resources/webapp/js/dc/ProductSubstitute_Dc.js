/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "ProductSubstitute_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "ProductSubstitute_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "ProductSubstitute_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_ProductSubstitute_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"product", dataIndex:"product", xtype:"md_Products_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "productId"} ]})
		.addLov({name:"substitute", dataIndex:"substitute", xtype:"md_Products_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "substituteId"} ]})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["product", "substitute"])
		.addChildrenTo("col2", ["active"]);
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Dnet.ns.md + "ProductSubstitute_Dc$CtxEditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_ProductSubstitute_Dc$CtxEditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"substitute", dataIndex:"substitute", xtype:"gridcolumn", width:200, 
			editor:{xtype:"md_Products_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "substituteId"} ,{lovField:"name", dsField: "substituteName"} ]}})
		.addTextColumn({name:"substituteName", dataIndex:"substituteName", width:200, noEdit: true})
		.addTextColumn({name:"notes", dataIndex:"notes", width:200})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "ProductSubstitute_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_ProductSubstitute_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"product", dataIndex:"product", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_Products_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "productId"} ]}})
		.addLov({name:"substitute", dataIndex:"substitute", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_Products_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "substituteId"} ,{lovField:"name", dsField: "substituteName"} ]}})
		.addDefaults();
	}
});
