/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "ProductAccounts_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_ProductAccounts_Lov",
	displayField: "product",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{product}, {productName}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "ProductAccount_Ui",
		bundle: Dnet.bundle.md
	},
	recordModel: Dnet.ns.md + "ProductAccountLov_Ds"
});
