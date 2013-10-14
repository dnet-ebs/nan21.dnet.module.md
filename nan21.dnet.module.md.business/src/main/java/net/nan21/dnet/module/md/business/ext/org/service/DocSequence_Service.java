/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.ext.org.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.commons.lang.StringUtils;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.business.api.org.IDocSequenceService;
import net.nan21.dnet.module.md.domain.impl.org.DocSequence;
import net.nan21.dnet.module.md.domain.impl.org.DocSequenceValue;

/**
 * Business extensions specific for {@link DocSequence} domain entity.
 * 
 */
public class DocSequence_Service extends
		net.nan21.dnet.module.md.business.impl.org.DocSequence_Service
		implements IDocSequenceService {

	/**
	 * Create values for the document sequence.
	 */
	@Override
	public void doCreateValues(String docSequenceId) throws BusinessException {

		DocSequence sequence = null;

		// check if values already exist

		try {
			sequence = this
					.getEntityManager()
					.createQuery(
							"select e from DocSequence e "
									+ " where e.id = :docSeqId "
									+ "  and not exists ( select 1 from DocSequenceValue v where v.docSequence.id = e.id  )",
							DocSequence.class)
					.setParameter("docSeqId", docSequenceId).getSingleResult();
		} catch (NoResultException e) {
			throw new BusinessException(
					"Cannot create values for a document sequence which already has values. ");
		}

		// generate values

		String prefix = "";
		String suffix = "";

		if (sequence.getPrefix() != null) {
			prefix = sequence.getPrefix();
		}
		if (sequence.getSuffix() != null) {
			suffix = sequence.getSuffix();
		}

		int from = sequence.getFirstNo();
		int to = sequence.getLastNo();
		int length = 0;

		if (sequence.getPaddingLength() != null) {
			length = sequence.getPaddingLength();
		}

		List<DocSequenceValue> values = new ArrayList<DocSequenceValue>();
		for (int i = from; i <= to; i++) {
			DocSequenceValue value = new DocSequenceValue();
			String _v = i + "";
			if (length > 0) {
				_v = StringUtils.leftPad(_v, length, '0');
			}
			value.setNumericValue(i);
			value.setValue(prefix + _v + suffix);
			value.setDocSequence(sequence);
			values.add(value);
		}

		this.findEntityService(DocSequenceValue.class).insert(values);

	}

	@Override
	protected void preInsert(DocSequence e) throws BusinessException {
		this.createName(e);
		super.preInsert(e);
	}

	@Override
	protected void preUpdate(DocSequence e) throws BusinessException {
		this.createName(e);
		super.preUpdate(e);
	}

	private void createName(DocSequence e) {
		String name = e.getCompany().getCode() + "_" + e.getDocType().getCode()
				+ "_" + e.getPrefix() + "_" + e.getLastNo() + "_"
				+ e.getSuffix();
		e.setName(name);
	}

}
