/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "FiscalYear_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.FiscalYear_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("year", Ext.create(Dnet.ns.md + "FiscalYear_Dc" ,{multiEdit:true}))	
		.addDc("period", Ext.create(Dnet.ns.md + "FiscalPeriod_Dc" ,{multiEdit:true}))
		.linkDc("period", "year",{fields:[
			{childField:"fiscalYearId", parentField:"id"}, {childField:"fiscalYear", parentField:"name", noFilter:true}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnCreateMonths", disabled:true, handler: this.onBtnCreateMonths,
				stateManager:{ name:"selected_one_clean", dc:"year" }, scope:this})
		.addButton({name:"btnCreateQuarters", disabled:true, handler: this.onBtnCreateQuarters,
				stateManager:{ name:"selected_one_clean", dc:"year" }, scope:this})
		.addButton({name:"btnCreateHalfYears", disabled:true, handler: this.onBtnCreateHalfYears,
				stateManager:{ name:"selected_one_clean", dc:"year" }, scope:this})
		.addDcFilterFormView("year", {name:"yearFilter", xtype:"md_FiscalYear_Dc$Filter"})
		.addDcEditGridView("year", {name:"yearEditList", xtype:"md_FiscalYear_Dc$EditList", frame:true})
		.addDcFilterFormView("period", {name:"periodFilter", _hasTitle_:true, width:250, xtype:"md_FiscalPeriod_Dc$FilterCtx", collapsible:true, collapsed:false
		})
		.addDcEditGridView("period", {name:"periodEditList", xtype:"md_FiscalPeriod_Dc$CtxEditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}})
		.addPanel({name:"periodPanel", height:240, layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["yearFilter", "yearEditList", "periodPanel"], ["north", "center", "south"])
		.addChildrenTo("periodPanel", ["periodFilter", "periodEditList"], ["west", "center"])
		.addToolbarTo("main", "tlbYearList")
		.addToolbarTo("periodPanel", "tlbPeriodList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbYearList", {dc: "year"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnCreateMonths") ,this._elems_.get("btnCreateQuarters") ,this._elems_.get("btnCreateHalfYears") ])
			.addReports()
		.end()
		.beginToolbar("tlbPeriodList", {dc: "period"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnCreateMonths
	 */
	,onBtnCreateMonths: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getDc_("period").doQuery();
		};
		var o={
			name:"createMonths",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("year").doRpcData(o);
	}
	
	/**
	 * On-Click handler for button btnCreateQuarters
	 */
	,onBtnCreateQuarters: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getDc_("period").doQuery();
		};
		var o={
			name:"createQuarters",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("year").doRpcData(o);
	}
	
	/**
	 * On-Click handler for button btnCreateHalfYears
	 */
	,onBtnCreateHalfYears: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getDc_("period").doQuery();
		};
		var o={
			name:"createHalfYears",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("year").doRpcData(o);
	}
});
