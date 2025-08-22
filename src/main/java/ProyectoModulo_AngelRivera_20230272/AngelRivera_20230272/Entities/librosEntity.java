package ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "LIBROS")
public class librosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "seq_LIBROS")
    @SequenceGenerator(sequenceName = "seq_LIBROS", name = "seq_LIBROS", allocationSize = 1)
    @Column (name = "id")
    private long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "isbn")
    private String isbn;
    @Column (name = "año_publicacion")
    private int año_publicacion;
    @Column(name = "genero")
    private String genero;
    @Column (name = "id")
    private long idAutor;
}
