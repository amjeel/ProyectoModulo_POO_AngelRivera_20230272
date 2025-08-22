package ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Services.libros;

import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Entities.librosEntity;
import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Models.DTO.LibrosDTO;
import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Repositories.librosRepository.librosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
}
