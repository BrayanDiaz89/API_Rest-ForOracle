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

    public Curso(DatosRegistrarCurso datosRegistrarCurso) {
        this.nombre = datosRegistrarCurso.nombre();
        this.descripcion = datosRegistrarCurso.descripcion();
    }
}