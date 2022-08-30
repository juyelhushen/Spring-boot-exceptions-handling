package com.example.exceptionhandlingdemo.exceptions;

import java.util.Date;

public class ErrorDetails {
    private String error;
    private int code;
    private Date timestamp;

    public ErrorDetails(String error, int code, Date timestamp) {
        this.error = error;
        this.code = code;
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
