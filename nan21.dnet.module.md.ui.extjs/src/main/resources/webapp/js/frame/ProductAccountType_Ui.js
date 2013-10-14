/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "ProductAccountType_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.ProductAccountType_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("type", Ext.create(Dnet.ns.md + "ProductAccountType_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("type", {name:"typeFilter", xtype:"md_ProductAccountType_Dc$Filter"})
		.addDcEditGridView("type", {name:"typeEditList", xtype:"md_ProductAccountType_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["typeFilter", "typeEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbAccount");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbAccount", {dc: "type"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
