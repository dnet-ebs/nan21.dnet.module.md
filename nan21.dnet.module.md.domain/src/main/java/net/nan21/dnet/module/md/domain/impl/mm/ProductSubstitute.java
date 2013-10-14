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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.md.domain.impl.mm.Product;

/** 
 * Product substitutes.
 */
@Entity
@Table(name = ProductSubstitute.TABLE_NAME)
public class ProductSubstitute extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_PROD_SUBST";

	private static final long serialVersionUID = -8865917134914502125L;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "REFPRODUCT_ID", referencedColumnName = "ID")
	private Product refProduct;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinColumn(name = "EQUIVALENCE_ID", referencedColumnName = "ID")
	private Product equivalence;

	public Product getRefProduct() {
		return this.refProduct;
	}

	public void setRefProduct(Product refProduct) {
		if (refProduct != null) {
			this.__validate_client_context__(refProduct.getClientId());
		}
		this.refProduct = refProduct;
	}

	public Product getEquivalence() {
		return this.equivalence;
	}

	public void setEquivalence(Product equivalence) {
		if (equivalence != null) {
			this.__validate_client_context__(equivalence.getClientId());
		}
		this.equivalence = equivalence;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
