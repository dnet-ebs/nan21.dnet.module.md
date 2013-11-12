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
import net.nan21.dnet.module.md.business.api.org.IFinancialAccountUsageService;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccount;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccountUsage;

/**
 * Repository functionality for {@link FinancialAccountUsage} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FinancialAccountUsage_Service
		extends
			AbstractEntityService<FinancialAccountUsage>
		implements
			IFinancialAccountUsageService {

	public FinancialAccountUsage_Service() {
		super();
	}

	public FinancialAccountUsage_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<FinancialAccountUsage> getEntityClass() {
		return FinancialAccountUsage.class;
	}
	/**
	 * Find by unique key
	 */
	public FinancialAccountUsage findByUsage(FinancialAccount financialAccount,
			DocType paymentDocType) {
		return (FinancialAccountUsage) this
				.getEntityManager()
				.createNamedQuery(FinancialAccountUsage.NQ_FIND_BY_USAGE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("financialAccount", financialAccount)
				.setParameter("paymentDocType", paymentDocType)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public FinancialAccountUsage findByUsage(Long financialAccountId,
			Long paymentDocTypeId) {
		return (FinancialAccountUsage) this
				.getEntityManager()
				.createNamedQuery(
						FinancialAccountUsage.NQ_FIND_BY_USAGE_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("financialAccountId", financialAccountId)
				.setParameter("paymentDocTypeId", paymentDocTypeId)
				.getSingleResult();
	}
	/**
	 * Find by reference: financialAccount
	 */
	public List<FinancialAccountUsage> findByFinancialAccount(
			FinancialAccount financialAccount) {
		return this.findByFinancialAccountId(financialAccount.getId());
	}
	/**
	 * Find by ID of reference: financialAccount.id
	 */
	public List<FinancialAccountUsage> findByFinancialAccountId(
			String financialAccountId) {
		return (List<FinancialAccountUsage>) this
				.getEntityManager()
				.createQuery(
						"select e from FinancialAccountUsage e where e.clientId = :clientId and e.financialAccount.id = :financialAccountId",
						FinancialAccountUsage.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("financialAccountId", financialAccountId)
				.getResultList();
	}
	/**
	 * Find by reference: paymentDocType
	 */
	public List<FinancialAccountUsage> findByPaymentDocType(
			DocType paymentDocType) {
		return this.findByPaymentDocTypeId(paymentDocType.getId());
	}
	/**
	 * Find by ID of reference: paymentDocType.id
	 */
	public List<FinancialAccountUsage> findByPaymentDocTypeId(
			String paymentDocTypeId) {
		return (List<FinancialAccountUsage>) this
				.getEntityManager()
				.createQuery(
						"select e from FinancialAccountUsage e where e.clientId = :clientId and e.paymentDocType.id = :paymentDocTypeId",
						FinancialAccountUsage.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("paymentDocTypeId", paymentDocTypeId)
				.getResultList();
	}
}
