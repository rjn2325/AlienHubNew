package com.alienhub.models.common;

import com.alienhub.models.UserModal;

import org.apache.logging.log4j.message.Message;

public class ResponseModel<T> {

  private Boolean success = false;
  private String message = "";
  // private Object data= new Object();
  private T data;
  private UserModal userModal = new UserModal();

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

  public void setData(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

}
