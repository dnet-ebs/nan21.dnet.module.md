/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.org;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractType;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.org.Org;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 * Document auto-numbering sequence definitions.
 */
@Entity
@Table(name = DocSequence.TABLE_NAME)
public class DocSequence extends AbstractType {

	public static final String TABLE_NAME = "MD_DOC_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotNull
	@Column(name = "FIRSTNO", nullable = false, precision = 8)
	private Integer firstNo;

	@NotNull
	@Column(name = "LASTNO", nullable = false, precision = 8)
	private Integer lastNo;

	@Column(name = "INCREMENTBY", precision = 2)
	private Integer incrementBy;

	@Column(name = "PREFIX", length = 4)
	private String prefix;

	@Column(name = "SUFFIX", length = 4)
	private String suffix;

	@Column(name = "PADDINGLENGTH", precision = 2)
	private Integer paddingLength;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DocType.class)
	@JoinColumn(name = "DOCTYPE_ID", referencedColumnName = "ID")
	private DocType docType;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Org.class)
	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
	private Org company;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = DocSequenceValue.class, mappedBy = "docSequence", cascade = CascadeType.REMOVE)
	@CascadeOnDelete
	private Collection<DocSequenceValue> values;

	public Integer getFirstNo() {
		return this.firstNo;
	}

	public void setFirstNo(Integer firstNo) {
		this.firstNo = firstNo;
	}

	public Integer getLastNo() {
		return this.lastNo;
	}

	public void setLastNo(Integer lastNo) {
		this.lastNo = lastNo;
	}

	public Integer getIncrementBy() {
		return this.incrementBy;
	}

	public void setIncrementBy(Integer incrementBy) {
		this.incrementBy = incrementBy;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Integer getPaddingLength() {
		return this.paddingLength;
	}

	public void setPaddingLength(Integer paddingLength) {
		this.paddingLength = paddingLength;
	}

	public DocType getDocType() {
		return this.docType;
	}

	public void setDocType(DocType docType) {
		if (docType != null) {
			this.__validate_client_context__(docType.getClientId());
		}
		this.docType = docType;
	}

	public Org getCompany() {
		return this.company;
	}

	public void setCompany(Org company) {
		if (company != null) {
			this.__validate_client_context__(company.getClientId());
		}
		this.company = company;
	}

	public Collection<DocSequenceValue> getValues() {
		return this.values;
	}

	public void setValues(Collection<DocSequenceValue> values) {
		this.values = values;
	}

	public void addToValues(DocSequenceValue e) {
		if (this.values == null) {
			this.values = new ArrayList<DocSequenceValue>();
		}
		e.setDocSequence(this);
		this.values.add(e);
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
