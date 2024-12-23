package alura.fororacle.api_fororacle.domain.topicos;

import alura.fororacle.api_fororacle.domain.cursos.CursoRepository;
import alura.fororacle.api_fororacle.domain.estudiante.EstudianteRepository;
import alura.fororacle.api_fororacle.domain.topicos.validaciones.actualizacion.ValidadorDeActualizacionTopicos;
import alura.fororacle.api_fororacle.domain.topicos.validaciones.creacion.ValidadorDeTopicos;
import alura.fororacle.api_fororacle.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistroDeTopicos {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorDeTopicos> validadores;

    @Autowired
    private List<ValidadorDeActualizacionTopicos> validadoresActualizar;

    public DatosRespuestaCreacionTopico crearTopico(DatosRegistrarTopico datosRegistrarTopico){
        if(!cursoRepository.existsById(datosRegistrarTopico.idCurso())){
            throw new ValidacionException("El curso al que hace referencia no fue encontrado, valide el id, por favor.");
        }
        if(!estudianteRepository.existsById(datosRegistrarTopico.idEstudiante())){
            throw new ValidacionException("El estudiante al que hace referencia no fue encontrado, valide el id, por favor.");
        }

        //validadores de creacion de topicos
        validadores.forEach(v->v.validar(datosRegistrarTopico));

        //después de la validación, entonces, crea el topico.
        var fecha = LocalDateTime.now();
        var curso = cursoRepository.findById(datosRegistrarTopico.idCurso()).get();
        var estudiante = estudianteRepository.findById(datosRegistrarTopico.idEstudiante()).get();
        var registro = new Topico(null, curso, estudiante, datosRegistrarTopico.titulo(), datosRegistrarTopico.descripcion(), fecha,null);

        topicoRepository.save(registro);
        return new DatosRespuestaCreacionTopico(registro);
    }

    public DatosRespuestaTopicoSinRespuestas actualizarTopico(DatosActualizarTopico datosActualizarTopico){
        if(!cursoRepository.existsById(datosActualizarTopico.idTopico())){
            throw new ValidacionException("El curso al que hace referencia no fue encontrado, valide el id, por favor.");
        }
        if(!estudianteRepository.existsById(datosActualizarTopico.idEstudiante())){
            throw new ValidacionException("El estudiante al que hace referencia no fue encontrado, valide el id, por favor.");
        }

        //validadores
        validadoresActualizar.forEach(v-> v.validar(datosActualizarTopico));

        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.idTopico());
        topico.actualizarDatos(datosActualizarTopico);

        return new DatosRespuestaTopicoSinRespuestas(topico.getId(), topico.getTitulo(),topico.getDescripcion(),topico.getFecha(), topico.getEstudiante().getId(),
                topico.getCurso().getId(),topico.getNo_resuelto());
    }

    public void eliminarTopico(Long id){
        if(!topicoRepository.existsById(id)) {
            throw new ValidacionException("No existe un tópico con el id suministrado.");
        }
        Topico topico = topicoRepository.getReferenceById(id);
        var idTopico = topicoRepository.findByActivoTrue(topico.getId());
        if(!idTopico){
           throw new ValidacionException("El topico ya ha sido resuelto, y se encuentra inactivo. No es posible eliminarlo de la base de datos.");
        }
        //Marcamos como resuelto el topico, para que se posicione inactivo.
        topico.marcarComoResueltoElTopico();
    }

}
