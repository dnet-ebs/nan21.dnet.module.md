/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.org;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.org.IInventoryLocationTypeService;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocationType;

/**
 * Repository functionality for {@link InventoryLocationType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class InventoryLocationType_Service
		extends
			AbstractEntityService<InventoryLocationType>
		implements
			IInventoryLocationTypeService {

	public InventoryLocationType_Service() {
		super();
	}

	public InventoryLocationType_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<InventoryLocationType> getEntityClass() {
		return InventoryLocationType.class;
	}
	/**
	 * Find by unique key
	 */
	public InventoryLocationType findByCode(String code) {
		return (InventoryLocationType) this
				.getEntityManager()
				.createNamedQuery(InventoryLocationType.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public InventoryLocationType findByName(String name) {
		return (InventoryLocationType) this
				.getEntityManager()
				.createNamedQuery(InventoryLocationType.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
