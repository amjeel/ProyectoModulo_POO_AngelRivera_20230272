package ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Controller.libros;

import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Models.DTO.LibrosDTO;
import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Services.libros.librosService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/libros")
public class librosController {

    @Autowired
    private librosService service;
    @GetMapping("/getallLibros")
    public List<LibrosDTO> datosLibro(){
        return service.getAllLibros();
    }

    @PostMapping("/IngresarLibros")
    public ResponseEntity <Map<String, Object>> registrarLibro(@Valid @RequestBody LibrosDTO libros,
                                                               HttpServletRequest request){
        try{
            LibrosDTO respuesta == service.insertLibro(libros);
            if(respuesta== null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Inserción"
                ))
            }
        }
    }
}
