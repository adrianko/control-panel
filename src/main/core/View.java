package main.core;

import com.github.mustachejava.DefaultMustacheFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class View {
    
    public static String render(String template, Object context) {
        Writer w = new StringWriter();    
        
        try {
            new DefaultMustacheFactory().compile(Base.path + template).execute(w, context).flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return w.toString();
    }
    
}
