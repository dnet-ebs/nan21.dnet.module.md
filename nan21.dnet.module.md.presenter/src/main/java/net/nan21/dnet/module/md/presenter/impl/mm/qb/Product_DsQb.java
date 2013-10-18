/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.mm.qb;

import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.md.presenter.impl.mm.model.Product_Ds;
import net.nan21.dnet.module.md.presenter.impl.mm.model.Product_DsParam;

import net.nan21.dnet.core.api.session.Session;

public class Product_DsQb
		extends
			QueryBuilderWithJpql<Product_Ds, Product_Ds, Product_DsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getAttr1id() != null
				&& !"".equals(this.params.getAttr1id())) {
			addFilterCondition(" e.id in (select av.targetRefid from AttributeValue av join AttributeSetAttribute asa on av.setAttribute.id = asa.id where av.value like :attr1val and asa.attribute.id = :attr1id ) ");
			addCustomFilterItem("attr1id", this.params.getAttr1id());
			addCustomFilterItem("attr1val", this.params.getAttr1val());
		}
		if (this.params != null && this.params.getAttr2id() != null
				&& !"".equals(this.params.getAttr2id())) {
			addFilterCondition(" e.id in (select av.targetRefid from AttributeValue av join AttributeSetAttribute asa on av.setAttribute.id = asa.id where av.value like :attr2val and asa.attribute.id = :attr2id ) ");
			addCustomFilterItem("attr2id", this.params.getAttr2id());
			addCustomFilterItem("attr2val", this.params.getAttr2val());
		}
		if (this.params != null && this.params.getAttr3id() != null
				&& !"".equals(this.params.getAttr3id())) {
			addFilterCondition(" e.id in (select av.targetRefid from AttributeValue av join AttributeSetAttribute asa on av.setAttribute.id = asa.id where av.value like :attr3val and asa.attribute.id = :attr3id ) ");
			addCustomFilterItem("attr3id", this.params.getAttr3id());
			addCustomFilterItem("attr3val", this.params.getAttr3val());
		}
	}
}
