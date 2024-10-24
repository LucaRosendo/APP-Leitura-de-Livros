
import java.util.ArrayList;
import java.util.Scanner;

import main.controller.GerenciamentoLivros;
import main.controller.GerencimentoUsuarios;
import main.model.Livro;
import main.model.Usuario;

public class Main {

    static ArrayList<Livro> biblioteca = new ArrayList<Livro>();

    static void carregaLivros() {
        biblioteca.add(null);
    }

    public static void main(String[] args) throws Exception {
        carregaLivros();

        Usuario user = new Usuario(null, null, 0);
        user.setBiblioteca(biblioteca);

    }
}
