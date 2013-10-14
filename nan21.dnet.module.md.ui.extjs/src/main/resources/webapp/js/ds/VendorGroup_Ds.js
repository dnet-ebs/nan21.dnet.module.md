/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.md + "VendorGroup_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
			{field: "name", type: 'presence'}
	],
	
	initRecord: function() {
		this.set("active", true);
	},
	
	fields: [
		{name:"paymentMethodId", type:"string"},
		{name:"paymentMethod", type:"string"},
		{name:"paymentTermId", type:"string"},
		{name:"paymentTerm", type:"string"},
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
