package br.com.acbueno.exception;

public class ServiceException extends Exception {

  private static final long serialVersionUID = -7575544805989674802L;

  public ServiceException(String errorMessage) {
    super(errorMessage);
  }

  public ServiceException(String errorMessage, Throwable throwable) {
    super(errorMessage, throwable);
  }

}
