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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.md.domain.impl.bp.LegalForm;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Entity eligible to have business relationships with.
 *	Can be private individuals, companies or groups.	
 */
@NamedQueries({@NamedQuery(name = BusinessPartner.NQ_FIND_BY_CODE, query = "SELECT e FROM BusinessPartner e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = BusinessPartner.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = BusinessPartner.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "CODE"})})
public class BusinessPartner extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_BP";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "BusinessPartner.findByCode";

	/** 
	 * Specifies whether a business partner is one of:
	 *	- private individual
	 *	- organization			 
	 *	Cannot be altered at a later stage.
	 */
	@Column(name = "TYPE", length = 16)
	private String type;

	@Column(name = "TAXPAYERNO", length = 255)
	private String taxPayerNo;

	@Column(name = "FIRSTNAME", length = 255)
	private String firstName;

	@Column(name = "LASTNAME", length = 255)
	private String lastName;

	@Column(name = "MIDDLENAME", length = 255)
	private String middleName;

	@Column(name = "GENDER", length = 16)
	private String gender;

	@Column(name = "IDENTITYCARDNO", length = 255)
	private String identityCardNo;

	@Column(name = "PASSPORTNO", length = 255)
	private String passportNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDATE")
	private Date birthDate;

	@Column(name = "COMPANYNAME", length = 255)
	private String companyName;

	@Column(name = "REGISTRATIONNO", length = 32)
	private String registrationNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATIONDATE")
	private Date registrationDate;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = LegalForm.class)
	@JoinColumn(name = "LEGALFORM_ID", referencedColumnName = "ID")
	private LegalForm legalForm;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTaxPayerNo() {
		return this.taxPayerNo;
	}

	public void setTaxPayerNo(String taxPayerNo) {
		this.taxPayerNo = taxPayerNo;
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

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentityCardNo() {
		return this.identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRegistrationNo() {
		return this.registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		if (country != null) {
			this.__validate_client_context__(country.getClientId());
		}
		this.country = country;
	}

	public LegalForm getLegalForm() {
		return this.legalForm;
	}

	public void setLegalForm(LegalForm legalForm) {
		if (legalForm != null) {
			this.__validate_client_context__(legalForm.getClientId());
		}
		this.legalForm = legalForm;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}
