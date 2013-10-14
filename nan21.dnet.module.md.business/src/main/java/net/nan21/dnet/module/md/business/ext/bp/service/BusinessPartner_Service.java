/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.ext.bp.service;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.business.api.bp.IBusinessPartnerService;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;

/**
 * Business extensions specific for {@link BusinessPartner} domain entity.
 * 
 */
public class BusinessPartner_Service extends
		net.nan21.dnet.module.md.business.impl.bp.BusinessPartner_Service
		implements IBusinessPartnerService {

	@Override
	protected void preInsert(BusinessPartner e) throws BusinessException {
		this.preSave(e);
		super.preInsert(e);
	}

	@Override
	protected void preUpdate(BusinessPartner e) throws BusinessException {
		this.preSave(e);
		super.preUpdate(e);
	}

	protected void preSave(BusinessPartner e) throws BusinessException {
		if (e.getType() != null && e.getType().equals("company")) {
			e.setName(e.getCompanyName());
		} else if (e.getType() != null && e.getType().equals("person")) {
			StringBuffer sb = new StringBuffer(e.getLastName());
			if (e.getFirstName() != null) {
				sb.append(" " + e.getFirstName());
			}
			if (e.getMiddleName() != null) {
				sb.append(" " + e.getMiddleName());
			}
			e.setName(sb.toString());
		} else {
			throw new BusinessException("Invalid type `" + e.getType()
					+ "` for a BusinessPartner. Must be `company` or `person` ");
		}
	}
}
