
package com.virgin.ecommerce.test;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude( JsonInclude.Include.NON_NULL)
public class ProductCatalog {

    @JsonProperty( "activeStartDate")
    private String               activeStartDate;
    @JsonProperty( "activeEndDate")
    private Object               activeEndDate;
    @JsonProperty( "active")
    private Boolean              active;
    @JsonProperty( "description")
    private Object               description;
    @JsonProperty( "id")
    private String               id;
    @JsonProperty( "name")
    private String               name;
    @JsonProperty( "products")
    private List<ProductDetails> products      = new ArrayList<ProductDetails>();
    @JsonProperty( "subcategories")
    private List<ProductCatalog> subcategories = new ArrayList<ProductCatalog>();
    @JsonProperty( "urlKey")
    private String               urlKey;
    @JsonProperty( "url")
    private String               url;
    @JsonProperty( "type")
    private String               type;
    @JsonProperty( "guid")
    private String               guid;

    /**
     * Gets the value of activeStartDate
     *
     * @return returns the property activeStartDate
     */

    public String getActiveStartDate() {

        return activeStartDate;
    }

    /**
     * Sets the value of property activeStartDate with value activeStartDate
     *
     * @param activeStartDate
     *            the activeStartDate to set
     */

    public void setActiveStartDate( String activeStartDate) {
        this.activeStartDate = activeStartDate;
    }

    /**
     * Gets the value of activeEndDate
     *
     * @return returns the property activeEndDate
     */

    public Object getActiveEndDate() {

        return activeEndDate;
    }

    /**
     * Sets the value of property activeEndDate with value activeEndDate
     *
     * @param activeEndDate
     *            the activeEndDate to set
     */

    public void setActiveEndDate( Object activeEndDate) {
        this.activeEndDate = activeEndDate;
    }

    /**
     * Gets the value of active
     *
     * @return returns the property active
     */

    public Boolean getActive() {

        return active;
    }

    /**
     * Sets the value of property active with value active
     *
     * @param active
     *            the active to set
     */

    public void setActive( Boolean active) {
        this.active = active;
    }

    /**
     * Gets the value of description
     *
     * @return returns the property description
     */

    public Object getDescription() {

        return description;
    }

    /**
     * Sets the value of property description with value description
     *
     * @param description
     *            the description to set
     */

    public void setDescription( Object description) {
        this.description = description;
    }

    /**
     * Gets the value of id
     *
     * @return returns the property id
     */

    public String getId() {

        return id;
    }

    /**
     * Sets the value of property id with value id
     *
     * @param id
     *            the id to set
     */

    public void setId( String id) {
        this.id = id;
    }

    /**
     * Gets the value of name
     *
     * @return returns the property name
     */

    public String getName() {

        return name;
    }

    /**
     * Sets the value of property name with value name
     *
     * @param name
     *            the name to set
     */

    public void setName( String name) {
        this.name = name;
    }

    /**
     * Gets the value of products
     *
     * @return returns the property products
     */

    public List<ProductDetails> getProducts() {

        return products;
    }

    /**
     * Sets the value of property products with value products
     *
     * @param products
     *            the products to set
     */

    public void setProducts( List<ProductDetails> products) {
        this.products = products;
    }

    /**
     * Gets the value of subcategories
     *
     * @return returns the property subcategories
     */

    public List<ProductCatalog> getSubcategories() {

        return subcategories;
    }

    /**
     * Sets the value of property subcategories with value subcategories
     *
     * @param subcategories
     *            the subcategories to set
     */

    public void setSubcategories( List<ProductCatalog> subcategories) {
        this.subcategories = subcategories;
    }

    /**
     * Gets the value of urlKey
     *
     * @return returns the property urlKey
     */

    public String getUrlKey() {

        return urlKey;
    }

    /**
     * Sets the value of property urlKey with value urlKey
     *
     * @param urlKey
     *            the urlKey to set
     */

    public void setUrlKey( String urlKey) {
        this.urlKey = urlKey;
    }

    /**
     * Gets the value of url
     *
     * @return returns the property url
     */

    public String getUrl() {

        return url;
    }

    /**
     * Sets the value of property url with value url
     *
     * @param url
     *            the url to set
     */

    public void setUrl( String url) {
        this.url = url;
    }

    /**
     * Gets the value of type
     *
     * @return returns the property type
     */

    public String getType() {

        return type;
    }

    /**
     * Sets the value of property type with value type
     *
     * @param type
     *            the type to set
     */

    public void setType( String type) {
        this.type = type;
    }

    /**
     * Gets the value of guid
     *
     * @return returns the property guid
     */

    public String getGuid() {

        return guid;
    }

    /**
     * Sets the value of property guid with value guid
     *
     * @param guid
     *            the guid to set
     */

    public void setGuid( String guid) {
        this.guid = guid;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "ProductCatalog [activeStartDate=" + activeStartDate + ", activeEndDate=" + activeEndDate + ", active=" + active + ", description=" + description
                + ", id=" + id + ", name=" + name + ", urlKey=" + urlKey + ", url=" + url + ", type=" + type + ", guid=" + guid + "]";
    }

}
