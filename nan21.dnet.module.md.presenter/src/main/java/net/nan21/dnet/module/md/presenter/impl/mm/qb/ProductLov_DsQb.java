/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.mm.qb;

import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.md.presenter.impl.mm.model.ProductLov_Ds;
import net.nan21.dnet.module.md.presenter.impl.mm.model.ProductLov_DsParam;

import net.nan21.dnet.core.api.session.Session;

public class ProductLov_DsQb
		extends
			QueryBuilderWithJpql<ProductLov_Ds, ProductLov_Ds, ProductLov_DsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null
				&& this.params.getCompanyIdForNewProdAccount() != null
				&& !"".equals(this.params.getCompanyIdForNewProdAccount())) {
			addFilterCondition("  e.id not in (select a.product.id from ProductAccount a where a.company.id = :companyIdForNewProdAccount) ");
			addCustomFilterItem("companyIdForNewProdAccount",
					this.params.getCompanyIdForNewProdAccount());
		}
	}
}
