package net.nan21.dnet.module.md.presenter.ext.base.delegate;

import net.nan21.dnet.core.presenter.service.AbstractPresenterDelegate;
import net.nan21.dnet.module.md.business.api.base.IFiscalYearService;
import net.nan21.dnet.module.md.domain.impl.base.FiscalYear;
import net.nan21.dnet.module.md.presenter.impl.base.model.FiscalYear_Ds;

public class FiscalPeriod_Pd extends AbstractPresenterDelegate {

	/**
	 * Create month periods for the given fiscal year.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void createMonths(FiscalYear_Ds ds) throws Exception {
		if (!this.canCreatePeriod("month", ds.getId())) {
			throw new Exception("There are already month periods defined for "
					+ ds.getName());
		}
		IFiscalYearService srv = (IFiscalYearService) this
				.findEntityService(FiscalYear.class);
		FiscalYear e = srv.findById(ds.getId());
		srv.doCreateMonths(e);
	}

	/**
	 * Create quarter periods for the given fiscal year.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void createQuarters(FiscalYear_Ds ds) throws Exception {
		if (!this.canCreatePeriod("quarter", ds.getId())) {
			throw new Exception(
					"There are already quarter periods defined for "
							+ ds.getName());
		}
		IFiscalYearService srv = (IFiscalYearService) this
				.findEntityService(FiscalYear.class);
		FiscalYear e = srv.findById(ds.getId());
		srv.doCreateQuarters(e);
	}

	/**
	 * Create half year periods for the given fiscal year.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void createHalfYears(FiscalYear_Ds ds) throws Exception {
		if (!this.canCreatePeriod("half-year", ds.getId())) {
			throw new Exception(
					"There are already half-year periods defined for "
							+ ds.getName());
		}
		IFiscalYearService srv = (IFiscalYearService) this
				.findEntityService(FiscalYear.class);
		FiscalYear e = srv.findById(ds.getId());
		srv.doCreateHalfYears(e);
	}

	/**
	 * 
	 * @param type
	 * @param yearId
	 * @return
	 */
	private boolean canCreatePeriod(String type, String yearId) {
		return true;
	}
}
