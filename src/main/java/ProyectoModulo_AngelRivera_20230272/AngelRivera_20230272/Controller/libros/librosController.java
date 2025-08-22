package ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Controller.libros;

import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Exceptions.ExceptionDatosDuplicados;
import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Models.DTO.LibrosDTO;
import ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Services.libros.librosService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
            LibrosDTO respuesta = service.insertLibros(libros);
            if(respuesta== null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Inserción incorrecta",
                        "errorType", "VALIDATION_ERROR",
                        "message", "Datos del libro invalidos"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "succes",
                    "data", respuesta));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "status", "error",
                            "message", "error al registrar el libro",
                            "detail", e.getMessage()
                    ));
        }
    }
    @PutMapping("/ActualizarLibro/{id}")
    public ResponseEntity<?> ActualizarLibro(
            @PathVariable Long id,
            @Valid @RequestBody LibrosDTO libros,
            BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String,String> errores = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error->
                    errores.put(error.getField(),error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        try{
            LibrosDTO libroActualizado = service.ActualizarLibro(id, libros);
            return  ResponseEntity.notFound().build();
        }catch (ExceptionDatosDuplicados e){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Map.of("error", "Datos duplicados", "campo", e.getCampoDuplicado)
            );
        }
    }
}
