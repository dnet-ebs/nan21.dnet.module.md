/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "ProductAccount_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "ProductAccount_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "ProductAccount_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_ProductAccount_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"company", dataIndex:"company", xtype:"md_OrgsLegalEntity_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "companyId"} ]})
		.addLov({name:"type", dataIndex:"type", xtype:"md_ProductAccountTypes_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "typeId"} ]})
		.addLov({name:"product", dataIndex:"product", xtype:"md_Products_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "productId"} ]})
		.addBooleanField({ name:"sale", dataIndex:"sale"})
		.addBooleanField({ name:"purchase", dataIndex:"purchase"})
		.addBooleanField({ name:"inventory", dataIndex:"inventory"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:220, layout:"form"})
		.addPanel({ name:"col3", width:170, layout:"form"})
		.addPanel({ name:"col4", width:180, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
		.addChildrenTo("col1", ["company", "product"])
		.addChildrenTo("col2", ["type"])
		.addChildrenTo("col3", ["purchase", "sale"])
		.addChildrenTo("col4", ["inventory", "active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "ProductAccount_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_ProductAccount_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"company", dataIndex:"company", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_OrgsLegalEntity_Lov", selectOnFocus:true, noUpdate:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "companyId"} ]}})
		.addLov({name:"product", dataIndex:"product", xtype:"gridcolumn", width:200, 
			editor:{xtype:"md_Products_Lov", selectOnFocus:true, allowBlank:false, noUpdate:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ],
				filterFieldMapping: [{lovParam:"companyIdForNewProdAccount", dsField: "companyId"}, {lovField:"active", value: "true"} ]}})
		.addTextColumn({name:"productName", dataIndex:"productName", width:200, noEdit: true})
		.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_ProductAccountTypes_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "typeId"} ,{lovField:"purchase", dsField: "purchase"} ,{lovField:"sale", dsField: "sale"} ,{lovField:"inventory", dsField: "inventory"} ],
				filterFieldMapping: [{lovField:"active", value: "true"} ]}})
		.addBooleanColumn({name:"purchase", dataIndex:"purchase", _noEdit_:true})
		.addBooleanColumn({name:"sale", dataIndex:"sale", _noEdit_:true})
		.addBooleanColumn({name:"inventory", dataIndex:"inventory", _noEdit_:true})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"companyId", dataIndex:"companyId", hidden:true, width:100})
		.addTextColumn({name:"productId", dataIndex:"productId", hidden:true, width:100})
		.addTextColumn({name:"typeId", dataIndex:"typeId", hidden:true, width:100})
		.addDefaults();
	}
});
