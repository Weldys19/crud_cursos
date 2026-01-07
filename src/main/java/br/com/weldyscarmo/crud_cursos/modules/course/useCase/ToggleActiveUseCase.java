package br.com.weldyscarmo.crud_cursos.modules.course.useCase;

import br.com.weldyscarmo.crud_cursos.modules.course.CourseRepository;
import br.com.weldyscarmo.crud_cursos.modules.exceptions.BusinessException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ToggleActiveUseCase {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public boolean execute(UUID id){
        var course = this.courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new BusinessException("Curso não encontrado");
                });
        var active = !course.getActive();
        course.setActive(active);

        return active;
    }
}
