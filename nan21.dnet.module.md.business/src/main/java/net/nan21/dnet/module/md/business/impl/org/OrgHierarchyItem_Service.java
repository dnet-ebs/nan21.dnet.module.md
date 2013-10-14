/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.org;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.business.api.org.IOrgHierarchyItemService;
import net.nan21.dnet.module.md.domain.impl.org.Org;
import net.nan21.dnet.module.md.domain.impl.org.OrgHierarchy;
import net.nan21.dnet.module.md.domain.impl.org.OrgHierarchyItem;

/**
 * Repository functionality for {@link OrgHierarchyItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OrgHierarchyItem_Service
		extends
			AbstractEntityService<OrgHierarchyItem>
		implements
			IOrgHierarchyItemService {

	public OrgHierarchyItem_Service() {
		super();
	}

	public OrgHierarchyItem_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<OrgHierarchyItem> getEntityClass() {
		return OrgHierarchyItem.class;
	}
	/**
	 * Find by unique key
	 */
	public OrgHierarchyItem findByItem(OrgHierarchy hierarchy, Org org) {
		return (OrgHierarchyItem) this
				.getEntityManager()
				.createNamedQuery(OrgHierarchyItem.NQ_FIND_BY_ITEM)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("hierarchy", hierarchy).setParameter("org", org)
				.getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public OrgHierarchyItem findByItem(Long hierarchyId, Long orgId) {
		return (OrgHierarchyItem) this
				.getEntityManager()
				.createNamedQuery(OrgHierarchyItem.NQ_FIND_BY_ITEM_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("hierarchyId", hierarchyId)
				.setParameter("orgId", orgId).getSingleResult();
	}
	/**
	 * Find by reference: hierarchy
	 */
	public List<OrgHierarchyItem> findByHierarchy(OrgHierarchy hierarchy) {
		return this.findByHierarchyId(hierarchy.getId());
	}
	/**
	 * Find by ID of reference: hierarchy.id
	 */
	public List<OrgHierarchyItem> findByHierarchyId(String hierarchyId) {
		return (List<OrgHierarchyItem>) this
				.getEntityManager()
				.createQuery(
						"select e from OrgHierarchyItem e where e.clientId = :clientId and e.hierarchy.id = :hierarchyId",
						OrgHierarchyItem.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("hierarchyId", hierarchyId).getResultList();
	}
	/**
	 * Find by reference: org
	 */
	public List<OrgHierarchyItem> findByOrg(Org org) {
		return this.findByOrgId(org.getId());
	}
	/**
	 * Find by ID of reference: org.id
	 */
	public List<OrgHierarchyItem> findByOrgId(String orgId) {
		return (List<OrgHierarchyItem>) this
				.getEntityManager()
				.createQuery(
						"select e from OrgHierarchyItem e where e.clientId = :clientId and e.org.id = :orgId",
						OrgHierarchyItem.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("orgId", orgId).getResultList();
	}
	/**
	 * Find by reference: parent
	 */
	public List<OrgHierarchyItem> findByParent(Org parent) {
		return this.findByParentId(parent.getId());
	}
	/**
	 * Find by ID of reference: parent.id
	 */
	public List<OrgHierarchyItem> findByParentId(String parentId) {
		return (List<OrgHierarchyItem>) this
				.getEntityManager()
				.createQuery(
						"select e from OrgHierarchyItem e where e.clientId = :clientId and e.parent.id = :parentId",
						OrgHierarchyItem.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("parentId", parentId).getResultList();
	}
}
