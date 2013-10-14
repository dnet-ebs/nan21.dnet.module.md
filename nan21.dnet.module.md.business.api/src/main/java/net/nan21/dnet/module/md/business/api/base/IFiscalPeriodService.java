/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.base;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.base.FiscalPeriod;
import net.nan21.dnet.module.md.domain.impl.base.FiscalYear;

/**
 * Interface to expose business functions specific for {@link FiscalPeriod} domain
 * entity.
 */
public interface IFiscalPeriodService extends IEntityService<FiscalPeriod> {

	/**
	 * Find by unique key
	 */
	public FiscalPeriod findByName(String name);

	/**
	 * Find by reference: fiscalYear
	 */
	public List<FiscalPeriod> findByFiscalYear(FiscalYear fiscalYear);

	/**
	 * Find by ID of reference: fiscalYear.id
	 */
	public List<FiscalPeriod> findByFiscalYearId(String fiscalYearId);
}
