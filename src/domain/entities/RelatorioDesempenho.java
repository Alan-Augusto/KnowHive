package domain.entities;

import java.util.List;

public class RelatorioDesempenho {

    public void gerarRelatorio(List<Questao> questoes, List<RespostaQuestao> respostas) {
        // Verificar se as listas não estão vazias
        if (questoes.isEmpty() || respostas.isEmpty()) {
            System.out.println("Não há questões ou respostas para gerar o relatório.");
            return;
        }

        // Verificar se as listas têm o mesmo tamanho
        if (questoes.size() != respostas.size()) {
            System.out
                    .println("O número de questões é diferente do número de respostas. Impossível gerar o relatório.");
            return;
        }

        // Lógica para gerar o relatório de desempenho com base nas questões e respostas
        // fornecidas
        System.out.println("Relatório de Desempenho:");
        for (int i = 0; i < questoes.size(); i++) {
            Questao questao = questoes.get(i);
            RespostaQuestao resposta = respostas.get(i);
            System.out.println("Questão: " + questao.getEnunciado());
            System.out.println("Resposta dada: " + resposta.getRespostaUsuario());
        }
    }
}
