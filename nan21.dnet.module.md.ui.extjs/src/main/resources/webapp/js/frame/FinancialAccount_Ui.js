/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "FinancialAccount_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.FinancialAccount_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("account", Ext.create(Dnet.ns.md + "FinancialAccount_Dc" ,{multiEdit:true}))	
		.addDc("usage", Ext.create(Dnet.ns.md + "FinancialAccountUsage_Dc" ,{multiEdit:true}))
		.linkDc("usage", "account",{fields:[
			{childField:"financialAccountId", parentField:"id"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("account", {name:"accountFilter", xtype:"md_FinancialAccount_Dc$Filter"})
		.addDcEditGridView("account", {name:"accountEditList", xtype:"md_FinancialAccount_Dc$EditList", frame:true})
		.addDcEditGridView("usage", {name:"usageList", height:250, xtype:"md_FinancialAccountUsage_Dc$CtxEditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["accountFilter", "accountEditList", "usageList"], ["north", "center", "south"])
		.addToolbarTo("main", "tlbSeqEditList")
		.addToolbarTo("usageList", "tlbValList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbSeqEditList", {dc: "account"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbValList", {dc: "usage"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

});
