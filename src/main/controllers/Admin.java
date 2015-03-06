package main.controllers;

import main.scaffolding.HttpResponse;

public class Admin extends HttpResponse {
    
    @Override
    public String getResponse() {
        return "<h1>Admin Panel</h1>";
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