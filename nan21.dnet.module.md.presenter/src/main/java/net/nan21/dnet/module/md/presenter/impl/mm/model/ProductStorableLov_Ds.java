/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.mm.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.mm.Product;

@Ds(entity = Product.class, jpqlWhere = " e.storable = true ", sort = {@SortField(field = ProductStorableLov_Ds.f_code)})
public class ProductStorableLov_Ds extends AbstractTypeWithCodeLov<Product> {

	public ProductStorableLov_Ds() {
		super();
	}

	public ProductStorableLov_Ds(Product e) {
		super(e);
	}
}
