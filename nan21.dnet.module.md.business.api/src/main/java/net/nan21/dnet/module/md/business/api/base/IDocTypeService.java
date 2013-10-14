/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.base;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.base.DocType;

/**
 * Interface to expose business functions specific for {@link DocType} domain
 * entity.
 */
public interface IDocTypeService extends IEntityService<DocType> {

	/**
	 * Find by unique key
	 */
	public DocType findByCode(String code);

	/**
	 * Find by unique key
	 */
	public DocType findByName(String name);
}
