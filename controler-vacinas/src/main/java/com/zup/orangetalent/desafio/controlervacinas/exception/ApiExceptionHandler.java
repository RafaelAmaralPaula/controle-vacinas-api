package com.zup.orangetalent.desafio.controlervacinas.exception;

import com.zup.orangetalent.desafio.controlervacinas.service.exception.UsuarioComEmailOuCpfJaExistenteException;
import com.zup.orangetalent.desafio.controlervacinas.service.exception.UsuarioInexistenteExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        List<ApiException> erros = criarListaErros(ex.getBindingResult());

        return handleExceptionInternal(ex , erros , headers , HttpStatus.BAD_REQUEST , request);
    }

    @ExceptionHandler({UsuarioComEmailOuCpfJaExistenteException.class})
    protected ResponseEntity<Object> handleUsuarioComEmailJaExistenteException (UsuarioComEmailOuCpfJaExistenteException ex,WebRequest request) {

        String mensagemUsuario = messageSource.getMessage("usuario.inexistente" , null , LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = ex.getMessage();
        List<ApiException> erros = Arrays.asList(new ApiException(mensagemUsuario , mensagemDesenvolvedor , HttpStatus.BAD_REQUEST , ZonedDateTime.now()));


        return handleExceptionInternal(ex , erros , new HttpHeaders(), HttpStatus.BAD_REQUEST , request);
    }

    @ExceptionHandler({UsuarioInexistenteExeption.class})
    protected ResponseEntity<Object> handleUsuarioInexistenteExeption (UsuarioInexistenteExeption ex,WebRequest request) {

        String mensagemUsuario = messageSource.getMessage("usuario.inexistente" , null , LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = ex.getMessage();
        List<ApiException> erros = Arrays.asList(new ApiException(mensagemUsuario , mensagemDesenvolvedor , HttpStatus.BAD_REQUEST , ZonedDateTime.now()));


        return handleExceptionInternal(ex , erros , new HttpHeaders(), HttpStatus.BAD_REQUEST , request);
    }

    private List<ApiException> criarListaErros(BindingResult bindingResult) {
        List<ApiException> erros = new ArrayList<>();

        for(FieldError fieldError : bindingResult.getFieldErrors()){
            String mensagemUsuario = messageSource.getMessage(fieldError , LocaleContextHolder.getLocale());
            String mensagemDesenvolvedor = fieldError.toString();
            erros.add(new ApiException(mensagemUsuario , mensagemDesenvolvedor,  HttpStatus.BAD_REQUEST , ZonedDateTime.now()));
        }

        return erros;
    }


}
