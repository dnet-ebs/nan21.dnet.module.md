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
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccount;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccountUsage;

@Ds(entity = FinancialAccountUsage.class)
@RefLookups({
		@RefLookup(refId = FinancialAccountUsage_Ds.f_financialAccountId, namedQuery = FinancialAccount.NQ_FIND_BY_CODE_PRIMITIVE, params = {@Param(name = "companyId", field = FinancialAccountUsage_Ds.f_financialAccount)}),
		@RefLookup(refId = FinancialAccountUsage_Ds.f_paymentDocTypeId, namedQuery = DocType.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = FinancialAccountUsage_Ds.f_paymentDocType)})})
public class FinancialAccountUsage_Ds
		extends
			AbstractAuditableDs<FinancialAccountUsage> {

	public static final String f_allowPayIn = "allowPayIn";
	public static final String f_allowPayOut = "allowPayOut";
	public static final String f_financialAccountId = "financialAccountId";
	public static final String f_financialAccount = "financialAccount";
	public static final String f_paymentDocTypeId = "paymentDocTypeId";
	public static final String f_paymentDocType = "paymentDocType";
	public static final String f_paymentDocTypeName = "paymentDocTypeName";

	@DsField
	private Boolean allowPayIn;

	@DsField
	private Boolean allowPayOut;

	@DsField(join = "left", path = "financialAccount.id")
	private String financialAccountId;

	@DsField(join = "left", path = "financialAccount.code")
	private String financialAccount;

	@DsField(join = "left", path = "paymentDocType.id")
	private String paymentDocTypeId;

	@DsField(join = "left", path = "paymentDocType.code")
	private String paymentDocType;

	@DsField(join = "left", path = "paymentDocType.name")
	private String paymentDocTypeName;

	public FinancialAccountUsage_Ds() {
		super();
	}

	public FinancialAccountUsage_Ds(FinancialAccountUsage e) {
		super(e);
	}

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

	public String getFinancialAccountId() {
		return this.financialAccountId;
	}

	public void setFinancialAccountId(String financialAccountId) {
		this.financialAccountId = financialAccountId;
	}

	public String getFinancialAccount() {
		return this.financialAccount;
	}

	public void setFinancialAccount(String financialAccount) {
		this.financialAccount = financialAccount;
	}

	public String getPaymentDocTypeId() {
		return this.paymentDocTypeId;
	}

	public void setPaymentDocTypeId(String paymentDocTypeId) {
		this.paymentDocTypeId = paymentDocTypeId;
	}

	public String getPaymentDocType() {
		return this.paymentDocType;
	}

	public void setPaymentDocType(String paymentDocType) {
		this.paymentDocType = paymentDocType;
	}

	public String getPaymentDocTypeName() {
		return this.paymentDocTypeName;
	}

	public void setPaymentDocTypeName(String paymentDocTypeName) {
		this.paymentDocTypeName = paymentDocTypeName;
	}
}
