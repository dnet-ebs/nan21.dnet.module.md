/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "CustomerGroup_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "CustomerGroup_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "CustomerGroup_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_CustomerGroup_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addLov({name:"code", dataIndex:"code", xtype:"md_CustomerGroups_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addLov({name:"paymentMethod", dataIndex:"paymentMethod", xtype:"md_DocTypes_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ],
			filterFieldMapping: [{lovField:"category", value: "payment-in"} ]})
		.addLov({name:"paymentTerm", dataIndex:"paymentTerm", xtype:"md_PaymentTerms_Lov",
			retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]})
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
		.addChildrenTo("col2", ["paymentMethod", "paymentTerm"])
		.addChildrenTo("col3", ["active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "CustomerGroup_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_CustomerGroup_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addLov({name:"paymentMethod", dataIndex:"paymentMethod", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_DocTypes_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ],
				filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"category", value: "payment-in"} ]}})
		.addLov({name:"paymentTerm", dataIndex:"paymentTerm", xtype:"gridcolumn", width:200, 
			editor:{xtype:"md_PaymentTerms_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ],
				filterFieldMapping: [{lovField:"active", value: "true"} ]}})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addDefaults();
	}
});
