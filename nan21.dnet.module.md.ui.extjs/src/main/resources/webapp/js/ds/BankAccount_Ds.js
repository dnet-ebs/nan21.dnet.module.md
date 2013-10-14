/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "BankAccount_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
		{field: "bank", type: 'presence'},
		{field: "accountNo", type: 'presence'},
		{field: "currency", type: 'presence'}
	],
	
	fields: [
		{name:"accountNo", type:"string"},
		{name:"ibanAccount", type:"boolean"},
		{name:"targetRefid", type:"string"},
		{name:"bankId", type:"string"},
		{name:"bank", type:"string"},
		{name:"bankName", type:"string"},
		{name:"bankBranchId", type:"string"},
		{name:"bankBranch", type:"string"},
		{name:"bankBranchName", type:"string"},
		{name:"currencyId", type:"string"},
		{name:"currency", type:"string"},
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
