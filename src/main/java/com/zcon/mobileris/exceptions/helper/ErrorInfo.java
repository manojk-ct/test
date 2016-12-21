package com.zcon.mobileris.exceptions.helper;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author ManojK
 */
public class ErrorInfo {
    private String url;
    private String message;

    public ErrorInfo(String url, String message) {
        this.url = url;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public ModelAndView asModelAndView(){
        MappingJackson2JsonView jsonViewForError = new MappingJackson2JsonView();
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("url", this.url);
        errorMap.put("message", this.message);
        return new ModelAndView(jsonViewForError, errorMap);
    }
}
     
