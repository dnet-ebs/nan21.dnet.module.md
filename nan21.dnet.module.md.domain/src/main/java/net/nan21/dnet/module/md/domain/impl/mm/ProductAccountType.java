/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.mm;

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
 * Product account groups.
 */
@NamedQueries({
		@NamedQuery(name = ProductAccountType.NQ_FIND_BY_CODE, query = "SELECT e FROM ProductAccountType e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ProductAccountType.NQ_FIND_BY_NAME, query = "SELECT e FROM ProductAccountType e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ProductAccountType.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = ProductAccountType.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = ProductAccountType.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class ProductAccountType extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_PROD_ACNT_TYPE";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "ProductAccountType.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "ProductAccountType.findByName";

	@NotNull
	@Column(name = "SALE", nullable = false)
	private Boolean sale;

	@NotNull
	@Column(name = "PURCHASE", nullable = false)
	private Boolean purchase;

	@NotNull
	@Column(name = "INVENTORY", nullable = false)
	private Boolean inventory;

	public Boolean getSale() {
		return this.sale;
	}

	public void setSale(Boolean sale) {
		this.sale = sale;
	}

	public Boolean getPurchase() {
		return this.purchase;
	}

	public void setPurchase(Boolean purchase) {
		this.purchase = purchase;
	}

	public Boolean getInventory() {
		return this.inventory;
	}

	public void setInventory(Boolean inventory) {
		this.inventory = inventory;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.sale == null) {
			this.sale = new Boolean(false);
		}
		if (this.purchase == null) {
			this.purchase = new Boolean(false);
		}
		if (this.inventory == null) {
			this.inventory = new Boolean(false);
		}
	}
}
