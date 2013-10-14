/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;

@Ds(entity = BusinessPartner.class, sort = {@SortField(field = BusinessPartnerLov_Ds.f_code)})
public class BusinessPartnerLov_Ds
		extends
			AbstractTypeWithCodeLov<BusinessPartner> {

	public BusinessPartnerLov_Ds() {
		super();
	}

	public BusinessPartnerLov_Ds(BusinessPartner e) {
		super(e);
	}
}
