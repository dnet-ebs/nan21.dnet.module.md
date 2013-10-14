/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "BpAccount_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	filterModel: Dnet.ns.md + "BpAccount_DsFilter",
	recordModel: Dnet.ns.md + "BpAccount_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "BpAccount_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_BpAccount_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({xtype:"md_OrgsLegalEntity_Lov", name:"company", dataIndex:"company", allowBlank:false, caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "companyId"} ]})
		.addLov({xtype:"md_BusinessPartners_Lov", name:"bpartner", dataIndex:"bpartner", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "bpartnerId"} ]})
		.addLov({xtype:"md_CustomerGroups_Lov", name:"customerGroup", dataIndex:"customerGroup", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "customerGroupId"} ]})
		.addLov({xtype:"md_VendorGroups_Lov", name:"vendorGroup", dataIndex:"vendorGroup", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "vendorGroupId"} ]})
		.addLov({xtype:"md_DocTypes_Lov", name:"customerPaymentMethod", dataIndex:"customerPaymentMethod", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "customerPaymentMethodId"} ],
			filterFieldMapping: [{lovField:"category", value: "payment-in"} ]})
		.addLov({xtype:"md_DocTypes_Lov", name:"vendorPaymentMethod", dataIndex:"vendorPaymentMethod", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "vendorPaymentMethodId"} ],
			filterFieldMapping: [{lovField:"category", value: "payment-out"} ]})
		.addBooleanField({ name:"customer", dataIndex:"customer"})
		.addBooleanField({ name:"vendor", dataIndex:"vendor"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"})
		.addPanel({ name:"col3", width:220, layout:"form"})
		.addPanel({ name:"col4", width:250, layout:"form"})
		.addPanel({ name:"col5", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3", "col4", "col5"])
		.addChildrenTo("col1", ["company", "bpartner"])
		.addChildrenTo("col2", ["customer", "vendor"])
		.addChildrenTo("col3", ["customerGroup", "vendorGroup"])
		.addChildrenTo("col4", ["customerPaymentMethod", "vendorPaymentMethod"])
		.addChildrenTo("col5", ["active"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.md + "BpAccount_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.md_BpAccount_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"company", dataIndex:"company", width:120})
		.addTextColumn({ name:"companyId", dataIndex:"companyId", hidden:true, width:100})
		.addTextColumn({ name:"bpartner", dataIndex:"bpartner", width:120})
		.addTextColumn({ name:"bpartnerName", dataIndex:"bpartnerName", hidden:true, width:200})
		.addTextColumn({ name:"businessPartnerId", dataIndex:"bpartnerId", hidden:true, width:100})
		.addBooleanColumn({ name:"customer", dataIndex:"customer"})
		.addBooleanColumn({ name:"vendor", dataIndex:"vendor"})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"customerGroup", dataIndex:"customerGroup", width:120})
		.addTextColumn({ name:"customerGroupId", dataIndex:"customerGroupId", hidden:true, width:100})
		.addNumberColumn({ name:"customerCreditLimit", dataIndex:"customerCreditLimit", hidden:true, decimals:2})
		.addTextColumn({ name:"customerPaymentMethod", dataIndex:"customerPaymentMethod", hidden:true, width:120})
		.addTextColumn({ name:"customerPaymentTerm", dataIndex:"customerPaymentTerm", hidden:true, width:200})
		.addTextColumn({ name:"vendorGroup", dataIndex:"vendorGroup", width:120})
		.addTextColumn({ name:"vendorGroupId", dataIndex:"vendorGroupId", hidden:true, width:100})
		.addNumberColumn({ name:"vendorCreditLimit", dataIndex:"vendorCreditLimit", hidden:true, decimals:2})
		.addTextColumn({ name:"vendorPaymentMethod", dataIndex:"vendorPaymentMethod", hidden:true, width:120})
		.addTextColumn({ name:"vendorPaymentTerm", dataIndex:"vendorPaymentTerm", hidden:true, width:200})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Create ================= */

Ext.define(Dnet.ns.md + "BpAccount_Dc$Create" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_BpAccount_Dc$Create",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({xtype:"md_OrgsLegalEntity_Lov", name:"company", dataIndex:"company", allowBlank:false, caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "companyId"} ]})
		.addLov({xtype:"md_BusinessPartners_Lov", name:"bpartner", dataIndex:"bpartner", allowBlank:false, caseRestriction:"uppercase",
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

Ext.define(Dnet.ns.md + "BpAccount_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_BpAccount_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"company", dataIndex:"company", noEdit:true , caseRestriction:"uppercase"})
		.addTextField({ name:"bpartner", dataIndex:"bpartner", noEdit:true , caseRestriction:"uppercase"})
		.addTextField({ name:"bpartnerName", dataIndex:"bpartnerName", noEdit:true })
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addBooleanField({ name:"customer", dataIndex:"customer",listeners:{
			change:{scope:this, fn:this.onCustChange}
		}})
		.addLov({xtype:"md_CustomerGroups_Lov", name:"customerGroup", dataIndex:"customerGroup", _enableFn_:this._cust_fld_enabled_, caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "customerGroupId"} ]})
		.addLov({xtype:"md_DocTypes_Lov", name:"customerPaymentMethod", dataIndex:"customerPaymentMethod", _enableFn_:this._cust_fld_enabled_, caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "customerPaymentMethodId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"category", value: "payment-in"} ]})
		.addLov({xtype:"md_PaymentTerms_Lov", name:"customerPaymentTerm", dataIndex:"customerPaymentTerm", _enableFn_:this._cust_fld_enabled_,
			retFieldMapping: [{lovField:"id", dsField: "customerPaymentTermId"} ]})
		.addNumberField({name:"customerCreditLimit", dataIndex:"customerCreditLimit", _enableFn_:this._cust_fld_enabled_, decimals:2})
		.addBooleanField({ name:"vendor", dataIndex:"vendor",listeners:{
			change:{scope:this, fn:this.onVendChange}
		}})
		.addLov({xtype:"md_VendorGroups_Lov", name:"vendorGroup", dataIndex:"vendorGroup", _enableFn_:this._vend_fld_enabled_, caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "vendorGroupId"} ]})
		.addLov({xtype:"md_DocTypes_Lov", name:"vendorPaymentMethod", dataIndex:"vendorPaymentMethod", _enableFn_:this._vend_fld_enabled_, caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "vendorPaymentMethodId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"category", value: "payment-out"} ]})
		.addLov({xtype:"md_PaymentTerms_Lov", name:"vendorPaymentTerm", dataIndex:"vendorPaymentTerm", _enableFn_:this._vend_fld_enabled_,
			retFieldMapping: [{lovField:"id", dsField: "vendorPaymentTermId"} ]})
		.addNumberField({name:"vendorCreditLimit", dataIndex:"vendorCreditLimit", _enableFn_:this._vend_fld_enabled_, decimals:2})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true})
		.addPanel({ name:"c1", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"right", labelWidth:150}})
		.addPanel({ name:"c2", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"right", labelWidth:150}})
		.addPanel({ name:"c3", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"right", labelWidth:150}});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["c1", "c2", "c3"])
		.addChildrenTo("c1", ["company", "bpartner", "bpartnerName", "active"])
		.addChildrenTo("c2", ["customer", "customerGroup", "customerCreditLimit", "customerPaymentMethod", "customerPaymentTerm"])
		.addChildrenTo("c3", ["vendor", "vendorGroup", "vendorCreditLimit", "vendorPaymentMethod", "vendorPaymentTerm"]);
	},
	/* ==================== Business functions ==================== */
	
	_cust_fld_enabled_: function(dc,rec) {
		return rec.get("customer") === true;
	},
	
	_vend_fld_enabled_: function(dc,rec) {
		return rec.get("vendor") === true;
	},
	
	onCustChange: function() {
		var rec = this._getController_().getRecord();		 
		this._setFieldsEnabledState_(["customerGroup","customerPaymentMethod","customerPaymentTerm","customerCreditLimit"], rec);
	},
	
	onVendChange: function() {
		var rec = this._getController_().getRecord();		 
		this._setFieldsEnabledState_(["vendorGroup","vendorPaymentMethod","vendorPaymentTerm","vendorCreditLimit"], rec);
	}
});
