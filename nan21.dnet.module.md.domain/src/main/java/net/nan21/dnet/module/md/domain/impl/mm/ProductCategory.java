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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Product category definitions.
 */
@NamedQueries({
		@NamedQuery(name = ProductCategory.NQ_FIND_BY_CODE, query = "SELECT e FROM ProductCategory e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = ProductCategory.NQ_FIND_BY_NAME, query = "SELECT e FROM ProductCategory e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = ProductCategory.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = ProductCategory.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = ProductCategory.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class ProductCategory extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_PROD_CTG";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "ProductCategory.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "ProductCategory.findByName";

	/** Is allowed to link products to this category? */
	@NotNull
	@Column(name = "FOLDER", nullable = false)
	private Boolean folder;

	/** Link to an icon which represents this category */
	@Column(name = "ICONURL", length = 255)
	private String iconUrl;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductCategory.class)
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
	private ProductCategory category;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AttributeSet.class)
	@JoinColumn(name = "ATTRIBUTESET_ID", referencedColumnName = "ID")
	private AttributeSet attributeSet;

	public Boolean getFolder() {
		return this.folder;
	}

	public void setFolder(Boolean folder) {
		this.folder = folder;
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public ProductCategory getCategory() {
		return this.category;
	}

	public void setCategory(ProductCategory category) {
		if (category != null) {
			this.__validate_client_context__(category.getClientId());
		}
		this.category = category;
	}

	public AttributeSet getAttributeSet() {
		return this.attributeSet;
	}

	public void setAttributeSet(AttributeSet attributeSet) {
		if (attributeSet != null) {
			this.__validate_client_context__(attributeSet.getClientId());
		}
		this.attributeSet = attributeSet;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.folder == null) {
			this.folder = new Boolean(false);
		}
	}
}
