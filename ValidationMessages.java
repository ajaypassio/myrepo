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
 * The Class ValidationMessages.
 */
public final class ValidationMessages {

  /** The Constant INVALID_LANGUAGE_INPUT. */
  public static final String INCORRECT_LANG = "invalid language code";

  /** The Constant INCORRECT_METHOD. */
  public static final String INCORRECT_METHOD = "only GET method allowed";

  /** The Constant INCORRECT_DATE_FORMAT. */
  public static final String INCORRECT_DATE_FORMAT = "invalid date format";

  /** The Constant INCORRECT_BOOLEAN. */
  public static final String INCORRECT_BOOLEAN = "invalid boolean value";

  /** The Constant IS_INVALID. */
  public static final String IS_INVALID = " is invalid";

  /** The Constant IS_REQUIRED. */
  public static final String IS_REQUIRED = " is required";

  /** The Constant INCORRECT_ENUM_VALUE. */
  public static final String INCORRECT_ENUM_VALUE = "incorrect value";

  /** The Constant INVALID_ASSETGRAPH. */
  public static final String INVALID_NODES = "invalid nodes present";

  /** The Constant INVALID_TYPE. */
  public static final String INVALID_TYPE = "invalid type";

  /** The Constant EMBEDDED_IS_ALLOWED. */
  public static final String EMBEDDED_IS_ALLOWED = "only EMBEDDED is allowed";

  /** The Constant REST_IS_ALLOWED. */
  public static final String REST_IS_ALLOWED = "only REST is allowed";

  /** The Constant EXPIRES_ON_SHOULD_BE_FUTURE_DATE. */
  public static final String EXPIRES_ON_SHOULD_BE_FUTURE_DATE = "expiresOn should be a future date and time";

  /** The Constant INACTIVE_IS_ALLOWED. */
  public static final String INACTIVE_IS_ALLOWED = "invalid status field:only INACTIVE is allowed";

  /** The Constant COMPLETED_ALLOWED. */
  public static final String COMPLETED_ALLOWED = "field is invalid : only COMPLETED is allowed";

  /** The Constant LEARNINGMODEL_IS_ALLOWED. */
  public static final String LEARNINGMODEL_IS_ALLOWED = "is invalid:only LEARNINGMODEL is allowed";

  /**
   * Instantiates a new validation messages.
   */
  private ValidationMessages() {
    super();
  }
}
