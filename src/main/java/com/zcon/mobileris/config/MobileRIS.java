/**
 *@author Manoj K
 * Date: 19 Jan 2016
 * Description : App Initializer class. It will act as a deployment descriptor
 *
 */
package com.zcon.mobileris.config;

import com.zcon.mobileris.filter.CorsFilter;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MobileRIS extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/api/*"};
    }

    @Override
    protected Filter[] getServletFilters() {
        Filter[] singleton = {
            new CorsFilter()
        };
        return singleton;
    }
    
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(getMultipartConfigElement());
    }
    
    private MultipartConfigElement getMultipartConfigElement() {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(ProjectConstants.TEMP_FILE_UPLOAD_DIR, ProjectConstants.MAX_FILE_SIZE, ProjectConstants.MAX_MULTIPART_REQUEST_SIZE , ProjectConstants.THRESHOLD_FILE_SIZE);
        return multipartConfigElement;
    }
}
