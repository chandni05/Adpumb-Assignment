package com.adpumb.shipproxy.model;

public class ProxyResponse {
    private String responseBody;
    private int statusCode;

    public ProxyResponse(String responseBody, int statusCode) {
        this.responseBody = responseBody;
        this.statusCode = statusCode;
    }

    public String getResponseBody() { return responseBody; }
    public int getStatusCode() { return statusCode; }
}
