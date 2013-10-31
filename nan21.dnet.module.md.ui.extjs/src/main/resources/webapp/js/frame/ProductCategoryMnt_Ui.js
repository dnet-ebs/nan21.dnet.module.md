/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "ProductCategoryMnt_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.ProductCategoryMnt_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("categ", Ext.create(Dnet.ns.md + "ProductCategory_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("categ", {name:"categFilter", xtype:"md_ProductCategory_Dc$Filter"})
		.addDcEditGridView("categ", {name:"categEditList", xtype:"md_ProductCategory_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["categFilter", "categEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbCategEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbCategEditList", {dc: "categ"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
