/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.md.domain.impl.base.TaxCategory;

@Ds(entity = TaxCategory.class, sort = {@SortField(field = TaxCategory_Ds.f_name)})
public class TaxCategory_Ds extends AbstractTypeDs<TaxCategory> {

	public TaxCategory_Ds() {
		super();
	}

	public TaxCategory_Ds(TaxCategory e) {
		super(e);
	}
}
