/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.md.domain.impl.org.Inventory;

@Ds(entity = Inventory.class, sort = {@SortField(field = InventoryLov_Ds.f_name)})
public class InventoryLov_Ds extends AbstractTypeLov<Inventory> {

	public static final String f_orgId = "orgId";

	@DsField(join = "left", path = "org.id")
	private String orgId;

	public InventoryLov_Ds() {
		super();
	}

	public InventoryLov_Ds(Inventory e) {
		super(e);
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}
