import java.util.ArrayList;
import java.util.List;
import main.controller.GerenciamentoAutores;
import main.controller.GerenciamentoLivros;
import main.controller.GerenciamentoUsuarios;
import main.model.Autor;
import main.model.Livro;
import main.model.Status;
import main.model.Usuario;

public class Main {
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();

        GerenciamentoLivros gerenciamentoLivros = new GerenciamentoLivros();
        GerenciamentoUsuarios gerenciamentoUsuarios = new GerenciamentoUsuarios();
        GerenciamentoAutores gerenciamentoAutores = new GerenciamentoAutores();

        
        try {
            gerenciamentoAutores.adicionarAutor(new Autor("J.K. Rowling",
                    List.of("Harry Potter e a Pedra Filosofal", "Harry Potter e a Câmara Secreta", "123"),
                    "Escritora britânica", "5 estrelas")
            );
            gerenciamentoAutores.adicionarAutor(new Autor("Monteiro Lobato",
                    List.of("O Sítio do Picapau Amarelo", "Reinações de Narizinho"),
                    "Escritor brasileiro", "4 estrelas")
            );
            gerenciamentoAutores.adicionarAutor(new Autor("Machado de Assis",
                    List.of("Dom Casmurro", "Memórias Póstumas de Brás Cubas"),
                    "Escritor brasileiro", "5 estrelas")
            );
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        Status status = new Status();

        try {
                livros.add(new Livro("Harry Potter e a Pedra Filosofal", List.of("Fantasia"), "Fantasia", gerenciamentoAutores.getAutores().get(0), 1997, true, status));
                gerenciamentoAutores.getAutores().get(0).adicionarPublicacao("Harry Potter e a Pedra Filosofal");
            
                livros.add(new Livro("Harry Potter e a Câmara Secreta", List.of("Fantasia"), "Fantasia", gerenciamentoAutores.getAutores().get(0), 1998, true, status));
                gerenciamentoAutores.getAutores().get(0).adicionarPublicacao("Harry Potter e a Câmara Secreta");
            
                livros.add(new Livro("456", List.of("Fantasia"), "Fantasia", gerenciamentoAutores.getAutores().get(0), 2000, true, status));
                gerenciamentoAutores.getAutores().get(0).adicionarPublicacao("456");
            
                livros.add(new Livro("Caçadas de Pedrinho", List.of("Infantil"), "Infantil", gerenciamentoAutores.getAutores().get(1), 1933, true, status));
                gerenciamentoAutores.getAutores().get(1).adicionarPublicacao("Caçadas de Pedrinho");
            
                livros.add(new Livro("Dom Casmurro", List.of("Romance"), "Romance", gerenciamentoAutores.getAutores().get(2), 1899, true, status));
                gerenciamentoAutores.getAutores().get(2).adicionarPublicacao("Dom Casmurro");
            
        } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
        }
            
        for (Autor autor : gerenciamentoAutores.getAutores()){
                System.out.println("==========================================================================================");
                System.out.println("Autor: " + autor.getNome());
                System.out.println("Publicações: " + autor.getPublicacoes());
                
        }
    }
}
