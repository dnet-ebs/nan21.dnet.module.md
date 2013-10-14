/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.mm;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.mm.IProductCategoryService;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;

/**
 * Repository functionality for {@link ProductCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductCategory_Service
		extends
			AbstractEntityService<ProductCategory>
		implements
			IProductCategoryService {

	public ProductCategory_Service() {
		super();
	}

	public ProductCategory_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductCategory> getEntityClass() {
		return ProductCategory.class;
	}
	/**
	 * Find by unique key
	 */
	public ProductCategory findByCode(String code) {
		return (ProductCategory) this
				.getEntityManager()
				.createNamedQuery(ProductCategory.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public ProductCategory findByName(String name) {
		return (ProductCategory) this
				.getEntityManager()
				.createNamedQuery(ProductCategory.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: category
	 */
	public List<ProductCategory> findByCategory(ProductCategory category) {
		return this.findByCategoryId(category.getId());
	}
	/**
	 * Find by ID of reference: category.id
	 */
	public List<ProductCategory> findByCategoryId(String categoryId) {
		return (List<ProductCategory>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductCategory e where e.clientId = :clientId and e.category.id = :categoryId",
						ProductCategory.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("categoryId", categoryId).getResultList();
	}
}
