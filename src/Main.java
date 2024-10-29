
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.controller.GerenciamentoAutores;
import main.controller.GerenciamentoLivros;
import main.controller.GerenciamentoUsuarios;
import main.model.Autor;
import main.model.Livro;
import main.model.Usuario;

public class Main {

    public static void main(String[] args) {
        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();

        GerenciamentoLivros gerenciamentoLivros = new GerenciamentoLivros();
        GerenciamentoUsuarios gerencimentoUsuarios = new GerenciamentoUsuarios();
        GerenciamentoAutores gerenciamentoAutores = new GerenciamentoAutores();

        Scanner scanner = new Scanner(System.in);

        autores.add(new Autor("J.K. Rowling",
                List.of("Harry Potter e a Pedra Filosofal",
                        "Harry Potter e a Câmara Secreta"),
                "Escritora britânica", "5 estrelas"));
        autores.add(new Autor("Monteiro Lobato",
                List.of("O Sítio do Picapau Amarelo",
                        "Reinações de Narizinho"),
                "Escritor brasileiro", "4 estrelas"));
        autores.add(new Autor("Machado de Assis",
                List.of("Dom Casmurro",
                        "Memórias Póstumas de Brás Cubas"),
                "Escritor brasileiro", "5 estrelas"));

        System.out.println("Autores cadastrados:");
        for (Autor autor : autores) {
            System.out.println(autor.getNome());
        }
    }
}
