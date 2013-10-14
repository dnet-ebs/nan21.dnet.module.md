/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.org;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.org.DocSequence;
import net.nan21.dnet.module.md.domain.impl.org.DocSequenceValue;

/**
 * Interface to expose business functions specific for {@link DocSequenceValue} domain
 * entity.
 */
public interface IDocSequenceValueService
		extends
			IEntityService<DocSequenceValue> {

	public DocSequenceValue getNextValue(String companyId, String docTypeId)
			throws BusinessException;

	/**
	 * Find by unique key
	 */
	public DocSequenceValue findByValue(DocSequence docSequence, String value);

	/**
	 * Find by unique key
	 */
	public DocSequenceValue findByValue(Long docSequenceId, String value);

	/**
	 * Find by reference: docSequence
	 */
	public List<DocSequenceValue> findByDocSequence(DocSequence docSequence);

	/**
	 * Find by ID of reference: docSequence.id
	 */
	public List<DocSequenceValue> findByDocSequenceId(String docSequenceId);
}
