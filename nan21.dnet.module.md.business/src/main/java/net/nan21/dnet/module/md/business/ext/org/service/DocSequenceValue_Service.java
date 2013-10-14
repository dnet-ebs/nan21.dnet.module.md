/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.ext.org.service;

import java.util.List;

import javax.persistence.LockModeType;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.business.api.org.IDocSequenceValueService;
import net.nan21.dnet.module.md.domain.impl.org.DocSequenceValue;

/**
 * Business extensions specific for {@link DocSequenceValue} domain entity.
 * 
 */
public class DocSequenceValue_Service extends
		net.nan21.dnet.module.md.business.impl.org.DocSequenceValue_Service
		implements IDocSequenceValueService {

	@Override
	public DocSequenceValue getNextValue(String companyId, String docTypeId)
			throws BusinessException {

		String eql = "select e from DocSequenceValue e "
				+ " where e.docSequence in "
				+ " ( select s from DocSequence s "
				+ "  where s.docType.id = :docTypeId "
				+ "   and  s.company.id = :companyId )" + " and e.used = false"
				+ " order by e.value";

		List<DocSequenceValue> result = this.getEntityManager()
				.createQuery(eql, DocSequenceValue.class)
				.setParameter("docTypeId", docTypeId)
				.setParameter("companyId", companyId).setMaxResults(1)
				.getResultList();

		if (result.size() < 1) {
			throw new BusinessException(
					"No document number available! Check the document sequence setup for the given document type and company.");
		}

		DocSequenceValue v = result.get(0);
		this.getEntityManager().lock(v, LockModeType.PESSIMISTIC_WRITE);
		return v;
	}
}
