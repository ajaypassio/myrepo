
package com.virgin.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class maps Retail Price node.
 */
@JsonInclude( JsonInclude.Include.NON_NULL)
public class Price {

    /** The amount. */
    @JsonProperty( "amount")
    private String amount;

    /** The currency. */
    @JsonProperty( "currency")
    private String currency;

    /** The total installments. */
    @JsonProperty( "totalInstallments")
    private String totalInstallments;

    /** The cycle. */
    @JsonProperty( "cycle")
    private String cycle;

    /**
     * Gets the total installments.
     *
     * @return the total installments
     */
    public String getTotalInstallments() {

        return totalInstallments;
    }

    /**
     * Sets the total installments.
     *
     * @param pTotalInstallments
     *            the total installments
     */
    public void setTotalInstallments( String pTotalInstallments) {
        totalInstallments = pTotalInstallments;
    }

    /**
     * Gets the cycle.
     *
     * @return the cycle
     */
    public String getCycle() {

        return cycle;
    }

    /**
     * Sets the cycle.
     *
     * @param pCycle
     *            the cycle
     */
    public void setCycle( String pCycle) {
        cycle = pCycle;
    }

    /**
     * Gets the amount.
     *
     * @return The amount
     */
    @JsonProperty( "amount")
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount
     *            The amount
     */
    @JsonProperty( "amount")
    public void setAmount( String amount) {
        this.amount = amount;
    }

    /**
     * Gets the currency.
     *
     * @return The currency
     */
    @JsonProperty( "currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency.
     *
     * @param currency
     *            The currency
     */
    @JsonProperty( "currency")
    public void setCurrency( String currency) {
        this.currency = currency;
    }

}
