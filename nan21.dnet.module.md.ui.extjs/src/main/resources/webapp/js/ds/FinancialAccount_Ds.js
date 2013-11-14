/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "FinancialAccount_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "company", type: 'presence'},
		{field: "code", type: 'presence'},
		{field: "name", type: 'presence'},
		{field: "currency", type: 'presence'},
		{field: "type", type: 'presence'}
	],
	
	initRecord: function() {
		this.set("company", getApplication().getSession().company.code);
		this.set("active", true);
	},
	
	fields: [
		{name:"type", type:"string"},
		{name:"companyId", type:"string"},
		{name:"company", type:"string"},
		{name:"currencyId", type:"string"},
		{name:"currency", type:"string"},
		{name:"bankAccountId", type:"string"},
		{name:"bankAccount", type:"string"},
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
