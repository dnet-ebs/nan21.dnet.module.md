/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.base;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.md.domain.impl.base.Bank;
import net.nan21.dnet.module.md.domain.impl.base.BankAccount;
import net.nan21.dnet.module.md.domain.impl.base.BankBranch;

/**
 * Interface to expose business functions specific for {@link BankAccount} domain
 * entity.
 */
public interface IBankAccountService extends IEntityService<BankAccount> {

	/**
	 * Find by unique key
	 */
	public BankAccount findByName(String name);

	/**
	 * Find by unique key
	 */
	public BankAccount findByAccount(Bank bank, String accountNo);

	/**
	 * Find by unique key
	 */
	public BankAccount findByAccount(Long bankId, String accountNo);

	/**
	 * Find by reference: bank
	 */
	public List<BankAccount> findByBank(Bank bank);

	/**
	 * Find by ID of reference: bank.id
	 */
	public List<BankAccount> findByBankId(String bankId);

	/**
	 * Find by reference: bankBranch
	 */
	public List<BankAccount> findByBankBranch(BankBranch bankBranch);

	/**
	 * Find by ID of reference: bankBranch.id
	 */
	public List<BankAccount> findByBankBranchId(String bankBranchId);

	/**
	 * Find by reference: currency
	 */
	public List<BankAccount> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<BankAccount> findByCurrencyId(String currencyId);
}
