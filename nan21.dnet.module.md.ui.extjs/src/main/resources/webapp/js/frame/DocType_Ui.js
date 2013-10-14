/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "DocType_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.DocType_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("docType", Ext.create(Dnet.ns.md + "DocType_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("docType", {name:"docTypeFilter", xtype:"md_DocType_Dc$Filter"})
		.addDcEditGridView("docType", {name:"docTypeEditList", xtype:"md_DocType_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["docTypeFilter", "docTypeEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbDocTypeEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbDocTypeEditList", {dc: "docType"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
