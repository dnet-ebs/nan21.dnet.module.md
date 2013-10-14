/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocationType;

@Ds(entity = InventoryLocationType.class, sort = {@SortField(field = InventoryLocationType_Ds.f_name)})
public class InventoryLocationType_Ds
		extends
			AbstractTypeDs<InventoryLocationType> {

	public InventoryLocationType_Ds() {
		super();
	}

	public InventoryLocationType_Ds(InventoryLocationType e) {
		super(e);
	}
}
