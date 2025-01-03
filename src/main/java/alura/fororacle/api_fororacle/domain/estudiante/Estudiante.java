package alura.fororacle.api_fororacle.domain.estudiante;

import alura.fororacle.api_fororacle.domain.cursos.Curso;
import alura.fororacle.api_fororacle.domain.cursos.DatosActualizarCurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="estudiantes")
@Entity(name="Estudiante")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private LocalDateTime fecha;
    private Boolean activo;

    //Creación de relación uno a muchos con Cursos, campo id_curso
    //Un estudiante pertenecen a almenos un curso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_curso")
    private Curso curso;

    //constructor para registrar estudiante, teniendo en cuenta la relación con cursos
    public Estudiante(Long id, Curso curso, String nombre, String email, LocalDateTime fecha, Boolean activo) {
        this.id = id;
        this.curso = curso;
        this.nombre = nombre;
        this.email = email;
        this.fecha = fecha;
        if (activo == null) {
            this.activo = true;
        }
    }

    //Constructor para test
    public Estudiante(Curso curso, String nombre, String email, LocalDateTime fecha, Boolean activo) {
        this.curso = curso;
        this.nombre = nombre;
        this. email = email;
        this.fecha = fecha;
        this.activo = activo;
    }

    public void desactivarEstudiante(){
        this.activo = false;
    }

    //Metodo para actualizar cursos, incluyendo su estado activo o inactivo
    public void actualizarDatos(DatosActualizarEstudiante datos) {
        if(datos.nombre() != null){
            this.nombre = datos.nombre();
        }
        if(datos.email() != null) {
            this.email = datos.email();
        }
        if(datos.activo() != null){
            this.activo = datos.activo();
        }
    }
}
