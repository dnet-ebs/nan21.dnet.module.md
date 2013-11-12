/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.md.domain.impl.base.BankAccount;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccount;
import net.nan21.dnet.module.md.domain.impl.org.Org;

/**
 * Interface to expose business functions specific for {@link FinancialAccount} domain
 * entity.
 */
public interface IFinancialAccountService
		extends
			IEntityService<FinancialAccount> {

	/**
	 * Find by unique key
	 */
	public FinancialAccount findByCode(Org company, String code);

	/**
	 * Find by unique key
	 */
	public FinancialAccount findByCode(Long companyId, String code);

	/**
	 * Find by reference: company
	 */
	public List<FinancialAccount> findByCompany(Org company);

	/**
	 * Find by ID of reference: company.id
	 */
	public List<FinancialAccount> findByCompanyId(String companyId);

	/**
	 * Find by reference: currency
	 */
	public List<FinancialAccount> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<FinancialAccount> findByCurrencyId(String currencyId);

	/**
	 * Find by reference: bankAccount
	 */
	public List<FinancialAccount> findByBankAccount(BankAccount bankAccount);

	/**
	 * Find by ID of reference: bankAccount.id
	 */
	public List<FinancialAccount> findByBankAccountId(String bankAccountId);
}
