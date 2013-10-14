/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.domain.impl.org.Org;
import net.nan21.dnet.module.md.domain.impl.org.OrgType;

@Ds(entity = Org.class, sort = {@SortField(field = Org_Ds.f_code)})
@RefLookups({@RefLookup(refId = Org_Ds.f_typeId, namedQuery = OrgType.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = Org_Ds.f_type)})})
public class Org_Ds extends AbstractTypeWithCodeDs<Org> {

	public static final String f_valid = "valid";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";

	@DsField
	private Boolean valid;

	@DsField(join = "left", path = "type.id")
	private String typeId;

	@DsField(join = "left", path = "type.code")
	private String type;

	public Org_Ds() {
		super();
	}

	public Org_Ds(Org e) {
		super(e);
	}

	public Boolean getValid() {
		return this.valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
