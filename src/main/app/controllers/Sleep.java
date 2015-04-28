package main.app.controllers;

import main.scaffolding.HttpResponse;

import java.io.IOException;

public class Sleep extends HttpResponse {

    @Override
    public void parseRequest() {
        try {
            Runtime.getRuntime().exec("C:/runtime/sleep.bat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getResponse() {
        return "";
    }

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public int getCode() {
        return 200;
    }
    
    public static void execute() {
        new Sleep().parseRequest();
    }

}
