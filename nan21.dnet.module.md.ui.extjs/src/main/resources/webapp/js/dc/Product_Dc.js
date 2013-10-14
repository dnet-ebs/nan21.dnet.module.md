/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Product_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "Product_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "Product_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_Product_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addLov({xtype:"md_Products_Lov", name:"code", dataIndex:"code", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addBooleanField({ name:"storable", dataIndex:"storable"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({xtype:"md_ProductManufacturers_Lov", name:"manufacturer", dataIndex:"manufacturer", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]})
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo"})
		.addLov({xtype:"bd_AttributeSets_Lov", name:"attributeSet", dataIndex:"attributeSet", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ]})
		.addLov({xtype:"md_ProductCategories_Lov", name:"category", dataIndex:"category", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:140, layout:"form", defaults:{labelAlign:"right", labelWidth:70}})
		.addPanel({ name:"col4", width:250, layout:"form"})
		.addPanel({ name:"col5", width:210, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col4", "col5"])
		.addChildrenTo("col1", ["code", "name"])
		.addChildrenTo("col2", ["storable", "active"])
		.addChildrenTo("col4", ["attributeSet", "category"])
		.addChildrenTo("col5", ["manufacturer", "manufacturerProductNo"]);
	}
});

/* ================= GRID: ShortList ================= */

Ext.define(Dnet.ns.md + "Product_Dc$ShortList" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.md_Product_Dc$ShortList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code", width:150})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"uom", dataIndex:"uom", hidden:true, width:80})
		.addTextColumn({ name:"manufacturer", dataIndex:"manufacturer", hidden:true, width:120})
		.addDefaults();
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.md + "Product_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.md_Product_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code", width:150})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})
		.addBooleanColumn({ name:"storable", dataIndex:"storable", width:60})
		.addTextColumn({ name:"uom", dataIndex:"uom", width:80})
		.addTextColumn({ name:"attributeSet", dataIndex:"attributeSet", width:120})
		.addTextColumn({ name:"category", dataIndex:"category", width:120})
		.addTextColumn({ name:"categoryName", dataIndex:"categoryName", hidden:true, width:200})
		.addTextColumn({ name:"manufacturer", dataIndex:"manufacturer", width:120})
		.addTextColumn({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", hidden:true, width:200})
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
		.addNumberColumn({ name:"weight", dataIndex:"weight", hidden:true, decimals:2})
		.addTextColumn({ name:"weightUom", dataIndex:"weightUom", hidden:true, width:120})
		.addNumberColumn({ name:"volume", dataIndex:"volume", hidden:true, decimals:2})
		.addTextColumn({ name:"volumeUom", dataIndex:"volumeUom", hidden:true, width:120})
		.addNumberColumn({ name:"dimWidth", dataIndex:"dimWidth", hidden:true, decimals:2})
		.addNumberColumn({ name:"dimHeight", dataIndex:"dimHeight", hidden:true, decimals:2})
		.addNumberColumn({ name:"dimDepth", dataIndex:"dimDepth", hidden:true, decimals:2})
		.addTextColumn({ name:"dimUom", dataIndex:"dimUom", hidden:true, width:120})
		.addTextColumn({ name:"iconUrl", dataIndex:"iconUrl", hidden:true, width:100})
		.addTextColumn({ name:"imageUrl", dataIndex:"imageUrl", hidden:true, width:100})
		.addTextColumn({ name:"uomId", dataIndex:"uomId", hidden:true, width:100})
		.addTextColumn({ name:"manufacturerId", dataIndex:"manufacturerId", hidden:true, width:100})
		.addTextColumn({ name:"weightUomId", dataIndex:"weightUomId", hidden:true, width:100})
		.addTextColumn({ name:"volumeUomId", dataIndex:"volumeUomId", hidden:true, width:100})
		.addTextColumn({ name:"dimUomId", dataIndex:"dimUomId", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT FORM: CtxFormName ================= */

Ext.define(Dnet.ns.md + "Product_Dc$CtxFormName" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_Product_Dc$CtxFormName",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name", noEdit:true , fieldCls:"important-field"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, width:"90%", layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["name"]);
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.md + "Product_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_Product_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name", allowBlank:false})
		.addTextField({ name:"code", dataIndex:"code", caseRestriction:"uppercase"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({xtype:"bd_AttributeSets_Lov", name:"attributeSet", dataIndex:"attributeSet", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ]})
		.addLov({xtype:"md_ProductCategories_Lov", name:"category", dataIndex:"category", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "categoryId"} ,{lovField:"name", dsField: "categoryName"} ]})
		.addTextField({ name:"categoryName", dataIndex:"categoryName", noEdit:true })
		.addLov({xtype:"bd_Uoms_Lov", name:"uom", dataIndex:"uom", allowBlank:false, caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "uomId"} ]})
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo"})
		.addLov({xtype:"md_ProductManufacturers_Lov", name:"manufacturer", dataIndex:"manufacturer", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]})
		.addImage({ name:"iconLocation", dataIndex:"iconLocation", height:120})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"c1"})
		.addPanel({ name:"c2", width:250, layout:"form"})
		.addPanel({ name:"c3", width:120, layout:"form", defaults:{labelAlign:"top"}})
		.addPanel({ name:"row1", width:750, layout:"form"})
		.addPanel({ name:"row2", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
		.addPanel({ name:"col1", width:350, layout:"form"})
		.addPanel({ name:"col2", width:350, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["c1", "c2", "c3"])
		.addChildrenTo("c1", ["row1", "row2"])
		.addChildrenTo("c2", ["manufacturer", "manufacturerProductNo"])
		.addChildrenTo("c3", ["iconLocation"])
		.addChildrenTo("row1", ["name"])
		.addChildrenTo("row2", ["col1", "col2"])
		.addChildrenTo("col1", ["code", "uom", "active"])
		.addChildrenTo("col2", ["category", "categoryName", "attributeSet"]);
	}
});

/* ================= EDIT FORM: EditInfo ================= */

Ext.define(Dnet.ns.md + "Product_Dc$EditInfo" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_Product_Dc$EditInfo",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"iconUrl", dataIndex:"iconUrl"})
		.addTextField({ name:"imageUrl", dataIndex:"imageUrl"})
		.addBooleanField({ name:"storable", dataIndex:"storable"})
		.addNumberField({name:"weight", dataIndex:"weight", decimals:2})
		.addNumberField({name:"volume", dataIndex:"volume", decimals:2})
		.addNumberField({name:"dimWidth", dataIndex:"dimWidth", decimals:2})
		.addNumberField({name:"dimHeight", dataIndex:"dimHeight", decimals:2})
		.addNumberField({name:"dimDepth", dataIndex:"dimDepth", decimals:2})
		.addLov({xtype:"bd_UomsVolume_Lov", name:"volumeUom", dataIndex:"volumeUom", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "volumeUomId"} ]})
		.addLov({xtype:"bd_UomsMass_Lov", name:"weightUom", dataIndex:"weightUom", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "weightUomId"} ]})
		.addLov({xtype:"bd_UomsLength_Lov", name:"dimUom", dataIndex:"dimUom", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "dimUomId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", title:"Physical", width:250, layout:"form", xtype:"fieldset", border:true, collapsible:false})
		.addPanel({ name:"col2", title:"Dimensions", width:250, layout:"form", xtype:"fieldset", border:true, collapsible:false})
		.addPanel({ name:"col3", title:"Image", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"top"}});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["storable", "weight", "weightUom", "volume", "volumeUom"])
		.addChildrenTo("col2", ["dimWidth", "dimHeight", "dimDepth", "dimUom"])
		.addChildrenTo("col3", ["iconUrl", "imageUrl"]);
	}
});
