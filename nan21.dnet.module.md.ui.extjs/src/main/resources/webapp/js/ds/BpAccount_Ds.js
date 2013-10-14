/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "BpAccount_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "company", type: 'presence'},
		{field: "bpartner", type: 'presence'}
	],
	
	fields: [
		{name:"customer", type:"boolean"},
		{name:"customerCreditLimit", type:"float", useNull:true},
		{name:"vendor", type:"boolean"},
		{name:"vendorCreditLimit", type:"float", useNull:true},
		{name:"bpartnerId", type:"string"},
		{name:"bpartner", type:"string"},
		{name:"bpartnerName", type:"string"},
		{name:"companyId", type:"string"},
		{name:"company", type:"string"},
		{name:"customerGroupId", type:"string"},
		{name:"customerGroup", type:"string"},
		{name:"customerPaymentMethodId", type:"string"},
		{name:"customerPaymentMethod", type:"string"},
		{name:"customerPaymentTermId", type:"string"},
		{name:"customerPaymentTerm", type:"string"},
		{name:"vendorGroupId", type:"string"},
		{name:"vendorGroup", type:"string"},
		{name:"vendorPaymentMethodId", type:"string"},
		{name:"vendorPaymentMethod", type:"string"},
		{name:"vendorPaymentTermId", type:"string"},
		{name:"vendorPaymentTerm", type:"string"},
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
	recordModelFqn: Dnet.ns.md + "BpAccount_Ds"
});
