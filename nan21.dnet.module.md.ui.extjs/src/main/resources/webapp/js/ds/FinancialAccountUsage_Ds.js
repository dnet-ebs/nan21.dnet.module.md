/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "FinancialAccountUsage_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"allowPayIn", type:"boolean"},
		{name:"allowPayOut", type:"boolean"},
		{name:"financialAccountId", type:"string"},
		{name:"financialAccount", type:"string"},
		{name:"paymentDocTypeId", type:"string"},
		{name:"paymentDocType", type:"string"},
		{name:"paymentDocTypeName", type:"string"},
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
