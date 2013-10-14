/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.bp;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.bp.BpContact;
import net.nan21.dnet.module.md.domain.impl.bp.BpContactPosition;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;

/**
 * Interface to expose business functions specific for {@link BpContact} domain
 * entity.
 */
public interface IBpContactService extends IEntityService<BpContact> {

	/**
	 * Find by reference: bpartner
	 */
	public List<BpContact> findByBpartner(BusinessPartner bpartner);

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<BpContact> findByBpartnerId(String bpartnerId);

	/**
	 * Find by reference: position
	 */
	public List<BpContact> findByPosition(BpContactPosition position);

	/**
	 * Find by ID of reference: position.id
	 */
	public List<BpContact> findByPositionId(String positionId);
}
