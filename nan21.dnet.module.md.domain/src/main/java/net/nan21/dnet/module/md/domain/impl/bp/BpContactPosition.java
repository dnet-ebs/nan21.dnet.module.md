/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.bp;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractType;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Position/Role of a business partner contact.
 */
@NamedQueries({@NamedQuery(name = BpContactPosition.NQ_FIND_BY_NAME, query = "SELECT e FROM BpContactPosition e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = BpContactPosition.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = BpContactPosition.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class BpContactPosition extends AbstractType {

	public static final String TABLE_NAME = "MD_BP_CNTC_POS";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "BpContactPosition.findByName";

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
