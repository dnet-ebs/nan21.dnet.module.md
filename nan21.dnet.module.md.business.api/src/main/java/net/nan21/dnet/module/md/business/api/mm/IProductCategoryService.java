/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.mm;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;

/**
 * Interface to expose business functions specific for {@link ProductCategory} domain
 * entity.
 */
public interface IProductCategoryService
		extends
			IEntityService<ProductCategory> {

	/**
	 * Find by unique key
	 */
	public ProductCategory findByCode(String code);

	/**
	 * Find by unique key
	 */
	public ProductCategory findByName(String name);

	/**
	 * Find by reference: category
	 */
	public List<ProductCategory> findByCategory(ProductCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<ProductCategory> findByCategoryId(String categoryId);
}
