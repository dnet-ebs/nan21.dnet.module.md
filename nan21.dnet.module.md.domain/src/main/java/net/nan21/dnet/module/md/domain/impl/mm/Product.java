/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.domain.impl.mm;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.domain.impl.attr.AttributeSet;
import net.nan21.dnet.module.bd.domain.impl.uom.Uom;
import net.nan21.dnet.module.md.domain.impl.mm.ProductCategory;
import net.nan21.dnet.module.md.domain.impl.mm.ProductManufacturer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/** 
 * Product master-data.
 */
@NamedQueries({
		@NamedQuery(name = Product.NQ_FIND_BY_CODE, query = "SELECT e FROM Product e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Product.NQ_FIND_BY_NAME, query = "SELECT e FROM Product e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Product.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = Product.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = Product.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class Product extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "MD_PROD";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Product.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Product.findByName";

	@Column(name = "MANUFACTURERPRODUCTNO", length = 255)
	private String manufacturerProductNo;

	/** Link to an icon which represents this product */
	@Column(name = "ICONURL", length = 255)
	private String iconUrl;

	/** Link to an image which represents this product */
	@Column(name = "IMAGEURL", length = 255)
	private String imageUrl;

	/** Flag which specifies if it is a physical-storable item. */
	@NotNull
	@Column(name = "STORABLE", nullable = false)
	private Boolean storable;

	@Column(name = "WEIGHT", precision = 21, scale = 6)
	private BigDecimal weight;

	@Column(name = "VOLUME", precision = 21, scale = 6)
	private BigDecimal volume;

	@Column(name = "DIMWIDTH", precision = 21, scale = 6)
	private BigDecimal dimWidth;

	@Column(name = "DIMHEIGHT", precision = 21, scale = 6)
	private BigDecimal dimHeight;

	@Column(name = "DIMDEPTH", precision = 21, scale = 6)
	private BigDecimal dimDepth;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
	@JoinColumn(name = "DEFAULTUOM_ID", referencedColumnName = "ID")
	private Uom defaultUom;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
	@JoinColumn(name = "WEIGHTUOM_ID", referencedColumnName = "ID")
	private Uom weightUom;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
	@JoinColumn(name = "VOLUMEUOM_ID", referencedColumnName = "ID")
	private Uom volumeUom;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
	@JoinColumn(name = "DIMUOM_ID", referencedColumnName = "ID")
	private Uom dimUom;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductManufacturer.class)
	@JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "ID")
	private ProductManufacturer manufacturer;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AttributeSet.class)
	@JoinColumn(name = "ATTRIBUTESET_ID", referencedColumnName = "ID")
	private AttributeSet attributeSet;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductCategory.class)
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
	private ProductCategory category;

	public String getManufacturerProductNo() {
		return this.manufacturerProductNo;
	}

	public void setManufacturerProductNo(String manufacturerProductNo) {
		this.manufacturerProductNo = manufacturerProductNo;
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getStorable() {
		return this.storable;
	}

	public void setStorable(Boolean storable) {
		this.storable = storable;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getDimWidth() {
		return this.dimWidth;
	}

	public void setDimWidth(BigDecimal dimWidth) {
		this.dimWidth = dimWidth;
	}

	public BigDecimal getDimHeight() {
		return this.dimHeight;
	}

	public void setDimHeight(BigDecimal dimHeight) {
		this.dimHeight = dimHeight;
	}

	public BigDecimal getDimDepth() {
		return this.dimDepth;
	}

	public void setDimDepth(BigDecimal dimDepth) {
		this.dimDepth = dimDepth;
	}

	public Uom getDefaultUom() {
		return this.defaultUom;
	}

	public void setDefaultUom(Uom defaultUom) {
		if (defaultUom != null) {
			this.__validate_client_context__(defaultUom.getClientId());
		}
		this.defaultUom = defaultUom;
	}

	public Uom getWeightUom() {
		return this.weightUom;
	}

	public void setWeightUom(Uom weightUom) {
		if (weightUom != null) {
			this.__validate_client_context__(weightUom.getClientId());
		}
		this.weightUom = weightUom;
	}

	public Uom getVolumeUom() {
		return this.volumeUom;
	}

	public void setVolumeUom(Uom volumeUom) {
		if (volumeUom != null) {
			this.__validate_client_context__(volumeUom.getClientId());
		}
		this.volumeUom = volumeUom;
	}

	public Uom getDimUom() {
		return this.dimUom;
	}

	public void setDimUom(Uom dimUom) {
		if (dimUom != null) {
			this.__validate_client_context__(dimUom.getClientId());
		}
		this.dimUom = dimUom;
	}

	public ProductManufacturer getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(ProductManufacturer manufacturer) {
		if (manufacturer != null) {
			this.__validate_client_context__(manufacturer.getClientId());
		}
		this.manufacturer = manufacturer;
	}

	public AttributeSet getAttributeSet() {
		return this.attributeSet;
	}

	public void setAttributeSet(AttributeSet attributeSet) {
		if (attributeSet != null) {
			this.__validate_client_context__(attributeSet.getClientId());
		}
		this.attributeSet = attributeSet;
	}

	public ProductCategory getCategory() {
		return this.category;
	}

	public void setCategory(ProductCategory category) {
		if (category != null) {
			this.__validate_client_context__(category.getClientId());
		}
		this.category = category;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.storable == null) {
			this.storable = new Boolean(false);
		}
	}
}
