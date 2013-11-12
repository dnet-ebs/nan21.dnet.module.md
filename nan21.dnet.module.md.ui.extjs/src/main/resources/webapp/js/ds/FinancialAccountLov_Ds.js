/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "FinancialAccountLov_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"type", type:"string"},
		{name:"companyId", type:"string"},
		{name:"company", type:"string"},
		{name:"currencyId", type:"string"},
		{name:"currency", type:"string"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"refid", type:"string"}
	]
});
