/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "TaxCategory_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.TaxCategory_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("taxcateg", Ext.create(Dnet.ns.md + "TaxCategory_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("taxcateg", {name:"taxcategFilter", xtype:"md_TaxCategory_Dc$Filter"})
		.addDcEditGridView("taxcateg", {name:"taxcategEditList", xtype:"md_TaxCategory_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["taxcategFilter", "taxcategEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbTaxcategEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbTaxcategEditList", {dc: "taxcateg"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
