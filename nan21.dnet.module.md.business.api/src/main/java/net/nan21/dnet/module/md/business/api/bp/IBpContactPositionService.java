/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.bp;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.bp.BpContactPosition;

/**
 * Interface to expose business functions specific for {@link BpContactPosition} domain
 * entity.
 */
public interface IBpContactPositionService
		extends
			IEntityService<BpContactPosition> {

	/**
	 * Find by unique key
	 */
	public BpContactPosition findByName(String name);
}
