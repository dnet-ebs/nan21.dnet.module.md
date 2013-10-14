/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.org;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.md.domain.impl.org.Org;
import net.nan21.dnet.module.md.domain.impl.org.OrgHierarchy;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Child - parent relationship within a certain hierarchy.
 */
@NamedQueries({
		@NamedQuery(name = OrgHierarchyItem.NQ_FIND_BY_ITEM, query = "SELECT e FROM OrgHierarchyItem e WHERE e.clientId = :clientId and e.hierarchy = :hierarchy and e.org = :org", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = OrgHierarchyItem.NQ_FIND_BY_ITEM_PRIMITIVE, query = "SELECT e FROM OrgHierarchyItem e WHERE e.clientId = :clientId and e.hierarchy.id = :hierarchyId and e.org.id = :orgId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = OrgHierarchyItem.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = OrgHierarchyItem.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "HIERARCHY_ID", "ORG_ID"})})
public class OrgHierarchyItem extends AbstractAuditable {

	public static final String TABLE_NAME = "MD_ORG_HRCHY_ITEM";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Item.
	 */
	public static final String NQ_FIND_BY_ITEM = "OrgHierarchyItem.findByItem";
	/**
	 * Named query find by unique key: Item using the ID field for references.
	 */
	public static final String NQ_FIND_BY_ITEM_PRIMITIVE = "OrgHierarchyItem.findByItem_PRIMITIVE";

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = OrgHierarchy.class)
	@JoinColumn(name = "HIERARCHY_ID", referencedColumnName = "ID")
	private OrgHierarchy hierarchy;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Org.class)
	@JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
	private Org org;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Org.class)
	@JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
	private Org parent;

	public OrgHierarchy getHierarchy() {
		return this.hierarchy;
	}

	public void setHierarchy(OrgHierarchy hierarchy) {
		if (hierarchy != null) {
			this.__validate_client_context__(hierarchy.getClientId());
		}
		this.hierarchy = hierarchy;
	}

	public Org getOrg() {
		return this.org;
	}

	public void setOrg(Org org) {
		if (org != null) {
			this.__validate_client_context__(org.getClientId());
		}
		this.org = org;
	}

	public Org getParent() {
		return this.parent;
	}

	public void setParent(Org parent) {
		if (parent != null) {
			this.__validate_client_context__(parent.getClientId());
		}
		this.parent = parent;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
