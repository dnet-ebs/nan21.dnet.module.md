/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.md.domain.impl.base.BankAccount;

@Ds(entity = BankAccount.class, sort = {@SortField(field = BankAccountLov_Ds.f_name)})
public class BankAccountLov_Ds extends AbstractTypeLov<BankAccount> {

	public BankAccountLov_Ds() {
		super();
	}

	public BankAccountLov_Ds(BankAccount e) {
		super(e);
	}
}
