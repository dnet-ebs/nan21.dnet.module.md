/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.md.domain.impl.base.Calendar;

@Ds(entity = Calendar.class, sort = {@SortField(field = Calendar_Ds.f_name)})
public class Calendar_Ds extends AbstractTypeDs<Calendar> {

	public Calendar_Ds() {
		super();
	}

	public Calendar_Ds(Calendar e) {
		super(e);
	}
}
