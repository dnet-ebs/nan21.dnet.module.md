/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.org;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Organization types definition.
 */
@NamedQueries({
		@NamedQuery(name = OrgType.NQ_FIND_BY_CODE, query = "SELECT e FROM OrgType e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = OrgType.NQ_FIND_BY_NAME, query = "SELECT e FROM OrgType e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = OrgType.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = OrgType.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = OrgType.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class OrgType extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_ORG_TYPE";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "OrgType.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "OrgType.findByName";

	@NotNull
	@Column(name = "LEGALENTITY", nullable = false)
	private Boolean legalEntity;

	@NotNull
	@Column(name = "ACCOUNTINGENABLED", nullable = false)
	private Boolean accountingEnabled;

	@NotNull
	@Column(name = "IS_EXTERNAL", nullable = false)
	private Boolean external;

	@NotNull
	@Column(name = "IS_INVENTORY", nullable = false)
	private Boolean inventory;

	@NotNull
	@Column(name = "IS_CARRIER", nullable = false)
	private Boolean carrier;

	@NotNull
	@Column(name = "IS_WAREHOUSE", nullable = false)
	private Boolean warehouse;

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

	public Boolean getExternal() {
		return this.external;
	}

	public void setExternal(Boolean external) {
		this.external = external;
	}

	public Boolean getInventory() {
		return this.inventory;
	}

	public void setInventory(Boolean inventory) {
		this.inventory = inventory;
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

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.legalEntity == null) {
			this.legalEntity = new Boolean(false);
		}
		if (this.accountingEnabled == null) {
			this.accountingEnabled = new Boolean(false);
		}
		if (this.external == null) {
			this.external = new Boolean(false);
		}
		if (this.inventory == null) {
			this.inventory = new Boolean(false);
		}
		if (this.carrier == null) {
			this.carrier = new Boolean(false);
		}
		if (this.warehouse == null) {
			this.warehouse = new Boolean(false);
		}
	}
}
