/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "LegalForm_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.LegalForm_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("legalForm", Ext.create(Dnet.ns.md + "LegalForm_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("legalForm", {name:"legalFormFilter", xtype:"md_LegalForm_Dc$Filter"})
		.addDcEditGridView("legalForm", {name:"legalFormEditList", xtype:"md_LegalForm_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["legalFormFilter", "legalFormEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbLegalFormEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbLegalFormEditList", {dc: "legalForm"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
