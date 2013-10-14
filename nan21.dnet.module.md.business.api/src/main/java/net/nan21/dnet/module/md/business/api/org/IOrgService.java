/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.org.Org;
import net.nan21.dnet.module.md.domain.impl.org.OrgType;

/**
 * Interface to expose business functions specific for {@link Org} domain
 * entity.
 */
public interface IOrgService extends IEntityService<Org> {

	/**
	 * Find by unique key
	 */
	public Org findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Org findByName(String name);

	/**
	 * Find by reference: type
	 */
	public List<Org> findByType(OrgType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Org> findByTypeId(String typeId);
}
