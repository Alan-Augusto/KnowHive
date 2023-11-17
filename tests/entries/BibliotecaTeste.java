package domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTeste {

    private Biblioteca biblioteca;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
    }

    @Test
    void getNome() {
        biblioteca.setNome("Biblioteca A");
        assertEquals("Biblioteca A", biblioteca.getNome());
    }

    @Test
    void setNome() {
        biblioteca.setNome("Biblioteca B");
        assertEquals("Biblioteca B", biblioteca.getNome());
    }

    @Test
    void getDescricao() {
        biblioteca.setDescricao("Teste descricao 1");
        assertEquals("Teste descricao 1", biblioteca.getDescricao());
    }

    @Test
    void setDescricao() {
        biblioteca.setDescricao("Teste descricao 2");
        assertEquals("Teste descricao 2", biblioteca.getDescricao());
    }

    @Test
    void isVisibilidade() {
        assertFalse(biblioteca.isVisibilidade());
    }

    @Test
    void setVisibilidade() {
        biblioteca.setVisibilidade(true);
        assertTrue(biblioteca.isVisibilidade());
    }

    @Test
    void novaQuestao() {
        Questao questao = new Questao();
        biblioteca.novaQuestao(questao);
        assertTrue(biblioteca.getQuestoes().contains(questao));
    }

    @Test
    void apagarQuestao() {
        Questao questao = new Questao();
        biblioteca.novaQuestao(questao);
        biblioteca.apagarQuestao(questao);
        assertFalse(biblioteca.getQuestoes().contains(questao));
    }

    @Test
    void getQuestoes() {
        List<Questao> questoes = new ArrayList<>();
        questoes.add(new Questao());
        biblioteca.setQuestoes(questoes);
        assertEquals(questoes, biblioteca.getQuestoes());
    }

    @Test
    void setQuestoes() {
        List<Questao> questoes = new ArrayList<>();
        questoes.add(new Questao());
        biblioteca.setQuestoes(questoes);
        assertEquals(questoes, biblioteca.getQuestoes());
    }
}
