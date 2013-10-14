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
import net.nan21.dnet.module.md.business.api.bp.ICustomerGroupService;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;
import net.nan21.dnet.module.md.domain.impl.bp.CustomerGroup;

/**
 * Repository functionality for {@link CustomerGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CustomerGroup_Service extends AbstractEntityService<CustomerGroup>
		implements
			ICustomerGroupService {

	public CustomerGroup_Service() {
		super();
	}

	public CustomerGroup_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CustomerGroup> getEntityClass() {
		return CustomerGroup.class;
	}
	/**
	 * Find by unique key
	 */
	public CustomerGroup findByCode(String code) {
		return (CustomerGroup) this
				.getEntityManager()
				.createNamedQuery(CustomerGroup.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public CustomerGroup findByName(String name) {
		return (CustomerGroup) this
				.getEntityManager()
				.createNamedQuery(CustomerGroup.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: paymentMethod
	 */
	public List<CustomerGroup> findByPaymentMethod(DocType paymentMethod) {
		return this.findByPaymentMethodId(paymentMethod.getId());
	}
	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<CustomerGroup> findByPaymentMethodId(String paymentMethodId) {
		return (List<CustomerGroup>) this
				.getEntityManager()
				.createQuery(
						"select e from CustomerGroup e where e.clientId = :clientId and e.paymentMethod.id = :paymentMethodId",
						CustomerGroup.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("paymentMethodId", paymentMethodId)
				.getResultList();
	}
	/**
	 * Find by reference: paymentTerm
	 */
	public List<CustomerGroup> findByPaymentTerm(PaymentTerm paymentTerm) {
		return this.findByPaymentTermId(paymentTerm.getId());
	}
	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<CustomerGroup> findByPaymentTermId(String paymentTermId) {
		return (List<CustomerGroup>) this
				.getEntityManager()
				.createQuery(
						"select e from CustomerGroup e where e.clientId = :clientId and e.paymentTerm.id = :paymentTermId",
						CustomerGroup.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("paymentTermId", paymentTermId).getResultList();
	}
}
