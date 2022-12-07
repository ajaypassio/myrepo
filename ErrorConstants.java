/*
 * PEARSON PROPRIETARY AND CONFIDENTIAL INFORMATION SUBJECT TO NDA 
 * Copyright (c) 2018 Pearson Education, Inc.
 * All Rights Reserved. 
 * 
 * NOTICE: All information contained herein is, and remains the property of 
 * Pearson Education, Inc. The intellectual and technical concepts contained 
 * herein are proprietary to Pearson Education, Inc. and may be covered by U.S. 
 * and Foreign Patents, patent applications, and are protected by trade secret 
 * or copyright law. Dissemination of this information, reproduction of this  
 * material, and copying or distribution of this software is strictly forbidden   
 * unless prior written permission is obtained from Pearson Education, Inc.
 */
package com.pearson.glp.cms.constants;

/**
 * The Class ErrorConstants.
 */
public final class ErrorConstants {

  /** The Constant MESSAGE_BAD_REQUEST. */
  public static final String MESSAGE_BAD_REQUEST = "The request does not comply with the expected schema";

  /** The Constant MESSAGE_UNAUTHORIZED. */
  public static final String MESSAGE_UNAUTHORIZED = "The request made to a resource requires authentication";

  /** The Constant MESSAGE_INTERNAL_SERVER_ERROR. */
  public static final String MESSAGE_INTERNAL_SERVER_ERROR = "The request can not be processed";

  /** The Constant MESSAGE_NOT_FOUND. */
  public static final String MESSAGE_NOT_FOUND = "The requested resource is not available";

  /** The Constant MESSAGE_UNSUPPORTED_MEDIA_TYPE. */
  public static final String MESSAGE_UNSUPPORTED_MEDIA_TYPE = "The resource cannot provide a representation that meets the request requirements in regards of its Content-Type.";

  /** The Constant MESSAGE_METHOD_NOT_ALLOWED. */
  public static final String MESSAGE_METHOD_NOT_ALLOWED = "Requested HTTP Method is not allowed/supported on the resource";

  /** The Constant MESSAGE_NOT_ACCEPTED. */
  public static final String MESSAGE_NOT_ACCEPTED = "The resource cannot provide a representation that meets the request requirements in regards of its Accept.";

  /** The Constant ERROR_METHOD_NOT_ALLOWED. */
  public static final String ERROR_METHOD_NOT_ALLOWED = "METHOD NOT ALLOWED";

  /** The Constant ERROR_NOT_ACCEPTED. */
  public static final String ERROR_NOT_ACCEPTED = "NOT ACCEPTED";

  /** The Constant VALIDATION_FAILED. */
  public static final String VALIDATION_FAILED = "The request validation has failed.";

  /** The Constant INVALID_REQUEST_PAYLOAD. */
  public static final String INVALID_REQUEST_PAYLOAD = "Invalid Request Payload";

  /** The Constant PAYLOAD_ABSENT. */
  public static final String PAYLOAD_REGEX = ".*Payload.*";

  /** The Constant ACCEPT_HEADER_KEY. */
  public static final String ACCEPT_HEADER_KEY = "Accept";

  /** The Constant INVALID_ACCEPT_HEADER_VALUE. */
  public static final String INVALID_ACCEPT_HEADER_VALUE = "invalid";

  /** The Constant ERROR_404. */
  public static final String ERROR_404 = "404";

  /** The Constant NO_RESPONSE. */
  public static final String NO_RESPONSE = "Could not get any response from upstream server";

  /** The Constant EXPIRES_ON_SHOULD_BE_FUTURE_DATE. */
  public static final String EXPIRES_ON_SHOULD_BE_FUTURE_DATE = "expiresOn should be a future date and time";

  /** The Constant PRODUCT_CONF_FETCH_ERROR. */
  public static final String PRODUCT_CONF_FETCH_ERROR = "Product configuration does not exist.";

  /** The Constant ERROR_PROCESSING_REQUEST. */
  public static final String ERROR_PROCESSING_REQUEST = "There was an error processing the request.";

  /** The Constant NO_POLICY_AVAILABLE. */
  public static final String NO_POLICY_AVAILABLE = "There is no policy available for this product id %s & version %s";

  /** The Constant INVALID_QUERY. */
  public static final String INVALID_QUERY = "Invalid Query Param used";

  /** The Constant POLICY_NOT_FOUND. */
  public static final String POLICY_NOT_FOUND = "The requested policy doesn't exist.";

  /** The Constant NO_PRODUCT_MODEL_POLICY_AVAILABLE. */
  public static final String NO_PRODUCT_MODEL_POLICY_AVAILABLE = "There is no policy available for this product model id %s & version %s";

  /** The Constant PRODUCT_MODEL_CONF_FETCH_ERROR. */
  public static final String PRODUCT_MODEL_CONF_FETCH_ERROR = "Product model configuration does not exist.";

  /** The Constant ERROR_PRODUCT_ASSESSMENT_TYPE_FETCH. */
  public static final String ERROR_PRODUCT_ASSESSMENT_TYPE_FETCH = "Error occurred while fetching assessment type of scanned product {}.";

  /** The Constant INCORRECT_CATEGORY_WEIGHTAGE. */
  public static final String INCORRECT_CATEGORY_WEIGHTAGE = "Sum of category weights for assessment types is not equal to 100. It must be equal to 100.";

  /**
   * Instantiates a new error constants.
   */
  private ErrorConstants() {
    super();
  }
}
