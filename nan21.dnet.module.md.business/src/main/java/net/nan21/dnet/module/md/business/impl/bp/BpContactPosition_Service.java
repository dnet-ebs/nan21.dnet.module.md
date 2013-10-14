/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.bp;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.bp.IBpContactPositionService;
import net.nan21.dnet.module.md.domain.impl.bp.BpContactPosition;

/**
 * Repository functionality for {@link BpContactPosition} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BpContactPosition_Service
		extends
			AbstractEntityService<BpContactPosition>
		implements
			IBpContactPositionService {

	public BpContactPosition_Service() {
		super();
	}

	public BpContactPosition_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BpContactPosition> getEntityClass() {
		return BpContactPosition.class;
	}
	/**
	 * Find by unique key
	 */
	public BpContactPosition findByName(String name) {
		return (BpContactPosition) this
				.getEntityManager()
				.createNamedQuery(BpContactPosition.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
