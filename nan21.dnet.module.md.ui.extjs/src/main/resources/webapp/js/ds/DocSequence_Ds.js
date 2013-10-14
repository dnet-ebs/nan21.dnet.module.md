/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "DocSequence_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "company", type: 'presence'},
		{field: "docType", type: 'presence'},
		{field: "firstNo", type: 'presence'},
		{field: "lastNo", type: 'presence'},
		{field: "incrementBy", type: 'presence'}
	],
	
	initRecord: function() {
		this.set("firstNo", 1);
		this.set("lastNo", 999);
		this.set("incrementBy", 1);
		this.set("paddingLength", 4);
	},
	
	fields: [
		{name:"firstNo", type:"int", useNull:true},
		{name:"lastNo", type:"int", useNull:true},
		{name:"incrementBy", type:"int", useNull:true},
		{name:"prefix", type:"string"},
		{name:"suffix", type:"string"},
		{name:"paddingLength", type:"int", useNull:true},
		{name:"docTypeId", type:"string"},
		{name:"docType", type:"string"},
		{name:"companyId", type:"string"},
		{name:"company", type:"string"},
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
