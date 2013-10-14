/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.org.OrgType;

/**
 * Interface to expose business functions specific for {@link OrgType} domain
 * entity.
 */
public interface IOrgTypeService extends IEntityService<OrgType> {

	/**
	 * Find by unique key
	 */
	public OrgType findByCode(String code);

	/**
	 * Find by unique key
	 */
	public OrgType findByName(String name);
}
