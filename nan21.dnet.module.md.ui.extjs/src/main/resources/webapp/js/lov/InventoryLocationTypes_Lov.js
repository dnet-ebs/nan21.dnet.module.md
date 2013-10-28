/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "InventoryLocationTypes_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_InventoryLocationTypes_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "Inventory_Ui",
		bundle: Dnet.bundle.md,
		tocElement: "canvasLoctype"
	},
	recordModel: Dnet.ns.md + "InventoryLocationTypeLov_Ds"
});
