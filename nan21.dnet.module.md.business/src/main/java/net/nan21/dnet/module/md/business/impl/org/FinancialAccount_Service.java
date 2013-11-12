/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.org;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.domain.impl.currency.Currency;
import net.nan21.dnet.module.md.business.api.org.IFinancialAccountService;
import net.nan21.dnet.module.md.domain.impl.base.BankAccount;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccount;
import net.nan21.dnet.module.md.domain.impl.org.Org;

/**
 * Repository functionality for {@link FinancialAccount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FinancialAccount_Service
		extends
			AbstractEntityService<FinancialAccount>
		implements
			IFinancialAccountService {

	public FinancialAccount_Service() {
		super();
	}

	public FinancialAccount_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<FinancialAccount> getEntityClass() {
		return FinancialAccount.class;
	}
	/**
	 * Find by unique key
	 */
	public FinancialAccount findByCode(Org company, String code) {
		return (FinancialAccount) this
				.getEntityManager()
				.createNamedQuery(FinancialAccount.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("company", company).setParameter("code", code)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public FinancialAccount findByCode(Long companyId, String code) {
		return (FinancialAccount) this
				.getEntityManager()
				.createNamedQuery(FinancialAccount.NQ_FIND_BY_CODE_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("companyId", companyId)
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by reference: company
	 */
	public List<FinancialAccount> findByCompany(Org company) {
		return this.findByCompanyId(company.getId());
	}
	/**
	 * Find by ID of reference: company.id
	 */
	public List<FinancialAccount> findByCompanyId(String companyId) {
		return (List<FinancialAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from FinancialAccount e where e.clientId = :clientId and e.company.id = :companyId",
						FinancialAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("companyId", companyId).getResultList();
	}
	/**
	 * Find by reference: currency
	 */
	public List<FinancialAccount> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}
	/**
	 * Find by ID of reference: currency.id
	 */
	public List<FinancialAccount> findByCurrencyId(String currencyId) {
		return (List<FinancialAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from FinancialAccount e where e.clientId = :clientId and e.currency.id = :currencyId",
						FinancialAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("currencyId", currencyId).getResultList();
	}
	/**
	 * Find by reference: bankAccount
	 */
	public List<FinancialAccount> findByBankAccount(BankAccount bankAccount) {
		return this.findByBankAccountId(bankAccount.getId());
	}
	/**
	 * Find by ID of reference: bankAccount.id
	 */
	public List<FinancialAccount> findByBankAccountId(String bankAccountId) {
		return (List<FinancialAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from FinancialAccount e where e.clientId = :clientId and e.bankAccount.id = :bankAccountId",
						FinancialAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bankAccountId", bankAccountId).getResultList();
	}
}
