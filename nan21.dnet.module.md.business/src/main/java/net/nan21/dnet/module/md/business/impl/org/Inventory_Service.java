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
import net.nan21.dnet.module.md.business.api.org.IInventoryService;
import net.nan21.dnet.module.md.domain.impl.org.Inventory;
import net.nan21.dnet.module.md.domain.impl.org.Org;

/**
 * Repository functionality for {@link Inventory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Inventory_Service extends AbstractEntityService<Inventory>
		implements
			IInventoryService {

	public Inventory_Service() {
		super();
	}

	public Inventory_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Inventory> getEntityClass() {
		return Inventory.class;
	}
	/**
	 * Find by unique key
	 */
	public Inventory findByName(String name) {
		return (Inventory) this
				.getEntityManager()
				.createNamedQuery(Inventory.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: org
	 */
	public List<Inventory> findByOrg(Org org) {
		return this.findByOrgId(org.getId());
	}
	/**
	 * Find by ID of reference: org.id
	 */
	public List<Inventory> findByOrgId(String orgId) {
		return (List<Inventory>) this
				.getEntityManager()
				.createQuery(
						"select e from Inventory e where e.clientId = :clientId and e.org.id = :orgId",
						Inventory.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("orgId", orgId).getResultList();
	}
}
