/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.mm;

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
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/** 
 * Product substitutes.
 */
@NamedQueries({
		@NamedQuery(name = ProductSubstitute.NQ_FIND_BY_SUBST, query = "SELECT e FROM ProductSubstitute e WHERE e.clientId = :clientId and e.product = :product and e.substitute = :substitute", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ProductSubstitute.NQ_FIND_BY_SUBST_PRIMITIVE, query = "SELECT e FROM ProductSubstitute e WHERE e.clientId = :clientId and e.product.id = :productId and e.substitute.id = :substituteId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ProductSubstitute.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ProductSubstitute.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "PRODUCT_ID", "SUBSTITUTE_ID"})})
public class ProductSubstitute extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_PROD_SUBST";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Subst.
	 */
	public static final String NQ_FIND_BY_SUBST = "ProductSubstitute.findBySubst";
	/**
	 * Named query find by unique key: Subst using the ID field for references.
	 */
	public static final String NQ_FIND_BY_SUBST_PRIMITIVE = "ProductSubstitute.findBySubst_PRIMITIVE";

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "SUBSTITUTE_ID", referencedColumnName = "ID")
	private Product substitute;

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		if (product != null) {
			this.__validate_client_context__(product.getClientId());
		}
		this.product = product;
	}

	public Product getSubstitute() {
		return this.substitute;
	}

	public void setSubstitute(Product substitute) {
		if (substitute != null) {
			this.__validate_client_context__(substitute.getClientId());
		}
		this.substitute = substitute;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
