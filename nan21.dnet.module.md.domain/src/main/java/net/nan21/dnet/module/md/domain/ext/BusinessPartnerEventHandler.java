/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.domain.ext;

import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.descriptors.DescriptorEvent;

import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;

public class BusinessPartnerEventHandler extends DefaultEventHandler {

	@Override
	   public void preInsert(DescriptorEvent event) {
	//BusinessPartner e = (BusinessPartner)event.getSource();
	  } 
	  
	@Override
	   public void preUpdate(DescriptorEvent event) {
	//BusinessPartner e = (BusinessPartner)event.getSource();
	  } 
}
