/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "ProductCategory_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.ProductCategory_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("categ", Ext.create(Dnet.ns.md + "ProductCategory_Dc" ,{}))	
		.addDc("subst", Ext.create(Dnet.ns.md + "ProductCategorySubstitute_Dc" ,{multiEdit:true}))	
		.addDc("attr", Ext.create(Dnet.ns.bd + "AttributeValue_Dc" ,{multiEdit:true}))	
		.addDc("classific", Ext.create(Dnet.ns.bd + "Classification_Dc" ,{multiEdit:true}))
		.linkDc("subst", "categ",{fields:[
			{childField:"categoryId", parentField:"id"}, {childField:"category", parentField:"code", noFilter:true}]}
		).linkDc("attr", "categ",{fields:[
			{childField:"targetRefid", parentField:"id"}, {childField:"attributeSetId", parentField:"attributeSetId"}, {childField:"attributeSet", parentField:"attributeSet", noFilter:true}]}
		).linkDc("classific", "categ",{fields:[
			{childField:"targetRefid", parentField:"refid"}, {childField:"targetAlias", parentField:"entityAlias"}, {childField:"targetType", value:"N/A"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnSyncAttr", disabled:false, handler: this.onBtnSyncAttr, scope:this})
		.addDcFilterFormView("categ", {name:"categFilter", xtype:"md_ProductCategory_Dc$Filter"})
		.addDcGridView("categ", {name:"categList", xtype:"md_ProductCategory_Dc$List"})
		.addDcFormView("categ", {name:"categEdit", xtype:"md_ProductCategory_Dc$Edit"})
		.addDcFormView("categ", {name:"categView", _hasTitle_:true, xtype:"md_ProductCategory_Dc$ViewIcon"})
		.addDcEditGridView("subst", {name:"substEditList", _hasTitle_:true, xtype:"md_ProductCategorySubstitute_Dc$CtxEditList", frame:true})
		.addDcEditGridView("classific", {name:"classificList", _hasTitle_:true, xtype:"bd_Classification_Dc$EditList", frame:true})
		.addDcEditGridView("attr", {name:"attrEditList", _hasTitle_:true, xtype:"bd_AttributeValue_Dc$CtxEditList", frame:true})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"detailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvas1", "canvas2"])
		.addChildrenTo("canvas1", ["categFilter", "categList"], ["north", "center"])
		.addChildrenTo("canvas2", ["categEdit", "detailsTab"], ["north", "center"])
		.addChildrenTo("detailsTab", ["attrEditList", "classificList", "substEditList"])
		.addToolbarTo("canvas1", "tlbCategList")
		.addToolbarTo("canvas2", "tlbCategEdit")
		.addToolbarTo("classificList", "tlbClassificList")
		.addToolbarTo("attrEditList", "tlbAttrEditList")
		.addToolbarTo("substEditList", "tlbSusbst");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbCategList", {dc: "categ"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports()
		.end()
		.beginToolbar("tlbCategEdit", {dc: "categ"})
			.addTitle().addSeparator().addSeparator()
			.addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports()
		.end()
		.beginToolbar("tlbClassificList", {dc: "classific"})
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
		.beginToolbar("tlbSusbst", {dc: "subst"})
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
	
	,_detailsState_: function() {
		
		var r = this._getDc_("categ").getRecord();
		if (r && r.get("acceptProd") === true) {
			this._get_("attrEditList").enable();
			this._get_("classificList").enable();
			this._get_("substEditList").enable();
		} else {
			this._get_("attrEditList").disable();
			this._get_("classificList").disable();
			this._get_("substEditList").disable();
		}
	}
	
	,_afterDefineDcs_: function() {
		
		this._getDc_("categ").on("recordChange", this._detailsState_, this);
		this._getDc_("categ").on("statusChange", this._detailsState_, this);
	}
});
