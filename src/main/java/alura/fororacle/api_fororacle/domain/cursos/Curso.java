package alura.fororacle.api_fororacle.domain.cursos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
//Anotaciones de lombok
@Getter //Generar getters para todos
@NoArgsConstructor //Generar constructores sin argumentos
@AllArgsConstructor //Generar todos los constructores
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private boolean activo;

    //constructor para facilitar el registro de un nuevo curso a la base de datos
    public Curso(DatosRegistrarCurso datosRegistrarCurso) {
        this.nombre = datosRegistrarCurso.nombre();
        this.descripcion = datosRegistrarCurso.descripcion();
    }
    //Metodo para actualizar cursos, incluyendo su estado activo o inactivo
    public void actualizarDatos(DatosActualizarCurso datosActualizarCurso) {
        if(datosActualizarCurso.nombre() != null){
            this.nombre = datosActualizarCurso.nombre();
        }
        if(datosActualizarCurso.descripcion() != null) {
            this.descripcion = datosActualizarCurso.descripcion();
        }
        if(datosActualizarCurso.activo() != activo){
            this.activo = datosActualizarCurso.activo();
        }
    }
    //Metodo para desactivar curso
    public void desactivarCurso(){
        this.activo = false;

    }
}