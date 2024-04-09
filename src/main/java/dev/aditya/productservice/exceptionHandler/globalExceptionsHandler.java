package dev.aditya.productservice.exceptionHandler;

import dev.aditya.productservice.Dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Executable;

@ControllerAdvice
public class globalExceptionsHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handlearthimaticexpection(){
        ExceptionDto dto=new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArithmeticException");
        ResponseEntity<ExceptionDto> response= new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;

    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handlearrayIndexOutofBoundexpection(){
        ExceptionDto dto=new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("Array Index Out Of Bounds");
        ResponseEntity<ExceptionDto> response= new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

}
