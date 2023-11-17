package domain.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RespostaQuestaoTeste {

    @Test
    void getQuestao() {
        RespostaQuestao resposta = new RespostaQuestao();
        Questao questao = new Questao();
        resposta.setQuestao(questao);
        assertEquals(questao, resposta.getQuestao());
    }

    @Test
    void setQuestao() {
        RespostaQuestao resposta = new RespostaQuestao();
        Questao questao = new Questao();
        resposta.setQuestao(questao);
        assertEquals(questao, resposta.getQuestao());
    }

    @Test
    void getRespostaUsuario() {
        RespostaQuestao resposta = new RespostaQuestao();
        resposta.setRespostaUsuario("Resposta 1");
        assertEquals("Resposta 1", resposta.getRespostaUsuario());
    }

    @Test
    void setRespostaUsuario() {
        RespostaQuestao resposta = new RespostaQuestao();
        resposta.setRespostaUsuario("Resposta 2");
        assertEquals("Resposta 2", resposta.getRespostaUsuario());
    }
}
