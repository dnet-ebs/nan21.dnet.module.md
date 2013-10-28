/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocationType;

/**
 * Interface to expose business functions specific for {@link InventoryLocationType} domain
 * entity.
 */
public interface IInventoryLocationTypeService
		extends
			IEntityService<InventoryLocationType> {

	/**
	 * Find by unique key
	 */
	public InventoryLocationType findByCode(String code);

	/**
	 * Find by unique key
	 */
	public InventoryLocationType findByName(String name);
}
