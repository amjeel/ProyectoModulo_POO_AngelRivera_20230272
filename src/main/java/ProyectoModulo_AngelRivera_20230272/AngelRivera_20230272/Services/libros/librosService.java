package ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Services.libros;

import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Entities.librosEntity;
import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Exceptions.ExceptionLibronoEncontrado;
import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Models.DTO.LibrosDTO;
import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Repositories.librosRepository.librosRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class librosService {
    @Autowired
    private librosRepository repo;

    public List<LibrosDTO> getAllLibros(){
        List<librosEntity> libros = repo.findAll();
        return libros.stream()
                .map(this::convertirALibroDTO)
                .collect(Collectors.toList());
    }

    public LibrosDTO insertLibros(LibrosDTO json){

        if (json == null){
            throw new IllegalArgumentException("La información del libro no puede estar vacia");
        }
        try{
            librosEntity objData = convertirALibroEntity(json);
            librosEntity productoGuardado = repo.save(objData);
            return convertirALibroDTO(objData);
        }catch (Exception e){
            log.error("Error al registrar el libro" + e.getMessage());
            throw new ExceptionLibronoEncontrado("El libro no pudo ser registrado");
        }
    }
    public LibrosDTO ActualizarLibro(Long id,  LibrosDTO libros) {
        librosEntity libroExistente = repo.findById(id).orElseThrow(()-> new
                ExceptionLibronoEncontrado("Libro no encontrado"));

        libroExistente.setTitulo(libros.getTitulo());
        libroExistente.setIsbn(libros.getIsbn());
        libroExistente.setAño_publicacion(libros.getAño_publicacion());
        libroExistente.setGenero(libros.getGenero());
        libroExistente.setIdAutor(libros.getIdAutor());
        librosEntity productoActualizado = repo.save(libroExistente);
        //4. Convertir a DTO
        return convertirALibroDTO(productoActualizado);
    }

    private LibrosDTO convertirALibroDTO(librosEntity libros) {
        LibrosDTO dto = new LibrosDTO();
        dto.setId(libros.getId());
        dto.setTitulo(libros.getTitulo());
        dto.setIsbn(libros.getIsbn());
        dto.setAño_publicacion(libros.getAño_publicacion());
        dto.setGenero(libros.getGenero());
        dto.setIdAutor(libros.getIdAutor());
        return dto;
    }
    private librosEntity convertirALibroEntity(@Valid LibrosDTO json) {
        librosEntity entity = new librosEntity();
        entity.setId(json.getId());
        entity.setTitulo(json.getTitulo());
        entity.setIsbn(json.getIsbn());
        entity.setAño_publicacion(json.getAño_publicacion());
        entity.setGenero(json.getGenero());
        entity.setIdAutor(json.getIdAutor());
        return entity;
    }

}
