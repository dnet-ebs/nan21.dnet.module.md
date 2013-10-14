/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.domain.impl.org.OrgType;

@Ds(entity = OrgType.class, sort = {@SortField(field = OrgType_Ds.f_code)})
public class OrgType_Ds extends AbstractTypeWithCodeDs<OrgType> {

	public static final String f_legalEntity = "legalEntity";
	public static final String f_accountingEnabled = "accountingEnabled";
	public static final String f_inventory = "inventory";
	public static final String f_external = "external";
	public static final String f_carrier = "carrier";
	public static final String f_warehouse = "warehouse";

	@DsField
	private Boolean legalEntity;

	@DsField
	private Boolean accountingEnabled;

	@DsField
	private Boolean inventory;

	@DsField
	private Boolean external;

	@DsField
	private Boolean carrier;

	@DsField
	private Boolean warehouse;

	public OrgType_Ds() {
		super();
	}

	public OrgType_Ds(OrgType e) {
		super(e);
	}

	public Boolean getLegalEntity() {
		return this.legalEntity;
	}

	public void setLegalEntity(Boolean legalEntity) {
		this.legalEntity = legalEntity;
	}

	public Boolean getAccountingEnabled() {
		return this.accountingEnabled;
	}

	public void setAccountingEnabled(Boolean accountingEnabled) {
		this.accountingEnabled = accountingEnabled;
	}

	public Boolean getInventory() {
		return this.inventory;
	}

	public void setInventory(Boolean inventory) {
		this.inventory = inventory;
	}

	public Boolean getExternal() {
		return this.external;
	}

	public void setExternal(Boolean external) {
		this.external = external;
	}

	public Boolean getCarrier() {
		return this.carrier;
	}

	public void setCarrier(Boolean carrier) {
		this.carrier = carrier;
	}

	public Boolean getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Boolean warehouse) {
		this.warehouse = warehouse;
	}
}
