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
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.md.business.api.bp.ILegalFormService;
import net.nan21.dnet.module.md.domain.impl.bp.LegalForm;

/**
 * Repository functionality for {@link LegalForm} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class LegalForm_Service extends AbstractEntityService<LegalForm>
		implements
			ILegalFormService {

	public LegalForm_Service() {
		super();
	}

	public LegalForm_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<LegalForm> getEntityClass() {
		return LegalForm.class;
	}
	/**
	 * Find by unique key
	 */
	public LegalForm findByCode(Country country, String code) {
		return (LegalForm) this
				.getEntityManager()
				.createNamedQuery(LegalForm.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("country", country).setParameter("code", code)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public LegalForm findByCode(Long countryId, String code) {
		return (LegalForm) this
				.getEntityManager()
				.createNamedQuery(LegalForm.NQ_FIND_BY_CODE_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("countryId", countryId)
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public LegalForm findByName(Country country, String name) {
		return (LegalForm) this
				.getEntityManager()
				.createNamedQuery(LegalForm.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("country", country).setParameter("name", name)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public LegalForm findByName(Long countryId, String name) {
		return (LegalForm) this
				.getEntityManager()
				.createNamedQuery(LegalForm.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("countryId", countryId)
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: country
	 */
	public List<LegalForm> findByCountry(Country country) {
		return this.findByCountryId(country.getId());
	}
	/**
	 * Find by ID of reference: country.id
	 */
	public List<LegalForm> findByCountryId(String countryId) {
		return (List<LegalForm>) this
				.getEntityManager()
				.createQuery(
						"select e from LegalForm e where e.clientId = :clientId and e.country.id = :countryId",
						LegalForm.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("countryId", countryId).getResultList();
	}
}
