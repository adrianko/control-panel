package main.controllers;

import main.scaffolding.HttpResponse;

public class Error404 extends HttpResponse {

    @Override
    public String getResponse() {
        return "Error404";
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