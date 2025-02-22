package alura.fororacle.api_fororacle.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("""
           select t from Topico t
           where
           t.no_resuelto = true
           """)
    Page<Topico> findByNoResueltoTrue(Pageable paginacion);

    @Query("""
           select t from Topico t
           where
           t.no_resuelto = false
           """)
    Page<Topico> findByNoResueltoFalse(Pageable paginacion);


    @Query("""
            select count(t) > 0
            from Topico t
            where t.id = :idTopico
            and t.estudiante.id = :idEstudiante
       """)
    boolean findByTopicoIfEstudianteCreoElTopico(Long idTopico, Long idEstudiante);

    @Query("""
           select t.no_resuelto
           from Topico t
           where
           t.id = :idTopico
           """)
    Boolean findByActivoTrue(Long idTopico);
}
