/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.domain.impl.base.Bank;

@Ds(entity = Bank.class, sort = {@SortField(field = Bank_Ds.f_code)})
public class Bank_Ds extends AbstractTypeWithCodeDs<Bank> {

	public static final String f_swiftCode = "swiftCode";

	@DsField
	private String swiftCode;

	public Bank_Ds() {
		super();
	}

	public Bank_Ds(Bank e) {
		super(e);
	}

	public String getSwiftCode() {
		return this.swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
}
