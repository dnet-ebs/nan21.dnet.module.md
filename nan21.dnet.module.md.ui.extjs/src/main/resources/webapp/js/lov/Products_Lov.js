/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Products_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_Products_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:350, maxHeight:350
	},
	_editDialog_: {
		name: "Product_Ui",
		bundle: Dnet.bundle.md
	},
	paramModel: Dnet.ns.md + "ProductLov_DsParam",
	recordModel: Dnet.ns.md + "ProductLov_Ds"
});
