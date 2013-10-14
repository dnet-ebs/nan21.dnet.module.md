/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.org.OrgType;

@Ds(entity = OrgType.class, sort = {@SortField(field = OrgTypeLov_Ds.f_code)})
public class OrgTypeLov_Ds extends AbstractTypeWithCodeLov<OrgType> {

	public OrgTypeLov_Ds() {
		super();
	}

	public OrgTypeLov_Ds(OrgType e) {
		super(e);
	}
}
