package com.medgenome.clientportal.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorInformation {
    private String errorCode;
    private String errorMessage;

    public ErrorInformation(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

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
}
