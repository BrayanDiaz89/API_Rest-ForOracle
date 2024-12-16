package alura.fororacle.api_fororacle.domain.cursos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="cursos")
@Entity(name="Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="idCurso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    private String nombre;
    private String descripcion;

    public Long getIdCurso() {
        return idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Curso(@Valid DatosRegistrarCurso datosRegistrarCurso) {
        this.nombre = datosRegistrarCurso.nombre();
        this.descripcion = datosRegistrarCurso.descripcion();
    }
}