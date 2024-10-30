
import java.util.ArrayList;
import java.util.List;
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
        GerenciamentoUsuarios gerenciamentoUsuarios = new GerenciamentoUsuarios();
        GerenciamentoAutores gerenciamentoAutores = new GerenciamentoAutores();

        autores.add(new Autor("J.K. Rowling",
                List.of("Harry Potter e a Pedra Filosofal",
                        "Harry Potter e a Câmara Secreta"),
                "Escritora britânica", "5 estrelas")
        );
        autores.add(new Autor("Monteiro Lobato",
                List.of("O Sítio do Picapau Amarelo",
                        "Reinações de Narizinho"),
                "Escritor brasileiro", "4 estrelas")
        );
        autores.add(new Autor("Machado de Assis",
                List.of("Dom Casmurro",
                        "Memórias Póstumas de Brás Cubas"),
                "Escritor brasileiro", "5 estrelas")
        );

        livros.add(new Livro("Harry Potter e a Pedra Filosofal", List.of("Fantasia", "Aventura"), "Harry Potter e a Pedra Filosofal é o primeiro livro da série Harry Potter de J.K. Rowling.", autor, 40, true, new Status()));

        //livros.add(new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia", 1997));
        //livros.add(new Livro("Harry Potter e a Câmara Secreta", "J.K. Rowling", "Fantasia", 1998));
        //livros.add(new Livro("Harry Potter e o Prisioneiro de Azkaban", "J.K. Rowling", "Fantasia", 1999));

        //livros.add(new Livro("O Sítio do Picapau Amarelo", "Monteiro Lobato", "Infantil", 1920));
        //livros.add(new Livro("Reinações de Narizinho", "Monteiro Lobato", "Infantil", 1931));
        //livros.add(new Livro("Caçadas de Pedrinho", "Monteiro Lobato", "Infantil", 1933));

        //livros.add(new Livro("Dom Casmurro", "Machado de Assis", "Romance", 1899));
        //livros.add(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", "Romance", 1881));
        //livros.add(new Livro("Quincas Borba", "Machado de Assis", "Romance", 1891));

        System.out.println("Autores cadastrados:");
        for (Autor autor : autores) {
                System.out.println("Nome: " + autor.getNome());
                System.out.println("Livros: " + String.join(", ", autor.getLivros()));
                System.out.println();
        }
    }
}
