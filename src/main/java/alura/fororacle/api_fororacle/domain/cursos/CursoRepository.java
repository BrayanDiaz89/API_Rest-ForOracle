package alura.fororacle.api_fororacle.domain.cursos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Page<Curso> findByActivoTrue(Pageable paginacion);

    Page<Curso> findByActivoFalse(Pageable paginacion);

    @Query("""
           select c.activo
           from Curso c
           where
           c.id = :idCurso
           """)
    boolean findByActivoById(Long idCurso);
}
