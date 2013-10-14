/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "DocSequence_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.DocSequence_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("seq", Ext.create(Dnet.ns.md + "DocSequence_Dc" ,{multiEdit:true}))	
		.addDc("val", Ext.create(Dnet.ns.md + "DocSequenceValue_Dc" ,{}))
		.linkDc("val", "seq",{fields:[
			{childField:"docSequenceId", parentField:"id"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnCreateValues", disabled:false, handler: this.onBtnCreateValues, scope:this})
		.addDcFilterFormView("seq", {name:"seqFilter", xtype:"md_DocSequence_Dc$Filter"})
		.addDcEditGridView("seq", {name:"seqEditList", xtype:"md_DocSequence_Dc$EditList", frame:true})
		.addDcGridView("val", {name:"valList", width:400, xtype:"md_DocSequenceValue_Dc$List"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["seqFilter", "seqEditList", "valList"], ["north", "center", "east"])
		.addToolbarTo("main", "tlbSeqEditList")
		.addToolbarTo("valList", "tlbValList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbSeqEditList", {dc: "seq"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnCreateValues") ])
			.addReports()
		.end()
		.beginToolbar("tlbValList", {dc: "val"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnCreateValues
	 */
	,onBtnCreateValues: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getDc_("val").doQuery();
		};
		var o={
			name:"createValues",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("seq").doRpcData(o);
	}
});
