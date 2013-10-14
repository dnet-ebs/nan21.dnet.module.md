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
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccountType;

@Ds(entity = ProductAccountType.class, sort = {@SortField(field = ProductAccountTypeLov_Ds.f_code)})
public class ProductAccountTypeLov_Ds
		extends
			AbstractTypeWithCodeLov<ProductAccountType> {

	public static final String f_purchase = "purchase";
	public static final String f_sale = "sale";
	public static final String f_inventory = "inventory";

	@DsField
	private Boolean purchase;

	@DsField
	private Boolean sale;

	@DsField
	private Boolean inventory;

	public ProductAccountTypeLov_Ds() {
		super();
	}

	public ProductAccountTypeLov_Ds(ProductAccountType e) {
		super(e);
	}

	public Boolean getPurchase() {
		return this.purchase;
	}

	public void setPurchase(Boolean purchase) {
		this.purchase = purchase;
	}

	public Boolean getSale() {
		return this.sale;
	}

	public void setSale(Boolean sale) {
		this.sale = sale;
	}

	public Boolean getInventory() {
		return this.inventory;
	}

	public void setInventory(Boolean inventory) {
		this.inventory = inventory;
	}
}
