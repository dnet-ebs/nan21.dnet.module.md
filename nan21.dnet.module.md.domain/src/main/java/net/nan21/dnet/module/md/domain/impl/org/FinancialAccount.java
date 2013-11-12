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
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.md.domain.impl.base.BankAccount;
import net.nan21.dnet.module.md.domain.impl.org.Org;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Payment account. Can be a bank account or cash account for a legal entity organization
 */
@NamedQueries({
		@NamedQuery(name = FinancialAccount.NQ_FIND_BY_CODE, query = "SELECT e FROM FinancialAccount e WHERE e.clientId = :clientId and e.company = :company and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = FinancialAccount.NQ_FIND_BY_CODE_PRIMITIVE, query = "SELECT e FROM FinancialAccount e WHERE e.clientId = :clientId and e.company.id = :companyId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = FinancialAccount.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = FinancialAccount.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "COMPANY_ID", "CODE"})})
public class FinancialAccount extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_FINACNT";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "FinancialAccount.findByCode";
	/**
	 * Named query find by unique key: Code using the ID field for references.
	 */
	public static final String NQ_FIND_BY_CODE_PRIMITIVE = "FinancialAccount.findByCode_PRIMITIVE";

	/** Account type: bank or cash */
	@NotBlank
	@Column(name = "TYPE", nullable = false, length = 8)
	private String type;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Org.class)
	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
	private Org company;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
	private Currency currency;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BankAccount.class)
	@JoinColumn(name = "BANKACCOUNT_ID", referencedColumnName = "ID")
	private BankAccount bankAccount;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Org getCompany() {
		return this.company;
	}

	public void setCompany(Org company) {
		if (company != null) {
			this.__validate_client_context__(company.getClientId());
		}
		this.company = company;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		if (currency != null) {
			this.__validate_client_context__(currency.getClientId());
		}
		this.currency = currency;
	}

	public BankAccount getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		if (bankAccount != null) {
			this.__validate_client_context__(bankAccount.getClientId());
		}
		this.bankAccount = bankAccount;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
