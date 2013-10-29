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
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/** 
 * Product substitutes.
 */
@NamedQueries({
		@NamedQuery(name = ProductCategorySubstitute.NQ_FIND_BY_SUBST, query = "SELECT e FROM ProductCategorySubstitute e WHERE e.clientId = :clientId and e.category = :category and e.substitute = :substitute", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ProductCategorySubstitute.NQ_FIND_BY_SUBST_PRIMITIVE, query = "SELECT e FROM ProductCategorySubstitute e WHERE e.clientId = :clientId and e.category.id = :categoryId and e.substitute.id = :substituteId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ProductCategorySubstitute.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = ProductCategorySubstitute.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "CATEGORY_ID", "SUBSTITUTE_ID"})})
public class ProductCategorySubstitute extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_PROD_CTG_SUBST";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Subst.
	 */
	public static final String NQ_FIND_BY_SUBST = "ProductCategorySubstitute.findBySubst";
	/**
	 * Named query find by unique key: Subst using the ID field for references.
	 */
	public static final String NQ_FIND_BY_SUBST_PRIMITIVE = "ProductCategorySubstitute.findBySubst_PRIMITIVE";

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductCategory.class)
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
	private ProductCategory category;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductCategory.class)
	@JoinColumn(name = "SUBSTITUTE_ID", referencedColumnName = "ID")
	private ProductCategory substitute;

	public ProductCategory getCategory() {
		return this.category;
	}

	public void setCategory(ProductCategory category) {
		if (category != null) {
			this.__validate_client_context__(category.getClientId());
		}
		this.category = category;
	}

	public ProductCategory getSubstitute() {
		return this.substitute;
	}

	public void setSubstitute(ProductCategory substitute) {
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
