import domain.Simulacao;
import domain.entities.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static List<Usuario> usuarios = new ArrayList<>();
    public static Boolean login = false;

    public static void main(String[] args) {
        Simulacao simulacao = new Simulacao();
        simulacao.run();
    }
}
