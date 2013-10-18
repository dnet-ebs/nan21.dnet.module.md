/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.mm.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;

@Ds(entity = ProductCategory.class, sort = {@SortField(field = ProductCategoryLov_Ds.f_code)})
public class ProductCategoryLov_Ds
		extends
			AbstractTypeWithCodeLov<ProductCategory> {

	public static final String f_folder = "folder";

	@DsField
	private Boolean folder;

	public ProductCategoryLov_Ds() {
		super();
	}

	public ProductCategoryLov_Ds(ProductCategory e) {
		super(e);
	}

	public Boolean getFolder() {
		return this.folder;
	}

	public void setFolder(Boolean folder) {
		this.folder = folder;
	}
}
