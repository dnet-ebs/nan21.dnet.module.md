/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Tax_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "Tax_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "Tax_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_Tax_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addLov({xtype:"md_TaxCategories_Lov", name:"category", dataIndex:"category",
			retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]})
		.addLov({xtype:"md_Taxes_Lov", name:"parentTax", dataIndex:"parentTax",
			retFieldMapping: [{lovField:"id", dsField: "parentTaxId"} ]})
		.addBooleanField({ name:"summary", dataIndex:"summary"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
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
		.addChildrenTo("col2", ["category", "parentTax"])
		.addChildrenTo("col3", ["summary", "active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "Tax_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_Tax_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addBooleanColumn({name:"summary", dataIndex:"summary"})
		.addNumberColumn({name:"rate", dataIndex:"rate", align:"right", decimals:6 })
		.addLov({name:"category", dataIndex:"category", xtype:"gridcolumn", width:200, 
			editor:{xtype:"md_TaxCategories_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]}})
		.addLov({name:"parentTax", dataIndex:"parentTax", xtype:"gridcolumn", width:200, 
			editor:{xtype:"md_Taxes_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "parentTaxId"} ],
				filterFieldMapping: [{lovField:"summary", value: "true"} ]}})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"categoryId", dataIndex:"categoryId", hidden:true, width:100})
		.addTextColumn({name:"parentTaxId", dataIndex:"parentTaxId", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.md + "Tax_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_Tax_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextArea({ name:"description", dataIndex:"description", height:60})
		.addNumberField({name:"rate", dataIndex:"rate", decimals:6})
		.addBooleanField({ name:"summary", dataIndex:"summary"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({xtype:"md_TaxCategories_Lov", name:"category", dataIndex:"category",
			retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]})
		.addLov({xtype:"md_Taxes_Lov", name:"parentTax", dataIndex:"parentTax",
			retFieldMapping: [{lovField:"id", dsField: "parentTaxId"} ],
			filterFieldMapping: [{lovField:"summary", value: "true"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:350, layout:"form"})
		.addPanel({ name:"col2", width:300, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "category", "description"])
		.addChildrenTo("col2", ["summary", "active", "rate", "parentTax"]);
	}
});
