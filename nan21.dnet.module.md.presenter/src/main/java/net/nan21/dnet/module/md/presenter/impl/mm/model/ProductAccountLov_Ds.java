/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.mm.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableLov;
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccount;

@Ds(entity = ProductAccount.class)
public class ProductAccountLov_Ds extends AbstractAuditableLov<ProductAccount> {

	public static final String f_active = "active";
	public static final String f_productId = "productId";
	public static final String f_product = "product";
	public static final String f_productName = "productName";
	public static final String f_uomId = "uomId";
	public static final String f_uom = "uom";
	public static final String f_companyId = "companyId";
	public static final String f_company = "company";
	public static final String f_purchase = "purchase";
	public static final String f_sale = "sale";
	public static final String f_inventory = "inventory";

	@DsField
	private Boolean active;

	@DsField(join = "left", path = "product.id")
	private String productId;

	@DsField(join = "left", path = "product.code")
	private String product;

	@DsField(join = "left", path = "product.name")
	private String productName;

	@DsField(join = "left", path = "product.defaultUom.id")
	private String uomId;

	@DsField(join = "left", path = "product.defaultUom.code")
	private String uom;

	@DsField(join = "left", path = "company.id")
	private String companyId;

	@DsField(join = "left", path = "company.code")
	private String company;

	@DsField(join = "left", path = "type.purchase")
	private Boolean purchase;

	@DsField(join = "left", path = "type.sale")
	private Boolean sale;

	@DsField(join = "left", path = "type.inventory")
	private Boolean inventory;

	public ProductAccountLov_Ds() {
		super();
	}

	public ProductAccountLov_Ds(ProductAccount e) {
		super(e);
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUomId() {
		return this.uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
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
