/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.mm;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;
import net.nan21.dnet.module.md.domain.impl.mm.Product;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;
import net.nan21.dnet.module.md.domain.impl.mm.ProductManufacturer;

/**
 * Interface to expose business functions specific for {@link Product} domain
 * entity.
 */
public interface IProductService extends IEntityService<Product> {

	/**
	 * Find by unique key
	 */
	public Product findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Product findByName(String name);

	/**
	 * Find by reference: defaultUom
	 */
	public List<Product> findByDefaultUom(Uom defaultUom);

	/**
	 * Find by ID of reference: defaultUom.id
	 */
	public List<Product> findByDefaultUomId(String defaultUomId);

	/**
	 * Find by reference: weightUom
	 */
	public List<Product> findByWeightUom(Uom weightUom);

	/**
	 * Find by ID of reference: weightUom.id
	 */
	public List<Product> findByWeightUomId(String weightUomId);

	/**
	 * Find by reference: volumeUom
	 */
	public List<Product> findByVolumeUom(Uom volumeUom);

	/**
	 * Find by ID of reference: volumeUom.id
	 */
	public List<Product> findByVolumeUomId(String volumeUomId);

	/**
	 * Find by reference: dimUom
	 */
	public List<Product> findByDimUom(Uom dimUom);

	/**
	 * Find by ID of reference: dimUom.id
	 */
	public List<Product> findByDimUomId(String dimUomId);

	/**
	 * Find by reference: manufacturer
	 */
	public List<Product> findByManufacturer(ProductManufacturer manufacturer);

	/**
	 * Find by ID of reference: manufacturer.id
	 */
	public List<Product> findByManufacturerId(String manufacturerId);

	/**
	 * Find by reference: attributeSet
	 */
	public List<Product> findByAttributeSet(AttributeSet attributeSet);

	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<Product> findByAttributeSetId(String attributeSetId);

	/**
	 * Find by reference: category
	 */
	public List<Product> findByCategory(ProductCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<Product> findByCategoryId(String categoryId);
}
