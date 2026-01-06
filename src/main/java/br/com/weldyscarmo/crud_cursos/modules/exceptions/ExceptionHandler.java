package br.com.weldyscarmo.crud_cursos.modules.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageErrorDTO>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<MessageErrorDTO> dto = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(erro -> {
        String message = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
        MessageErrorDTO messageErrorDTO = new MessageErrorDTO(message, erro.getField());
        dto.add(messageErrorDTO);
        });
        return ResponseEntity.badRequest().body(dto);
    }
}
