package alura.fororacle.api_fororacle.domain.estudiante;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Page<Estudiante> findByActivoTrue(Pageable paginacion);
    Page<Estudiante> findByActivoFalse(Pageable paginacion);
}
