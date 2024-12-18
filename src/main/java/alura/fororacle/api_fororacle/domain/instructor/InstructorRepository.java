package alura.fororacle.api_fororacle.domain.instructor;

import alura.fororacle.api_fororacle.domain.estudiante.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Page<Instructor> findByActivoTrue(Pageable paginacion);
    Page<Instructor> findByActivoFalse(Pageable paginacion);
}
