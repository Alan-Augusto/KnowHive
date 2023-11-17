package domain.auth;

import domain.entities.Usuario;
import domain.errors.DataNascimentoInvalidaException;
import domain.errors.UsuarioNaoEncontradoException;
import domain.repositories.UsuarioRepositorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Auth {
    private UsuarioRepositorio usuarioRepositorio;
    private Scanner scanner;

    private final int LOGIN = 1;
    private final int CADASTRAR = 2;

    public Auth(UsuarioRepositorio repositorio, Scanner scanner) {
        this.usuarioRepositorio = repositorio;
        this.scanner = scanner;
    }

    public Usuario processar(int opcao) {
        if (opcao == LOGIN)
            return fazerLogin();

        return fazerCadastro();
    }

    private Usuario fazerLogin() {
        do {
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();

            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            try {
                Usuario usuarioEncontrado = procurarUsuario(email, senha);

                System.out.println("Login bem-sucedido para o usuario: " + usuarioEncontrado.getNome());
                return usuarioEncontrado;
            } catch (UsuarioNaoEncontradoException e) {
                System.out.println("Email ou senha invalidos!");
            }
        } while (true);
    }

    private Usuario procurarUsuario(String email, String senha) throws RuntimeException {
        try {
            Usuario usuarioEncontrado = this.usuarioRepositorio.retornaPorEmailESenha(email, senha);
            return usuarioEncontrado;
        } catch (UsuarioNaoEncontradoException e) {
            throw e;
        }
    }

    private Usuario fazerCadastro() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        // Requisita ao usuario uma data de nascimento valida
        Date dataNascimento = promptDataNascimento();

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, email, senha, dataNascimento);
        this.usuarioRepositorio.salvar(novoUsuario);

        System.out.println("Cadastrado concluido com sucesso!");

        return novoUsuario;
    }

    private Date promptDataNascimento() {
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
}
