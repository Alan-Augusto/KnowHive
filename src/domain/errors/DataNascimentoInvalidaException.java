package domain.errors;

public class DataNascimentoInvalidaException extends RuntimeException {
    public DataNascimentoInvalidaException() {
        super("Data de nascimento invalida. Certifique-se de seguir o padrao especificado!");
    }
}
