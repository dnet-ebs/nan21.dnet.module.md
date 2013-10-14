/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;

@Ds(entity = PaymentTerm.class, sort = {@SortField(field = PaymentTerm_Ds.f_name)})
public class PaymentTerm_Ds extends AbstractTypeDs<PaymentTerm> {

	public static final String f_days = "days";

	@DsField
	private Integer days;

	public PaymentTerm_Ds() {
		super();
	}

	public PaymentTerm_Ds(PaymentTerm e) {
		super(e);
	}

	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
}
