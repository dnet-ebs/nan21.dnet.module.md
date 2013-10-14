/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "Product_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "name", type: 'presence'}
	],
	
	fields: [
		{name:"iconUrl", type:"string"},
		{name:"imageUrl", type:"string"},
		{name:"storable", type:"boolean"},
		{name:"weight", type:"float", useNull:true},
		{name:"volume", type:"float", useNull:true},
		{name:"dimWidth", type:"float", useNull:true},
		{name:"dimHeight", type:"float", useNull:true},
		{name:"dimDepth", type:"float", useNull:true},
		{name:"manufacturerProductNo", type:"string"},
		{name:"iconLocation", type:"string"},
		{name:"imageLocation", type:"string"},
		{name:"categoryId", type:"string"},
		{name:"category", type:"string"},
		{name:"categoryName", type:"string"},
		{name:"attributeSetId", type:"string"},
		{name:"attributeSet", type:"string"},
		{name:"attributeSetName", type:"string"},
		{name:"uomId", type:"string"},
		{name:"uom", type:"string"},
		{name:"weightUomId", type:"string"},
		{name:"weightUom", type:"string"},
		{name:"volumeUomId", type:"string"},
		{name:"volumeUom", type:"string"},
		{name:"dimUomId", type:"string"},
		{name:"dimUom", type:"string"},
		{name:"manufacturerId", type:"string"},
		{name:"manufacturer", type:"string"},
		{name:"id", type:"string"},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
		{name:"active", type:"boolean"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"refid", type:"string"},
		{name:"entityAlias", type:"string"},
		{name:"entityFqn", type:"string"}
	]
});
