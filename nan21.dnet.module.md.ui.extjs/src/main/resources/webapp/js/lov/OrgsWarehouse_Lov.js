/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "OrgsWarehouse_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_OrgsWarehouse_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "Org_Ui",
		bundle: Dnet.bundle.md
	},
	recordModel: Dnet.ns.md + "OrgWarehouseLov_Ds"
});
