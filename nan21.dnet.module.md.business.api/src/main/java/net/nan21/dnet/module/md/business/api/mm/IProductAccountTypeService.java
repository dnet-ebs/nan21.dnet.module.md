/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.mm;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccountType;

/**
 * Interface to expose business functions specific for {@link ProductAccountType} domain
 * entity.
 */
public interface IProductAccountTypeService
		extends
			IEntityService<ProductAccountType> {

	/**
	 * Find by unique key
	 */
	public ProductAccountType findByCode(String code);

	/**
	 * Find by unique key
	 */
	public ProductAccountType findByName(String name);
}
