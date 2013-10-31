/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "ProductCategorySubstitute_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.ProductCategorySubstitute_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("subst", Ext.create(Dnet.ns.md + "ProductCategorySubstitute_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("subst", {name:"substFilter", xtype:"md_ProductCategorySubstitute_Dc$Filter"})
		.addDcEditGridView("subst", {name:"substEditList", xtype:"md_ProductCategorySubstitute_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["substFilter", "substEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbSubstEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbSubstEditList", {dc: "subst"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
