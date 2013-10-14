/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "CustomerAccount_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "company", type: 'presence'},
		{field: "bpartner", type: 'presence'}
	],
	
	fields: [
		{name:"customer", type:"boolean"},
		{name:"creditLimit", type:"float", useNull:true},
		{name:"companyId", type:"string"},
		{name:"company", type:"string"},
		{name:"bpartnerId", type:"string"},
		{name:"bpartner", type:"string"},
		{name:"bpartnerName", type:"string"},
		{name:"groupId", type:"string"},
		{name:"group", type:"string"},
		{name:"paymentMethodId", type:"string"},
		{name:"paymentMethod", type:"string"},
		{name:"paymentTermId", type:"string"},
		{name:"paymentTerm", type:"string"},
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

Dnet.createFilterModelFromRecordModel({
	initFilter: function() {
		this.set("companyId", getApplication().getSession().company.id);
		this.set("company", getApplication().getSession().company.code);
	},
	recordModelFqn: Dnet.ns.md + "CustomerAccount_Ds"
});
