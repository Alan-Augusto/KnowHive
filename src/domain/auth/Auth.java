package domain.auth;

import domain.entities.Usuario;
import domain.errors.CredenciaisInvalidasException;
import domain.errors.DataNascimentoInvalidaException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Auth {
    private List<Usuario> usuarios;

    private final int LOGIN = 1;
    private final int CADASTRAR = 2;

    public Auth(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario processar(int opcao) {
        if (opcao == LOGIN)
            return fazerLogin();

        return fazerCadastro();
    }

    private Usuario fazerLogin() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();

            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            try {
                Usuario usuarioEncontrado = procurarUsuario(email, senha);

                System.out.println("Login bem-sucedido para o usuario: " + usuarioEncontrado.getNome());
                scanner.close();
                return usuarioEncontrado;
            } catch (CredenciaisInvalidasException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private Usuario procurarUsuario(String email, String senha) throws RuntimeException {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }

        throw new CredenciaisInvalidasException();
    }

    private Usuario fazerCadastro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        // Requisita ao usuario uma data de nascimento valida
        Date dataNascimento = promptDataNascimento(scanner);

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, email, senha, dataNascimento);
        usuarios.add(novoUsuario);

        System.out.println("Cadastrado concluido com sucesso!");

        scanner.close();
        return novoUsuario;
    }

    private Date promptDataNascimento(Scanner scanner) {
        do {
            System.out.print("Digite sua data de nascimento (DD/MM/YYYY): ");
            String dataString = scanner.nextLine();

            try {
                Date dataNascimento = processarData(dataString);
                return dataNascimento;
            } catch (DataNascimentoInvalidaException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private Date processarData(String dataString) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);

        try {
            Date data = formato.parse(dataString);
            return data;
        } catch (ParseException e) {
            throw new DataNascimentoInvalidaException();
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
