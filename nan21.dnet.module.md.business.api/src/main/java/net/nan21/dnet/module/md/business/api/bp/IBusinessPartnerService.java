/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.bp;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;
import net.nan21.dnet.module.md.domain.impl.bp.LegalForm;

/**
 * Interface to expose business functions specific for {@link BusinessPartner} domain
 * entity.
 */
public interface IBusinessPartnerService
		extends
			IEntityService<BusinessPartner> {

	/**
	 * Find by unique key
	 */
	public BusinessPartner findByCode(String code);

	/**
	 * Find by reference: country
	 */
	public List<BusinessPartner> findByCountry(Country country);

	/**
	 * Find by ID of reference: country.id
	 */
	public List<BusinessPartner> findByCountryId(String countryId);

	/**
	 * Find by reference: legalForm
	 */
	public List<BusinessPartner> findByLegalForm(LegalForm legalForm);

	/**
	 * Find by ID of reference: legalForm.id
	 */
	public List<BusinessPartner> findByLegalFormId(String legalFormId);
}
