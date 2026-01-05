package br.com.weldyscarmo.crud_cursos.modules.course.useCase;

import br.com.weldyscarmo.crud_cursos.modules.course.CourseEntity;
import br.com.weldyscarmo.crud_cursos.modules.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute(){
        return this.courseRepository.findAll();
    }
}
