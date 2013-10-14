/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.md + "Calendar_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Calendar_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("calendar", Ext.create(Dnet.ns.md + "Calendar_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("calendar", {name:"calendarFilter", xtype:"md_Calendar_Dc$Filter"})
		.addDcEditGridView("calendar", {name:"calendarEditList", xtype:"md_Calendar_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["calendarFilter", "calendarEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbCalendarList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbCalendarList", {dc: "calendar"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});
