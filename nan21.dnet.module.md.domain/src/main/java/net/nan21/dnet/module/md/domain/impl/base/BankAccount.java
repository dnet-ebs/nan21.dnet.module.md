/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.base;

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
import net.nan21.dnet.core.domain.impl.AbstractType;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.md.domain.impl.base.Bank;
import net.nan21.dnet.module.md.domain.impl.base.BankBranch;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Bank account definitions. Bank accounts are loosely coupled to entities with refid.
 */
@NamedQueries({
		@NamedQuery(name = BankAccount.NQ_FIND_BY_NAME, query = "SELECT e FROM BankAccount e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = BankAccount.NQ_FIND_BY_ACCOUNT, query = "SELECT e FROM BankAccount e WHERE e.clientId = :clientId and e.bank = :bank and e.accountNo = :accountNo", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = BankAccount.NQ_FIND_BY_ACCOUNT_PRIMITIVE, query = "SELECT e FROM BankAccount e WHERE e.clientId = :clientId and e.bank.id = :bankId and e.accountNo = :accountNo", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = BankAccount.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = BankAccount.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "NAME"}),
		@UniqueConstraint(name = BankAccount.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "BANK_ID", "ACCOUNTNO"})})
public class BankAccount extends AbstractType {

	public static final String TABLE_NAME = "MD_BANK_ACNT";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "BankAccount.findByName";
	/**
	 * Named query find by unique key: Account.
	 */
	public static final String NQ_FIND_BY_ACCOUNT = "BankAccount.findByAccount";
	/**
	 * Named query find by unique key: Account using the ID field for references.
	 */
	public static final String NQ_FIND_BY_ACCOUNT_PRIMITIVE = "BankAccount.findByAccount_PRIMITIVE";

	/** Account number. */
	@NotBlank
	@Column(name = "ACCOUNTNO", nullable = false, length = 32)
	private String accountNo;

	/** Flag which indicates if the account number represents an IBAN account. */
	@NotNull
	@Column(name = "IBANACCOUNT", nullable = false)
	private Boolean ibanAccount;

	/** Reference used to link bank accounts to different entity types. */
	@NotBlank
	@Column(name = "TARGETREFID", nullable = false, length = 64)
	private String targetRefid;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Bank.class)
	@JoinColumn(name = "BANK_ID", referencedColumnName = "ID")
	private Bank bank;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BankBranch.class)
	@JoinColumn(name = "BANKBRANCH_ID", referencedColumnName = "ID")
	private BankBranch bankBranch;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Currency.class)
	@JoinColumn(name = "CURRENCY_ID", referencedColumnName = "ID")
	private Currency currency;

	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Boolean getIbanAccount() {
		return this.ibanAccount;
	}

	public void setIbanAccount(Boolean ibanAccount) {
		this.ibanAccount = ibanAccount;
	}

	public String getTargetRefid() {
		return this.targetRefid;
	}

	public void setTargetRefid(String targetRefid) {
		this.targetRefid = targetRefid;
	}

	public Bank getBank() {
		return this.bank;
	}

	public void setBank(Bank bank) {
		if (bank != null) {
			this.__validate_client_context__(bank.getClientId());
		}
		this.bank = bank;
	}

	public BankBranch getBankBranch() {
		return this.bankBranch;
	}

	public void setBankBranch(BankBranch bankBranch) {
		if (bankBranch != null) {
			this.__validate_client_context__(bankBranch.getClientId());
		}
		this.bankBranch = bankBranch;
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

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.ibanAccount == null) {
			this.ibanAccount = new Boolean(false);
		}
	}
}
