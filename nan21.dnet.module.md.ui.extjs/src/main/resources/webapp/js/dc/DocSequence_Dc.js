/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "DocSequence_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	filterModel: Dnet.ns.md + "DocSequence_DsFilter",
	recordModel: Dnet.ns.md + "DocSequence_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "DocSequence_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_DocSequence_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"docType", dataIndex:"docType", xtype:"md_DocTypes_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]})
		.addLov({name:"company", dataIndex:"company", allowBlank:false, xtype:"md_OrgsLegalEntity_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "companyId"} ]})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addTextField({ name:"prefix", dataIndex:"prefix", maxLength:4})
		.addTextField({ name:"suffix", dataIndex:"suffix", maxLength:4})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:180, layout:"form"})
		.addPanel({ name:"col3", width:180, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["company", "docType"])
		.addChildrenTo("col2", ["prefix", "suffix"])
		.addChildrenTo("col3", ["active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "DocSequence_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_DocSequence_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"company", dataIndex:"company", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_OrgsLegalEntity_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "companyId"} ]}})
		.addLov({name:"docType", dataIndex:"docType", xtype:"gridcolumn", width:150, 
			editor:{xtype:"md_DocTypes_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]}})
		.addTextColumn({name:"prefix", dataIndex:"prefix", width:60, maxLength:4})
		.addNumberColumn({name:"firstNo", dataIndex:"firstNo", align:"right" })
		.addNumberColumn({name:"lastNo", dataIndex:"lastNo", align:"right" })
		.addNumberColumn({name:"incrementBy", dataIndex:"incrementBy", align:"right", width:60 })
		.addTextColumn({name:"suffix", dataIndex:"suffix", width:60, maxLength:4})
		.addNumberColumn({name:"paddingLength", dataIndex:"paddingLength", align:"right" })
		.addTextColumn({name:"description", dataIndex:"description", hidden:true, width:200})
		.addDefaults();
	}
});
