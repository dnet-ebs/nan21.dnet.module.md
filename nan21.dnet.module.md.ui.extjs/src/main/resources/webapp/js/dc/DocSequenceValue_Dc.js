/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "DocSequenceValue_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.md + "DocSequenceValue_Ds"
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.md + "DocSequenceValue_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.md_DocSequenceValue_Dc$List",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"value", dataIndex:"value", width:200})
		.addBooleanColumn({ name:"used", dataIndex:"used"})
		.addDefaults();
	}
});
