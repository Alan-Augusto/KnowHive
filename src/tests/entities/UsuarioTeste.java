package tests.entities;

import domain.entities.Biblioteca;
import domain.entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTeste {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
    }

    @Test
    void adicionarBibliotecaCompartilhada() {
        Biblioteca biblioteca = new Biblioteca();
        usuario.adicionarBibliotecaCompartilhada(biblioteca, true);
        List<Biblioteca> bibliotecasCompartilhadas = usuario.getBibliotecasCompartilhadas();

        assertEquals(1, bibliotecasCompartilhadas.size());
        assertTrue(bibliotecasCompartilhadas.contains(biblioteca));
        assertTrue(biblioteca.isVisibilidade());
    }

    @Test
    void getNome() {
        usuario.setNome("Nome usuario 1");
        assertEquals("Nome usuario 1", usuario.getNome());
    }

    @Test
    void setNome() {
        usuario.setNome("Nome usuario 2");
        assertEquals("Nome usuario 2", usuario.getNome());
    }

    @Test
    void getEmail() {
        usuario.setEmail("usuario1@exemplo.com");
        assertEquals("usuario1@exemplo.com", usuario.getEmail());
    }

    @Test
    void setEmail() {
        usuario.setEmail("usuario2@exemplo.com");
        assertEquals("usuario2@exemplo.com", usuario.getEmail());
    }

    @Test
    void getSenha() {
        usuario.setSenha("senha1");
        assertEquals("senha1", usuario.getSenha());
    }

    @Test
    void setSenha() {
        usuario.setSenha("senha2");
        assertEquals("senha2", usuario.getSenha());
    }

    @Test
    void getDataNascimento() {
        Date dataNascimento = new Date();
        usuario.setDataNascimento(dataNascimento);
        assertEquals(dataNascimento, usuario.getDataNascimento());
    }

    @Test
    void setDataNascimento() {
        Date newDataNascimento = new Date();
        usuario.setDataNascimento(newDataNascimento);
        assertEquals(newDataNascimento, usuario.getDataNascimento());
    }

    @Test
    void getBibliotecasCompartilhadas() {
        List<Biblioteca> bibliotecas = new ArrayList<>();
        bibliotecas.add(new Biblioteca());
        usuario.setBibliotecasCompartilhadas(bibliotecas);
        assertEquals(bibliotecas, usuario.getBibliotecasCompartilhadas());
    }

    @Test
    void setBibliotecasCompartilhadas() {
        List<Biblioteca> newBibliotecas = new ArrayList<>();
        newBibliotecas.add(new Biblioteca());
        usuario.setBibliotecasCompartilhadas(newBibliotecas);
        assertEquals(newBibliotecas, usuario.getBibliotecasCompartilhadas());
    }
}
