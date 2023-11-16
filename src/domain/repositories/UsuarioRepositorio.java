package domain.repositories;

import domain.entities.Usuario;
import domain.errors.UsuarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {
    private List<Usuario> usuarios;

    public UsuarioRepositorio() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public List<Usuario> retornaTodos() {
        return this.usuarios;
    }

    public Usuario retornaPorNome(String nome) {
        for (Usuario usuario: this.usuarios) {
            if (usuario.getNome().equals(nome))
                return usuario;
        }

        throw new UsuarioNaoEncontradoException();
    }

    public Usuario retornaPorEmailESenha(String email, String senha) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }

        throw new UsuarioNaoEncontradoException();
    }

    public void salvar(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}
