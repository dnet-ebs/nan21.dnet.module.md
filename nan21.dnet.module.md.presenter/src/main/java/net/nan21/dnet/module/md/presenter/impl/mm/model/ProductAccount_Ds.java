/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.mm.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.md.domain.impl.mm.Product;
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccount;
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccountType;
import net.nan21.dnet.module.md.domain.impl.org.Org;

@Ds(entity = ProductAccount.class)
@RefLookups({
		@RefLookup(refId = ProductAccount_Ds.f_companyId, namedQuery = Org.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = ProductAccount_Ds.f_company)}),
		@RefLookup(refId = ProductAccount_Ds.f_typeId, namedQuery = ProductAccountType.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = ProductAccount_Ds.f_type)}),
		@RefLookup(refId = ProductAccount_Ds.f_productId, namedQuery = Product.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = ProductAccount_Ds.f_product)})})
public class ProductAccount_Ds extends AbstractAuditableDs<ProductAccount> {

	public static final String f_analiticSegment = "analiticSegment";
	public static final String f_companyId = "companyId";
	public static final String f_company = "company";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_purchase = "purchase";
	public static final String f_sale = "sale";
	public static final String f_inventory = "inventory";
	public static final String f_productId = "productId";
	public static final String f_product = "product";
	public static final String f_productName = "productName";

	@DsField
	private String analiticSegment;

	@DsField(join = "left", path = "company.id")
	private String companyId;

	@DsField(join = "left", path = "company.code")
	private String company;

	@DsField(join = "left", path = "type.id")
	private String typeId;

	@DsField(join = "left", path = "type.code")
	private String type;

	@DsField(join = "left", path = "type.purchase")
	private Boolean purchase;

	@DsField(join = "left", path = "type.sale")
	private Boolean sale;

	@DsField(join = "left", path = "type.inventory")
	private Boolean inventory;

	@DsField(join = "left", path = "product.id")
	private String productId;

	@DsField(join = "left", path = "product.code")
	private String product;

	@DsField(join = "left", path = "product.name")
	private String productName;

	public ProductAccount_Ds() {
		super();
	}

	public ProductAccount_Ds(ProductAccount e) {
		super(e);
	}

	public String getAnaliticSegment() {
		return this.analiticSegment;
	}

	public void setAnaliticSegment(String analiticSegment) {
		this.analiticSegment = analiticSegment;
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

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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
}
