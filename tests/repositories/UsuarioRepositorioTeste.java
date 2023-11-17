package domain.repositories;

import domain.entities.Usuario;
import domain.errors.UsuarioNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRepositorioTeste {

    private UsuarioRepositorio usuarioRepositorio;

    @BeforeEach
    void setUp() {
        usuarioRepositorio = new UsuarioRepositorio();
    }

    @Test
    void retornaTodos() {
        assertTrue(usuarioRepositorio.retornaTodos().isEmpty());

        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();

        usuarioRepositorio.salvar(usuario1);
        usuarioRepositorio.salvar(usuario2);

        assertEquals(2, usuarioRepositorio.retornaTodos().size());
    }

    @Test
    void retornaPorNome() {
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario 1");
        usuarioRepositorio.salvar(usuario);

        assertEquals(usuario, usuarioRepositorio.retornaPorNome("Usuario 1"));
    }

    @Test
    void retornaPorNomeUsuarioNaoEncontrado() {
        assertThrows(UsuarioNaoEncontradoException.class,
                () -> usuarioRepositorio.retornaPorNome("Usuario nao encontrado"));
    }

    @Test
    void retornaPorEmailESenha() {
        Usuario usuario = new Usuario();
        usuario.setEmail("usuario@exemplo.com");
        usuario.setSenha("senha1");
        usuarioRepositorio.salvar(usuario);

        assertEquals(usuario, usuarioRepositorio.retornaPorEmailESenha("usuario@exemplo.com", "senha1"));
    }

    @Test
    void retornaPorEmailESenhaUsuarioNaoEncontrado() {
        assertThrows(UsuarioNaoEncontradoException.class,
                () -> usuarioRepositorio.retornaPorEmailESenha("usuario.inexistente@exemplo.com", "senhaerrada"));
    }

    @Test
    void salvar() {
        assertTrue(usuarioRepositorio.retornaTodos().isEmpty());

        Usuario usuario = new Usuario();
        usuarioRepositorio.salvar(usuario);

        assertEquals(1, usuarioRepositorio.retornaTodos().size());
    }
}
