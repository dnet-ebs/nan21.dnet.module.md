/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.org;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.org.IOrgTypeService;
import net.nan21.dnet.module.md.domain.impl.org.OrgType;

/**
 * Repository functionality for {@link OrgType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OrgType_Service extends AbstractEntityService<OrgType>
		implements
			IOrgTypeService {

	public OrgType_Service() {
		super();
	}

	public OrgType_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<OrgType> getEntityClass() {
		return OrgType.class;
	}
	/**
	 * Find by unique key
	 */
	public OrgType findByCode(String code) {
		return (OrgType) this
				.getEntityManager()
				.createNamedQuery(OrgType.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public OrgType findByName(String name) {
		return (OrgType) this
				.getEntityManager()
				.createNamedQuery(OrgType.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
