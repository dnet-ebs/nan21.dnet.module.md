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

@Ds(entity = Org.class, jpqlWhere = " e.type.warehouse = true ", sort = {@SortField(field = OrgWarehouseLov_Ds.f_code)})
public class OrgWarehouseLov_Ds extends AbstractTypeWithCodeLov<Org> {

	public static final String f_warehouse = "warehouse";

	@DsField(join = "left", path = "type.warehouse")
	private Boolean warehouse;

	public OrgWarehouseLov_Ds() {
		super();
	}

	public OrgWarehouseLov_Ds(Org e) {
		super(e);
	}

	public Boolean getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Boolean warehouse) {
		this.warehouse = warehouse;
	}
}
