/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.ext.mm.service;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.business.api.mm.IProductCategoryService;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;

/**
 * Business extensions specific for {@link ProductCategory} domain entity.
 * 
 */
public class ProductCategory_Service extends
		net.nan21.dnet.module.md.business.impl.mm.ProductCategory_Service
		implements IProductCategoryService {

	@Override
	protected void preInsert(ProductCategory e) throws BusinessException {
		this.preSave(e);
		super.preInsert(e);
	}

	@Override
	protected void preUpdate(ProductCategory e) throws BusinessException {
		this.preSave(e);
		super.preUpdate(e);
	}

	protected void preSave(ProductCategory e) throws BusinessException {
		if (e.getCategory() != null && e.getId() != null) {
			if (e.getId().equals(e.getCategory().getId())) {
				throw new BusinessException(
						"Cannot attach itself as parent category");
			}
		}
	}

}
