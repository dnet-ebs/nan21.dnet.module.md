/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.md.domain.impl.bp.BpContact;

@Ds(entity = BpContact.class, sort = {@SortField(field = BpContactLov_Ds.f_name)})
public class BpContactLov_Ds extends AbstractTypeLov<BpContact> {

	public static final String f_businessPartnerId = "businessPartnerId";

	@DsField(join = "left", path = "bpartner.id")
	private String businessPartnerId;

	public BpContactLov_Ds() {
		super();
	}

	public BpContactLov_Ds(BpContact e) {
		super(e);
	}

	public String getBusinessPartnerId() {
		return this.businessPartnerId;
	}

	public void setBusinessPartnerId(String businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}
}
