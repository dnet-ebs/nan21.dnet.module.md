/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.base;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.base.Bank;
import net.nan21.dnet.module.md.domain.impl.base.BankBranch;

/**
 * Interface to expose business functions specific for {@link BankBranch} domain
 * entity.
 */
public interface IBankBranchService extends IEntityService<BankBranch> {

	/**
	 * Find by unique key
	 */
	public BankBranch findByCode(Bank bank, String code);

	/**
	 * Find by unique key
	 */
	public BankBranch findByCode(Long bankId, String code);

	/**
	 * Find by unique key
	 */
	public BankBranch findByName(Bank bank, String name);

	/**
	 * Find by unique key
	 */
	public BankBranch findByName(Long bankId, String name);

	/**
	 * Find by reference: bank
	 */
	public List<BankBranch> findByBank(Bank bank);

	/**
	 * Find by ID of reference: bank.id
	 */
	public List<BankBranch> findByBankId(String bankId);
}
