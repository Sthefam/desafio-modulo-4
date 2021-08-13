package br.com.zup.Ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipularExcecoesDeValidacao(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<Erro> erros = fieldErrors.stream().map(objeto -> new Erro(objeto.getDefaultMessage())).collect(Collectors.toList());

        return new MensagemDeErro(400,erros);
    }

    @ExceptionHandler(CapturarErroException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularPetNaoEncontrado(CapturarErroException exception){
        List<Erro> erros = Arrays.asList(new Erro(exception.getMessage()));

        return new MensagemDeErro(422,erros);

    }

}
