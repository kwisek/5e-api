package pl.kwisek.dnd5e.exception;

public class DataIntegrityException extends RuntimeException {

    public DataIntegrityException(String msg) {
        super(msg);
    }
}
