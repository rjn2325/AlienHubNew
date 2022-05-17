package com.alienhub.models.common;

import org.apache.logging.log4j.message.Message;

public class ResponseModel {

  private Boolean success = false;
  private String message = "";

  public boolean getSuccess() {
    return success;
  }

  public boolean setSucccess(boolean success) {
    return this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public String setMessage(String message) {
    return this.message = message;
  }

}
