/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.mm;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.mm.Product;
import net.nan21.dnet.module.md.domain.impl.mm.ProductSubstitute;

/**
 * Interface to expose business functions specific for {@link ProductSubstitute} domain
 * entity.
 */
public interface IProductSubstituteService
		extends
			IEntityService<ProductSubstitute> {

	/**
	 * Find by unique key
	 */
	public ProductSubstitute findBySubst(Product product, Product substitute);

	/**
	 * Find by unique key
	 */
	public ProductSubstitute findBySubst(Long productId, Long substituteId);

	/**
	 * Find by reference: product
	 */
	public List<ProductSubstitute> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProductSubstitute> findByProductId(String productId);

	/**
	 * Find by reference: substitute
	 */
	public List<ProductSubstitute> findBySubstitute(Product substitute);

	/**
	 * Find by ID of reference: substitute.id
	 */
	public List<ProductSubstitute> findBySubstituteId(String substituteId);
}
