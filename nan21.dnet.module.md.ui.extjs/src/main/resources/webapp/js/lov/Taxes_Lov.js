/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Taxes_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_Taxes_Lov",
	displayField: "name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "Tax_Ui",
		bundle: Dnet.bundle.md
	},
	recordModel: Dnet.ns.md + "TaxLov_Ds"
});
