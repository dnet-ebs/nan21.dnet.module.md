/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.md.domain.impl.org.Inventory;
import net.nan21.dnet.module.md.domain.impl.org.Org;

@Ds(entity = Inventory.class, sort = {@SortField(field = Inventory_Ds.f_name)})
@RefLookups({@RefLookup(refId = Inventory_Ds.f_orgId, namedQuery = Org.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = Inventory_Ds.f_orgCode)})})
public class Inventory_Ds extends AbstractTypeDs<Inventory> {

	public static final String f_orgId = "orgId";
	public static final String f_orgCode = "orgCode";
	public static final String f_orgName = "orgName";

	@DsField(join = "left", path = "org.id")
	private String orgId;

	@DsField(join = "left", path = "org.code")
	private String orgCode;

	@DsField(join = "left", path = "org.name")
	private String orgName;

	public Inventory_Ds() {
		super();
	}

	public Inventory_Ds(Inventory e) {
		super(e);
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}
