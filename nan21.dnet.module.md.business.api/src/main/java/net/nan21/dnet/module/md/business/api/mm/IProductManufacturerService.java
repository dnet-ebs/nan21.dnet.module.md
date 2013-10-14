/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.mm;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.mm.ProductManufacturer;

/**
 * Interface to expose business functions specific for {@link ProductManufacturer} domain
 * entity.
 */
public interface IProductManufacturerService
		extends
			IEntityService<ProductManufacturer> {

	/**
	 * Find by unique key
	 */
	public ProductManufacturer findByCode(String code);

	/**
	 * Find by unique key
	 */
	public ProductManufacturer findByName(String name);
}
