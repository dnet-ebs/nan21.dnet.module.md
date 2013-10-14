/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableLov;
import net.nan21.dnet.module.md.domain.impl.bp.BpAccount;

@Ds(entity = BpAccount.class, jpqlWhere = " e.customer = true ")
public class CustomerAccountLov_Ds extends AbstractAuditableLov<BpAccount> {

	public static final String f_active = "active";
	public static final String f_bpartnerId = "bpartnerId";
	public static final String f_code = "code";
	public static final String f_name = "name";
	public static final String f_companyId = "companyId";
	public static final String f_company = "company";
	public static final String f_paymentTermId = "paymentTermId";
	public static final String f_paymentTerm = "paymentTerm";

	@DsField
	private Boolean active;

	@DsField(join = "left", path = "bpartner.id")
	private String bpartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String code;

	@DsField(join = "left", path = "bpartner.name")
	private String name;

	@DsField(join = "left", path = "company.id")
	private String companyId;

	@DsField(join = "left", path = "company.code")
	private String company;

	@DsField(join = "left", path = "custPaymentTerm.id")
	private String paymentTermId;

	@DsField(join = "left", path = "custPaymentTerm.name")
	private String paymentTerm;

	public CustomerAccountLov_Ds() {
		super();
	}

	public CustomerAccountLov_Ds(BpAccount e) {
		super(e);
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getBpartnerId() {
		return this.bpartnerId;
	}

	public void setBpartnerId(String bpartnerId) {
		this.bpartnerId = bpartnerId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
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
