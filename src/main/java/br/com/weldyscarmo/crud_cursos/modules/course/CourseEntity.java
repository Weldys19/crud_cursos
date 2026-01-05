package br.com.weldyscarmo.crud_cursos.modules.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Pattern(regexp = "[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$", message = "O curso só deve conter letras")
    private String name;

    @NotBlank
    @Pattern(regexp = "[A-Za-zÀ-ÿ]+(?: [A-Za-zÀ-ÿ]+)*$", message = "O nome do professor só deve conter letras")
    private String teacher;
    private String category;
    private Boolean active;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}