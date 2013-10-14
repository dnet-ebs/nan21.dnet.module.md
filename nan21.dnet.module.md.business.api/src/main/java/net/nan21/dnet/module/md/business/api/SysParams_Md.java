/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.business.api;

import java.util.Collection;

import net.nan21.dnet.core.api.descriptor.AbstractSysParams;
import net.nan21.dnet.core.api.descriptor.ISysParamDefinition;
import net.nan21.dnet.core.api.descriptor.SysParamDefinition;
 /*
 Set default values in application properties file:


# Product category icon base url
# 
sysparam.MM_PRODCATEG_ICON_BASEURL=http://dnet.nan21.net/static-demo-resources/MM/product-categories

# Product category icon default extension
# 
sysparam.MM_PRODCATEG_ICON_EXT=jpg

# Manufacturer icon base url
# 
sysparam.MM_MANUFACT_ICON_BASEURL=http://dnet.nan21.net/static-demo-resources/MM/product-manufacturers

# Manufacturer icon default extension
# 
sysparam.MM_MANUFACT_ICON_EXT=jpg

# Product icon base url
# 
sysparam.MM_PRODUCT_ICON_BASEURL=http://dnet.nan21.net/static-demo-resources/MM/products

# Product icon default extension
# 
sysparam.MM_PRODUCT_ICON_EXT=jpg

# Product icon default suffix
# 
sysparam.MM_PRODUCT_ICON_SUFFIX=-small

# Product image base url
# 
sysparam.MM_PRODUCT_IMAGE_BASEURL=http://dnet.nan21.net/static-demo-resources/MM/products

# Product image default extension
# 
sysparam.MM_PRODUCT_IMAGE_EXT=jpg

# Product image default suffix
# 
sysparam.MM_PRODUCT_IMAGE_SUFFIX=

Declare bean in spring xml: 

<bean name="sysparams" class="net.nan21.dnet.module.md.business.api.SysParams_Md">
	<property name="defaultValues">
		<props>
			<prop key="MM_PRODCATEG_ICON_BASEURL">${sysparam.MM_PRODCATEG_ICON_BASEURL}</prop>
			<prop key="MM_PRODCATEG_ICON_EXT">${sysparam.MM_PRODCATEG_ICON_EXT}</prop>
			<prop key="MM_MANUFACT_ICON_BASEURL">${sysparam.MM_MANUFACT_ICON_BASEURL}</prop>
			<prop key="MM_MANUFACT_ICON_EXT">${sysparam.MM_MANUFACT_ICON_EXT}</prop>
			<prop key="MM_PRODUCT_ICON_BASEURL">${sysparam.MM_PRODUCT_ICON_BASEURL}</prop>
			<prop key="MM_PRODUCT_ICON_EXT">${sysparam.MM_PRODUCT_ICON_EXT}</prop>
			<prop key="MM_PRODUCT_ICON_SUFFIX">${sysparam.MM_PRODUCT_ICON_SUFFIX}</prop>
			<prop key="MM_PRODUCT_IMAGE_BASEURL">${sysparam.MM_PRODUCT_IMAGE_BASEURL}</prop>
			<prop key="MM_PRODUCT_IMAGE_EXT">${sysparam.MM_PRODUCT_IMAGE_EXT}</prop>
			<prop key="MM_PRODUCT_IMAGE_SUFFIX">${sysparam.MM_PRODUCT_IMAGE_SUFFIX}</prop>
		</props>
	</property>
</bean>
 */
public class SysParams_Md extends AbstractSysParams {

	public static final String MM_PRODCATEG_ICON_BASEURL = "MM_PRODCATEG_ICON_BASEURL";
	public static final String MM_PRODCATEG_ICON_EXT = "MM_PRODCATEG_ICON_EXT";
	public static final String MM_MANUFACT_ICON_BASEURL = "MM_MANUFACT_ICON_BASEURL";
	public static final String MM_MANUFACT_ICON_EXT = "MM_MANUFACT_ICON_EXT";
	public static final String MM_PRODUCT_ICON_BASEURL = "MM_PRODUCT_ICON_BASEURL";
	public static final String MM_PRODUCT_ICON_EXT = "MM_PRODUCT_ICON_EXT";
	public static final String MM_PRODUCT_ICON_SUFFIX = "MM_PRODUCT_ICON_SUFFIX";
	public static final String MM_PRODUCT_IMAGE_BASEURL = "MM_PRODUCT_IMAGE_BASEURL";
	public static final String MM_PRODUCT_IMAGE_EXT = "MM_PRODUCT_IMAGE_EXT";
	public static final String MM_PRODUCT_IMAGE_SUFFIX = "MM_PRODUCT_IMAGE_SUFFIX";

	protected void initParams(Collection<ISysParamDefinition> params) {
		
		params.add(new SysParamDefinition(MM_PRODCATEG_ICON_BASEURL,
			"Product category icon base url",
			"",
			SysParamDefinition.TYPE_STRING,
			getDefaultValue(MM_PRODCATEG_ICON_BASEURL), null));
		
		params.add(new SysParamDefinition(MM_PRODCATEG_ICON_EXT,
			"Product category icon default extension",
			"",
			SysParamDefinition.TYPE_STRING,
			getDefaultValue(MM_PRODCATEG_ICON_EXT), null));
		
		params.add(new SysParamDefinition(MM_MANUFACT_ICON_BASEURL,
			"Manufacturer icon base url",
			"",
			SysParamDefinition.TYPE_STRING,
			getDefaultValue(MM_MANUFACT_ICON_BASEURL), null));
		
		params.add(new SysParamDefinition(MM_MANUFACT_ICON_EXT,
			"Manufacturer icon default extension",
			"",
			SysParamDefinition.TYPE_STRING,
			getDefaultValue(MM_MANUFACT_ICON_EXT), null));
		
		params.add(new SysParamDefinition(MM_PRODUCT_ICON_BASEURL,
			"Product icon base url",
			"",
			SysParamDefinition.TYPE_STRING,
			getDefaultValue(MM_PRODUCT_ICON_BASEURL), null));
		
		params.add(new SysParamDefinition(MM_PRODUCT_ICON_EXT,
			"Product icon default extension",
			"",
			SysParamDefinition.TYPE_STRING,
			getDefaultValue(MM_PRODUCT_ICON_EXT), null));
		
		params.add(new SysParamDefinition(MM_PRODUCT_ICON_SUFFIX,
			"Product icon default suffix",
			"",
			SysParamDefinition.TYPE_STRING,
			getDefaultValue(MM_PRODUCT_ICON_SUFFIX), null));
		
		params.add(new SysParamDefinition(MM_PRODUCT_IMAGE_BASEURL,
			"Product image base url",
			"",
			SysParamDefinition.TYPE_STRING,
			getDefaultValue(MM_PRODUCT_IMAGE_BASEURL), null));
		
		params.add(new SysParamDefinition(MM_PRODUCT_IMAGE_EXT,
			"Product image default extension",
			"",
			SysParamDefinition.TYPE_STRING,
			getDefaultValue(MM_PRODUCT_IMAGE_EXT), null));
		
		params.add(new SysParamDefinition(MM_PRODUCT_IMAGE_SUFFIX,
			"Product image default suffix",
			"",
			SysParamDefinition.TYPE_STRING,
			getDefaultValue(MM_PRODUCT_IMAGE_SUFFIX), null));
	}
}
