package alura.fororacle.api_fororacle.domain.respuestas;

import alura.fororacle.api_fororacle.domain.cursos.Curso;
import alura.fororacle.api_fororacle.domain.estudiante.Estudiante;
import alura.fororacle.api_fororacle.domain.instructor.Instructor;
import alura.fororacle.api_fororacle.domain.respuestas.estudiante.DatosActualizarRespuestaEstudiante;
import alura.fororacle.api_fororacle.domain.respuestas.instructor.DatosActualizarRespuestaInstructor;
import alura.fororacle.api_fororacle.domain.topicos.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenido;
    private LocalDateTime fecha;
    private Boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instructor")
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_topico")
    private Topico topico;

    //Constructor para test
    public Respuesta(Estudiante estudiante, Instructor instructor, String contenido, LocalDateTime fecha, Topico topico, Boolean activo) {
        this.estudiante = estudiante;
        this.instructor = instructor;
        this.contenido = contenido;
        this.fecha = fecha;
        this.topico = topico;
        this.activo = activo;
    }

    public void actualizarDatosRespuestaInstructor(DatosActualizarRespuestaInstructor datos){
        this.contenido = datos.contenido();
        if(datos.fecha() == null){
            this.fecha = LocalDateTime.now();
        }
    }
    public void actualizarDatosRespuestaEstudiante(DatosActualizarRespuestaEstudiante datos){
        this.contenido = datos.contenido();
        if(datos.fecha() == null){
            this.fecha = LocalDateTime.now();
        }
    }
    public void eliminarRespuesta() { this.activo = false; }

}
