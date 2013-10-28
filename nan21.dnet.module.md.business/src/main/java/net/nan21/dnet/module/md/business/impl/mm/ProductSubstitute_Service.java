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
import net.nan21.dnet.module.md.business.api.mm.IProductSubstituteService;
import net.nan21.dnet.module.md.domain.impl.mm.Product;
import net.nan21.dnet.module.md.domain.impl.mm.ProductSubstitute;

/**
 * Repository functionality for {@link ProductSubstitute} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductSubstitute_Service
		extends
			AbstractEntityService<ProductSubstitute>
		implements
			IProductSubstituteService {

	public ProductSubstitute_Service() {
		super();
	}

	public ProductSubstitute_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductSubstitute> getEntityClass() {
		return ProductSubstitute.class;
	}
	/**
	 * Find by unique key
	 */
	public ProductSubstitute findBySubst(Product product, Product substitute) {
		return (ProductSubstitute) this
				.getEntityManager()
				.createNamedQuery(ProductSubstitute.NQ_FIND_BY_SUBST)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("product", product)
				.setParameter("substitute", substitute).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public ProductSubstitute findBySubst(Long productId, Long substituteId) {
		return (ProductSubstitute) this
				.getEntityManager()
				.createNamedQuery(ProductSubstitute.NQ_FIND_BY_SUBST_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("productId", productId)
				.setParameter("substituteId", substituteId).getSingleResult();
	}
	/**
	 * Find by reference: product
	 */
	public List<ProductSubstitute> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}
	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProductSubstitute> findByProductId(String productId) {
		return (List<ProductSubstitute>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductSubstitute e where e.clientId = :clientId and e.product.id = :productId",
						ProductSubstitute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("productId", productId).getResultList();
	}
	/**
	 * Find by reference: substitute
	 */
	public List<ProductSubstitute> findBySubstitute(Product substitute) {
		return this.findBySubstituteId(substitute.getId());
	}
	/**
	 * Find by ID of reference: substitute.id
	 */
	public List<ProductSubstitute> findBySubstituteId(String substituteId) {
		return (List<ProductSubstitute>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductSubstitute e where e.clientId = :clientId and e.substitute.id = :substituteId",
						ProductSubstitute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("substituteId", substituteId).getResultList();
	}
}
