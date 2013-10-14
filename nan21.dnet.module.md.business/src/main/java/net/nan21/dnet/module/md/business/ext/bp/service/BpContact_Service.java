/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.ext.bp.service;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.business.api.bp.IBpContactService;
import net.nan21.dnet.module.md.domain.impl.bp.BpContact;

/**
 * Business extensions specific for {@link BpContact} domain entity.
 * 
 */
public class BpContact_Service extends
		net.nan21.dnet.module.md.business.impl.bp.BpContact_Service implements
		IBpContactService {

	@Override
	protected void preInsert(BpContact e) throws BusinessException {
		this.preSave(e);
		super.preInsert(e);
	}

	@Override
	protected void preUpdate(BpContact e) throws BusinessException {
		this.preSave(e);
		super.preUpdate(e);
	}

	protected void preSave(BpContact e) {
		e.setName(e.getLastName() + " " + e.getFirstName());
	}
}
