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

@Ds(entity = Org.class, jpqlWhere = " e.type.carrier = true ", sort = {@SortField(field = OrgCarrierLov_Ds.f_code)})
public class OrgCarrierLov_Ds extends AbstractTypeWithCodeLov<Org> {

	public static final String f_carrier = "carrier";

	@DsField(join = "left", path = "type.carrier")
	private Boolean carrier;

	public OrgCarrierLov_Ds() {
		super();
	}

	public OrgCarrierLov_Ds(Org e) {
		super(e);
	}

	public Boolean getCarrier() {
		return this.carrier;
	}

	public void setCarrier(Boolean carrier) {
		this.carrier = carrier;
	}
}
