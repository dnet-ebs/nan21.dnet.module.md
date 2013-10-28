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
import net.nan21.dnet.module.md.domain.impl.mm.ProductSubstitute;

@Ds(entity = ProductSubstitute.class)
@RefLookups({
		@RefLookup(refId = ProductSubstitute_Ds.f_productId, namedQuery = Product.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = ProductSubstitute_Ds.f_product)}),
		@RefLookup(refId = ProductSubstitute_Ds.f_substituteId, namedQuery = Product.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = ProductSubstitute_Ds.f_substitute)})})
public class ProductSubstitute_Ds
		extends
			AbstractAuditableDs<ProductSubstitute> {

	public static final String f_productId = "productId";
	public static final String f_product = "product";
	public static final String f_productName = "productName";
	public static final String f_substituteId = "substituteId";
	public static final String f_substitute = "substitute";
	public static final String f_substituteName = "substituteName";

	@DsField(join = "left", path = "product.id")
	private String productId;

	@DsField(join = "left", path = "product.code")
	private String product;

	@DsField(join = "left", path = "product.name")
	private String productName;

	@DsField(join = "left", path = "substitute.id")
	private String substituteId;

	@DsField(join = "left", path = "substitute.code")
	private String substitute;

	@DsField(join = "left", path = "substitute.name")
	private String substituteName;

	public ProductSubstitute_Ds() {
		super();
	}

	public ProductSubstitute_Ds(ProductSubstitute e) {
		super(e);
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

	public String getSubstituteId() {
		return this.substituteId;
	}

	public void setSubstituteId(String substituteId) {
		this.substituteId = substituteId;
	}

	public String getSubstitute() {
		return this.substitute;
	}

	public void setSubstitute(String substitute) {
		this.substitute = substitute;
	}

	public String getSubstituteName() {
		return this.substituteName;
	}

	public void setSubstituteName(String substituteName) {
		this.substituteName = substituteName;
	}
}
