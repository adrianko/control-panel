package main.scaffolding.fallback;

import main.scaffolding.HttpResponse;

public class Error extends HttpResponse {

    @Override
    public void parseRequest() {}

    @Override
    public String getResponse() {
        return "404 Not Found :(";
    }

    @Override
    public String getContentType() {
        return "text/plain";
    }

    @Override
    public int getCode() {
        return 404;
    }
    
}