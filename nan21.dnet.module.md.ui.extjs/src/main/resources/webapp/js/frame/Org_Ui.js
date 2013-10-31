/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Org_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Org_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("org", Ext.create(Dnet.ns.md + "Org_Dc" ,{multiEdit:true}))	
		.addDc("address", Ext.create(Dnet.ns.bd + "Location_Dc" ,{}))	
		.addDc("communic", Ext.create(Dnet.ns.bd + "CommunicationMethod_Dc" ,{multiEdit:true}))
		.linkDc("address", "org",{fields:[
			{childField:"targetRefid", parentField:"refid"}]}
		).linkDc("communic", "org",{fields:[
			{childField:"targetRefid", parentField:"refid"}, {childField:"targetAlias", parentField:"entityAlias"}, {childField:"targetType", parentField:"type"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("org", {name:"orgFilter", xtype:"md_Org_Dc$Filter"})
		.addDcEditGridView("org", {name:"orgList", xtype:"md_Org_Dc$EditList", frame:true})
		.addDcGridView("address", {name:"addressList", xtype:"bd_Location_Dc$List"})
		.addDcFormView("address", {name:"addressEdit", xtype:"bd_Location_Dc$Edit"})
		.addDcEditGridView("communic", {name:"communicEditList", _hasTitle_:true, xtype:"bd_CommunicationMethod_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}})
		.addPanel({name:"detailsTab", height:250, xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
		.addPanel({name:"addressPanel", _hasTitle_:true, layout:"card", activeItem:0})
		.addPanel({name:"addressEditWrapper", layout:"fit"});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["orgFilter", "orgList", "detailsTab"], ["north", "center", "south"])
		.addChildrenTo("detailsTab", ["addressPanel", "communicEditList"])
		.addChildrenTo("addressPanel", ["addressList", "addressEditWrapper"])
		.addChildrenTo("addressEditWrapper", ["addressEdit"])
		.addToolbarTo("main", "tlbOrgList")
		.addToolbarTo("addressList", "tlbAddressList")
		.addToolbarTo("addressEditWrapper", "tlbAddressEdit")
		.addToolbarTo("communicEditList", "tlbCommunicEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbOrgList", {dc: "org"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbAddressList", {dc: "address"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addEdit({inContainer:"addressPanel",showView:"addressEditWrapper"}
			).addNew().addCopy().addDeleteSelected()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbAddressEdit", {dc: "address"})
			.addTitle().addSeparator().addSeparator()
			.addBack({inContainer:"addressPanel",showView:"addressList"}
			).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbCommunicEditList", {dc: "communic"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

});
