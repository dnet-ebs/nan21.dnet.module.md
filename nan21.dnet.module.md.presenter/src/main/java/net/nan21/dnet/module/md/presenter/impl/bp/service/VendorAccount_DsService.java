/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.service;

import net.nan21.dnet.core.api.service.presenter.IDsService;
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.md.domain.impl.bp.BpAccount;
import net.nan21.dnet.module.md.presenter.impl.bp.model.VendorAccount_Ds;
import net.nan21.dnet.module.md.presenter.impl.bp.model.VendorAccount_DsFilter;

public class VendorAccount_DsService
		extends
			AbstractEntityDsService<VendorAccount_Ds, VendorAccount_DsFilter, Object, BpAccount>
		implements
			IDsService<VendorAccount_Ds, VendorAccount_DsFilter, Object> {

	@Override
	public void preInsert(VendorAccount_Ds ds, Object params) {
		ds.setVendor(true);
	}

	@Override
	public void preUpdate(VendorAccount_Ds ds, Object params) {
		ds.setVendor(true);
	}
}
