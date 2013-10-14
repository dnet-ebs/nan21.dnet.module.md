/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.org.Org;

@Ds(entity = Org.class, jpqlWhere = " e.type.external = true ", sort = {@SortField(field = OrgExternalLov_Ds.f_code)})
public class OrgExternalLov_Ds extends AbstractTypeWithCodeLov<Org> {

	public static final String f_external = "external";

	@DsField(join = "left", path = "type.external")
	private Boolean external;

	public OrgExternalLov_Ds() {
		super();
	}

	public OrgExternalLov_Ds(Org e) {
		super(e);
	}

	public Boolean getExternal() {
		return this.external;
	}

	public void setExternal(Boolean external) {
		this.external = external;
	}
}
