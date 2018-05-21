package com.curveDental.model.common;

public class ErrorPayload {

    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static ErrorPayload of(final String errorMessage, final String errorCode) {
        ErrorPayload errorPayload = new ErrorPayload();
        errorPayload.setErrorMessage(errorMessage);
        errorPayload.setErrorCode(errorCode);
        return errorPayload;
    }
}
