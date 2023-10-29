package com.dompet.sigopback.exception.handler;

import com.dompet.tontineonline.exception.EntityAlreadyExistsException;
import com.dompet.tontineonline.exception.EntityNotFoundException;
import com.dompet.tontineonline.exception.message.ErrorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public @ResponseBody ErrorEntity handleException(EntityNotFoundException exception){
        return  ErrorEntity.builder()
                .code(404)
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public @ResponseBody ErrorEntity handleException(EntityAlreadyExistsException exception){
        return  ErrorEntity.builder()
                .code(409)
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(value = {RuntimeException.class})
    public @ResponseBody ErrorEntity handleException(RuntimeException exception){
        return  ErrorEntity.builder()
                .code(406)
                .message(exception.getMessage())
                .build();
    }



}
