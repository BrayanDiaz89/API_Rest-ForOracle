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
    private Boolean activo;

    //constructor para facilitar el registro de un nuevo curso a la base de datos
    public Curso(DatosRegistrarCurso datosRegistrarCurso) {
        this.nombre = datosRegistrarCurso.nombre();
        this.descripcion = datosRegistrarCurso.descripcion();
        if(datosRegistrarCurso.activo() == null || datosRegistrarCurso.activo()){
            this.activo = true;
        } else {
            //quiero que sea true, en todos los casos, no es posible crear un estudiante inactivo.
            this.activo = true;
        }
    }
    //Metodo para actualizar cursos, incluyendo su estado activo o inactivo
    public void actualizarDatos(DatosActualizarCurso datosActualizarCurso) {
        if(datosActualizarCurso.nombre() != null){
            this.nombre = datosActualizarCurso.nombre();
        }
        if(datosActualizarCurso.descripcion() != null) {
            this.descripcion = datosActualizarCurso.descripcion();
        }
        //Asegurar que una vez se actualice un curso y no se manipule su activacion, automaticamente se asigne activado.
        if(datosActualizarCurso.activo() == null){
            this.activo = true;
        } else {
            this.activo = datosActualizarCurso.activo();
        }
    }
    //Metodo para desactivar curso
    public void desactivarCurso() {
        this.activo = false;
    }
}