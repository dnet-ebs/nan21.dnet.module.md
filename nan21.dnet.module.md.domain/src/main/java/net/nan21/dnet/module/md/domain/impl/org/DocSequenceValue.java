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
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.md.domain.impl.org.DocSequence;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Document sequence extracted values.
 */
@NamedQueries({
		@NamedQuery(name = DocSequenceValue.NQ_FIND_BY_VALUE, query = "SELECT e FROM DocSequenceValue e WHERE e.clientId = :clientId and e.docSequence = :docSequence and e.value = :value", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = DocSequenceValue.NQ_FIND_BY_VALUE_PRIMITIVE, query = "SELECT e FROM DocSequenceValue e WHERE e.clientId = :clientId and e.docSequence.id = :docSequenceId and e.value = :value", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = DocSequenceValue.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = DocSequenceValue.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "DOCSEQUENCE_ID", "VALUE"})})
public class DocSequenceValue extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_DOC_SEQ_VAL";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Value.
	 */
	public static final String NQ_FIND_BY_VALUE = "DocSequenceValue.findByValue";
	/**
	 * Named query find by unique key: Value using the ID field for references.
	 */
	public static final String NQ_FIND_BY_VALUE_PRIMITIVE = "DocSequenceValue.findByValue_PRIMITIVE";

	@NotNull
	@Column(name = "NUMERICVALUE", nullable = false, precision = 8)
	private Integer numericValue;

	@NotBlank
	@Column(name = "VALUE", nullable = false, length = 255)
	private String value;

	@NotNull
	@Column(name = "USED", nullable = false)
	private Boolean used;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DocSequence.class)
	@JoinColumn(name = "DOCSEQUENCE_ID", referencedColumnName = "ID")
	private DocSequence docSequence;

	public Integer getNumericValue() {
		return this.numericValue;
	}

	public void setNumericValue(Integer numericValue) {
		this.numericValue = numericValue;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getUsed() {
		return this.used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	public DocSequence getDocSequence() {
		return this.docSequence;
	}

	public void setDocSequence(DocSequence docSequence) {
		if (docSequence != null) {
			this.__validate_client_context__(docSequence.getClientId());
		}
		this.docSequence = docSequence;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.used == null) {
			this.used = new Boolean(false);
		}
	}
}
