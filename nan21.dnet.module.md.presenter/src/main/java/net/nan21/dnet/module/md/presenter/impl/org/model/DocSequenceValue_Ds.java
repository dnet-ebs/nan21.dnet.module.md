/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.md.domain.impl.org.DocSequenceValue;

@Ds(entity = DocSequenceValue.class)
public class DocSequenceValue_Ds extends AbstractAuditableDs<DocSequenceValue> {

	public static final String f_value = "value";
	public static final String f_used = "used";
	public static final String f_docSequenceId = "docSequenceId";

	@DsField
	private String value;

	@DsField
	private Boolean used;

	@DsField(join = "left", path = "docSequence.id")
	private String docSequenceId;

	public DocSequenceValue_Ds() {
		super();
	}

	public DocSequenceValue_Ds(DocSequenceValue e) {
		super(e);
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

	public String getDocSequenceId() {
		return this.docSequenceId;
	}

	public void setDocSequenceId(String docSequenceId) {
		this.docSequenceId = docSequenceId;
	}
}
