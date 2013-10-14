/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "BankAccount_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "BankAccount_Ds"
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.md + "BankAccount_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.md_BankAccount_Dc$EditList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"bank", dataIndex:"bank", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_Banks_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "bankId"} ,{lovField:"name", dsField: "bankName"} ]}})
		.addTextColumn({name:"bankName", dataIndex:"bankName", width:200, noEdit: true})
		.addLov({name:"bankBranch", dataIndex:"bankBranch", xtype:"gridcolumn", width:120, 
			editor:{xtype:"md_BankBranches_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "bankBranchId"} ,{lovField:"name", dsField: "bankBranchName"} ],
				filterFieldMapping: [{lovField:"bankId", dsField: "bankId"} ]}})
		.addTextColumn({name:"bankBranchName", dataIndex:"bankBranchName", width:200, noEdit: true})
		.addLov({name:"currency", dataIndex:"currency", xtype:"gridcolumn", width:120, 
			editor:{xtype:"bd_Currencies_Lov", selectOnFocus:true, caseRestriction:"uppercase",
				retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]}})
		.addTextColumn({name:"accountNo", dataIndex:"accountNo", width:200, maxLength:32})
		.addBooleanColumn({name:"ibanAccount", dataIndex:"ibanAccount"})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"bankId", dataIndex:"bankId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"bankBranchId", dataIndex:"bankBranchId", hidden:true, width:100, noEdit: true})
		.addTextColumn({name:"currencyId", dataIndex:"currencyId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});
