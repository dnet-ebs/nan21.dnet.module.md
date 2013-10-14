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
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;
import net.nan21.dnet.module.md.business.api.mm.IProductService;
import net.nan21.dnet.module.md.domain.impl.mm.Product;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;
import net.nan21.dnet.module.md.domain.impl.mm.ProductManufacturer;

/**
 * Repository functionality for {@link Product} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Product_Service extends AbstractEntityService<Product>
		implements
			IProductService {

	public Product_Service() {
		super();
	}

	public Product_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Product> getEntityClass() {
		return Product.class;
	}
	/**
	 * Find by unique key
	 */
	public Product findByCode(String code) {
		return (Product) this
				.getEntityManager()
				.createNamedQuery(Product.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Product findByName(String name) {
		return (Product) this
				.getEntityManager()
				.createNamedQuery(Product.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: defaultUom
	 */
	public List<Product> findByDefaultUom(Uom defaultUom) {
		return this.findByDefaultUomId(defaultUom.getId());
	}
	/**
	 * Find by ID of reference: defaultUom.id
	 */
	public List<Product> findByDefaultUomId(String defaultUomId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :clientId and e.defaultUom.id = :defaultUomId",
						Product.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("defaultUomId", defaultUomId).getResultList();
	}
	/**
	 * Find by reference: weightUom
	 */
	public List<Product> findByWeightUom(Uom weightUom) {
		return this.findByWeightUomId(weightUom.getId());
	}
	/**
	 * Find by ID of reference: weightUom.id
	 */
	public List<Product> findByWeightUomId(String weightUomId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :clientId and e.weightUom.id = :weightUomId",
						Product.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("weightUomId", weightUomId).getResultList();
	}
	/**
	 * Find by reference: volumeUom
	 */
	public List<Product> findByVolumeUom(Uom volumeUom) {
		return this.findByVolumeUomId(volumeUom.getId());
	}
	/**
	 * Find by ID of reference: volumeUom.id
	 */
	public List<Product> findByVolumeUomId(String volumeUomId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :clientId and e.volumeUom.id = :volumeUomId",
						Product.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("volumeUomId", volumeUomId).getResultList();
	}
	/**
	 * Find by reference: dimUom
	 */
	public List<Product> findByDimUom(Uom dimUom) {
		return this.findByDimUomId(dimUom.getId());
	}
	/**
	 * Find by ID of reference: dimUom.id
	 */
	public List<Product> findByDimUomId(String dimUomId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :clientId and e.dimUom.id = :dimUomId",
						Product.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("dimUomId", dimUomId).getResultList();
	}
	/**
	 * Find by reference: manufacturer
	 */
	public List<Product> findByManufacturer(ProductManufacturer manufacturer) {
		return this.findByManufacturerId(manufacturer.getId());
	}
	/**
	 * Find by ID of reference: manufacturer.id
	 */
	public List<Product> findByManufacturerId(String manufacturerId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :clientId and e.manufacturer.id = :manufacturerId",
						Product.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("manufacturerId", manufacturerId).getResultList();
	}
	/**
	 * Find by reference: attributeSet
	 */
	public List<Product> findByAttributeSet(AttributeSet attributeSet) {
		return this.findByAttributeSetId(attributeSet.getId());
	}
	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<Product> findByAttributeSetId(String attributeSetId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :clientId and e.attributeSet.id = :attributeSetId",
						Product.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("attributeSetId", attributeSetId).getResultList();
	}
	/**
	 * Find by reference: category
	 */
	public List<Product> findByCategory(ProductCategory category) {
		return this.findByCategoryId(category.getId());
	}
	/**
	 * Find by ID of reference: category.id
	 */
	public List<Product> findByCategoryId(String categoryId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :clientId and e.category.id = :categoryId",
						Product.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("categoryId", categoryId).getResultList();
	}
}
