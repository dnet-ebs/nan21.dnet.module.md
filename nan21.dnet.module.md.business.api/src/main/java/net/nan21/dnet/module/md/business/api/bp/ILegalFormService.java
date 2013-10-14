/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.bp;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.md.domain.impl.bp.LegalForm;

/**
 * Interface to expose business functions specific for {@link LegalForm} domain
 * entity.
 */
public interface ILegalFormService extends IEntityService<LegalForm> {

	/**
	 * Find by unique key
	 */
	public LegalForm findByCode(Country country, String code);

	/**
	 * Find by unique key
	 */
	public LegalForm findByCode(Long countryId, String code);

	/**
	 * Find by unique key
	 */
	public LegalForm findByName(Country country, String name);

	/**
	 * Find by unique key
	 */
	public LegalForm findByName(Long countryId, String name);

	/**
	 * Find by reference: country
	 */
	public List<LegalForm> findByCountry(Country country);

	/**
	 * Find by ID of reference: country.id
	 */
	public List<LegalForm> findByCountryId(String countryId);
}
