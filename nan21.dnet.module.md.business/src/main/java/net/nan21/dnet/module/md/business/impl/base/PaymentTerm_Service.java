/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.base;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.base.IPaymentTermService;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;

/**
 * Repository functionality for {@link PaymentTerm} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PaymentTerm_Service extends AbstractEntityService<PaymentTerm>
		implements
			IPaymentTermService {

	public PaymentTerm_Service() {
		super();
	}

	public PaymentTerm_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PaymentTerm> getEntityClass() {
		return PaymentTerm.class;
	}
	/**
	 * Find by unique key
	 */
	public PaymentTerm findByName(String name) {
		return (PaymentTerm) this
				.getEntityManager()
				.createNamedQuery(PaymentTerm.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
