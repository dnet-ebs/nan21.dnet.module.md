/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "ProductAccount_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "company", type: 'presence'},
		{field: "product", type: 'presence'},
		{field: "type", type: 'presence'}
	],
	
	fields: [
		{name:"analiticSegment", type:"string"},
		{name:"companyId", type:"string"},
		{name:"company", type:"string"},
		{name:"typeId", type:"string"},
		{name:"type", type:"string"},
		{name:"purchase", type:"boolean"},
		{name:"sale", type:"boolean"},
		{name:"inventory", type:"boolean"},
		{name:"productId", type:"string"},
		{name:"product", type:"string"},
		{name:"productName", type:"string"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"active", type:"boolean"},
		{name:"version", type:"int", useNull:true},
		{name:"refid", type:"string"},
		{name:"entityAlias", type:"string"},
		{name:"entityFqn", type:"string"}
	]
});
