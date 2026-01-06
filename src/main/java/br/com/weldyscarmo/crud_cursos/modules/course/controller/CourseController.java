package br.com.weldyscarmo.crud_cursos.modules.course.controller;

import br.com.weldyscarmo.crud_cursos.modules.course.CourseEntity;
import br.com.weldyscarmo.crud_cursos.modules.course.dto.UpdateCourseDTO;
import br.com.weldyscarmo.crud_cursos.modules.course.useCase.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ListCourseUseCase listCourseUseCase;

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private ToggleActiveUseCase toggleActiveUseCase;

    @PostMapping("/")
    public CourseEntity create(@Valid @RequestBody CourseEntity courseEntity){
        return this.createCourseUseCase.execute(courseEntity);
    }

    @GetMapping("/")
    public List<CourseEntity> getCourses(){
        return this.listCourseUseCase.execute();
    }

    @PutMapping("/{id}")
    public CourseEntity update(@Valid @RequestBody UpdateCourseDTO updateCourseDTO, @PathVariable UUID id){
        return this.updateCourseUseCase.execute(updateCourseDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        this.deleteCourseUseCase.execute(id);
    }

    @PatchMapping("/{id}/active")
    public Boolean toggleActive(@PathVariable UUID id){
        return this.toggleActiveUseCase.execute(id);
    }
}
