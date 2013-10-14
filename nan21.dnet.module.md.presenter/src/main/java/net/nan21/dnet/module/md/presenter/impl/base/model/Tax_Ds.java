/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import java.math.BigDecimal;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.md.domain.impl.base.Tax;
import net.nan21.dnet.module.md.domain.impl.base.TaxCategory;

@Ds(entity = Tax.class, sort = {@SortField(field = Tax_Ds.f_name)})
@RefLookups({
		@RefLookup(refId = Tax_Ds.f_categoryId, namedQuery = TaxCategory.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = Tax_Ds.f_category)}),
		@RefLookup(refId = Tax_Ds.f_parentTaxId, namedQuery = Tax.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = Tax_Ds.f_parentTax)})})
public class Tax_Ds extends AbstractTypeDs<Tax> {

	public static final String f_rate = "rate";
	public static final String f_summary = "summary";
	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";
	public static final String f_parentTaxId = "parentTaxId";
	public static final String f_parentTax = "parentTax";

	@DsField
	private BigDecimal rate;

	@DsField
	private Boolean summary;

	@DsField(join = "left", path = "category.id")
	private String categoryId;

	@DsField(join = "left", path = "category.name")
	private String category;

	@DsField(join = "left", path = "parentTax.id")
	private String parentTaxId;

	@DsField(join = "left", path = "parentTax.name")
	private String parentTax;

	public Tax_Ds() {
		super();
	}

	public Tax_Ds(Tax e) {
		super(e);
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Boolean getSummary() {
		return this.summary;
	}

	public void setSummary(Boolean summary) {
		this.summary = summary;
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

	public String getParentTaxId() {
		return this.parentTaxId;
	}

	public void setParentTaxId(String parentTaxId) {
		this.parentTaxId = parentTaxId;
	}

	public String getParentTax() {
		return this.parentTax;
	}

	public void setParentTax(String parentTax) {
		this.parentTax = parentTax;
	}
}
