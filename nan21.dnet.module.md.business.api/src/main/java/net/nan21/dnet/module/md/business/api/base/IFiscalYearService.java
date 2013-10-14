/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.base;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.base.Calendar;
import net.nan21.dnet.module.md.domain.impl.base.FiscalYear;

/**
 * Interface to expose business functions specific for {@link FiscalYear} domain
 * entity.
 */
public interface IFiscalYearService extends IEntityService<FiscalYear> {

	public void doCreateMonths(FiscalYear year) throws BusinessException;

	public void doCreateQuarters(FiscalYear year) throws BusinessException;

	public void doCreateHalfYears(FiscalYear year) throws BusinessException;

	/**
	 * Find by unique key
	 */
	public FiscalYear findByName(String name);

	/**
	 * Find by reference: calendar
	 */
	public List<FiscalYear> findByCalendar(Calendar calendar);

	/**
	 * Find by ID of reference: calendar.id
	 */
	public List<FiscalYear> findByCalendarId(String calendarId);
}
