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
import net.nan21.dnet.module.md.domain.impl.bp.BpContact;
import net.nan21.dnet.module.md.domain.impl.bp.BpContactPosition;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;

/**
 * Repository functionality for {@link BpContact} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BpContact_Service extends AbstractEntityService<BpContact> {

	public BpContact_Service() {
		super();
	}

	public BpContact_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BpContact> getEntityClass() {
		return BpContact.class;
	}
	/**
	 * Find by reference: bpartner
	 */
	public List<BpContact> findByBpartner(BusinessPartner bpartner) {
		return this.findByBpartnerId(bpartner.getId());
	}
	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<BpContact> findByBpartnerId(String bpartnerId) {
		return (List<BpContact>) this
				.getEntityManager()
				.createQuery(
						"select e from BpContact e where e.clientId = :clientId and e.bpartner.id = :bpartnerId",
						BpContact.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("bpartnerId", bpartnerId).getResultList();
	}
	/**
	 * Find by reference: position
	 */
	public List<BpContact> findByPosition(BpContactPosition position) {
		return this.findByPositionId(position.getId());
	}
	/**
	 * Find by ID of reference: position.id
	 */
	public List<BpContact> findByPositionId(String positionId) {
		return (List<BpContact>) this
				.getEntityManager()
				.createQuery(
						"select e from BpContact e where e.clientId = :clientId and e.position.id = :positionId",
						BpContact.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("positionId", positionId).getResultList();
	}
}
