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
package com.pearson.glp.cms.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class CmsException.
 * 
 * @author anuj.verma
 */
@Getter
@Setter
public class CmsException extends RuntimeException {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 7999403540310491684L;

  /** The error code. */
  private int errorCode;

  /** The error msg. */
  private String errorMsg;

  /**
   * Instantiates a new cms exception.
   *
   * @param ex
   *          the ex
   */
  public CmsException(Throwable ex) {
    super(ex);
  }

  /**
   * Instantiates a new cms exception.
   *
   * @param errorCode
   *          the error code
   * @param errorMsg
   *          the error msg
   */
  public CmsException(int errorCode, String errorMsg) {
    super(errorMsg);
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }
}
