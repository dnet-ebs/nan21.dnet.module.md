/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.ext.base.service;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.business.api.base.IFiscalYearService;
import net.nan21.dnet.module.md.business.ext.base.delegate.FiscalYear_Bd;
import net.nan21.dnet.module.md.domain.impl.base.FiscalYear;

/**
 * Business extensions specific for {@link FiscalYear} domain entity.
 * 
 */
public class FiscalYear_Service extends
		net.nan21.dnet.module.md.business.impl.base.FiscalYear_Service
		implements IFiscalYearService {

	@Override
	public void doCreateMonths(FiscalYear year) throws BusinessException {
		this.getBusinessDelegate(FiscalYear_Bd.class).createMonths(year);

	}

	@Override
	public void doCreateQuarters(FiscalYear year) throws BusinessException {
		this.getBusinessDelegate(FiscalYear_Bd.class).createQuarters(year);
	}

	@Override
	public void doCreateHalfYears(FiscalYear year) throws BusinessException {
		this.getBusinessDelegate(FiscalYear_Bd.class).createHalfYears(year);
	}

}
