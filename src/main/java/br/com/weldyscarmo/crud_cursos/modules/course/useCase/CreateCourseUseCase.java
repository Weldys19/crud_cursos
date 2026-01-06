package br.com.weldyscarmo.crud_cursos.modules.course.useCase;

import br.com.weldyscarmo.crud_cursos.modules.course.CourseEntity;
import br.com.weldyscarmo.crud_cursos.modules.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity){
        courseEntity.setActive(true);
        return this.courseRepository.save(courseEntity);
    }
}
