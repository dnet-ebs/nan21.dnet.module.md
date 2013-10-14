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
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.org.DocSequence;
import net.nan21.dnet.module.md.domain.impl.org.Org;

@Ds(entity = DocSequence.class, sort = {@SortField(field = DocSequence_Ds.f_name)})
@RefLookups({
		@RefLookup(refId = DocSequence_Ds.f_docTypeId, namedQuery = DocType.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = DocSequence_Ds.f_docType)}),
		@RefLookup(refId = DocSequence_Ds.f_companyId, namedQuery = Org.NQ_FIND_BY_CODE, params = {@Param(name = "code", field = DocSequence_Ds.f_company)})})
public class DocSequence_Ds extends AbstractTypeDs<DocSequence> {

	public static final String f_firstNo = "firstNo";
	public static final String f_lastNo = "lastNo";
	public static final String f_incrementBy = "incrementBy";
	public static final String f_prefix = "prefix";
	public static final String f_suffix = "suffix";
	public static final String f_paddingLength = "paddingLength";
	public static final String f_docTypeId = "docTypeId";
	public static final String f_docType = "docType";
	public static final String f_companyId = "companyId";
	public static final String f_company = "company";

	@DsField
	private Integer firstNo;

	@DsField
	private Integer lastNo;

	@DsField
	private Integer incrementBy;

	@DsField
	private String prefix;

	@DsField
	private String suffix;

	@DsField
	private Integer paddingLength;

	@DsField(join = "left", path = "docType.id")
	private String docTypeId;

	@DsField(join = "left", path = "docType.code")
	private String docType;

	@DsField(join = "left", path = "company.id")
	private String companyId;

	@DsField(join = "left", path = "company.code")
	private String company;

	public DocSequence_Ds() {
		super();
	}

	public DocSequence_Ds(DocSequence e) {
		super(e);
	}

	public Integer getFirstNo() {
		return this.firstNo;
	}

	public void setFirstNo(Integer firstNo) {
		this.firstNo = firstNo;
	}

	public Integer getLastNo() {
		return this.lastNo;
	}

	public void setLastNo(Integer lastNo) {
		this.lastNo = lastNo;
	}

	public Integer getIncrementBy() {
		return this.incrementBy;
	}

	public void setIncrementBy(Integer incrementBy) {
		this.incrementBy = incrementBy;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Integer getPaddingLength() {
		return this.paddingLength;
	}

	public void setPaddingLength(Integer paddingLength) {
		this.paddingLength = paddingLength;
	}

	public String getDocTypeId() {
		return this.docTypeId;
	}

	public void setDocTypeId(String docTypeId) {
		this.docTypeId = docTypeId;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
