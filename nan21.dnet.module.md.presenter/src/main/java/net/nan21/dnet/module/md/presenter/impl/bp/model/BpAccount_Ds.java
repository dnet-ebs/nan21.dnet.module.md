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
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;
import net.nan21.dnet.module.md.domain.impl.bp.BpAccount;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;
import net.nan21.dnet.module.md.domain.impl.bp.CustomerGroup;
import net.nan21.dnet.module.md.domain.impl.bp.VendorGroup;
import net.nan21.dnet.module.md.domain.impl.org.Org;

@Ds(entity = BpAccount.class)
@RefLookups({
		@RefLookup(refId = BpAccount_Ds.f_bpartnerId, namedQuery = BusinessPartner.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = BpAccount_Ds.f_bpartner)}),
		@RefLookup(refId = BpAccount_Ds.f_companyId, namedQuery = Org.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = BpAccount_Ds.f_company)}),
		@RefLookup(refId = BpAccount_Ds.f_customerGroupId, namedQuery = CustomerGroup.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = BpAccount_Ds.f_customerGroup)}),
		@RefLookup(refId = BpAccount_Ds.f_customerPaymentMethodId, namedQuery = DocType.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = BpAccount_Ds.f_customerPaymentMethod)}),
		@RefLookup(refId = BpAccount_Ds.f_customerPaymentTermId, namedQuery = PaymentTerm.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = BpAccount_Ds.f_customerPaymentTerm)}),
		@RefLookup(refId = BpAccount_Ds.f_vendorGroupId, namedQuery = VendorGroup.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = BpAccount_Ds.f_vendorGroup)}),
		@RefLookup(refId = BpAccount_Ds.f_vendorPaymentMethodId, namedQuery = DocType.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = BpAccount_Ds.f_vendorPaymentMethod)}),
		@RefLookup(refId = BpAccount_Ds.f_vendorPaymentTermId, namedQuery = PaymentTerm.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = BpAccount_Ds.f_vendorPaymentTerm)})})
public class BpAccount_Ds extends AbstractAuditableDs<BpAccount> {

	public static final String f_customer = "customer";
	public static final String f_customerCreditLimit = "customerCreditLimit";
	public static final String f_vendor = "vendor";
	public static final String f_vendorCreditLimit = "vendorCreditLimit";
	public static final String f_bpartnerId = "bpartnerId";
	public static final String f_bpartner = "bpartner";
	public static final String f_bpartnerName = "bpartnerName";
	public static final String f_companyId = "companyId";
	public static final String f_company = "company";
	public static final String f_customerGroupId = "customerGroupId";
	public static final String f_customerGroup = "customerGroup";
	public static final String f_customerPaymentMethodId = "customerPaymentMethodId";
	public static final String f_customerPaymentMethod = "customerPaymentMethod";
	public static final String f_customerPaymentTermId = "customerPaymentTermId";
	public static final String f_customerPaymentTerm = "customerPaymentTerm";
	public static final String f_vendorGroupId = "vendorGroupId";
	public static final String f_vendorGroup = "vendorGroup";
	public static final String f_vendorPaymentMethodId = "vendorPaymentMethodId";
	public static final String f_vendorPaymentMethod = "vendorPaymentMethod";
	public static final String f_vendorPaymentTermId = "vendorPaymentTermId";
	public static final String f_vendorPaymentTerm = "vendorPaymentTerm";

	@DsField
	private Boolean customer;

	@DsField(path = "custCreditLimit")
	private BigDecimal customerCreditLimit;

	@DsField
	private Boolean vendor;

	@DsField(path = "vendCreditLimit")
	private BigDecimal vendorCreditLimit;

	@DsField(join = "left", path = "bpartner.id")
	private String bpartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String bpartner;

	@DsField(join = "left", path = "bpartner.name")
	private String bpartnerName;

	@DsField(join = "left", path = "company.id")
	private String companyId;

	@DsField(join = "left", path = "company.code")
	private String company;

	@DsField(join = "left", path = "custGroup.id")
	private String customerGroupId;

	@DsField(join = "left", path = "custGroup.code")
	private String customerGroup;

	@DsField(join = "left", path = "custPaymentMethod.id")
	private String customerPaymentMethodId;

	@DsField(join = "left", path = "custPaymentMethod.code")
	private String customerPaymentMethod;

	@DsField(join = "left", path = "custPaymentTerm.id")
	private String customerPaymentTermId;

	@DsField(join = "left", path = "custPaymentTerm.name")
	private String customerPaymentTerm;

	@DsField(join = "left", path = "vendGroup.id")
	private String vendorGroupId;

	@DsField(join = "left", path = "vendGroup.code")
	private String vendorGroup;

	@DsField(join = "left", path = "vendPaymentMethod.id")
	private String vendorPaymentMethodId;

	@DsField(join = "left", path = "vendPaymentMethod.code")
	private String vendorPaymentMethod;

	@DsField(join = "left", path = "vendPaymentTerm.id")
	private String vendorPaymentTermId;

	@DsField(join = "left", path = "vendPaymentTerm.name")
	private String vendorPaymentTerm;

	public BpAccount_Ds() {
		super();
	}

	public BpAccount_Ds(BpAccount e) {
		super(e);
	}

	public Boolean getCustomer() {
		return this.customer;
	}

	public void setCustomer(Boolean customer) {
		this.customer = customer;
	}

	public BigDecimal getCustomerCreditLimit() {
		return this.customerCreditLimit;
	}

	public void setCustomerCreditLimit(BigDecimal customerCreditLimit) {
		this.customerCreditLimit = customerCreditLimit;
	}

	public Boolean getVendor() {
		return this.vendor;
	}

	public void setVendor(Boolean vendor) {
		this.vendor = vendor;
	}

	public BigDecimal getVendorCreditLimit() {
		return this.vendorCreditLimit;
	}

	public void setVendorCreditLimit(BigDecimal vendorCreditLimit) {
		this.vendorCreditLimit = vendorCreditLimit;
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

	public String getCustomerGroupId() {
		return this.customerGroupId;
	}

	public void setCustomerGroupId(String customerGroupId) {
		this.customerGroupId = customerGroupId;
	}

	public String getCustomerGroup() {
		return this.customerGroup;
	}

	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}

	public String getCustomerPaymentMethodId() {
		return this.customerPaymentMethodId;
	}

	public void setCustomerPaymentMethodId(String customerPaymentMethodId) {
		this.customerPaymentMethodId = customerPaymentMethodId;
	}

	public String getCustomerPaymentMethod() {
		return this.customerPaymentMethod;
	}

	public void setCustomerPaymentMethod(String customerPaymentMethod) {
		this.customerPaymentMethod = customerPaymentMethod;
	}

	public String getCustomerPaymentTermId() {
		return this.customerPaymentTermId;
	}

	public void setCustomerPaymentTermId(String customerPaymentTermId) {
		this.customerPaymentTermId = customerPaymentTermId;
	}

	public String getCustomerPaymentTerm() {
		return this.customerPaymentTerm;
	}

	public void setCustomerPaymentTerm(String customerPaymentTerm) {
		this.customerPaymentTerm = customerPaymentTerm;
	}

	public String getVendorGroupId() {
		return this.vendorGroupId;
	}

	public void setVendorGroupId(String vendorGroupId) {
		this.vendorGroupId = vendorGroupId;
	}

	public String getVendorGroup() {
		return this.vendorGroup;
	}

	public void setVendorGroup(String vendorGroup) {
		this.vendorGroup = vendorGroup;
	}

	public String getVendorPaymentMethodId() {
		return this.vendorPaymentMethodId;
	}

	public void setVendorPaymentMethodId(String vendorPaymentMethodId) {
		this.vendorPaymentMethodId = vendorPaymentMethodId;
	}

	public String getVendorPaymentMethod() {
		return this.vendorPaymentMethod;
	}

	public void setVendorPaymentMethod(String vendorPaymentMethod) {
		this.vendorPaymentMethod = vendorPaymentMethod;
	}

	public String getVendorPaymentTermId() {
		return this.vendorPaymentTermId;
	}

	public void setVendorPaymentTermId(String vendorPaymentTermId) {
		this.vendorPaymentTermId = vendorPaymentTermId;
	}

	public String getVendorPaymentTerm() {
		return this.vendorPaymentTerm;
	}

	public void setVendorPaymentTerm(String vendorPaymentTerm) {
		this.vendorPaymentTerm = vendorPaymentTerm;
	}
}
