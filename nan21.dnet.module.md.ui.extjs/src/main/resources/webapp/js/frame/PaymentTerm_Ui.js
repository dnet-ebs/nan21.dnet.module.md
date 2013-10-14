/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "PaymentTerm_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.PaymentTerm_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("payTerm", Ext.create(Dnet.ns.md + "PaymentTerm_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("payTerm", {name:"payTermFilter", height:90, xtype:"md_PaymentTerm_Dc$Filter"})
		.addDcEditGridView("payTerm", {name:"payTermEditList", xtype:"md_PaymentTerm_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["payTermFilter", "payTermEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbpayTerm");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbpayTerm", {dc: "payTerm"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
