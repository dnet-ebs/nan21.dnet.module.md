/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "BpAccount_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.BpAccount_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("account", Ext.create(Dnet.ns.md + "BpAccount_Dc" ,{}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnCreateContinue", disabled:true, handler: this.onBtnCreateContinue,
				stateManager:{ name:"record_is_dirty", dc:"account" , and: function(dc) {return (dc.record.isValid());}}, scope:this})
		.addButton({name:"btnCreateCancel", disabled:false, handler: this.onBtnCreateCancel, scope:this})
		.addDcFilterFormView("account", {name:"accountFilter", xtype:"md_BpAccount_Dc$Filter"})
		.addDcGridView("account", {name:"accountList", xtype:"md_BpAccount_Dc$List"})
		.addDcFormView("account", {name:"accountEdit", width:550, xtype:"md_BpAccount_Dc$Edit"})
		.addDcFormView("account", {name:"accountCreate", width:350, xtype:"md_BpAccount_Dc$Create"})
		.addWindow({name:"wdwCreate", _hasTitle_:true, closeAction:'hide', resizable:true, layout:"fit", modal:true,
			items:[this._elems_.get("accountCreate")], closable:false
			, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnCreateContinue"), this._elems_.get("btnCreateCancel")]}]})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["accountFilter", "accountList", "accountEdit"], ["north", "center", "east"])
		.addToolbarTo("main", "tlbAccountList")
		.addToolbarTo("accountEdit", "tlbAccountEdit");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbAccountList", {dc: "account"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addNew().addCopy().addDeleteSelected()
			.addReports()
		.end()
		.beginToolbar("tlbAccountEdit", {dc: "account"})
			.addTitle().addSeparator().addSeparator()
			.addSave().addNew().addCopy().addCancel()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnCreateContinue
	 */
	,onBtnCreateContinue: function() {
		this._getWindow_("wdwCreate").close();
	}
	
	/**
	 * On-Click handler for button btnCreateCancel
	 */
	,onBtnCreateCancel: function() {
		this._getWindow_("wdwCreate").close();
		this._getDc_("account").doCancel();
	}
	
	,_whenCreate_: function() {	
		this._getWindow_("wdwCreate").show();
	}
	
	,_afterDefineDcs_: function() {
		this._getDc_("account").on("afterDoNew", this._whenCreate_, this);
	}
	
	,_when_called_to_edit_: function(params) {
		
		var account = this._getDc_("account");
		if (account.isDirty()) {
			this._alert_dirty_();
			return;
		}
		account.doClearQuery();
		
		account.setFilterValue("companyId", params.companyId);
		account.setFilterValue("company", params.company );
		account.setFilterValue("bpartnerId", params.bpartnerId );
		account.setFilterValue("bpartner", params.bpartner );
		account.doQuery();
	}
});
