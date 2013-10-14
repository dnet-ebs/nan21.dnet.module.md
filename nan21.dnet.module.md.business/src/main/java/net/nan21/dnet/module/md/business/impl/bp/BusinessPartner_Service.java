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
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;
import net.nan21.dnet.module.md.domain.impl.bp.LegalForm;

/**
 * Repository functionality for {@link BusinessPartner} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BusinessPartner_Service
		extends
			AbstractEntityService<BusinessPartner> {

	public BusinessPartner_Service() {
		super();
	}

	public BusinessPartner_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BusinessPartner> getEntityClass() {
		return BusinessPartner.class;
	}
	/**
	 * Find by unique key
	 */
	public BusinessPartner findByCode(String code) {
		return (BusinessPartner) this
				.getEntityManager()
				.createNamedQuery(BusinessPartner.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by reference: country
	 */
	public List<BusinessPartner> findByCountry(Country country) {
		return this.findByCountryId(country.getId());
	}
	/**
	 * Find by ID of reference: country.id
	 */
	public List<BusinessPartner> findByCountryId(String countryId) {
		return (List<BusinessPartner>) this
				.getEntityManager()
				.createQuery(
						"select e from BusinessPartner e where e.clientId = :clientId and e.country.id = :countryId",
						BusinessPartner.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("countryId", countryId).getResultList();
	}
	/**
	 * Find by reference: legalForm
	 */
	public List<BusinessPartner> findByLegalForm(LegalForm legalForm) {
		return this.findByLegalFormId(legalForm.getId());
	}
	/**
	 * Find by ID of reference: legalForm.id
	 */
	public List<BusinessPartner> findByLegalFormId(String legalFormId) {
		return (List<BusinessPartner>) this
				.getEntityManager()
				.createQuery(
						"select e from BusinessPartner e where e.clientId = :clientId and e.legalForm.id = :legalFormId",
						BusinessPartner.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("legalFormId", legalFormId).getResultList();
	}
}
