/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.md.domain.impl.bp.LegalForm;

@Ds(entity = LegalForm.class, sort = {@SortField(field = LegalForm_Ds.f_code)})
@RefLookups({@RefLookup(refId = LegalForm_Ds.f_countryId, namedQuery = Country.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = LegalForm_Ds.f_country)})})
public class LegalForm_Ds extends AbstractTypeWithCodeDs<LegalForm> {

	public static final String f_countryId = "countryId";
	public static final String f_country = "country";

	@DsField(join = "left", path = "country.id")
	private String countryId;

	@DsField(join = "left", path = "country.code")
	private String country;

	public LegalForm_Ds() {
		super();
	}

	public LegalForm_Ds(LegalForm e) {
		super(e);
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
