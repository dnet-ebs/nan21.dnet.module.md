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
import net.nan21.dnet.module.md.business.api.bp.IVendorGroupService;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;
import net.nan21.dnet.module.md.domain.impl.bp.VendorGroup;

/**
 * Repository functionality for {@link VendorGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class VendorGroup_Service extends AbstractEntityService<VendorGroup>
		implements
			IVendorGroupService {

	public VendorGroup_Service() {
		super();
	}

	public VendorGroup_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<VendorGroup> getEntityClass() {
		return VendorGroup.class;
	}
	/**
	 * Find by unique key
	 */
	public VendorGroup findByCode(String code) {
		return (VendorGroup) this
				.getEntityManager()
				.createNamedQuery(VendorGroup.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public VendorGroup findByName(String name) {
		return (VendorGroup) this
				.getEntityManager()
				.createNamedQuery(VendorGroup.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: paymentMethod
	 */
	public List<VendorGroup> findByPaymentMethod(DocType paymentMethod) {
		return this.findByPaymentMethodId(paymentMethod.getId());
	}
	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<VendorGroup> findByPaymentMethodId(String paymentMethodId) {
		return (List<VendorGroup>) this
				.getEntityManager()
				.createQuery(
						"select e from VendorGroup e where e.clientId = :clientId and e.paymentMethod.id = :paymentMethodId",
						VendorGroup.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("paymentMethodId", paymentMethodId)
				.getResultList();
	}
	/**
	 * Find by reference: paymentTerm
	 */
	public List<VendorGroup> findByPaymentTerm(PaymentTerm paymentTerm) {
		return this.findByPaymentTermId(paymentTerm.getId());
	}
	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<VendorGroup> findByPaymentTermId(String paymentTermId) {
		return (List<VendorGroup>) this
				.getEntityManager()
				.createQuery(
						"select e from VendorGroup e where e.clientId = :clientId and e.paymentTerm.id = :paymentTermId",
						VendorGroup.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("paymentTermId", paymentTermId).getResultList();
	}
}
