/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.md.domain.impl.base.TaxCategory;

@Ds(entity = TaxCategory.class, sort = {@SortField(field = TaxCategoryLov_Ds.f_name)})
public class TaxCategoryLov_Ds extends AbstractTypeLov<TaxCategory> {

	public TaxCategoryLov_Ds() {
		super();
	}

	public TaxCategoryLov_Ds(TaxCategory e) {
		super(e);
	}
}
