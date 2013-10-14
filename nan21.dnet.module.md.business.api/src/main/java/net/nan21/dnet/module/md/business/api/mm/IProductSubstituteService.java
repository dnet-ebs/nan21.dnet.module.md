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
	 * Find by reference: refProduct
	 */
	public List<ProductSubstitute> findByRefProduct(Product refProduct);

	/**
	 * Find by ID of reference: refProduct.id
	 */
	public List<ProductSubstitute> findByRefProductId(String refProductId);

	/**
	 * Find by reference: equivalence
	 */
	public List<ProductSubstitute> findByEquivalence(Product equivalence);

	/**
	 * Find by ID of reference: equivalence.id
	 */
	public List<ProductSubstitute> findByEquivalenceId(String equivalenceId);
}
