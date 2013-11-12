/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "BankAccounts_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_BankAccounts_Lov",
	displayField: "name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250, maxHeight:350
	},
	recordModel: Dnet.ns.md + "BankAccountLov_Ds"
});
