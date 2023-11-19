package domain;

import domain.entities.Alternativa;
import domain.entities.Biblioteca;
import domain.entities.Questao;
import domain.entities.Usuario;
import domain.auth.Auth;
import domain.errors.BibliotecaNaoEncontradaException;
import domain.repositories.BibliotecaRepositorio;
import domain.repositories.UsuarioRepositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Simulacao {
    private UsuarioRepositorio usuarioRepositorio;
    private BibliotecaRepositorio bibliotecaRepositorio;
    private Usuario usuarioAtual;
    private Auth authenticator;
    private Scanner scanner;

    private final int LOGIN = 1;
    private final int CADASTRAR = 2;
    private final int SAIR = 0;
    private final int CRIAR_BIBLIOTECA = 1;
    private final int ADICIONAR_QUESTAO = 2;
    private final int VISUALIZAR_BIBLIOTECA = 3;
    private final int LISTAR_BIBLIOTECAS = 4;
    private int[] comandosDisponiveis = new int[]{SAIR, CRIAR_BIBLIOTECA, ADICIONAR_QUESTAO, VISUALIZAR_BIBLIOTECA, LISTAR_BIBLIOTECAS};

    public Simulacao() {
        this.usuarioRepositorio = new UsuarioRepositorio();
        popularUsuarios();
        this.bibliotecaRepositorio = null;
        this.usuarioAtual = null;
        this.scanner = new Scanner(System.in);
        this.authenticator = new Auth(this.usuarioRepositorio, this.scanner);
    }

    public void iniciar() {
        imprimeBemVindo();

        int opcaoEscolhida = fazerLoginOuCadastrar();

        this.usuarioAtual = this.authenticator.processar(opcaoEscolhida);

        this.bibliotecaRepositorio = new BibliotecaRepositorio(usuarioAtual);

        do {
            int comandoEscolhido = requisitarComando(obterTextoComandos(), comandosDisponiveis);
            processarComando(comandoEscolhido);
        } while (true);
    }

    private void popularUsuarios() {
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João");
        usuario1.setEmail("joao@email.com");
        usuario1.setSenha("123");
        usuario1.setDataNascimento(new Date("01/01/2000"));

        Usuario usuario2 = new Usuario();
        usuario2.setNome("admin");
        usuario2.setEmail("admin@email.com");
        usuario2.setSenha("admin");
        usuario2.setDataNascimento(new Date("31/12/1990"));

        this.usuarioRepositorio.salvar(usuario1);
        this.usuarioRepositorio.salvar(usuario2);
    }

    private void imprimeBemVindo() {
        System.out.println("BEM VINDO AO KnowHive");
        System.out.println("Unindo Saberes, Elevando Conquistas");
        System.out.println(" ------------------------------------");
        System.out.println("1 - Fazer Login \n2 - Cadastrar");
    }

    private int fazerLoginOuCadastrar() {
        int[] opcoes = new int[]{LOGIN, CADASTRAR};
        int opcaoEscolhida = requisitarComando("Escolha uma opção: ", opcoes);

        return opcaoEscolhida;
    }

    private int requisitarComando(String prompt, int[] comandos) {
        int comandoEscolhido = -1;
        do {
            System.out.print(prompt);
            comandoEscolhido = pegarNumero();

            if (!opcaoEhValida(comandoEscolhido, comandos)) {
                System.out.println("Opcao invalida. Digite novamente");
                continue;
            }

            return comandoEscolhido;
        } while (true);
    }

    // Solicita um numero ate o usuario prove-lo
    private int pegarNumero() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, digite um número.");
            scanner.next();
        }

        int numero = scanner.nextInt();

        // Limpa o caracter \n do scanner
        scanner.nextLine();

        return numero;
    }

    private boolean opcaoEhValida(int opcaoEscolhida, int[] opcoes) {
        for (int opcao: opcoes) {
            if (opcao == opcaoEscolhida)
                return true;
        }

        return false;
    }

    private String obterTextoComandos() {
        StringBuilder textoComandos = new StringBuilder();
        textoComandos.append("1 - Criar Biblioteca\n");
        textoComandos.append("2 - Adicionar Questão\n");
        textoComandos.append("3 - Visualizar Biblioteca\n");
        textoComandos.append("4 - Listar bibliotecas existentes\n");
        textoComandos.append("0 - Sair\n");
        textoComandos.append("Selecione um comando: ");

        return textoComandos.toString();
    }

    private void processarComando(int comando) {
        switch (comando) {
            case (SAIR):
                System.exit(1);
                break;

            case (CRIAR_BIBLIOTECA):
                criarBiblioteca();
                break;

            case (ADICIONAR_QUESTAO):
                adicionarQuestao();
                break;

            case (VISUALIZAR_BIBLIOTECA):
                visualizarBiblioteca();
                break;

            case (LISTAR_BIBLIOTECAS):
                listarBibliotecas();
                break;

            default:
                throw new RuntimeException("Comando invalido: " + comando);
        }
    }

    private void criarBiblioteca() {
        System.out.print("Digite o nome da nova biblioteca: ");
        String nomeBiblioteca = scanner.nextLine();

        System.out.print("Digite a descricao da biblioteca: ");
        String descricao = scanner.nextLine();

        String opcoesTexto = "1 - Publico\n2 - Privado\nEscolha a visibilidade da biblioteca: ";

        int visibilidadeEscolhida = requisitarComando(opcoesTexto, new int[]{1, 2});
        boolean ehPublico = visibilidadeEscolhida == 1;

        this.usuarioAtual.adicionarBibliotecaCompartilhada(new Biblioteca(nomeBiblioteca, descricao), ehPublico);

        System.out.println("Biblioteca '" + nomeBiblioteca + "' criada com sucesso");
    }

    private void adicionarQuestao() {
        Biblioteca biblioteca = requisitarNomeBiblioteca();

        System.out.print("Digite as tags desejadas (separadas por espaço): ");
        String tags = scanner.nextLine();

        System.out.print("Digite o enunciado da questao: ");
        String enunciado = scanner.nextLine();

        System.out.println("Preencha as alternativas. Digite 'sair' para finalizar. ");
        List<Alternativa> alternativas = coletarAlternativas();

        System.out.print("Digite o número da alternativa correta: ");
        int indexAlternativaCorreta = Integer.parseInt(scanner.nextLine()) - 1;

        alternativas.get(indexAlternativaCorreta).setCorreta(true);

        Questao questao = new Questao(enunciado, alternativas);
        questao.setTags(tags);

        biblioteca.novaQuestao(questao);

        System.out.println("Questao criada com sucesso na biblioteca '" + biblioteca.getNome() + "'.");
    }

    private Biblioteca requisitarNomeBiblioteca() {
        String nomeBiblioteca = "";
        do {
            System.out.print("Digite o nome da biblioteca desejada: ");
            nomeBiblioteca = scanner.nextLine();

            if (!bibliotecaExiste(nomeBiblioteca)) {
                System.out.println("Biblioteca nao encontrada. Tente novamente.");
                continue;
            }

        } while (!bibliotecaExiste(nomeBiblioteca));

        return this.bibliotecaRepositorio.retornaPorNome(nomeBiblioteca);
    }

    private boolean bibliotecaExiste(String nome) {
        try {
            this.bibliotecaRepositorio.retornaPorNome(nome);
            return true;
        } catch (BibliotecaNaoEncontradaException e) {
            return false;
        }
    }

    private List<Alternativa> coletarAlternativas() {
        List<Alternativa> alternativas = new ArrayList<>();
        String textoAlternativa = null;
        int numeroAlternativa = 1;
        do {
            System.out.print(numeroAlternativa + ") ");
            textoAlternativa = scanner.nextLine();

            if (!textoAlternativa.equals("sair"))
                alternativas.add(new Alternativa(textoAlternativa));

            numeroAlternativa++;
        } while (!textoAlternativa.equals("sair"));

        return alternativas;
    }

    private void visualizarBiblioteca() {
        Biblioteca biblioteca = requisitarNomeBiblioteca();

        System.out.println("Nome: " + biblioteca.getNome());
        System.out.println("Descricao: " + biblioteca.getDescricao());
        System.out.println("Questoes:");

        imprimirQuestoes(biblioteca);
    }

    private void imprimirQuestoes(Biblioteca biblioteca) {
        List<Questao> questoes = biblioteca.getQuestoes();
        for (int i = 0; i < questoes.size(); i++) {
            Questao questaoAtual = questoes.get(i);

            System.out.println("\t" + (i+1) + ". " + questaoAtual.getEnunciado());
            imprimirAlternativas(questaoAtual,i+1);
        }
    }

    private void imprimirAlternativas(Questao questao, int index) {
        List<Alternativa> alternativas = questao.getAlternativas();
        for (int j = 0; j < alternativas.size(); j++) {
            Alternativa alternativa = alternativas.get(j);
            System.out.print("\t\t" + index + "." + (j+1) + ". ");

            if (alternativa.isCorreta())
                System.out.print("(V) ");

            System.out.println(alternativa.getTexto());
        }
    }

    private void listarBibliotecas() {
        System.out.println("Bibliotecas existentes:");
        List<Biblioteca> bibliotecas = this.bibliotecaRepositorio.retornaTodos();
        for (Biblioteca biblioteca : bibliotecas) {
            System.out.println(biblioteca.getNome());
        }
    }
}

