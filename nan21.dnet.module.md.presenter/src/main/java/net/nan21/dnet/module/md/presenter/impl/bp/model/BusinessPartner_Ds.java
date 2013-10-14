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
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.bd.domain.impl.geo.Country;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;
import net.nan21.dnet.module.md.domain.impl.bp.LegalForm;

@Ds(entity = BusinessPartner.class, sort = {@SortField(field = BusinessPartner_Ds.f_code)})
@RefLookups({
		@RefLookup(refId = BusinessPartner_Ds.f_countryId, namedQuery = Country.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = BusinessPartner_Ds.f_country)}),
		@RefLookup(refId = BusinessPartner_Ds.f_legalFormId, namedQuery = LegalForm.NQ_FIND_BY_CODE_PRIMITIVE, params = {
				@Param(name = "countryId", field = BusinessPartner_Ds.f_countryId),
				@Param(name = "code", field = BusinessPartner_Ds.f_legalForm)})})
public class BusinessPartner_Ds extends AbstractTypeWithCodeDs<BusinessPartner> {

	public static final String f_type = "type";
	public static final String f_taxPayerNo = "taxPayerNo";
	public static final String f_firstName = "firstName";
	public static final String f_lastName = "lastName";
	public static final String f_middleName = "middleName";
	public static final String f_gender = "gender";
	public static final String f_identityCardNo = "identityCardNo";
	public static final String f_passportNo = "passportNo";
	public static final String f_birthDate = "birthDate";
	public static final String f_companyName = "companyName";
	public static final String f_registrationNo = "registrationNo";
	public static final String f_registrationDate = "registrationDate";
	public static final String f_countryId = "countryId";
	public static final String f_country = "country";
	public static final String f_legalFormId = "legalFormId";
	public static final String f_legalForm = "legalForm";

	@DsField
	private String type;

	@DsField
	private String taxPayerNo;

	@DsField
	private String firstName;

	@DsField
	private String lastName;

	@DsField
	private String middleName;

	@DsField
	private String gender;

	@DsField
	private String identityCardNo;

	@DsField
	private String passportNo;

	@DsField
	private Date birthDate;

	@DsField
	private String companyName;

	@DsField
	private String registrationNo;

	@DsField
	private Date registrationDate;

	@DsField(join = "left", path = "country.id")
	private String countryId;

	@DsField(join = "left", path = "country.code")
	private String country;

	@DsField(join = "left", path = "legalForm.id")
	private String legalFormId;

	@DsField(join = "left", path = "legalForm.code")
	private String legalForm;

	public BusinessPartner_Ds() {
		super();
	}

	public BusinessPartner_Ds(BusinessPartner e) {
		super(e);
	}

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

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLegalFormId() {
		return this.legalFormId;
	}

	public void setLegalFormId(String legalFormId) {
		this.legalFormId = legalFormId;
	}

	public String getLegalForm() {
		return this.legalForm;
	}

	public void setLegalForm(String legalForm) {
		this.legalForm = legalForm;
	}
}
