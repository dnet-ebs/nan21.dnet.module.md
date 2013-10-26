/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractType;
import net.nan21.dnet.module.md.domain.impl.base.Tax;
import net.nan21.dnet.module.md.domain.impl.base.TaxCategory;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Tax definition.
 */
@NamedQueries({@NamedQuery(name = Tax.NQ_FIND_BY_NAME, query = "SELECT e FROM Tax e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Tax.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = Tax.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class Tax extends AbstractType {

	public static final String TABLE_NAME = "MD_TAX";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Tax.findByName";

	@NotNull
	@Column(name = "RATE", nullable = false, precision = 21, scale = 6)
	private BigDecimal rate;

	@NotNull
	@Column(name = "SUMMARY", nullable = false)
	private Boolean summary;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = TaxCategory.class)
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
	private TaxCategory category;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Tax.class)
	@JoinColumn(name = "PARENTTAX_ID", referencedColumnName = "ID")
	private Tax parentTax;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Tax.class, mappedBy = "parentTax")
	private Collection<Tax> children;

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Boolean getSummary() {
		return this.summary;
	}

	public void setSummary(Boolean summary) {
		this.summary = summary;
	}

	public TaxCategory getCategory() {
		return this.category;
	}

	public void setCategory(TaxCategory category) {
		if (category != null) {
			this.__validate_client_context__(category.getClientId());
		}
		this.category = category;
	}

	public Tax getParentTax() {
		return this.parentTax;
	}

	public void setParentTax(Tax parentTax) {
		if (parentTax != null) {
			this.__validate_client_context__(parentTax.getClientId());
		}
		this.parentTax = parentTax;
	}

	public Collection<Tax> getChildren() {
		return this.children;
	}

	public void setChildren(Collection<Tax> children) {
		this.children = children;
	}

	public void addToChildren(Tax e) {
		if (this.children == null) {
			this.children = new ArrayList<Tax>();
		}
		e.setParentTax(this);
		this.children.add(e);
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.summary == null) {
			this.summary = new Boolean(false);
		}
	}
}
