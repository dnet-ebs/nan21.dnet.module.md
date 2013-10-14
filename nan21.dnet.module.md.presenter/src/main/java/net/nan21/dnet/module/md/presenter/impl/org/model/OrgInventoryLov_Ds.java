/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.org.Org;

@Ds(entity = Org.class, jpqlWhere = " e.type.inventory = true ", sort = {@SortField(field = OrgInventoryLov_Ds.f_code)})
public class OrgInventoryLov_Ds extends AbstractTypeWithCodeLov<Org> {

	public static final String f_inventory = "inventory";

	@DsField(join = "left", path = "type.inventory")
	private Boolean inventory;

	public OrgInventoryLov_Ds() {
		super();
	}

	public OrgInventoryLov_Ds(Org e) {
		super(e);
	}

	public Boolean getInventory() {
		return this.inventory;
	}

	public void setInventory(Boolean inventory) {
		this.inventory = inventory;
	}
}
