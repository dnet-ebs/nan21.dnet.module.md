/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.base;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.base.ITaxService;
import net.nan21.dnet.module.md.domain.impl.base.Tax;
import net.nan21.dnet.module.md.domain.impl.base.TaxCategory;

/**
 * Repository functionality for {@link Tax} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Tax_Service extends AbstractEntityService<Tax>
		implements
			ITaxService {

	public Tax_Service() {
		super();
	}

	public Tax_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Tax> getEntityClass() {
		return Tax.class;
	}
	/**
	 * Find by unique key
	 */
	public Tax findByName(String name) {
		return (Tax) this
				.getEntityManager()
				.createNamedQuery(Tax.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: category
	 */
	public List<Tax> findByCategory(TaxCategory category) {
		return this.findByCategoryId(category.getId());
	}
	/**
	 * Find by ID of reference: category.id
	 */
	public List<Tax> findByCategoryId(String categoryId) {
		return (List<Tax>) this
				.getEntityManager()
				.createQuery(
						"select e from Tax e where e.clientId = :clientId and e.category.id = :categoryId",
						Tax.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("categoryId", categoryId).getResultList();
	}
	/**
	 * Find by reference: parentTax
	 */
	public List<Tax> findByParentTax(Tax parentTax) {
		return this.findByParentTaxId(parentTax.getId());
	}
	/**
	 * Find by ID of reference: parentTax.id
	 */
	public List<Tax> findByParentTaxId(String parentTaxId) {
		return (List<Tax>) this
				.getEntityManager()
				.createQuery(
						"select e from Tax e where e.clientId = :clientId and e.parentTax.id = :parentTaxId",
						Tax.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("parentTaxId", parentTaxId).getResultList();
	}
	/**
	 * Find by reference: children
	 */
	public List<Tax> findByChildren(Tax children) {
		return this.findByChildrenId(children.getId());
	}
	/**
	 * Find by ID of reference: children.id
	 */
	public List<Tax> findByChildrenId(String childrenId) {
		return (List<Tax>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Tax e, IN (e.children) c where e.clientId = :clientId and c.id = :childrenId",
						Tax.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("childrenId", childrenId).getResultList();
	}
}
