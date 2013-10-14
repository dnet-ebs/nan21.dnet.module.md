/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "BpAccountGroup_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.BpAccountGroup_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("custGroup", Ext.create(Dnet.ns.md + "CustomerGroup_Dc" ,{multiEdit:true}))	
		.addDc("vendGroup", Ext.create(Dnet.ns.md + "VendorGroup_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("custGroup", {name:"custGroupFilter", xtype:"md_CustomerGroup_Dc$Filter"})
		.addDcEditGridView("custGroup", {name:"custGroupEditList", xtype:"md_CustomerGroup_Dc$EditList", frame:true})
		.addDcFilterFormView("vendGroup", {name:"vendGroupFilter", xtype:"md_VendorGroup_Dc$Filter"})
		.addDcEditGridView("vendGroup", {name:"vendGroupEditList", xtype:"md_VendorGroup_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvasCustGroup", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvasVendGroup", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}}).addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
					listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
			})
		.addToc(["canvasCustGroup","canvasVendGroup"]);
		this._mainViewName_  = "_main_with_toc_";
		;
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvasCustGroup", "canvasVendGroup"])
		.addChildrenTo("canvasCustGroup", ["custGroupFilter", "custGroupEditList"], ["north", "center"])
		.addChildrenTo("canvasVendGroup", ["vendGroupFilter", "vendGroupEditList"], ["north", "center"])
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
		.addToolbarTo("canvasCustGroup", "tlbCustGroup")
		.addToolbarTo("canvasVendGroup", "tlbVendGroup");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbCustGroup", {dc: "custGroup"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbVendGroup", {dc: "vendGroup"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
