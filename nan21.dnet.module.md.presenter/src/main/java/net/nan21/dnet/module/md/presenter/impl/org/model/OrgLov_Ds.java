/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.org.Org;

@Ds(entity = Org.class, sort = {@SortField(field = OrgLov_Ds.f_code)})
public class OrgLov_Ds extends AbstractTypeWithCodeLov<Org> {

	public OrgLov_Ds() {
		super();
	}

	public OrgLov_Ds(Org e) {
		super(e);
	}
}
