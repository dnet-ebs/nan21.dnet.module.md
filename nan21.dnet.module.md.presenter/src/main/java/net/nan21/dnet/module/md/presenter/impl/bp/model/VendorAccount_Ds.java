/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import java.math.BigDecimal;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;
import net.nan21.dnet.module.md.domain.impl.bp.BpAccount;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;
import net.nan21.dnet.module.md.domain.impl.bp.VendorGroup;
import net.nan21.dnet.module.md.domain.impl.org.Org;

@Ds(entity = BpAccount.class, jpqlWhere = " e.vendor = true ")
@RefLookups({
		@RefLookup(refId = VendorAccount_Ds.f_bpartnerId, namedQuery = BusinessPartner.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = VendorAccount_Ds.f_bpartner)}),
		@RefLookup(refId = VendorAccount_Ds.f_companyId, namedQuery = Org.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = VendorAccount_Ds.f_company)}),
		@RefLookup(refId = VendorAccount_Ds.f_groupId, namedQuery = VendorGroup.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = VendorAccount_Ds.f_group)}),
		@RefLookup(refId = VendorAccount_Ds.f_paymentTermId, namedQuery = PaymentTerm.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = VendorAccount_Ds.f_paymentTerm)})})
public class VendorAccount_Ds extends AbstractAuditableDs<BpAccount> {

	public static final String f_vendor = "vendor";
	public static final String f_creditLimit = "creditLimit";
	public static final String f_companyId = "companyId";
	public static final String f_company = "company";
	public static final String f_bpartnerId = "bpartnerId";
	public static final String f_bpartner = "bpartner";
	public static final String f_bpartnerName = "bpartnerName";
	public static final String f_groupId = "groupId";
	public static final String f_group = "group";
	public static final String f_paymentMethodId = "paymentMethodId";
	public static final String f_paymentMethod = "paymentMethod";
	public static final String f_paymentTermId = "paymentTermId";
	public static final String f_paymentTerm = "paymentTerm";

	@DsField
	private Boolean vendor;

	@DsField(path = "vendCreditLimit")
	private BigDecimal creditLimit;

	@DsField(join = "left", path = "company.id")
	private String companyId;

	@DsField(join = "left", path = "company.code")
	private String company;

	@DsField(join = "left", path = "bpartner.id")
	private String bpartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String bpartner;

	@DsField(join = "left", path = "bpartner.name")
	private String bpartnerName;

	@DsField(join = "left", path = "vendGroup.id")
	private String groupId;

	@DsField(join = "left", path = "vendGroup.code")
	private String group;

	@DsField(join = "left", path = "vendPaymentMethod.id")
	private String paymentMethodId;

	@DsField(join = "left", path = "vendPaymentMethod.code")
	private String paymentMethod;

	@DsField(join = "left", path = "vendPaymentTerm.id")
	private String paymentTermId;

	@DsField(join = "left", path = "vendPaymentTerm.name")
	private String paymentTerm;

	public VendorAccount_Ds() {
		super();
	}

	public VendorAccount_Ds(BpAccount e) {
		super(e);
	}

	public Boolean getVendor() {
		return this.vendor;
	}

	public void setVendor(Boolean vendor) {
		this.vendor = vendor;
	}

	public BigDecimal getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
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

	public String getBpartnerId() {
		return this.bpartnerId;
	}

	public void setBpartnerId(String bpartnerId) {
		this.bpartnerId = bpartnerId;
	}

	public String getBpartner() {
		return this.bpartner;
	}

	public void setBpartner(String bpartner) {
		this.bpartner = bpartner;
	}

	public String getBpartnerName() {
		return this.bpartnerName;
	}

	public void setBpartnerName(String bpartnerName) {
		this.bpartnerName = bpartnerName;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
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
