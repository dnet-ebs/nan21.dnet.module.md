/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.md.domain.impl.base.FiscalYear;

@Ds(entity = FiscalYear.class, sort = {@SortField(field = FiscalYearLov_Ds.f_name)})
public class FiscalYearLov_Ds extends AbstractTypeLov<FiscalYear> {

	public FiscalYearLov_Ds() {
		super();
	}

	public FiscalYearLov_Ds(FiscalYear e) {
		super(e);
	}
}
