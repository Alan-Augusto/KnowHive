package tests.entities;

import domain.entities.Alternativa;
import domain.entities.Fonte;
import domain.entities.Questao;
import domain.entities.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestaoTeste {

    private Questao questao;

    @BeforeEach
    void setUp() {
        questao = new Questao();
    }

    @Test
    void getEnunciado() {
        questao.setEnunciado("Enunciado questão 1");
        assertEquals("Enunciado questão 1", questao.getEnunciado());
    }

    @Test
    void setEnunciado() {
        questao.setEnunciado("Enunciado questão 2");
        assertEquals("Enunciado questão 2", questao.getEnunciado());
    }

    @Test
    void getObservacao() {
        questao.setObservacao("Observacao 1");
        assertEquals("Observacao 1", questao.getObservacao());
    }

    @Test
    void setObservacao() {
        questao.setObservacao("Observacao 2");
        assertEquals("Observacao 2", questao.getObservacao());
    }

    @Test
    void isVisibilidade() {
        assertFalse(questao.isVisibilidade());
    }

    @Test
    void setVisibilidade() {
        questao.setVisibilidade(true);
        assertTrue(questao.isVisibilidade());
    }

    @Test
    void novaFonte() {
        Fonte fonte = new Fonte();
        questao.novaFonte(fonte);
        assertTrue(questao.getFontes().contains(fonte));
    }

    @Test
    void apagarFonte() {
        Fonte fonte = new Fonte();
        questao.novaFonte(fonte);
        questao.apagarFonte(fonte);
        assertFalse(questao.getFontes().contains(fonte));
    }

    @Test
    void novaTag() {
        Tag tag = new Tag();
        questao.novaTag(tag);
        assertTrue(questao.getTags().contains(tag));
    }

    @Test
    void apagarTag() {
        Tag tag = new Tag();
        questao.novaTag(tag);
        questao.apagarTag(tag);
        assertFalse(questao.getTags().contains(tag));
    }

    @Test
    void novaAlternativa() {
        Alternativa alternativa = new Alternativa();
        questao.novaAlternativa(alternativa);
        assertTrue(questao.getAlternativas().contains(alternativa));
    }

    @Test
    void apagarAlternativa() {
        Alternativa alternativa = new Alternativa();
        questao.novaAlternativa(alternativa);
        questao.apagarAlternativa(alternativa);
        assertFalse(questao.getAlternativas().contains(alternativa));
    }

    @Test
    void getFontes() {
        List<Fonte> fontes = new ArrayList<>();
        fontes.add(new Fonte());
        questao.setFontes(fontes);
        assertEquals(fontes, questao.getFontes());
    }

    @Test
    void setFontes() {
        List<Fonte> fontes = new ArrayList<>();
        fontes.add(new Fonte());
        questao.setFontes(fontes);
        assertEquals(fontes, questao.getFontes());
    }

    @Test
    void getTags() {
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag());
        questao.setTags(tags);
        assertEquals(tags, questao.getTags());
    }

    @Test
    void setTags() {
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag());
        questao.setTags(tags);
        assertEquals(tags, questao.getTags());
    }

    @Test
    void getAlternativas() {
        List<Alternativa> alternativas = new ArrayList<>();
        alternativas.add(new Alternativa());
        questao.setAlternativas(alternativas);
        assertEquals(alternativas, questao.getAlternativas());
    }

    @Test
    void setAlternativas() {
        List<Alternativa> alternativas = new ArrayList<>();
        alternativas.add(new Alternativa());
        questao.setAlternativas(alternativas);
        assertEquals(alternativas, questao.getAlternativas());
    }
}
