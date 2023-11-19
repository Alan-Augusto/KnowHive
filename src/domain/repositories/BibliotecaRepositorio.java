package domain.repositories;

import domain.entities.Biblioteca;
import domain.entities.Usuario;
import domain.errors.BibliotecaNaoEncontradaException;

import java.util.List;

public class BibliotecaRepositorio {
    private  Usuario usuario;

    public BibliotecaRepositorio(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Biblioteca> retornaTodos() {
        return this.usuario.getBibliotecasCompartilhadas();
    }

    public Biblioteca retornaPorNome(String nome) {
        List<Biblioteca> bibliotecas = this.usuario.getBibliotecasCompartilhadas();
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getNome().equals(nome))
                return biblioteca;
        }

        throw new BibliotecaNaoEncontradaException();
    }

    public void salvar(Biblioteca biblioteca, boolean ehPublica) {
        this.usuario.adicionarBibliotecaCompartilhada(biblioteca, ehPublica);
    }
}
