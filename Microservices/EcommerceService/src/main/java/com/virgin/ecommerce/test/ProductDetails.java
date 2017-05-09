
package com.virgin.ecommerce.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude( JsonInclude.Include.NON_NULL)
public class ProductDetails {

    @JsonProperty( "productType")
    private String               productType;
    @JsonProperty( "name")
    private String               name;
    @JsonProperty( "displayOrder")
    private Integer              displayOrder;
    @JsonProperty( "productId")
    private Integer              productId;
    @JsonProperty( "retailPrice")
    private Map<String, String>  retailPrice = new HashMap<String, String>();
    @JsonProperty( "salePrice")
    private Object               salePrice;
    @JsonProperty( "iconUrl")
    private Object               iconUrl;
    @JsonProperty( "shortDescription")
    private Object               shortDescription;
    @JsonProperty( "longDescription")
    private Object               longDescription;
    @JsonProperty( "usageLimitInBytes")
    private Long                 usageLimitInBytes;
    @JsonProperty( "usageLimitInMessages")
    private Object               usageLimitInMessages;
    @JsonProperty( "usageLimitInSeconds")
    private Object               usageLimitInSeconds;
    @JsonProperty( "bundleItems")
    private List<ProductDetails> bundleItems = new ArrayList<ProductDetails>();
    @JsonProperty( "isHidden")
    private Boolean              isHidden;

    /**
     * 
     * @return The productType
     */
    @JsonProperty( "productType")
    public String getProductType() {
        return productType;
    }

    /**
     * 
     * @param productType
     *            The productType
     */
    @JsonProperty( "productType")
    public void setProductType( String productType) {
        this.productType = productType;
    }

    /**
     * 
     * @return The name
     */
    @JsonProperty( "name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *            The name
     */
    @JsonProperty( "name")
    public void setName( String name) {
        this.name = name;
    }

    /**
     * 
     * @return The displayOrder
     */
    @JsonProperty( "displayOrder")
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * 
     * @param displayOrder
     *            The displayOrder
     */
    @JsonProperty( "displayOrder")
    public void setDisplayOrder( Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * 
     * @return The productId
     */
    @JsonProperty( "productId")
    public Integer getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId
     *            The productId
     */
    @JsonProperty( "productId")
    public void setProductId( Integer productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return The retailPrice
     */
    @JsonProperty( "retailPrice")
    public Map<String, String> getRetailPrice() {
        return retailPrice;
    }

    /**
     * 
     * @param retailPrice
     *            The retailPrice
     */
    @JsonProperty( "retailPrice")
    public void setRetailPrice( Map<String, String> retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 
     * @return The salePrice
     */
    @JsonProperty( "salePrice")
    public Object getSalePrice() {
        return salePrice;
    }

    /**
     * 
     * @param salePrice
     *            The salePrice
     */
    @JsonProperty( "salePrice")
    public void setSalePrice( Object salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * 
     * @return The iconUrl
     */
    @JsonProperty( "iconUrl")
    public Object getIconUrl() {
        return iconUrl;
    }

    /**
     * 
     * @param iconUrl
     *            The iconUrl
     */
    @JsonProperty( "iconUrl")
    public void setIconUrl( Object iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * 
     * @return The shortDescription
     */
    @JsonProperty( "shortDescription")
    public Object getShortDescription() {
        return shortDescription;
    }

    /**
     * 
     * @param shortDescription
     *            The shortDescription
     */
    @JsonProperty( "shortDescription")
    public void setShortDescription( Object shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * 
     * @return The longDescription
     */
    @JsonProperty( "longDescription")
    public Object getLongDescription() {
        return longDescription;
    }

    /**
     * 
     * @param longDescription
     *            The longDescription
     */
    @JsonProperty( "longDescription")
    public void setLongDescription( Object longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * 
     * @return The usageLimitInBytes
     */
    @JsonProperty( "usageLimitInBytes")
    public Long getUsageLimitInBytes() {
        return usageLimitInBytes;
    }

    /**
     * 
     * @param usageLimitInBytes
     *            The usageLimitInBytes
     */
    @JsonProperty( "usageLimitInBytes")
    public void setUsageLimitInBytes( Long usageLimitInBytes) {
        this.usageLimitInBytes = usageLimitInBytes;
    }

    /**
     * 
     * @return The usageLimitInMessages
     */
    @JsonProperty( "usageLimitInMessages")
    public Object getUsageLimitInMessages() {
        return usageLimitInMessages;
    }

    /**
     * 
     * @param usageLimitInMessages
     *            The usageLimitInMessages
     */
    @JsonProperty( "usageLimitInMessages")
    public void setUsageLimitInMessages( Object usageLimitInMessages) {
        this.usageLimitInMessages = usageLimitInMessages;
    }

    /**
     * 
     * @return The usageLimitInSeconds
     */
    @JsonProperty( "usageLimitInSeconds")
    public Object getUsageLimitInSeconds() {
        return usageLimitInSeconds;
    }

    /**
     * 
     * @param usageLimitInSeconds
     *            The usageLimitInSeconds
     */
    @JsonProperty( "usageLimitInSeconds")
    public void setUsageLimitInSeconds( Object usageLimitInSeconds) {
        this.usageLimitInSeconds = usageLimitInSeconds;
    }

    /**
     * 
     * @return The bundleItems
     */
    @JsonProperty( "bundleItems")
    public List<ProductDetails> getBundleItems() {
        return bundleItems;
    }

    /**
     * 
     * @param bundleItems
     *            The bundleItems
     */
    @JsonProperty( "bundleItems")
    public void setBundleItems( List<ProductDetails> bundleItems) {
        this.bundleItems = bundleItems;
    }

    /**
     * 
     * @return The isHidden
     */
    @JsonProperty( "isHidden")
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     * 
     * @param isHidden
     *            The isHidden
     */
    @JsonProperty( "isHidden")
    public void setIsHidden( Boolean isHidden) {
        this.isHidden = isHidden;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "ProductDetails [productType=" + productType + ", name=" + name + ", displayOrder=" + displayOrder + ", productId=" + productId
                + ", retailPrice=" + retailPrice + ", salePrice=" + salePrice + ", iconUrl=" + iconUrl + ", shortDescription=" + shortDescription
                + ", longDescription=" + longDescription + ", usageLimitInBytes=" + usageLimitInBytes + ", usageLimitInMessages=" + usageLimitInMessages
                + ", usageLimitInSeconds=" + usageLimitInSeconds + ", bundleItems=" + bundleItems + ", isHidden=" + isHidden + "]";
    }

}
