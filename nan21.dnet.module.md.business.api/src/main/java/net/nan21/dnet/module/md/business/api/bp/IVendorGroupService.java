/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api.bp;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.md.domain.impl.base.DocType;
import net.nan21.dnet.module.md.domain.impl.base.PaymentTerm;
import net.nan21.dnet.module.md.domain.impl.bp.VendorGroup;

/**
 * Interface to expose business functions specific for {@link VendorGroup} domain
 * entity.
 */
public interface IVendorGroupService extends IEntityService<VendorGroup> {

	/**
	 * Find by unique key
	 */
	public VendorGroup findByCode(String code);

	/**
	 * Find by unique key
	 */
	public VendorGroup findByName(String name);

	/**
	 * Find by reference: paymentMethod
	 */
	public List<VendorGroup> findByPaymentMethod(DocType paymentMethod);

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<VendorGroup> findByPaymentMethodId(String paymentMethodId);

	/**
	 * Find by reference: paymentTerm
	 */
	public List<VendorGroup> findByPaymentTerm(PaymentTerm paymentTerm);

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<VendorGroup> findByPaymentTermId(String paymentTermId);
}
