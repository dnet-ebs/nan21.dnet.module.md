/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.org.Org;
import net.nan21.dnet.module.md.domain.impl.org.OrgHierarchy;
import net.nan21.dnet.module.md.domain.impl.org.OrgHierarchyItem;

/**
 * Interface to expose business functions specific for {@link OrgHierarchyItem} domain
 * entity.
 */
public interface IOrgHierarchyItemService
		extends
			IEntityService<OrgHierarchyItem> {

	/**
	 * Find by unique key
	 */
	public OrgHierarchyItem findByItem(OrgHierarchy hierarchy, Org org);

	/**
	 * Find by unique key
	 */
	public OrgHierarchyItem findByItem(Long hierarchyId, Long orgId);

	/**
	 * Find by reference: hierarchy
	 */
	public List<OrgHierarchyItem> findByHierarchy(OrgHierarchy hierarchy);

	/**
	 * Find by ID of reference: hierarchy.id
	 */
	public List<OrgHierarchyItem> findByHierarchyId(String hierarchyId);

	/**
	 * Find by reference: org
	 */
	public List<OrgHierarchyItem> findByOrg(Org org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<OrgHierarchyItem> findByOrgId(String orgId);

	/**
	 * Find by reference: parent
	 */
	public List<OrgHierarchyItem> findByParent(Org parent);

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<OrgHierarchyItem> findByParentId(String parentId);
}
