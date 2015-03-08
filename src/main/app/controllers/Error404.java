package main.app.controllers;

import main.scaffolding.HttpResponse;

public class Error404 extends HttpResponse {

    @Override
    public void parseRequest() {}

    @Override
    public String getResponse() {
        return "404 Not Found";
    }

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public int getCode() {
        return 404;
    }
    
}