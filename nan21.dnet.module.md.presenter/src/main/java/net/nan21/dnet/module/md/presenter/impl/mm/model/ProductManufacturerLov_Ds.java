/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.mm.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.mm.ProductManufacturer;

@Ds(entity = ProductManufacturer.class, sort = {@SortField(field = ProductManufacturerLov_Ds.f_code)})
public class ProductManufacturerLov_Ds
		extends
			AbstractTypeWithCodeLov<ProductManufacturer> {

	public ProductManufacturerLov_Ds() {
		super();
	}

	public ProductManufacturerLov_Ds(ProductManufacturer e) {
		super(e);
	}
}
