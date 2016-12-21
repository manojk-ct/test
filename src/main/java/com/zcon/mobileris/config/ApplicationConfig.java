package com.zcon.mobileris.config;

import com.zcon.mobileris.filter.CorsFilter;
import com.zcon.mobileris.filter.CsrfHeaderFilter;
import com.zcon.mobileris.services.impl.MailService;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@Order(1)
@ComponentScan(basePackages = "com.zcon.mobileris")
@PropertySource("classpath:email-${env.name}.properties")
//@PropertySource("classpath:application.properties")
/* Description : This file is for whole basic application configuration with filters and resources */
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;
    
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public CsrfHeaderFilter csrfHeaderFilter() {
        CsrfHeaderFilter csrfHeaderFilter = new CsrfHeaderFilter();
        return csrfHeaderFilter;
    }
    

    @Bean(name = {"messageSource"})
    public MessageSource messagSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(env.getRequiredProperty("message.source.basename"));
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }
    
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsFilter corsFilter = new CorsFilter();
        return corsFilter;
    }
    
    @Bean(name = "multipartResolver")
    public StandardServletMultipartResolver multipartResolver()
    {
        return new StandardServletMultipartResolver();
    }
    
    @Bean
    public SimpleMailMessage simpleMailMessage() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(env.getRequiredProperty("emailfrom"));
        simpleMailMessage.setTo(env.getRequiredProperty("emailto"));
        simpleMailMessage.setSubject(env.getRequiredProperty("emailsubject"));
        return simpleMailMessage;
    }

    @Bean
    public MimeMessage mimeMessage() {
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties);
        MimeMessage mimeMessage = new MimeMessage(session);
        return mimeMessage;
    }

    @Bean
    public MailService mailService() {
        MailService mailService = new MailService();
        return mailService;
    }
    
        @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getRequiredProperty("emailhost"));
        mailSender.setPort(Integer.parseInt(env.getRequiredProperty("emailport")));
        mailSender.setUsername(env.getRequiredProperty("emailusername"));
        mailSender.setPassword(env.getRequiredProperty("emailpassword"));
        mailSender.setJavaMailProperties(getMailProperties());

        return mailSender;
    }
    
    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        return properties;
    }
    
}
