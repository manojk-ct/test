package com.zcon.mobileris.controllers;

import com.zcon.mobileris.exceptions.FileUploadException;
import com.zcon.mobileris.exceptions.RecordNotFoundException;
import com.zcon.mobileris.exceptions.helper.ErrorInfo;
import com.zcon.mobileris.exceptions.helper.FieldErrorDTO;
import com.zcon.mobileris.exceptions.helper.FieldErrorInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author ManojK
 */
@ControllerAdvice

/* This class is controller class for Exception Handling */
public class GlobalExceptionProcessor extends RuntimeException {

    @Autowired
    MessageSource messageSource;

    /* This function handles exception for if there is no any perticular record found in database */
    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView handleRecordNotFoundException(HttpServletRequest req, RecordNotFoundException e) {
        String url = req.getRequestURL().toString();
        String errMsg = localizeErrorMessage("error.no.record.id");
        errMsg += e.getRecordName() + " with ID " + e.getId();
        return new ErrorInfo(url, errMsg).asModelAndView();
    }

    /* This function handles argument exception for backend validation */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView handleArgumentValidationException(HttpServletRequest req, MethodArgumentNotValidException e) {
        String url = req.getRequestURL().toString();
        String errMsg = localizeErrorMessage("error.bad.arguments");
        FieldErrorInfo errorInfo = new FieldErrorInfo(url, errMsg);

        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        errorInfo.getFieldErrors().addAll(findFieldErrors(fieldErrors));

        return errorInfo.asModelAndView();
    }

    /* This function handles constraint violation exception for backend validation (e.g. email validation) */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView handleConstraintViolationException(HttpServletRequest req, ConstraintViolationException e) {
        String url = req.getRequestURL().toString();
        String errMsg = localizeErrorMessage("error.bad.db.constraint") + e.getMessage();
        return new ErrorInfo(url, errMsg).asModelAndView();
    }

    /* This function handles all types of SQL exception database server connection failure */
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleAllSQLExceptions(HttpServletRequest req, SQLException e) {
        String url = req.getRequestURL().toString();
        String errMsg = localizeErrorMessage("error.bad.db.random") + e.getMessage();
        return new ErrorInfo(url, errMsg).asModelAndView();
    }

    /* This function id default exception handler for any application exception */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleDefaultException(HttpServletRequest req, Exception e) {
        String url = req.getRequestURL().toString();
        String errMsg = localizeErrorMessage("error.app.exception") + e.getMessage();
        return new ErrorInfo(url, errMsg).asModelAndView();
    }

    /* This function is for combining all errors or exception of incoming request and returns list of them */
    public List<FieldErrorDTO> findFieldErrors(List<FieldError> errorList) {
        List<FieldErrorDTO> fieldErrors = new ArrayList<>();
        StringBuilder errorMessage = new StringBuilder("");
        for (FieldError err : errorList) {
            errorMessage.append(err.getCode()).append(".");
            errorMessage.append(err.getObjectName()).append(".");
            errorMessage.append(err.getField());
            String localizeErrMsg = localizeErrorMessage(errorMessage.toString());

            fieldErrors.add(new FieldErrorDTO(err.getField(), localizeErrMsg));

            errorMessage.delete(0, errorMessage.capacity());
        }

        return fieldErrors;
    }

    /* This function for generating error message */
    public String localizeErrorMessage(String errorCode) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(errorCode, null, locale);
    }
}
