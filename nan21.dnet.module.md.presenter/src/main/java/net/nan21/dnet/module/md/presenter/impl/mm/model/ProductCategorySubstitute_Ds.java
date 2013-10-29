/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.mm.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategorySubstitute;

@Ds(entity = ProductCategorySubstitute.class)
@RefLookups({
		@RefLookup(refId = ProductCategorySubstitute_Ds.f_categoryId, namedQuery = ProductCategory.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = ProductCategorySubstitute_Ds.f_category)}),
		@RefLookup(refId = ProductCategorySubstitute_Ds.f_substituteId, namedQuery = ProductCategory.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = ProductCategorySubstitute_Ds.f_substitute)})})
public class ProductCategorySubstitute_Ds
		extends
			AbstractAuditableDs<ProductCategorySubstitute> {

	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";
	public static final String f_categoryName = "categoryName";
	public static final String f_substituteId = "substituteId";
	public static final String f_substitute = "substitute";
	public static final String f_substituteName = "substituteName";

	@DsField(join = "left", path = "category.id")
	private String categoryId;

	@DsField(join = "left", path = "category.code")
	private String category;

	@DsField(join = "left", path = "category.name")
	private String categoryName;

	@DsField(join = "left", path = "substitute.id")
	private String substituteId;

	@DsField(join = "left", path = "substitute.code")
	private String substitute;

	@DsField(join = "left", path = "substitute.name")
	private String substituteName;

	public ProductCategorySubstitute_Ds() {
		super();
	}

	public ProductCategorySubstitute_Ds(ProductCategorySubstitute e) {
		super(e);
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubstituteId() {
		return this.substituteId;
	}

	public void setSubstituteId(String substituteId) {
		this.substituteId = substituteId;
	}

	public String getSubstitute() {
		return this.substitute;
	}

	public void setSubstitute(String substitute) {
		this.substitute = substitute;
	}

	public String getSubstituteName() {
		return this.substituteName;
	}

	public void setSubstituteName(String substituteName) {
		this.substituteName = substituteName;
	}
}
