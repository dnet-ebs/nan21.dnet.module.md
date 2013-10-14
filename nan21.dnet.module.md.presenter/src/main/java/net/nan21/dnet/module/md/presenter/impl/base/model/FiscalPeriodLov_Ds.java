/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.md.domain.impl.base.FiscalPeriod;

@Ds(entity = FiscalPeriod.class, sort = {@SortField(field = FiscalPeriodLov_Ds.f_name)})
public class FiscalPeriodLov_Ds extends AbstractTypeLov<FiscalPeriod> {

	public static final String f_startDate = "startDate";
	public static final String f_endDate = "endDate";
	public static final String f_fiscalYearId = "fiscalYearId";
	public static final String f_fiscalYear = "fiscalYear";

	@DsField
	private Date startDate;

	@DsField
	private Date endDate;

	@DsField(join = "left", path = "fiscalYear.id")
	private String fiscalYearId;

	@DsField(join = "left", path = "fiscalYear.name")
	private String fiscalYear;

	public FiscalPeriodLov_Ds() {
		super();
	}

	public FiscalPeriodLov_Ds(FiscalPeriod e) {
		super(e);
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFiscalYearId() {
		return this.fiscalYearId;
	}

	public void setFiscalYearId(String fiscalYearId) {
		this.fiscalYearId = fiscalYearId;
	}

	public String getFiscalYear() {
		return this.fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
}
