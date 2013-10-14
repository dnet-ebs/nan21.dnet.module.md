/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractType;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Payment term definition
 */
@NamedQueries({@NamedQuery(name = PaymentTerm.NQ_FIND_BY_NAME, query = "SELECT e FROM PaymentTerm e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = PaymentTerm.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = PaymentTerm.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class PaymentTerm extends AbstractType {

	public static final String TABLE_NAME = "MD_PAY_TERM";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "PaymentTerm.findByName";

	@NotNull
	@Column(name = "DAYS", nullable = false, precision = 4)
	private Integer days;

	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
