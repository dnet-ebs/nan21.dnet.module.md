/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccount;

@Ds(entity = FinancialAccount.class, sort = {@SortField(field = FinancialAccountLov_Ds.f_code)})
public class FinancialAccountLov_Ds
		extends
			AbstractTypeWithCodeLov<FinancialAccount> {

	public static final String f_type = "type";
	public static final String f_companyId = "companyId";
	public static final String f_company = "company";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";

	@DsField
	private String type;

	@DsField(join = "left", path = "company.id")
	private String companyId;

	@DsField(join = "left", path = "company.code")
	private String company;

	@DsField(join = "left", path = "currency.id")
	private String currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	public FinancialAccountLov_Ds() {
		super();
	}

	public FinancialAccountLov_Ds(FinancialAccount e) {
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
}
