package com.study.lxy.dto;

import java.io.Serializable;

/**
 * Created by Harry on 17/11/21.
 */
public class Response<T> implements Serializable {

  private static final long serialVersionUID = -2499398849260312712L;
  private Integer code = 200;
  private T data;
  private String msg;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
