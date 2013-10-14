/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import java.math.BigDecimal;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.md.domain.impl.base.Tax;

@Ds(entity = Tax.class, jpqlWhere = " e.parentTax is null and e.active = true ", sort = {@SortField(field = TaxApplicableLov_Ds.f_name)})
public class TaxApplicableLov_Ds extends AbstractTypeLov<Tax> {

	public static final String f_rate = "rate";
	public static final String f_summary = "summary";

	@DsField
	private BigDecimal rate;

	@DsField
	private Boolean summary;

	public TaxApplicableLov_Ds() {
		super();
	}

	public TaxApplicableLov_Ds(Tax e) {
		super(e);
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Boolean getSummary() {
		return this.summary;
	}

	public void setSummary(Boolean summary) {
		this.summary = summary;
	}
}
