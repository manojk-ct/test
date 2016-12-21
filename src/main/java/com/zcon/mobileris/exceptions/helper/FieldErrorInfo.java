package com.zcon.mobileris.exceptions.helper;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author ManojK
 */
public class FieldErrorInfo {
    private String url;
    private String message;
    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();
    
    public FieldErrorInfo(){}

    public FieldErrorInfo(String url, String message) {
        this.url = url;
        this.message = message;
    }
    public FieldErrorInfo(String url, String message,List<FieldErrorDTO> fieldErrors){        
        this.url = url;
        this.message = message;
        this.fieldErrors = fieldErrors;
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

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
    
    public ModelAndView asModelAndView(){
        MappingJackson2JsonView jsonViewForError = new MappingJackson2JsonView();
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("url", this.url);
        errorMap.put("message", this.message);
        errorMap.put("errorFields", this.fieldErrors);
        return new ModelAndView(jsonViewForError, errorMap);
    }
}