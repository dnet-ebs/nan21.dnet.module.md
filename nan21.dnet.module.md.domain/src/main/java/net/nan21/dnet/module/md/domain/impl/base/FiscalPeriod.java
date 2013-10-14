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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractType;
import net.nan21.dnet.module.md.domain.impl.base.FiscalYear;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Fiscal periods definition.
 */
@NamedQueries({@NamedQuery(name = FiscalPeriod.NQ_FIND_BY_NAME, query = "SELECT e FROM FiscalPeriod e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = FiscalPeriod.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = FiscalPeriod.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class FiscalPeriod extends AbstractType {

	public static final String TABLE_NAME = "MD_PER_PRD";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "FiscalPeriod.findByName";

	@Column(name = "TYPE", length = 16)
	private String type;

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE")
	private Date endDate;

	@NotNull
	@Column(name = "POSTING", nullable = false)
	private Boolean posting;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = FiscalYear.class)
	@JoinColumn(name = "FISCALYEAR_ID", referencedColumnName = "ID")
	private FiscalYear fiscalYear;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public Boolean getPosting() {
		return this.posting;
	}

	public void setPosting(Boolean posting) {
		this.posting = posting;
	}

	public FiscalYear getFiscalYear() {
		return this.fiscalYear;
	}

	public void setFiscalYear(FiscalYear fiscalYear) {
		if (fiscalYear != null) {
			this.__validate_client_context__(fiscalYear.getClientId());
		}
		this.fiscalYear = fiscalYear;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.posting == null) {
			this.posting = new Boolean(false);
		}
	}
}
