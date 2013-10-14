/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.presenter.ext.mm.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.nan21.dnet.core.api.action.query.IQueryBuilder;
import net.nan21.dnet.core.api.service.presenter.IDsService;
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.md.business.api.SysParams_Md;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;
import net.nan21.dnet.module.md.presenter.impl.mm.model.ProductCategory_Ds;

public class ProductCategory_DsService
		extends
		AbstractEntityDsService<ProductCategory_Ds, ProductCategory_Ds, Object, ProductCategory>
		implements IDsService<ProductCategory_Ds, ProductCategory_Ds, Object> {

	/**
	 * Calculate real icon/image location
	 */
	@Override
	protected void postFind(
			IQueryBuilder<ProductCategory_Ds, ProductCategory_Ds, Object> builder,
			List<ProductCategory_Ds> result) throws Exception {

		String MM_PRODCATEG_ICON_BASEURL = this.getSettings().getParam(
				SysParams_Md.MM_PRODCATEG_ICON_BASEURL);

		String MM_PRODCATEG_ICON_EXT = this.getSettings().getParam(
				SysParams_Md.MM_PRODCATEG_ICON_EXT);

		for (ProductCategory_Ds ds : result) {

			if (StringUtils.isBlank(ds.getIconUrl())) {
				ds.setIconLocation(MM_PRODCATEG_ICON_BASEURL + "/"
						+ ds.getCode() + "." + MM_PRODCATEG_ICON_EXT);
			} else {
				if (!ds.getIconUrl().startsWith("http")) {
					ds.setIconLocation(MM_PRODCATEG_ICON_BASEURL + "/"
							+ ds.getIconUrl());
				} else {
					ds.setIconLocation(ds.getIconUrl());
				}
			}
		}
	}

}
