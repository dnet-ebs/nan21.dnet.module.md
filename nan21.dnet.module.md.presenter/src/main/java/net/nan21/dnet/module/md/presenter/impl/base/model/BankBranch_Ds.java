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
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.domain.impl.base.Bank;
import net.nan21.dnet.module.md.domain.impl.base.BankBranch;

@Ds(entity = BankBranch.class, sort = {@SortField(field = BankBranch_Ds.f_code)})
@RefLookups({@RefLookup(refId = BankBranch_Ds.f_bankId, namedQuery = Bank.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = BankBranch_Ds.f_bank)})})
public class BankBranch_Ds extends AbstractTypeWithCodeDs<BankBranch> {

	public static final String f_bankId = "bankId";
	public static final String f_bank = "bank";
	public static final String f_bankName = "bankName";

	@DsField(join = "left", path = "bank.id")
	private String bankId;

	@DsField(join = "left", path = "bank.code")
	private String bank;

	@DsField(join = "left", path = "bank.name")
	private String bankName;

	public BankBranch_Ds() {
		super();
	}

	public BankBranch_Ds(BankBranch e) {
		super(e);
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
}
