package domain.entities;

public class Alternativa {
    private String texto;
    private boolean correta;

    public Alternativa(String texto) {
        this.texto = texto;
        this.correta = false;
    }

    public Alternativa() {
        this.texto = "";
        this.correta = false;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }
}
