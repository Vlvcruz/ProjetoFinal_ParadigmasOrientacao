package com.example.crud.exception;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(ResourceNotFoundException.class)
 public ResponseEntity<?> nf(ResourceNotFoundException e){ return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); }
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<?> val(MethodArgumentNotValidException e){
  Map<String,String> map=new HashMap<>();
  e.getBindingResult().getFieldErrors().forEach(err->map.put(err.getField(),err.getDefaultMessage()));
  return ResponseEntity.badRequest().body(map);
 }
}