/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.md.domain.impl.org.DocSequence;

@Ds(entity = DocSequence.class, sort = {@SortField(field = DocSequenceLov_Ds.f_name)})
public class DocSequenceLov_Ds extends AbstractTypeLov<DocSequence> {

	public DocSequenceLov_Ds() {
		super();
	}

	public DocSequenceLov_Ds(DocSequence e) {
		super(e);
	}
}
