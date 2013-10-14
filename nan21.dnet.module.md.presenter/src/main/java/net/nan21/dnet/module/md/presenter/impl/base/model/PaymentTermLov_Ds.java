/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;

@Ds(entity = PaymentTerm.class, sort = {@SortField(field = PaymentTermLov_Ds.f_name)})
public class PaymentTermLov_Ds extends AbstractTypeLov<PaymentTerm> {

	public PaymentTermLov_Ds() {
		super();
	}

	public PaymentTermLov_Ds(PaymentTerm e) {
		super(e);
	}
}
