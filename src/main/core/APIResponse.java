package main.core;

import main.scaffolding.HttpResponse;

public class APIResponse extends HttpResponse {

    @Override
    public void parseRequest() {

    }

    @Override
    public String getResponse() {
        return null;
    }

    @Override
    public String getContentType() {
        return "application/json";
    }

    @Override
    public int getCode() {
        return 200;
    }

}