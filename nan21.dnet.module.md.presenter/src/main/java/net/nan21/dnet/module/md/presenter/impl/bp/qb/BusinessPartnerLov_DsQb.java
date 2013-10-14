/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.qb;

import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.md.presenter.impl.bp.model.BusinessPartnerLov_Ds;
import net.nan21.dnet.module.md.presenter.impl.bp.model.BusinessPartnerLov_DsParam;

import net.nan21.dnet.core.api.session.Session;

public class BusinessPartnerLov_DsQb
		extends
			QueryBuilderWithJpql<BusinessPartnerLov_Ds, BusinessPartnerLov_Ds, BusinessPartnerLov_DsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null
				&& this.params.getCompanyIdForNewBpAccount() != null
				&& !"".equals(this.params.getCompanyIdForNewBpAccount())) {
			addFilterCondition("  e.id not in (select a.bpartner.id from BpAccount a where a.company.id = :companyIdForNewBpAccount) ");
			addCustomFilterItem("companyIdForNewBpAccount",
					this.params.getCompanyIdForNewBpAccount());
		}
	}
}
