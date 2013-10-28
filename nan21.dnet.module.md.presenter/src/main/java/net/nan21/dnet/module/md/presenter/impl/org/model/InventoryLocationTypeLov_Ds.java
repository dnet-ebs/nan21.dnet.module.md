/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocationType;

@Ds(entity = InventoryLocationType.class, sort = {@SortField(field = InventoryLocationTypeLov_Ds.f_code)})
public class InventoryLocationTypeLov_Ds
		extends
			AbstractTypeWithCodeLov<InventoryLocationType> {

	public InventoryLocationTypeLov_Ds() {
		super();
	}

	public InventoryLocationTypeLov_Ds(InventoryLocationType e) {
		super(e);
	}
}
