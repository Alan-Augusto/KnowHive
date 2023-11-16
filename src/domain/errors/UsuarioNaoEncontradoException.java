package domain.errors;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException() {
        super("Usuario nao encontrado");
    }
}
