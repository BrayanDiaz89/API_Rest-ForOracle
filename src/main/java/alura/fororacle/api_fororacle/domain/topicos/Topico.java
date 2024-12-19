package alura.fororacle.api_fororacle.domain.topicos;

import alura.fororacle.api_fororacle.domain.cursos.Curso;
import alura.fororacle.api_fororacle.domain.estudiante.Estudiante;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fecha;
    private Boolean no_resuelto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    //constructor para registrar topicos, teniendo en cuenta la relaciones con cursos y estudiantes
    public Topico(Long id, Curso curso, Estudiante estudiante, String titulo, String descripcion, LocalDateTime fecha, Boolean no_resuelto){
        this.id = id;
        this.curso = curso;
        this.estudiante = estudiante;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        if(no_resuelto == null){
            this.no_resuelto = true;
        }
    }

    public void marcarComoResueltoElTopico(){ this.no_resuelto = false; }

}
