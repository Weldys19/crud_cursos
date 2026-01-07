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

    public List<CourseEntity> execute(String name, String category){

        if (name != null && category != null) {
            return courseRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
        }

        if (name != null) {
            return courseRepository.findByNameContainingIgnoreCase(name);
        }

        if (category != null) {
            return courseRepository.findByCategoryContainingIgnoreCase(category);
        }

        return courseRepository.findAll();
    }
}
