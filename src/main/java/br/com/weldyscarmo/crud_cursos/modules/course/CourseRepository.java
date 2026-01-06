package br.com.weldyscarmo.crud_cursos.modules.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    List<CourseEntity> findAll();
    Optional<CourseEntity> findById(UUID id);
}
