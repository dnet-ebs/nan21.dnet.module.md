/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.mm;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategorySubstitute;

/**
 * Interface to expose business functions specific for {@link ProductCategorySubstitute} domain
 * entity.
 */
public interface IProductCategorySubstituteService
		extends
			IEntityService<ProductCategorySubstitute> {

	/**
	 * Find by unique key
	 */
	public ProductCategorySubstitute findBySubst(ProductCategory category,
			ProductCategory substitute);

	/**
	 * Find by unique key
	 */
	public ProductCategorySubstitute findBySubst(Long categoryId,
			Long substituteId);

	/**
	 * Find by reference: category
	 */
	public List<ProductCategorySubstitute> findByCategory(
			ProductCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<ProductCategorySubstitute> findByCategoryId(String categoryId);

	/**
	 * Find by reference: substitute
	 */
	public List<ProductCategorySubstitute> findBySubstitute(
			ProductCategory substitute);

	/**
	 * Find by ID of reference: substitute.id
	 */
	public List<ProductCategorySubstitute> findBySubstituteId(
			String substituteId);
}
