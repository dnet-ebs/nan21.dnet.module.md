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
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.md.domain.impl.base.BankAccount;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccount;
import net.nan21.dnet.module.md.domain.impl.org.Org;

@Ds(entity = FinancialAccount.class, sort = {@SortField(field = FinancialAccount_Ds.f_code)})
@RefLookups({
		@RefLookup(refId = FinancialAccount_Ds.f_currencyId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = FinancialAccount_Ds.f_currency)}),
		@RefLookup(refId = FinancialAccount_Ds.f_companyId, namedQuery = Org.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = FinancialAccount_Ds.f_company)}),
		@RefLookup(refId = FinancialAccount_Ds.f_bankAccountId, namedQuery = BankAccount.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = FinancialAccount_Ds.f_bankAccount)})})
public class FinancialAccount_Ds
		extends
			AbstractTypeWithCodeDs<FinancialAccount> {

	public static final String f_type = "type";
	public static final String f_companyId = "companyId";
	public static final String f_company = "company";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_bankAccountId = "bankAccountId";
	public static final String f_bankAccount = "bankAccount";

	@DsField(noUpdate = true)
	private String type;

	@DsField(join = "left", path = "company.id")
	private String companyId;

	@DsField(join = "left", path = "company.code")
	private String company;

	@DsField(join = "left", path = "currency.id")
	private String currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	@DsField(join = "left", path = "bankAccount.id")
	private String bankAccountId;

	@DsField(join = "left", path = "bankAccount.name")
	private String bankAccount;

	public FinancialAccount_Ds() {
		super();
	}

	public FinancialAccount_Ds(FinancialAccount e) {
		super(e);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getBankAccountId() {
		return this.bankAccountId;
	}

	public void setBankAccountId(String bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
}
