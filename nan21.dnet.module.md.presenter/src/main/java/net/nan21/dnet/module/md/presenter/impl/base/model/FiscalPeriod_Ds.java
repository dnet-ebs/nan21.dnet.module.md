/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.md.domain.impl.base.FiscalPeriod;
import net.nan21.dnet.module.md.domain.impl.base.FiscalYear;

@Ds(entity = FiscalPeriod.class, sort = {@SortField(field = FiscalPeriod_Ds.f_startDate, desc = true)})
@RefLookups({@RefLookup(refId = FiscalPeriod_Ds.f_fiscalYearId, namedQuery = FiscalYear.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = FiscalPeriod_Ds.f_fiscalYear)})})
public class FiscalPeriod_Ds extends AbstractTypeDs<FiscalPeriod> {

	public static final String f_type = "type";
	public static final String f_startDate = "startDate";
	public static final String f_endDate = "endDate";
	public static final String f_posting = "posting";
	public static final String f_fiscalYearId = "fiscalYearId";
	public static final String f_fiscalYear = "fiscalYear";

	@DsField
	private String type;

	@DsField
	private Date startDate;

	@DsField
	private Date endDate;

	@DsField
	private Boolean posting;

	@DsField(join = "left", path = "fiscalYear.id")
	private String fiscalYearId;

	@DsField(join = "left", path = "fiscalYear.name")
	private String fiscalYear;

	public FiscalPeriod_Ds() {
		super();
	}

	public FiscalPeriod_Ds(FiscalPeriod e) {
		super(e);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Boolean getPosting() {
		return this.posting;
	}

	public void setPosting(Boolean posting) {
		this.posting = posting;
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
