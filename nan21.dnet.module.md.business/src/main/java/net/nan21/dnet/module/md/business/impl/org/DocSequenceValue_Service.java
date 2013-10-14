/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.impl.org;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.domain.impl.org.DocSequence;
import net.nan21.dnet.module.md.domain.impl.org.DocSequenceValue;

/**
 * Repository functionality for {@link DocSequenceValue} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DocSequenceValue_Service
		extends
			AbstractEntityService<DocSequenceValue> {

	public DocSequenceValue_Service() {
		super();
	}

	public DocSequenceValue_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DocSequenceValue> getEntityClass() {
		return DocSequenceValue.class;
	}
	/**
	 * Find by unique key
	 */
	public DocSequenceValue findByValue(DocSequence docSequence, String value) {
		return (DocSequenceValue) this
				.getEntityManager()
				.createNamedQuery(DocSequenceValue.NQ_FIND_BY_VALUE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("docSequence", docSequence)
				.setParameter("value", value).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public DocSequenceValue findByValue(Long docSequenceId, String value) {
		return (DocSequenceValue) this
				.getEntityManager()
				.createNamedQuery(DocSequenceValue.NQ_FIND_BY_VALUE_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("docSequenceId", docSequenceId)
				.setParameter("value", value).getSingleResult();
	}
	/**
	 * Find by reference: docSequence
	 */
	public List<DocSequenceValue> findByDocSequence(DocSequence docSequence) {
		return this.findByDocSequenceId(docSequence.getId());
	}
	/**
	 * Find by ID of reference: docSequence.id
	 */
	public List<DocSequenceValue> findByDocSequenceId(String docSequenceId) {
		return (List<DocSequenceValue>) this
				.getEntityManager()
				.createQuery(
						"select e from DocSequenceValue e where e.clientId = :clientId and e.docSequence.id = :docSequenceId",
						DocSequenceValue.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("docSequenceId", docSequenceId).getResultList();
	}
}
