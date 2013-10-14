/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.md.domain.impl.bp.BpContactPosition;

@Ds(entity = BpContactPosition.class, sort = {@SortField(field = BpContactPosition_Ds.f_name)})
public class BpContactPosition_Ds extends AbstractTypeDs<BpContactPosition> {

	public BpContactPosition_Ds() {
		super();
	}

	public BpContactPosition_Ds(BpContactPosition e) {
		super(e);
	}
}
