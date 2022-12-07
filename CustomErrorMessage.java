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

import java.io.Serializable;
import java.time.OffsetTime;
import java.util.HashMap;
import java.util.Optional;

import org.joda.time.Instant;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import com.pearson.glp.cms.constants.ErrorConstants;
import com.pearson.glp.cms.utils.ErrorUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Custom Error Message.
 */
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "timestamp", "status", "error", "message", "_links" })
public class CustomErrorMessage implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 5784593708441636014L;

  /** The timestamp. */
  @SerializedName("timestamp")
  @JsonProperty("timestamp")
  private String timestamp;

  /** The status. */
  @SerializedName("status")
  @JsonProperty("status")
  private int status;

  /** The error. */
  @SerializedName("error")
  @JsonProperty("error")
  private String error;

  /** The message. */
  @SerializedName("message")
  @JsonProperty("message")
  private String message;

  /** The links. */
  @SerializedName("_links")
  @JsonProperty("_links")
  private HashMap<String, Object> links;

  /**
   * Instantiates a new custom error message.
   */
  public CustomErrorMessage() {
    this.setErrorModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), Optional.empty());
  }

  /**
   * Instantiates a new custom error message.
   *
   * @param status
   *          the status
   */
  public CustomErrorMessage(int status) {
    this.setErrorModel(status, Optional.empty());
  }

  /**
   * Instantiates a new custom error message.
   *
   * @param status
   *          the status
   * @param message
   *          the message
   */
  public CustomErrorMessage(int status, String message) {
    this.setErrorModel(status, Optional.ofNullable(message));
  }

  /**
   * Instantiates a new custom error message.
   *
   * @param throwable
   *          the throwable
   */
  public CustomErrorMessage(Throwable throwable) {
    this.setErrorModel(ErrorUtils.getErrorModelFromException(throwable));
  }

  /**
   * Sets the error model.
   *
   * @param status
   *          the new error model
   */
  private void setErrorModel(int status, Optional<String> optionalMessage) {
    String offset = OffsetTime.now().getOffset().toString().replaceAll("Z", "+00:00");
    this.timestamp = Instant.now().toString().replaceAll("\\.(.*)", offset);
    this.status = status;
    HttpStatus httpStatus = HttpStatus.valueOf(status);
    this.setError(httpStatus.getReasonPhrase());
    if (optionalMessage.isPresent()) {
      this.setMessage(optionalMessage.get());
    } else {
      populateErrorMessage(httpStatus);
    }
  }

  /**
   * Sets the error model.
   *
   * @param errorModel
   *          the new error model
   */
  private void setErrorModel(CustomErrorMessage errorModel) {
    this.timestamp = errorModel.getTimestamp();
    this.status = errorModel.getStatus();
    this.error = errorModel.getError();
    this.message = errorModel.getMessage();
    this.links = errorModel.getLinks();
  }

  /**
   * Populate error and error message.
   */
  private final void populateErrorMessage(HttpStatus httpStatus) {
    if (httpStatus == HttpStatus.BAD_REQUEST) {
      this.setMessage(ErrorConstants.MESSAGE_BAD_REQUEST);
    } else if (httpStatus == HttpStatus.UNAUTHORIZED) {
      this.setMessage(ErrorConstants.MESSAGE_UNAUTHORIZED);
    } else if (httpStatus == HttpStatus.NOT_FOUND) {
      this.setMessage(ErrorConstants.MESSAGE_NOT_FOUND);
    } else if (httpStatus == HttpStatus.UNSUPPORTED_MEDIA_TYPE) {
      this.setMessage(ErrorConstants.MESSAGE_UNSUPPORTED_MEDIA_TYPE);
    } else if (httpStatus == HttpStatus.METHOD_NOT_ALLOWED) {
      this.setMessage(ErrorConstants.MESSAGE_METHOD_NOT_ALLOWED);
    } else if (httpStatus == HttpStatus.NOT_ACCEPTABLE) {
      this.setMessage(ErrorConstants.MESSAGE_NOT_ACCEPTED);
    } else {
      this.setMessage(ErrorConstants.MESSAGE_INTERNAL_SERVER_ERROR);
    }
  }
}
