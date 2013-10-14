/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.base;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.base.Tax;
import net.nan21.dnet.module.md.domain.impl.base.TaxCategory;

/**
 * Interface to expose business functions specific for {@link Tax} domain
 * entity.
 */
public interface ITaxService extends IEntityService<Tax> {

	/**
	 * Find by unique key
	 */
	public Tax findByName(String name);

	/**
	 * Find by reference: category
	 */
	public List<Tax> findByCategory(TaxCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<Tax> findByCategoryId(String categoryId);

	/**
	 * Find by reference: parentTax
	 */
	public List<Tax> findByParentTax(Tax parentTax);

	/**
	 * Find by ID of reference: parentTax.id
	 */
	public List<Tax> findByParentTaxId(String parentTaxId);

	/**
	 * Find by reference: children
	 */
	public List<Tax> findByChildren(Tax children);

	/**
	 * Find by ID of reference: children.id
	 */
	public List<Tax> findByChildrenId(String childrenId);
}
