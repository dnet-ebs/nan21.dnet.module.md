/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "OrgType_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.OrgType_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("orgtype", Ext.create(Dnet.ns.md + "OrgType_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("orgtype", {name:"orgtypeFilter", xtype:"md_OrgType_Dc$Filter"})
		.addDcEditGridView("orgtype", {name:"orgtypeEditList", xtype:"md_OrgType_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["orgtypeFilter", "orgtypeEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbOrgtypeList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbOrgtypeList", {dc: "orgtype"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
