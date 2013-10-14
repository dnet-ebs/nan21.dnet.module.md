/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.org.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.md.domain.impl.org.Inventory;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocation;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocationType;

@Ds(entity = InventoryLocation.class, sort = {@SortField(field = InventoryLocation_Ds.f_name)})
@RefLookups({
		@RefLookup(refId = InventoryLocation_Ds.f_inventoryId, namedQuery = Inventory.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = InventoryLocation_Ds.f_inventory)}),
		@RefLookup(refId = InventoryLocation_Ds.f_locationTypeId, namedQuery = InventoryLocationType.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = InventoryLocation_Ds.f_locationType)})})
public class InventoryLocation_Ds extends AbstractTypeDs<InventoryLocation> {

	public static final String f_inventoryId = "inventoryId";
	public static final String f_inventory = "inventory";
	public static final String f_locationTypeId = "locationTypeId";
	public static final String f_locationType = "locationType";

	@DsField(join = "left", path = "inventory.id")
	private String inventoryId;

	@DsField(join = "left", path = "inventory.name")
	private String inventory;

	@DsField(join = "left", path = "locationType.id")
	private String locationTypeId;

	@DsField(join = "left", path = "locationType.name")
	private String locationType;

	public InventoryLocation_Ds() {
		super();
	}

	public InventoryLocation_Ds(InventoryLocation e) {
		super(e);
	}

	public String getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventory() {
		return this.inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getLocationTypeId() {
		return this.locationTypeId;
	}

	public void setLocationTypeId(String locationTypeId) {
		this.locationTypeId = locationTypeId;
	}

	public String getLocationType() {
		return this.locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
}
