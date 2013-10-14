/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.md.domain.impl.bp.BpContactPosition;

@Ds(entity = BpContactPosition.class, sort = {@SortField(field = BpContactPositionLov_Ds.f_name)})
public class BpContactPositionLov_Ds extends AbstractTypeLov<BpContactPosition> {

	public BpContactPositionLov_Ds() {
		super();
	}

	public BpContactPositionLov_Ds(BpContactPosition e) {
		super(e);
	}
}
