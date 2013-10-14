/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.domain.impl.base.DocType;

@Ds(entity = DocType.class, sort = {@SortField(field = DocType_Ds.f_code)})
public class DocType_Ds extends AbstractTypeWithCodeDs<DocType> {

	public static final String f_category = "category";

	@DsField
	private String category;

	public DocType_Ds() {
		super();
	}

	public DocType_Ds(DocType e) {
		super(e);
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
