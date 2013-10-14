/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.org;

import javax.persistence.Column;
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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.md.domain.impl.org.OrgType;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Organizations definition. An organization can be anything from
 * legal entities to departments, warehouses, teams or external units.
 */
@NamedQueries({
		@NamedQuery(name = Org.NQ_FIND_BY_CODE, query = "SELECT e FROM Org e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Org.NQ_FIND_BY_NAME, query = "SELECT e FROM Org e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Org.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = Org.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = Org.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class Org extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_ORG";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Org.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Org.findByName";

	@NotNull
	@Column(name = "VALID", nullable = false)
	private Boolean valid;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = OrgType.class)
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
	private OrgType type;

	public Boolean getValid() {
		return this.valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public OrgType getType() {
		return this.type;
	}

	public void setType(OrgType type) {
		if (type != null) {
			this.__validate_client_context__(type.getClientId());
		}
		this.type = type;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.valid == null) {
			this.valid = new Boolean(false);
		}
	}
}
