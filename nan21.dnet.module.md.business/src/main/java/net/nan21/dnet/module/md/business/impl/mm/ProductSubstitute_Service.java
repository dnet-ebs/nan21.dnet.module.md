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
	 * Find by reference: refProduct
	 */
	public List<ProductSubstitute> findByRefProduct(Product refProduct) {
		return this.findByRefProductId(refProduct.getId());
	}
	/**
	 * Find by ID of reference: refProduct.id
	 */
	public List<ProductSubstitute> findByRefProductId(String refProductId) {
		return (List<ProductSubstitute>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductSubstitute e where e.clientId = :clientId and e.refProduct.id = :refProductId",
						ProductSubstitute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("refProductId", refProductId).getResultList();
	}
	/**
	 * Find by reference: equivalence
	 */
	public List<ProductSubstitute> findByEquivalence(Product equivalence) {
		return this.findByEquivalenceId(equivalence.getId());
	}
	/**
	 * Find by ID of reference: equivalence.id
	 */
	public List<ProductSubstitute> findByEquivalenceId(String equivalenceId) {
		return (List<ProductSubstitute>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductSubstitute e where e.clientId = :clientId and e.equivalence.id = :equivalenceId",
						ProductSubstitute.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("equivalenceId", equivalenceId).getResultList();
	}
}
