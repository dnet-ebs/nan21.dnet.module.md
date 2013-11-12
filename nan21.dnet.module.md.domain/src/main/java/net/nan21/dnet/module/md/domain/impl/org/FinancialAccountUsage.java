/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.org;

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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccount;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Payment documents allowed to be used with a financial account 
 */
@NamedQueries({
		@NamedQuery(name = FinancialAccountUsage.NQ_FIND_BY_USAGE, query = "SELECT e FROM FinancialAccountUsage e WHERE e.clientId = :clientId and e.financialAccount = :financialAccount and e.paymentDocType = :paymentDocType", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = FinancialAccountUsage.NQ_FIND_BY_USAGE_PRIMITIVE, query = "SELECT e FROM FinancialAccountUsage e WHERE e.clientId = :clientId and e.financialAccount.id = :financialAccountId and e.paymentDocType.id = :paymentDocTypeId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = FinancialAccountUsage.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = FinancialAccountUsage.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "FINANCIALACCOUNT_ID",
		"PAYMENTDOCTYPE_ID"})})
public class FinancialAccountUsage extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_FINACNT_USE";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Usage.
	 */
	public static final String NQ_FIND_BY_USAGE = "FinancialAccountUsage.findByUsage";
	/**
	 * Named query find by unique key: Usage using the ID field for references.
	 */
	public static final String NQ_FIND_BY_USAGE_PRIMITIVE = "FinancialAccountUsage.findByUsage_PRIMITIVE";

	@NotNull
	@Column(name = "ALLOWPAYIN", nullable = false)
	private Boolean allowPayIn;

	@NotNull
	@Column(name = "ALLOWPAYOUT", nullable = false)
	private Boolean allowPayOut;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = FinancialAccount.class)
	@JoinColumn(name = "FINANCIALACCOUNT_ID", referencedColumnName = "ID")
	private FinancialAccount financialAccount;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DocType.class)
	@JoinColumn(name = "PAYMENTDOCTYPE_ID", referencedColumnName = "ID")
	private DocType paymentDocType;

	public Boolean getAllowPayIn() {
		return this.allowPayIn;
	}

	public void setAllowPayIn(Boolean allowPayIn) {
		this.allowPayIn = allowPayIn;
	}

	public Boolean getAllowPayOut() {
		return this.allowPayOut;
	}

	public void setAllowPayOut(Boolean allowPayOut) {
		this.allowPayOut = allowPayOut;
	}

	public FinancialAccount getFinancialAccount() {
		return this.financialAccount;
	}

	public void setFinancialAccount(FinancialAccount financialAccount) {
		if (financialAccount != null) {
			this.__validate_client_context__(financialAccount.getClientId());
		}
		this.financialAccount = financialAccount;
	}

	public DocType getPaymentDocType() {
		return this.paymentDocType;
	}

	public void setPaymentDocType(DocType paymentDocType) {
		if (paymentDocType != null) {
			this.__validate_client_context__(paymentDocType.getClientId());
		}
		this.paymentDocType = paymentDocType;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.allowPayIn == null) {
			this.allowPayIn = new Boolean(false);
		}
		if (this.allowPayOut == null) {
			this.allowPayOut = new Boolean(false);
		}
	}
}
