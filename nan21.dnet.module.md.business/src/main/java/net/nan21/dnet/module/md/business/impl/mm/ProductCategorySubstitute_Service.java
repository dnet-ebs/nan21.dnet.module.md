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
import net.nan21.dnet.module.md.business.api.mm.IProductCategorySubstituteService;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategorySubstitute;

/**
 * Repository functionality for {@link ProductCategorySubstitute} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductCategorySubstitute_Service
		extends
			AbstractEntityService<ProductCategorySubstitute>
		implements
			IProductCategorySubstituteService {

	public ProductCategorySubstitute_Service() {
		super();
	}

	public ProductCategorySubstitute_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductCategorySubstitute> getEntityClass() {
		return ProductCategorySubstitute.class;
	}
	/**
	 * Find by unique key
	 */
	public ProductCategorySubstitute findBySubst(ProductCategory category,
			ProductCategory substitute) {
		return (ProductCategorySubstitute) this
				.getEntityManager()
				.createNamedQuery(ProductCategorySubstitute.NQ_FIND_BY_SUBST)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("category", category)
				.setParameter("substitute", substitute).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public ProductCategorySubstitute findBySubst(Long categoryId,
			Long substituteId) {
		return (ProductCategorySubstitute) this
				.getEntityManager()
				.createNamedQuery(
						ProductCategorySubstitute.NQ_FIND_BY_SUBST_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("categoryId", categoryId)
				.setParameter("substituteId", substituteId).getSingleResult();
	}
	/**
	 * Find by reference: category
	 */
	public List<ProductCategorySubstitute> findByCategory(
			ProductCategory category) {
		return this.findByCategoryId(category.getId());
	}
	/**
	 * Find by ID of reference: category.id
	 */
	public List<ProductCategorySubstitute> findByCategoryId(String categoryId) {
		return (List<ProductCategorySubstitute>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductCategorySubstitute e where e.clientId = :clientId and e.category.id = :categoryId",
						ProductCategorySubstitute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("categoryId", categoryId).getResultList();
	}
	/**
	 * Find by reference: substitute
	 */
	public List<ProductCategorySubstitute> findBySubstitute(
			ProductCategory substitute) {
		return this.findBySubstituteId(substitute.getId());
	}
	/**
	 * Find by ID of reference: substitute.id
	 */
	public List<ProductCategorySubstitute> findBySubstituteId(
			String substituteId) {
		return (List<ProductCategorySubstitute>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductCategorySubstitute e where e.clientId = :clientId and e.substitute.id = :substituteId",
						ProductCategorySubstitute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("substituteId", substituteId).getResultList();
	}
}
