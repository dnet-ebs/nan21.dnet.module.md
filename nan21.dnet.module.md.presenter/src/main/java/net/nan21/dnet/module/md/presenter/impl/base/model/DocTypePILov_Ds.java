/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.base.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.domain.impl.base.DocType;

@Ds(entity = DocType.class, jpqlWhere = " e.active=true and e.category = 'purchase-invoice' ", sort = {@SortField(field = DocTypePILov_Ds.f_code)})
public class DocTypePILov_Ds extends AbstractTypeWithCodeLov<DocType> {

	public static final String f_category = "category";

	@DsField
	private String category;

	public DocTypePILov_Ds() {
		super();
	}

	public DocTypePILov_Ds(DocType e) {
		super(e);
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
