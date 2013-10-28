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
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.md.domain.impl.org.Inventory;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocation;
import net.nan21.dnet.module.md.domain.impl.org.InventoryLocationType;
import net.nan21.dnet.module.md.domain.impl.org.Org;

@Ds(entity = InventoryLocation.class, sort = {@SortField(field = InventoryLocation_Ds.f_code)})
@RefLookups({
		@RefLookup(refId = InventoryLocation_Ds.f_orgId, namedQuery = Org.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = InventoryLocation_Ds.f_org)}),
		@RefLookup(refId = InventoryLocation_Ds.f_inventoryId, namedQuery = Inventory.NQ_FIND_BY_CODE_PRIMITIVE, params = {
				@Param(name = "orgId", field = InventoryLocation_Ds.f_orgId),
				@Param(name = "code", field = InventoryLocation_Ds.f_inventory)}),
		@RefLookup(refId = InventoryLocation_Ds.f_locationTypeId, namedQuery = InventoryLocationType.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = InventoryLocation_Ds.f_locationType)})})
public class InventoryLocation_Ds
		extends
			AbstractTypeWithCodeDs<InventoryLocation> {

	public static final String f_inventoryId = "inventoryId";
	public static final String f_inventory = "inventory";
	public static final String f_inventoryName = "inventoryName";
	public static final String f_orgId = "orgId";
	public static final String f_org = "org";
	public static final String f_orgName = "orgName";
	public static final String f_locationTypeId = "locationTypeId";
	public static final String f_locationType = "locationType";

	@DsField(join = "left", path = "inventory.id")
	private String inventoryId;

	@DsField(join = "left", path = "inventory.code")
	private String inventory;

	@DsField(join = "left", path = "inventory.name")
	private String inventoryName;

	@DsField(join = "left", path = "inventory.org.id")
	private String orgId;

	@DsField(join = "left", path = "inventory.org.code")
	private String org;

	@DsField(join = "left", path = "inventory.org.name")
	private String orgName;

	@DsField(join = "left", path = "locationType.id")
	private String locationTypeId;

	@DsField(join = "left", path = "locationType.code")
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

	public String getInventoryName() {
		return this.inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrg() {
		return this.org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
