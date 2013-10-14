/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "CustomerAccountLov_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"active", type:"boolean"},
		{name:"bpartnerId", type:"string"},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"companyId", type:"string"},
		{name:"company", type:"string"},
		{name:"paymentTermId", type:"string"},
		{name:"paymentTerm", type:"string"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"refid", type:"string"}
	]
});
