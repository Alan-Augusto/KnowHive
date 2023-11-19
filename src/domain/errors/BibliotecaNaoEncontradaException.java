package domain.errors;

public class BibliotecaNaoEncontradaException extends RuntimeException {
    public BibliotecaNaoEncontradaException() {
        super("Biblioteca nao encontrada");
    }
}
