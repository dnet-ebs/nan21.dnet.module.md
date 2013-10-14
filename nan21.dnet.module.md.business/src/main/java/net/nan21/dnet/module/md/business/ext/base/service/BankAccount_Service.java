/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.ext.base.service;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.business.api.base.IBankAccountService;
import net.nan21.dnet.module.md.domain.impl.base.BankAccount;

/**
 * Business extensions specific for {@link BankAccount} domain entity.
 * 
 */
public class BankAccount_Service extends
		net.nan21.dnet.module.md.business.impl.base.BankAccount_Service
		implements IBankAccountService {

	@Override
	protected void preInsert(BankAccount e) throws BusinessException {
		this.beforeSave(e);
	}

	@Override
	protected void preUpdate(BankAccount e) throws BusinessException {
		this.beforeSave(e);
	}

	private void beforeSave(BankAccount e) {
		if (e.getIbanAccount()) {
			e.setName(e.getAccountNo());
		} else {
			e.setName(e.getBank().getCode() + "-" + e.getAccountNo());
		}
	}
}
