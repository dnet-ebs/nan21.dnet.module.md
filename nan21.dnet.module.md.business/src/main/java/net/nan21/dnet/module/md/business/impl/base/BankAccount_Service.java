/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.base;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.md.domain.impl.base.Bank;
import net.nan21.dnet.module.md.domain.impl.base.BankAccount;
import net.nan21.dnet.module.md.domain.impl.base.BankBranch;

/**
 * Repository functionality for {@link BankAccount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BankAccount_Service extends AbstractEntityService<BankAccount> {

	public BankAccount_Service() {
		super();
	}

	public BankAccount_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BankAccount> getEntityClass() {
		return BankAccount.class;
	}
	/**
	 * Find by unique key
	 */
	public BankAccount findByName(String name) {
		return (BankAccount) this
				.getEntityManager()
				.createNamedQuery(BankAccount.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public BankAccount findByAccount(Bank bank, String accountNo) {
		return (BankAccount) this
				.getEntityManager()
				.createNamedQuery(BankAccount.NQ_FIND_BY_ACCOUNT)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bank", bank)
				.setParameter("accountNo", accountNo).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public BankAccount findByAccount(Long bankId, String accountNo) {
		return (BankAccount) this
				.getEntityManager()
				.createNamedQuery(BankAccount.NQ_FIND_BY_ACCOUNT_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bankId", bankId)
				.setParameter("accountNo", accountNo).getSingleResult();
	}
	/**
	 * Find by reference: bank
	 */
	public List<BankAccount> findByBank(Bank bank) {
		return this.findByBankId(bank.getId());
	}
	/**
	 * Find by ID of reference: bank.id
	 */
	public List<BankAccount> findByBankId(String bankId) {
		return (List<BankAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BankAccount e where e.clientId = :clientId and e.bank.id = :bankId",
						BankAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bankId", bankId).getResultList();
	}
	/**
	 * Find by reference: bankBranch
	 */
	public List<BankAccount> findByBankBranch(BankBranch bankBranch) {
		return this.findByBankBranchId(bankBranch.getId());
	}
	/**
	 * Find by ID of reference: bankBranch.id
	 */
	public List<BankAccount> findByBankBranchId(String bankBranchId) {
		return (List<BankAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BankAccount e where e.clientId = :clientId and e.bankBranch.id = :bankBranchId",
						BankAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bankBranchId", bankBranchId).getResultList();
	}
	/**
	 * Find by reference: currency
	 */
	public List<BankAccount> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}
	/**
	 * Find by ID of reference: currency.id
	 */
	public List<BankAccount> findByCurrencyId(String currencyId) {
		return (List<BankAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BankAccount e where e.clientId = :clientId and e.currency.id = :currencyId",
						BankAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("currencyId", currencyId).getResultList();
	}
}
