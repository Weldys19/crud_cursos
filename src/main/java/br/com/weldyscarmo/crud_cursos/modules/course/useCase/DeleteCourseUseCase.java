package br.com.weldyscarmo.crud_cursos.modules.course.useCase;

import br.com.weldyscarmo.crud_cursos.modules.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID id){
        var deleteCourse = this.courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Curso não encontrado");
                });

        this.courseRepository.delete(deleteCourse);
    }
}
