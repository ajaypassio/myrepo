
package com.virgin.ecommerce.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class maps ItsOn json schema .
 */
@JsonInclude( JsonInclude.Include.NON_NULL)
public class Product implements Comparable<Product> {

    /** The Constant DisplayOrderComparator. */
    public static final Comparator<Product> DisplayOrderComparator = new Comparator<Product>() {

                                                                       @Override
                                                                       public int compare( Product o1, Product o2) {
                                                                           return o1.getDisplayOrder() - o2.getDisplayOrder();
                                                                       }
                                                                   };

    /** The Constant NameComparator. */
    public static final Comparator<Product> NameComparator         = new Comparator<Product>() {

                                                                       @Override
                                                                       public int compare( Product o1, Product o2) {
                                                                           return o1.getName().compareTo(o2.getName());
                                                                       }
                                                                   };

    /** The product type. */
    @JsonProperty( "productType")
    private String                          productType;

    /** The name. */
    @JsonProperty( "name")
    private String                          name;

    /** The display order. */
    @JsonProperty( "displayOrder")
    private Integer                         displayOrder;

    /** The product id. */
    @JsonProperty( "productId")
    private Integer                         productId;

    /** The retail price. */
    @JsonProperty( "retailPrice")
    private Price                           retailPrice;

    /** The sale price. */
    @JsonProperty( "salePrice")
    private Object                          salePrice;

    /** The icon url. */
    @JsonProperty( "iconUrl")
    private String                          iconUrl;

    // This variable maps with the shortDescription coming in ItsOn json.
    /** The short description. */
    @JsonProperty( "shortDescription")
    private String                          shortDescription;

    // This variable maps with the longDescription coming in ItsOn json.
    /** The long description. */
    @JsonProperty( "longDescription")
    private String                          longDescription;

    /** The usage limit in bytes. */
    @JsonProperty( "usageLimitInBytes")
    private Object                          usageLimitInBytes;

    /** The usage limit in messages. */
    @JsonProperty( "usageLimitInMessages")
    private Object                          usageLimitInMessages;

    /** The usage limit in seconds. */
    @JsonProperty( "usageLimitInSeconds")
    private Object                          usageLimitInSeconds;

    /** The bundle items. */
    @JsonProperty( "bundleItems")
    private List<Product>                   bundleItems            = new ArrayList<Product>();

    /** The is hidden. */
    @JsonProperty( "isHidden")
    private Boolean                         isHidden;

    /** The color. */
    private String                          color;

    /** The installment price. */
    private Price                           installmentPrice;

    /** The memory. */
    private String                          memory;

    /** The is pre loved. */
    private boolean                         isPreLoved;

    /** The type. */
    private String                          type;

    /** The Specs. */
    private String                          Specs;

    /** The Features. */
    private String                          Features;

    /** The new price installment. */
    private Price                           newPriceInstallment;

    /** The pre loved price installment. */
    private Price                           preLovedPriceInstallment;

    /*
     * Variables for Accessories json shortDesc, typeName, typeId
     */

    /** The short desc. */
    @JsonIgnore
    private String                          shortDesc;

    /** The type name. */
    @JsonIgnore
    private String                          typeName;

    /** The type id. */
    @JsonIgnore
    private String                          typeId;

    /**
     * Gets the type id.
     *
     * @return the type id
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * Sets the type id.
     *
     * @param typeId
     *            the type id
     */
    public void setTypeId( String typeId) {
        this.typeId = typeId;
    }

    /**
     * Gets the type name.
     *
     * @return the type name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the type name.
     *
     * @param typeName
     *            the type name
     */
    public void setTypeName( String typeName) {
        this.typeName = typeName;
    }

    /**
     * Gets the short description if set separately using setShortDesc (). *
     * 
     * @return the short desc
     */
    public String getShortDesc() {
        return shortDesc;
    }

    /**
     * Sets the short short description which could be accessed later using getShortDesc().
     *
     * @param shortDesc
     *            the short desc
     */
    public void setShortDesc( String shortDesc) {
        this.shortDesc = shortDesc;
    }

    /**
     * Gets the new price installment.
     *
     * @return the new price installment
     */
    public Price getNewPriceInstallment() {

        return newPriceInstallment;
    }

    /**
     * Sets the new price installment.
     *
     * @param pNewPriceInstallment
     *            the new price installment
     */
    public void setNewPriceInstallment( Price pNewPriceInstallment) {
        newPriceInstallment = pNewPriceInstallment;
    }

    /**
     * Gets the pre loved price installment.
     *
     * @return the pre loved price installment
     */
    public Price getPreLovedPriceInstallment() {

        return preLovedPriceInstallment;
    }

    /**
     * Sets the pre loved price installment.
     *
     * @param pPreLovedPriceInstallment
     *            the pre loved price installment
     */
    public void setPreLovedPriceInstallment( Price pPreLovedPriceInstallment) {
        preLovedPriceInstallment = pPreLovedPriceInstallment;
    }

    /**
     * Gets the color.
     *
     * @return the color
     */
    public String getColor() {

        return color;
    }

    /**
     * Sets the color.
     *
     * @param pColor
     *            the color
     */
    public void setColor( String pColor) {
        color = pColor;
    }

    /**
     * Gets the memory.
     *
     * @return the memory
     */
    public String getMemory() {

        return memory;
    }

    /**
     * Sets the memory.
     *
     * @param pMemory
     *            the memory
     */
    public void setMemory( String pMemory) {
        memory = pMemory;
    }

    /**
     * Gets the is pre loved.
     *
     * @return the checks if is pre loved
     */
    public boolean getIsPreLoved() {

        return isPreLoved;
    }

    /**
     * Sets the is pre loved.
     *
     * @param pIsPreLoved
     *            the checks if is pre loved
     */
    public void setIsPreLoved( boolean pIsPreLoved) {
        isPreLoved = pIsPreLoved;
    }

    /**
     * Gets the specs.
     *
     * @return the specs
     */
    public String getSpecs() {

        return Specs;
    }

    /**
     * Sets the specs.
     *
     * @param pSpecs
     *            the specs
     */
    public void setSpecs( String pSpecs) {
        Specs = pSpecs;
    }

    /**
     * Gets the features.
     *
     * @return the features
     */
    public String getFeatures() {

        return Features;
    }

    /**
     * Sets the features.
     *
     * @param pFeatures
     *            the features
     */
    public void setFeatures( String pFeatures) {
        Features = pFeatures;
    }

    /**
     * Gets the product type.
     *
     * @return The productType
     */
    @JsonProperty( "productType")
    public String getProductType() {
        return productType;
    }

    /**
     * Sets the product type.
     *
     * @param productType
     *            The productType
     */
    @JsonProperty( "productType")
    public void setProductType( String productType) {
        this.productType = productType;
    }

    /**
     * Gets the name.
     *
     * @return The name
     */
    @JsonProperty( "name")
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            The name
     */
    @JsonProperty( "name")
    public void setName( String name) {
        this.name = name;
    }

    /**
     * Gets the display order.
     *
     * @return The displayOrder
     */
    @JsonProperty( "displayOrder")
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * Sets the display order.
     *
     * @param displayOrder
     *            The displayOrder
     */
    @JsonProperty( "displayOrder")
    public void setDisplayOrder( Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * Gets the product id.
     *
     * @return The productId
     */
    @JsonProperty( "productId")
    public Integer getProductId() {
        return productId;
    }

    /**
     * Sets the product id.
     *
     * @param productId
     *            The productId
     */
    @JsonProperty( "productId")
    public void setProductId( Integer productId) {
        this.productId = productId;
    }

    /**
     * Gets the retail price.
     *
     * @return The retailPrice
     */
    @JsonProperty( "retailPrice")
    public Price getRetailPrice() {
        return retailPrice;
    }

    /**
     * Sets the retail price.
     *
     * @param retailPrice
     *            The retailPrice
     */
    @JsonProperty( "retailPrice")
    public void setRetailPrice( Price retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * Gets the sale price.
     *
     * @return The salePrice
     */
    @JsonProperty( "salePrice")
    public Object getSalePrice() {
        return salePrice;
    }

    /**
     * Sets the sale price.
     *
     * @param salePrice
     *            The salePrice
     */
    @JsonProperty( "salePrice")
    public void setSalePrice( Object salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * Gets the icon url.
     *
     * @return The iconUrl
     */
    @JsonProperty( "iconUrl")
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * Sets the icon url.
     *
     * @param iconUrl
     *            The iconUrl
     */
    @JsonProperty( "iconUrl")
    public void setIconUrl( String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * This method maps the shortDescription coming in ItsOn json.
     *
     * @return The shortDescription
     */
    @JsonProperty( "shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * This method maps the shortDescription coming in ItsOn json.
     *
     * @param shortDescription
     *            The shortDescription
     */
    @JsonProperty( "shortDescription")
    public void setShortDescription( String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * This method maps the longDescription coming in ItsOn json.
     *
     * @return The longDescription
     */
    @JsonProperty( "longDescription")
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * This method maps the longDescription coming in ItsOn json.
     *
     * @param longDescription
     *            The longDescription
     */
    @JsonProperty( "longDescription")
    public void setLongDescription( String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * Gets the usage limit in bytes.
     *
     * @return The usageLimitInBytes
     */
    @JsonProperty( "usageLimitInBytes")
    public Object getUsageLimitInBytes() {
        return usageLimitInBytes;
    }

    /**
     * Sets the usage limit in bytes.
     *
     * @param usageLimitInBytes
     *            The usageLimitInBytes
     */
    @JsonProperty( "usageLimitInBytes")
    public void setUsageLimitInBytes( Object usageLimitInBytes) {
        this.usageLimitInBytes = usageLimitInBytes;
    }

    /**
     * Gets the usage limit in messages.
     *
     * @return The usageLimitInMessages
     */
    @JsonProperty( "usageLimitInMessages")
    public Object getUsageLimitInMessages() {
        return usageLimitInMessages;
    }

    /**
     * Sets the usage limit in messages.
     *
     * @param usageLimitInMessages
     *            The usageLimitInMessages
     */
    @JsonProperty( "usageLimitInMessages")
    public void setUsageLimitInMessages( Object usageLimitInMessages) {
        this.usageLimitInMessages = usageLimitInMessages;
    }

    /**
     * Gets the usage limit in seconds.
     *
     * @return The usageLimitInSeconds
     */
    @JsonProperty( "usageLimitInSeconds")
    public Object getUsageLimitInSeconds() {
        return usageLimitInSeconds;
    }

    /**
     * Sets the usage limit in seconds.
     *
     * @param usageLimitInSeconds
     *            The usageLimitInSeconds
     */
    @JsonProperty( "usageLimitInSeconds")
    public void setUsageLimitInSeconds( Object usageLimitInSeconds) {
        this.usageLimitInSeconds = usageLimitInSeconds;
    }

    /**
     * Gets the bundle items.
     *
     * @return The bundleItems
     */
    @JsonProperty( "bundleItems")
    public List<Product> getBundleItems() {
        return bundleItems;
    }

    /**
     * Sets the bundle items.
     *
     * @param bundleItems
     *            The bundleItems
     */
    @JsonProperty( "bundleItems")
    public void setBundleItems( List<Product> bundleItems) {
        this.bundleItems = bundleItems;
    }

    /**
     * Gets the is hidden.
     *
     * @return The isHidden
     */
    @JsonProperty( "isHidden")
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     * Sets the is hidden.
     *
     * @param isHidden
     *            The isHidden
     */
    @JsonProperty( "isHidden")
    public void setIsHidden( Boolean isHidden) {
        this.isHidden = isHidden;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {

        return type;
    }

    /**
     * Sets the type.
     *
     * @param pType
     *            the type
     */
    public void setType( String pType) {
        type = pType;
    }

    /**
     * Gets the installment price.
     *
     * @return the installment price
     */
    public Price getInstallmentPrice() {

        return installmentPrice;
    }

    /**
     * Sets the installment price.
     *
     * @param installmentPrice
     *            the installment price
     */
    public void setInstallmentPrice( Price installmentPrice) {
        this.installmentPrice = installmentPrice;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */

    @Override
    public int compareTo( Product o) {
        return this.getDisplayOrder() - o.getDisplayOrder();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((displayOrder == null) ? 0 : displayOrder.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals( Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (displayOrder == null) {
            if (other.displayOrder != null)
                return false;
        } else if (!displayOrder.equals(other.displayOrder))
            return false;
        return true;
    }

}