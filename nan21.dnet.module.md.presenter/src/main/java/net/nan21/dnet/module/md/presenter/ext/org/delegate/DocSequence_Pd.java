package net.nan21.dnet.module.md.presenter.ext.org.delegate;

import net.nan21.dnet.core.presenter.service.AbstractPresenterDelegate;
import net.nan21.dnet.module.md.business.api.org.IDocSequenceService;
import net.nan21.dnet.module.md.domain.impl.org.DocSequence;
import net.nan21.dnet.module.md.presenter.impl.org.model.DocSequence_Ds;

public class DocSequence_Pd extends AbstractPresenterDelegate {

	/**
	 * Create values for the document sequence. Delegate to the transactional
	 * business service
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void createValues(DocSequence_Ds ds) throws Exception {
		((IDocSequenceService) this.findEntityService(DocSequence.class))
				.doCreateValues(ds.getId());
	}

}
