package br.com.weldyscarmo.crud_cursos.modules.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
