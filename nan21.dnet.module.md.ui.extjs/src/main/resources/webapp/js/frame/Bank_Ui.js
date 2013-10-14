/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Bank_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Bank_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("bank", Ext.create(Dnet.ns.md + "Bank_Dc" ,{multiEdit:true}))	
		.addDc("branch", Ext.create(Dnet.ns.md + "BankBranch_Dc" ,{multiEdit:true}))
		.linkDc("branch", "bank",{fields:[
			{childField:"bankId", parentField:"id"}, {childField:"bank", parentField:"code", noFilter:true}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("bank", {name:"bankFilter", xtype:"md_Bank_Dc$Filter"})
		.addDcEditGridView("bank", {name:"bankEditList", xtype:"md_Bank_Dc$EditList", frame:true})
		.addDcEditGridView("branch", {name:"branchEditList", width:600, xtype:"md_BankBranch_Dc$CtxEditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["bankFilter", "bankEditList", "branchEditList"], ["north", "center", "east"])
		.addToolbarTo("main", "tlbBankEditList")
		.addToolbarTo("branchEditList", "tlbBranchEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbBankEditList", {dc: "bank"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbBranchEditList", {dc: "branch"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

});
