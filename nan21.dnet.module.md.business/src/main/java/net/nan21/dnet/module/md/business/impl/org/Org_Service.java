/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.org;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.org.IOrgService;
import net.nan21.dnet.module.md.domain.impl.org.Org;
import net.nan21.dnet.module.md.domain.impl.org.OrgType;

/**
 * Repository functionality for {@link Org} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Org_Service extends AbstractEntityService<Org>
		implements
			IOrgService {

	public Org_Service() {
		super();
	}

	public Org_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Org> getEntityClass() {
		return Org.class;
	}
	/**
	 * Find by unique key
	 */
	public Org findByCode(String code) {
		return (Org) this
				.getEntityManager()
				.createNamedQuery(Org.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Org findByName(String name) {
		return (Org) this
				.getEntityManager()
				.createNamedQuery(Org.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: type
	 */
	public List<Org> findByType(OrgType type) {
		return this.findByTypeId(type.getId());
	}
	/**
	 * Find by ID of reference: type.id
	 */
	public List<Org> findByTypeId(String typeId) {
		return (List<Org>) this
				.getEntityManager()
				.createQuery(
						"select e from Org e where e.clientId = :clientId and e.type.id = :typeId",
						Org.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("typeId", typeId).getResultList();
	}
	/**
	 * Find by reference: company
	 */
	public List<Org> findByCompany(Org company) {
		return this.findByCompanyId(company.getId());
	}
	/**
	 * Find by ID of reference: company.id
	 */
	public List<Org> findByCompanyId(String companyId) {
		return (List<Org>) this
				.getEntityManager()
				.createQuery(
						"select e from Org e where e.clientId = :clientId and e.company.id = :companyId",
						Org.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("companyId", companyId).getResultList();
	}
}
