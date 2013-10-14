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
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.org.DocSequence;
import net.nan21.dnet.module.md.domain.impl.org.DocSequenceValue;
import net.nan21.dnet.module.md.domain.impl.org.Org;

/**
 * Repository functionality for {@link DocSequence} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DocSequence_Service extends AbstractEntityService<DocSequence> {

	public DocSequence_Service() {
		super();
	}

	public DocSequence_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DocSequence> getEntityClass() {
		return DocSequence.class;
	}
	/**
	 * Find by reference: docType
	 */
	public List<DocSequence> findByDocType(DocType docType) {
		return this.findByDocTypeId(docType.getId());
	}
	/**
	 * Find by ID of reference: docType.id
	 */
	public List<DocSequence> findByDocTypeId(String docTypeId) {
		return (List<DocSequence>) this
				.getEntityManager()
				.createQuery(
						"select e from DocSequence e where e.clientId = :clientId and e.docType.id = :docTypeId",
						DocSequence.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("docTypeId", docTypeId).getResultList();
	}
	/**
	 * Find by reference: company
	 */
	public List<DocSequence> findByCompany(Org company) {
		return this.findByCompanyId(company.getId());
	}
	/**
	 * Find by ID of reference: company.id
	 */
	public List<DocSequence> findByCompanyId(String companyId) {
		return (List<DocSequence>) this
				.getEntityManager()
				.createQuery(
						"select e from DocSequence e where e.clientId = :clientId and e.company.id = :companyId",
						DocSequence.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("companyId", companyId).getResultList();
	}
	/**
	 * Find by reference: values
	 */
	public List<DocSequence> findByValues(DocSequenceValue values) {
		return this.findByValuesId(values.getId());
	}
	/**
	 * Find by ID of reference: values.id
	 */
	public List<DocSequence> findByValuesId(String valuesId) {
		return (List<DocSequence>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from DocSequence e, IN (e.values) c where e.clientId = :clientId and c.id = :valuesId",
						DocSequence.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("valuesId", valuesId).getResultList();
	}
}
