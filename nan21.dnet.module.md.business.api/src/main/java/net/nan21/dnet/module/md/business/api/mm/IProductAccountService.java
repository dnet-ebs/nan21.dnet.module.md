/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.mm;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.mm.Product;
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccount;
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccountType;
import net.nan21.dnet.module.md.domain.impl.org.Org;

/**
 * Interface to expose business functions specific for {@link ProductAccount} domain
 * entity.
 */
public interface IProductAccountService extends IEntityService<ProductAccount> {

	/**
	 * Find by unique key
	 */
	public ProductAccount findByProd_org(Product product, Org company);

	/**
	 * Find by unique key
	 */
	public ProductAccount findByProd_org(Long productId, Long companyId);

	/**
	 * Find by reference: company
	 */
	public List<ProductAccount> findByCompany(Org company);

	/**
	 * Find by ID of reference: company.id
	 */
	public List<ProductAccount> findByCompanyId(String companyId);

	/**
	 * Find by reference: type
	 */
	public List<ProductAccount> findByType(ProductAccountType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<ProductAccount> findByTypeId(String typeId);

	/**
	 * Find by reference: product
	 */
	public List<ProductAccount> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProductAccount> findByProductId(String productId);
}
