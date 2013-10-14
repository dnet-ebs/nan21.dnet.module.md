/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.org.Inventory;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocation;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocationType;

/**
 * Interface to expose business functions specific for {@link InventoryLocation} domain
 * entity.
 */
public interface IInventoryLocationService
		extends
			IEntityService<InventoryLocation> {

	/**
	 * Find by unique key
	 */
	public InventoryLocation findByName(String name);

	/**
	 * Find by reference: inventory
	 */
	public List<InventoryLocation> findByInventory(Inventory inventory);

	/**
	 * Find by ID of reference: inventory.id
	 */
	public List<InventoryLocation> findByInventoryId(String inventoryId);

	/**
	 * Find by reference: locationType
	 */
	public List<InventoryLocation> findByLocationType(
			InventoryLocationType locationType);

	/**
	 * Find by ID of reference: locationType.id
	 */
	public List<InventoryLocation> findByLocationTypeId(String locationTypeId);
}
