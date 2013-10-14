/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.org.Inventory;
import net.nan21.dnet.module.md.domain.impl.org.Org;

/**
 * Interface to expose business functions specific for {@link Inventory} domain
 * entity.
 */
public interface IInventoryService extends IEntityService<Inventory> {

	/**
	 * Find by unique key
	 */
	public Inventory findByName(String name);

	/**
	 * Find by reference: org
	 */
	public List<Inventory> findByOrg(Org org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<Inventory> findByOrgId(String orgId);
}
