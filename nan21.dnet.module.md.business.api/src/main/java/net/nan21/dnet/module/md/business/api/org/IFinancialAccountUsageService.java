/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccount;
import net.nan21.dnet.module.md.domain.impl.org.FinancialAccountUsage;

/**
 * Interface to expose business functions specific for {@link FinancialAccountUsage} domain
 * entity.
 */
public interface IFinancialAccountUsageService
		extends
			IEntityService<FinancialAccountUsage> {

	/**
	 * Find by unique key
	 */
	public FinancialAccountUsage findByUsage(FinancialAccount financialAccount,
			DocType paymentDocType);

	/**
	 * Find by unique key
	 */
	public FinancialAccountUsage findByUsage(Long financialAccountId,
			Long paymentDocTypeId);

	/**
	 * Find by reference: financialAccount
	 */
	public List<FinancialAccountUsage> findByFinancialAccount(
			FinancialAccount financialAccount);

	/**
	 * Find by ID of reference: financialAccount.id
	 */
	public List<FinancialAccountUsage> findByFinancialAccountId(
			String financialAccountId);

	/**
	 * Find by reference: paymentDocType
	 */
	public List<FinancialAccountUsage> findByPaymentDocType(
			DocType paymentDocType);

	/**
	 * Find by ID of reference: paymentDocType.id
	 */
	public List<FinancialAccountUsage> findByPaymentDocTypeId(
			String paymentDocTypeId);
}
