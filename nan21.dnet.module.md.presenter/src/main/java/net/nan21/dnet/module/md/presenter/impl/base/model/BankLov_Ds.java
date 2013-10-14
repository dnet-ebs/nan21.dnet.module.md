/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.base.Bank;

@Ds(entity = Bank.class, sort = {@SortField(field = BankLov_Ds.f_code)})
public class BankLov_Ds extends AbstractTypeWithCodeLov<Bank> {

	public BankLov_Ds() {
		super();
	}

	public BankLov_Ds(Bank e) {
		super(e);
	}
}
