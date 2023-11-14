import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static List<Usuario> usuarios = new ArrayList<>();
    public static Boolean login = false;

    public static void main(String[] args) {
        povoar();
        Scanner scanner = new Scanner(System.in);
        String opEntrada = loginORsigin(scanner);
        Boolean exit = false;

        while (!exit || !login) {

        }
        if (opEntrada.equals("Cadastro")) {
            cadastrar(scanner);
        } else if (opEntrada.equals("Login")) {
            fazerLogin(scanner);
        }

        while (login) {

        }

        scanner.close();
    }

    public static String loginORsigin(Scanner scanner) {
        String opcaoSelecionada = "INVALIDO";

        System.out.println("BEM VINDO AO KnowHive");
        System.out.println(" Unindo Saberes, Elevando Conquistas");
        System.out.println(" ------------------------------------");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Fazer Login \n2 - Cadastrar");

        while (opcaoSelecionada.equals("INVALIDO")) {
            String entradaUsuario = scanner.nextLine();

            if (entradaUsuario.equals("1")) {
                opcaoSelecionada = "Login";
            } else if (entradaUsuario.equals("2")) {
                opcaoSelecionada = "Cadastro";
            } else {
                System.out.println("!!OPÇÃO INVÁLIDA!!");
                opcaoSelecionada = "INVALIDO";
            }
        }

        System.out.println("selecionou -> " + opcaoSelecionada);
        return opcaoSelecionada;
    }

    public static void cadastrar(Scanner scanner) {
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o email: ");
        String email = scanner.nextLine();

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        usuarios.add(novoUsuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    public static void fazerLogin(Scanner scanner) {
        System.out.println("Digite o email: ");
        String email = scanner.nextLine();

        boolean encontrado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                encontrado = true;
                System.out.println("Login bem-sucedido para o usuário: " + usuario.getNome());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Usuário não encontrado. Faça o cadastro primeiro.");
        }
    }

    public static void povoar() {
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João");
        usuario1.setEmail("joao@email.com");
        usuario1.setSenha("123");
        usuarios.add(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNome("admin");
        usuario2.setEmail("admin@email.com");
        usuario1.setSenha("123");
        usuarios.add(usuario2);
    }
}
