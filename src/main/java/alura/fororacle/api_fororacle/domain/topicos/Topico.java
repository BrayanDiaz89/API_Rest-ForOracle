package alura.fororacle.api_fororacle.domain.topicos;

import alura.fororacle.api_fororacle.domain.cursos.Curso;
import alura.fororacle.api_fororacle.domain.estudiante.Estudiante;
import alura.fororacle.api_fororacle.domain.instructor.DatosActualizarInstructor;
import alura.fororacle.api_fororacle.domain.respuestas.Respuesta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;

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

    //Constructor para actualizar tópico
    public Topico(Long id, Estudiante estudiante, String titulo, String descripcion, LocalDateTime fecha, Boolean no_resuelto){
        this.id = id;
        this.estudiante = estudiante;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        if(no_resuelto == null){
            this.no_resuelto = true;
        }
    }
    //Crear constructor para test
    public Topico(Curso curso, Estudiante estudiante, String titulo, String descripcion, LocalDateTime fecha, Boolean noResuelto) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.no_resuelto = noResuelto;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.descripcion() != null){
            this.descripcion = datosActualizarTopico.descripcion();
        }
        if(datosActualizarTopico.fecha() == null){
            this.fecha = LocalDateTime.now();
        }
        if(datosActualizarTopico.no_resuelto() != null){
            this.no_resuelto = datosActualizarTopico.no_resuelto();
        }
    }

    public void marcarComoResueltoElTopico(){ this.no_resuelto = false; }
}

