/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "FinancialAccountUsage_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "FinancialAccountUsage_Ds"
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Dnet.ns.md + "FinancialAccountUsage_Dc$CtxEditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_FinancialAccountUsage_Dc$CtxEditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"paymentDocType", dataIndex:"paymentDocType", xtype:"gridcolumn", width:150, 
			editor:{xtype:"md_DocTypes_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "paymentDocTypeId"} ,{lovField:"name", dsField: "paymentDocTypeName"} ],
				filterFieldMapping: [{lovField:"category", value: "payment"}, {lovField:"active", value: "true"} ]}})
		.addTextColumn({name:"paymentDocTypeName", dataIndex:"paymentDocTypeName", width:200, noEdit: true})
		.addBooleanColumn({name:"allowPayIn", dataIndex:"allowPayIn", width:80})
		.addBooleanColumn({name:"allowPayOut", dataIndex:"allowPayOut", width:80})
		.addTextColumn({name:"financialAccountId", dataIndex:"financialAccountId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"financialAccount", dataIndex:"financialAccountId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
