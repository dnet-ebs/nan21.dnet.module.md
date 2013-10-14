/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.base;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractType;
import net.nan21.dnet.module.md.domain.impl.base.Calendar;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Fiscal years definition.
 */
@NamedQueries({@NamedQuery(name = FiscalYear.NQ_FIND_BY_NAME, query = "SELECT e FROM FiscalYear e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = FiscalYear.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = FiscalYear.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class FiscalYear extends AbstractType {

	public static final String TABLE_NAME = "MD_PER_YEAR";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "FiscalYear.findByName";

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE")
	private Date endDate;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Calendar.class)
	@JoinColumn(name = "CALENDAR_ID", referencedColumnName = "ID")
	private Calendar calendar;

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

	public Calendar getCalendar() {
		return this.calendar;
	}

	public void setCalendar(Calendar calendar) {
		if (calendar != null) {
			this.__validate_client_context__(calendar.getClientId());
		}
		this.calendar = calendar;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
