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
import net.nan21.dnet.module.md.domain.impl.base.Calendar;
import net.nan21.dnet.module.md.domain.impl.base.FiscalYear;

/**
 * Repository functionality for {@link FiscalYear} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FiscalYear_Service extends AbstractEntityService<FiscalYear> {

	public FiscalYear_Service() {
		super();
	}

	public FiscalYear_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<FiscalYear> getEntityClass() {
		return FiscalYear.class;
	}
	/**
	 * Find by unique key
	 */
	public FiscalYear findByName(String name) {
		return (FiscalYear) this
				.getEntityManager()
				.createNamedQuery(FiscalYear.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: calendar
	 */
	public List<FiscalYear> findByCalendar(Calendar calendar) {
		return this.findByCalendarId(calendar.getId());
	}
	/**
	 * Find by ID of reference: calendar.id
	 */
	public List<FiscalYear> findByCalendarId(String calendarId) {
		return (List<FiscalYear>) this
				.getEntityManager()
				.createQuery(
						"select e from FiscalYear e where e.clientId = :clientId and e.calendar.id = :calendarId",
						FiscalYear.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("calendarId", calendarId).getResultList();
	}
}
