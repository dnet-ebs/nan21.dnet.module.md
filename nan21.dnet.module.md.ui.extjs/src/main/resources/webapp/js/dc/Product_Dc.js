/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Product_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	paramModel: Dnet.ns.md + "Product_DsParam",
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
		.addLov({name:"code", dataIndex:"code", xtype:"md_Products_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addBooleanField({ name:"storable", dataIndex:"storable"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({name:"manufacturer", dataIndex:"manufacturer", xtype:"md_ProductManufacturers_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]})
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo"})
		.addLov({name:"attributeSet", dataIndex:"attributeSet", xtype:"bd_AttributeSets_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ]})
		.addLov({name:"category", dataIndex:"category", xtype:"md_ProductCategories_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]})
		.addLov({name:"attr1", paramIndex:"attr1", width:250, xtype:"bd_Attributes_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsParam: "attr1id"} ]})
		.addTextField({ name:"attr1val", paramIndex:"attr1val", noLabel: true})
		.addLov({name:"attr2", paramIndex:"attr2", width:250, xtype:"bd_Attributes_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsParam: "attr2id"} ]})
		.addTextField({ name:"attr2val", paramIndex:"attr2val", noLabel: true})
		.addLov({name:"attr3", paramIndex:"attr3", width:250, xtype:"bd_Attributes_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsParam: "attr3id"} ]})
		.addTextField({ name:"attr3val", paramIndex:"attr3val", noLabel: true})
		.addLov({name:"material", dataIndex:"material", xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "materialId"} ],
			filterFieldMapping: [{lovField:"type", value: "Product.material"} ]})
		.addLov({name:"quality", dataIndex:"quality", xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "qualityId"} ],
			filterFieldMapping: [{lovField:"type", value: "Product.quality"} ]})
		.addLov({name:"surface", dataIndex:"surface", xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "surfaceId"} ],
			filterFieldMapping: [{lovField:"type", value: "Product.surface"} ]})
		.add({name:"attr1cf", xtype: "fieldcontainer", layout: "hbox", items: [this._getConfig_("attr1"),this._getConfig_("attr1val")]})
		.add({name:"attr2cf", xtype: "fieldcontainer", layout: "hbox", items: [this._getConfig_("attr2"),this._getConfig_("attr2val")]})
		.add({name:"attr3cf", xtype: "fieldcontainer", layout: "hbox", items: [this._getConfig_("attr3"),this._getConfig_("attr3val")]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form", defaults:{labelAlign:"right", labelWidth:120}})
		.addPanel({ name:"col3", width:350, layout:"form"})
		.addPanel({ name:"col4", width:220, layout:"form"})
		.addPanel({ name:"col5", width:140, layout:"form", defaults:{labelAlign:"right", labelWidth:70}});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3", "col4", "col5"])
		.addChildrenTo("col1", ["code", "name", "category"])
		.addChildrenTo("col2", ["manufacturer", "manufacturerProductNo", "attributeSet"])
		.addChildrenTo("col3", ["attr1cf", "attr2cf", "attr3cf"])
		.addChildrenTo("col4", ["material", "quality", "surface"])
		.addChildrenTo("col5", ["storable", "active"]);
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
		.addTextColumn({ name:"uomId", dataIndex:"uomId", hidden:true, width:100})
		.addTextColumn({ name:"uom", dataIndex:"uom", width:80})
		.addTextColumn({ name:"attributeSet", dataIndex:"attributeSet", width:120})
		.addTextColumn({ name:"categoryId", dataIndex:"categoryId", hidden:true, width:100})
		.addTextColumn({ name:"category", dataIndex:"category", width:120})
		.addTextColumn({ name:"categoryName", dataIndex:"categoryName", hidden:true, width:200})
		.addTextColumn({ name:"manufacturerId", dataIndex:"manufacturerId", hidden:true, width:100})
		.addTextColumn({ name:"manufacturer", dataIndex:"manufacturer", width:120})
		.addTextColumn({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", hidden:true, width:200})
		.addTextColumn({ name:"materialId", dataIndex:"materialId", hidden:true, width:100})
		.addTextColumn({ name:"material", dataIndex:"material", width:100})
		.addTextColumn({ name:"qualityId", dataIndex:"qualityId", hidden:true, width:100})
		.addTextColumn({ name:"quality", dataIndex:"quality", width:100})
		.addTextColumn({ name:"surfaceId", dataIndex:"surfaceId", hidden:true, width:100})
		.addTextColumn({ name:"surface", dataIndex:"surface", width:100})
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
		.addNumberColumn({ name:"weight", dataIndex:"weight", hidden:true, decimals:6})
		.addTextColumn({ name:"weightUomId", dataIndex:"weightUomId", hidden:true, width:100})
		.addTextColumn({ name:"weightUom", dataIndex:"weightUom", hidden:true, width:120})
		.addNumberColumn({ name:"volume", dataIndex:"volume", hidden:true, decimals:6})
		.addTextColumn({ name:"volumeUomId", dataIndex:"volumeUomId", hidden:true, width:100})
		.addTextColumn({ name:"volumeUom", dataIndex:"volumeUom", hidden:true, width:120})
		.addNumberColumn({ name:"dimWidth", dataIndex:"dimWidth", hidden:true, decimals:6})
		.addNumberColumn({ name:"dimHeight", dataIndex:"dimHeight", hidden:true, decimals:6})
		.addNumberColumn({ name:"dimDepth", dataIndex:"dimDepth", hidden:true, decimals:6})
		.addTextColumn({ name:"dimUomId", dataIndex:"dimUomId", hidden:true, width:100})
		.addTextColumn({ name:"dimUom", dataIndex:"dimUom", hidden:true, width:120})
		.addTextColumn({ name:"iconUrl", dataIndex:"iconUrl", hidden:true, width:100})
		.addTextColumn({ name:"imageUrl", dataIndex:"imageUrl", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "Product_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_Product_Dc$EditList",
	_bulkEditFields_: ["active","storable","uom","attributeSet","category","manufacturer","weight","weightUom","volume","volumeUom","dimWidth","dimHeight","dimDepth","dimUom"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"code", dataIndex:"code", width:150, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addBooleanColumn({name:"active", dataIndex:"active", width:60})
		.addBooleanColumn({name:"storable", dataIndex:"storable", width:60})
		.addLov({name:"uom", dataIndex:"uom", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_Uoms_Lov", selectOnFocus:true, allowBlank:false, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "uomId"} ]}})
		.addTextColumn({name:"uomId", dataIndex:"uomId", hidden:true, width:100, noEdit: true})
		.addLov({name:"attributeSet", dataIndex:"attributeSet", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_AttributeSets_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ],
				filterFieldMapping: [{lovField:"active", value: "true"} ]}})
		.addLov({name:"category", dataIndex:"category", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_ProductCategories_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "categoryId"} ,{lovField:"name", dsField: "categoryName"} ],
				filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"acceptProd", value: "true"} ]}})
		.addTextColumn({name:"categoryId", dataIndex:"categoryId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"categoryName", dataIndex:"categoryName", hidden:true, width:200, noEdit: true})
		.addLov({name:"manufacturer", dataIndex:"manufacturer", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_ProductManufacturers_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]}})
		.addTextColumn({name:"manufacturerId", dataIndex:"manufacturerId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", width:200})
		.addLov({name:"material", dataIndex:"material", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_LookupItems_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "materialId"} ],
				filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.material"} ]}})
		.addTextColumn({name:"materialId", dataIndex:"materialId", hidden:true, width:100, noEdit: true})
		.addLov({name:"quality", dataIndex:"quality", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_LookupItems_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "qualityId"} ],
				filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.quality"} ]}})
		.addTextColumn({name:"qualityId", dataIndex:"qualityId", hidden:true, width:100, noEdit: true})
		.addLov({name:"surface", dataIndex:"surface", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_LookupItems_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "surfaceId"} ],
				filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.surface"} ]}})
		.addTextColumn({name:"surfaceId", dataIndex:"surfaceId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"description", dataIndex:"description", hidden:true, width:200})
		.addNumberColumn({name:"weight", dataIndex:"weight", align:"right", decimals:6 })
		.addLov({name:"weightUom", dataIndex:"weightUom", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_UomsMass_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "weightUomId"} ]}})
		.addTextColumn({name:"weightUomId", dataIndex:"weightUomId", hidden:true, width:100, noEdit: true})
		.addNumberColumn({name:"volume", dataIndex:"volume", hidden:true, align:"right", decimals:6 })
		.addLov({name:"volumeUom", dataIndex:"volumeUom", hidden:true, xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_UomsVolume_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "volumeUomId"} ]}})
		.addTextColumn({name:"volumeUomId", dataIndex:"volumeUomId", hidden:true, width:100, noEdit: true})
		.addNumberColumn({name:"dimWidth", dataIndex:"dimWidth", align:"right", decimals:6 })
		.addNumberColumn({name:"dimHeight", dataIndex:"dimHeight", align:"right", decimals:6 })
		.addNumberColumn({name:"dimDepth", dataIndex:"dimDepth", align:"right", decimals:6 })
		.addLov({name:"dimUom", dataIndex:"dimUom", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_UomsLength_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "dimUomId"} ]}})
		.addTextColumn({name:"dimUomId", dataIndex:"dimUomId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"iconUrl", dataIndex:"iconUrl", hidden:true, width:100})
		.addTextColumn({name:"imageUrl", dataIndex:"imageUrl", hidden:true, width:100})
		.addDefaults();
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
		.addTextField({ name:"description", dataIndex:"description"})
		.addTextField({ name:"code", dataIndex:"code", caseRestriction:"uppercase"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({name:"attributeSet", dataIndex:"attributeSet", xtype:"bd_AttributeSets_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"} ]})
		.addLov({name:"category", dataIndex:"category", xtype:"md_ProductCategories_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "categoryId"} ,{lovField:"name", dsField: "categoryName"} ],
			filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"acceptProd", value: "true"} ]})
		.addTextField({ name:"categoryName", dataIndex:"categoryName", noEdit:true })
		.addLov({name:"uom", dataIndex:"uom", allowBlank:false, xtype:"bd_Uoms_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "uomId"} ]})
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo"})
		.addLov({name:"manufacturer", dataIndex:"manufacturer", xtype:"md_ProductManufacturers_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]})
		.addImage({ name:"iconLocation", dataIndex:"iconLocation", height:120})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"c1"})
		.addPanel({ name:"c2", width:250, layout:"form"})
		.addPanel({ name:"c3", width:120, layout:"form", defaults:{labelAlign:"top"}})
		.addPanel({ name:"row1", width:715, layout:"form", defaults:{labelAlign:"right", labelWidth:105}})
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
		.addChildrenTo("row1", ["name", "description"])
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
		.addTextArea({ name:"notes", dataIndex:"notes", height:80})
		.addTextField({ name:"iconUrl", dataIndex:"iconUrl"})
		.addTextField({ name:"imageUrl", dataIndex:"imageUrl"})
		.addBooleanField({ name:"storable", dataIndex:"storable"})
		.addNumberField({name:"weight", dataIndex:"weight", decimals:6})
		.addNumberField({name:"volume", dataIndex:"volume", decimals:6})
		.addNumberField({name:"dimWidth", dataIndex:"dimWidth", decimals:6})
		.addNumberField({name:"dimHeight", dataIndex:"dimHeight", decimals:6})
		.addNumberField({name:"dimDepth", dataIndex:"dimDepth", decimals:6})
		.addLov({name:"volumeUom", dataIndex:"volumeUom", xtype:"bd_UomsVolume_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "volumeUomId"} ]})
		.addLov({name:"weightUom", dataIndex:"weightUom", xtype:"bd_UomsMass_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "weightUomId"} ]})
		.addLov({name:"dimUom", dataIndex:"dimUom", xtype:"bd_UomsLength_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "dimUomId"} ]})
		.addLov({name:"material", dataIndex:"material", xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "materialId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.material"} ]})
		.addLov({name:"quality", dataIndex:"quality", xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "qualityId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.quality"} ]})
		.addLov({name:"surface", dataIndex:"surface", xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "surfaceId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.surface"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1"})
		.addPanel({ name:"col3"})
		.addPanel({ name:"form1", title:"Physical", width:250, layout:"form", xtype:"fieldset", border:true, collapsible:false})
		.addPanel({ name:"form2", title:"Dimensions", width:250, layout:"form", xtype:"fieldset", border:true, collapsible:false})
		.addPanel({ name:"form3", title:"Descriptors", width:300, layout:"form", xtype:"fieldset", border:true, collapsible:false})
		.addPanel({ name:"form4", title:"Image", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"top"}})
		.addPanel({ name:"form5", width:400, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"top"}});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "form3", "col3"])
		.addChildrenTo("col1", ["form1", "form2"])
		.addChildrenTo("col3", ["form4", "form5"])
		.addChildrenTo("form1", ["storable", "weight", "weightUom", "volume", "volumeUom"])
		.addChildrenTo("form2", ["dimWidth", "dimHeight", "dimDepth", "dimUom"])
		.addChildrenTo("form3", ["material", "quality", "surface"])
		.addChildrenTo("form4", ["iconUrl", "imageUrl"])
		.addChildrenTo("form5", ["notes"]);
	}
});
