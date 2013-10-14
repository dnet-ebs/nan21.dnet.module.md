/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "BpContactPosition_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.BpContactPosition_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("pos", Ext.create(Dnet.ns.md + "BpContactPosition_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("pos", {name:"posFilter", xtype:"md_BpContactPosition_Dc$Filter"})
		.addDcEditGridView("pos", {name:"posEditList", xtype:"md_BpContactPosition_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["posFilter", "posEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbPosEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbPosEditList", {dc: "pos"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
