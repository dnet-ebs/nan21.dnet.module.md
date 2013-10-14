/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.org.DocSequence;
import net.nan21.dnet.module.md.domain.impl.org.DocSequenceValue;
import net.nan21.dnet.module.md.domain.impl.org.Org;

/**
 * Interface to expose business functions specific for {@link DocSequence} domain
 * entity.
 */
public interface IDocSequenceService extends IEntityService<DocSequence> {

	public void doCreateValues(String docSequenceId) throws BusinessException;

	/**
	 * Find by reference: docType
	 */
	public List<DocSequence> findByDocType(DocType docType);

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<DocSequence> findByDocTypeId(String docTypeId);

	/**
	 * Find by reference: company
	 */
	public List<DocSequence> findByCompany(Org company);

	/**
	 * Find by ID of reference: company.id
	 */
	public List<DocSequence> findByCompanyId(String companyId);

	/**
	 * Find by reference: values
	 */
	public List<DocSequence> findByValues(DocSequenceValue values);

	/**
	 * Find by ID of reference: values.id
	 */
	public List<DocSequence> findByValuesId(String valuesId);
}
