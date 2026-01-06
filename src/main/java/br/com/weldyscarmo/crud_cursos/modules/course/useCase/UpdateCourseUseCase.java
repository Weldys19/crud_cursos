package br.com.weldyscarmo.crud_cursos.modules.course.useCase;

import br.com.weldyscarmo.crud_cursos.modules.course.CourseEntity;
import br.com.weldyscarmo.crud_cursos.modules.course.CourseRepository;
import br.com.weldyscarmo.crud_cursos.modules.course.dto.UpdateCourseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public CourseEntity execute(UpdateCourseDTO updateCourseDTO, UUID id){
        CourseEntity courseEntity = this.courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Curso não encontrado");
                });

        if (updateCourseDTO.getName() != null) {
            courseEntity.setName(updateCourseDTO.getName());
        }
        if (updateCourseDTO.getCategory() != null) {
            courseEntity.setCategory(updateCourseDTO.getCategory());
        }
        if (updateCourseDTO.getTeacher() != null) {
            courseEntity.setTeacher(updateCourseDTO.getTeacher());
        }
        courseEntity.setUpdatedAt(LocalDateTime.now());

        return courseEntity;
    }
}
