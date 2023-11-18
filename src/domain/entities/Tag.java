package domain.entities;

public class Tag {
    private String nome;

    public Tag(String nome) {
        this.nome = nome;
    }

    public Tag() {
        this.nome = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
