/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.base;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.base.IDocTypeService;
import net.nan21.dnet.module.md.domain.impl.base.DocType;

/**
 * Repository functionality for {@link DocType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DocType_Service extends AbstractEntityService<DocType>
		implements
			IDocTypeService {

	public DocType_Service() {
		super();
	}

	public DocType_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DocType> getEntityClass() {
		return DocType.class;
	}
	/**
	 * Find by unique key
	 */
	public DocType findByCode(String code) {
		return (DocType) this
				.getEntityManager()
				.createNamedQuery(DocType.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public DocType findByName(String name) {
		return (DocType) this
				.getEntityManager()
				.createNamedQuery(DocType.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
