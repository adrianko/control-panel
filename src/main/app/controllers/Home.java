package main.app.controllers;

import main.scaffolding.HttpResponse;

public class Home extends HttpResponse {

    String response;

    @Override
    public void parseRequest() {
        response = "<h1>Hello World</h1>";

        if (httpRequest.getRequestURI().getQuery() != null) {
            if (httpRequest.getRequestURI().getQuery().contains("g")) {
                response = "<h1>Hi there</h1>";
            }
        }
    }

    @Override

    public String getResponse() {
        return response;
    }

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public int getCode() {
        return 200;
    }

}