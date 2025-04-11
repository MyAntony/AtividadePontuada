package com.example.pontuada.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    // Trata exceções genéricas do tipo RuntimeException e retorna um status BAD_REQUEST com a mensagem de erro
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handlerRuntimeException(RuntimeException erro)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", erro.getMessage()));
    }

    // Trata erros de validação de argumentos de métodos e retorna um status BAD_REQUEST com a mensagem do primeiro erro de campo
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException erro)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", erro.getFieldErrors().get(0).getDefaultMessage()));
    }

    // Trata métodos HTTP não suportados e retorna um status NOT_FOUND com uma mensagem personalizada
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException erro)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensagem", "Recurso não encontrado!"));
    }

    // Trata casos em que um recurso solicitado não é encontrado e retorna um status NOT_FOUND com uma mensagem personalizada
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerNoResourceFoundException(NoResourceFoundException erro)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Mensagem", "Recurso não encontrado!"));
    }

    // Trata casos em que a mensagem HTTP não é legível e retorna um status BAD_REQUEST com uma mensagem personalizada
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handlerHttpMessageNotReadableException(HttpMessageNotReadableException erro)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Mensagem", "Insira dados válidos!"));
    }
}
