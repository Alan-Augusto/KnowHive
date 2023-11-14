import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        // Criando usuários
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João");
        usuario1.setEmail("joao@email.com");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Maria");
        usuario2.setEmail("maria@email.com");

        // Criando bibliotecas
        Biblioteca biblioteca1 = new Biblioteca();
        biblioteca1.setNome("Biblioteca de Matemática");
        biblioteca1.setDescricao("Questões de matemática variadas");
        biblioteca1.setVisibilidade(true); // Pública

        Biblioteca biblioteca2 = new Biblioteca();
        biblioteca2.setNome("Biblioteca de História");
        biblioteca2.setDescricao("Questões de história mundial");
        biblioteca2.setVisibilidade(false); // Privada

        // Associando questões às bibliotecas
        Questao questao1 = new Questao();
        questao1.setEnunciado("Qual é a capital do Brasil?");
        questao1.setObservacao("Questão de múltipla escolha");
        questao1.setVisibilidade(true); // Pública

        Alternativa alt1 = new Alternativa();
        alt1.setTexto("Brasília");
        alt1.setCorreta(true);

        Alternativa alt2 = new Alternativa();
        alt2.setTexto("São Paulo");
        alt2.setCorreta(false);

        questao1.novaAlternativa(alt1);
        questao1.novaAlternativa(alt2);

        Fonte fonte1 = new Fonte();
        fonte1.setTexto("Livro de Geografia");
        fonte1.setDescricao("Página 50");

        questao1.novaFonte(fonte1);

        Tag tag1 = new Tag();
        tag1.setNome("Geografia");

        questao1.novaTag(tag1);

        biblioteca1.novaQuestao(questao1);

        // Adicionar mais questões, associar às bibliotecas, etc.

        // Compartilhando biblioteca2 com usuario1
        usuario1.adicionarBibliotecaCompartilhada(biblioteca2, true); // Com permissão de edição

        // Responder às questões da biblioteca1 (prova)
        List<Questao> questoesProva = biblioteca1.getQuestoes();
        List<RespostaQuestao> respostasProvaUsuario1 = new ArrayList<>();

        for (Questao questao : questoesProva) {
            // Lógica para responder às questões da prova pelo usuário1
            // Preencher respostasProvaUsuario1 com as respostas dadas
        }

        // Gerar relatório de desempenho da prova para usuario1
        RelatorioDesempenho relatorioUsuario1 = new RelatorioDesempenho();
        relatorioUsuario1.gerarRelatorio(questoesProva, respostasProvaUsuario1);
    }
}
