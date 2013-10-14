/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.bp;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.bp.IBpAccountService;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;
import net.nan21.dnet.module.md.domain.impl.bp.BpAccount;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;
import net.nan21.dnet.module.md.domain.impl.bp.CustomerGroup;
import net.nan21.dnet.module.md.domain.impl.bp.VendorGroup;
import net.nan21.dnet.module.md.domain.impl.org.Org;

/**
 * Repository functionality for {@link BpAccount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BpAccount_Service extends AbstractEntityService<BpAccount>
		implements
			IBpAccountService {

	public BpAccount_Service() {
		super();
	}

	public BpAccount_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BpAccount> getEntityClass() {
		return BpAccount.class;
	}
	/**
	 * Find by unique key
	 */
	public BpAccount findByOrg_bp(Org company, BusinessPartner bpartner) {
		return (BpAccount) this
				.getEntityManager()
				.createNamedQuery(BpAccount.NQ_FIND_BY_ORG_BP)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("company", company)
				.setParameter("bpartner", bpartner).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public BpAccount findByOrg_bp(Long companyId, Long bpartnerId) {
		return (BpAccount) this
				.getEntityManager()
				.createNamedQuery(BpAccount.NQ_FIND_BY_ORG_BP_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("companyId", companyId)
				.setParameter("bpartnerId", bpartnerId).getSingleResult();
	}
	/**
	 * Find by reference: bpartner
	 */
	public List<BpAccount> findByBpartner(BusinessPartner bpartner) {
		return this.findByBpartnerId(bpartner.getId());
	}
	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<BpAccount> findByBpartnerId(String bpartnerId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :clientId and e.bpartner.id = :bpartnerId",
						BpAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bpartnerId", bpartnerId).getResultList();
	}
	/**
	 * Find by reference: company
	 */
	public List<BpAccount> findByCompany(Org company) {
		return this.findByCompanyId(company.getId());
	}
	/**
	 * Find by ID of reference: company.id
	 */
	public List<BpAccount> findByCompanyId(String companyId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :clientId and e.company.id = :companyId",
						BpAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("companyId", companyId).getResultList();
	}
	/**
	 * Find by reference: custGroup
	 */
	public List<BpAccount> findByCustGroup(CustomerGroup custGroup) {
		return this.findByCustGroupId(custGroup.getId());
	}
	/**
	 * Find by ID of reference: custGroup.id
	 */
	public List<BpAccount> findByCustGroupId(String custGroupId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :clientId and e.custGroup.id = :custGroupId",
						BpAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("custGroupId", custGroupId).getResultList();
	}
	/**
	 * Find by reference: custPaymentMethod
	 */
	public List<BpAccount> findByCustPaymentMethod(DocType custPaymentMethod) {
		return this.findByCustPaymentMethodId(custPaymentMethod.getId());
	}
	/**
	 * Find by ID of reference: custPaymentMethod.id
	 */
	public List<BpAccount> findByCustPaymentMethodId(String custPaymentMethodId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :clientId and e.custPaymentMethod.id = :custPaymentMethodId",
						BpAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("custPaymentMethodId", custPaymentMethodId)
				.getResultList();
	}
	/**
	 * Find by reference: custPaymentTerm
	 */
	public List<BpAccount> findByCustPaymentTerm(PaymentTerm custPaymentTerm) {
		return this.findByCustPaymentTermId(custPaymentTerm.getId());
	}
	/**
	 * Find by ID of reference: custPaymentTerm.id
	 */
	public List<BpAccount> findByCustPaymentTermId(String custPaymentTermId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :clientId and e.custPaymentTerm.id = :custPaymentTermId",
						BpAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("custPaymentTermId", custPaymentTermId)
				.getResultList();
	}
	/**
	 * Find by reference: vendGroup
	 */
	public List<BpAccount> findByVendGroup(VendorGroup vendGroup) {
		return this.findByVendGroupId(vendGroup.getId());
	}
	/**
	 * Find by ID of reference: vendGroup.id
	 */
	public List<BpAccount> findByVendGroupId(String vendGroupId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :clientId and e.vendGroup.id = :vendGroupId",
						BpAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("vendGroupId", vendGroupId).getResultList();
	}
	/**
	 * Find by reference: vendPaymentMethod
	 */
	public List<BpAccount> findByVendPaymentMethod(DocType vendPaymentMethod) {
		return this.findByVendPaymentMethodId(vendPaymentMethod.getId());
	}
	/**
	 * Find by ID of reference: vendPaymentMethod.id
	 */
	public List<BpAccount> findByVendPaymentMethodId(String vendPaymentMethodId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :clientId and e.vendPaymentMethod.id = :vendPaymentMethodId",
						BpAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("vendPaymentMethodId", vendPaymentMethodId)
				.getResultList();
	}
	/**
	 * Find by reference: vendPaymentTerm
	 */
	public List<BpAccount> findByVendPaymentTerm(PaymentTerm vendPaymentTerm) {
		return this.findByVendPaymentTermId(vendPaymentTerm.getId());
	}
	/**
	 * Find by ID of reference: vendPaymentTerm.id
	 */
	public List<BpAccount> findByVendPaymentTermId(String vendPaymentTermId) {
		return (List<BpAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpAccount e where e.clientId = :clientId and e.vendPaymentTerm.id = :vendPaymentTermId",
						BpAccount.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("vendPaymentTermId", vendPaymentTermId)
				.getResultList();
	}
}
