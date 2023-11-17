package domain;

import domain.entities.Usuario;
import domain.auth.Auth;
import domain.repositories.UsuarioRepositorio;

import java.util.Date;
import java.util.Scanner;

public class Simulacao {
    private UsuarioRepositorio usuarioRepositorio;
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
        this.usuarioAtual = null;
        this.scanner = new Scanner(System.in);
        this.authenticator = new Auth(this.usuarioRepositorio, this.scanner);
    }

    public void iniciar() {
        imprimeBemVindo();

        int opcaoEscolhida = fazerLoginOuCadastrar();
        this.usuarioAtual = this.authenticator.processar(opcaoEscolhida);

        requisitarComandos();

        this.scanner.close();
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
        int opcaoEscolhida = 0;
        do {
            System.out.print("Escolha uma opção: ");
            opcaoEscolhida = pegarNumero();

            if (!opcaoEhValida(opcaoEscolhida, opcoes)) {
                System.out.println("Opção inválida. Digite 1 ou 2.");
                continue;
            }
        } while (!opcaoEhValida(opcaoEscolhida, opcoes));

        return opcaoEscolhida;
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

    private void requisitarComandos() {
        int comandoEscolhido = -1;
        do {
            imprimeComandos();
            comandoEscolhido = pegarNumero();

            if (!opcaoEhValida(comandoEscolhido, comandosDisponiveis)) {
                System.out.println("Comando invalido. Digite novamente");
                continue;
            }

            processarComando(comandoEscolhido);
        } while (true);
    }

    private void imprimeComandos() {
        System.out.println("1 - Criar Biblioteca");
        System.out.println("2 - Adicionar Questão");
        System.out.println("3 - Visualizar Biblioteca");
        System.out.println("4 - Listar bibliotecas existentes");
        System.out.println("0 - Sair");
        System.out.print("Selecione um comando: ");
    }

    // TODO
    private void processarComando(int comando) {
        switch (comando) {
            case (SAIR):
                System.exit(1);
                break;

            default:
                throw new RuntimeException("Comando invalido: " + comando);
        }
    }
}

