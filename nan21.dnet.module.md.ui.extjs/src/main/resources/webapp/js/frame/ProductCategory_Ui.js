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
		.addDc("categ", Ext.create(Dnet.ns.md + "ProductCategory_Dc" ,{multiEdit:true}))	
		.addDc("attr", Ext.create(Dnet.ns.bd + "AttributeValue_Dc" ,{multiEdit:true}))	
		.addDc("classific", Ext.create(Dnet.ns.bd + "Classification_Dc" ,{multiEdit:true}))
		.linkDc("attr", "categ",{fields:[
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
		.addDcEditGridView("categ", {name:"categEditList", xtype:"md_ProductCategory_Dc$EditList", frame:true})
		.addDcFormView("categ", {name:"categView", _hasTitle_:true, xtype:"md_ProductCategory_Dc$ViewIcon"})
		.addDcEditGridView("classific", {name:"classificList", _hasTitle_:true, xtype:"bd_Classification_Dc$EditList", frame:true})
		.addDcEditGridView("attr", {name:"attrEditList", _hasTitle_:true, xtype:"bd_AttributeValue_Dc$CtxEditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}})
		.addPanel({name:"detailsPanel", width:600, layout:"accordion", activeItem:0});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["categFilter", "categEditList", "detailsPanel"], ["north", "center", "east"])
		.addChildrenTo("detailsPanel", ["categView", "attrEditList", "classificList"])
		.addToolbarTo("main", "tlbCateg")
		.addToolbarTo("classificList", "tlbClassificList")
		.addToolbarTo("attrEditList", "tlbAttrEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbCateg", {dc: "categ"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
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
