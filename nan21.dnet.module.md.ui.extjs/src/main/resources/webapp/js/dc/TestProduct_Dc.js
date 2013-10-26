/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "TestProduct_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	paramModel: Dnet.ns.md + "Product_DsParam",
	recordModel: Dnet.ns.md + "Product_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.md + "TestProduct_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.md_TestProduct_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextField({ name:"code", dataIndex:"code", caseRestriction:"uppercase"})
		.addBooleanField({ name:"storable", dataIndex:"storable"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addLov({name:"manufacturer", dataIndex:"manufacturer", xtype:"md_ProductManufacturers_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:210, layout:"form"})
		.addPanel({ name:"col3", width:170, layout:"form", defaults:{labelAlign:"right", labelWidth:100}});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["name", "code"])
		.addChildrenTo("col2", ["manufacturer"])
		.addChildrenTo("col3", ["storable", "active"]);
	}
});

/* ================= FILTER: FilterPG ================= */


Ext.define(Dnet.ns.md + "TestProduct_Dc$FilterPG" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterPropGrid",
	alias: "widget.md_TestProduct_Dc$FilterPG",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", dataIndex:"name"})
			.addTextField({ name:"code", dataIndex:"code", caseRestriction:"uppercase"})
			.addBooleanField({ name:"storable", dataIndex:"storable"})
			.addBooleanField({ name:"active", dataIndex:"active"})
			.addTextField({ name:"manufacturerId", dataIndex:"manufacturerId"})
			.addLov({xtype:"md_ProductManufacturers_Lov", name:"manufacturer", dataIndex:"manufacturer", caseRestriction:"uppercase",
				editor:{_fqn_:Dnet.ns.md + "ProductManufacturers_Lov" , selectOnFocus:true, caseRestriction:"uppercase",
					retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]}})
			.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo"})
			.addLov({xtype:"bd_AttributeSets_Lov", name:"attributeSet", dataIndex:"attributeSet", caseRestriction:"uppercase",
				editor:{_fqn_:Dnet.ns.bd + "AttributeSets_Lov" , selectOnFocus:true, caseRestriction:"uppercase",
					retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ]}})
		;
	}

});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.md + "TestProduct_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.md_TestProduct_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"code", dataIndex:"code", width:120})
		.addBooleanColumn({ name:"active", dataIndex:"active", width:60})
		.addBooleanColumn({ name:"storable", dataIndex:"storable", width:60})
		.addTextColumn({ name:"uom", dataIndex:"uom", width:120})
		.addTextColumn({ name:"attributeSet", dataIndex:"attributeSet", width:120})
		.addNumberColumn({ name:"weight", dataIndex:"weight", decimals:6})
		.addTextColumn({ name:"weightUomId", dataIndex:"weightUomId", hidden:true, width:100})
		.addTextColumn({ name:"weightUom", dataIndex:"weightUom", width:120})
		.addTextColumn({ name:"iconUrl", dataIndex:"iconUrl", hidden:true, width:100})
		.addTextColumn({ name:"imageUrl", dataIndex:"imageUrl", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "TestProduct_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_TestProduct_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"code", dataIndex:"code", width:120, caseRestriction:"uppercase"})
		.addBooleanColumn({name:"active", dataIndex:"active", width:60})
		.addBooleanColumn({name:"storable", dataIndex:"storable", width:60})
		.addTextColumn({name:"uomId", dataIndex:"uomId", hidden:true, width:100})
		.addLov({name:"uom", dataIndex:"uom", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_Uoms_Lov", selectOnFocus:true, allowBlank:false, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "uomId"} ]}})
		.addTextColumn({name:"attributeSet", dataIndex:"attributeSet", width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", hidden:true, width:200})
		.addNumberColumn({name:"weight", dataIndex:"weight", align:"right", decimals:6 })
		.addTextColumn({name:"weightUomId", dataIndex:"weightUomId", hidden:true, width:100})
		.addTextColumn({name:"weightUom", dataIndex:"weightUom", width:120, caseRestriction:"uppercase"})
		.addNumberColumn({name:"dimWidth", dataIndex:"dimWidth", hidden:true, align:"right", decimals:6 })
		.addNumberColumn({name:"dimHeight", dataIndex:"dimHeight", hidden:true, align:"right", decimals:6 })
		.addNumberColumn({name:"dimDepth", dataIndex:"dimDepth", hidden:true, align:"right", decimals:6 })
		.addTextColumn({name:"dimUomId", dataIndex:"dimUomId", hidden:true, width:100})
		.addTextColumn({name:"dimUom", dataIndex:"dimUom", hidden:true, width:120, caseRestriction:"uppercase"})
		.addTextColumn({name:"iconUrl", dataIndex:"iconUrl", hidden:true, width:100})
		.addTextColumn({name:"imageUrl", dataIndex:"imageUrl", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.md + "TestProduct_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.md_TestProduct_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name", allowBlank:false})
		.addTextField({ name:"code", dataIndex:"code", caseRestriction:"uppercase"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo"})
		.addLov({name:"manufacturer", dataIndex:"manufacturer", xtype:"md_ProductManufacturers_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]})
		.addLov({name:"attributeSet", dataIndex:"attributeSet", xtype:"bd_AttributeSets_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ]})
		.addLov({name:"uom", dataIndex:"uom", allowBlank:false, xtype:"bd_Uoms_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "uomId"} ]})
		.addBooleanField({ name:"storable", dataIndex:"storable"})
		.addNumberField({name:"weight", dataIndex:"weight", decimals:6})
		.addLov({name:"weightUom", dataIndex:"weightUom", xtype:"bd_UomsMass_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "weightUomId"} ]})
		.addTextField({ name:"iconUrl", dataIndex:"iconUrl"})
		.addTextField({ name:"imageUrl", dataIndex:"imageUrl"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:300, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:300, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["name", "code", "uom", "attributeSet", "manufacturer", "manufacturerProductNo"])
		.addChildrenTo("col2", ["storable", "weight", "weightUom"])
		.addChildrenTo("col3", ["active", "iconUrl", "imageUrl"]);
	}
});

/* ================= EDITOR: EditPG ================= */


Ext.define(Dnet.ns.md + "TestProduct_Dc$EditPG" , {
	extend: "dnet.core.dc.view.AbstractDcvEditPropGrid",
	alias: "widget.md_TestProduct_Dc$EditPG",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", dataIndex:"name", allowBlank:false})
			.addTextField({ name:"code", dataIndex:"code", caseRestriction:"uppercase"})
			.addBooleanField({ name:"active", dataIndex:"active"})
			.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo"})
			.addLov({xtype:"md_ProductManufacturers_Lov", name:"manufacturer", dataIndex:"manufacturer", caseRestriction:"uppercase",
				editor:{_fqn_:Dnet.ns.md + "ProductManufacturers_Lov" , selectOnFocus:true,
					retFieldMapping: [{lovField:"id", dsField: "manufacturerId"} ]}})
			.addLov({xtype:"bd_AttributeSets_Lov", name:"attributeSet", dataIndex:"attributeSet", caseRestriction:"uppercase",
				editor:{_fqn_:Dnet.ns.bd + "AttributeSets_Lov" , selectOnFocus:true,
					retFieldMapping: [{lovField:"id", dsField: "attributeSetId"} ]}})
			.addTextField({ name:"uomId", dataIndex:"uomId"})
			.addLov({xtype:"bd_Uoms_Lov", name:"uom", dataIndex:"uom", allowBlank:false, caseRestriction:"uppercase",
				editor:{_fqn_:Dnet.ns.bd + "Uoms_Lov" , selectOnFocus:true, allowBlank:false,
					retFieldMapping: [{lovField:"id", dsField: "uomId"} ]}})
			.addBooleanField({ name:"storable", dataIndex:"storable"})
			.addNumberField({name:"weight", dataIndex:"weight", decimals:6})
			.addLov({xtype:"bd_UomsMass_Lov", name:"weightUom", dataIndex:"weightUom", caseRestriction:"uppercase",
				editor:{_fqn_:Dnet.ns.bd + "UomsMass_Lov" , selectOnFocus:true,
					retFieldMapping: [{lovField:"id", dsField: "weightUomId"} ]}})
			.addTextField({ name:"iconUrl", dataIndex:"iconUrl"})
			.addTextField({ name:"imageUrl", dataIndex:"imageUrl"})
		;
	}

});
