import java.util.List;

public class RelatorioDesempenho {

    public void gerarRelatorio(List<Questao> questoes, List<RespostaQuestao> respostas) {
        // Lógica para gerar o relatório de desempenho com base nas questões e respostas fornecidas

        // Aqui podemos calcular o tempo de execução, questões menos acertadas, etc.

        // Exemplo básico:
        System.out.println("Relatório de Desempenho:");
        for (int i = 0; i < questoes.size(); i++) {
            Questao questao = questoes.get(i);
            RespostaQuestao resposta = respostas.get(i);
            System.out.println("Questão: " + questao.getEnunciado());
            System.out.println("Resposta dada: " + resposta.getRespostaUsuario());
        }
    }
}
