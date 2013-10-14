/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Bp_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Bp_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("bp", Ext.create(Dnet.ns.md + "BusinessPartner_Dc" ,{}))	
		.addDc("address", Ext.create(Dnet.ns.bd + "Location_Dc" ,{}))	
		.addDc("bankAccount", Ext.create(Dnet.ns.md + "BankAccount_Dc" ,{multiEdit:true}))	
		.addDc("contact", Ext.create(Dnet.ns.md + "BpContact_Dc" ,{multiEdit:true}))	
		.addDc("communic", Ext.create(Dnet.ns.bd + "CommunicationMethod_Dc" ,{multiEdit:true}))	
		.addDc("classific", Ext.create(Dnet.ns.bd + "Classification_Dc" ,{multiEdit:true}))	
		.addDc("atch", Ext.create(Dnet.ns.bd + "Attachment_Dc" ,{}))
		.linkDc("address", "bp",{fields:[
			{childField:"targetRefid", parentField:"refid"}]}
		).linkDc("bankAccount", "bp",{fields:[
			{childField:"targetRefid", parentField:"refid"}]}
		).linkDc("contact", "bp",{fields:[
			{childField:"businessPartnerId", parentField:"id"}, {childField:"businessPartner", parentField:"code", noFilter:true}]}
		).linkDc("communic", "bp",{fields:[
			{childField:"targetRefid", parentField:"refid"}, {childField:"targetAlias", parentField:"entityAlias"}, {childField:"targetType", parentField:"type"}]}
		).linkDc("classific", "bp",{fields:[
			{childField:"targetRefid", parentField:"refid"}, {childField:"targetAlias", parentField:"entityAlias"}, {childField:"targetType", parentField:"type"}]}
		).linkDc("atch", "bp",{fields:[
			{childField:"targetRefid", parentField:"refid"}, {childField:"targetAlias", parentField:"entityAlias"}, {childField:"targetType", parentField:"type"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnCreateContinue", disabled:false, handler: this.onBtnCreateContinue, scope:this})
		.addButton({name:"btnCreateCancel", disabled:false, handler: this.onBtnCreateCancel, scope:this})
		.addDcFilterFormView("bp", {name:"bpFilter", xtype:"md_BusinessPartner_Dc$Filter"})
		.addDcGridView("bp", {name:"bpList", xtype:"md_BusinessPartner_Dc$List"})
		.addDcFormView("bp", {name:"bpCreate", xtype:"md_BusinessPartner_Dc$Create"})
		.addDcFormView("bp", {name:"bpEdit", xtype:"md_BusinessPartner_Dc$Edit"})
		.addDcGridView("address", {name:"addressList", xtype:"bd_Location_Dc$ListCtx"})
		.addDcFormView("address", {name:"addressEdit", xtype:"bd_Location_Dc$EditCtx"})
		.addDcEditGridView("bankAccount", {name:"bankAccountEditList", _hasTitle_:true, xtype:"md_BankAccount_Dc$EditList", frame:true})
		.addDcEditGridView("classific", {name:"classificEdit", _hasTitle_:true, xtype:"bd_Classification_Dc$EditList", frame:true})
		.addDcEditGridView("communic", {name:"communicEditList", _hasTitle_:true, xtype:"bd_CommunicationMethod_Dc$EditList", frame:true})
		.addDcEditGridView("contact", {name:"contactList", _hasTitle_:true, xtype:"md_BpContact_Dc$EditList", frame:true})
		.addDcGridView("atch", {name:"atchList", _hasTitle_:true, xtype:"bd_Attachment_Dc$List"})
		.addWindow({name:"wdwCreate", _hasTitle_:true, closeAction:'hide', resizable:true, layout:"fit", modal:true,
			items:[this._elems_.get("bpCreate")], closable:false
			, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnCreateContinue"), this._elems_.get("btnCreateCancel")]}]})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}, onActivateDoLayoutFor:["bpEdit", "bpDetailsTab"]})
		.addPanel({name:"bpDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
		.addPanel({name:"addressPanel", _hasTitle_:true, layout:"card", activeItem:0})
		.addPanel({name:"addressEditWrapper", layout:"fit"});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvas1", "canvas2"])
		.addChildrenTo("canvas1", ["bpFilter", "bpList"], ["north", "center"])
		.addChildrenTo("canvas2", ["bpEdit", "bpDetailsTab"], ["north", "center"])
		.addChildrenTo("bpDetailsTab", ["addressPanel", "communicEditList", "contactList", "bankAccountEditList", "classificEdit", "atchList"])
		.addChildrenTo("addressPanel", ["addressList", "addressEditWrapper"])
		.addChildrenTo("addressEditWrapper", ["addressEdit"])
		.addToolbarTo("canvas1", "tlbBpList")
		.addToolbarTo("canvas2", "tlbBpEdit")
		.addToolbarTo("addressList", "tlbAddressList")
		.addToolbarTo("addressEditWrapper", "tlbAddressEdit")
		.addToolbarTo("bankAccountEditList", "tlbBankAccountList")
		.addToolbarTo("communicEditList", "tlbCommunicEditList")
		.addToolbarTo("contactList", "tlbContactEditList")
		.addToolbarTo("classificEdit", "tlbClassific")
		.addToolbarTo("atchList", "tlbAtchList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbBpList", {dc: "bp"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports()
		.end()
		.beginToolbar("tlbBpEdit", {dc: "bp"})
			.addTitle().addSeparator().addSeparator()
			.addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports()
		.end()
		.beginToolbar("tlbAddressList", {dc: "address"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addEdit({inContainer:"addressPanel",showView:"addressEditWrapper"}
			).addNew().addCopy().addDeleteSelected()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbAddressEdit", {dc: "address"})
			.addTitle().addSeparator().addSeparator()
			.addBack({inContainer:"addressPanel",showView:"addressList"}
			).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbBankAccountList", {dc: "bankAccount"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbCommunicEditList", {dc: "communic"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbContactEditList", {dc: "contact"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbClassific", {dc: "classific"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbAtchList", {dc: "atch"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addNew().addDeleteSelected()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnCreateContinue
	 */
	,onBtnCreateContinue: function() {
		this._getWindow_("wdwCreate").close();
		this._selectBpEditorForm_();
	}
	
	/**
	 * On-Click handler for button btnCreateCancel
	 */
	,onBtnCreateCancel: function() {
		this._getWindow_("wdwCreate").close();
		this._getDc_("bp").doCancel();
	}
	
	,onUploadSuccess: function() {	
		this._getDc_("atch").doQuery();
	}
	
	,_whenCreateNewBp_: function() {	
		this._getWindow_("wdwCreate").show();
	}
	
	,onBtnUploadAttachment: function() {
		var w=new dnet.core.base.FileUploadWindow({
		    		_nameFieldValue_: this._getDc_("atch").getRecord().get("name"),
		    		_p1Value_: this._getDc_("atch").getRecord().get("id"),
		    		_uploadUrl_:"/nan21.dnet.core.web/upload/adDataAttachment",
		    		_succesCallbackFn_ : this.onUploadSuccess,
		    		_succesCallbackScope_: this
		    	});w.show();
	}
	
	,_afterDefineDcs_: function() {
		this._getDc_("bp").on("afterDoNew", this._whenCreateNewBp_, this);
	}
	
	,_selectBpEditorForm_: function() {
		this._getElement_("bpEdit").onRecordChange();
	}
	
	,onBtnViewAttachment: function() {
		
				var url = this._getDc_("atch").getRecord().get("url");
				window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
});
