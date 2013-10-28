/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Product_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Product_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("prod", Ext.create(Dnet.ns.md + "Product_Dc" ,{}))	
		.addDc("subst", Ext.create(Dnet.ns.md + "ProductSubstitute_Dc" ,{multiEdit:true}))	
		.addDc("attr", Ext.create(Dnet.ns.bd + "AttributeValue_Dc" ,{multiEdit:true}))	
		.addDc("atch", Ext.create(Dnet.ns.bd + "Attachment_Dc" ,{}))	
		.addDc("classific", Ext.create(Dnet.ns.bd + "Classification_Dc" ,{multiEdit:true}))
		.linkDc("subst", "prod",{fields:[
			{childField:"productId", parentField:"id"}, {childField:"product", parentField:"code", noFilter:true}]}
		).linkDc("attr", "prod",{fields:[
			{childField:"targetRefid", parentField:"id"}, {childField:"attributeSetId", parentField:"attributeSetId"}, {childField:"attributeSet", parentField:"attributeSet", noFilter:true}]}
		).linkDc("atch", "prod",{fields:[
			{childField:"targetRefid", parentField:"refid"}, {childField:"targetAlias", parentField:"entityAlias"}, {childField:"targetType", value:"N/A"}]}
		).linkDc("classific", "prod",{fields:[
			{childField:"targetRefid", parentField:"refid"}, {childField:"targetAlias", parentField:"entityAlias"}, {childField:"targetType", value:"N/A"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnSyncAttr", disabled:false, handler: this.onBtnSyncAttr, scope:this})
		.addDcFilterFormView("prod", {name:"prodFilter", xtype:"md_Product_Dc$Filter"})
		.addDcGridView("prod", {name:"prodList", xtype:"md_Product_Dc$List"})
		.addDcFormView("prod", {name:"prodEdit", xtype:"md_Product_Dc$Edit"})
		.addDcFormView("prod", {name:"prodEditInfo", _hasTitle_:true, xtype:"md_Product_Dc$EditInfo", _acquireFocusInsert_: false, _acquireFocusUpdate_: false})
		.addDcEditGridView("subst", {name:"substEditList", _hasTitle_:true, xtype:"md_ProductSubstitute_Dc$CtxEditList", frame:true})
		.addDcEditGridView("classific", {name:"classificEdit", _hasTitle_:true, xtype:"bd_Classification_Dc$EditList", frame:true})
		.addDcGridView("atch", {name:"atchList", _hasTitle_:true, xtype:"bd_Attachment_Dc$List"})
		.addDcFormView("atch", {name:"atchCreate", xtype:"bd_Attachment_Dc$Create"})
		.addDcFilterFormView("attr", {name:"attrFilter", _hasTitle_:true, width:250, xtype:"bd_AttributeValue_Dc$CtxFilter", collapsible:true, collapsed:true
		})
		.addDcEditGridView("attr", {name:"attrEditList", xtype:"bd_AttributeValue_Dc$CtxEditList", frame:true})
		.addPanel({name:"attrPanel", _hasTitle_:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}, onActivateDoLayoutFor:["prodDetailsTab"]})
		.addPanel({name:"prodDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("attrPanel", ["attrFilter", "attrEditList"], ["west", "center"])
		.addChildrenTo("main", ["canvas1", "canvas2"])
		.addChildrenTo("canvas1", ["prodFilter", "prodList"], ["north", "center"])
		.addChildrenTo("canvas2", ["prodEdit", "prodDetailsTab"], ["north", "center"])
		.addChildrenTo("prodDetailsTab", ["prodEditInfo", "attrPanel", "classificEdit", "substEditList", "atchList"])
		.addToolbarTo("canvas1", "tlbProdList")
		.addToolbarTo("canvas2", "tlbProdEdit")
		.addToolbarTo("substEditList", "tlbSusbst")
		.addToolbarTo("attrPanel", "tlbAttrEditList")
		.addToolbarTo("atchList", "tlbAtchList")
		.addToolbarTo("classificEdit", "tlbClassific");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbProdList", {dc: "prod"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports()
		.end()
		.beginToolbar("tlbProdEdit", {dc: "prod"})
			.addTitle().addSeparator().addSeparator()
			.addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports()
		.end()
		.beginToolbar("tlbSusbst", {dc: "subst"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbAttrEditList", {dc: "attr"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addCancel()
			.addSeparator().addAutoLoad()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnSyncAttr") ])
			.addReports()
		.end()
		.beginToolbar("tlbAtchList", {dc: "atch"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addNew().addDeleteSelected()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbClassific", {dc: "classific"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnSyncAttr
	 */
	,onBtnSyncAttr: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getDc_("attr").doQuery();
		};
		var o={
			name:"synchronizeAttributes",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("attr").doRpcFilter(o);
	}
});
