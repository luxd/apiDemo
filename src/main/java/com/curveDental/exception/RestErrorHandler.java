package com.curveDental.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.curveDental.model.common.ErrorPayload;

@ControllerAdvice
public class RestErrorHandler {

    // TODO: error message should be localized from message bundle
    // @Resource
    // protected MessageSource messageSource;

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorPayload processValidationError(ValidationException validationException) {
        return toErrorPayload(validationException);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorPayload processObjectNotFoundError(ObjectNotFoundException objectNotFoundException) {
        return toErrorPayload(objectNotFoundException);
    }

    protected ErrorPayload toErrorPayload(ApplicationException applicationException) {
        return ErrorPayload.of(applicationException.getLocalizedMessage(), applicationException.getErrorCode());
    }
}
