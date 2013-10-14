/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.org;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractType;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Organization hierarchies definition.
 * A hierarchy is valid within a period of time.
 */
@NamedQueries({@NamedQuery(name = OrgHierarchy.NQ_FIND_BY_NAME, query = "SELECT e FROM OrgHierarchy e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = OrgHierarchy.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = OrgHierarchy.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class OrgHierarchy extends AbstractType {

	public static final String TABLE_NAME = "MD_ORG_HRCHY";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "OrgHierarchy.findByName";

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", nullable = false)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE")
	private Date endDate;

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
