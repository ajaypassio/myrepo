
package com.virgin.ecommerce.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * Class to map the product category (i.e. New/Pre-loved)
 * </p>
 * .
 *
 * @author vm00436370
 * @project EmailService
 * @updated DateTime: Nov 14, 2016 4:47:34 PM Author: vm00436370
 */

@JsonInclude( JsonInclude.Include.NON_NULL)
public class ProductCategory {

    /** The category type. */
    @JsonProperty( "categoryType")
    private String        categoryType;

    /** The is preloved. */
    @JsonIgnore
    private boolean       isPreloved;

    /** The products. */
    @JsonProperty( "products")
    private List<Product> products;

    /**
     * Gets the category type.
     *
     * @return the category type
     */
    public String getCategoryType() {

        return categoryType;
    }

    /**
     * Sets the category type.
     *
     * @param pCategoryType
     *            the category type
     */
    public void setCategoryType( String pCategoryType) {
        categoryType = pCategoryType;
    }

    /**
     * Gets the products.
     *
     * @return the products
     */
    public List<Product> getProducts() {

        return products;
    }

    /**
     * Sets the products.
     *
     * @param pProducts
     *            the products
     */
    public void setProducts( List<Product> pProducts) {
        products = pProducts;
    }

    /**
     * Gets the is preloved.
     *
     * @return the checks if is preloved
     */
    public boolean getIsPreloved() {

        return isPreloved;
    }

    /**
     * Sets the is preloved.
     *
     * @param pIsPreloved
     *            the checks if is preloved
     */
    public void setIsPreloved( boolean pIsPreloved) {
        isPreloved = pIsPreloved;
    }

}
