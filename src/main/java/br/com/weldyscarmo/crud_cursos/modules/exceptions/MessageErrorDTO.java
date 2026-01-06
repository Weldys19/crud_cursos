package br.com.weldyscarmo.crud_cursos.modules.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageErrorDTO {

    private String message;
    private String field;
}
