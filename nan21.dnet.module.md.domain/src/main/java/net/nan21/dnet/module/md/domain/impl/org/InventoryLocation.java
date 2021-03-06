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
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.md.domain.impl.org.Inventory;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocationType;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * 
 */
@NamedQueries({
		@NamedQuery(name = InventoryLocation.NQ_FIND_BY_CODE, query = "SELECT e FROM InventoryLocation e WHERE e.clientId = :clientId and e.inventory = :inventory and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = InventoryLocation.NQ_FIND_BY_CODE_PRIMITIVE, query = "SELECT e FROM InventoryLocation e WHERE e.clientId = :clientId and e.inventory.id = :inventoryId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = InventoryLocation.NQ_FIND_BY_NAME, query = "SELECT e FROM InventoryLocation e WHERE e.clientId = :clientId and e.inventory = :inventory and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = InventoryLocation.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM InventoryLocation e WHERE e.clientId = :clientId and e.inventory.id = :inventoryId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = InventoryLocation.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = InventoryLocation.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "INVENTORY_ID", "CODE"}),
		@UniqueConstraint(name = InventoryLocation.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "INVENTORY_ID", "NAME"})})
public class InventoryLocation extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_IVTLOC";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "InventoryLocation.findByCode";
	/**
	 * Named query find by unique key: Code using the ID field for references.
	 */
	public static final String NQ_FIND_BY_CODE_PRIMITIVE = "InventoryLocation.findByCode_PRIMITIVE";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "InventoryLocation.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "InventoryLocation.findByName_PRIMITIVE";

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Inventory.class)
	@JoinColumn(name = "INVENTORY_ID", referencedColumnName = "ID")
	private Inventory inventory;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = InventoryLocationType.class)
	@JoinColumn(name = "LOCATIONTYPE_ID", referencedColumnName = "ID")
	private InventoryLocationType locationType;

	public Inventory getInventory() {
		return this.inventory;
	}

	public void setInventory(Inventory inventory) {
		if (inventory != null) {
			this.__validate_client_context__(inventory.getClientId());
		}
		this.inventory = inventory;
	}

	public InventoryLocationType getLocationType() {
		return this.locationType;
	}

	public void setLocationType(InventoryLocationType locationType) {
		if (locationType != null) {
			this.__validate_client_context__(locationType.getClientId());
		}
		this.locationType = locationType;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
