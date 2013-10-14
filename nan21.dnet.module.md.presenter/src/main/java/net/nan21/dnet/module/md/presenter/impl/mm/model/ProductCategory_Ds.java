/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.mm.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;

@Ds(entity = ProductCategory.class, sort = {@SortField(field = ProductCategory_Ds.f_code)})
public class ProductCategory_Ds extends AbstractTypeWithCodeDs<ProductCategory> {

	public static final String f_folder = "folder";
	public static final String f_iconUrl = "iconUrl";
	public static final String f_iconLocation = "iconLocation";

	@DsField
	private Boolean folder;

	@DsField
	private String iconUrl;

	@DsField(fetch = false)
	private String iconLocation;

	public ProductCategory_Ds() {
		super();
	}

	public ProductCategory_Ds(ProductCategory e) {
		super(e);
	}

	public Boolean getFolder() {
		return this.folder;
	}

	public void setFolder(Boolean folder) {
		this.folder = folder;
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getIconLocation() {
		return this.iconLocation;
	}

	public void setIconLocation(String iconLocation) {
		this.iconLocation = iconLocation;
	}
}
