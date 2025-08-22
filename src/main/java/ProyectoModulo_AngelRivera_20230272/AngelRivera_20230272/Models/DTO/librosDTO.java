package ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Models.DTO;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class librosDTO {
    private long id;

    @NotBlank(message = "el titulo no puede estar vacio")
    private String titulo;

    @NotBlank(message = "el libro tiene que contar con su respectivo isbn")
    private String isbn;

    private int año_publicacion;
    private String genero;
    private long idAutor;
}
