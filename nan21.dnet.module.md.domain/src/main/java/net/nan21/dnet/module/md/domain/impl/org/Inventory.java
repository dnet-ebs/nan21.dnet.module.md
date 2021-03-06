/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.org;

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
import net.nan21.dnet.module.md.domain.impl.org.Org;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * 
 */
@NamedQueries({
		@NamedQuery(name = Inventory.NQ_FIND_BY_CODE, query = "SELECT e FROM Inventory e WHERE e.clientId = :clientId and e.org = :org and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Inventory.NQ_FIND_BY_CODE_PRIMITIVE, query = "SELECT e FROM Inventory e WHERE e.clientId = :clientId and e.org.id = :orgId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Inventory.NQ_FIND_BY_NAME, query = "SELECT e FROM Inventory e WHERE e.clientId = :clientId and e.org = :org and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Inventory.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM Inventory e WHERE e.clientId = :clientId and e.org.id = :orgId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Inventory.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = Inventory.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "ORG_ID", "CODE"}),
		@UniqueConstraint(name = Inventory.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "ORG_ID", "NAME"})})
public class Inventory extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_IVT";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Inventory.findByCode";
	/**
	 * Named query find by unique key: Code using the ID field for references.
	 */
	public static final String NQ_FIND_BY_CODE_PRIMITIVE = "Inventory.findByCode_PRIMITIVE";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Inventory.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "Inventory.findByName_PRIMITIVE";

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Org.class)
	@JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
	private Org org;

	public Org getOrg() {
		return this.org;
	}

	public void setOrg(Org org) {
		if (org != null) {
			this.__validate_client_context__(org.getClientId());
		}
		this.org = org;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
