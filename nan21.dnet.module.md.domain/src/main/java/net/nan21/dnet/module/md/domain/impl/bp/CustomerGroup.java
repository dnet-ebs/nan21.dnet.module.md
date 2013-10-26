/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.bp;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * 
 */
@NamedQueries({
		@NamedQuery(name = CustomerGroup.NQ_FIND_BY_CODE, query = "SELECT e FROM CustomerGroup e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = CustomerGroup.NQ_FIND_BY_NAME, query = "SELECT e FROM CustomerGroup e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = CustomerGroup.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = CustomerGroup.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = CustomerGroup.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class CustomerGroup extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_BP_CUSTGRP";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "CustomerGroup.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "CustomerGroup.findByName";

	@Column(name = "CREDITLIMIT", precision = 21, scale = 6)
	private BigDecimal creditLimit;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DocType.class)
	@JoinColumn(name = "PAYMENTMETHOD_ID", referencedColumnName = "ID")
	private DocType paymentMethod;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentTerm.class)
	@JoinColumn(name = "PAYMENTTERM_ID", referencedColumnName = "ID")
	private PaymentTerm paymentTerm;

	public BigDecimal getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public DocType getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(DocType paymentMethod) {
		if (paymentMethod != null) {
			this.__validate_client_context__(paymentMethod.getClientId());
		}
		this.paymentMethod = paymentMethod;
	}

	public PaymentTerm getPaymentTerm() {
		return this.paymentTerm;
	}

	public void setPaymentTerm(PaymentTerm paymentTerm) {
		if (paymentTerm != null) {
			this.__validate_client_context__(paymentTerm.getClientId());
		}
		this.paymentTerm = paymentTerm;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
