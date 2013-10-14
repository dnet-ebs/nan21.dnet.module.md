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
import net.nan21.dnet.module.md.business.api.base.IFiscalPeriodService;
import net.nan21.dnet.module.md.domain.impl.base.FiscalPeriod;
import net.nan21.dnet.module.md.domain.impl.base.FiscalYear;

/**
 * Repository functionality for {@link FiscalPeriod} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FiscalPeriod_Service extends AbstractEntityService<FiscalPeriod>
		implements
			IFiscalPeriodService {

	public FiscalPeriod_Service() {
		super();
	}

	public FiscalPeriod_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<FiscalPeriod> getEntityClass() {
		return FiscalPeriod.class;
	}
	/**
	 * Find by unique key
	 */
	public FiscalPeriod findByName(String name) {
		return (FiscalPeriod) this
				.getEntityManager()
				.createNamedQuery(FiscalPeriod.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: fiscalYear
	 */
	public List<FiscalPeriod> findByFiscalYear(FiscalYear fiscalYear) {
		return this.findByFiscalYearId(fiscalYear.getId());
	}
	/**
	 * Find by ID of reference: fiscalYear.id
	 */
	public List<FiscalPeriod> findByFiscalYearId(String fiscalYearId) {
		return (List<FiscalPeriod>) this
				.getEntityManager()
				.createQuery(
						"select e from FiscalPeriod e where e.clientId = :clientId and e.fiscalYear.id = :fiscalYearId",
						FiscalPeriod.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("fiscalYearId", fiscalYearId).getResultList();
	}
}
