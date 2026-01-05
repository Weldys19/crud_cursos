package br.com.weldyscarmo.crud_cursos.modules.course.controller;

import br.com.weldyscarmo.crud_cursos.modules.course.CourseEntity;
import br.com.weldyscarmo.crud_cursos.modules.course.useCase.CreateCourseUseCase;
import br.com.weldyscarmo.crud_cursos.modules.course.useCase.ListCourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ListCourseUseCase listCourseUseCase;

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @PostMapping("/")
    public CourseEntity create(@RequestBody CourseEntity courseEntity){
        return this.createCourseUseCase.execute(courseEntity);
    }

    @GetMapping("/")
    public List<CourseEntity> getCourses(){
        return this.listCourseUseCase.execute();
    }
}
