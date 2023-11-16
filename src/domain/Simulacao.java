package domain;

import domain.entities.Usuario;
import infrastructure.Auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulacao {
    private List<Usuario> usuarios;
    private Auth authenticator;
    private Scanner scanner;

    private final int LOGIN = 1;
    private final int CADASTRAR = 2;

    public Simulacao() {
        this.usuarios = new ArrayList<Usuario>();
        popularUsuarios();
        this.scanner = new Scanner(System.in);
        this.authenticator = new Auth(this.usuarios);
    }

    public void run() {
        imprimeBemVindo();
        int opcaoEscolhida = fazerLoginOuCadastrar();
        this.authenticator.processar(opcaoEscolhida);
    }

    private void popularUsuarios() {
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João");
        usuario1.setEmail("joao@email.com");
        usuario1.setSenha("123");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("admin");
        usuario2.setEmail("admin@email.com");
        usuario2.setSenha("admin");

        usuarios.add(usuario1);
        usuarios.add(usuario2);
    }

    private void imprimeBemVindo() {
        System.out.println("BEM VINDO AO KnowHive");
        System.out.println("Unindo Saberes, Elevando Conquistas");
        System.out.println(" ------------------------------------");
        System.out.println("1 - Fazer Login \n2 - Cadastrar");
    }

    private int fazerLoginOuCadastrar() {
        int opcaoEscolhida = 0;
        do {
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número.");
                scanner.next();
            }
            opcaoEscolhida = scanner.nextInt();

            if (opcaoEscolhida != LOGIN && opcaoEscolhida != CADASTRAR) {
                System.out.println("Opção inválida. Digite 1 ou 2.");
            }
        } while (opcaoEscolhida != LOGIN && opcaoEscolhida != CADASTRAR);

        return opcaoEscolhida;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

