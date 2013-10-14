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
import net.nan21.dnet.module.md.domain.impl.mm.Product;
import net.nan21.dnet.module.md.presenter.impl.mm.model.Product_Ds;

public class Product_DsService extends
		AbstractEntityDsService<Product_Ds, Product_Ds, Object, Product>
		implements IDsService<Product_Ds, Product_Ds, Object> {

	@Override
	protected void postFind(
			IQueryBuilder<Product_Ds, Product_Ds, Object> builder,
			List<Product_Ds> result) throws Exception {

		String MM_PRODUCT_ICON_BASEURL = this.getSettings().getParam(
				SysParams_Md.MM_PRODUCT_ICON_BASEURL);

		String MM_PRODUCT_ICON_EXT = this.getSettings().getParam(
				SysParams_Md.MM_PRODUCT_ICON_EXT);

		String MM_PRODUCT_ICON_SUFFIX = this.getSettings().getParam(
				SysParams_Md.MM_PRODUCT_ICON_SUFFIX);

		for (Product_Ds ds : result) {

			if (StringUtils.isBlank(ds.getIconUrl())) {
				ds.setIconLocation(MM_PRODUCT_ICON_BASEURL + "/" + ds.getCode()
						+ MM_PRODUCT_ICON_SUFFIX + "." + MM_PRODUCT_ICON_EXT);
			} else {
				if (!ds.getIconUrl().startsWith("http")) {
					ds.setIconLocation(MM_PRODUCT_ICON_BASEURL + "/"
							+ ds.getIconUrl());
				} else {
					ds.setIconLocation(ds.getIconUrl());
				}
			}
		}

	}

}
