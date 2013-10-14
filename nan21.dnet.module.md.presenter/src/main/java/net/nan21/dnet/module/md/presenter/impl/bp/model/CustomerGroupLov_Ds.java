/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.bp.CustomerGroup;

@Ds(entity = CustomerGroup.class, sort = {@SortField(field = CustomerGroupLov_Ds.f_code)})
public class CustomerGroupLov_Ds extends AbstractTypeWithCodeLov<CustomerGroup> {

	public CustomerGroupLov_Ds() {
		super();
	}

	public CustomerGroupLov_Ds(CustomerGroup e) {
		super(e);
	}
}
