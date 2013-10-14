/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "BusinessPartner_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "BusinessPartner_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "BusinessPartner_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_BusinessPartner_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addLov({xtype:"md_BusinessPartners_Lov", name:"code", dataIndex:"code", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addTextField({ name:"firstName", dataIndex:"firstName"})
		.addTextField({ name:"lastName", dataIndex:"lastName"})
		.addTextField({ name:"companyName", dataIndex:"companyName"})
		.addTextField({ name:"registrationNo", dataIndex:"registrationNo", maxLength:32})
		.addTextField({ name:"taxPayerNo", dataIndex:"taxPayerNo"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addCombo({ xtype:"combo", name:"gender", dataIndex:"gender", store:[ "male", "female"]})
		.addCombo({ xtype:"combo", name:"type", dataIndex:"type", store:[ "person", "company"]})
		.addLov({xtype:"bd_Countries_Lov", name:"country", dataIndex:"country", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "countryId"} ]})
		.addLov({xtype:"md_LegalForms_Lov", name:"legalForm", dataIndex:"legalForm", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "legalFormId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:240, layout:"form"})
		.addPanel({ name:"col2", width:220, layout:"form"})
		.addPanel({ name:"col3", title:"Person", width:240, layout:"form", xtype:"fieldset", border:true, collapsible:false})
		.addPanel({ name:"col4", title:"Company", width:240, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"right", labelWidth:110}});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
		.addChildrenTo("col1", ["code", "name", "taxPayerNo"])
		.addChildrenTo("col2", ["country", "type", "active"])
		.addChildrenTo("col3", ["lastName", "firstName", "gender"])
		.addChildrenTo("col4", ["companyName", "registrationNo", "legalForm"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.md + "BusinessPartner_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.md_BusinessPartner_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code", width:120})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"type", dataIndex:"type", width:100})
		.addTextColumn({ name:"country", dataIndex:"country", width:120})
		.addTextColumn({ name:"taxPayerNo", dataIndex:"taxPayerNo", width:80})
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})
		.addTextColumn({ name:"companyName", dataIndex:"companyName", hidden:true, width:200})
		.addTextColumn({ name:"firstName", dataIndex:"firstName", hidden:true, width:200})
		.addTextColumn({ name:"lastName", dataIndex:"lastName", hidden:true, width:200})
		.addTextColumn({ name:"identityCardNo", dataIndex:"identityCardNo", width:80})
		.addTextColumn({ name:"gender", dataIndex:"gender", hidden:true, width:60})
		.addTextColumn({ name:"legalForm", dataIndex:"legalForm", width:80})
		.addTextColumn({ name:"registrationNo", dataIndex:"registrationNo", width:80})
		.addDateColumn({ name:"registrationDate", dataIndex:"registrationDate", width:80, _mask_: Masks.DATE})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Create ================= */

Ext.define(Dnet.ns.md + "BusinessPartner_Dc$Create" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_BusinessPartner_Dc$Create",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addCombo({ xtype:"combo", name:"type", dataIndex:"type", store:[ "person", "company"]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, width:250, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["type"]);
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.md + "BusinessPartner_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_BusinessPartner_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"code", dataIndex:"code", caseRestriction:"uppercase"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addTextField({ name:"type", dataIndex:"type", noEdit:true , maxLength:16})
		.addLov({xtype:"bd_Countries_Lov", name:"country", dataIndex:"country", allowBlank:false, caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "countryId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"} ]})
		.addTextField({ name:"taxPayerNo", dataIndex:"taxPayerNo"})
		.addTextField({ name:"firstName", dataIndex:"firstName"})
		.addTextField({ name:"lastName", dataIndex:"lastName"})
		.addTextField({ name:"middleName", dataIndex:"middleName"})
		.addTextField({ name:"identityCardNo", dataIndex:"identityCardNo"})
		.addTextField({ name:"passportNo", dataIndex:"passportNo"})
		.addDateField({name:"birthDate", dataIndex:"birthDate"})
		.addCombo({ xtype:"combo", name:"gender", dataIndex:"gender", store:[ "male", "female"]})
		.addTextField({ name:"companyName", dataIndex:"companyName"})
		.addTextField({ name:"registrationNo", dataIndex:"registrationNo", maxLength:32})
		.addDateField({name:"registrationDate", dataIndex:"registrationDate"})
		.addLov({xtype:"md_LegalForms_Lov", name:"legalForm", dataIndex:"legalForm", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "legalFormId"} ],
			filterFieldMapping: [{lovField:"countryId", dsField: "countryId"}, {lovField:"active", value: "true"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col0", layout:"card"})
		.addPanel({ name:"formCompany", width:600})
		.addPanel({ name:"formCompanyCol1", width:500, height: 40, layout:"form", defaults:{labelAlign:"right", labelWidth:110}})
		.addPanel({ name:"formCompanyCol2", width:250, layout:"form", defaults:{labelAlign:"right", labelWidth:110}})
		.addPanel({ name:"formPerson", width:600, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
		.addPanel({ name:"formPersonCol1", width:300, layout:"form"})
		.addPanel({ name:"formPersonCol2", width:250, layout:"form"})
		.addPanel({ name:"col1", width:250, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col0"])
		.addChildrenTo("col0", ["formCompany", "formPerson"])
		.addChildrenTo("formCompany", ["formCompanyCol1", "formCompanyCol2"])
		.addChildrenTo("formCompanyCol1", ["companyName"])
		.addChildrenTo("formCompanyCol2", ["legalForm", "registrationNo", "registrationDate"])
		.addChildrenTo("formPerson", ["formPersonCol1", "formPersonCol2"])
		.addChildrenTo("formPersonCol1", ["lastName", "firstName", "middleName"])
		.addChildrenTo("formPersonCol2", ["identityCardNo", "passportNo", "gender", "birthDate"])
		.addChildrenTo("col1", ["type", "country", "taxPayerNo", "code", "active"]);
	},
	/* ==================== Business functions ==================== */
	
	onRecordChange: function() {
		var rec = this._controller_.getRecord();
		if(rec) {
			if( rec.get("type") == "company") {
				this._showStackedViewElement_("col0", "formCompany");
			} else {
				this._showStackedViewElement_("col0", "formPerson");
			}			
		}
	},
	
	_registerListeners_: function() {
		this.callParent(arguments);
		this._controller_.on("recordChange", this.onRecordChange, this);
	}
});
