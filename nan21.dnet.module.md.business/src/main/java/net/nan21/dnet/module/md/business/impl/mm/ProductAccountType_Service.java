/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.mm;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.mm.IProductAccountTypeService;
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccountType;

/**
 * Repository functionality for {@link ProductAccountType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductAccountType_Service
		extends
			AbstractEntityService<ProductAccountType>
		implements
			IProductAccountTypeService {

	public ProductAccountType_Service() {
		super();
	}

	public ProductAccountType_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductAccountType> getEntityClass() {
		return ProductAccountType.class;
	}
	/**
	 * Find by unique key
	 */
	public ProductAccountType findByCode(String code) {
		return (ProductAccountType) this
				.getEntityManager()
				.createNamedQuery(ProductAccountType.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public ProductAccountType findByName(String name) {
		return (ProductAccountType) this
				.getEntityManager()
				.createNamedQuery(ProductAccountType.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
