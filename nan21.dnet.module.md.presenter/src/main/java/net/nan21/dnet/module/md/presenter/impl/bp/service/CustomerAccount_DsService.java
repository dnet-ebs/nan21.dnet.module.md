/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.service;

import net.nan21.dnet.core.api.service.presenter.IDsService;
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.md.domain.impl.bp.BpAccount;
import net.nan21.dnet.module.md.presenter.impl.bp.model.CustomerAccount_Ds;
import net.nan21.dnet.module.md.presenter.impl.bp.model.CustomerAccount_DsFilter;

public class CustomerAccount_DsService
		extends
			AbstractEntityDsService<CustomerAccount_Ds, CustomerAccount_DsFilter, Object, BpAccount>
		implements
			IDsService<CustomerAccount_Ds, CustomerAccount_DsFilter, Object> {

	@Override
	public void preInsert(CustomerAccount_Ds ds, Object params) {
		ds.setCustomer(true);
	}

	@Override
	public void preUpdate(CustomerAccount_Ds ds, Object params) {
		ds.setCustomer(true);
	}
}
