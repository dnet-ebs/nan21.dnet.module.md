/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.presenter.impl.bp.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.md.domain.impl.bp.BpContact;
import net.nan21.dnet.module.md.domain.impl.bp.BpContactPosition;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;

@Ds(entity = BpContact.class, sort = {@SortField(field = BpContact_Ds.f_name)})
@RefLookups({
		@RefLookup(refId = BpContact_Ds.f_positionId, namedQuery = BpContactPosition.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = BpContact_Ds.f_position)}),
		@RefLookup(refId = BpContact_Ds.f_businessPartnerId, namedQuery = BusinessPartner.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = BpContact_Ds.f_businessPartner)})})
public class BpContact_Ds extends AbstractTypeDs<BpContact> {

	public static final String f_firstName = "firstName";
	public static final String f_lastName = "lastName";
	public static final String f_birthDate = "birthDate";
	public static final String f_businessPartnerId = "businessPartnerId";
	public static final String f_businessPartner = "businessPartner";
	public static final String f_businessPartnerName = "businessPartnerName";
	public static final String f_positionId = "positionId";
	public static final String f_position = "position";

	@DsField
	private String firstName;

	@DsField
	private String lastName;

	@DsField
	private Date birthDate;

	@DsField(join = "left", path = "bpartner.id")
	private String businessPartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String businessPartner;

	@DsField(join = "left", path = "bpartner.name")
	private String businessPartnerName;

	@DsField(join = "left", path = "position.id")
	private String positionId;

	@DsField(join = "left", path = "position.name")
	private String position;

	public BpContact_Ds() {
		super();
	}

	public BpContact_Ds(BpContact e) {
		super(e);
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBusinessPartnerId() {
		return this.businessPartnerId;
	}

	public void setBusinessPartnerId(String businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public String getBusinessPartner() {
		return this.businessPartner;
	}

	public void setBusinessPartner(String businessPartner) {
		this.businessPartner = businessPartner;
	}

	public String getBusinessPartnerName() {
		return this.businessPartnerName;
	}

	public void setBusinessPartnerName(String businessPartnerName) {
		this.businessPartnerName = businessPartnerName;
	}

	public String getPositionId() {
		return this.positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
