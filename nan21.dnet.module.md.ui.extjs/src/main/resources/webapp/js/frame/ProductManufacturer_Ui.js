/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "ProductManufacturer_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.ProductManufacturer_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("manufact", Ext.create(Dnet.ns.md + "ProductManufacturer_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("manufact", {name:"manufactFilter", xtype:"md_ProductManufacturer_Dc$Filter"})
		.addDcEditGridView("manufact", {name:"manufactEditList", xtype:"md_ProductManufacturer_Dc$EditList", frame:true})
		.addDcFormView("manufact", {name:"manufactView", width:200, xtype:"md_ProductManufacturer_Dc$ViewIcon"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["manufactFilter", "manufactEditList", "manufactView"], ["north", "center", "east"])
		.addToolbarTo("main", "tlbManufactEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbManufactEditList", {dc: "manufact"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
