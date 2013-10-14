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
import net.nan21.dnet.module.md.business.api.base.IBankBranchService;
import net.nan21.dnet.module.md.domain.impl.base.Bank;
import net.nan21.dnet.module.md.domain.impl.base.BankBranch;

/**
 * Repository functionality for {@link BankBranch} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BankBranch_Service extends AbstractEntityService<BankBranch>
		implements
			IBankBranchService {

	public BankBranch_Service() {
		super();
	}

	public BankBranch_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BankBranch> getEntityClass() {
		return BankBranch.class;
	}
	/**
	 * Find by unique key
	 */
	public BankBranch findByCode(Bank bank, String code) {
		return (BankBranch) this
				.getEntityManager()
				.createNamedQuery(BankBranch.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bank", bank).setParameter("code", code)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public BankBranch findByCode(Long bankId, String code) {
		return (BankBranch) this
				.getEntityManager()
				.createNamedQuery(BankBranch.NQ_FIND_BY_CODE_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bankId", bankId).setParameter("code", code)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public BankBranch findByName(Bank bank, String name) {
		return (BankBranch) this
				.getEntityManager()
				.createNamedQuery(BankBranch.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bank", bank).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public BankBranch findByName(Long bankId, String name) {
		return (BankBranch) this
				.getEntityManager()
				.createNamedQuery(BankBranch.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bankId", bankId).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by reference: bank
	 */
	public List<BankBranch> findByBank(Bank bank) {
		return this.findByBankId(bank.getId());
	}
	/**
	 * Find by ID of reference: bank.id
	 */
	public List<BankBranch> findByBankId(String bankId) {
		return (List<BankBranch>) this
				.getEntityManager()
				.createQuery(
						"select e from BankBranch e where e.clientId = :clientId and e.bank.id = :bankId",
						BankBranch.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bankId", bankId).getResultList();
	}
}
