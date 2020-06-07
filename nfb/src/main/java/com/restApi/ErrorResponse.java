package com.restApi;

import lombok.Data;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 07-jun.-2020  15:25
 */
@Data
public class ErrorResponse extends Throwable {
    private String status;
    private String message;

    public ErrorResponse() {
        this.status = "OK";
    }

    public ErrorResponse(String message) {
        this.status = "NOK";
        this.message = message;
    }

}
