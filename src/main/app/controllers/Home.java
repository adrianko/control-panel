package main.app.controllers;

import main.scaffolding.HttpResponse;

public class Home extends HttpResponse {

    @Override
    public String getResponse() {
        /*
        if (httpRequest.getRequestURI().getQuery().contains("g")) {
            return "<h1>Hi there</h1>";
        }
        */
        return "<h1>Hello World</h1>";
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