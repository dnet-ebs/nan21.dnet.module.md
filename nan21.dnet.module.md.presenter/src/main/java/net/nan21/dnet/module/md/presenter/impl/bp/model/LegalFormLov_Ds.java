/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.bp.LegalForm;

@Ds(entity = LegalForm.class, sort = {@SortField(field = LegalFormLov_Ds.f_code)})
public class LegalFormLov_Ds extends AbstractTypeWithCodeLov<LegalForm> {

	public static final String f_countryId = "countryId";

	@DsField(join = "left", path = "country.id")
	private String countryId;

	public LegalFormLov_Ds() {
		super();
	}

	public LegalFormLov_Ds(LegalForm e) {
		super(e);
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
}
