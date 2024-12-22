package alura.fororacle.api_fororacle.domain.instructor;

import alura.fororacle.api_fororacle.domain.estudiante.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Page<Instructor> findByActivoTrue(Pageable paginacion);
    Page<Instructor> findByActivoFalse(Pageable paginacion);

    @Query("""
           select i.activo
           from Instructor i
           where
           i.id = :idInstructor
           """)
    Boolean findByActivoById(Long idInstructor);
}
