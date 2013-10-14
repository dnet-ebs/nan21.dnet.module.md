/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.bp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Legal entity types
 */
@NamedQueries({
		@NamedQuery(name = LegalForm.NQ_FIND_BY_CODE, query = "SELECT e FROM LegalForm e WHERE e.clientId = :clientId and e.country = :country and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = LegalForm.NQ_FIND_BY_CODE_PRIMITIVE, query = "SELECT e FROM LegalForm e WHERE e.clientId = :clientId and e.country.id = :countryId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = LegalForm.NQ_FIND_BY_NAME, query = "SELECT e FROM LegalForm e WHERE e.clientId = :clientId and e.country = :country and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = LegalForm.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM LegalForm e WHERE e.clientId = :clientId and e.country.id = :countryId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = LegalForm.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = LegalForm.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "COUNTRY_ID", "CODE"}),
		@UniqueConstraint(name = LegalForm.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "COUNTRY_ID", "NAME"})})
public class LegalForm extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_BP_LGL_FRM";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "LegalForm.findByCode";
	/**
	 * Named query find by unique key: Code using the ID field for references.
	 */
	public static final String NQ_FIND_BY_CODE_PRIMITIVE = "LegalForm.findByCode_PRIMITIVE";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "LegalForm.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "LegalForm.findByName_PRIMITIVE";

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
	private Country country;

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		if (country != null) {
			this.__validate_client_context__(country.getClientId());
		}
		this.country = country;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
