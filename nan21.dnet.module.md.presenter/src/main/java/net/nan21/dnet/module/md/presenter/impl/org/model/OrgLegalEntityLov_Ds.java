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

@Ds(entity = Org.class, jpqlWhere = " e.type.legalEntity = true ", sort = {@SortField(field = OrgLegalEntityLov_Ds.f_code)})
public class OrgLegalEntityLov_Ds extends AbstractTypeWithCodeLov<Org> {

	public static final String f_legalEntity = "legalEntity";

	@DsField(join = "left", path = "type.legalEntity")
	private Boolean legalEntity;

	public OrgLegalEntityLov_Ds() {
		super();
	}

	public OrgLegalEntityLov_Ds(Org e) {
		super(e);
	}

	public Boolean getLegalEntity() {
		return this.legalEntity;
	}

	public void setLegalEntity(Boolean legalEntity) {
		this.legalEntity = legalEntity;
	}
}
