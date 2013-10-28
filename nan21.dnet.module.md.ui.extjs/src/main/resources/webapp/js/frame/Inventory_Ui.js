/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Inventory_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Inventory_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("ivt", Ext.create(Dnet.ns.md + "Inventory_Dc" ,{multiEdit:true}))	
		.addDc("loc", Ext.create(Dnet.ns.md + "InventoryLocation_Dc" ,{multiEdit:true}))	
		.addDc("loctype", Ext.create(Dnet.ns.md + "InventoryLocationType_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("ivt", {name:"ivtFilter", xtype:"md_Inventory_Dc$Filter"})
		.addDcEditGridView("ivt", {name:"ivtEditList", xtype:"md_Inventory_Dc$EditList", frame:true})
		.addDcFilterFormView("loc", {name:"locFilter", xtype:"md_InventoryLocation_Dc$Filter"})
		.addDcEditGridView("loc", {name:"locEditList", xtype:"md_InventoryLocation_Dc$EditList", frame:true})
		.addDcFilterFormView("loctype", {name:"loctypeFilter", xtype:"md_InventoryLocationType_Dc$Filter"})
		.addDcEditGridView("loctype", {name:"loctypeEditList", xtype:"md_InventoryLocationType_Dc$EditList", frame:true})
		.addPanel({name:"canvasIvt", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvasLoc", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvasLoctype", _hasTitle_:true, preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"main", layout:"card", activeItem:0}).addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
					listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
			})
		.addToc(["canvasIvt","canvasLoc","canvasLoctype"]);
		this._mainViewName_  = "_main_with_toc_";
		;
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("canvasIvt", ["ivtFilter", "ivtEditList"], ["north", "center"])
		.addChildrenTo("canvasLoc", ["locFilter", "locEditList"], ["north", "center"])
		.addChildrenTo("canvasLoctype", ["loctypeFilter", "loctypeEditList"], ["north", "center"])
		.addChildrenTo("main", ["canvasIvt", "canvasLoc", "canvasLoctype"])
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
		.addToolbarTo("canvasIvt", "tlbIvtList")
		.addToolbarTo("canvasLoc", "tlbLocList")
		.addToolbarTo("canvasLoctype", "tlbLoctypeList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbIvtList", {dc: "ivt"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbLocList", {dc: "loc"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbLoctypeList", {dc: "loctype"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
