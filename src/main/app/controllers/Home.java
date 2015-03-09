package main.app.controllers;

import main.scaffolding.HttpResponse;

import java.util.Optional;

public class Home extends HttpResponse {

    String response;

    @Override
    public void parseRequest() {
        response = "<link type=\"text/css\" rel=\"stylesheet\" href=\"/assets/css/styles.css\">";
        response += "<h1>Hello World</h1>";
        Optional<String> query = Optional.ofNullable(httpRequest.getRequestURI().getQuery());

        if (query.isPresent() && query.get().contains("g")) {
            response += "<h1>Hi there</h1>";
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