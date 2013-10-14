/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "BankBranch_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.BankBranch_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("branch", Ext.create(Dnet.ns.md + "BankBranch_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("branch", {name:"branchFilter", xtype:"md_BankBranch_Dc$Filter"})
		.addDcEditGridView("branch", {name:"branchEditList", xtype:"md_BankBranch_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["branchFilter", "branchEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbBranchEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbBranchEditList", {dc: "branch"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
