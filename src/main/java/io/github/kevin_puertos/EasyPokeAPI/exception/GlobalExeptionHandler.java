package io.github.kevin_puertos.EasyPokeAPI.exception;

import io.github.kevin_puertos.EasyPokeAPI.exception.exeptions.ResourceNotFound;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Hidden // Oculta el controller para swager y evita fallos.
public class GlobalExeptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFound ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }



}
