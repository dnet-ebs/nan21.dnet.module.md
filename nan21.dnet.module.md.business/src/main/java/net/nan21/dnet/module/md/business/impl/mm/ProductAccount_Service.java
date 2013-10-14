/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.mm;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.mm.IProductAccountService;
import net.nan21.dnet.module.md.domain.impl.mm.Product;
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccount;
import net.nan21.dnet.module.md.domain.impl.mm.ProductAccountType;
import net.nan21.dnet.module.md.domain.impl.org.Org;

/**
 * Repository functionality for {@link ProductAccount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductAccount_Service
		extends
			AbstractEntityService<ProductAccount>
		implements
			IProductAccountService {

	public ProductAccount_Service() {
		super();
	}

	public ProductAccount_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductAccount> getEntityClass() {
		return ProductAccount.class;
	}
	/**
	 * Find by unique key
	 */
	public ProductAccount findByProd_org(Product product, Org company) {
		return (ProductAccount) this
				.getEntityManager()
				.createNamedQuery(ProductAccount.NQ_FIND_BY_PROD_ORG)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("product", product)
				.setParameter("company", company).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public ProductAccount findByProd_org(Long productId, Long companyId) {
		return (ProductAccount) this
				.getEntityManager()
				.createNamedQuery(ProductAccount.NQ_FIND_BY_PROD_ORG_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("productId", productId)
				.setParameter("companyId", companyId).getSingleResult();
	}
	/**
	 * Find by reference: company
	 */
	public List<ProductAccount> findByCompany(Org company) {
		return this.findByCompanyId(company.getId());
	}
	/**
	 * Find by ID of reference: company.id
	 */
	public List<ProductAccount> findByCompanyId(String companyId) {
		return (List<ProductAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAccount e where e.clientId = :clientId and e.company.id = :companyId",
						ProductAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("companyId", companyId).getResultList();
	}
	/**
	 * Find by reference: type
	 */
	public List<ProductAccount> findByType(ProductAccountType type) {
		return this.findByTypeId(type.getId());
	}
	/**
	 * Find by ID of reference: type.id
	 */
	public List<ProductAccount> findByTypeId(String typeId) {
		return (List<ProductAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAccount e where e.clientId = :clientId and e.type.id = :typeId",
						ProductAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("typeId", typeId).getResultList();
	}
	/**
	 * Find by reference: product
	 */
	public List<ProductAccount> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}
	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProductAccount> findByProductId(String productId) {
		return (List<ProductAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAccount e where e.clientId = :clientId and e.product.id = :productId",
						ProductAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("productId", productId).getResultList();
	}
}
