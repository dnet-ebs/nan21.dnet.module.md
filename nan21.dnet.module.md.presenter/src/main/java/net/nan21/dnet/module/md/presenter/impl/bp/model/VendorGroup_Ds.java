/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;
import net.nan21.dnet.module.md.domain.impl.bp.VendorGroup;

@Ds(entity = VendorGroup.class, sort = {@SortField(field = VendorGroup_Ds.f_code)})
@RefLookups({
		@RefLookup(refId = VendorGroup_Ds.f_paymentMethodId, namedQuery = DocType.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = VendorGroup_Ds.f_paymentMethod)}),
		@RefLookup(refId = VendorGroup_Ds.f_paymentTermId, namedQuery = PaymentTerm.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = VendorGroup_Ds.f_paymentTerm)})})
public class VendorGroup_Ds extends AbstractTypeWithCodeDs<VendorGroup> {

	public static final String f_paymentMethodId = "paymentMethodId";
	public static final String f_paymentMethod = "paymentMethod";
	public static final String f_paymentTermId = "paymentTermId";
	public static final String f_paymentTerm = "paymentTerm";

	@DsField(join = "left", path = "paymentMethod.id")
	private String paymentMethodId;

	@DsField(join = "left", path = "paymentMethod.code")
	private String paymentMethod;

	@DsField(join = "left", path = "paymentTerm.id")
	private String paymentTermId;

	@DsField(join = "left", path = "paymentTerm.name")
	private String paymentTerm;

	public VendorGroup_Ds() {
		super();
	}

	public VendorGroup_Ds(VendorGroup e) {
		super(e);
	}

	public String getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentTermId() {
		return this.paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPaymentTerm() {
		return this.paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}
}
