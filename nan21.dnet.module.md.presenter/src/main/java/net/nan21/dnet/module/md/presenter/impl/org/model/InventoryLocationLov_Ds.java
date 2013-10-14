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
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocation;

@Ds(entity = InventoryLocation.class, sort = {@SortField(field = InventoryLocationLov_Ds.f_name)})
public class InventoryLocationLov_Ds extends AbstractTypeLov<InventoryLocation> {

	public static final String f_subInventoryId = "subInventoryId";

	@DsField(join = "left", path = "inventory.id")
	private String subInventoryId;

	public InventoryLocationLov_Ds() {
		super();
	}

	public InventoryLocationLov_Ds(InventoryLocation e) {
		super(e);
	}

	public String getSubInventoryId() {
		return this.subInventoryId;
	}

	public void setSubInventoryId(String subInventoryId) {
		this.subInventoryId = subInventoryId;
	}
}
