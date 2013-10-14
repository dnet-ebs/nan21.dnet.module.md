/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.base;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.base.ITaxCategoryService;
import net.nan21.dnet.module.md.domain.impl.base.TaxCategory;

/**
 * Repository functionality for {@link TaxCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TaxCategory_Service extends AbstractEntityService<TaxCategory>
		implements
			ITaxCategoryService {

	public TaxCategory_Service() {
		super();
	}

	public TaxCategory_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<TaxCategory> getEntityClass() {
		return TaxCategory.class;
	}
	/**
	 * Find by unique key
	 */
	public TaxCategory findByName(String name) {
		return (TaxCategory) this
				.getEntityManager()
				.createNamedQuery(TaxCategory.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
