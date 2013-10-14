/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "BusinessPartner_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "type", type: 'presence'}
	],
	
	initRecord: function() {
		this.set("type", "company");
		this.set("active", true);
	},
	
	fields: [
		{name:"type", type:"string"},
		{name:"taxPayerNo", type:"string"},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"middleName", type:"string"},
		{name:"gender", type:"string"},
		{name:"identityCardNo", type:"string"},
		{name:"passportNo", type:"string"},
		{name:"birthDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"companyName", type:"string"},
		{name:"registrationNo", type:"string"},
		{name:"registrationDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"countryId", type:"string"},
		{name:"country", type:"string"},
		{name:"legalFormId", type:"string"},
		{name:"legalForm", type:"string"},
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
