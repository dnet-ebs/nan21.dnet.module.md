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
import net.nan21.dnet.module.md.domain.impl.bp.BpAccount;
import net.nan21.dnet.module.md.domain.impl.bp.BusinessPartner;
import net.nan21.dnet.module.md.domain.impl.bp.CustomerGroup;
import net.nan21.dnet.module.md.domain.impl.bp.VendorGroup;
import net.nan21.dnet.module.md.domain.impl.org.Org;

/**
 * Interface to expose business functions specific for {@link BpAccount} domain
 * entity.
 */
public interface IBpAccountService extends IEntityService<BpAccount> {

	/**
	 * Find by unique key
	 */
	public BpAccount findByOrg_bp(Org company, BusinessPartner bpartner);

	/**
	 * Find by unique key
	 */
	public BpAccount findByOrg_bp(Long companyId, Long bpartnerId);

	/**
	 * Find by reference: bpartner
	 */
	public List<BpAccount> findByBpartner(BusinessPartner bpartner);

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<BpAccount> findByBpartnerId(String bpartnerId);

	/**
	 * Find by reference: company
	 */
	public List<BpAccount> findByCompany(Org company);

	/**
	 * Find by ID of reference: company.id
	 */
	public List<BpAccount> findByCompanyId(String companyId);

	/**
	 * Find by reference: custGroup
	 */
	public List<BpAccount> findByCustGroup(CustomerGroup custGroup);

	/**
	 * Find by ID of reference: custGroup.id
	 */
	public List<BpAccount> findByCustGroupId(String custGroupId);

	/**
	 * Find by reference: custPaymentMethod
	 */
	public List<BpAccount> findByCustPaymentMethod(DocType custPaymentMethod);

	/**
	 * Find by ID of reference: custPaymentMethod.id
	 */
	public List<BpAccount> findByCustPaymentMethodId(String custPaymentMethodId);

	/**
	 * Find by reference: custPaymentTerm
	 */
	public List<BpAccount> findByCustPaymentTerm(PaymentTerm custPaymentTerm);

	/**
	 * Find by ID of reference: custPaymentTerm.id
	 */
	public List<BpAccount> findByCustPaymentTermId(String custPaymentTermId);

	/**
	 * Find by reference: vendGroup
	 */
	public List<BpAccount> findByVendGroup(VendorGroup vendGroup);

	/**
	 * Find by ID of reference: vendGroup.id
	 */
	public List<BpAccount> findByVendGroupId(String vendGroupId);

	/**
	 * Find by reference: vendPaymentMethod
	 */
	public List<BpAccount> findByVendPaymentMethod(DocType vendPaymentMethod);

	/**
	 * Find by ID of reference: vendPaymentMethod.id
	 */
	public List<BpAccount> findByVendPaymentMethodId(String vendPaymentMethodId);

	/**
	 * Find by reference: vendPaymentTerm
	 */
	public List<BpAccount> findByVendPaymentTerm(PaymentTerm vendPaymentTerm);

	/**
	 * Find by ID of reference: vendPaymentTerm.id
	 */
	public List<BpAccount> findByVendPaymentTermId(String vendPaymentTermId);
}
