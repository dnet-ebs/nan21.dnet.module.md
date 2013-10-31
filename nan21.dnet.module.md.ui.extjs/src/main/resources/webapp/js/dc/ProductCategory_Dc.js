/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "ProductCategory_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "ProductCategory_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "ProductCategory_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_ProductCategory_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"code", dataIndex:"code", xtype:"md_ProductCategories_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addLov({name:"category", dataIndex:"category", xtype:"md_ProductCategories_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "categoryId"} ]})
		.addLov({name:"attributeSet", dataIndex:"attributeSet", xtype:"bd_AttributeSets_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ]})
		.addLov({name:"material", dataIndex:"material", xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "materialId"} ],
			filterFieldMapping: [{lovField:"type", value: "Product.material"} ]})
		.addLov({name:"quality", dataIndex:"quality", xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "qualityId"} ],
			filterFieldMapping: [{lovField:"type", value: "Product.quality"} ]})
		.addLov({name:"surface", dataIndex:"surface", xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "surfaceId"} ],
			filterFieldMapping: [{lovField:"type", value: "Product.surface"} ]})
		.addTextField({ name:"name", dataIndex:"name"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addBooleanField({ name:"acceptProd", dataIndex:"acceptProd"})
		.addBooleanField({ name:"acceptCateg", dataIndex:"acceptCateg"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:250, layout:"form"})
		.addPanel({ name:"col4", width:190, layout:"form", defaults:{labelAlign:"right", labelWidth:130}});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
		.addChildrenTo("col1", ["code", "name"])
		.addChildrenTo("col2", ["category", "attributeSet"])
		.addChildrenTo("col3", ["material", "quality", "surface"])
		.addChildrenTo("col4", ["acceptProd", "acceptCateg", "active"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.md + "ProductCategory_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.md_ProductCategory_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code", width:120})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
		.addTextColumn({ name:"categoryId", dataIndex:"categoryId", hidden:true, width:100})
		.addTextColumn({ name:"category", dataIndex:"category", width:120})
		.addTextColumn({ name:"categoryName", dataIndex:"categoryName", hidden:true, width:200})
		.addTextColumn({ name:"attributeSetId", dataIndex:"attributeSetId", hidden:true, width:100})
		.addTextColumn({ name:"attributeSet", dataIndex:"attributeSet", width:120})
		.addTextColumn({ name:"attributeSetName", dataIndex:"attributeSetName", hidden:true, width:200})
		.addTextColumn({ name:"iconUrl", dataIndex:"iconUrl", width:100})
		.addBooleanColumn({ name:"acceptProd", dataIndex:"acceptProd"})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.md + "ProductCategory_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_ProductCategory_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"code", dataIndex:"code", caseRestriction:"uppercase"})
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextField({ name:"description", dataIndex:"description"})
		.addLov({name:"category", dataIndex:"category", xtype:"md_ProductCategories_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addTextField({ name:"categoryName", dataIndex:"categoryName", noEdit:true })
		.addLov({name:"attributeSet", dataIndex:"attributeSet", _enableFn_:this._accprod_fld_enabled_, xtype:"bd_AttributeSets_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ]})
		.addLov({name:"material", dataIndex:"material", _enableFn_:this._accprod_fld_enabled_, xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "materialId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.material"} ]})
		.addLov({name:"quality", dataIndex:"quality", _enableFn_:this._accprod_fld_enabled_, xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "qualityId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.quality"} ]})
		.addLov({name:"surface", dataIndex:"surface", _enableFn_:this._accprod_fld_enabled_, xtype:"bd_LookupItems_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "surfaceId"} ],
			filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.surface"} ]})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addBooleanField({ name:"acceptProd", dataIndex:"acceptProd",listeners:{
			change:{scope:this, fn:this.onAcceptProdChange}
		}})
		.addBooleanField({ name:"acceptCateg", dataIndex:"acceptCateg"})
		.addImage({ name:"iconLocation", dataIndex:"iconLocation", height:120})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"c1"})
		.addPanel({ name:"c2", width:270, layout:"form"})
		.addPanel({ name:"c3", width:120, layout:"form", defaults:{labelAlign:"top"}})
		.addPanel({ name:"row1", width:715, layout:"form", defaults:{labelAlign:"right", labelWidth:135}})
		.addPanel({ name:"row2", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
		.addPanel({ name:"col1", width:350, layout:"form", defaults:{labelAlign:"right", labelWidth:130}})
		.addPanel({ name:"col2", width:350, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["c1", "c2", "c3"])
		.addChildrenTo("c1", ["row1", "row2"])
		.addChildrenTo("c2", ["material", "quality", "surface"])
		.addChildrenTo("c3", ["iconLocation"])
		.addChildrenTo("row1", ["name", "description"])
		.addChildrenTo("row2", ["col1", "col2"])
		.addChildrenTo("col1", ["code", "acceptProd", "acceptCateg", "active"])
		.addChildrenTo("col2", ["category", "categoryName", "attributeSet"]);
	},
	/* ==================== Business functions ==================== */
	
	_accprod_fld_enabled_: function(dc,rec) {
		return rec.get("acceptProd") === true;
	},
	
	onAcceptProdChange: function() {
		var rec = this._getController_().getRecord();		 
		this._setFieldsEnabledState_(["attributeSet","material","quality","surface"], rec);
	}
});

/* ================= EDIT FORM: ViewIcon ================= */

Ext.define(Dnet.ns.md + "ProductCategory_Dc$ViewIcon" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_ProductCategory_Dc$ViewIcon",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addImage({ name:"iconLocation", dataIndex:"iconLocation", maxWidth:150})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["iconLocation"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "ProductCategory_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_ProductCategory_Dc$EditList",
	_bulkEditFields_: ["acceptCateg","acceptProd","active","attributeSet","category","material","quality","surface"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"description", dataIndex:"description", hidden:true, width:200})
		.addBooleanColumn({name:"acceptProd", dataIndex:"acceptProd"})
		.addBooleanColumn({name:"acceptCateg", dataIndex:"acceptCateg"})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"categoryId", dataIndex:"categoryId", hidden:true, width:100})
		.addLov({name:"category", dataIndex:"category", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_ProductCategories_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "categoryId"} ,{lovField:"name", dsField: "categoryName"} ]}})
		.addTextColumn({name:"categoryName", dataIndex:"categoryName", hidden:true, width:200})
		.addTextColumn({name:"attributeSetId", dataIndex:"attributeSetId", hidden:true, width:100})
		.addLov({name:"attributeSet", dataIndex:"attributeSet", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_AttributeSets_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ,{lovField:"name", dsField: "attributeSetName"} ],
				filterFieldMapping: [{lovField:"active", value: "true"} ]}})
		.addTextColumn({name:"attributeSetName", dataIndex:"attributeSetName", hidden:true, width:200})
		.addLov({name:"material", dataIndex:"material", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_LookupItems_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "materialId"} ],
				filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.material"} ]}})
		.addLov({name:"quality", dataIndex:"quality", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_LookupItems_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "qualityId"} ],
				filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.quality"} ]}})
		.addLov({name:"surface", dataIndex:"surface", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_LookupItems_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "surfaceId"} ],
				filterFieldMapping: [{lovField:"active", value: "true"}, {lovField:"type", value: "Product.surface"} ]}})
		.addTextColumn({name:"iconUrl", dataIndex:"iconUrl", width:100})
		.addDefaults();
	}
});
