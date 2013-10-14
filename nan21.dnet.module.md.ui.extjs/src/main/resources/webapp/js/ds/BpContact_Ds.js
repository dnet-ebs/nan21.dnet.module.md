/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "BpContact_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "businessPartner", type: 'presence'},
		{field: "lastName", type: 'presence'}
	],
	
	fields: [
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"birthDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"businessPartnerId", type:"string"},
		{name:"businessPartner", type:"string"},
		{name:"businessPartnerName", type:"string"},
		{name:"positionId", type:"string"},
		{name:"position", type:"string"},
		{name:"id", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
		{name:"active", type:"boolean"},
		{name:"clientId", type:"string"},
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
