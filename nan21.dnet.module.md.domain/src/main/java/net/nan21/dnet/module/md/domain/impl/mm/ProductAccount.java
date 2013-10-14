/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.mm;

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
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.md.domain.impl.mm.Product;
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccountType;
import net.nan21.dnet.module.md.domain.impl.org.Org;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/** 
 * Product accounts. Specify how a product is used within an organization.
 */
@NamedQueries({
		@NamedQuery(name = ProductAccount.NQ_FIND_BY_PROD_ORG, query = "SELECT e FROM ProductAccount e WHERE e.clientId = :clientId and e.product = :product and e.company = :company", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ProductAccount.NQ_FIND_BY_PROD_ORG_PRIMITIVE, query = "SELECT e FROM ProductAccount e WHERE e.clientId = :clientId and e.product.id = :productId and e.company.id = :companyId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ProductAccount.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ProductAccount.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "PRODUCT_ID", "COMPANY_ID"})})
public class ProductAccount extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_PROD_ACNT";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Prod_org.
	 */
	public static final String NQ_FIND_BY_PROD_ORG = "ProductAccount.findByProd_org";
	/**
	 * Named query find by unique key: Prod_org using the ID field for references.
	 */
	public static final String NQ_FIND_BY_PROD_ORG_PRIMITIVE = "ProductAccount.findByProd_org_PRIMITIVE";

	@Column(name = "ANALITICSEGMENT", length = 32)
	private String analiticSegment;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Org.class)
	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
	private Org company;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductAccountType.class)
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
	private ProductAccountType type;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	private Product product;

	public String getAnaliticSegment() {
		return this.analiticSegment;
	}

	public void setAnaliticSegment(String analiticSegment) {
		this.analiticSegment = analiticSegment;
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

	public ProductAccountType getType() {
		return this.type;
	}

	public void setType(ProductAccountType type) {
		if (type != null) {
			this.__validate_client_context__(type.getClientId());
		}
		this.type = type;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		if (product != null) {
			this.__validate_client_context__(product.getClientId());
		}
		this.product = product;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
