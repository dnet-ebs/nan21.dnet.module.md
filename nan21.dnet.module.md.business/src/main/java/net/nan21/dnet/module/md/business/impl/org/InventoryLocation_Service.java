/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.org;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.org.IInventoryLocationService;
import net.nan21.dnet.module.md.domain.impl.org.Inventory;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocation;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocationType;

/**
 * Repository functionality for {@link InventoryLocation} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class InventoryLocation_Service
		extends
			AbstractEntityService<InventoryLocation>
		implements
			IInventoryLocationService {

	public InventoryLocation_Service() {
		super();
	}

	public InventoryLocation_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<InventoryLocation> getEntityClass() {
		return InventoryLocation.class;
	}
	/**
	 * Find by unique key
	 */
	public InventoryLocation findByName(String name) {
		return (InventoryLocation) this
				.getEntityManager()
				.createNamedQuery(InventoryLocation.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: inventory
	 */
	public List<InventoryLocation> findByInventory(Inventory inventory) {
		return this.findByInventoryId(inventory.getId());
	}
	/**
	 * Find by ID of reference: inventory.id
	 */
	public List<InventoryLocation> findByInventoryId(String inventoryId) {
		return (List<InventoryLocation>) this
				.getEntityManager()
				.createQuery(
						"select e from InventoryLocation e where e.clientId = :clientId and e.inventory.id = :inventoryId",
						InventoryLocation.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("inventoryId", inventoryId).getResultList();
	}
	/**
	 * Find by reference: locationType
	 */
	public List<InventoryLocation> findByLocationType(
			InventoryLocationType locationType) {
		return this.findByLocationTypeId(locationType.getId());
	}
	/**
	 * Find by ID of reference: locationType.id
	 */
	public List<InventoryLocation> findByLocationTypeId(String locationTypeId) {
		return (List<InventoryLocation>) this
				.getEntityManager()
				.createQuery(
						"select e from InventoryLocation e where e.clientId = :clientId and e.locationType.id = :locationTypeId",
						InventoryLocation.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("locationTypeId", locationTypeId).getResultList();
	}
}
