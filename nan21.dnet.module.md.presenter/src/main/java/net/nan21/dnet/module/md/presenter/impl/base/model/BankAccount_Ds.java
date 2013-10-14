/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.md.domain.impl.base.Bank;
import net.nan21.dnet.module.md.domain.impl.base.BankAccount;
import net.nan21.dnet.module.md.domain.impl.base.BankBranch;

@Ds(entity = BankAccount.class, sort = {@SortField(field = BankAccount_Ds.f_name)})
@RefLookups({
		@RefLookup(refId = BankAccount_Ds.f_currencyId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = BankAccount_Ds.f_currency)}),
		@RefLookup(refId = BankAccount_Ds.f_bankId, namedQuery = Bank.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = BankAccount_Ds.f_bank)}),
		@RefLookup(refId = BankAccount_Ds.f_bankBranchId, namedQuery = BankBranch.NQ_FIND_BY_CODE_PRIMITIVE, params = {
				@Param(name = "bankId", field = BankAccount_Ds.f_bankId),
				@Param(name = "code", field = BankAccount_Ds.f_bankBranch)})})
public class BankAccount_Ds extends AbstractTypeDs<BankAccount> {

	public static final String f_accountNo = "accountNo";
	public static final String f_ibanAccount = "ibanAccount";
	public static final String f_targetRefid = "targetRefid";
	public static final String f_bankId = "bankId";
	public static final String f_bank = "bank";
	public static final String f_bankName = "bankName";
	public static final String f_bankBranchId = "bankBranchId";
	public static final String f_bankBranch = "bankBranch";
	public static final String f_bankBranchName = "bankBranchName";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";

	@DsField
	private String accountNo;

	@DsField
	private Boolean ibanAccount;

	@DsField
	private String targetRefid;

	@DsField(join = "left", path = "bank.id")
	private String bankId;

	@DsField(join = "left", path = "bank.code")
	private String bank;

	@DsField(join = "left", path = "bank.name")
	private String bankName;

	@DsField(join = "left", path = "bankBranch.id")
	private String bankBranchId;

	@DsField(join = "left", path = "bankBranch.code")
	private String bankBranch;

	@DsField(join = "left", path = "bankBranch.name")
	private String bankBranchName;

	@DsField(join = "left", path = "currency.id")
	private String currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	public BankAccount_Ds() {
		super();
	}

	public BankAccount_Ds(BankAccount e) {
		super(e);
	}

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

	public String getBankId() {
		return this.bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranchId() {
		return this.bankBranchId;
	}

	public void setBankBranchId(String bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	public String getBankBranch() {
		return this.bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getBankBranchName() {
		return this.bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	public String getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
