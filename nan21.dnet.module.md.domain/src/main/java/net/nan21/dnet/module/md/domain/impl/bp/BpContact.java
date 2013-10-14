/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.bp;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import net.nan21.dnet.core.domain.impl.AbstractType;
import net.nan21.dnet.module.md.domain.impl.bp.BpContactPosition;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;

/**
 * Business partner contact person
 */
@Entity
@Table(name = BpContact.TABLE_NAME)
public class BpContact extends AbstractType {

	public static final String TABLE_NAME = "MD_BP_CNTC";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "FIRSTNAME", length = 255)
	private String firstName;

	@Column(name = "LASTNAME", length = 255)
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDATE")
	private Date birthDate;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BusinessPartner.class)
	@JoinColumn(name = "BPARTNER_ID", referencedColumnName = "ID")
	private BusinessPartner bpartner;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BpContactPosition.class)
	@JoinColumn(name = "POSITION_ID", referencedColumnName = "ID")
	private BpContactPosition position;

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

	public BusinessPartner getBpartner() {
		return this.bpartner;
	}

	public void setBpartner(BusinessPartner bpartner) {
		if (bpartner != null) {
			this.__validate_client_context__(bpartner.getClientId());
		}
		this.bpartner = bpartner;
	}

	public BpContactPosition getPosition() {
		return this.position;
	}

	public void setPosition(BpContactPosition position) {
		if (position != null) {
			this.__validate_client_context__(position.getClientId());
		}
		this.position = position;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
