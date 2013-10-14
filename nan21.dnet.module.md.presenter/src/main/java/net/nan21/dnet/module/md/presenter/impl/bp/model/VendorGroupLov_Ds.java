/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.bp.VendorGroup;

@Ds(entity = VendorGroup.class, sort = {@SortField(field = VendorGroupLov_Ds.f_code)})
public class VendorGroupLov_Ds extends AbstractTypeWithCodeLov<VendorGroup> {

	public VendorGroupLov_Ds() {
		super();
	}

	public VendorGroupLov_Ds(VendorGroup e) {
		super(e);
	}
}
