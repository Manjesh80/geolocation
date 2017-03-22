package com.manjesh.microservices.model;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/22/2017.
 */
public class ValidationError {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
