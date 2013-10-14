/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.org.OrgHierarchy;

/**
 * Interface to expose business functions specific for {@link OrgHierarchy} domain
 * entity.
 */
public interface IOrgHierarchyService extends IEntityService<OrgHierarchy> {

	/**
	 * Find by unique key
	 */
	public OrgHierarchy findByName(String name);
}
