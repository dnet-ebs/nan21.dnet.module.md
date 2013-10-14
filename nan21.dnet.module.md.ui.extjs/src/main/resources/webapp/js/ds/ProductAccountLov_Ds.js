/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "ProductAccountLov_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"active", type:"boolean"},
		{name:"productId", type:"string"},
		{name:"product", type:"string"},
		{name:"productName", type:"string"},
		{name:"uomId", type:"string"},
		{name:"uom", type:"string"},
		{name:"companyId", type:"string"},
		{name:"company", type:"string"},
		{name:"purchase", type:"boolean"},
		{name:"sale", type:"boolean"},
		{name:"inventory", type:"boolean"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"refid", type:"string"}
	]
});
