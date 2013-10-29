/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "ProductCategory_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
			{field: "name", type: 'presence'}
	],
	
	fields: [
		{name:"acceptProd", type:"boolean"},
		{name:"acceptCateg", type:"boolean"},
		{name:"iconUrl", type:"string"},
		{name:"iconLocation", type:"string"},
		{name:"categoryId", type:"string"},
		{name:"category", type:"string"},
		{name:"categoryName", type:"string"},
		{name:"attributeSetId", type:"string"},
		{name:"attributeSet", type:"string"},
		{name:"attributeSetName", type:"string"},
		{name:"materialId", type:"string"},
		{name:"material", type:"string"},
		{name:"qualityId", type:"string"},
		{name:"quality", type:"string"},
		{name:"surfaceId", type:"string"},
		{name:"surface", type:"string"},
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
