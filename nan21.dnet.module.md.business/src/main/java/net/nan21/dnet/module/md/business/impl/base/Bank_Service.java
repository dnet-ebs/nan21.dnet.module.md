/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.base;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.base.IBankService;
import net.nan21.dnet.module.md.domain.impl.base.Bank;

/**
 * Repository functionality for {@link Bank} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Bank_Service extends AbstractEntityService<Bank>
		implements
			IBankService {

	public Bank_Service() {
		super();
	}

	public Bank_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Bank> getEntityClass() {
		return Bank.class;
	}
	/**
	 * Find by unique key
	 */
	public Bank findByCode(String code) {
		return (Bank) this
				.getEntityManager()
				.createNamedQuery(Bank.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Bank findByName(String name) {
		return (Bank) this
				.getEntityManager()
				.createNamedQuery(Bank.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
}
