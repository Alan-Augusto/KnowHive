package domain.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Date dataNascimento;
    private List<Biblioteca> bibliotecasCompartilhadas;

    public Usuario() {
        bibliotecasCompartilhadas = new ArrayList<>();
    }

    public Usuario(String nome, String email, String senha, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void adicionarBibliotecaCompartilhada(Biblioteca biblioteca, boolean permissaoEdicao) {
        // Lógica para adicionar uma biblioteca compartilhada
        biblioteca.setVisibilidade(permissaoEdicao); // Definindo a visibilidade conforme a permissão de edição
        bibliotecasCompartilhadas.add(biblioteca);
    }

    public List<Biblioteca> getBibliotecasCompartilhadas() {
        return bibliotecasCompartilhadas;
    }

    public void setBibliotecasCompartilhadas(List<Biblioteca> bibliotecasCompartilhadas) {
        this.bibliotecasCompartilhadas = bibliotecasCompartilhadas;
    }
}
