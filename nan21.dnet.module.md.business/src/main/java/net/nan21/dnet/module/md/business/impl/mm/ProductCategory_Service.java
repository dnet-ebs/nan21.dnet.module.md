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
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.attr.LookupItem;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;

/**
 * Repository functionality for {@link ProductCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductCategory_Service
		extends
			AbstractEntityService<ProductCategory> {

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
	/**
	 * Find by reference: attributeSet
	 */
	public List<ProductCategory> findByAttributeSet(AttributeSet attributeSet) {
		return this.findByAttributeSetId(attributeSet.getId());
	}
	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<ProductCategory> findByAttributeSetId(String attributeSetId) {
		return (List<ProductCategory>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductCategory e where e.clientId = :clientId and e.attributeSet.id = :attributeSetId",
						ProductCategory.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("attributeSetId", attributeSetId).getResultList();
	}
	/**
	 * Find by reference: material
	 */
	public List<ProductCategory> findByMaterial(LookupItem material) {
		return this.findByMaterialId(material.getId());
	}
	/**
	 * Find by ID of reference: material.id
	 */
	public List<ProductCategory> findByMaterialId(String materialId) {
		return (List<ProductCategory>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductCategory e where e.clientId = :clientId and e.material.id = :materialId",
						ProductCategory.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("materialId", materialId).getResultList();
	}
	/**
	 * Find by reference: quality
	 */
	public List<ProductCategory> findByQuality(LookupItem quality) {
		return this.findByQualityId(quality.getId());
	}
	/**
	 * Find by ID of reference: quality.id
	 */
	public List<ProductCategory> findByQualityId(String qualityId) {
		return (List<ProductCategory>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductCategory e where e.clientId = :clientId and e.quality.id = :qualityId",
						ProductCategory.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("qualityId", qualityId).getResultList();
	}
	/**
	 * Find by reference: surface
	 */
	public List<ProductCategory> findBySurface(LookupItem surface) {
		return this.findBySurfaceId(surface.getId());
	}
	/**
	 * Find by ID of reference: surface.id
	 */
	public List<ProductCategory> findBySurfaceId(String surfaceId) {
		return (List<ProductCategory>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductCategory e where e.clientId = :clientId and e.surface.id = :surfaceId",
						ProductCategory.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("surfaceId", surfaceId).getResultList();
	}
}
