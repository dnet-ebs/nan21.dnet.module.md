/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.bp;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;
import net.nan21.dnet.module.md.domain.impl.bp.CustomerGroup;
import net.nan21.dnet.module.md.domain.impl.bp.VendorGroup;
import net.nan21.dnet.module.md.domain.impl.org.Org;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * 
 */
@NamedQueries({
		@NamedQuery(name = BpAccount.NQ_FIND_BY_ORG_BP, query = "SELECT e FROM BpAccount e WHERE e.clientId = :clientId and e.company = :company and e.bpartner = :bpartner", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = BpAccount.NQ_FIND_BY_ORG_BP_PRIMITIVE, query = "SELECT e FROM BpAccount e WHERE e.clientId = :clientId and e.company.id = :companyId and e.bpartner.id = :bpartnerId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = BpAccount.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = BpAccount.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "COMPANY_ID", "BPARTNER_ID"})})
public class BpAccount extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_BP_ACNT";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Org_bp.
	 */
	public static final String NQ_FIND_BY_ORG_BP = "BpAccount.findByOrg_bp";
	/**
	 * Named query find by unique key: Org_bp using the ID field for references.
	 */
	public static final String NQ_FIND_BY_ORG_BP_PRIMITIVE = "BpAccount.findByOrg_bp_PRIMITIVE";

	/** Is this business partner a customer for the organization ? */
	@NotNull
	@Column(name = "CUSTOMER", nullable = false)
	private Boolean customer;

	/** Is this business partner a vendor for the organization ? */
	@NotNull
	@Column(name = "VENDOR", nullable = false)
	private Boolean vendor;

	/** Credit limit as customer. Overrides customer-group level value */
	@Column(name = "CUSTCREDITLIMIT", precision = 18, scale = 2)
	private BigDecimal custCreditLimit;

	/** Credit limit as vendor. Overrides vendor-group level value */
	@Column(name = "VENDCREDITLIMIT", precision = 18, scale = 2)
	private BigDecimal vendCreditLimit;

	@Column(name = "ANALITICSEGMENT", length = 32)
	private String analiticSegment;

	@Column(name = "CUSTANALITICSEGMENT", length = 32)
	private String custAnaliticSegment;

	@Column(name = "VENDANALITICSEGMENT", length = 32)
	private String vendAnaliticSegment;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
	@JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
	private BusinessPartner bpartner;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Org.class)
	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
	private Org company;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomerGroup.class)
	@JoinColumn(name = "CUSTGROUP_ID", referencedColumnName = "ID")
	private CustomerGroup custGroup;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DocType.class)
	@JoinColumn(name = "CUSTPAYMENTMETHOD_ID", referencedColumnName = "ID")
	private DocType custPaymentMethod;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentTerm.class)
	@JoinColumn(name = "CUSTPAYMENTTERM_ID", referencedColumnName = "ID")
	private PaymentTerm custPaymentTerm;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = VendorGroup.class)
	@JoinColumn(name = "VENDGROUP_ID", referencedColumnName = "ID")
	private VendorGroup vendGroup;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DocType.class)
	@JoinColumn(name = "VENDPAYMENTMETHOD_ID", referencedColumnName = "ID")
	private DocType vendPaymentMethod;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PaymentTerm.class)
	@JoinColumn(name = "VENDPAYMENTTERM_ID", referencedColumnName = "ID")
	private PaymentTerm vendPaymentTerm;

	public Boolean getCustomer() {
		return this.customer;
	}

	public void setCustomer(Boolean customer) {
		this.customer = customer;
	}

	public Boolean getVendor() {
		return this.vendor;
	}

	public void setVendor(Boolean vendor) {
		this.vendor = vendor;
	}

	public BigDecimal getCustCreditLimit() {
		return this.custCreditLimit;
	}

	public void setCustCreditLimit(BigDecimal custCreditLimit) {
		this.custCreditLimit = custCreditLimit;
	}

	public BigDecimal getVendCreditLimit() {
		return this.vendCreditLimit;
	}

	public void setVendCreditLimit(BigDecimal vendCreditLimit) {
		this.vendCreditLimit = vendCreditLimit;
	}

	public String getAnaliticSegment() {
		return this.analiticSegment;
	}

	public void setAnaliticSegment(String analiticSegment) {
		this.analiticSegment = analiticSegment;
	}

	public String getCustAnaliticSegment() {
		return this.custAnaliticSegment;
	}

	public void setCustAnaliticSegment(String custAnaliticSegment) {
		this.custAnaliticSegment = custAnaliticSegment;
	}

	public String getVendAnaliticSegment() {
		return this.vendAnaliticSegment;
	}

	public void setVendAnaliticSegment(String vendAnaliticSegment) {
		this.vendAnaliticSegment = vendAnaliticSegment;
	}

	public BusinessPartner getBpartner() {
		return this.bpartner;
	}

	public void setBpartner(BusinessPartner bpartner) {
		if (bpartner != null) {
			this.__validate_client_context__(bpartner.getClientId());
		}
		this.bpartner = bpartner;
	}

	public Org getCompany() {
		return this.company;
	}

	public void setCompany(Org company) {
		if (company != null) {
			this.__validate_client_context__(company.getClientId());
		}
		this.company = company;
	}

	public CustomerGroup getCustGroup() {
		return this.custGroup;
	}

	public void setCustGroup(CustomerGroup custGroup) {
		if (custGroup != null) {
			this.__validate_client_context__(custGroup.getClientId());
		}
		this.custGroup = custGroup;
	}

	public DocType getCustPaymentMethod() {
		return this.custPaymentMethod;
	}

	public void setCustPaymentMethod(DocType custPaymentMethod) {
		if (custPaymentMethod != null) {
			this.__validate_client_context__(custPaymentMethod.getClientId());
		}
		this.custPaymentMethod = custPaymentMethod;
	}

	public PaymentTerm getCustPaymentTerm() {
		return this.custPaymentTerm;
	}

	public void setCustPaymentTerm(PaymentTerm custPaymentTerm) {
		if (custPaymentTerm != null) {
			this.__validate_client_context__(custPaymentTerm.getClientId());
		}
		this.custPaymentTerm = custPaymentTerm;
	}

	public VendorGroup getVendGroup() {
		return this.vendGroup;
	}

	public void setVendGroup(VendorGroup vendGroup) {
		if (vendGroup != null) {
			this.__validate_client_context__(vendGroup.getClientId());
		}
		this.vendGroup = vendGroup;
	}

	public DocType getVendPaymentMethod() {
		return this.vendPaymentMethod;
	}

	public void setVendPaymentMethod(DocType vendPaymentMethod) {
		if (vendPaymentMethod != null) {
			this.__validate_client_context__(vendPaymentMethod.getClientId());
		}
		this.vendPaymentMethod = vendPaymentMethod;
	}

	public PaymentTerm getVendPaymentTerm() {
		return this.vendPaymentTerm;
	}

	public void setVendPaymentTerm(PaymentTerm vendPaymentTerm) {
		if (vendPaymentTerm != null) {
			this.__validate_client_context__(vendPaymentTerm.getClientId());
		}
		this.vendPaymentTerm = vendPaymentTerm;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.customer == null) {
			this.customer = new Boolean(false);
		}
		if (this.vendor == null) {
			this.vendor = new Boolean(false);
		}
	}
}
