/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "CustomerAccount_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	filterModel: Dnet.ns.md + "CustomerAccount_DsFilter",
	recordModel: Dnet.ns.md + "CustomerAccount_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "CustomerAccount_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_CustomerAccount_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"company", dataIndex:"company", allowBlank:false, xtype:"md_OrgsLegalEntity_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "companyId"} ]})
		.addLov({name:"bpartner", dataIndex:"bpartner", xtype:"md_BusinessPartners_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ]})
		.addLov({name:"group", dataIndex:"group", xtype:"md_CustomerGroups_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "groupId"} ]})
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
		.addPanel({ name:"col3", width:210, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["company", "bpartner"])
		.addChildrenTo("col2", ["paymentMethod", "paymentTerm"])
		.addChildrenTo("col3", ["group", "active"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.md + "CustomerAccount_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.md_CustomerAccount_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"company", dataIndex:"company", width:120})
		.addTextColumn({ name:"companyId", dataIndex:"companyId", hidden:true, width:100})
		.addTextColumn({ name:"bpartner", dataIndex:"bpartner", width:120})
		.addTextColumn({ name:"bpartnerName", dataIndex:"bpartnerName", hidden:true, width:200})
		.addTextColumn({ name:"bpartnerId", dataIndex:"bpartnerId", hidden:true, width:100})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"group", dataIndex:"group", width:120})
		.addTextColumn({ name:"groupId", dataIndex:"groupId", hidden:true, width:100})
		.addNumberColumn({ name:"creditLimit", dataIndex:"creditLimit", decimals:2})
		.addTextColumn({ name:"paymentMethod", dataIndex:"paymentMethod", width:120})
		.addTextColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true, width:100})
		.addTextColumn({ name:"paymentTerm", dataIndex:"paymentTerm", width:200})
		.addTextColumn({ name:"paymentTermId", dataIndex:"paymentTermId", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Create ================= */

Ext.define(Dnet.ns.md + "CustomerAccount_Dc$Create" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_CustomerAccount_Dc$Create",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"company", dataIndex:"company", xtype:"md_OrgsLegalEntity_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "companyId"} ]})
		.addLov({name:"bpartner", dataIndex:"bpartner", xtype:"md_BusinessPartners_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ,{lovField:"name", dsField: "bpartnerName"} ],
			filterFieldMapping: [{lovParam:"companyIdForNewBpAccount", dsField: "companyId"} ]})
		.addTextField({ name:"bpartnerName", dataIndex:"bpartnerName", noEdit:true })
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, width:350, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["company", "bpartner", "bpartnerName"]);
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.md + "CustomerAccount_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_CustomerAccount_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"company", dataIndex:"company", noUpdate:true, caseRestriction:"uppercase"})
		.addTextField({ name:"bpartner", dataIndex:"bpartner", noEdit:true , caseRestriction:"uppercase"})
		.addTextField({ name:"bpartnerName", dataIndex:"bpartnerName", noEdit:true })
		.addBooleanField({ name:"active", dataIndex:"active", noEdit:true })
		.addLov({name:"group", dataIndex:"group", xtype:"md_CustomerGroups_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "groupId"} ]})
		.addLov({name:"paymentMethod", dataIndex:"paymentMethod", xtype:"md_DocTypes_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"category", value: "payment-in"} ]})
		.addLov({name:"paymentTerm", dataIndex:"paymentTerm", xtype:"md_PaymentTerms_Lov",
			retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]})
		.addNumberField({name:"creditLimit", dataIndex:"creditLimit", decimals:2})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"c1", width:400, layout:"form", defaults:{labelAlign:"right", labelWidth:150}})
		.addPanel({ name:"c2", width:350, layout:"form", defaults:{labelAlign:"right", labelWidth:150}});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["c1", "c2"])
		.addChildrenTo("c1", ["company", "bpartner", "bpartnerName", "active"])
		.addChildrenTo("c2", ["group", "creditLimit", "paymentMethod", "paymentTerm"]);
	}
});
