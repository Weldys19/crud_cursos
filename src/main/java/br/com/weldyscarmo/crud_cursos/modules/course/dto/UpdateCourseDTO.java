package br.com.weldyscarmo.crud_cursos.modules.course.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateCourseDTO {

    @Pattern(regexp = "[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$", message = "O campo [name] só deve conter letras")
    private String name;
    private String category;

    @Pattern(regexp = "[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$", message = "O campo [teacher] só deve conter letras")
    private String teacher;
}
