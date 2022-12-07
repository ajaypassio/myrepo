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
package com.pearson.glp.lpb.exceptions;

import com.pearson.glp.core.errors.PlatformError;
import com.pearson.glp.core.utils.exception.PlatformException;
import com.pearson.glp.lpb.data.model.Link;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author lokesh.sharma3
 *
 */
@Getter
@Setter
public class SchemaValidationException extends PlatformException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 216494170434566080L;

  /** The error code. */
  private String errorCode;

  /** The message. */
  private String message;

  /** The timestamp. */
  private String timestamp;

  /** The link. */
  private Link link;

  /**
   * Instantiates a new schema validation exception.
   *
   * @param httpStatus
   *          the http status
   * @param error
   *          the error
   * @param errorCode
   *          the error code
   * @param message
   *          the message
   * @param timestamp
   *          the timestamp
   * @param link
   *          the link
   */
  public SchemaValidationException(int httpStatus, PlatformError error, String errorCode,
      String message, String timestamp, Link link) {
    super(httpStatus, error);
    this.errorCode = errorCode;
    this.message = message;
    this.timestamp = timestamp;
    this.link = link;
  }

}
