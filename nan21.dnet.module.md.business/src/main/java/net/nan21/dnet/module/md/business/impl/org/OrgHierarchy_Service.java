/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.org;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.org.IOrgHierarchyService;
import net.nan21.dnet.module.md.domain.impl.org.OrgHierarchy;

/**
 * Repository functionality for {@link OrgHierarchy} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OrgHierarchy_Service extends AbstractEntityService<OrgHierarchy>
		implements
			IOrgHierarchyService {

	public OrgHierarchy_Service() {
		super();
	}

	public OrgHierarchy_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<OrgHierarchy> getEntityClass() {
		return OrgHierarchy.class;
	}
	/**
	 * Find by unique key
	 */
	public OrgHierarchy findByName(String name) {
		return (OrgHierarchy) this
				.getEntityManager()
				.createNamedQuery(OrgHierarchy.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
