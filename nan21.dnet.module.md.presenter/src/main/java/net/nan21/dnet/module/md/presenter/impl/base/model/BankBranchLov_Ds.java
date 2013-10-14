/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.base.BankBranch;

@Ds(entity = BankBranch.class, sort = {@SortField(field = BankBranchLov_Ds.f_code)})
public class BankBranchLov_Ds extends AbstractTypeWithCodeLov<BankBranch> {

	public static final String f_bankId = "bankId";
	public static final String f_bankCode = "bankCode";

	@DsField(join = "left", path = "bank.id")
	private String bankId;

	@DsField(join = "left", path = "bank.code")
	private String bankCode;

	public BankBranchLov_Ds() {
		super();
	}

	public BankBranchLov_Ds(BankBranch e) {
		super(e);
	}

	public String getBankId() {
		return this.bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
}
