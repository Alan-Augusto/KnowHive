package tests.entities;

import domain.entities.Questao;
import domain.entities.RelatorioDesempenho;
import domain.entities.RespostaQuestao;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RelatorioDesempenhoTeste {

    @Test
    void gerarRelatorio() {
        RelatorioDesempenho relatorio = new RelatorioDesempenho();

        List<Questao> questoes = new ArrayList<>();
        List<RespostaQuestao> respostas = new ArrayList<>();

        Questao questao1 = new Questao();
        questao1.setEnunciado("Questão 1");
        questoes.add(questao1);

        RespostaQuestao resposta1 = new RespostaQuestao();
        resposta1.setRespostaUsuario("Resposta 1");
        respostas.add(resposta1);

        Questao questao2 = new Questao();
        questao2.setEnunciado("Questão 2");
        questoes.add(questao2);

        RespostaQuestao resposta2 = new RespostaQuestao();
        resposta2.setRespostaUsuario("Resposta 2");
        respostas.add(resposta2);

        // Necessario fazer a checagem do relatorio no terminal.
        relatorio.gerarRelatorio(questoes, respostas);
    }
}
