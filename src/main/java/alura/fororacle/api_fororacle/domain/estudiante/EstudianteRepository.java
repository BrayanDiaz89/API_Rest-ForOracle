package alura.fororacle.api_fororacle.domain.estudiante;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Page<Estudiante> findByActivoTrue(Pageable paginacion);
    Page<Estudiante> findByActivoFalse(Pageable paginacion);

    @Query("""
           select e.activo
           from Estudiante e
           where
           e.id = :idEstudiante
           """)
    Boolean findByActivoById(Long idEstudiante);
}
