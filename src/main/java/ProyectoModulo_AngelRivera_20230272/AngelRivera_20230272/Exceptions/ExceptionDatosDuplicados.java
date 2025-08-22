package ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Exceptions;

public class ExceptionDatosDuplicados extends RuntimeException {
    public String getCampoDuplicado;

    public ExceptionDatosDuplicados(String message) {
        super(message);
    }
}
